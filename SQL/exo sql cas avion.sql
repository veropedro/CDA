CREATE TABLE AEROPORT (
	aer_id INT auto_increment NOT NULL,
    aer_nom VARCHAR(50) NOT NULL,
    aer_ville VARCHAR(50) NOT NULL,
    PRIMARY KEY(aer_id)
);
CREATE TABLE PILOTE (
	pil_id INT auto_increment NOT NULL,
    pil_nom VARCHAR(50) NOT NULL,
    pil_prenom VARCHAR(30) NOT NULL,
    PRIMARY KEY(pil_id)
);
CREATE TABLE CONSTRUCTEUR (
	con_id INT auto_increment NOT NULL,
    con_nom VARCHAR(50) NOT NULL,
    PRIMARY KEY(con_id)
);
CREATE TABLE TYPE (
	typ_id INT auto_increment NOT NULL,
    typ_libelle VARCHAR(20) NOT NULL,
    typ_capacite SMALLINT NOT NULL,
    PRIMARY KEY(typ_id)
);
CREATE TABLE CONSTRUIT (
	con_id INT NOT NULL,
    typ_id INT NOT NULL,
	FOREIGN KEY(con_id) REFERENCES CONSTRUCTEUR(con_id),
	FOREIGN KEY(typ_id) REFERENCES TYPE(typ_id),
    PRIMARY KEY(con_id, typ_id)
);
CREATE TABLE AVION (
	avi_id INT auto_increment NOT NULL,
    aer_id INT NOT NULL,
    typ_id INT NOT NULL,
    avi_numero INT NOT NULL,
    PRIMARY KEY(avi_id),
    FOREIGN KEY(aer_id) REFERENCES AEROPORT(aer_id),
	FOREIGN KEY(typ_id) REFERENCES TYPE(typ_id)
);
CREATE TABLE DATE (
	dat_id INT auto_increment NOT NULL,
    dat_date DATETIME NOT NULL,
    PRIMARY KEY(dat_id)
);
CREATE TABLE VOL (
	vol_id INT auto_increment NOT NULL,
    aer_depart_id INT NOT NULL,
    aer_arrivee_id INT NOT NULL,
    vol_numero VARCHAR(5) NOT NULL,
    vol_heuredepart TIME NOT NULL,
    vol_heurearrivee TIME NOT NULL,
    PRIMARY KEY(vol_id),
    FOREIGN KEY(aer_depart_id) REFERENCES AEROPORT(aer_id),
    FOREIGN KEY(aer_arrivee_id) REFERENCES AEROPORT(aer_id)
);    