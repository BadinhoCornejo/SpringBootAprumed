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
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `Autor` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `FechaPublicacion` date DEFAULT NULL,
  `Isbn` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Precio` decimal(9,3) DEFAULT NULL,
  `Stock` int(11) DEFAULT NULL,
  `Titulo` varchar(230) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `LibroID` int(11) NOT NULL AUTO_INCREMENT,
  `CategoriaID` int(11) NOT NULL,
  `Estado` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PortadaID` int(11) DEFAULT '1',
  PRIMARY KEY (`LibroID`),
  KEY `FK_Libro_Categoria` (`CategoriaID`),
  KEY `FK_Libro_Portada` (`PortadaID`),
  CONSTRAINT `FK_Libro_Categoria` FOREIGN KEY (`CategoriaID`) REFERENCES `categoria` (`CategoriaID`),
  CONSTRAINT `FK_Libro_Portada` FOREIGN KEY (`PortadaID`) REFERENCES `portada` (`PortadaID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES ('Stephen King','1977-01-28','978849032872',49.000,4,'El Resplandor',1,9,'Activo',28),('Julio Verne','1864-11-25','97895830010',29.000,6,'Viaje Al Centro De La Tierra',2,11,'Activo',29),('Ernest Hemingway','1953-03-15','9787500120742',29.000,8,'El Viejo Y El Mar',3,1,'Activo',24),('Cecelia Ahern','2004-02-01','9789603642534',55.000,7,'P.S. I Love You',4,1,'Activo',5),('Gabriel García Márquez','1986-10-28','9783423113601',30.000,10,'El Amor En Tiempos De Cólera',5,1,'Activo',8),('Nicholas Sparks','1996-10-01','9788478883356',49.000,9,'The Notebook',6,1,'Activo',23),('J.K. Rowling','1997-06-26','9788700631625',49.000,9,'Harry Potter y la piedra filosofal',7,10,'Activo',13),('J.K. Rowling','2005-07-16','9788884516374',59.000,9,'Harry Potter y el misterio del príncipe',8,10,'Activo',14);
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-16 19:48:29
