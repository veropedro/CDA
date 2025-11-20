/* ----- */
/* EXO 2 */
/* ----- */
/* 
Départements : ( DNO, DNOM, DIR, VILLE)
Employés : ( ENO, ENOM, PROF, DATEEMB, SAL, COMM, #DNO)
*/
CREATE DATABASE exo2; 
USE exo2;

CREATE TABLE departement (
	dno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	dnom VARCHAR(50) NOT NULL,
	dir VARCHAR(50) NOT NULL,
    ville VARCHAR(50) NOT NULL
);

CREATE TABLE employes (
	eno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	enom VARCHAR(50),
	prof VARCHAR(50),
    dateemb date, 
    sal int,
    comm int,
    dno INT NOT NULL,
    CONSTRAINT fk_dno FOREIGN KEY (dno) REFERENCES departement(dno)
);


insert into departement (dnom, dir, ville) 
values ("production", "jero", "nancy"), ("rh", "jero", "nancy");

insert into employes (enom, prof, dateemb, sal, comm, dno) 
values ("boebion", "dev", "2020-08-12",2000, 1000, 1);
insert into employes (enom, prof, dateemb, sal, comm, dno) 
values ("john", "dev", "2020-08-12",2500, 1500, 1);
insert into employes (enom, prof, dateemb, sal, comm, dno) 
values ("marie", "rh", "2020-08-12",1500, null, 2);
insert into employes (enom, prof, dateemb, sal, comm, dno) 
values ("julie", "rh", "2020-08-12",1500, null, 2);


