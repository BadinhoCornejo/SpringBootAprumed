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
-- Table structure for table `avatar`
--

DROP TABLE IF EXISTS `avatar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avatar` (
  `AvatarID` int(11) NOT NULL AUTO_INCREMENT,
  `Estado` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `NombreAvatar` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Url` varchar(2083) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`AvatarID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avatar`
--

LOCK TABLES `avatar` WRITE;
/*!40000 ALTER TABLE `avatar` DISABLE KEYS */;
INSERT INTO `avatar` VALUES (1,'Activo','Default','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Users%2Fdefault-avatar.png?alt=media&token=bcefbfb0-dd0b-4ee5-a974-ca3e3278cb3d'),(2,'Activo','Badinho Cornejo','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Users%2FEsta_prro.JPG?alt=media&token=ebc3921e-6b57-4765-a55d-3820eb3c18c8'),(3,'Activo','el-pirata-portada.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Users%2Fel-pirata-portada.jpg?alt=media&token=0a36e476-85d1-407f-8d2e-f355aa6e22fb'),(4,'Activo','profile2.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Users%2Fprofile2.jpg?alt=media&token=8cb2ae25-eeee-4a0c-bd54-b7ab42b4dc41'),(5,'Activo','fotoCV.jpg',''),(6,'Activo','Esta_prro.JPG','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Users%2FEsta_prro.JPG?alt=media&token=f7209493-ff33-49db-8229-34f21b8a1db1'),(7,'Activo','Bajo La Misma Estrella - John Green.jpg',''),(8,'Activo','carrito.jpg','');
/*!40000 ALTER TABLE `avatar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `NombreCategoria` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CategoriaID` int(11) NOT NULL AUTO_INCREMENT,
  `Estado` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`CategoriaID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES ('Novela',1,'Activo'),('Ciencia ficción',2,'Activo'),('Literatura peruana',3,'Activo'),('Infantil',4,'Activo'),('Filosofía',5,'Activo'),('Crecimiento personal',6,'Activo'),('Idiomas',7,'Activo'),('Educación',8,'Activo'),('Terror',9,'Activo'),('Fantasía',10,'Activo'),('Aventura',11,'Activo'),('Tragedia',12,'Activo');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprobantepago`
--

DROP TABLE IF EXISTS `comprobantepago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comprobantepago` (
  `FechaCp` date DEFAULT NULL,
  `HoraCp` datetime DEFAULT NULL,
  `Ruc` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Subtotal` decimal(9,3) DEFAULT NULL,
  `ComprobantePagoID` int(11) NOT NULL AUTO_INCREMENT,
  `VentaID` int(11) NOT NULL,
  PRIMARY KEY (`ComprobantePagoID`),
  KEY `FK_ComprobantePago_Venta` (`VentaID`),
  CONSTRAINT `FK_ComprobantePago_Venta` FOREIGN KEY (`VentaID`) REFERENCES `venta` (`VentaID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprobantepago`
--

LOCK TABLES `comprobantepago` WRITE;
/*!40000 ALTER TABLE `comprobantepago` DISABLE KEYS */;
INSERT INTO `comprobantepago` VALUES ('2019-11-06','2019-11-06 17:02:48','20554394273',144.000,1,1),('2019-11-06','2019-11-06 17:07:09','20554394273',88.000,2,4),('2019-11-06','2019-11-06 18:06:03','20554394273',29.000,3,5),('2019-11-06','2019-11-06 18:07:52','20554394273',84.000,4,7),('2019-11-06','2019-11-06 20:21:15','20554394273',185.000,5,8),('2019-11-06','2019-11-06 20:32:10','20554394273',58.000,6,10),('2019-11-20','2019-11-20 15:40:13','20554394273',145.000,7,9),('2019-11-20','2019-11-20 18:20:23','20554394273',222.000,8,12),('2019-12-06','2019-12-06 06:40:14','20554394273',284.000,9,13),('2019-12-06','2019-12-06 11:16:04','20554394273',150.000,10,2),('2019-12-06','2019-12-06 11:24:48','20554394273',137.000,11,14),('2021-10-20','2021-10-20 22:29:25','20554394273',49.000,12,15),('2021-10-20','2021-10-20 22:32:42','20554394273',153.000,13,18);
/*!40000 ALTER TABLE `comprobantepago` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=259 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejemplar`
--

LOCK TABLES `ejemplar` WRITE;
/*!40000 ALTER TABLE `ejemplar` DISABLE KEYS */;
INSERT INTO `ejemplar` VALUES ('Boo/ElR/Ste1',3,'Vendido',1),('Boo/ElR/Ste/2',4,'Vendido',1),('Boo/ElR/Ste/3',5,'Vendido',1),('Boo/ElR/Ste/4',6,'Vendido',1),('Boo/ElR/Ste/5',7,'Vendido',1),('Boo/ElR/Ste/6',8,'En Carrito',1),('Boo/ElR/Ste/7',9,'Vendido',1),('Boo/ElR/Ste/8',10,'Vendido',1),('Boo/ElR/Ste/9',11,'Activo',1),('Boo/ElR/Ste/10',12,'Activo',1),('Boo/Via/Jul/1',13,'Vendido',2),('Boo/Via/Jul/2',14,'Vendido',2),('Boo/Via/Jul/3',15,'Vendido',2),('Boo/Via/Jul/4',16,'Vendido',2),('Boo/Via/Jul/5',17,'Vendido',2),('Boo/Via/Jul/6',18,'Vendido',2),('Boo/Via/Jul/7',19,'Vendido',2),('Boo/Via/Jul/8',20,'Vendido',2),('Boo/Via/Jul/9',21,'Vendido',2),('Boo/Via/Jul/10',22,'Vendido',2),('Boo/ElV/Ern/1',23,'Vendido',3),('Boo/ElV/Ern/2',24,'Vendido',3),('Boo/ElV/Ern/3',25,'Vendido',3),('Boo/ElV/Ern/4',26,'Vendido',3),('Boo/ElV/Ern/5',27,'Vendido',3),('Boo/ElV/Ern/6',28,'Vendido',3),('Boo/ElV/Ern/7',29,'Vendido',3),('Boo/ElV/Ern/8',30,'Vendido',3),('Boo/ElV/Ern/9',31,'Vendido',3),('Boo/ElV/Ern/10',32,'En Carrito',3),('Boo/P.S/Cec/1	',33,'Vendido',4),('Boo/P.S/Cec/2',34,'Vendido',4),('Boo/P.S/Cec/3',35,'Vendido',4),('Boo/P.S/Cec/4',36,'Vendido',4),('Boo/P.S/Cec/5',37,'Vendido',4),('Boo/P.S/Cec/6',38,'Vendido',4),('Boo/P.S/Cec/7',39,'Vendido',4),('Boo/P.S/Cec/8',40,'Vendido',4),('Boo/P.S/Cec/9',41,'Activo',4),('Boo/P.S/Cec/10',42,'Activo',4),('Boo/ElA/Gab/1',43,'Vendido',5),('Boo/ElA/Gab/2',44,'Vendido',5),('Boo/ElA/Gab/3',45,'Vendido',5),('Boo/ElA/Gab/4',47,'Activo',5),('Boo/ElA/Gab/5',48,'Activo',5),('Boo/ElA/Gab/6',49,'Activo',5),('Boo/ElA/Gab/7',50,'Activo',5),('Boo/ElA/Gab/8',51,'Vendido',5),('Boo/ElA/Gab/9',52,'Vendido',5),('Boo/ElA/Gab/10',53,'Vendido',5),('Boo/The/Nic/1',54,'Vendido',6),('Boo/The/Nic/2',55,'Vendido',6),('Boo/The/Nic/3',56,'Inactivo',6),('Boo/The/Nic/4',57,'Inactivo',6),('Boo/The/Nic/5',58,'Vendido',6),('Boo/The/Nic/6',59,'En Carrito',6),('Boo/The/Nic/7',60,'En Carrito',6),('Boo/The/Nic/8',61,'Activo',6),('Boo/The/Nic/9',62,'Activo',6),('Boo/The/Nic/10',63,'Activo',6),('Boo/Har/J.K/1',64,'Vendido',7),('Boo/Har/J.K/2',65,'Vendido',7),('Boo/Har/J.K/3',66,'En Carrito',7),('Boo/Har/J.K/4',67,'Vendido',7),('Boo/Har/J.K/5',68,'Vendido',7),('Boo/Har/J.K/6',69,'Vendido',7),('Boo/Har/J.K/7',70,'Activo',7),('Boo/Har/J.K/8',71,'Activo',7),('Boo/Har/J.K/9',72,'Activo',7),('Boo/Har/J.K/10',73,'Activo',7),('Boo/Har/J.K/6/1',74,'Vendido',8),('Boo/Har/J.K/6/2',75,'Vendido',8),('Boo/Har/J.K/6/3',76,'Activo',8),('Boo/Har/J.K/6/4',77,'Activo',8),('Boo/Har/J.K/6/5',78,'Activo',8),('Boo/Har/J.K/6/6',79,'Activo',8),('Boo/Har/J.K/6/7',80,'Activo',8),('Boo/Har/J.K/6/8',81,'Activo',8),('Boo/Har/J.K/6/9',82,'Activo',8),('Boo/ElR/Ste/11',83,'Inactivo',1),('Boo/ElR/Ste/12',84,'Inactivo',1),('Boo/Via/Jul/11',85,'Vendido',2),('Boo/Via/Jul/12',86,'Vendido',2),('Boo/Via/Jul/13',87,'Activo',2),('Elp/Ant/Boo/1',88,'Activo',9),('Elp/Ant/Boo/2',89,'Activo',9),('Elp/Ant/Boo/3',90,'Activo',9),('Elp/Ant/Boo/4',91,'Activo',9),('Elp/Ant/Boo/5',92,'Activo',9),('Elp/Ant/Boo/6',93,'Activo',9),('Elp/Ant/Boo/7',94,'Activo',9),('Elp/Ant/Boo/8',95,'Activo',9),('Dun/Pla/Boo/1',96,'Activo',10),('Dun/Pla/Boo/2',97,'Activo',10),('Dun/Pla/Boo/3',98,'Activo',10),('Dun/Pla/Boo/4',99,'Activo',10),('Dun/Pla/Boo/5',100,'Activo',10),('Dun/Pla/Boo/6',101,'Activo',10),('Dun/Pla/Boo/7',102,'Activo',10),('Dun/Pla/Boo/8',103,'Activo',10),('ElG/Sco/Boo/1',104,'Vendido',12),('ElG/Sco/Boo/2',105,'Vendido',12),('ElG/Sco/Boo/3',106,'En Carrito',12),('ElG/Sco/Boo/4',107,'En Carrito',12),('ElG/Sco/Boo/5',108,'Activo',12),('ElG/Sco/Boo/6',109,'Activo',12),('ElG/Sco/Boo/7',110,'Activo',12),('ElG/Sco/Boo/8',111,'Activo',12),('Edi/Sóf/Boo/1',112,'Activo',13),('Edi/Sóf/Boo/2',113,'Activo',13),('Edi/Sóf/Boo/3',114,'Activo',13),('Edi/Sóf/Boo/4',115,'Activo',13),('Edi/Sóf/Boo/5',116,'Activo',13),('Edi/Sóf/Boo/6',117,'Activo',13),('Edi/Sóf/Boo/7',118,'Activo',13),('Edi/Sóf/Boo/8',119,'Activo',13),('Así/Fri/Boo/1',120,'Activo',14),('Así/Fri/Boo/2',121,'Activo',14),('Así/Fri/Boo/3',122,'Activo',14),('Así/Fri/Boo/4',123,'Activo',14),('Así/Fri/Boo/5',124,'Activo',14),('Así/Fri/Boo/6',125,'Activo',14),('Así/Fri/Boo/7',126,'Activo',14),('Así/Fri/Boo/8',127,'Activo',14),('Eln/Fri/Boo/1',128,'Activo',15),('Eln/Fri/Boo/2',129,'Activo',15),('Eln/Fri/Boo/3',130,'Activo',15),('Eln/Fri/Boo/4',131,'Activo',15),('Eln/Fri/Boo/5',132,'Activo',15),('Eln/Fri/Boo/6',133,'Activo',15),('Eln/Fri/Boo/7',134,'Activo',15),('Eln/Fri/Boo/8',135,'Activo',15),('Elm/Art/Boo/1',136,'Vendido',16),('Elm/Art/Boo/2',137,'Vendido',16),('Elm/Art/Boo/3',138,'Activo',16),('Elm/Art/Boo/4',139,'Activo',16),('Elm/Art/Boo/5',140,'Activo',16),('Elm/Art/Boo/6',141,'Activo',16),('Elm/Art/Boo/7',142,'Activo',16),('Elm/Art/Boo/8',143,'Activo',16),('Fra/Mar/Boo/1',144,'Activo',11),('Fra/Mar/Boo/2',145,'Activo',11),('Fra/Mar/Boo/3',146,'Activo',11),('Fra/Mar/Boo/4',147,'Activo',11),('Fra/Mar/Boo/5',148,'Activo',11),('Fra/Mar/Boo/6',149,'Activo',11),('Fra/Mar/Boo/7',150,'Activo',11),('Fra/Mar/Boo/8',151,'Activo',11),('It/Ste/Boo/1',152,'Activo',17),('It/Ste/Boo/2',153,'Activo',17),('It/Ste/Boo/3',154,'Activo',17),('It/Ste/Boo/4',155,'Activo',17),('It/Ste/Boo/5',156,'Activo',17),('It/Ste/Boo/6',157,'Activo',17),('It/Ste/Boo/7',158,'Activo',17),('It/Ste/Boo/8',159,'Activo',17),('Ana/Leó/Boo/1',160,'En Carrito',18),('Ana/Leó/Boo/2',161,'Activo',18),('Ana/Leó/Boo/3',162,'Activo',18),('Ana/Leó/Boo/4',163,'Activo',18),('Ana/Leó/Boo/5',164,'Activo',18),('Ana/Leó/Boo/6',165,'Activo',18),('Ana/Leó/Boo/7',166,'Activo',18),('Ana/Leó/Boo/8',167,'Activo',18),('Arr/Áng/Boo/1',168,'Activo',19),('Arr/Áng/Boo/2',169,'Activo',19),('Arr/Áng/Boo/3',170,'Activo',19),('Arr/Áng/Boo/4',171,'Activo',19),('Arr/Áng/Boo/5',172,'Activo',19),('Arr/Áng/Boo/6',173,'Activo',19),('Arr/Áng/Boo/7',174,'Activo',19),('Arr/Áng/Boo/8',175,'Activo',19),('Baj/Joh/Boo/1',176,'Activo',20),('Baj/Joh/Boo/2',177,'Activo',20),('Baj/Joh/Boo/3',178,'Activo',20),('Baj/Joh/Boo/4',179,'Activo',20),('Baj/Joh/Boo/5',180,'Activo',20),('Baj/Joh/Boo/6',181,'Activo',20),('Baj/Joh/Boo/7',182,'Activo',20),('Baj/Joh/Boo/8',183,'Activo',20),('Cie/Gab/Boo/1',184,'Activo',21),('Cie/Gab/Boo/2',185,'Activo',21),('Cie/Gab/Boo/3',186,'Activo',21),('Cie/Gab/Boo/4',187,'Activo',21),('Cie/Gab/Boo/5',188,'Activo',21),('Cie/Gab/Boo/6',189,'Activo',21),('Cie/Gab/Boo/7',190,'Activo',21),('Cie/Gab/Boo/8',191,'Activo',21),('Jue/Geo/Boo/1	',192,'Activo',22),('Jue/Geo/Boo/2',193,'Activo',22),('Jue/Geo/Boo/3',194,'Activo',22),('Jue/Geo/Boo/4',195,'Activo',22),('Jue/Geo/Boo/5',196,'Activo',22),('Jue/Geo/Boo/6',197,'Activo',22),('Jue/Geo/Boo/7',198,'Activo',22),('Jue/Geo/Boo/8',199,'Activo',22),('The/Sti/Boo/1	',200,'Activo',23),('The/Sti/Boo/2',201,'Activo',23),('The/Sti/Boo/3',202,'Activo',23),('The/Sti/Boo/4',203,'Activo',23),('The/Sti/Boo/5',204,'Activo',23),('The/Sti/Boo/6',205,'Activo',23),('The/Sti/Boo/7',206,'Activo',23),('The/Sti/Boo/8',207,'Activo',23),('Mad/Gus/Boo/1',208,'En Carrito',24),('Mad/Gus/Boo/2',209,'En Carrito',24),('Mad/Gus/Boo/3',210,'Activo',24),('Mad/Gus/Boo/4',211,'Activo',24),('Mad/Gus/Boo/5',212,'Activo',24),('Mad/Gus/Boo/6',213,'Activo',24),('Mad/Gus/Boo/7',214,'Activo',24),('Mad/Gus/Boo/8',215,'Activo',24),('Ela/Art/Boo/1',216,'Activo',25),('Ela/Art/Boo/2',217,'Activo',25),('Ela/Art/Boo/3',218,'Activo',25),('Ela/Art/Boo/4',219,'Activo',25),('Ela/Art/Boo/5',220,'Activo',25),('Ela/Art/Boo/6',221,'Activo',25),('Ela/Art/Boo/7',222,'Activo',25),('Ela/Art/Boo/8',223,'Activo',25),('Com/Lau/Boo/1',224,'Activo',26),('Com/Lau/Boo/2',225,'Activo',26),('Com/Lau/Boo/3',226,'Activo',26),('Com/Lau/Boo/4',227,'Activo',26),('Com/Lau/Boo/5',228,'Activo',26),('Com/Lau/Boo/6',229,'Activo',26),('Com/Lau/Boo/7',230,'Activo',26),('Com/Lau/Boo/8',231,'Activo',26),('Fau/Joh/Boo/1	',232,'Activo',27),('Fau/Joh/Boo/2',233,'Activo',27),('Fau/Joh/Boo/3',234,'Activo',27),('Fau/Joh/Boo/4',235,'Activo',27),('Fau/Joh/Boo/5',236,'Activo',27),('Fau/Joh/Boo/6',237,'Activo',27),('Fau/Joh/Boo/7',238,'Activo',27),('Fau/Joh/Boo/8',239,'Activo',27),('Lam/Fra/Boo/1	',240,'Vendido',28),('Lam/Fra/Boo/2',241,'Vendido',28),('Lam/Fra/Boo/3',242,'Vendido',28),('Lam/Fra/Boo/4',243,'Activo',28),('Lam/Fra/Boo/5',244,'Activo',28),('Lam/Fra/Boo/6',245,'Activo',28),('Lam/Fra/Boo/7',246,'Activo',28),('Lam/Fra/Boo/8',247,'Activo',28),('G21j23121231',248,'Activo',5),('G21j23121232',249,'Activo',5),('G21j23121223',250,'En Carrito',3),('G21j23121221',251,'Activo',3),('G21j23121220',252,'Activo',3),('9780605039071',253,'Activo',29),('9780605039072',254,'Activo',29),('9780605039073',255,'Activo',29),('Boo/LAB/Bil1',256,'Activo',30),('Boo/LAB/Bil2',257,'Activo',30),('Boo/LAB/Bil3',258,'Activo',30);
/*!40000 ALTER TABLE `ejemplar` ENABLE KEYS */;
UNLOCK TABLES;

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
  `Titulo` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `LibroID` int(11) NOT NULL AUTO_INCREMENT,
  `CategoriaID` int(11) NOT NULL,
  `Estado` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PortadaID` int(11) DEFAULT '1',
  PRIMARY KEY (`LibroID`),
  KEY `FK_Libro_Categoria` (`CategoriaID`),
  KEY `FK_Libro_Portada` (`PortadaID`),
  CONSTRAINT `FK_Libro_Categoria` FOREIGN KEY (`CategoriaID`) REFERENCES `categoria` (`CategoriaID`),
  CONSTRAINT `FK_Libro_Portada` FOREIGN KEY (`PortadaID`) REFERENCES `portada` (`PortadaID`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES ('Stephen King','1977-01-28','978849032872',49.000,2,'El Resplandor',1,9,'Activo',34),('Julio Verne','1864-11-25','97895830010',29.000,1,'Viaje Al Centro De La Tierra',2,11,'Activo',29),('Ernest Hemingway','1953-03-15','9787500120742',29.000,2,'El Viejo Y El Mar',3,1,'Activo',24),('Cecelia Ahern','2004-02-01','9789603642534',55.000,2,'P.S. I Love You',4,1,'Activo',5),('Gabriel García Márquez','1986-10-28','9783423113601',30.000,6,'El Amor En Tiempos De Cólera',5,1,'Activo',8),('Nicholas Sparks','1996-10-01','9788478883356',49.000,3,'The Notebook',6,1,'Activo',23),('J.K. Rowling','1997-06-26','9788700631625',49.000,4,'Harry Potter y la piedra filosofal',7,10,'Activo',13),('J.K. Rowling','2005-07-16','9788884516374',59.000,7,'Harry Potter y el misterio del príncipe',8,10,'Activo',14),('Antoine de Saint-Exupéry','1963-06-09','9788310105110',54.500,8,'El principito',9,4,'Activo',31),('Player\'s Handbook 5th Edition','2019-11-06','978-0786965601',150.000,8,'Dungeons and Dragons',10,4,'Activo',33),('Mary Shelley','1823-11-09','9781478198406',24.000,8,'Frankenstein',11,2,'Activo',50),('Scott Fitzgerald','1925-04-25','9781597226769',39.900,4,'El Gran Gatsby',12,1,'Activo',38),('Sófocles','2019-11-13','9783760813592',15.500,8,'Edipo Rey',13,12,'Activo',46),('Friedrich Nietzsche','1883-03-20','9781975638634',40.000,8,'Así habló Zaratustra',14,5,'Activo',47),('Friedrich Nietzsche','1872-04-04','9788932961903',40.000,8,'El nacimiento de la tragedia en el espíritu de la música',15,5,'Activo',48),('Arthur Schopenhauer','1819-02-22','9789028424746',50.000,6,'El mundo como la voluntad y representación',16,5,'Activo',49),('Stephen King','1986-04-23','9788677102302',65.000,8,'It',17,9,'Activo',35),('León Tolstói','1877-03-21','9781976236617',45.000,7,'Ana Karenina',18,1,'Activo',40),('Ángeles Mastretta','1985-03-01','9788420494647',35.000,8,'Arráncame la vida',19,1,'Activo',42),('John Green','2012-01-10','9781499513622',70.000,8,'Bajo la misma estrella',20,1,'Activo',43),('Gabriel García Márquez','1982-03-02','9789631420494',35.000,8,'Cien años de soledad',21,10,'Activo',41),('George R. R. Martin','1996-03-02','9780553386790',79.000,8,'Juego de tronos (A Game of Thrones)',22,10,'Activo',51),('Stieg Larsson','2005-02-03','9781847244840',35.000,8,'The Girl with the Dragon Tattoo',23,1,'Activo',52),('Gustave Flaubert','1857-02-03','9782743431839',25.000,6,'Madame Bovary',24,1,'Activo',53),('Arthur Schopenhauer','1995-02-03','9788578270391',30.000,8,'El arte de conocerse a sí mismo',25,5,'Activo',54),('Laura Esquivel','1989-02-03','9789029080040',38.000,8,'Como agua para chocolate',26,1,'Activo',44),('Johann Wolfgang von Goethe','1829-02-03','9781340173739',25.000,7,'Fausto',27,12,'Activo',55),(' Franz Kafka','1915-02-03','9783458352419',50.000,5,'La metamorfosis',28,1,'Activo',56),('J.K. Rowling','2007-07-21','9780605039070',50.000,3,'Harry Potter y las reliquias de la muerte',29,4,'Activo',57),('Bilito','1999-03-31','978849032892',45.000,3,'Las aventuras de bilito',30,9,'Inactivo',59),('GAAAA','1888-02-21','9789029080041',200.000,0,'Ga',31,3,'Inactivo',60),('Drake','2021-02-23','978134017373133',26.000,0,'La silla misteriosa',32,9,'Inactivo',61);
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineaventa`
--

LOCK TABLES `lineaventa` WRITE;
/*!40000 ALTER TABLE `lineaventa` DISABLE KEYS */;
INSERT INTO `lineaventa` VALUES (51,43,1),(52,44,1),(53,17,1),(54,36,1),(55,18,4),(56,25,4),(57,45,4),(113,19,5),(115,21,7),(116,37,7),(118,22,8),(119,20,8),(120,9,8),(121,10,8),(122,26,8),(123,27,10),(124,28,10),(127,29,9),(128,30,9),(129,31,9),(131,86,9),(132,85,9),(133,74,12),(134,75,12),(135,38,12),(136,65,12),(167,51,13),(168,136,13),(169,137,13),(170,52,13),(171,53,13),(172,104,13),(173,39,13),(174,240,2),(175,241,2),(176,242,2),(177,55,14),(178,58,14),(179,105,14),(180,106,16),(181,107,16),(182,32,16),(183,250,16),(184,59,16),(185,160,16),(186,60,16),(187,208,16),(188,209,16),(189,66,16),(190,67,15),(191,68,18),(192,40,18),(193,69,18);
/*!40000 ALTER TABLE `lineaventa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `portada`
--

DROP TABLE IF EXISTS `portada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `portada` (
  `PortadaID` int(11) NOT NULL AUTO_INCREMENT,
  `Estado` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `NombrePortada` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Url` varchar(2083) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`PortadaID`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `portada`
--

LOCK TABLES `portada` WRITE;
/*!40000 ALTER TABLE `portada` DISABLE KEYS */;
INSERT INTO `portada` VALUES (1,'Activo','Default','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fno-image.jpg?alt=media&token=02ff92cc-31c3-4137-8e25-50fbeb850797'),(2,'Activo','Anne Karenina','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FAnna%20Karenina%20-%20myLusciousLife_com.jpg?alt=media&token=300f90c8-2b8e-419f-b2ec-6199100e0ef1'),(3,'Activo','Arrancame La Vida - Ángeles Mastretta','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FArrancame%20La%20Vida-%20%C3%81ngeles%20Mastretta.jpg?alt=media&token=1886ce01-8a52-495e-94b4-8d5e007d62cf'),(4,'Activo','Bajo La Misma Estrella - John Green','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FBajo%20La%20Misma%20Estrella%20-%20John%20Green.jpg?alt=media&token=79c8f9dd-e48b-42ff-9d23-5d4f4776ada1'),(5,'Activo','P.S I Love You - Cecelia Ahern','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FCecelia%20Ahern%20-%20P_%20S.%20I%20Love%20You.%20I%20Love%20You.%20I%20Love%20You.jpg?alt=media&token=bbc78647-5f18-43f1-a4b7-9cc5a03a6875'),(6,'Activo','Cien Anos de Soledad - Gabriel García Marquez','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FCien%20Anos%20de%20Soledad%2C%20Gabriel%20Garcia%20Marquez.jpg?alt=media&token=8f796eef-cfa1-45b7-8629-c5c995296d01'),(7,'Activo','Como Agura Para Chocolate','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fcomo-agua-para-chocolate.jpg?alt=media&token=2cf7cf83-e17e-4172-8d65-8beb1aa711ee'),(8,'Activo','El amor en tiempos de colera','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FEL%20AMOR%20EN%20TIEMPOS%20DE%20COLERA%20.jpg?alt=media&token=ef79a15c-2ba7-4641-b5f0-55c3acccc14a'),(9,'Activo','El Pirata - Eloy','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fel-pirata-portada.jpg?alt=media&token=861b9231-84e7-4b79-a8a6-1af2b2d72fde'),(10,'Activo','Fausto','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Ffausto.jpg?alt=media&token=9be12b68-06ef-436d-a3f2-60a7068e1e05'),(11,'Activo','Game of Thrones','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FGame-Thrones.jpg?alt=media&token=37f2878e-fce7-4ab2-af20-c11ce9601d48'),(12,'Activo','Girl Dragon Tattoo','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FGirl-Dragon-Tattoo.jpg?alt=media&token=e93a2687-7d06-42d9-a37c-f5d5e1980cd6'),(13,'Activo','Hp 1','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fhp-1.jpg?alt=media&token=f23e9c6c-162a-4f25-87d7-616ff67435d7'),(14,'Activo','Hp 6','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fhp-6.jpg?alt=media&token=97871998-493b-4673-b953-8fcc4f2ef718'),(15,'Activo','Kafka-la-metamorfosis','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fkafka-la-metamorfosis.jpg?alt=media&token=67d1f170-d496-4590-9cbd-aa0ca4b25d10'),(16,'Activo','la-divina-comedia','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fla-divina-comedia.jpg?alt=media&token=71d47d63-c487-4d25-9ad0-870d960d1a89'),(17,'Activo','lolitaa','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Flolita.jpg?alt=media&token=c1cbb685-a756-4566-bb0e-d80e9cc291f8'),(18,'Activo','Madame Bovary','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FMadame%20Bovary.jpg?alt=media&token=4d34e821-6c4c-411a-9bff-e420e19241d5'),(19,'Activo','orgullo-prejuicio','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Forgullo-prejucio.jpg?alt=media&token=9fe333d4-bad5-4ef7-ab12-c67f9a327775'),(20,'Activo','origen-ritmos','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Forigen-ritmos.jpg?alt=media&token=107bd4fa-bf52-442a-93b0-80b3129e4cad'),(21,'Activo','El Arte de Conocerse A Sí Mismo','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FSchopenhauer%2C%20El%20Arte%20de%20Conocerse%20a%20S%C3%AD%20Mismo.jpg?alt=media&token=0d5756ef-36d7-4a8f-a407-7a678b02e028'),(22,'Activo','the-great-gatsby','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fthe-great-gatsby.jpg?alt=media&token=82cad557-b2ea-42c8-9acc-9d31e017c5be'),(23,'Activo','the-notebook','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fthe-notebook.jpg?alt=media&token=e9ffaca0-8b0a-4c3f-b8a7-2731c53b149a'),(24,'Activo','the-old-man-and-the-sea','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fthe-old-man-and-the-sea.jpg?alt=media&token=e245c869-e405-4a49-bfd2-2a317f8afbf2'),(25,'Activo','the-outsider','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fthe-outsider-stephen-king.jpg?alt=media&token=55d83c46-9c07-4e53-b0a3-2642baf90ef3'),(26,'Activo','the-picture-of-dorian-gray','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fthe-picture-dorian-gray.jpg?alt=media&token=e6a2e873-e052-456e-bca6-17ab0575a9b9'),(27,'Activo','the-raven','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fthe-raven.jpg?alt=media&token=5f0f0337-76a2-4062-8908-b887d46baad3'),(28,'Activo','the-shining','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fthe-shining.jpg?alt=media&token=7bd30e37-5ca6-4434-8e3f-66f0a80aecfb'),(29,'Activo','Viaje al centro de la tierra','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FViaje%20al%20centro%20de%20la%20tierra_%20Julio%20Verne.jpg?alt=media&token=298ab2f8-7f10-4852-8080-b9cea57ec061'),(30,'Activo','origen-ritmos.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Forigen-ritmos.jpg?alt=media&token=9863c151-9b37-438c-8e6a-29b855e3c7b0'),(31,'Activo','El-principito-Le-Petit-Prince.png','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FEl-principito-Le-Petit-Prince.png?alt=media&token=799e8213-f7f0-4a29-a970-b3185970eb95'),(32,'Activo','',''),(33,'Activo','D&D.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FD%26D.jpg?alt=media&token=6011eb8c-9ef8-4fdb-a353-a6a3953a828d'),(34,'Activo','the-shining.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fthe-shining.jpg?alt=media&token=19b5a70f-e9c1-4a78-a714-b06d6229ce25'),(35,'Activo','1504804810-it.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2F1504804810-it.jpg?alt=media&token=ebcab1cf-ed2f-4ea8-be5f-a18d2dd6ce53'),(36,'Activo','the-great-gatssby.jpg',''),(37,'Activo','the-ravenn.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fthe-ravenn.jpg?alt=media&token=27ae1e3d-751f-4dd5-bf70-bed6fe938364'),(38,'Activo','elgrangatsby.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Felgrangatsby.jpg?alt=media&token=2fec5656-dfb4-42bb-a93a-d456391511c8'),(39,'Activo','1505161319-forrest-gump.jpg',''),(40,'Activo','Anna Karenina - myLusciousLife_com.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FAnna%20Karenina%20-%20myLusciousLife_com.jpg?alt=media&token=66c2dc14-2bab-4971-8e2f-3b372ae116c9'),(41,'Activo','Cien Anos de Soledad, Gabriel Garcia Marquez.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FCien%20Anos%20de%20Soledad%2C%20Gabriel%20Garcia%20Marquez.jpg?alt=media&token=e0abc76e-119e-4f6b-a4b0-b9a1079f89e2'),(42,'Activo','Arrancame La Vida- Ángeles Mastretta.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FArrancame%20La%20Vida-%20%C3%81ngeles%20Mastretta.jpg?alt=media&token=314219a9-cc72-4cd6-901b-951987e6ca52'),(43,'Activo','Bajo La Misma Estrella - John Green.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FBajo%20La%20Misma%20Estrella%20-%20John%20Green.jpg?alt=media&token=75fede0c-d584-492b-9c60-4f138ce853d8'),(44,'Activo','como-agua-para-chocolate.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fcomo-agua-para-chocolate.jpg?alt=media&token=077136d9-0f07-4356-8862-4714e76b0f55'),(45,'Activo','orgullo-prejucio.jpg',''),(46,'Activo','edipo.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fedipo.jpg?alt=media&token=a6c75a05-da5e-431e-9f0a-fdb30a7ea0df'),(47,'Activo','zaratustra.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fzaratustra.jpg?alt=media&token=3de20c92-28c5-4640-a128-2d69bdc943bb'),(48,'Activo','elNacimientodelatrag.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FelNacimientodelatrag.jpg?alt=media&token=517fe540-5143-4529-9c83-a492ad46390d'),(49,'Activo','schope1.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fschope1.jpg?alt=media&token=67bb83ad-38e8-49ba-8e7e-420b8eb3e020'),(50,'Activo','frankenstein-o-el-moderno-prometeo-4.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Ffrankenstein-o-el-moderno-prometeo-4.jpg?alt=media&token=69ff2f96-68c2-4dc6-b199-84c09cdf05bc'),(51,'Activo','Game-Thrones.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FGame-Thrones.jpg?alt=media&token=30fdc022-4276-4560-bd27-198bb8951359'),(52,'Activo','Girl-Dragon-Tattoo.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FGirl-Dragon-Tattoo.jpg?alt=media&token=b8c6d928-b48c-4804-b138-21390fab2a11'),(53,'Activo','Madame Bovary.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FMadame%20Bovary.jpg?alt=media&token=b5b78c26-9604-4563-acea-f87001cbe051'),(54,'Activo','Schopenhauer, El Arte de Conocerse a Sí Mismo.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FSchopenhauer%2C%20El%20Arte%20de%20Conocerse%20a%20S%C3%AD%20Mismo.jpg?alt=media&token=8adcb737-7393-452d-bdf1-a914b22526c6'),(55,'Activo','fausto.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Ffausto.jpg?alt=media&token=bd994be4-05d3-491c-86cb-65459222e3c3'),(56,'Activo','kafka-la-metamorfosis.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fkafka-la-metamorfosis.jpg?alt=media&token=c1f3bce5-5106-44ca-b5d3-f916c9c06b4e'),(57,'Activo','harrypopoter.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fharrypopoter.jpg?alt=media&token=de074667-8cf5-496b-88ae-22d303cd0b8d'),(58,'Activo','Home.png',''),(59,'Activo','ClassicFM_1.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FClassicFM_1.jpg?alt=media&token=d0c81c78-24f0-4ba8-9764-59780c3fdf08'),(60,'Activo','filip-bunkens-9YDaCFmuoug-unsplash.jpg','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Ffilip-bunkens-9YDaCFmuoug-unsplash.jpg?alt=media&token=230b7633-40e2-4e27-a38d-73f47aaadd10'),(61,'Activo','SillaPrev.png','https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FSillaPrev.png?alt=media&token=701a4c42-2e52-469f-ad32-f4c66bf25cff'),(62,'Activo','cafetera-1.jpg','');
/*!40000 ALTER TABLE `portada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receptor`
--

DROP TABLE IF EXISTS `receptor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receptor` (
  `Apellido` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Dni` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Nombre` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Telefono` varchar(9) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ReceptorID` int(11) NOT NULL AUTO_INCREMENT,
  `VentaID` int(11) NOT NULL,
  PRIMARY KEY (`ReceptorID`),
  KEY `FK_Receptor_Venta` (`VentaID`),
  CONSTRAINT `FK_Receptor_Venta` FOREIGN KEY (`VentaID`) REFERENCES `venta` (`VentaID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receptor`
--

LOCK TABLES `receptor` WRITE;
/*!40000 ALTER TABLE `receptor` DISABLE KEYS */;
INSERT INTO `receptor` VALUES ('Cornejo','71778079','Daniel','977969843',2,1),('Cornejo','71778079','Daniel','977969843',3,4),('Cornejo','71778079','Daniel','977969843',4,5),('Cornejo','71778079','Daniel','923243242',5,7),('Lulixa','71778079','Lurdes','987898767',6,9),('Cornejo Chunga','71778079','Badinho','987123789',7,9),('Cornejo','71778079','Daniel','987182818',8,12),('Cornejo','71778079','Daniel','982737622',9,13),('alayo','12345678','anthony','123456789',10,2),('Cornejo','12345647','Daniel','565678978',11,14),('Bilito','72343723','Bili','928382834',12,15),('Cornejo','12345674','Daniel','23453454',13,18);
/*!40000 ALTER TABLE `receptor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipousuario`
--

DROP TABLE IF EXISTS `tipousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipousuario` (
  `NombreTipoUsuario` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Estado` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `TipoUsuarioID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`TipoUsuarioID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipousuario`
--

LOCK TABLES `tipousuario` WRITE;
/*!40000 ALTER TABLE `tipousuario` DISABLE KEYS */;
INSERT INTO `tipousuario` VALUES ('ROLE_USER','Activo',1),('ROLE_ADMIN','Activo',2),('Cajero','Activo',3);
/*!40000 ALTER TABLE `tipousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `Apellido` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Nombre` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Sexo` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Telefono` varchar(9) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Email` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Estado` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `UsrPassword` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `UsuarioID` int(11) NOT NULL AUTO_INCREMENT,
  `TipoUsuarioID` int(11) NOT NULL,
  `AvatarID` int(11) DEFAULT '1',
  PRIMARY KEY (`UsuarioID`),
  KEY `FK_Usuario_TipoUsuario` (`TipoUsuarioID`),
  KEY `FK_Usuario_Avatar` (`AvatarID`),
  CONSTRAINT `FK_Usuario_Avatar` FOREIGN KEY (`AvatarID`) REFERENCES `avatar` (`AvatarID`),
  CONSTRAINT `FK_Usuario_TipoUsuario` FOREIGN KEY (`TipoUsuarioID`) REFERENCES `tipousuario` (`TipoUsuarioID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('Cornejo Chunga','Daniel Badinho','Masculino','977969843','badinhocornejo@gmail.com','Activo','$2a$10$mRtgEYjoC6W4M3PcP.BvweSqd0Fos4BKShO6WrIN7iEupbO4oTQmC',1,1,6),('Cornejo ','Daniel Admin','Masculino','947903931','badinhocornejo@aprumed.pe','Activo','$2a$10$XuX0KF/N5mu/CwGFUq0loeDXkY3cfy353BFncUBFA1GKp1bA9em.O',2,2,1),('Detal','Fulano','Masculino','987264569','fulanitodetal@gmail.com','Activo','cisco123',3,1,1),('Diaz Amaya','Lourdes Roxana','Femenino','997189179','lulixa2000@gmail.com','Activo','abc123',4,3,1),('Ledesma','César','Masculino','983371828','ledesma@gmail.com','Activo','cisco123',5,1,1),('Perales','Ander','Masculino','986234567','perales@gmail.com','Activo','$2a$10$JT4a6AokWSOgePVXH9avz.unp963B4wKWo33GXVmHc7xB/t8Dwi0m',6,1,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `FechaVenta` date DEFAULT NULL,
  `HoraVenta` datetime DEFAULT NULL,
  `VentaID` int(11) NOT NULL AUTO_INCREMENT,
  `Estado` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `UsuarioID` int(11) NOT NULL,
  PRIMARY KEY (`VentaID`),
  KEY `FK_Venta_Usuario` (`UsuarioID`),
  CONSTRAINT `FK_Venta_Usuario` FOREIGN KEY (`UsuarioID`) REFERENCES `usuario` (`UsuarioID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES ('2019-11-06','2019-11-06 17:02:48',1,'Realizada',1),('2019-12-06','2019-12-06 11:16:04',2,'Realizada',2),(NULL,NULL,3,'Activo',3),('2019-11-06','2019-11-06 17:07:09',4,'Realizada',1),('2019-11-06','2019-11-06 18:06:03',5,'Realizada',1),(NULL,NULL,6,'Activo',4),('2019-11-06','2019-11-06 18:07:52',7,'Realizada',1),('2019-11-06','2019-11-06 20:21:15',8,'Realizada',1),('2019-11-20','2019-11-20 15:40:13',9,'Realizada',1),('2019-11-06','2019-11-06 20:32:10',10,'Realizada',5),(NULL,NULL,11,'Activo',5),('2019-11-20','2019-11-20 18:20:23',12,'Realizada',1),('2019-12-06','2019-12-06 06:40:14',13,'Realizada',1),('2019-12-06','2019-12-06 11:24:48',14,'Realizada',1),('2021-10-20','2021-10-20 22:29:25',15,'Realizada',2),(NULL,NULL,16,'Activo',1),(NULL,NULL,17,'Activo',6),('2021-10-20','2021-10-20 22:32:42',18,'Realizada',2),(NULL,NULL,19,'Activo',2);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-20 22:38:49
