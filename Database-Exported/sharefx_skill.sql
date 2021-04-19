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
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill` (
  `uid` int DEFAULT NULL,
  `sid` int NOT NULL AUTO_INCREMENT,
  `sname` varchar(50) DEFAULT NULL,
  `sdate` date DEFAULT NULL,
  `stime` time DEFAULT NULL,
  `sinfo` varchar(999) DEFAULT NULL,
  `slocation` varchar(50) DEFAULT NULL,
  `scontact` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `uid` (`uid`),
  CONSTRAINT `skill_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (1,1,'Guitarist','2021-04-18','10:00:00','Hey! I am cool Guitarist! Open to teach kids in Stfx','80 Brookland','Arjun-9028709777'),(2,2,'Computer Programming','2021-04-18','16:00:00','I have done my Masters in Computer Science and have 6 years of work experience in Java Programming. Open to coach under-grad students at Stfx','80 Brookland Street','Ajay-9028709777'),(2,3,'Free Style Dance','2021-04-18','16:00:00','Lets make use of this lock down. Interested to train kids on Free Style Dance over Zoom','80 Brookland/Online','Ajay-9028709777'),(1,4,'10th grade Math','2021-04-18','11:00:00','Available to teach Math to 10th grade Students','80Brookland/Online','Arjun-9028709777'),(1,5,'Football coaching','2021-04-18','10:00:00','Hello Folks! I have been a part of the Stfx Football team for the past 2 years and considered to be one of the key players in the team. Interested to train interested kids. As this is out of my passion, I do not charge for this. Interested folks can contact me.','80 Brookland Street','Arjun-9028709777');
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
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
