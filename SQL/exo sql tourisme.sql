CREATE TABLE ADHERENT (
	adh_id INT auto_increment NOT NULL,
    adh_nom VARCHAR(50) NOT NULL,
    adh_prenom VARCHAR(50) NOT NULL,
    adh_adresse VARCHAR(100) NOT NULL,
    adh_date date NOT NULL,
    PRIMARY KEY(adh_id)
);
CREATE TABLE PAYS (
	pay_id INT auto_increment NOT NULL,
    pay_nom VARCHAR(100) NOT NULL,
    PRIMARY KEY(pay_id)
);
CREATE TABLE ACTIVITE (
	act_id INT auto_increment NOT NULL,
    act_nom VARCHAR(20) NOT NULL,
    PRIMARY KEY(act_id)
);
CREATE TABLE PERIODE (
	per_id INT auto_increment NOT NULL,
    per_label VARCHAR(25) NOT NULL,
    per_debut INT NOT NULL,
    per_fin INT NOT NULL,
    per_annee FLOAT NOT NULL,
    PRIMARY KEY(per_id)
);
CREATE TABLE SEMAINE (
	sem_id FLOAT auto_increment NOT NULL,
    per_id INT NOT NULL,
    PRIMARY KEY(sem_id),
    FOREIGN KEY(per_id) REFERENCES PERIODE(per_id)
);
CREATE TABLE VILLAGE (
	vil_id INT auto_increment NOT NULL,
    pay_id INT NOT NULL,
    vil_nom VARCHAR(50) NOT NULL,
    vil_places FLOAT NOT NULL,
    PRIMARY KEY(vil_id),
    FOREIGN KEY(pay_id) REFERENCES PAYS(pay_id)
);
CREATE TABLE RESERVER (
	vil_id INT NOT NULL,
    adh_id INT NOT NULL,
    sem_id FLOAT NOT NULL,
    res_places FLOAT NOT NULL,
    FOREIGN KEY(vil_id) REFERENCES VILLAGE(vil_id),
    FOREIGN KEY(adh_id) REFERENCES ADHERENT(adh_id),
    FOREIGN KEY(sem_id) REFERENCES SEMAINE(sem_id)
);
CREATE TABLE OFFRIR (
	vil_id INT NOT NULL,
    per_id INT NOT NULL,
    sem_id FLOAT NOT NULL,
    prix FLOAT NOT NULL,
    FOREIGN KEY(vil_id) REFERENCES VILLAGE(vil_id),
    FOREIGN KEY(per_id) REFERENCES PERIODE(per_id),
    FOREIGN KEY(sem_id) REFERENCES SEMAINE(sem_id)
);
CREATE TABLE PROPOSER (
	vil_id INT NOT NULL,
    act_id INT NOT NULL,
    FOREIGN KEY(vil_id) REFERENCES VILLAGE(vil_id),
    FOREIGN KEY(act_id) REFERENCES ACTIVITE(act_id)
);

