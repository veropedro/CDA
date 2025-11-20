-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: airdejava
-- ------------------------------------------------------
-- Server version	8.4.6

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acces`
--

DROP TABLE IF EXISTS `acces`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acces` (
  `PRO_ID` int NOT NULL,
  `MEN_ID` int NOT NULL,
  PRIMARY KEY (`PRO_ID`,`MEN_ID`),
  KEY `FK_ACCES2` (`MEN_ID`),
  CONSTRAINT `FK_ACCES` FOREIGN KEY (`PRO_ID`) REFERENCES `profil` (`PRO_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_ACCES2` FOREIGN KEY (`MEN_ID`) REFERENCES `menu` (`MEN_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acces`
--

LOCK TABLES `acces` WRITE;
/*!40000 ALTER TABLE `acces` DISABLE KEYS */;
INSERT INTO `acces` VALUES (1,1),(2,1),(1,2),(2,2),(1,3),(2,3),(1,4),(2,4),(3,4),(1,5);
/*!40000 ALTER TABLE `acces` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auteur`
--

DROP TABLE IF EXISTS `auteur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auteur` (
  `PER_ID` int NOT NULL,
  `CHA_ID` int NOT NULL,
  PRIMARY KEY (`PER_ID`,`CHA_ID`),
  KEY `FK_AUTEUR2` (`CHA_ID`),
  CONSTRAINT `FK_AUTEUR` FOREIGN KEY (`PER_ID`) REFERENCES `personne` (`PER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_AUTEUR2` FOREIGN KEY (`CHA_ID`) REFERENCES `chanson` (`CHA_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auteur`
--

LOCK TABLES `auteur` WRITE;
/*!40000 ALTER TABLE `auteur` DISABLE KEYS */;
INSERT INTO `auteur` VALUES (5,1),(39,2),(7,3),(48,4),(45,5),(15,6),(17,7),(39,8),(24,9),(25,10),(26,11),(48,12),(37,13),(38,14),(41,15),(45,16),(4,17),(9,18),(13,19),(39,20),(32,21),(33,22),(45,23),(50,24),(51,25);
/*!40000 ALTER TABLE `auteur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chanson`
--

DROP TABLE IF EXISTS `chanson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chanson` (
  `CHA_ID` int NOT NULL AUTO_INCREMENT,
  `TYPO_ID` int NOT NULL,
  `CHA_TITRE` char(50) NOT NULL,
  `CHA_DATE` char(4) NOT NULL,
  `CHA_TPS` time NOT NULL,
  PRIMARY KEY (`CHA_ID`),
  KEY `FK_ESTTYPE` (`TYPO_ID`),
  CONSTRAINT `FK_ESTTYPE` FOREIGN KEY (`TYPO_ID`) REFERENCES `typeoeuvre` (`TYPO_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chanson`
--

LOCK TABLES `chanson` WRITE;
/*!40000 ALTER TABLE `chanson` DISABLE KEYS */;
INSERT INTO `chanson` VALUES (1,1,'Smells Like teen spirit','1991','00:05:01'),(2,7,'Rocky road to Dubli','1901','00:03:20'),(3,2,'Detachable penis','1992','00:03:22'),(4,2,'Highway to hell','1979','00:03:26'),(5,2,'Die, die my darling','1984','00:06:29'),(6,4,'Killing me softly with his song','1973','00:04:46'),(7,7,'Whiskey in the jar','1728','00:15:04'),(8,8,'I wanna be sedated','1979','00:02:29'),(9,1,'Janie Jones','1977','00:02:09'),(10,8,'I wanna be your dog','1969','00:03:09'),(11,8,'Pretty vacant','1977','00:03:20'),(12,3,'So what','1981','00:03:08'),(13,8,'Insane in the Brai','1993','00:03:33'),(14,2,'Stoned raiders','1995','00:02:54'),(15,2,'I fought the law','1959','00:02:14'),(16,2,'The End','1967','00:11:43'),(17,8,'Atrocity exhibitio','1980','00:06:06'),(18,1,'A means to an end','1980','00:04:07'),(19,6,'The Funeral party','1981','00:04:14'),(20,2,'Hey,hey, My My','1979','00:05:20'),(21,9,'Derezzed','2010','00:01:43'),(22,1,'Wrong','2009','00:03:13'),(23,2,'Rotten apple','1994','00:06:58'),(24,2,'Nutshell','1994','00:04:19'),(25,2,'Mama','1983','00:06:52'),(26,2,'Zouk','2011','00:03:00'),(27,1,'Ma Chanson leur à pas plu','1987','00:04:11'),(28,1,'Loulou','1988','00:04:10');
/*!40000 ALTER TABLE `chanson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `civilite`
--

DROP TABLE IF EXISTS `civilite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `civilite` (
  `CIV_ID` int NOT NULL AUTO_INCREMENT,
  `CIV_LIBELLE` char(20) NOT NULL,
  PRIMARY KEY (`CIV_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `civilite`
--

LOCK TABLES `civilite` WRITE;
/*!40000 ALTER TABLE `civilite` DISABLE KEYS */;
INSERT INTO `civilite` VALUES (1,'Monsieur'),(2,'Madame'),(3,'Mademoiselle');
/*!40000 ALTER TABLE `civilite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `groupe` (
  `GRO_ID` int NOT NULL AUTO_INCREMENT,
  `PER_ID` int NOT NULL,
  `GRO_NOM` char(50) NOT NULL,
  PRIMARY KEY (`GRO_ID`),
  KEY `FK_CORRESPONDAND` (`PER_ID`),
  CONSTRAINT `FK_CORRESPONDAND` FOREIGN KEY (`PER_ID`) REFERENCES `personne` (`PER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupe`
--

LOCK TABLES `groupe` WRITE;
/*!40000 ALTER TABLE `groupe` DISABLE KEYS */;
INSERT INTO `groupe` VALUES (3,11,'The Beatles'),(4,15,'La mano negra'),(5,17,'Louise Attaque'),(6,20,'Abba'),(7,24,'Killer bees'),(8,31,'Myslovitz'),(9,36,'Mecano'),(10,37,'Début de soirée'),(11,41,'Il était une fois'),(12,46,'The supremes'),(13,1,'The blues brothers'),(14,6,'Tri Yann'),(15,11,'Johnny Hallyday'),(16,15,'Daft punk'),(17,17,'Los Portos'),(18,20,'Lady punk'),(19,24,'Afpa Max'),(20,31,'La bande à Bono'),(21,36,'Tokyo Hotel'),(22,37,'Mississipi burning'),(23,41,'Chocolate box'),(24,46,'Fingers in the nose'),(25,1,'Demonic turtle'),(26,6,'Donde esta la fiesta ?'),(27,11,'Simple minds'),(28,31,'MCD do dupy !'),(29,36,'Les tambours du Bronx'),(30,37,'Alea jacta est');
/*!40000 ALTER TABLE `groupe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupe_supprime`
--

DROP TABLE IF EXISTS `groupe_supprime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `groupe_supprime` (
  `GRO_ID` int NOT NULL AUTO_INCREMENT,
  `PER_ID` int NOT NULL,
  `GRO_NOM` char(50) NOT NULL,
  `DATE_SUPPRESSION` date DEFAULT NULL,
  PRIMARY KEY (`GRO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupe_supprime`
--

LOCK TABLES `groupe_supprime` WRITE;
/*!40000 ALTER TABLE `groupe_supprime` DISABLE KEYS */;
/*!40000 ALTER TABLE `groupe_supprime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instrument`
--

DROP TABLE IF EXISTS `instrument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instrument` (
  `INS_ID` int NOT NULL AUTO_INCREMENT,
  `INS_NOM` char(20) NOT NULL,
  PRIMARY KEY (`INS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instrument`
--

LOCK TABLES `instrument` WRITE;
/*!40000 ALTER TABLE `instrument` DISABLE KEYS */;
INSERT INTO `instrument` VALUES (1,'Accordéo'),(2,'Appeau'),(3,'Banjo'),(4,'Basse'),(5,'Bâton de pluie'),(6,'Batterie'),(7,'Bombarde'),(8,'Bongo'),(9,'Calebasse'),(10,'Carillo'),(11,'Castagnettes'),(12,'Cithare'),(13,'Clarinette'),(14,'Claveci'),(15,'Claves'),(16,'Cloche'),(17,'Corne'),(18,'Cornemuse'),(19,'Cymbales'),(20,'Diapaso'),(21,'Djembé'),(22,'Flûte'),(23,'Grelots'),(24,'Guimbarde'),(25,'Guitare'),(26,'Harmonica'),(27,'Harpe'),(28,'Hautbois'),(29,'Lyre'),(30,'Mandoline'),(31,'Orgue'),(32,'Piano'),(33,'Saxophone'),(34,'Synthétiseur'),(35,'Tambour'),(36,'Timbale'),(37,'Triangle'),(38,'Trombone'),(39,'Trompette'),(40,'Violo'),(41,'Violoncelle'),(42,'Xylophone');
/*!40000 ALTER TABLE `instrument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jouer`
--

DROP TABLE IF EXISTS `jouer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jouer` (
  `PER_ID` int NOT NULL,
  `INS_ID` int NOT NULL,
  PRIMARY KEY (`PER_ID`,`INS_ID`),
  KEY `FK_JOUER2` (`INS_ID`),
  CONSTRAINT `FK_JOUER` FOREIGN KEY (`PER_ID`) REFERENCES `personne` (`PER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_JOUER2` FOREIGN KEY (`INS_ID`) REFERENCES `instrument` (`INS_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jouer`
--

LOCK TABLES `jouer` WRITE;
/*!40000 ALTER TABLE `jouer` DISABLE KEYS */;
INSERT INTO `jouer` VALUES (5,1),(15,1),(24,1),(26,1),(45,1),(10,2),(18,2),(20,2),(47,2),(9,3),(10,3),(18,4),(26,4),(49,4),(9,5),(24,5),(48,6),(41,7),(45,7),(14,8),(18,8),(25,8),(29,8),(12,9),(25,10),(9,11),(27,11),(46,12),(49,12),(50,13),(37,14),(4,15),(6,15),(35,16),(44,16),(22,17),(23,17),(30,17),(33,17),(44,17),(25,18),(40,18),(43,18),(16,19),(7,20),(28,20),(30,20),(43,20),(45,20),(6,21),(23,21),(38,21),(45,21),(32,22),(4,23),(31,23),(33,23),(44,23),(23,24),(5,25),(20,25),(50,25),(4,26),(14,26),(27,27),(51,27),(5,28),(19,28),(13,29),(8,30),(6,31),(28,31),(51,31),(2,32),(33,33),(37,33),(6,34),(11,34),(13,34),(47,34);
/*!40000 ALTER TABLE `jouer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `LOG_USER` int NOT NULL AUTO_INCREMENT,
  `PRO_ID` int NOT NULL,
  `LOG_NOM` char(20) NOT NULL,
  `LOG_PASS` char(20) NOT NULL,
  PRIMARY KEY (`LOG_USER`),
  KEY `FK_TYPEPROFIL` (`PRO_ID`),
  CONSTRAINT `FK_TYPEPROFIL` FOREIGN KEY (`PRO_ID`) REFERENCES `profil` (`PRO_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,1,'Jea','Némar'),(2,2,'Robi','Didonque'),(3,3,'Camille','Onssiterne'),(4,2,'Thomas','Teufarssi'),(5,3,'Jéremy','Maichossette');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membre`
--

DROP TABLE IF EXISTS `membre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `membre` (
  `GRO_ID` int NOT NULL,
  `PER_ID` int NOT NULL,
  PRIMARY KEY (`PER_ID`,`GRO_ID`),
  KEY `FK_MEMBRE` (`GRO_ID`),
  CONSTRAINT `FK_MEMBRE` FOREIGN KEY (`GRO_ID`) REFERENCES `groupe` (`GRO_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_MEMBRE2` FOREIGN KEY (`PER_ID`) REFERENCES `personne` (`PER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membre`
--

LOCK TABLES `membre` WRITE;
/*!40000 ALTER TABLE `membre` DISABLE KEYS */;
INSERT INTO `membre` VALUES (4,18),(5,1),(5,15),(7,1),(7,23),(9,4),(9,15),(9,20),(9,22),(11,12),(11,18),(12,9),(12,23),(12,27),(14,5),(15,17),(16,1),(16,3),(16,10),(16,24),(17,15),(17,22),(18,8),(18,11),(20,3),(20,10),(21,26),(21,27),(22,9),(22,29),(23,12),(25,1),(25,18),(26,19),(26,21),(27,6),(28,12),(29,2),(29,25),(29,29),(30,5);
/*!40000 ALTER TABLE `membre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `MEN_ID` int NOT NULL AUTO_INCREMENT,
  `MEN_LIBELLE` char(20) NOT NULL,
  PRIMARY KEY (`MEN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'Groupes'),(2,'Rencontres'),(3,'Œuvres'),(4,'Interrogations'),(5,'Outils');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `necessite`
--

DROP TABLE IF EXISTS `necessite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `necessite` (
  `CHA_ID` int NOT NULL,
  `INS_ID` int NOT NULL,
  PRIMARY KEY (`CHA_ID`,`INS_ID`),
  KEY `FK_NECESSITE2` (`INS_ID`),
  CONSTRAINT `FK_NECESSITE` FOREIGN KEY (`CHA_ID`) REFERENCES `chanson` (`CHA_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_NECESSITE2` FOREIGN KEY (`INS_ID`) REFERENCES `instrument` (`INS_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `necessite`
--

LOCK TABLES `necessite` WRITE;
/*!40000 ALTER TABLE `necessite` DISABLE KEYS */;
INSERT INTO `necessite` VALUES (1,11),(9,11),(1,25),(4,25),(9,31),(13,31),(5,32),(6,32),(9,32),(12,32),(9,33),(13,33);
/*!40000 ALTER TABLE `necessite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `occuper`
--

DROP TABLE IF EXISTS `occuper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `occuper` (
  `RES_ID` int NOT NULL,
  `GRO_ID` int NOT NULL,
  `PER_ID` int NOT NULL,
  PRIMARY KEY (`GRO_ID`,`RES_ID`,`PER_ID`),
  KEY `FK_OCCUPER` (`RES_ID`),
  KEY `FK_OCCUPER3` (`PER_ID`),
  CONSTRAINT `FK_OCCUPER` FOREIGN KEY (`RES_ID`) REFERENCES `responsabilite` (`RES_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_OCCUPER2` FOREIGN KEY (`GRO_ID`) REFERENCES `groupe` (`GRO_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_OCCUPER3` FOREIGN KEY (`PER_ID`) REFERENCES `personne` (`PER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `occuper`
--

LOCK TABLES `occuper` WRITE;
/*!40000 ALTER TABLE `occuper` DISABLE KEYS */;
INSERT INTO `occuper` VALUES (1,3,20),(1,4,33),(1,5,2),(1,6,51),(1,7,44),(1,8,42),(1,9,22),(1,10,20),(1,11,18),(1,12,23),(1,13,50),(1,14,2),(1,15,9),(1,16,32),(1,17,34),(1,18,25),(1,20,48),(1,21,2),(1,24,39),(1,28,38),(1,29,39),(1,30,46),(2,3,34),(2,4,50),(2,5,30),(2,6,41),(2,8,2),(2,9,12),(2,10,16),(2,12,11),(2,13,35),(2,15,5),(2,16,50),(2,18,38),(2,19,26),(2,20,44),(2,20,49),(2,21,26),(2,22,9),(2,29,22),(3,3,16),(3,4,9),(3,5,34),(3,6,27),(3,8,18),(3,9,43),(3,10,35),(3,12,28),(3,13,48),(3,15,17),(3,17,15),(3,18,4),(3,19,34),(3,20,47),(3,22,9),(3,23,34),(4,5,14),(4,6,38),(4,13,33),(4,15,38),(4,17,32),(4,18,40),(4,20,9),(4,22,17),(4,23,12),(4,25,34),(5,13,32),(5,17,48),(5,20,9),(5,22,48),(5,23,7),(5,26,21),(6,13,39),(6,17,2),(6,20,47),(6,23,34),(7,23,51),(7,27,37),(7,30,2),(8,23,50),(8,29,29),(9,27,1),(10,27,12),(11,27,21),(12,27,33),(12,30,34),(13,18,11),(14,25,29),(14,29,44),(15,24,16);
/*!40000 ALTER TABLE `occuper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passage`
--

DROP TABLE IF EXISTS `passage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passage` (
  `PAS_ID` int NOT NULL AUTO_INCREMENT,
  `GRO_ID` int NOT NULL,
  `REN_ID` int NOT NULL,
  `PAS_DATE` datetime NOT NULL,
  `PAS_HEUREDEB` time NOT NULL,
  `PAS_HEUREFIN` time NOT NULL,
  `PAS_LIEU` char(50) NOT NULL,
  PRIMARY KEY (`PAS_ID`),
  KEY `FK_HEBERGER` (`REN_ID`),
  KEY `FK_PASSAGEGROUPE` (`GRO_ID`),
  CONSTRAINT `FK_HEBERGER` FOREIGN KEY (`REN_ID`) REFERENCES `rencontre` (`REN_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_PASSAGEGROUPE` FOREIGN KEY (`GRO_ID`) REFERENCES `groupe` (`GRO_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passage`
--

LOCK TABLES `passage` WRITE;
/*!40000 ALTER TABLE `passage` DISABLE KEYS */;
INSERT INTO `passage` VALUES (1,19,1,'2012-02-14 00:00:00','14:00:00','15:00:00','Salle des Fêtes Vandoeuvre'),(2,30,1,'2012-02-14 00:00:00','15:30:00','16:45:00','Zénith de Nancy'),(3,9,1,'2012-02-14 00:00:00','18:30:00','20:00:00','Le Quai\'son'),(4,20,1,'2012-02-17 00:00:00','21:00:00','23:30:00','Zénith de Nancy'),(5,18,1,'2012-02-17 00:00:00','16:00:00','16:45:00','Salle des Fêtes Villerupt'),(6,13,1,'2012-02-17 00:00:00','20:45:00','23:59:00','Zénith de Nancy'),(7,17,2,'2011-12-12 00:00:00','20:00:00','21:30:00','Le Quartz'),(8,14,2,'2011-12-14 00:00:00','21:45:00','23:00:00','Penn Ar Jazz'),(9,6,2,'2011-12-15 00:00:00','16:00:00','18:30:00','Penfeld Parc Expo'),(10,5,2,'2011-12-15 00:00:00','20:00:00','22:00:00','Parc Expo Penvillers - Quimper'),(11,6,3,'2011-06-10 00:00:00','14:00:00','15:25:00','Café de la Danse - 11ème'),(12,4,3,'2011-06-10 00:00:00','18:00:00','20:30:00','La Cigale - 18ème'),(13,16,3,'2011-06-10 00:00:00','21:30:00','23:00:00','Zénith de Paris'),(14,16,3,'2011-06-13 00:00:00','20:00:00','22:00:00','Zénith de Paris'),(15,16,3,'2011-06-14 00:00:00','20:00:00','22:00:00','Zénith de Paris'),(16,21,4,'2011-08-05 00:00:00','20:30:00','22:00:00','Théâtre de Narbonne'),(17,22,4,'2011-08-06 00:00:00','21:30:00','23:00:00','Théâtre de Narbonne'),(18,14,4,'2011-08-07 00:00:00','22:30:00','00:00:00','Théâtre de Narbonne'),(19,16,10,'2011-11-16 00:00:00','15:05:00','16:00:00','Zénith de Montpellier'),(20,15,10,'2011-11-19 00:00:00','20:00:00','22:00:00','Zénith de Montpellier'),(21,30,13,'2011-09-06 00:00:00','20:00:00','21:30:00','Le TNT - Nantes'),(22,14,13,'2011-09-09 00:00:00','20:00:00','22:00:00','Zénith de Nantes'),(23,28,15,'2011-09-18 00:00:00','20:00:00','22:00:00','Parc des Expos - St-Etienne'),(24,15,15,'2011-09-24 00:00:00','21:30:00','23:00:00','Zénith de Saint-Etienne'),(26,15,16,'2011-09-25 00:00:00','21:30:00','22:00:00','Zénith de Saint-Etienne');
/*!40000 ALTER TABLE `passage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pays`
--

DROP TABLE IF EXISTS `pays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pays` (
  `PAY_ID` int NOT NULL AUTO_INCREMENT,
  `PAY_NOM` char(20) NOT NULL,
  PRIMARY KEY (`PAY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pays`
--

LOCK TABLES `pays` WRITE;
/*!40000 ALTER TABLE `pays` DISABLE KEYS */;
INSERT INTO `pays` VALUES (1,'France'),(2,'Belgique'),(3,'Italie'),(4,'Suède'),(5,'Pologne'),(6,'Suède'),(7,'Norvège'),(8,'Allemagne'),(9,'Espagne'),(10,'Portugal'),(11,'Royaume-Uni'),(12,'Autriche'),(13,'Pays-Bas');
/*!40000 ALTER TABLE `pays` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodicite`
--

DROP TABLE IF EXISTS `periodicite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodicite` (
  `PERI_ID` int NOT NULL AUTO_INCREMENT,
  `PERI_NOM` char(20) NOT NULL,
  PRIMARY KEY (`PERI_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodicite`
--

LOCK TABLES `periodicite` WRITE;
/*!40000 ALTER TABLE `periodicite` DISABLE KEYS */;
INSERT INTO `periodicite` VALUES (1,'Unique'),(2,'Quotidienne'),(3,'Lundi-Vendredi'),(4,'Week-end'),(5,'Hebdomadaire'),(6,'Mensuelle'),(7,'Bimensuelle'),(8,'Trimestrielle'),(9,'Semestrielle'),(10,'Annuelle'),(11,'Biennale'),(12,'tria-nnuel'),(13,'quadri-annuel'),(14,'quinquennal');
/*!40000 ALTER TABLE `periodicite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personne`
--

DROP TABLE IF EXISTS `personne`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personne` (
  `PER_ID` int NOT NULL AUTO_INCREMENT,
  `CIV_ID` int NOT NULL,
  `PER_NOM` char(20) NOT NULL,
  `PER_PRENOM` char(20) NOT NULL,
  `PER_ADR` char(50) DEFAULT NULL,
  `PER_CP` int DEFAULT NULL,
  `PER_VILLE` char(20) DEFAULT NULL,
  `PER_TEL` int DEFAULT NULL,
  `PER_FAX` int DEFAULT NULL,
  `PER_EMAIL` char(50) DEFAULT NULL,
  `PER_DATENAISSANCE` datetime DEFAULT NULL,
  PRIMARY KEY (`PER_ID`),
  KEY `FK_CIVIL` (`CIV_ID`),
  CONSTRAINT `FK_CIVIL` FOREIGN KEY (`CIV_ID`) REFERENCES `civilite` (`CIV_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personne`
--

LOCK TABLES `personne` WRITE;
/*!40000 ALTER TABLE `personne` DISABLE KEYS */;
INSERT INTO `personne` VALUES (1,1,'ARISTOTE','JEAN FRANCOIS','19 RUE GENERAL LECLERC',78300,'POISSY',NULL,NULL,'jf.aristote@hotmail.fr','1962-06-19 00:00:00'),(2,1,'BALLY','PHILIPPE','3 RUE DES NOISETTES',33000,'BORDEAUX',NULL,NULL,'','1981-05-15 00:00:00'),(3,1,'DURAND','PIERRE','',54500,'VANDOEUVRE',NULL,NULL,'p.durand@gmail.com','1964-10-22 00:00:00'),(4,2,'GARCIA','LAURENCE','78 RUE DU CANTALOUP',41000,'BLOIS',NULL,NULL,'','1959-07-04 00:00:00'),(5,2,'GIRAUDIER','VALERIE','19 AV ROUGE BORDEAUX',63000,'CLERMONT FERRAND',NULL,NULL,'','1991-07-01 00:00:00'),(6,1,'BARDI','HENRY','15 CHEMIN DE CROIX',92000,'NANTERRE',NULL,NULL,'h.bardin@gmail.com','1955-06-27 00:00:00'),(7,1,'LOUMAIGNE','PIERRE','',73000,'CHAMBERRY',NULL,NULL,'','1972-08-15 00:00:00'),(8,1,'MOULIADE','LOUIS','11 RUE DE LA FONTAINE',83600,'FREJUS',NULL,NULL,'','1970-04-29 00:00:00'),(9,1,'PAGNON','MICHEL','99 PLACE DE LA LANCE',94120,'FONTENAY SOUS BOIS',NULL,NULL,'','1964-06-01 00:00:00'),(10,3,'RAYNAUD','SYLVIE','54 PLACE DE L\'ÉTÉ VERT',95130,'FRANCONVILLE',NULL,NULL,'','1953-01-28 00:00:00'),(11,1,'BIJOUMAT','SYLVAI','54 ALLEE DES FLEURS',92500,'RUEIL MALMAISO',NULL,NULL,'s.bijoumat@yahoo.fr','1950-08-09 00:00:00'),(12,1,'AURY','STEVE','118 AV DE POISSY',59300,'VALENCIENNE',NULL,NULL,'','1974-04-28 00:00:00'),(13,3,'HABER','SONIA','19 RUE DE LA ROQUETTE',13127,'VITROLLES',NULL,NULL,'','1980-08-25 00:00:00'),(14,2,'MILLET','FRANCOISE','',38200,'VIENNES',NULL,NULL,'','1969-02-11 00:00:00'),(15,1,'BELISTOT','NICOLAS','112 AV DE LA VERRIERE',95100,'ARGENTEUIL',NULL,NULL,'n.belistot@free.fr','1949-03-22 00:00:00'),(16,3,'PAILLETTE','MAUDE','56 AV DE LA FORTUNE',54000,'NANCY',NULL,NULL,'','1967-11-01 00:00:00'),(17,2,'SOLHEID','JOSIANE','12 RUE OPPORTUNITE',57000,'METZ',NULL,NULL,'j.solheid@gmail.com','1971-09-18 00:00:00'),(18,1,'KLERSY','KARIM','45 RUE DE LA MEDITERRANEE',66000,'PERPIGNA',NULL,NULL,'','1972-09-08 00:00:00'),(19,1,'FOURNIE','YVES','13 RUE DE L\'ECHO',59500,'DOUAI',NULL,NULL,'','1966-03-10 00:00:00'),(20,1,'ALBERTO','RENE','15 RUE DU MOULI',78500,'SARTROUVILLE',NULL,NULL,'r.alberto@hotmail.fr','1970-07-12 00:00:00'),(21,1,'CARL','ZIDANE','12 RUE DE L\'ABREUVOIR',83600,'FREJUS',NULL,NULL,'','1965-01-04 00:00:00'),(22,1,'MEDINA','MOKHTAR','119 RUE DU FAUCO',57600,'FORBACH',NULL,NULL,'','1955-04-12 00:00:00'),(23,3,'HADDAD','LAETITIA','14 AV FLANDRE',91620,'JUVISY SUR ORGE',NULL,NULL,'','1949-08-18 00:00:00'),(24,1,'FONDEVILLE','FRANCOIS','89 RUE DE L\'ARMEE',25000,'BESANCO',NULL,NULL,'f.fondeville@gmail.com','1960-09-27 00:00:00'),(25,1,'OUAISSA','AMAR','59 RUE DE LA PROVINCE',17500,'JONZAC',NULL,NULL,'','1961-04-07 00:00:00'),(26,1,'COSTES','CHRISTIA','235 AV DE L\'ESPOIR',37300,'JOUE LES TOURS',NULL,NULL,'','1984-03-06 00:00:00'),(27,2,'AUBERT','SOPHIE','5 RUE DU FIL ROUGE',49000,'ANGERS',NULL,NULL,'','1971-06-28 00:00:00'),(28,2,'BAZZARA','AURORE','',13080,'AIX EN PROVENCE',NULL,NULL,'','1964-03-18 00:00:00'),(29,1,'AZERTY','MICHEL','',75012,'PARIS',NULL,NULL,'m.azerty@free.fr','1977-02-23 00:00:00'),(30,1,'MARINOT','ANTOINE','',75008,'PARIS',NULL,NULL,'','1963-05-08 00:00:00'),(31,2,'CANTI','JEANINE','256 ALLEE DES OISEAUX',65000,'TARBES',NULL,NULL,'j.cantin@msn.com','1971-11-23 00:00:00'),(32,1,'NGUYE','MICHEL','10 AV DE LA LIBERTE',NULL,'MARSEILLE',NULL,NULL,'','1967-12-23 00:00:00'),(33,3,'PARKER','LAURA','',54520,'LAXOU',NULL,NULL,'','1964-03-30 00:00:00'),(34,1,'RODOMISTO','CHRISTOPHE','76 RUE FROUARD',38000,'GRENOBLE',NULL,NULL,'','1972-10-27 00:00:00'),(35,2,'AUGUSTIN','MELANIE','',54390,'FROUARD',NULL,NULL,'','1963-06-09 00:00:00'),(36,1,'BANOU','FRANCK','13 AV DE LA SPHERE',97200,'FORT DE France',NULL,NULL,'f.banoun@free.fr','1975-07-17 00:00:00'),(37,1,'TCHANA','PATRICK','19 RUE DE L ALTITUDE',17200,'ROYA',NULL,NULL,'p.tchana@gmail.com','1982-07-14 00:00:00'),(38,3,'CONNER','ALISO','',33450,'MONTUSA',NULL,NULL,'','2000-01-01 00:00:00'),(39,1,'DAVID','FELIX','',NULL,'',NULL,NULL,'','1948-12-27 00:00:00'),(40,2,'BENSOUSS','JULIE','',97224,'DUCOS',NULL,NULL,'','1974-11-26 00:00:00'),(41,2,'BRETANI','MARIE','56 RUE DE LA LORRAINE',13004,'MARSEILLE',NULL,NULL,'m.bretanie@gmail.com','1953-02-17 00:00:00'),(42,1,'MAILLARD','ARNAUD','100 RUE DU TILLEUL',37500,'CHINO',NULL,NULL,'','1960-08-07 00:00:00'),(43,2,'DUBRULLE','JULIETTE','13 RUE RENARD',NULL,'',NULL,NULL,'','1974-06-22 00:00:00'),(44,1,'LE DUFF','ISAAC','7 AV GENERAL DE GAULLE',NULL,'',NULL,NULL,'','1980-03-27 00:00:00'),(45,3,'MEYNARD','JESSICA','',NULL,'',NULL,NULL,'','1971-02-03 00:00:00'),(46,2,'HUC','ELISABETH','13 AV DE LA GRANDE ARMEE',75019,'PARIS',NULL,NULL,'e.huc@free.fr','1970-01-09 00:00:00'),(47,3,'LAURENCE','PEGGY','',17500,'JONZAC',NULL,NULL,'','1972-10-29 00:00:00'),(48,1,'GARCI','YOA','',NULL,'',NULL,NULL,'','1965-01-05 00:00:00'),(49,1,'IDTALEB','ISMAEL','115 RUE CHATEAU NEUF',NULL,'',NULL,NULL,'','1982-02-15 00:00:00'),(50,2,'JAMET','FRANCINE','',66600,'PERILLOS',NULL,NULL,'','1977-07-31 00:00:00'),(51,1,'MAOUET','YVES','',13009,'MARSEILLE',NULL,NULL,'y.maouet@yahoo.fr','1966-08-14 00:00:00');
/*!40000 ALTER TABLE `personne` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profil`
--

DROP TABLE IF EXISTS `profil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profil` (
  `PRO_ID` int NOT NULL AUTO_INCREMENT,
  `PRO_TYPE` char(20) NOT NULL,
  PRIMARY KEY (`PRO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profil`
--

LOCK TABLES `profil` WRITE;
/*!40000 ALTER TABLE `profil` DISABLE KEYS */;
INSERT INTO `profil` VALUES (1,'Administrateur'),(2,'Utilisateur'),(3,'Consultations');
/*!40000 ALTER TABLE `profil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `region` (
  `REG_ID` int NOT NULL AUTO_INCREMENT,
  `PAY_ID` int NOT NULL,
  `REG_NOM` char(30) NOT NULL,
  PRIMARY KEY (`REG_ID`),
  KEY `FK_SETROUVER` (`PAY_ID`),
  CONSTRAINT `FK_SETROUVER` FOREIGN KEY (`PAY_ID`) REFERENCES `pays` (`PAY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES (1,11,'Midlands de l\'Ouest'),(2,11,'Yorkshire et Humber'),(3,8,'Bade-Wurtemberg'),(4,8,'Basse-Saxe'),(5,8,'Bavière'),(6,8,'Berlin'),(7,8,'Brandebourg'),(8,8,'Brême'),(9,8,'Hambourg'),(10,8,'Hesse'),(13,8,'Rhénanie-Palatinat'),(14,8,'Sarre'),(15,8,'Saxe'),(16,8,'Schleswig-Holstein'),(17,8,'Thuringe'),(18,12,'Autriche de l\'Est'),(19,12,'Autriche du Sud'),(20,12,'Autriche de l\'Ouest'),(21,13,'Nord'),(22,13,'Est'),(23,13,'Ouest'),(24,13,'Sud'),(25,1,'Grand-Est'),(26,1,'Bretagne'),(27,1,'Ile-de-France'),(28,1,'Occitanie'),(29,1,'Basse-Normandie'),(30,1,'Provence-Alpes-Côte d\'Azur'),(31,1,'Auvergne-Rhône-Alpes'),(32,1,'Normandie'),(33,1,'Pays de la Loire');
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rencontre`
--

DROP TABLE IF EXISTS `rencontre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rencontre` (
  `REN_ID` int NOT NULL AUTO_INCREMENT,
  `PERI_ID` int NOT NULL,
  `PER_ID` int NOT NULL,
  `REG_ID` int NOT NULL,
  `REN_NOM` char(20) NOT NULL,
  `REN_LIEU` char(20) NOT NULL,
  `REN_DATEDEBUT` datetime NOT NULL,
  `REN_DATEFIN` datetime NOT NULL,
  `REN_NBPERS` int NOT NULL,
  PRIMARY KEY (`REN_ID`),
  KEY `FK_ORGANISER` (`PER_ID`),
  KEY `FK_SEDEROULER` (`PERI_ID`),
  KEY `FK_SESITUER` (`REG_ID`),
  CONSTRAINT `FK_ORGANISER` FOREIGN KEY (`PER_ID`) REFERENCES `personne` (`PER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_SEDEROULER` FOREIGN KEY (`PERI_ID`) REFERENCES `periodicite` (`PERI_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_SESITUER` FOREIGN KEY (`REG_ID`) REFERENCES `region` (`REG_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rencontre`
--

LOCK TABLES `rencontre` WRITE;
/*!40000 ALTER TABLE `rencontre` DISABLE KEYS */;
INSERT INTO `rencontre` VALUES (1,6,1,25,'CANAL SOLEIL','NANCY','2011-02-14 14:00:00','2011-02-17 23:59:00',1500),(2,10,6,26,'VIEILLES CHARRUES','BREST','2011-12-12 20:00:00','2011-12-15 22:00:00',2200),(3,11,11,27,'LES MUZIKELLES','PARIS','2011-06-10 14:00:00','2011-06-14 22:00:00',35000),(4,10,11,28,'REGGAE FESTIVALES','NARBONNE','2011-08-05 20:30:00','2011-08-07 00:00:00',3000),(5,10,15,25,'JA\'SOUND','METZ','2011-01-02 00:00:00','2011-01-06 00:00:00',4500),(6,8,17,29,'VOULSTOCK','CAEN','2011-04-19 00:00:00','2011-04-22 00:00:00',18000),(7,11,20,30,'FIEST\'A SETE','NICE','2011-05-05 00:00:00','2011-05-07 00:00:00',25000),(8,5,24,31,'ENFERMES DEHORS','GRENOBLE','2011-03-26 00:00:00','2011-03-29 00:00:00',7000),(9,6,31,28,'NUIT DE NACRE','TOULOUSE','2011-05-21 00:00:00','2011-05-23 00:00:00',11000),(10,10,31,28,'TRAD HIVERNALES','MONTPELLIER','2011-11-16 15:05:00','2011-11-19 22:00:00',5000),(11,11,36,30,'CAP FESTIVAL','MARSEILLE','2011-06-01 00:00:00','2011-06-04 00:00:00',6000),(12,7,37,32,'MOISSON ROCK','CHERBOURG','2011-10-22 00:00:00','2011-10-27 00:00:00',30000),(13,10,41,33,'SCOPITONE','NANTES','2011-09-06 20:00:00','2011-09-09 22:00:00',10000),(14,9,46,31,'PANTIERO','LYON','2011-12-01 00:00:00','2011-12-04 00:00:00',8000),(15,8,17,31,'SALSA','SAINT ETIENNE','2011-09-18 20:00:00','2011-09-24 23:00:00',20000),(16,8,17,31,'Irlande','SAINT ETIENNE','2011-09-25 21:30:00','2011-09-25 23:00:00',20000);
/*!40000 ALTER TABLE `rencontre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repertoire`
--

DROP TABLE IF EXISTS `repertoire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `repertoire` (
  `CHA_ID` int NOT NULL,
  `GRO_ID` int NOT NULL,
  PRIMARY KEY (`CHA_ID`,`GRO_ID`),
  KEY `FK_REPERTOIRE2` (`GRO_ID`),
  CONSTRAINT `FK_REPERTOIRE` FOREIGN KEY (`CHA_ID`) REFERENCES `chanson` (`CHA_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_REPERTOIRE2` FOREIGN KEY (`GRO_ID`) REFERENCES `groupe` (`GRO_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repertoire`
--

LOCK TABLES `repertoire` WRITE;
/*!40000 ALTER TABLE `repertoire` DISABLE KEYS */;
INSERT INTO `repertoire` VALUES (3,3),(10,3),(1,4),(10,4),(24,4),(6,5),(16,5),(7,6),(9,6),(1,7),(7,8),(12,8),(4,9),(8,9),(7,10),(3,11),(22,11),(5,12),(7,12),(13,12),(13,13),(14,13),(9,14),(18,14),(12,15),(21,15),(5,16),(23,16),(9,17),(15,18),(16,18),(18,19),(16,20),(17,21),(19,22),(21,22),(25,22),(1,23),(6,23),(11,23),(19,23),(20,24),(24,24),(11,25),(12,26),(13,27),(14,28),(15,29),(16,30);
/*!40000 ALTER TABLE `repertoire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `representation`
--

DROP TABLE IF EXISTS `representation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `representation` (
  `REP_ID` int NOT NULL AUTO_INCREMENT,
  `PAS_ID` int NOT NULL,
  `CHA_ID` int NOT NULL,
  `REP_TEMPS` time NOT NULL,
  PRIMARY KEY (`REP_ID`),
  KEY `FK_IDENTIFIER` (`PAS_ID`),
  KEY `FK_PRODUIT` (`CHA_ID`),
  CONSTRAINT `FK_IDENTIFIER` FOREIGN KEY (`PAS_ID`) REFERENCES `passage` (`PAS_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_PRODUIT` FOREIGN KEY (`CHA_ID`) REFERENCES `chanson` (`CHA_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `representation`
--

LOCK TABLES `representation` WRITE;
/*!40000 ALTER TABLE `representation` DISABLE KEYS */;
INSERT INTO `representation` VALUES (1,1,18,'00:04:10'),(2,2,16,'00:11:40'),(3,3,4,'00:03:30'),(4,4,16,'00:11:40'),(5,5,15,'00:02:14'),(6,6,13,'00:03:30'),(7,7,9,'00:02:10'),(8,8,9,'00:02:10'),(9,9,9,'00:02:10'),(10,10,6,'00:05:00'),(11,11,9,'00:02:10'),(12,12,1,'00:05:00'),(13,13,5,'00:06:30'),(14,14,23,'00:07:00'),(15,15,23,'00:07:00'),(16,16,17,'00:06:06'),(17,17,21,'00:01:50'),(18,18,18,'00:04:10'),(19,19,23,'00:07:00'),(20,20,21,'00:01:50'),(21,21,16,'00:02:20'),(22,22,18,'00:04:10'),(23,23,13,'00:03:40'),(24,24,12,'00:03:10'),(25,25,18,'00:04:10'),(26,26,16,'00:11:40'),(27,27,20,'00:05:20'),(28,28,19,'00:04:20'),(29,29,1,'00:05:00'),(30,30,1,'00:05:00'),(31,31,2,'00:03:20'),(32,32,7,'00:15:00');
/*!40000 ALTER TABLE `representation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `representer`
--

DROP TABLE IF EXISTS `representer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `representer` (
  `REG_ID` int NOT NULL,
  `GRO_ID` int NOT NULL,
  PRIMARY KEY (`REG_ID`,`GRO_ID`),
  KEY `FK_REPRESENTER3` (`GRO_ID`),
  CONSTRAINT `FK_REPRESENTER` FOREIGN KEY (`REG_ID`) REFERENCES `region` (`REG_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_REPRESENTER3` FOREIGN KEY (`GRO_ID`) REFERENCES `groupe` (`GRO_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `representer`
--

LOCK TABLES `representer` WRITE;
/*!40000 ALTER TABLE `representer` DISABLE KEYS */;
INSERT INTO `representer` VALUES (5,3),(1,4),(2,4),(7,4),(2,5),(13,5),(3,6),(10,6),(13,8),(7,9),(22,9),(1,10),(9,10),(14,14),(16,15),(7,16),(18,19),(24,19),(19,20),(4,21),(6,22),(14,22),(1,23),(8,24),(5,25);
/*!40000 ALTER TABLE `representer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsabilite`
--

DROP TABLE IF EXISTS `responsabilite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `responsabilite` (
  `RES_ID` int NOT NULL AUTO_INCREMENT,
  `RES_NOM` char(20) NOT NULL,
  PRIMARY KEY (`RES_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsabilite`
--

LOCK TABLES `responsabilite` WRITE;
/*!40000 ALTER TABLE `responsabilite` DISABLE KEYS */;
INSERT INTO `responsabilite` VALUES (1,'Chauffeur'),(2,'Eclairagiste'),(3,'Manutentionnaire'),(4,'Trésorier'),(5,'Habilleur'),(6,'Maquilleur'),(7,'Groupie'),(8,'Coach'),(9,'Intendant'),(10,'Ingénieur so'),(11,'Eclairagiste'),(12,'Secrétaire'),(13,'Chorégraphe'),(14,'Scénographe'),(15,'Cuisinier');
/*!40000 ALTER TABLE `responsabilite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialiser`
--

DROP TABLE IF EXISTS `specialiser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specialiser` (
  `SPE_ID` int NOT NULL,
  `PER_ID` int NOT NULL,
  `REN_ID` int NOT NULL,
  PRIMARY KEY (`PER_ID`,`SPE_ID`,`REN_ID`),
  KEY `FK_SPECIALISER` (`SPE_ID`),
  KEY `FK_SPECIALISER3` (`REN_ID`),
  CONSTRAINT `FK_SPECIALISER` FOREIGN KEY (`SPE_ID`) REFERENCES `specialite` (`SPE_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_SPECIALISER2` FOREIGN KEY (`PER_ID`) REFERENCES `personne` (`PER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_SPECIALISER3` FOREIGN KEY (`REN_ID`) REFERENCES `rencontre` (`REN_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialiser`
--

LOCK TABLES `specialiser` WRITE;
/*!40000 ALTER TABLE `specialiser` DISABLE KEYS */;
INSERT INTO `specialiser` VALUES (1,2,4),(1,3,1),(1,5,5),(1,7,10),(1,10,11),(1,19,11),(1,20,13),(1,27,11),(1,28,9),(1,31,14),(1,41,13),(1,45,6),(2,3,2),(2,10,13),(2,11,5),(2,11,10),(2,19,9),(2,25,7),(2,29,9),(2,30,11),(2,30,15),(2,31,4),(2,31,6);
/*!40000 ALTER TABLE `specialiser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialite`
--

DROP TABLE IF EXISTS `specialite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specialite` (
  `SPE_ID` int NOT NULL AUTO_INCREMENT,
  `SPE_NOM` char(20) DEFAULT NULL,
  PRIMARY KEY (`SPE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialite`
--

LOCK TABLES `specialite` WRITE;
/*!40000 ALTER TABLE `specialite` DISABLE KEYS */;
INSERT INTO `specialite` VALUES (1,'soliste'),(2,'choriste'),(3,'musicien');
/*!40000 ALTER TABLE `specialite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typeoeuvre`
--

DROP TABLE IF EXISTS `typeoeuvre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typeoeuvre` (
  `TYPO_ID` int NOT NULL AUTO_INCREMENT,
  `TYPO_NOM` char(20) NOT NULL,
  PRIMARY KEY (`TYPO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typeoeuvre`
--

LOCK TABLES `typeoeuvre` WRITE;
/*!40000 ALTER TABLE `typeoeuvre` DISABLE KEYS */;
INSERT INTO `typeoeuvre` VALUES (1,'Pop'),(2,'Rock'),(3,'Classique'),(4,'RnB'),(5,'Reggea'),(6,'Metal'),(7,'Variete'),(8,'Punk'),(9,'Eletro');
/*!40000 ALTER TABLE `typeoeuvre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typeoeuvre_supprime`
--

DROP TABLE IF EXISTS `typeoeuvre_supprime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typeoeuvre_supprime` (
  `TYPO_ID` int NOT NULL AUTO_INCREMENT,
  `TYPO_NOM` char(20) NOT NULL,
  `DATE_SUPPRESSION` date DEFAULT NULL,
  PRIMARY KEY (`TYPO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typeoeuvre_supprime`
--

LOCK TABLES `typeoeuvre_supprime` WRITE;
/*!40000 ALTER TABLE `typeoeuvre_supprime` DISABLE KEYS */;
/*!40000 ALTER TABLE `typeoeuvre_supprime` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-23 12:08:09
