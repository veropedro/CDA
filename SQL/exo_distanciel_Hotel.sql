-- Exercice 1 HOTEL :

USE hotel;
-- 1.Liste des hôtels dans chaque ville
select hot_nom, hot_ville
from hotel;

-- 2. Afficher le Nom, Prénom et la villede Mr White
select cli_nom, cli_prenom, cli_ville
from client
where cli_nom = "white";

-- 3. Afficher les ou la Station > 1000md’altitude
select sta_nom, sta_altitude
from station
where sta_altitude > 1000;

-- 4. afficher les numéros de chambresayant une Capacité > 1 personne
select cha_numero, cha_capacite
from chambre
where cha_capacite > 1;

-- 5. Liste des clients n'habitant pas àLondres
select cli_nom, cli_ville
from client
where cli_ville != "londres";

-- 6. la liste des hôtels situé à Bretou etde catégorie > 3
select hot_nom, hot_ville, hot_categorie
from hotel
where hot_ville = "bretou" and hot_categorie > 3;

-- 7. le nombre d’Hôtels par station
select station.sta_nom as station, count(hotel.hot_id)
from station
inner join hotel on hotel.hot_sta_id = station.sta_id
group by station;


-- EXERCICE 2 HOTEL :
-- 1. le nombre de chambre par station
select station.sta_nom as Stations, count(chambre.cha_id) as totalChambre
from station
inner join hotel on hotel.hot_sta_id = station.sta_id
inner join chambre on chambre.cha_hot_id = hotel.hot_id
group by station.sta_nom;

-- 2. la liste des stations et de leurshôtels avec leur catégorie et la villeassociée
select station.sta_nom, hotel.hot_nom, hotel.hot_categorie, hotel.hot_ville
from station
inner join hotel on hotel.hot_sta_id = station.sta_id
order by station.sta_nom;

-- 3. la liste des chambres > 1 place dans la ville de Bretou On souhaiteafficher le nom, la catégorie, laville, le numéro de chambre et sacapacité
select h.hot_nom, h.hot_categorie, h.hot_ville, c.cha_numero, c.cha_capacite
from hotel h
inner join chambre c on c.cha_hot_id = h.hot_id
where c.cha_capacite > 1
order by h.hot_nom;