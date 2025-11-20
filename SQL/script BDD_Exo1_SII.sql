DROP DATABASE IF EXISTS SII;

CREATE DATABASE IF NOT EXISTS SII;

USE SII;

drop table if exists SERVICE;
  
create table SERVICE(
	SER_ID int auto_increment,
    SER_NOM varchar(30),
    SER_CHEF int,
    primary key (SER_ID)
);

lock tables SERVICE write;
INSERT INTO SERVICE (SER_NOM)
VALUES
  ("Comptabilite"),  ("Recherche"),  ("Ressource Humaine");
unlock tables;

drop table if exists EMPLOYE;

create table EMPLOYE(
	EMP_ID int auto_increment,
    EMP_NOM varchar(30),
    EMP_HEBDO int,
    EMP_SALAIRE int,
    EMP_SERV int,
    primary key(EMP_ID)
);

lock tables EMPLOYE write;
INSERT INTO EMPLOYE (EMP_NOM,EMP_HEBDO,EMP_SALAIRE,EMP_SERV)
VALUES
  ("Lee Houston",2,1894,2),  ("Thor Marquez",2,2661,2),  ("Samantha Copeland",8,2698,2),  ("Xyla Sawyer",1,2544,1),  ("Kelsie Boyle",0,2867,2),
  ("Leslie Cortez",6,2273,1),  ("Vladimir Mcmahon",7,2666,1),  ("Aiko Marquez",7,1842,2),  ("Lavinia Bird",7,2727,3),  ("Perry Walton",6,2903,3),
  ("Mary Bryant",0,2838,3),  ("Aline Hobbs",7,2029,2),  ("Kelly Knight",8,2003,1),  ("Kareem Cobb",8,2230,3),  ("Tanya Cooke",1,2899,2),
  ("Holmes Tanner",1,1554,3),  ("Dominique Torres",7,2120,2),  ("Keiko Cross",2,2425,2),  ("Grace Jarvis",1,1567,3),  ("Slade Henry",7,2048,1);
  unlock tables;
  
alter table SERVICE
add constraint FK_SER_CHEF foreign key (SER_CHEF) references EMPLOYE(EMP_ID);
update SERVICE set SER_CHEF = 1 where SER_ID = 1;
update SERVICE set SER_CHEF = 2 where SER_ID = 2;
update SERVICE set SER_CHEF = 3 where SER_ID = 3;
  
drop table if exists PROJET;

create table PROJET(
	PRO_ID int auto_increment,
    PRO_NOM varchar(30),
    PRO_RESP int,
    primary key (PRO_ID),
    constraint FK_PRO_RESP foreign key (PRO_RESP) references EMPLOYE(EMP_ID)
);

lock tables PROJET write;
INSERT INTO PROJET (PRO_NOM,PRO_RESP)
VALUES 
  ("Mega Lavage Informatique",1),  ("Cool Zero",2),  ("Lavage Informatique Zero",3),  ("Restaurant",4),  ("Bar à Tapas",5),  ("Super Cool Mega",6);
unlock tables;

drop table if exists TRAVAIL;

create table TRAVAIL(
	EMP_ID int,
    PRO_ID int,
    TRA_DUREE int,
    constraint FK_TRA_EMP foreign key (EMP_ID) references EMPLOYE(EMP_ID),
    constraint FK_TRA_PRO foreign key (PRO_ID) references PROJET(PRO_ID)
);

lock tables TRAVAIL write;
INSERT INTO TRAVAIL (EMP_ID,PRO_ID,TRA_DUREE)
VALUES
  (14,3,3),  (7,5,9),  (18,3,36),  (4,1,19),  (3,2,38),  (12,4,4),  (4,1,34),  (4,1,16),  (4,2,33),  (14,1,42),  (18,2,31),  (4,1,22),  (17,3,17),  (6,4,40),  (15,3,9),  (4,5,48),  (18,2,26),  (16,3,48),  (9,3,11),  (18,5,28),
  (18,4,23),  (17,2,50),  (13,6,39),  (18,3,36),  (9,5,22),  (6,6,25),  (11,2,37),  (16,4,11),  (13,4,30),  (10,6,13),  (9,1,14),  (16,2,29),  (14,1,44),  (7,5,41),  (9,6,44),  (10,4,26),  (10,3,12),  (5,5,45),  (1,5,49),  (18,3,7),
  (9,3,19),  (1,4,42),  (20,3,16),  (15,5,45),  (16,3,48),  (11,1,34),  (17,4,46),  (11,3,29),  (13,3,17),  (18,3,21),  (18,5,43),  (6,6,8),  (8,1,1),  (11,3,44),  (3,5,31),  (19,1,31),  (4,3,34),  (4,3,7),  (2,1,44),  (15,3,4),
  (18,3,2),  (5,6,36),  (16,6,19),  (17,3,20),  (5,3,35),  (8,2,48),  (2,2,35),  (13,3,31),  (6,2,37),  (5,3,8),  (3,4,33),  (17,1,6),  (5,6,21),  (12,3,47),  (3,2,36),  (14,4,42),  (3,2,35),  (20,4,40),  (5,6,46),  (1,3,9),
  (11,5,36),  (20,2,17),  (9,4,34),  (20,3,12),  (17,2,35),  (1,5,10),  (7,4,13),  (2,5,50),  (2,3,34),  (2,3,20),  (6,4,25),  (6,4,30),  (6,3,47),  (5,3,26),  (15,1,11),  (5,4,40),  (1,5,40),  (4,4,32),  (8,5,27),  (17,2,32),
  (18,3,38),  (2,5,41),  (18,5,25),  (13,3,26),  (13,5,30),  (13,6,1),  (20,2,6),  (1,4,31),  (6,1,4),  (13,6,28),  (1,2,33),  (16,6,1),  (7,4,15),  (19,4,14),  (5,1,13),  (12,5,40),  (9,5,19),  (4,2,22),  (14,3,43),  (9,3,23);
unlock tables;
  
  
  
  
  
  
  
  
  