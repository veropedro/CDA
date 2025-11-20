USE exo9;
-- Titredesfilmsdontladuréeestsupérieureouégaleàdeuxheures?
select titre
from film
where duree > 120;

-- Nomdesvillesabritantuncinémanommé«RIF»?
select nomville
from ville
inner join cinema on cinema.codepostal = ville.codepostal
where nomcine = "RIF";

-- NomdescinémassituésàMeknèsoucontenantaumoinsunesalledeplus100places?
select distinct nomcine
from cinema
inner join ville on ville.codepostal = cinema.codepostal
inner join salle on salle.numcine = cinema.numcine
where ville.nomville ="Meknès" or salle.capacite > 100;

-- Nom,adresseetvilledescinémasdanslesquelsonjouelefilm«Hypnose»lasemaine19?
select nomcine, adresse, nomville
from cinema
inner join ville on ville.codepostal = cinema.codepostal
inner join salle on salle.numcine = cinema.numcine
inner join projection on projection.numsalle = salle.numsalle
inner join film on film.numexploit = projection.numexploit
where film.titre = "Hypnose" and projection.numsemaine = 19;


-- Numérod’exploitationdesfilmsprojetésdanstouteslessalles?
select distinct projection.numexploit 
from projection
inner join film on film.numexploit = projection.numexploit
inner join salle on salle.numsalle = projection.numsalle
where projection.numexploit = (SELECT COUNT(*) FROM film);

-- Titredesfilmsquin’ontpasétéprojetés?
select titre
from film
inner join projection on projection.numexploit = film.numexploit
where film not in (select numsemaine from projection);