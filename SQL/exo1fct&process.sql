USE SII

-- 1- Écrire une procédure qui prend comme arguments un identifiant d’employé et un nombre, puis mettre à jour le salaire de l’employé donné avec le nombre donné.

delimiter $

create procedure employe_modif_salaire (IN p_emp_id int, in p_nouveau_salaire int)
begin
update employe
set emp_salaire = p_nouveau_salaire
where emp_id = p_emp_id ;
end $

delimiter ;
select * from employe;
CALL employe_modif_salaire(5, 3500);
 
-- 2- Écrire une fonction qui compte le nombre d’employés participant à un projet donné.
DELIMITER $$

CREATE FUNCTION nb_employes_projet (
    p_projet_id INT
)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE nb_employes INT;

    SELECT COUNT(DISTINCT EMP_ID)
    INTO nb_employes
    FROM TRAVAIL
    WHERE PRO_ID = p_projet_id;

    RETURN nb_employes;
END $$

DELIMITER ;

SELECT nb_employes_projet(1);

-- 3- Écrire une fonction qui compte le nombre de projets supervisés par les employés d’un service donné.
DELIMITER $

CREATE FUNCTION nb_projets_service_v2 (
    p_service_id INT
)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE nb_projets INT;

    SELECT COUNT(DISTINCT p.PRO_ID)
    INTO nb_projets
    FROM projet p
    join employe e on p.pro_resp = e.emp_id
    WHERE e.emp_serv = p_service_id;

    RETURN nb_projets;
END $

DELIMITER ;

SELECT nb_projets_service_v2(2);

-- 4- Écrire une fonction qui compte le nombre de projets auxquels participe l’employé donné.
DELIMITER $

CREATE FUNCTION nb_projets_employe_v4 (
    p_employe_id INT
)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE nb_pro INT;

    SELECT COUNT(DISTINCT PRO_ID)
    INTO nb_pro
    FROM travail
    WHERE EMP_ID = p_employe_id;

    RETURN nb_pro;
END $
DELIMITER ;
SELECT nb_projets_employe_v4 (4);

-- 5- Écrire une fonction qui renvoie la chaîne ‘Salaire faible’ si le salaire de l’employé donné est supérieur à 2000$ sinon retourner ‘Bon salaire‘.
DELIMITER $
CREATE FUNCTION  verifier_salaire_employe (
    p_employe_id INT
)
RETURNS VARCHAR(20)
not DETERMINISTIC
reads sql data
BEGIN
	DECLARE salaire_emp INT;
    DECLARE resultat VARCHAR(20);

    -- On récupère le salaire de l'employé
    SELECT EMP_SALAIRE
    INTO salaire_emp
    FROM EMPLOYE
    WHERE EMP_ID = p_employe_id;

    -- On vérifie le salaire
    IF salaire_emp < 2000 THEN
        SET resultat = 'Salaire faible';
    ELSE
        SET resultat = 'Bon salaire';
    END IF;
    RETURN resultat;
END $
DELIMITER ;
SELECT verifier_salaire_employe (19);


-- 6- Écrire une fonction, qui compte le nombre d’employés qui prennent en charge plus que le nombre de projets donné.
DELIMITER $

CREATE FUNCTION nb_employes_plus_projets (
    p_nb_projets INT
)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE nb_employes INT;

    -- On compte combien d'employés ont plus de projets que le nombre donné
    SELECT COUNT(*) 
    INTO nb_employes
    FROM (
        SELECT EMP_ID, COUNT(DISTINCT PRO_ID) AS nb_projets
        FROM TRAVAIL
        GROUP BY EMP_ID
        HAVING nb_projets > p_nb_projets
    ) AS sous_table;

    RETURN nb_employes;
END $

DELIMITER ;

-- Test : combien d'employés ont plus de 3 projets ?
SELECT nb_employes_plus_projets(3);

-- 7- Écrire une procédure qui insère l’employé donné dans une table de sauvegarde nommée ‘ALERT_EMPLOYE‘.

CREATE TABLE IF NOT EXISTS ALERT_EMPLOYE 
SELECT * FROM EMPLOYE WHERE 1 = 0;

DELIMITER $

CREATE PROCEDURE inserer_employe_sauvegarde2 (
    IN p_employe_id INT
)
BEGIN
    INSERT INTO ALERT_EMPLOYE
    SELECT *
    FROM EMPLOYE
    WHERE EMP_ID = p_employe_id;
END $

DELIMITER ;

CALL inserer_employe_sauvegarde2(4);