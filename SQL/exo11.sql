CREATE DATABASE  IF NOT EXISTS `texo12` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `texo12`;
-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: exo12
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `art_num` mediumint unsigned NOT NULL AUTO_INCREMENT,
  `art_nom` text,
  `art_poids` mediumint DEFAULT NULL,
  `art_stock` mediumint DEFAULT NULL,
  `art_pa` mediumint DEFAULT NULL,
  `art_pv` mediumint DEFAULT NULL,
  `art_four` mediumint unsigned NOT NULL,
  PRIMARY KEY (`art_num`),
  KEY `FK_Four` (`art_four`),
  CONSTRAINT `FK_Four` FOREIGN KEY (`art_four`) REFERENCES `fournisseur` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'mauris,',12,22,77,7,1),(2,'odio',15,21,35,18,1),(3,'suspendisse',14,44,85,15,4),(4,'sit',19,1,4,10,5),(5,'augue',9,43,25,41,2),(6,'amet',18,5,49,68,1),(7,'et',5,10,56,66,2),(8,'pellentesque',8,17,57,26,2),(9,'arcu',7,39,91,34,3),(10,'vestibulum',14,29,39,51,4);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `clt_num` mediumint unsigned NOT NULL AUTO_INCREMENT,
  `clt_nom` varchar(255) DEFAULT NULL,
  `clt_prenom` varchar(255) DEFAULT NULL,
  `clt_pays` varchar(100) DEFAULT NULL,
  `clt_loc` varchar(255) DEFAULT NULL,
  `clt_type` text,
  PRIMARY KEY (`clt_num`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Chambers','Tobias','Barbados','Ladysmith','Habitue'),(2,'Coffey','Sylvia','Virgin Islands, United States','Kaneohe','VIP'),(3,'Gregory','Amaya','Saint Lucia','Arviat','VIP'),(4,'Nixon','Helen','Benin','Bikaner','VIP'),(5,'Rowe','Simon','Bahamas','Dannevirke','Habitue'),(6,'Hartman','Ivan','Sri Lanka','Wandsworth','Habitue'),(7,'Marquez','Kasimir','Serbia','Culiacán','VIP'),(8,'Holden','Damon','Spain','Mariupol','Habitue'),(9,'Newman','Sheila','South Sudan','Okene','VIP'),(10,'Myers','Marshall','Isle of Man','San Pedro','Habitue'),(11,'Carrillo','Kirk','Argentina','Owerri','VIP'),(12,'Becker','Dylan','Turkmenistan','Ockelbo','Habitue'),(13,'Bass','Uriel','Armenia','Bathurst','Habitue'),(14,'Thornton','Lilah','Slovenia','Steinkjer','Habitue'),(15,'Torres','Graiden','Argentina','Palma de Mallorca','Habitue'),(16,'Mcdonald','Logan','Luxembourg','Arendal','Habitue'),(17,'Bender','Vernon','French Polynesia','Joué-lès-Tours','VIP'),(18,'Bauer','Haley','Laos','Acacías','VIP'),(19,'Dalton','Driscoll','Guinea-Bissau','Jurong East','Habitue'),(20,'Merrill','Vivien','Angola','Campbellton','Habitue');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commande` (
  `cmd_num` mediumint unsigned NOT NULL AUTO_INCREMENT,
  `cmd_date` date DEFAULT NULL,
  `clt_num` mediumint unsigned NOT NULL,
  `mag_num` mediumint unsigned NOT NULL,
  PRIMARY KEY (`cmd_num`),
  KEY `FK_clt` (`clt_num`),
  KEY `FK_mag` (`mag_num`),
  CONSTRAINT `FK_clt` FOREIGN KEY (`clt_num`) REFERENCES `client` (`clt_num`),
  CONSTRAINT `FK_mag` FOREIGN KEY (`mag_num`) REFERENCES `magasin` (`mag_num`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande`
--

LOCK TABLES `commande` WRITE;
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
INSERT INTO `commande` VALUES (1,'2019-08-20',5,4),(2,'2019-06-23',2,3),(3,'2019-09-20',10,2),(4,'2019-07-13',19,3),(5,'2019-08-06',8,1),(6,'2019-07-26',13,5),(7,'2019-09-01',17,1),(8,'2019-08-21',8,4),(9,'2019-08-17',9,3),(10,'2019-09-04',6,5),(11,'2019-08-31',20,2),(12,'2019-09-28',15,3),(13,'2019-07-11',18,3),(14,'2019-08-08',18,1),(15,'2019-06-02',10,4),(16,'2019-06-20',7,3),(17,'2019-09-11',7,2),(18,'2019-06-19',7,2),(19,'2019-07-20',19,3),(20,'2019-08-25',8,2),(21,'2019-08-08',17,5),(22,'2019-06-06',20,2),(23,'2019-08-09',6,4),(24,'2019-07-13',5,5),(25,'2019-06-17',17,4),(26,'2019-06-01',1,3),(27,'2019-06-19',16,4),(28,'2019-09-05',7,3),(29,'2019-09-11',8,5),(30,'2019-09-23',12,3);
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fournisseur`
--

DROP TABLE IF EXISTS `fournisseur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fournisseur` (
  `id` mediumint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fournisseur`
--

LOCK TABLES `fournisseur` WRITE;
/*!40000 ALTER TABLE `fournisseur` DISABLE KEYS */;
INSERT INTO `fournisseur` VALUES (1,'Ginger Park'),(2,'Victor Foster'),(3,'Rigel Sparks'),(4,'Clio Walker'),(5,'Barclay Ayala');
/*!40000 ALTER TABLE `fournisseur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ligne_cmd`
--

DROP TABLE IF EXISTS `ligne_cmd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ligne_cmd` (
  `cmd_num` mediumint unsigned NOT NULL,
  `art_num` mediumint unsigned NOT NULL,
  `lcd_qte` mediumint DEFAULT NULL,
  `lcd_pu` mediumint DEFAULT NULL,
  `lcd_date_liv` date DEFAULT NULL,
  KEY `FK_cmd` (`cmd_num`),
  KEY `FK_art` (`art_num`),
  CONSTRAINT `FK_art` FOREIGN KEY (`art_num`) REFERENCES `article` (`art_num`),
  CONSTRAINT `FK_cmd` FOREIGN KEY (`cmd_num`) REFERENCES `commande` (`cmd_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ligne_cmd`
--

LOCK TABLES `ligne_cmd` WRITE;
/*!40000 ALTER TABLE `ligne_cmd` DISABLE KEYS */;
INSERT INTO `ligne_cmd` VALUES (16,4,1,999,'2019-07-20'),(3,2,3,32,'2018-11-03'),(26,4,2,429,'2018-03-20'),(20,6,2,882,'2019-05-10'),(12,7,1,563,'2018-03-25'),(5,8,2,964,'2019-08-26'),(23,8,2,344,'2018-09-10'),(29,9,2,539,'2019-01-23'),(13,7,2,174,'2019-02-02'),(20,2,2,346,'2018-09-17'),(23,2,1,806,'2017-12-12'),(26,3,3,17,'2017-11-22'),(24,3,3,647,'2018-05-02'),(6,5,1,690,'2019-05-23'),(3,5,3,889,'2018-07-27'),(10,4,2,426,'2018-08-29'),(27,9,1,431,'2017-12-25'),(13,9,3,431,'2018-05-24'),(10,7,1,301,'2019-09-03'),(21,2,2,390,'2018-09-03');
/*!40000 ALTER TABLE `ligne_cmd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `magasin`
--

DROP TABLE IF EXISTS `magasin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `magasin` (
  `mag_num` mediumint unsigned NOT NULL AUTO_INCREMENT,
  `mag_loc` varchar(255) DEFAULT NULL,
  `mag_gerant` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mag_num`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `magasin`
--

LOCK TABLES `magasin` WRITE;
/*!40000 ALTER TABLE `magasin` DISABLE KEYS */;
INSERT INTO `magasin` VALUES (1,'Beijing','Delilah Alvarado'),(2,'Invercargill','Noah Martinez'),(3,'Picton','Sonia Rowe'),(4,'Sagay','Amal Rodriguez'),(5,'Yahyalı','Madonna Foley');
/*!40000 ALTER TABLE `magasin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-06 15:03:58