use banqueTrigger;

-- 1- Créer un trigger interceptant toutes les données supprimées pour les mettre dans une table “poubelle” afin d’éviter les suppressions accidentelles.

-- Création de la table POUBELLE (si elle n'existe pas déjà)

DELIMITER //

-- Trigger sur CLIENTS
CREATE TRIGGER trg_clients_before_delete
BEFORE DELETE ON CLIENTS
FOR EACH ROW
BEGIN
    INSERT INTO POUBELLE (NOM_TABLE, DONNEES_SUPPRIMEES, DATE_SUPPRESSION)
    VALUES (
        'CLIENTS',
        CONCAT(
            'CLI_ID=', OLD.CLI_ID, ', ',
            'CLI_NOM=', OLD.CLI_NOM, ', ',
            'CLI_PRENOM=', OLD.CLI_PRENOM, ', ',
            'CLI_SEXE=', OLD.CLI_SEXE, ', ',
            'CLI_VILLE=', OLD.CLI_VILLE, ', ',
            'CLI_DATE_CREATION=', OLD.CLI_DATE_CREATION, ', ',
            'CLI_DATE_MAJ=', OLD.CLI_DATE_MAJ
        ),
        NOW()
    );
END;
//

-- Trigger sur COMPTES
CREATE TRIGGER trg_comptes_before_delete
BEFORE DELETE ON COMPTES
FOR EACH ROW
BEGIN
    INSERT INTO POUBELLE (NOM_TABLE, DONNEES_SUPPRIMEES, DATE_SUPPRESSION)
    VALUES (
        'COMPTES',
        CONCAT(
            'COM_ID=', OLD.COM_ID, ', ',
            'COM_SOLDE=', OLD.COM_SOLDE, ', ',
            'CLI_ID=', OLD.CLI_ID, ', ',
            'AGE_ID=', OLD.AGE_ID, ', ',
            'COM_DATE_CREATION=', OLD.COM_DATE_CREATION, ', ',
            'COM_DATE_MAJ=', OLD.COM_DATE_MAJ
        ),
        NOW()
    );
END;
//

-- Trigger sur EMPRUNTS
CREATE TRIGGER trg_emprunts_before_delete
BEFORE DELETE ON EMPRUNTS
FOR EACH ROW
BEGIN
    INSERT INTO POUBELLE (NOM_TABLE, DONNEES_SUPPRIMEES, DATE_SUPPRESSION)
    VALUES (
        'EMPRUNTS',
        CONCAT(
            'EMP_ID=', OLD.EMP_ID, ', ',
            'EMP_MONTANT=', OLD.EMP_MONTANT, ', ',
            'CLI_ID=', OLD.CLI_ID, ', ',
            'AGE_ID=', OLD.AGE_ID, ', ',
            'EMP_DATE_CREATION=', OLD.EMP_DATE_CREATION, ', ',
            'EMP_DATE_MAJ=', OLD.EMP_DATE_MAJ
        ),
        NOW()
    );
END;
//

-- Trigger sur AGENCES
CREATE TRIGGER trg_agences_before_delete
BEFORE DELETE ON AGENCES
FOR EACH ROW
BEGIN
    INSERT INTO POUBELLE (NOM_TABLE, DONNEES_SUPPRIMEES, DATE_SUPPRESSION)
    VALUES (
        'AGENCES',
        CONCAT(
            'AGE_ID=', OLD.AGE_ID, ', ',
            'AGE_NOM=', OLD.AGE_NOM, ', ',
            'AGE_VILLE=', OLD.AGE_VILLE, ', ',
            'AGE_ACTIF=', OLD.AGE_ACTIF, ', ',
            'AGE_TAUX_ACTIF=', OLD.AGE_TAUX_ACTIF, ', ',
            'AGE_DATE_CREATION=', OLD.AGE_DATE_CREATION, ', ',
            'AGE_DATE_MAJ=', OLD.AGE_DATE_MAJ
        ),
        NOW()
    );
END;
//

DELIMITER ;


DELETE FROM COMPTES WHERE CLI_ID = 3;
DELETE FROM EMPRUNTS WHERE CLI_ID = 3;
DELETE FROM CLIENTS WHERE CLI_ID = 3;

SELECT * FROM POUBELLE;



-- 2- Créer la table “emprunts_supprimees” Affecter à la table emprunts le trigger nommé “emprunts_supprimees_trigger“
DELIMITER //

CREATE TRIGGER emprunts_supprimees_trigger
BEFORE DELETE ON EMPRUNTS
FOR EACH ROW
BEGIN
    INSERT INTO emprunts_supprimees
    (EMP_ID, EMP_MONTANT, EMP_DATE_CREATION, EMP_DATE_MAJ, CLI_ID, AGE_ID, DATE_SUPPRESSION)
    VALUES
    (OLD.EMP_ID, OLD.EMP_MONTANT, OLD.EMP_DATE_CREATION, OLD.EMP_DATE_MAJ, OLD.CLI_ID, OLD.AGE_ID, NOW());
END;
//

DELIMITER ;
DELETE FROM EMPRUNTS WHERE EMP_ID = 1;
SELECT * FROM emprunts_supprimees;

-- 2.1- Utiliser l’événement DELETE


-- 2.2- Le trigger sera invoqué après l’instruction DELETE
DELIMITER //

CREATE TRIGGER emprunts_supprimees_trigger_after
AFTER DELETE ON EMPRUNTS
FOR EACH ROW
BEGIN
    INSERT INTO emprunts_supprimees
    (EMP_ID, EMP_MONTANT, EMP_DATE_CREATION, EMP_DATE_MAJ, CLI_ID, AGE_ID, DATE_SUPPRESSION)
    VALUES
    (OLD.EMP_ID, OLD.EMP_MONTANT, OLD.EMP_DATE_CREATION, OLD.EMP_DATE_MAJ, OLD.CLI_ID, OLD.AGE_ID, NOW());
END;
//

DELIMITER ;
DELETE FROM EMPRUNTS WHERE EMP_ID = 2;
SELECT * FROM emprunts_supprimees;


-- 1- Créer un trigger permettant de compter le nombre de requêtes d’ajout, de mise à jour et de suppression effectués par jour sur la table Agences
-- - Créer la table “audit_comptes“ qui va permettre de converser les différentes actions réalisées sur la date emprunts. Dans cette table, par exemple, on peut conserver la date de l’action et le type d’action.
DELIMITER //

-- 2️⃣ Triggers pour INSERT, UPDATE, DELETE sur AGENCES

CREATE TRIGGER trg_agences_insert
AFTER INSERT ON AGENCES
FOR EACH ROW
BEGIN
    INSERT INTO audit_comptes (DATE_ACTION, TYPE_ACTION, NOMBRE_ACTIONS)
    VALUES (CURDATE(), 'INSERT', 1);
END;
//

CREATE TRIGGER trg_agences_update
AFTER UPDATE ON AGENCES
FOR EACH ROW
BEGIN
    INSERT INTO audit_comptes (DATE_ACTION, TYPE_ACTION, NOMBRE_ACTIONS)
    VALUES (CURDATE(), 'UPDATE', 1);
END;
//

CREATE TRIGGER trg_agences_delete
AFTER DELETE ON AGENCES
FOR EACH ROW
BEGIN
    INSERT INTO audit_comptes (DATE_ACTION, TYPE_ACTION, NOMBRE_ACTIONS)
    VALUES (CURDATE(), 'DELETE', 1);
END;
//

DELIMITER ;

-- 3️⃣ Test des triggers


-- Test UPDATE
UPDATE AGENCES
SET AGE_TAUX_ACTIF = 10
WHERE AGE_ID = 1;

-- Test DELETE
DELETE FROM EMPRUNTS WHERE AGE_ID = 1;
DELETE FROM COMPTES WHERE AGE_ID = 1;
DELETE FROM AGENCES WHERE AGE_ID = 1;

-- 4️⃣ Vérifier la table audit_comptes
SELECT * FROM audit_comptes; 

-- 5️⃣ Vérifier le total par type et par jour
SELECT DATE_ACTION, TYPE_ACTION, SUM(NOMBRE_ACTIONS) AS total_actions
FROM audit_comptes
GROUP BY DATE_ACTION, TYPE_ACTION
ORDER BY DATE_ACTION, TYPE_ACTION;

-- 2- Affecter à la table “emprunts” les triggers suivant en utilisant la table audit_comptes précédemment crée :
-- 2.1- comptes_inserees_trigger” (Evèn. : INSERT, PE : AFTER)

-- 2.2- comptes_supprimees_trigger” (Evén. : DELETE, PE : AFTER)

-- 2.3- comptes_modifiees_trigger” (Evén. : UPDATE, PE : AFTER)
