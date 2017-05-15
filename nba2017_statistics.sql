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
-- Table structure for table `statistics`
--

DROP TABLE IF EXISTS `statistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statistics` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(45) NOT NULL DEFAULT 'null',
  `points` int(11) NOT NULL DEFAULT '0',
  `fieldGoalAttemptted` int(11) NOT NULL DEFAULT '0',
  `fieldGoalMade` int(11) NOT NULL DEFAULT '0',
  `fieldGoalPercentage` int(11) NOT NULL DEFAULT '0',
  `3pointsAttemptted` int(11) NOT NULL DEFAULT '0',
  `3pointsMade` int(11) NOT NULL DEFAULT '0',
  `3pointsPercentage` int(11) NOT NULL,
  `freeThrowAttemptted` int(11) NOT NULL DEFAULT '0',
  `freeThrowMade` int(11) NOT NULL DEFAULT '0',
  `freeThrowPercentage` int(11) NOT NULL DEFAULT '0',
  `rebounds` int(11) NOT NULL DEFAULT '0',
  `assists` int(11) NOT NULL,
  `steals` int(11) NOT NULL DEFAULT '0',
  `turnovers` int(11) NOT NULL DEFAULT '0',
  `partOf` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `partOf_idx` (`partOf`),
  CONSTRAINT `partOfPlaryer` FOREIGN KEY (`partOf`) REFERENCES `player` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statistics`
--

LOCK TABLES `statistics` WRITE;
/*!40000 ALTER TABLE `statistics` DISABLE KEYS */;
INSERT INTO `statistics` VALUES (1,'P.Millsap',0,0,0,0,0,0,0,0,0,0,0,0,0,0,1),(2,'D.Howard',0,0,0,0,0,0,0,0,0,0,0,0,0,0,1),(3,'D.Schroder',0,0,0,0,0,0,0,0,0,0,0,0,0,0,1),(4,'K.Bazemore',0,0,0,0,0,0,0,0,0,0,0,0,0,0,1),(5,'M.Scott',0,0,0,0,0,0,0,0,0,0,0,0,0,0,1),(6,'T.Splitter',0,0,0,0,0,0,0,0,0,0,0,0,0,0,1),(7,'T.Hardaway Jr.',0,0,0,0,0,0,0,0,0,0,0,0,0,0,1),(8,'T.Sefolosha',0,0,0,0,0,0,0,0,0,0,0,0,0,0,1),(9,'K.Humphries',0,0,0,0,0,0,0,0,0,0,0,0,0,0,1),(10,'J.Jack',0,0,0,0,0,0,0,0,0,0,0,0,0,0,1),(13,'A.Bradley',46,22,13,0,12,9,78,16,11,0,6,6,1,1,2),(14,'G.Green',0,0,0,0,0,0,0,0,0,0,0,0,0,0,2),(15,'J.Brown',0,0,0,0,0,0,0,0,0,0,0,0,0,0,2),(16,'J.Crowder',13,3,0,0,1,0,67,15,13,0,5,5,2,0,2),(17,'I.Thomas',25,24,10,0,5,3,76,3,2,0,6,5,0,0,2),(18,'M.Smart',0,0,0,0,0,0,0,0,0,0,0,0,0,0,2),(19,'A.Johnson',27,13,9,0,0,0,47,14,9,0,11,1,1,3,2),(20,'J.Jerebko',0,0,0,0,0,0,0,0,0,0,0,0,0,0,2),(21,'A.Horford',27,23,13,0,2,1,69,0,0,0,4,7,1,0,2),(22,'K.Olynyk',0,0,0,0,0,0,0,0,0,0,0,0,0,0,2),(23,'T.Zeller',0,0,0,0,0,0,0,0,0,0,0,0,0,0,2),(25,'S.Kilpatrick',0,0,0,0,0,0,0,0,0,0,0,0,0,0,3),(26,'R.Foye',0,0,0,0,0,0,0,0,0,0,0,0,0,0,3),(27,'R.Hollis-J',0,0,0,0,0,0,0,0,0,0,0,0,0,0,3),(28,'B.Bogdanovic',0,0,0,0,0,0,0,0,0,0,0,0,0,0,3),(29,'J.Lin',0,0,0,0,0,0,0,0,0,0,0,0,0,0,3),(30,'I.Whitehead',0,0,0,0,0,0,0,0,0,0,0,0,0,0,3),(31,'G.Vasquez',0,0,0,0,0,0,0,0,0,0,0,0,0,0,3),(32,'T.Booker',0,0,0,0,0,0,0,0,0,0,0,0,0,0,3),(33,'A.Bennett',0,0,0,0,0,0,0,0,0,0,0,0,0,0,3),(34,'L.Scola',0,0,0,0,0,0,0,0,0,0,0,0,0,0,3),(35,'J.Hamilton',0,0,0,0,0,0,0,0,0,0,0,0,0,0,3),(36,'B.Lopez',0,0,0,0,0,0,0,0,0,0,0,0,0,0,3),(37,'J.Lamb',0,0,0,0,0,0,0,0,0,0,0,0,0,0,4),(38,'M.Belinelli',0,0,0,0,0,0,0,0,0,0,0,0,0,0,4),(39,'A.Harrison',0,0,0,0,0,0,0,0,0,0,0,0,0,0,4),(40,'N.Batum',0,0,0,0,0,0,0,0,0,0,0,0,0,0,4),(41,'M.Kidd-G',0,0,0,0,0,0,0,0,0,0,0,0,0,0,4),(42,'K.Walker',0,0,0,0,0,0,0,0,0,0,0,0,0,0,4),(43,'R.Sessions',0,0,0,0,0,0,0,0,0,0,0,0,0,0,4),(44,'M.Williams',0,0,0,0,0,0,0,0,0,0,0,0,0,0,4),(45,'F.Kaminsky',0,0,0,0,0,0,0,0,0,0,0,0,0,0,4),(46,'C.Zeller',0,0,0,0,0,0,0,0,0,0,0,0,0,0,4),(47,'S.Hawes',0,0,0,0,0,0,0,0,0,0,0,0,0,0,4),(48,'R.Hibbert',0,0,0,0,0,0,0,0,0,0,0,0,0,0,4),(49,'J.Butler',28,16,11,0,0,0,70,8,6,0,2,3,0,2,5),(50,'D.Wade',23,13,9,0,0,0,72,7,5,0,5,9,1,1,5),(51,'I.Canaan',0,0,0,0,0,0,0,0,0,0,0,0,0,0,5),(52,'D.McDermott',0,0,0,0,0,0,0,0,0,0,0,0,0,0,5),(53,'D.Valentine',0,0,0,0,0,0,0,0,0,0,0,0,0,0,5),(54,'R.Rando',23,12,7,0,0,0,62,14,9,0,2,7,0,0,5),(55,'J.Grant',0,0,0,0,0,0,0,0,0,0,0,0,0,0,5),(56,'N.Mirotic',41,25,16,0,7,4,59,6,5,0,3,0,3,1,5),(57,'B.Portis',0,0,0,0,0,0,0,0,0,0,0,0,0,0,5),(58,'C.Felicio',0,0,0,0,0,0,0,0,0,0,0,0,0,0,5),(59,'R.Lopez',17,6,3,0,0,0,62,16,11,0,7,6,0,1,5);
/*!40000 ALTER TABLE `statistics` ENABLE KEYS */;
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
