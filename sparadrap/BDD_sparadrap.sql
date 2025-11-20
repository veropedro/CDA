DROP DATABASE IF EXISTS sparadrap;
CREATE DATABASE sparadrap;
use sparadrap;

drop table if exists Resider;

drop table if exists Contacter;

drop table if exists Avoir;

drop table if exists Situer;

drop table if exists Relier;

drop table if exists Constituer;

drop table if exists Lier;

drop table if exists ACHAT;

drop table if exists ORDONNANCE;

drop table if exists MEDICAMENT;

drop table if exists CLIENT;

drop table if exists MEDECIN;

drop table if exists PERSONNE;

drop table if exists COORDONNEES;

drop table if exists ADRESSE;

-- =============================
-- Création des tables de base
-- =============================

CREATE TABLE ADRESSE (
   idAdresse INT AUTO_INCREMENT,
   ad_numero INT NOT NULL,
   ad_rue VARCHAR(50) NOT NULL,
   ad_codePostal INT NOT NULL,
   ad_ville VARCHAR(50) NOT NULL,
   PRIMARY KEY(idAdresse)
);

CREATE TABLE COORDONNEES (
   idCoordonnees INT AUTO_INCREMENT,
   coo_telephone VARCHAR(20) NOT NULL,
   coo_email VARCHAR(50) NOT NULL,
   PRIMARY KEY(idCoordonnees)
);

CREATE TABLE Personne (
   idPersonne INT AUTO_INCREMENT,
   pers_nom VARCHAR(50) NOT NULL,
   pers_prenom VARCHAR(50) NOT NULL,
   pers_civilite VARCHAR(10),
   PRIMARY KEY(idPersonne)
);

-- =============================
-- Tables héritées de Personne
-- =============================

CREATE TABLE MEDECIN (
   idMedecin INT AUTO_INCREMENT,
   med_numeroAgreement VARCHAR(50) NOT NULL,
   idPersonne INT NOT NULL,
   PRIMARY KEY(idMedecin),
   FOREIGN KEY(idPersonne) REFERENCES Personne(idPersonne)
);

CREATE TABLE CLIENT (
   idClient INT AUTO_INCREMENT,
   cli_numeroSecu VARCHAR(15) NOT NULL,
   cli_dateNaissance DATE NOT NULL,
   idPersonne INT NOT NULL,
   idMedecin INT,         -- médecin traitant
   idMutuelle INT,        -- mutuelle du client
   PRIMARY KEY(idClient),
   FOREIGN KEY(idPersonne) REFERENCES Personne(idPersonne),
   FOREIGN KEY(idMedecin) REFERENCES MEDECIN(idMedecin)
);

-- =============================
-- Table Mutuelle
-- =============================

CREATE TABLE MUTUELLE (
   idMutuelle INT AUTO_INCREMENT,
   mut_nom VARCHAR(50) NOT NULL,
   mut_tauxPriseChargeMedoc DECIMAL(5,2) NOT NULL,
   PRIMARY KEY(idMutuelle)
);

-- On met à jour la contrainte entre CLIENT et MUTUELLE
ALTER TABLE CLIENT
ADD FOREIGN KEY(idMutuelle) REFERENCES MUTUELLE(idMutuelle);

-- =============================
-- Médicament et Ordonnance
-- =============================

CREATE TABLE MEDICAMENT (
   idMedicament INT AUTO_INCREMENT,
   medoc_nom VARCHAR(50) NOT NULL,
   medoc_categorie VARCHAR(50) NOT NULL,
   medoc_prix DECIMAL(8,2) NOT NULL,
   medoc_dateMiseService DATE,
   medoc_quantite INT NOT NULL DEFAULT 0,
   PRIMARY KEY(idMedicament)
);


CREATE TABLE ORDONNANCE (
   idOrdonnance INT AUTO_INCREMENT,
   ord_date DATE NOT NULL,
   idMedecin INT NOT NULL,
   idClient INT NOT NULL,
   PRIMARY KEY(idOrdonnance),
   FOREIGN KEY(idMedecin) REFERENCES MEDECIN(idMedecin),
   FOREIGN KEY(idClient) REFERENCES CLIENT(idClient)
);

-- =============================
-- Achats
-- =============================

CREATE TABLE ACHAT (
   idAchat INT AUTO_INCREMENT,
   parOrdonnance BOOLEAN NOT NULL,
   dateAchat DATE NOT NULL,
   idClient INT NOT NULL,
   PRIMARY KEY(idAchat),
   FOREIGN KEY(idClient) REFERENCES CLIENT(idClient)
);

-- =============================
-- Associations intermédiaires
-- =============================

-- Une ordonnance contient plusieurs médicaments
CREATE TABLE Lier (
   idOrdonnance INT,
   idMedicament INT,
   quantite INT NOT NULL,
   PRIMARY KEY(idOrdonnance, idMedicament),
   FOREIGN KEY(idOrdonnance) REFERENCES ORDONNANCE(idOrdonnance),
   FOREIGN KEY(idMedicament) REFERENCES MEDICAMENT(idMedicament)
);

-- Un achat contient plusieurs médicaments
CREATE TABLE Constituer (
   idAchat INT,
   idMedicament INT,
   quantite INT NOT NULL,
   PRIMARY KEY(idAchat, idMedicament),
   FOREIGN KEY(idAchat) REFERENCES ACHAT(idAchat),
   FOREIGN KEY(idMedicament) REFERENCES MEDICAMENT(idMedicament)
);

-- Lien entre un achat et une ordonnance (si achat sur ordonnance)
CREATE TABLE Relier (
   idAchat INT,
   idOrdonnance INT,
   PRIMARY KEY(idAchat, idOrdonnance),
   FOREIGN KEY(idAchat) REFERENCES ACHAT(idAchat),
   FOREIGN KEY(idOrdonnance) REFERENCES ORDONNANCE(idOrdonnance)
);

-- =============================
-- Adresses et coordonnées
-- =============================

-- Lien Personne ↔ Adresse
CREATE TABLE Situer (
   idPersonne INT,
   idAdresse INT,
   PRIMARY KEY(idPersonne, idAdresse),
   FOREIGN KEY(idPersonne) REFERENCES Personne(idPersonne),
   FOREIGN KEY(idAdresse) REFERENCES ADRESSE(idAdresse)
);

-- Lien Personne ↔ Coordonnées
CREATE TABLE Avoir (
   idPersonne INT,
   idCoordonnees INT,
   PRIMARY KEY(idPersonne, idCoordonnees),
   FOREIGN KEY(idPersonne) REFERENCES Personne(idPersonne),
   FOREIGN KEY(idCoordonnees) REFERENCES COORDONNEES(idCoordonnees)
);

-- Lien Mutuelle ↔ Coordonnées
CREATE TABLE Contacter (
   idMutuelle INT,
   idCoordonnees INT,
   PRIMARY KEY(idMutuelle, idCoordonnees),
   FOREIGN KEY(idMutuelle) REFERENCES MUTUELLE(idMutuelle),
   FOREIGN KEY(idCoordonnees) REFERENCES COORDONNEES(idCoordonnees)
);

-- Lien Mutuelle ↔ Adresse
CREATE TABLE Resider (
   idMutuelle INT,
   idAdresse INT,
   departement VARCHAR(50),
   PRIMARY KEY(idMutuelle, idAdresse),
   FOREIGN KEY(idMutuelle) REFERENCES MUTUELLE(idMutuelle),
   FOREIGN KEY(idAdresse) REFERENCES ADRESSE(idAdresse)
);


-- =============================
-- INSERTIONS DES ADRESSES
-- =============================

INSERT INTO ADRESSE (ad_numero, ad_rue, ad_codePostal, ad_ville)
VALUES
(3, 'avenue General Leclerc', 54000, 'Nancy'),
(12, 'rue des Fleurs', 54000, 'Nancy'),
(45, 'boulevard de la République', 54000, 'Nancy'),
(8, 'avenue de la Liberté', 54000, 'Nancy'),
(27, 'rue Victor Hugo', 54000, 'Nancy'),
(12, 'rue Saint-Jean', 54000, 'Nancy'),
(5, 'avenue Poincaré', 54000, 'Nancy'),
(8, 'rue Rives de Meurthe', 54000, 'Nancy'),
(3, 'boulevard Victor Hugo', 54000, 'Nancy'),
(27, 'rue du Général Leclerc', 54000, 'Nancy'),
(12, 'rue de Paris', 54000, 'Nancy'),
(5, 'boulevard Victor Hugo', 67000, 'Strasbourg'),
(8, 'avenue Foch', 68100, 'Mulhouse'),
(27, 'rue du Général Leclerc', 51100, 'Reims'),
(15, 'rue des Jardins', 57000, 'Metz');

-- =============================
-- INSERTIONS DES COORDONNÉES
-- =============================

INSERT INTO COORDONNEES (coo_telephone, coo_email)
VALUES
('0650368754', 'pvero@h.fr'),
('0612457896', 'marie.durand@mail.fr'),
('0678593214', 'julien.bernard@mail.fr'),
('0625478963', 'sophie.nguyen@mail.fr'),
('0645789652', 'carlos.rodriguez@mail.fr'),
('0612345678', 'sandrine.wagner@mail.fr'),
('0623456789', 'luc.martin@mail.fr'),
('0634567890', 'claire.dupuis@mail.fr'),
('0645678901', 'paul.leclerc@mail.fr'),
('0656789012', 'marie.dubois@mail.fr'),
('0383456789', 'contact@harmonie.fr'),
('0389123456', 'contact@mgen.fr'),
('0387654321', 'contact@allianz.fr'),
('0323456789', 'contact@axa.fr'),
('0334567890', 'contact@maif.fr');

-- =============================
-- INSERTIONS DES PERSONNES
-- =============================

INSERT INTO Personne (pers_nom, pers_prenom, pers_civilite)
VALUES
('pedro', 'vero', 'Mme'),
('Durand', 'Marie', 'Mme'),
('Bernard', 'Julien', 'M.'),
('Nguyen', 'Sophie', 'Mme'),
('Rodriguez', 'Carlos', 'M.'),
('Wagner', 'Sandrine', 'Dr'),
('Martin', 'Luc', 'Dr'),
('Dupuis', 'Claire', 'Dr'),
('Leclerc', 'Paul', 'Dr'),
('Dubois', 'Marie', 'Dr');

-- =============================
-- INSERTIONS DES MÉDECINS
-- =============================

INSERT INTO MEDECIN (med_numeroAgreement, idPersonne)
VALUES
('AG12345', 6),
('AG23456', 7),
('AG34567', 8),
('AG45678', 9),
('AG56789', 10);

-- =============================
-- INSERTIONS DES MUTUELLES
-- =============================

INSERT INTO MUTUELLE (mut_nom, mut_tauxPriseChargeMedoc)
VALUES
('Harmonie', 80.00),
('MGEN', 90.00),
('Allianz', 85.00),
('AXA Santé', 75.00),
('MAIF Santé', 80.00);

-- =============================
-- INSERTIONS DES CLIENTS
-- =============================

INSERT INTO CLIENT (cli_numeroSecu, cli_dateNaissance, idPersonne, idMedecin, idMutuelle)
VALUES
('184125412345678', '1999-03-13', 1, 1, 1),
('285076512345612', '1985-07-25', 2, 2, 5),
('184021012345634', '1990-02-10', 3, 3, 2),
('285031212345698', '2000-12-05', 4, 4, 3),
('184111212345677', '1978-11-12', 5, 5, 4);

-- =============================
-- INSERTIONS DES MÉDICAMENTS
-- =============================

INSERT INTO MEDICAMENT (medoc_nom, medoc_categorie, medoc_prix, medoc_dateMiseService, medoc_quantite)
VALUES
('Paracetamol', 'Antalgique', 4.5, '2020-01-15', 50),
('Ibuprofen', 'Anti-inflammatoire', 5.0, '2021-05-10', 30),
('Amoxicilline', 'Antibiotique', 8.0, '2019-08-20', 20),
('Cetirizine', 'Antihistaminique', 6.5, '2022-03-05', 15),
('Omeprazole', 'Antiacide', 7.5, '2021-11-12', 25);

-- =============================
-- INSERTIONS DES ORDONNANCES
-- =============================

INSERT INTO ORDONNANCE (ord_date, idMedecin, idClient)
VALUES
('2025-03-01', 1, 1),
('2025-03-05', 2, 2),
('2025-03-10', 1, 2),
('2025-03-15', 2, 1),
('2025-03-20', 1, 1),
('2025-03-25', 2, 2);

-- =============================
-- LIEN ORDONNANCE ↔ MÉDICAMENTS
-- =============================

INSERT INTO Lier (idOrdonnance, idMedicament, quantite)
VALUES
(1, 1, 1), (1, 4, 1),
(2, 2, 1),
(3, 3, 1), (3, 1, 1),
(4, 2, 1), (4, 4, 1),
(5, 1, 1), (5, 2, 1), (5, 3, 1),
(6, 4, 1);

-- =============================
-- INSERTIONS DES ACHATS
-- =============================

INSERT INTO ACHAT (parOrdonnance, dateAchat, idClient)
VALUES
(false, '2021-06-15', 1),
(false, '2025-09-03', 4),
(true, '2023-08-05', 2),
(true, '2025-08-30', 3);

-- =============================
-- LIEN ACHAT ↔ MÉDICAMENTS
-- =============================

INSERT INTO Constituer (idAchat, idMedicament, quantite)
VALUES
(1, 1, 1),
(2, 1, 1),
(3, 1, 1), (3, 2, 1),
(4, 1, 1), (4, 2, 1);

-- =============================
-- LIEN ACHAT ↔ ORDONNANCE
-- =============================

INSERT INTO Relier (idAchat, idOrdonnance)
VALUES
(3, 2),
(4, 3);



