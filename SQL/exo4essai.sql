USE exo4;

-- D’afficherlesnomsetlesprixdeslogicielsappartenantauprojetayantcommetitre«gestiondestock»,triésdansl’ordredécroissantdesprix?
select logiciel.NomLog, logiciel.PrixLog 
from logiciel
inner join projet on projet.NumProj = logiciel.NumProj
where TitreProj = "gestion de stock"
order by logiciel.PrixLog DESC;

-- D’afficherletotaldesprixdeslogicielsduprojetnuméro10.Lorsdel’affichage,letitredelacolonnesera«courstotalduprojet»?
select sum(logiciel.PrixLog) as "cout total du projet"
from logiciel
where NumProj = 10;

-- Afficherlenombrededéveloppeursquiontparticipéauprojetintitulé«gestiondestock»?
select count(*)
from developpeur
inner join realisation on realisation.NumDev = developpeur.NumDev
inner join projet on realisation.NumProj = projet.NumProj
where TitreProj = "gestion de stock";


-- Afficherlesprojetsquiontplusque5logiciels? 

select projet.TitreProj , GROUP_CONCAT(Logiciel.NomLog SEPARATOR ', ') AS Logiciels
from projet
inner join logiciel on logiciel.NumProj = projet.NumProj
GROUP BY Projet.TitreProj
HAVING COUNT(Logiciel.CodLog) >= 5;


-- Lesnumérosetnomsdesdéveloppeursquiontparticipésdanstouslesprojets?
select developpeur.NumDev , developpeur.NomDev
from developpeur
inner join realisation on realisation.NumDev = developpeur.NumDev
inner join projet on realisation.NumProj = projet.NumProj
group by developpeur.NumDev
having count(projet.NumProj) = 15;


-- Lesnumérosdeprojetsdanslesquellestouslesdéveloppeursyparticipentdanssaréalisation?
select projet.NumProj as "nom du projet"
from projet
inner join realisation on realisation.NumProj = projet.NumProj
inner join developpeur on realisation.NumDev = developpeur.NumDev
group by projet.NumProj
having count(developpeur.NumDev) = 5;

-- OU

SELECT projet.NumProj as "nom du projet"
FROM projet
INNER JOIN realisation ON realisation.NumProj = projet.NumProj
INNER JOIN developpeur ON realisation.NumDev = developpeur.NumDev
GROUP BY projet.NumProj
HAVING COUNT(DISTINCT developpeur.NumDev) = (
    SELECT COUNT(*) FROM developpeur
);

