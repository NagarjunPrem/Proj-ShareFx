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
-- Table structure for table `hobby`
--

DROP TABLE IF EXISTS `hobby`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hobby` (
  `uid` int DEFAULT NULL,
  `hid` int NOT NULL AUTO_INCREMENT,
  `hname` varchar(200) DEFAULT NULL,
  `hdate` date DEFAULT NULL,
  `htime` time DEFAULT NULL,
  `hinfo` varchar(999) DEFAULT NULL,
  `hlocation` varchar(50) DEFAULT NULL,
  `hcontact` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`hid`),
  KEY `uid` (`uid`),
  CONSTRAINT `hobby_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hobby`
--

LOCK TABLES `hobby` WRITE;
/*!40000 ALTER TABLE `hobby` DISABLE KEYS */;
INSERT INTO `hobby` VALUES (1,1,'Game Night','2021-04-24','22:00:00','How about a fifa game on my new PS5?','80 Brookland Street','Arjun-9028709777'),(2,2,'Movie','2021-04-25','21:00:00','Planning to watch a movie before results. Movie Suggestions Open.','101 Highland Dive','Ajay-9028709777'),(1,3,'Gardening','2021-04-02','09:00:00','Anyone interested in accompanying at my new garden?','80 Brookland Street','Arjun-9028709777'),(1,4,'Trekking','2021-04-10','10:00:00','Planning to go on for Trekking to Cape Breton Highland. Can share the accessories. Utmost 2 people can join..','80 Brookland','Arjun-9028709777'),(2,5,'Attention Book Readers!','2021-04-18','10:00:00','I have Harry Potter and the Philosopher\'s Stone. But looking for Harry Potter and the Half-Blood Prince. Anyone interested to exchange??','80 Brookland street','Ajay-9028709777'),(2,6,'Hiking','2021-04-25','10:00:00','How about Hiking - Cape Breton Highlands? Interested folks can ping me on mentioned num.','80 Brookland','Ajay-9028709777');
/*!40000 ALTER TABLE `hobby` ENABLE KEYS */;
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
