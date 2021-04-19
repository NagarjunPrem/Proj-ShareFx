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
-- Table structure for table `ride`
--

DROP TABLE IF EXISTS `ride`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ride` (
  `uid` int DEFAULT NULL,
  `rid` int NOT NULL AUTO_INCREMENT,
  `rname` varchar(50) DEFAULT NULL,
  `rdeparture` varchar(15) DEFAULT NULL,
  `rdestination` varchar(15) DEFAULT NULL,
  `rdate` date DEFAULT NULL,
  `rtime` time DEFAULT NULL,
  `rinfo` varchar(100) DEFAULT NULL,
  `rcount` int DEFAULT NULL,
  `rcontact` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`rid`),
  KEY `uid` (`uid`),
  CONSTRAINT `ride_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ride`
--

LOCK TABLES `ride` WRITE;
/*!40000 ALTER TABLE `ride` DISABLE KEYS */;
INSERT INTO `ride` VALUES (1,1,'Halifax Trip','Antigonish','Halifax','2021-04-06','19:30:10','Short visit to Halifax with my friends. Anyone interested can accompany us.',1,'Arjun - 9028709777'),(2,3,'Cape Breton Trip ','Halifax','Cape Breton','2021-05-06','09:30:10','Short visit to Cape Breton with my friends. Iinterested folks can ping me.',3,'Ajay - 9028709777'),(1,4,'To Antigonish','Halifax','Antigonish','2021-06-06','22:10:00','Pit Stop for Dinner- Truro',1,'Arjun - 9028709777'),(2,5,'Looking for a ride','Antigonish','Halifax','2021-07-06','10:00:00','looking for a ride to Halifax Friday! Will pay $$',1,'Ajay - 9028709777'),(2,6,'To Antigonish','Cape Breton','Antigonish','2021-07-06','12:00:00','Trip antigonish with friends',2,'Arjun - 9028709777'),(2,7,'To Sydney','Antigonish','Sydney','2021-08-06','13:00:00','Antigonish - Sydney',3,'Arjun - 9028709777'),(2,8,'To Halifax','Sydney','Halifax','2021-10-06','16:00:00','Pit Stop - Antigonish',1,'Arjun - 9028709777'),(2,9,'Dinner at TRuro','Ant','Tru','2021-12-06','18:00:00','Travelling Alone',3,'Arjun - 9028709777'),(2,10,'Breakfast Drive','Sydney','Antigonish','2021-12-13','08:30:00','Interested people can contact',2,'Arjun - 9028709777'),(1,11,'Long drive','Antigonish','Pictou','2021-12-13','11:30:00','Note: I will be driving slow',1,'Ajay - 9028709777'),(2,12,'Bangalore','Kaggadasapure','Shhivaji','2021-07-10','10:00:00','314-A -Bus.. illana Sangu',2,'Arjun-9028709777'),(2,26,'Short Trip with Family','Antigonish','New Glasgow','2021-07-27','13:00:00','Planning to halt for a day at New Glasgow. Travelling with Family. No Smoking inside the car.',1,'Arjun-9028709777'),(2,27,'frrwtret','ewrqtrtret','ratgrrr','2021-04-25','10:00:00','efwfwegrwg',2,'efewrewrw'),(1,28,'Trip to Truro with friends','Antigonish','Truro','2021-04-08','14:30:00','Please don\'t forget to get some snacks',2,'Arjun - 902870977'),(2,29,'Trip Toronto','Antigonish','Toronto','2021-04-17','14:00:00','Long Trip Toronto On Car. Pretty Long journey so be prepared',2,'Ajay-9028709777'),(2,30,'On my way to Debert','Antigonish','Debert','2021-04-18','15:00:00','Going Alone. utmost 2 can accompany',2,'Ajay-9028709777');
/*!40000 ALTER TABLE `ride` ENABLE KEYS */;
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
