USE exo8;

-- Nom,prénomete-maildesclientsayantuneréservationencours?
select distinct client.nom, client.prenom, client.e_mail
from client
inner join reservation on reservation.numcli = client.numcli
where DateRes >= '2022-03-05';

select client.nom, client.prenom, client.e_mail
from client
inner join reservation on reservation.numcli = client.numcli
where reservation.codevoyage is not null;

-- Nom,prénomete-maildesclientsn’ayantaucuneréservationencours?
select client.nom, client.prenom, client.e_mail
from client
where numcli not in (select numcli from reservation);

-- Destinationetlistedesclientsayantréservéspourunvoyagedeplusde10joursetcoûtantmoinsde1000€?
select voyage.destination , client.nom , client.prenom
from voyage, client
where voyage.prix < 1000 and voyage.duree > 10;

-- Numérosdetouslesclientsayantréservéssurtouslesvoyagesproposés?
select client.numcli
from client
inner join reservation on reservation.numcli = client.numcli
GROUP BY client.numcli

-- correction


HAVING COUNT(DISTINCT reservation.codevoyage) = (SELECT COUNT(*) FROM voyage);

/*COUNT(DISTINCT r.codevoyage) → compte combien de voyages le client a réservés.

(SELECT COUNT(*) FROM voyage) → compte combien de voyages existent au total.

HAVING → garde seulement les clients qui ont réservé autant de voyages que le total existant./*