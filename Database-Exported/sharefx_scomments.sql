-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sharefx
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `scomments`
--

DROP TABLE IF EXISTS `scomments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scomments` (
  `uid` int DEFAULT NULL,
  `username` varchar(15) DEFAULT NULL,
  `sid` int DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  KEY `uid` (`uid`),
  KEY `username` (`username`),
  KEY `sid` (`sid`),
  CONSTRAINT `scomments_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`),
  CONSTRAINT `scomments_ibfk_2` FOREIGN KEY (`username`) REFERENCES `username` (`username`),
  CONSTRAINT `scomments_ibfk_3` FOREIGN KEY (`sid`) REFERENCES `skill` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scomments`
--

LOCK TABLES `scomments` WRITE;
/*!40000 ALTER TABLE `scomments` DISABLE KEYS */;
INSERT INTO `scomments` VALUES (2,'Ajay',1,'Interested! Can I join?'),(1,'Arjun',2,'Very helpful. Thank you. Have messaged you'),(2,'Ajay',3,'Just adding to the above Post.. It would be on weekends.'),(1,'Arjun',3,'Oh Cool! Have messaged you'),(2,'Ajay',4,'Oh That\'s Great! I am interested.'),(1,'Arjun',5,'Adding to the above post.. This would be on the weekends');
/*!40000 ALTER TABLE `scomments` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-19  0:29:45
