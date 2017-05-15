-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: nba2017
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `number` int(11) NOT NULL,
  `position` enum('C','PF','SF','SG','PG') NOT NULL,
  `shotClose` int(11) NOT NULL,
  `shotThree` int(11) NOT NULL,
  `ballControl` int(11) NOT NULL,
  `drawFoul` int(11) NOT NULL,
  `freeThrow` int(11) NOT NULL,
  `pass` int(11) NOT NULL,
  `attackConsistency` int(11) NOT NULL,
  `steal` int(11) NOT NULL,
  `shotContest` int(11) NOT NULL,
  `defenceConsistency` int(11) NOT NULL,
  `rebound` int(11) NOT NULL,
  `fatigue` int(11) NOT NULL,
  `morale` int(11) NOT NULL,
  `partOf` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `partOf_idx` (`partOf`),
  CONSTRAINT `partOf` FOREIGN KEY (`partOf`) REFERENCES `team` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='					';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` VALUES (1,'P.Millsap',4,'PF',71,57,57,66,69,57,68,72,61,88,67,89,50,1),(2,'D.Howard',8,'C',69,37,33,75,42,33,58,54,73,73,75,90,50,1),(3,'D.Schroder',17,'PG',48,69,80,67,75,76,66,63,60,56,34,93,50,1),(4,'K.Bazemore',24,'SF',51,63,67,55,76,58,69,65,56,69,48,88,50,1),(5,'M.Scott',32,'PF',66,60,41,55,76,38,62,55,56,47,59,81,50,1),(6,'T.Splitter',11,'C',61,42,30,65,76,33,40,58,71,60,60,77,50,1),(7,'T.Hardaway Jr.',10,'SG',54,63,72,62,83,65,41,55,51,38,31,81,50,1),(8,'T.Sefolosha',25,'SG',55,54,63,70,58,46,25,68,75,65,48,88,50,1),(9,'K.Humphries',43,'PF',58,58,36,62,76,37,56,53,61,46,70,80,50,1),(10,'J.Jack',3,'PG',50,76,76,63,88,76,64,62,61,39,40,85,50,1),(13,'A.Bradley',0,'SG',49,70,72,40,73,56,80,64,77,90,31,85,50,2),(14,'G.Green',5,'SG',61,62,71,60,72,47,40,55,59,40,38,85,50,2),(15,'J.Brown',7,'SF',60,50,70,67,62,67,32,58,71,52,52,77,50,2),(16,'J.Crowder',99,'SF',58,68,71,58,78,59,58,75,58,81,49,93,50,2),(17,'I.Thomas',4,'PG',50,76,85,83,81,83,89,57,54,54,31,98,75,2),(18,'M.Smart',36,'PG',52,62,77,54,74,68,46,75,68,71,48,84,50,2),(19,'A.Johnson',90,'PF',65,50,35,53,54,42,62,58,77,67,72,83,50,2),(20,'J.Jerebko',8,'PF',63,57,58,47,74,46,66,52,56,46,62,80,50,2),(21,'A.Horford',42,'C',67,66,43,53,73,54,83,53,74,78,62,90,50,2),(22,'K.Olynyk',41,'C',63,55,37,69,70,45,75,58,74,60,59,84,50,2),(23,'T.Zeller',44,'C',60,46,30,64,76,35,55,50,56,60,67,80,50,2),(25,'S.Kilpatrick',6,'SG',55,71,65,65,86,50,62,55,45,26,35,92,50,3),(26,'R.Foye',8,'SG',51,66,74,46,79,60,57,56,57,47,33,85,50,3),(27,'R.Hollis-J',24,'SF',59,47,56,70,69,40,26,85,65,53,66,75,50,3),(28,'B.Bogdanovic',4,'SF',57,75,62,50,80,52,72,52,55,52,43,89,50,3),(29,'J.Lin',7,'PG',50,69,75,75,78,79,70,57,63,51,38,89,65,3),(30,'I.Whitehead',15,'PG',58,66,73,63,74,65,39,69,73,29,49,79,50,3),(31,'G.Vasquez',21,'PG',53,63,76,37,81,75,46,54,62,56,39,85,50,3),(32,'T.Booker',35,'PF',63,48,45,63,63,43,56,60,54,31,75,86,50,3),(33,'A.Bennett',13,'PF',67,60,52,59,75,44,30,68,48,45,65,80,50,3),(34,'L.Scola',5,'PF',64,59,33,69,69,39,66,57,65,41,67,77,50,3),(35,'J.Hamilton',41,'C',65,66,48,67,82,44,55,65,50,50,64,74,50,3),(36,'B.Lopez',11,'C',73,59,31,72,75,42,86,55,76,56,67,84,55,3),(37,'J.Lamb',3,'SG',57,69,71,62,70,64,57,60,55,47,55,80,50,4),(38,'M.Belinelli',8,'SG',52,69,68,56,79,63,61,54,56,41,30,83,50,4),(39,'A.Harrison',9,'SG',47,62,72,40,55,62,40,67,57,40,45,80,50,4),(40,'N.Batum',5,'SF',61,71,73,42,84,71,62,57,75,72,49,95,55,4),(41,'M.Kidd-G',14,'SF',60,46,70,70,67,53,27,52,79,77,66,85,50,4),(42,'K.Walker',15,'PG',52,78,82,81,79,79,92,63,69,64,40,93,60,4),(43,'R.Sessions',7,'PG',49,67,75,71,72,75,61,56,59,51,38,95,50,4),(44,'M.Williams',2,'PF',62,66,64,45,78,49,70,54,59,40,64,83,50,4),(45,'F.Kaminsky',44,'PF',58,58,47,61,66,45,58,51,52,33,53,81,50,4),(46,'C.Zeller',40,'C',63,47,34,62,68,36,64,56,62,49,67,82,50,4),(47,'S.Hawes',0,'C',59,70,34,47,80,50,67,55,62,37,64,78,50,4),(48,'R.Hibbert',55,'C',57,39,30,57,76,36,25,52,85,70,58,83,50,4),(49,'J.Butler',21,'SF',64,70,71,80,74,67,82,61,81,82,42,98,70,5),(50,'D.Wade',3,'SG',66,69,80,78,72,76,81,56,88,73,44,94,60,5),(51,'I.Canaan',0,'SG',46,70,78,57,81,69,83,59,52,43,37,80,50,5),(52,'D.McDermott',11,'SF',65,73,49,45,83,43,67,42,56,37,39,81,50,5),(53,'D.Valentine',45,'SF',52,72,72,37,79,67,57,41,39,27,46,81,50,5),(54,'R.Rando',9,'PG',70,61,81,74,54,86,56,75,74,81,74,88,55,5),(55,'J.Grant',13,'PG',49,57,75,45,73,67,45,60,58,40,36,80,50,5),(56,'N.Mirotic',44,'PF',61,63,64,74,77,53,81,59,71,76,62,85,50,5),(57,'B.Portis',5,'PF',58,57,47,60,68,42,55,53,51,35,73,80,50,5),(58,'C.Felicio',6,'C',59,34,31,62,67,35,25,53,63,31,71,75,50,5),(59,'R.Lopez',8,'C',66,50,31,58,76,38,66,41,76,71,75,80,50,5);
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-02 20:03:45
