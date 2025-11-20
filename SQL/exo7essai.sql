USE exo7;
-- Date de naissance et l’adresse de John Humphrey ?
select employe.DateNaissance, employe.Adresse
from employe
where employe.Nom = "Humphrey";

-- Nom et adresse des employés qui travaillent au département de recherche ?
select employe.Nom, employe.Adresse
from employe
inner join departement on departement.N_Dep = employe.N_Dep
where departement.NomD = "recherche";

-- Nom et Prénom des employés dont le supérieur est John Humphrey ?
select employe.Nom, employe.prenom
from employe
where employe.superieur = 1;

-- Nom des employés qui travaillent plus de 6 heures sur un projet à Périgueux ?
select employe.Nom
from employe
inner join travaille on travaille.Matricule = employe.Matricule
inner join projet on projet.N_Proj = travaille.N_Proj
where projet.Lieu = "Périgueux" and travaille.Heures > 6;

-- Nom des projets sur lesquelles travaillent John Humphrey et Mejia Sawyer ?
select projet.NomP
from projet
inner join travaille on travaille.N_Proj = projet.N_Proj
inner join employe on employe.Matricule = travaille.Matricule
where employe.prenom = "John" or "Mejia";

-- Nom et prénom des employés qui ne travaillent sur aucun projet ?
select employe.Nom
from employe
inner join travaille on employe.Matricule = travaille.Matricule
inner join projet on travaille.N_Proj = projet.N_Proj
where projet.NomP = null;

SELECT Nom, Prenom
FROM Employe
WHERE Matricule NOT IN (
    SELECT Matricule
    FROM Travaille
);

-- Numéro des projets qui ont au moins un participant de chaque département ?
select projet.N_Proj
from projet
inner join travaille on travaille.N_Proj = projet.N_Proj
inner join employe on employe.Matricule = travaille.Matricule
where employe.matricule = (
	select min(matricule)
	from employe
);

SELECT t.N_Proj
FROM Travaille t
JOIN Employe e ON t.Matricule = e.Matricule
GROUP BY t.N_Proj
HAVING COUNT(DISTINCT e.N_Dep) = (SELECT COUNT(*) FROM Departement);

-- Nom des employés qui ne travaillent pas sur un projet à Périgueux ?
SELECT DISTINCT e.nom, e.prenom FROM employe e
LEFT JOIN travaille t
ON e.Matricule = t.Matricule
LEFT JOIN projet p
ON t.N_Proj = p.N_Proj
WHERE p.lieu != 'Périgueux'
 