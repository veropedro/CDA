/* exo AUTO ECOLE/*

CREATE TABLE MODELE (
	mod_id INT auto_increment NOT NULL,
    mod_label VARCHAR(50) NOT NULL,
    PRIMARY KEY(mod_id)
);
CREATE TABLE VEHICULE (
	veh_id INT auto_increment NOT NULL,
    mod_id INT NOT NULL,
    veh_immat VARCHAR(10) NOT NULL,
    veh_label VARCHAR(50) NOT NULL,
    PRIMARY KEY(veh_id),
    FOREIGN KEY(mod_id) REFERENCES MODELE(mod_id)
);
CREATE TABLE ELEVE (
	ele_id INT auto_increment NOT NULL,
    ele_nom VARCHAR(50) NOT NULL,
    ele_prenom VARCHAR(50) NOT NULL,
    PRIMARY KEY(ele_id)
);
CREATE TABLE MONITEUR (
	mon_id INT auto_increment NOT NULL,
    mon_nom VARCHAR(50) NOT NULL,
    mon_prenom VARCHAR(50) NOT NULL,
    PRIMARY KEY(mon_id)
);
CREATE TABLE CALENDRIER (
	cal_id INT auto_increment NOT NULL,
    cal_nom datetime NOT NULL,
    PRIMARY KEY(cal_id)
);
CREATE TABLE LECON (
FOREIGN KEY(mod_id) REFERENCES MODELE(mod_id),
FOREIGN KEY(ele_id) REFERENCES ELEVE(ele_id),
FOREIGN KEY(cal_id) REFERENCES CALENDRIER(cal_id),
FOREIGN KEY(mon_id) REFERENCES MONITEUR(mon_id),
duree time NOT NULL,
lec_date datetime NOT NULL
)







	