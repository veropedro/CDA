USE exo6;
-- Donnez la liste des avions dont la capacité est supérieure à 350 passagers ?
select avion.NOMAV
from avion
where avion.CAPACITE >= 350;

-- Quels sont les numéros et noms des avions localisés à Marrakech ?
select avion.NOMAV, avion.NUMAV
from avion
where avion.VILLE = "Marrakech";

-- Quels sont les numéros des pilotes en service et les villes de départ de leurs vols ?
select pilote.NOMPIL, VOL.H_DEP
from pilote
inner join vol on vol.NUMPIL = pilote.NUMPIL;

-- Donnez toutes les informations sur les pilotes de la compagnie ?
select pilote.NOMPIL,  pilote.NUMPIL,  pilote.VILLE,  pilote.SALAIRE
from pilote;

-- Quel est le nom des pilotes domiciliés à Meknès dont le salaire est supérieur à 20000 € ?
select pilote.NOMPIL,  pilote.VILLE,  pilote.SALAIRE
from pilote
where pilote.VILLE = "Meknès" and  pilote.SALAIRE >= 20000;

-- Quels sont les avions (numéro et nom) localisés à Marrakech ou dont la capacité est inférieure à 350 passagers ?
select avion.NOMAV, avion.NUMAV
from avion
where avion.VILLE = "Marrakech" and  avion.CAPACITE < 350;

-- Quels sont les numéros des pilotes qui ne sont pas en service ?
select pilote.NUMPIL
from pilote
inner join vol on vol.NUMPIL = pilote.NUMPIL
where vol.H_DEP is null;

-- correction:
SELECT P.NUMPIL, P.NOMPIL 
FROM PILOTE P
LEFT JOIN VOL V ON V.NUMPIL = P.NUMPIL
WHERE V.NUMPIL IS NULL;
 

-- Donnez le numéro des vols effectués au départ de Marrakech par des pilotes de Meknès ?
select vol.NUMVOL
from vol
inner join pilote on pilote.NUMPIL = vol.NUMPIL
where vol.VILLE_DEP = "Marrakech" and pilote.VILLE = "Meknès";

-- Quels sont les vols effectués par un avion qui n’est pas localisé à Marrakech ?
select vol.NUMVOL
from vol
inner join avion on avion.NUMAV = vol.NUMAV
where avion.VILLE != "Marrakech" ;

-- Quelles sont les villes desservies à partir de la ville d’arrivée d’un vol au départ de Guelma ?

