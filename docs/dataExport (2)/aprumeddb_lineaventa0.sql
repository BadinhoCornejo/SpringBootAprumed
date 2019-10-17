-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: aprumeddb
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `lineaventa`
--

DROP TABLE IF EXISTS `lineaventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lineaventa` (
  `LineaventaID` int(11) NOT NULL AUTO_INCREMENT,
  `EjemplarID` int(11) DEFAULT NULL,
  `VentaID` int(11) DEFAULT NULL,
  PRIMARY KEY (`LineaventaID`),
  KEY `FK_LineaVenta_Ejemplar` (`EjemplarID`),
  KEY `FK_LineaVenta_Venta` (`VentaID`),
  CONSTRAINT `FK_LineaVenta_Ejemplar` FOREIGN KEY (`EjemplarID`) REFERENCES `ejemplar` (`EjemplarID`),
  CONSTRAINT `FK_LineaVenta_Venta` FOREIGN KEY (`VentaID`) REFERENCES `venta` (`VentaID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineaventa`
--

LOCK TABLES `lineaventa` WRITE;
/*!40000 ALTER TABLE `lineaventa` DISABLE KEYS */;
INSERT INTO `lineaventa` VALUES (1,3,2),(2,13,2),(3,23,2),(5,33,2),(6,4,1),(7,5,3),(8,14,3),(9,15,4),(10,24,4),(11,6,5),(12,34,5),(13,35,6),(16,16,7),(17,7,8),(18,64,8),(19,54,8),(20,8,9);
/*!40000 ALTER TABLE `lineaventa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-16 19:48:25
