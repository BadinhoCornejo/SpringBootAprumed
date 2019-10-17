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
-- Table structure for table `ejemplar`
--

DROP TABLE IF EXISTS `ejemplar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ejemplar` (
  `Sku` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EjemplarID` int(11) NOT NULL AUTO_INCREMENT,
  `Estado` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `LibroID` int(11) NOT NULL,
  PRIMARY KEY (`EjemplarID`),
  KEY `FK_Ejemplar_Libro` (`LibroID`),
  CONSTRAINT `FK_Ejemplar_Libro` FOREIGN KEY (`LibroID`) REFERENCES `libro` (`LibroID`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejemplar`
--

LOCK TABLES `ejemplar` WRITE;
/*!40000 ALTER TABLE `ejemplar` DISABLE KEYS */;
INSERT INTO `ejemplar` VALUES ('Boo/ElR/Ste1',3,'Vendido',1),('Boo/ElR/Ste/2',4,'Vendido',1),('Boo/ElR/Ste/3',5,'Vendido',1),('Boo/ElR/Ste/4',6,'Vendido',1),('Boo/ElR/Ste/5',7,'Vendido',1),('Boo/ElR/Ste/6',8,'En Carrito',1),('Boo/ElR/Ste/7',9,'Activo',1),('Boo/ElR/Ste/8',10,'Activo',1),('Boo/ElR/Ste/9',11,'Activo',1),('Boo/ElR/Ste/10',12,'Activo',1),('Boo/Via/Jul/1',13,'Vendido',2),('Boo/Via/Jul/2',14,'Vendido',2),('Boo/Via/Jul/3',15,'Vendido',2),('Boo/Via/Jul/4',16,'Vendido',2),('Boo/Via/Jul/5',17,'Activo',2),('Boo/Via/Jul/6',18,'Activo',2),('Boo/Via/Jul/7',19,'Activo',2),('Boo/Via/Jul/8',20,'Activo',2),('Boo/Via/Jul/9',21,'Activo',2),('Boo/Via/Jul/10',22,'Activo',2),('Boo/ElV/Ern/1',23,'Vendido',3),('Boo/ElV/Ern/2',24,'Vendido',3),('Boo/ElV/Ern/3',25,'Activo',3),('Boo/ElV/Ern/4',26,'Activo',3),('Boo/ElV/Ern/5',27,'Activo',3),('Boo/ElV/Ern/6',28,'Activo',3),('Boo/ElV/Ern/7',29,'Activo',3),('Boo/ElV/Ern/8',30,'Activo',3),('Boo/ElV/Ern/9',31,'Activo',3),('Boo/ElV/Ern/10',32,'Activo',3),('Boo/P.S/Cec/1	',33,'Vendido',4),('Boo/P.S/Cec/2',34,'Vendido',4),('Boo/P.S/Cec/3',35,'Vendido',4),('Boo/P.S/Cec/4',36,'Activo',4),('Boo/P.S/Cec/5',37,'Activo',4),('Boo/P.S/Cec/6',38,'Activo',4),('Boo/P.S/Cec/7',39,'Activo',4),('Boo/P.S/Cec/8',40,'Activo',4),('Boo/P.S/Cec/9',41,'Activo',4),('Boo/P.S/Cec/10',42,'Activo',4),('Boo/ElA/Gab/1',43,'Activo',5),('Boo/ElA/Gab/2',44,'Activo',5),('Boo/ElA/Gab/3',45,'Activo',5),('Boo/ElA/Gab/4',47,'Activo',5),('Boo/ElA/Gab/5',48,'Activo',5),('Boo/ElA/Gab/6',49,'Activo',5),('Boo/ElA/Gab/7',50,'Activo',5),('Boo/ElA/Gab/8',51,'Activo',5),('Boo/ElA/Gab/9',52,'Activo',5),('Boo/ElA/Gab/10',53,'Activo',5),('Boo/The/Nic/1',54,'Vendido',6),('Boo/The/Nic/2',55,'Activo',6),('Boo/The/Nic/3',56,'Activo',6),('Boo/The/Nic/4',57,'Activo',6),('Boo/The/Nic/5',58,'Activo',6),('Boo/The/Nic/6',59,'Activo',6),('Boo/The/Nic/7',60,'Activo',6),('Boo/The/Nic/8',61,'Activo',6),('Boo/The/Nic/9',62,'Activo',6),('Boo/The/Nic/10',63,'Activo',6),('Boo/Har/J.K/1',64,'Vendido',7),('Boo/Har/J.K/2',65,'Activo',7),('Boo/Har/J.K/3',66,'Activo',7),('Boo/Har/J.K/4',67,'Activo',7),('Boo/Har/J.K/5',68,'Activo',7),('Boo/Har/J.K/6',69,'Activo',7),('Boo/Har/J.K/7',70,'Activo',7),('Boo/Har/J.K/8',71,'Activo',7),('Boo/Har/J.K/9',72,'Activo',7),('Boo/Har/J.K/10',73,'Activo',7),('Boo/Har/J.K/6/1',74,'Activo',8),('Boo/Har/J.K/6/2',75,'Activo',8),('Boo/Har/J.K/6/3',76,'Activo',8),('Boo/Har/J.K/6/4',77,'Activo',8),('Boo/Har/J.K/6/5',78,'Activo',8),('Boo/Har/J.K/6/6',79,'Activo',8),('Boo/Har/J.K/6/7',80,'Activo',8),('Boo/Har/J.K/6/8',81,'Activo',8),('Boo/Har/J.K/6/9',82,'Activo',8);
/*!40000 ALTER TABLE `ejemplar` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-16 19:48:28
