 use AirdeJava;

-- METTRE EN PLACE LA BASE DE DONNÉES
-- 1. Donner la séquence en SQL pour créer un compte utilisateur avec des droits de consultations (lecture et écriture) de la base de données mais sans les droits d’administrations de la base de données.

CREATE USER 'veronique'@'localhost' IDENTIFIED BY 'motdepasse123';                     -- Création du compte utilisateur
GRANT SELECT, INSERT, UPDATE, DELETE ON AirdeJava.* TO 'veronique'@'localhost';        -- Attribution des droits de lecture et écriture sur une base donnée (ex: "AirdeJava")
FLUSH PRIVILEGES;                                                                      -- Actualiser les privilèges (facultatif selon le SGBD)


SELECT User, Host FROM mysql.user;
SHOW GRANTS FOR 'veronique'@'localhost';


-- 2. Après réflexion, dans la base de données, je ne souhaite pas que le compte utilisateur ait accès aux tables suivantes Profil, Acces, Memu et Login en écriture. Donner le code SQL pour retirer ces droits.

REVOKE ALL PRIVILEGES ON AirdeJava.* FROM 'veronique'@'localhost';                       -- Retire tous les droits actuels sur la base

GRANT SELECT ON AirdeJava.* TO 'veronique'@'localhost';

GRANT INSERT, UPDATE, DELETE ON AirdeJava.auteur TO 'veronique'@'localhost';              -- Donner INSERT, UPDATE, DELETE sur toutes les tables SAUF les 4 sensibles
GRANT INSERT, UPDATE, DELETE ON AirdeJava.chanson TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.civilite TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.groupe TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.groupe_supprime TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.instrument TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.jouer TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.membre TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.necessiter TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.occuper TO 'veronique'@'localhost'; 
GRANT INSERT, UPDATE, DELETE ON AirdeJava.passage TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.pays TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.periodicite TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.personne TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.region TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.rencontre TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.repertoire TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.representation TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.representer TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.responsabilite TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.specialiser TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.specialite TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.typeoeuvre TO 'veronique'@'localhost';
GRANT INSERT, UPDATE, DELETE ON AirdeJava.typeoeuvre_supprime TO 'veronique'@'localhost';
         
SHOW GRANTS FOR 'veronique'@'localhost';         -- (Facultatif) Vérifier les privilèges actuels de l’utilisateur



-- Décrivez les procédures que vous mettez en place pour assurer les sauvegardes de la base.
/*
1️/ Sauvegarde de la base:
Ouvrir MySQL Workbench
Double-clique sur MySQL Workbench et connecte-toi à ton serveur MySQL avec ton utilisateur (ex : root) et mot de passe.

Accéder à l’outil d’export:
Dans le menu en haut :
Server → Data Export

Sélectionner la base à sauvegarder:
Dans la colonne de gauche, coche la case AirdeJava.
Si tu veux toutes les tables, clique sur Select All Tables.

Choisir le type de fichier de sauvegarde:
Dans “Export Options”, choisis Export to Self-Contained File.
Clique sur … pour sélectionner le dossier où tu veux sauvegarder la base → par exemple Bureau.
Nom du fichier : air2java.sql.

Lancer la sauvegarde:
Clique sur Start Export.
Le processus commence et quelques secondes plus tard, le fichier air2java.sql apparaît sur ton Bureau.

Vérification:
Ouvre le Bureau → tu dois voir le fichier air2java.sql.
Tu peux l’ouvrir avec Notepad ou VS Code pour vérifier qu’il contient des lignes SQL (CREATE TABLE, INSERT INTO).

2️/ Restauration de la base
Ouvrir l’outil d’import:
Dans MySQL Workbench, menu :
Server → Data Import

Sélectionner le fichier de sauvegarde:
Coche Import from Self-Contained File.
Clique sur … et choisis le fichier air2java.sql sur ton Bureau.

Choisir la base de destination:
Dans Default Target Schema :
Sélectionne la base AirdeJava si elle existe.
Sinon, coche Create New Schema et nomme-la AirdeJava.

Lancer l’import:
Clique sur Start Import.
MySQL Workbench lit le fichier SQL et recrée toutes les tables et données dans la base.

Vérification:
Dans Workbench, ouvre la base AirdeJava → clique sur Tables.
Toutes les tables et données doivent apparaître exactement comme dans la sauvegarde. */



-- PROGRAMMER DANS LE LANGAGE DU SGBD
-- i. Interrogation des groupes jouant un titre donné.
-- • Par exemple pour le titre « Detachable penis »

select g.gro_nom 
from groupe g
inner join repertoire r on r.gro_id = g.gro_id
inner join chanson c on c.cha_id = r.cha_id
where c.cha_titre = 'Detachable penis';

-- ii. Interrogation des rencontres où un titre a été interprété et par qui.
-- • Par exemple pour le titre « The End »
select r.ren_nom as rencontre, g.gro_nom as groupe
from rencontre r
inner join passage p on p.ren_id = r.ren_id
inner join groupe g on g.gro_id = p.gro_id
inner join repertoire rp on rp.gro_id = g.gro_id
inner join chanson c on c.cha_id = rp.cha_id
where c.cha_titre = 'The End';

-- iii. Interrogation des membres ayant une spécialité donnée pour une rencontre donnée.
-- • Par exemple pour le festival « CAP FESTIVAL » et la spécialité « Soliste »
select per.per_nom as nom, per.per_prenom as prenom
from personne per
inner join specialiser on specialiser.per_id = per.per_id
inner join specialite sp on sp.spe_id = specialiser.spe_id
inner join rencontre r on r.ren_id = specialiser.ren_id
where r.ren_nom = 'CAP FESTIVAL' and sp.spe_nom = 'Soliste';

-- iv. Interrogation des titres de plus de x minutes pour un pays ou une région donnée.
-- • Par exemple pour la région « Bavière » et le pays « Royaume-Uni »
select distinct c.cha_titre, c.cha_tps 
from chanson c
inner join repertoire rp on rp.cha_id = c.cha_id
inner join groupe g on g.gro_id = rp.gro_id
inner join representer rpst on rpst.gro_id = g.gro_id
inner join region reg on reg.reg_id = rpst.reg_id
inner join pays pay on pay.pay_id = reg.pay_id
where c.cha_tps > '00:04:00' and reg.reg_nom = 'Bavière' or pay.pay_nom = 'Royaume-Uni';

-- v. Interrogation des rencontres ayant eu n groupes participants.
-- • Test avec 1, 2, 3

select  r.ren_nom as rencontre
from rencontre r
inner join passage p on p.ren_id = r.ren_id
inner join groupe g on g.gro_id = p.gro_id
group by r.ren_nom
having count(distinct g.gro_id) = 3;

select  r.ren_nom as rencontre
from rencontre r
inner join passage p on p.ren_id = r.ren_id
inner join groupe g on g.gro_id = p.gro_id
group by r.ren_nom
having count(distinct g.gro_id) = 2;

select  r.ren_nom as rencontre
from rencontre r
inner join passage p on p.ren_id = r.ren_id
inner join groupe g on g.gro_id = p.gro_id
group by r.ren_nom
having count(distinct g.gro_id) = 1;

-- vi. Interrogation des rencontres où on a joué d'un instrument donné
select  r.ren_nom as rencontre
from rencontre r
inner join personne per on per.per_id = r.per_id
inner join jouer j on j.per_id = per.per_id
inner join instrument i on i.ins_id = j.ins_id
where i.ins_nom = 'Guitare';

-- vii. Planning complet de la rencontre par lieu et groupe.
  select pas.pas_lieu, g.gro_nom, pas.pas_date, pas.pas_heuredeb, pas.pas_heurefin
  from passage pas
  inner join groupe g on g.gro_id = pas.gro_id ;
  
  
-- Créez une fonction permettant de contrôler qu’une date de rencontre est bien
-- un vendredi soir, un samedi ou un dimanche en matinée. Exception : du 15
-- juin au 15 septembre, les rencontres peuvent se dérouler n’importe quel jour.

DELIMITER |
DROP FUNCTION IF EXISTS controle_rencontre;
CREATE FUNCTION controle_rencontre (NomRencontre CHAR(20))
RETURNS VARCHAR(8) DETERMINISTIC
BEGIN
    IF (
        SELECT COUNT(*)
        FROM passage P
        JOIN rencontre R ON R.REN_ID = P.REN_ID
        WHERE R.REN_NOM LIKE NomRencontre
          -- En dehors de la période autorisée (15 juin au 15 septembre)
          AND NOT (
                MONTH(P.PAS_DATE) IN (7,8)
                OR (MONTH(P.PAS_DATE) = 6 AND DAY(P.PAS_DATE) >= 15)
                OR (MONTH(P.PAS_DATE) = 9 AND DAY(P.PAS_DATE) <= 15)
          )
          -- Et la date/heure n’est pas un vendredi soir, samedi ou dimanche matin
          AND NOT (
                (DAYOFWEEK(P.PAS_DATE) = 6 AND P.PAS_HEUREDEB >= '19:00:00')
                OR (DAYOFWEEK(P.PAS_DATE) = 7)
                OR (DAYOFWEEK(P.PAS_DATE) = 1 AND P.PAS_HEUREDEB <= '10:00:00')
          )
    ) > 0 THEN
        RETURN 'Pas Bien';
    ELSE
        RETURN 'Bien';
    END IF;
END |
DELIMITER ;

SELECT controle_rencontre('CANAL SOLEIL');
SELECT controle_rencontre('REGGAE FESTIVALES');


-- Mettez en place les triggers liées à la suppression d’un groupe et à la suppression d’une oeuvre.

-- SUPPRESION GROUPE:
DROP TRIGGER IF EXISTS sauvegarde_suppression_groupe;

CREATE TRIGGER sauvegarde_groupes_supprimes
AFTER DELETE ON groupe
FOR EACH ROW
INSERT INTO GROUPE_SUPPRIME (GRO_ID, PER_ID, GRO_NOM, DATE_SUPPRESSION)
VALUES (OLD.GRO_ID, OLD.PER_ID, OLD.GRO_NOM, CURDATE());


DELETE FROM representation WHERE PAS_ID IN (
    SELECT PAS_ID FROM passage WHERE GRO_ID = 30
);
DELETE FROM passage WHERE GRO_ID = 30;
DELETE FROM membre WHERE GRO_ID = 30;
DELETE FROM occuper WHERE GRO_ID = 30;
DELETE FROM repertoire WHERE GRO_ID = 30;
DELETE FROM groupe WHERE GRO_ID = 30;


SELECT * FROM groupe WHERE GRO_ID = 30;
SELECT * FROM GROUPE_SUPPRIME WHERE GRO_ID = 30;


-- SUPPRESION OEUVRE:
CREATE TRIGGER sauvegarde_oeuvres_supprimes
AFTER DELETE ON TYPEOEUVRE  
FOR EACH ROW
INSERT INTO TYPEOEUVRE_SUPPRIME (TYPO_ID, TYPO_NOM, DATE_SUPPRESSION)
VALUES (OLD.TYPO_ID, OLD.TYPO_NOM, CURDATE());

DELETE FROM auteur WHERE cha_id IN (
    SELECT cha_id FROM chanson WHERE TYPO_ID = 9
);
DELETE FROM representation WHERE cha_id IN (
    SELECT cha_id FROM chanson WHERE TYPO_ID = 9
);
DELETE FROM repertoire WHERE cha_id IN (
    SELECT cha_id FROM chanson WHERE TYPO_ID = 9
);
DELETE FROM chanson WHERE TYPO_ID = 9;
DELETE FROM TYPEOEUVRE WHERE TYPO_ID = 9;

SELECT * FROM TYPEOEUVRE WHERE TYPO_ID = 9;
SELECT * FROM TYPEOEUVRE_SUPPRIME WHERE TYPO_ID = 9;


-- Créez une procédure stockée qui sélectionne les groupes qui ne participent pas à une rencontre donnée, puis une autre qui renvoie le dernier numéro de rencontre insérée.

delimiter $
create procedure groupe_no_participation (IN p_ren_id int)
BEGIN
    SELECT g.gro_nom as groupe
    FROM groupe g
    WHERE g.gro_id not in(
		select gro_id
		from passage
		where ren_id = p_ren_id
    );
END $
delimiter ;


select * from groupe;
CALL groupe_no_participation(1);



delimiter $
create procedure derniere_rencontre (OUT p_ren_id int)
BEGIN
    SELECT max(ren_ID) INTO p_ren_id
    FROM rencontre ;
END $
delimiter ;

CALL derniere_rencontre(@resultat);
select @resultat;

-- Créez un objet du SGDB qui permet de générer sept rencontres ayant les mêmes caractéristiques sauf le jour de la rencontre qui varie d’une journée à chaque fois.
-- • Vous devez vous assurer que la date de rencontre est correcte sinon aucune des rencontres ne doit être insérée (transaction) – réutiliser la fonction crée précédemment.

DELIMITER $$
CREATE FUNCTION VerifierDate(dateAVerifier DATETIME)
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
    -- Vérifier que la date n'est pas NULL et qu'elle est dans le futur
    IF dateAVerifier IS NULL OR dateAVerifier < NOW() THEN
        RETURN FALSE;
    END IF;
    RETURN TRUE;
END$$
DELIMITER ; 

DELIMITER $$

CREATE PROCEDURE CreerSeptRencontres(
    IN pPERI_ID INT,
    IN pPER_ID INT,
    IN pREG_ID INT,
    IN pREN_NOM CHAR(20),
    IN pREN_LIEU CHAR(20),
    IN pREN_DATEDEBUT DATETIME,
    IN pREN_DATEFIN DATETIME,
    IN pREN_NBPERS INT
)
BEGIN
    DECLARE i INT DEFAULT 0;
    DECLARE currentDateDebut DATETIME;
    DECLARE currentDateFin DATETIME;
     DECLARE dateValide BOOLEAN DEFAULT TRUE;

    START TRANSACTION;
    -- Boucle pour créer les 7 rencontres
   boucle_rencontres: WHILE i < 7 DO
        SET currentDateDebut = DATE_ADD(pREN_DATEDEBUT, INTERVAL i DAY);
        SET currentDateFin = DATE_ADD(pREN_DATEFIN, INTERVAL i DAY);

        -- Vérification de la date
        SET dateValide = VerifierDate(currentDateDebut) AND VerifierDate(currentDateFin);
        
        IF NOT dateValide THEN
            ROLLBACK;
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Date invalide détectée';
        END IF;

        INSERT INTO RENCONTRE (PERI_ID, PER_ID, REG_ID, REN_NOM, REN_LIEU, REN_DATEDEBUT, REN_DATEFIN, REN_NBPERS)
        VALUES (pPERI_ID, pPER_ID, pREG_ID, pREN_NOM, pREN_LIEU, currentDateDebut, currentDateFin, pREN_NBPERS);

        SET i = i + 1;
    END WHILE boucle_rencontres;

    COMMIT;
END$$
DELIMITER ;

CALL CreerSeptRencontres(1,2,3,'Match Amical', 'Stade Municipal', '2025-10-25 15:00:00',  '2025-10-25 17:00:00', 20 );
SHOW FUNCTION STATUS WHERE Db = 'AirdeJava';

SELECT * FROM RENCONTRE 
WHERE REN_NOM = 'Match Amical' 
ORDER BY REN_DATEDEBUT;  