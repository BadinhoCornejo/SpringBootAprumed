use aprumeddb;

SET
  FOREIGN_KEY_CHECKS = 0;

SET
  GLOBAL time_zone = '-3:00';

/* Drop Tables */
DROP TABLE IF EXISTS `Avatar` CASCADE;

DROP TABLE IF EXISTS `Portada` CASCADE;

DROP TABLE IF EXISTS `Categoria` CASCADE;

DROP TABLE IF EXISTS `ComprobantePago` CASCADE;

DROP TABLE IF EXISTS `Ejemplar` CASCADE;

DROP TABLE IF EXISTS `Libro` CASCADE;

DROP TABLE IF EXISTS `LineaVenta` CASCADE;

DROP TABLE IF EXISTS `Receptor` CASCADE;

DROP TABLE IF EXISTS `TipoUsuario` CASCADE;

DROP TABLE IF EXISTS `Usuario` CASCADE;

DROP TABLE IF EXISTS `Venta` CASCADE;

/* Create Tables */
CREATE TABLE `Categoria` (
  `NombreCategoria` NVARCHAR(30) NULL,
  `CategoriaID` INT NOT NULL AUTO_INCREMENT,
  `Estado` VARCHAR(20) NULL,
  CONSTRAINT `PK_Categoria` PRIMARY KEY (`CategoriaID` ASC)
);

CREATE TABLE `ComprobantePago` (
  `FechaCp` DATE NULL,
  `HoraCp` DATETIME NULL,
  `Ruc` NVARCHAR(13) NULL,
  `Subtotal` DECIMAL(9, 3) NULL,
  `ComprobantePagoID` INT NOT NULL AUTO_INCREMENT,
  `VentaID` INT NOT NULL,
  CONSTRAINT `PK_ComprobantePago` PRIMARY KEY (`ComprobantePagoID` ASC)
);

CREATE TABLE `Ejemplar` (
  `Sku` VARCHAR(15) NULL,
  `EjemplarID` INT NOT NULL AUTO_INCREMENT,
  `Estado` VARCHAR(20) NULL,
  `LibroID` INT NOT NULL,
  CONSTRAINT `PK_Ejemplar` PRIMARY KEY (`EjemplarID` ASC)
);

CREATE TABLE `Libro` (
  `Autor` NVARCHAR(40) NULL,
  `FechaPublicacion` DATE NULL,
  `Isbn` NVARCHAR(15) NULL,
  `Precio` DECIMAL(9, 3) NULL,
  `Stock` INT NULL,
  `Titulo` NVARCHAR(60) NULL,
  `LibroID` INT NOT NULL AUTO_INCREMENT,
  `CategoriaID` INT NOT NULL,
  `Estado` VARCHAR(20) NULL,
  `PortadaID` INT NULL DEFAULT 1,
  CONSTRAINT `PK_Libro` PRIMARY KEY (`LibroID` ASC)
);

CREATE TABLE `Portada` (
  `PortadaID` INT NOT NULL AUTO_INCREMENT,
  `Estado` VARCHAR(30) NULL,
  `NombrePortada` NVARCHAR(50) NULL,
  `Url` NVARCHAR(2083) NULL,
  CONSTRAINT `PK_Portada` PRIMARY KEY (`PortadaID` ASC)
);

CREATE TABLE `LineaVenta` (
  `LineaventaID` INT NOT NULL AUTO_INCREMENT,
  `EjemplarID` INT NULL,
  `VentaID` INT NULL,
  CONSTRAINT `PK_LineaVenta` PRIMARY KEY (`LineaventaID` ASC)
);

CREATE TABLE `Receptor` (
  `Apellido` NVARCHAR(40) NULL,
  `Dni` VARCHAR(8) NULL,
  `Nombre` NVARCHAR(40) NULL,
  `Telefono` VARCHAR(9) NULL,
  `ReceptorID` INT NOT NULL AUTO_INCREMENT,
  `VentaID` INT NOT NULL,
  CONSTRAINT `PK_Receptor` PRIMARY KEY (`ReceptorID` ASC)
);

CREATE TABLE `TipoUsuario` (
  `NombreTipoUsuario` NVARCHAR(20) NULL,
  `Estado` VARCHAR(20) NULL,
  `TipoUsuarioID` INT NOT NULL AUTO_INCREMENT,
  CONSTRAINT `PK_TipoUsuario` PRIMARY KEY (`TipoUsuarioID` ASC)
);

CREATE TABLE `Usuario` (
  `Apellido` NVARCHAR(40) NULL,
  `Nombre` NVARCHAR(40) NULL,
  `Sexo` VARCHAR(20) NULL,
  `Telefono` VARCHAR(9) NULL,
  `Email` NVARCHAR(40) NULL,
  `Estado` VARCHAR(20) NULL,
  `UsrPassword` NVARCHAR(25) NULL,
  `UsuarioID` INT NOT NULL AUTO_INCREMENT,
  `TipoUsuarioID` INT NOT NULL,
  `AvatarID` INT NULL DEFAULT 1,
  CONSTRAINT `PK_Usuario` PRIMARY KEY (`UsuarioID` ASC)
);

CREATE TABLE `Avatar` (
  `AvatarID` INT NOT NULL AUTO_INCREMENT,
  `Estado` VARCHAR(30) NULL,
  `NombreAvatar` NVARCHAR(50) NULL,
  `Url` NVARCHAR(2083) NULL,
  CONSTRAINT `PK_Avatar` PRIMARY KEY (`AvatarID` ASC)
);

CREATE TABLE `Venta` (
  `FechaVenta` DATE NULL,
  `HoraVenta` DATETIME NULL,
  `VentaID` INT NOT NULL AUTO_INCREMENT,
  `Estado` VARCHAR(20) NULL,
  `UsuarioID` INT NOT NULL,
  CONSTRAINT `PK_Venta` PRIMARY KEY (`VentaID` ASC)
);

/* Create Foreign Key Constraints */
ALTER TABLE
  `ComprobantePago`
ADD
  CONSTRAINT `FK_ComprobantePago_Venta` FOREIGN KEY (`VentaID`) REFERENCES `Venta` (`VentaID`) ON DELETE No Action ON UPDATE No Action;

ALTER TABLE
  `Ejemplar`
ADD
  CONSTRAINT `FK_Ejemplar_Libro` FOREIGN KEY (`LibroID`) REFERENCES `Libro` (`LibroID`) ON DELETE No Action ON UPDATE No Action;

ALTER TABLE
  `Libro`
ADD
  CONSTRAINT `FK_Libro_Categoria` FOREIGN KEY (`CategoriaID`) REFERENCES `Categoria` (`CategoriaID`) ON DELETE No Action ON UPDATE No Action;

ALTER TABLE
  `Libro`
ADD
  CONSTRAINT `FK_Libro_Portada` FOREIGN KEY (`PortadaID`) REFERENCES `Portada` (`PortadaID`) ON DELETE No Action ON UPDATE No Action;

ALTER TABLE
  `LineaVenta`
ADD
  CONSTRAINT `FK_LineaVenta_Ejemplar` FOREIGN KEY (`EjemplarID`) REFERENCES `Ejemplar` (`EjemplarID`) ON DELETE No Action ON UPDATE No Action;

ALTER TABLE
  `LineaVenta`
ADD
  CONSTRAINT `FK_LineaVenta_Venta` FOREIGN KEY (`VentaID`) REFERENCES `Venta` (`VentaID`) ON DELETE No Action ON UPDATE No Action;

ALTER TABLE
  `Receptor`
ADD
  CONSTRAINT `FK_Receptor_Venta` FOREIGN KEY (`VentaID`) REFERENCES `Venta` (`VentaID`) ON DELETE No Action ON UPDATE No Action;

ALTER TABLE
  `Usuario`
ADD
  CONSTRAINT `FK_Usuario_TipoUsuario` FOREIGN KEY (`TipoUsuarioID`) REFERENCES `TipoUsuario` (`TipoUsuarioID`) ON DELETE No Action ON UPDATE No Action;

ALTER TABLE
  `Usuario`
ADD
  CONSTRAINT `FK_Usuario_Avatar` FOREIGN KEY (`AvatarID`) REFERENCES `Avatar` (`AvatarID`) ON DELETE No Action ON UPDATE No Action;

ALTER TABLE
  `Venta`
ADD
  CONSTRAINT `FK_Venta_Usuario` FOREIGN KEY (`UsuarioID`) REFERENCES `Usuario` (`UsuarioID`) ON DELETE No Action ON UPDATE No Action;

SET
  FOREIGN_KEY_CHECKS = 1;

/*INSERTS*/

-- insert into
--   tipousuario (NombreTipoUsuario, Estado)
-- values
--   ("Cliente", "Activo");

-- insert into
--   tipousuario (NombreTipoUsuario, Estado)
-- values
--   ("Administrador", "Activo");

-- insert into
--   tipousuario (NombreTipoUsuario, Estado)
-- values
--   ("Cajero", "Activo");

-- INSERT INTO
--   `avatar`
-- VALUES
--   (
--     1,
--     'Activo',
--     'Default',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Users%2Fdefault-avatar.png?alt=media&token=bcefbfb0-dd0b-4ee5-a974-ca3e3278cb3d'
--   ),(
--     2,
--     'Activo',
--     'Badinho Cornejo',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Users%2FEsta_prro.JPG?alt=media&token=ebc3921e-6b57-4765-a55d-3820eb3c18c8'
--   );

-- INSERT INTO
--   `portada`
-- VALUES
--   (
--     1,
--     'Activo',
--     'Default',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fno-image.jpg?alt=media&token=02ff92cc-31c3-4137-8e25-50fbeb850797'
--   ),(
--     2,
--     'Activo',
--     'Anne Karenina',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FAnna%20Karenina%20-%20myLusciousLife_com.jpg?alt=media&token=300f90c8-2b8e-419f-b2ec-6199100e0ef1'
--   ),(
--     3,
--     'Activo',
--     'Arrancame La Vida - Ángeles Mastretta',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FArrancame%20La%20Vida-%20%C3%81ngeles%20Mastretta.jpg?alt=media&token=1886ce01-8a52-495e-94b4-8d5e007d62cf'
--   ),(
--     4,
--     'Activo',
--     'Bajo La Misma Estrella - John Green',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FBajo%20La%20Misma%20Estrella%20-%20John%20Green.jpg?alt=media&token=79c8f9dd-e48b-42ff-9d23-5d4f4776ada1'
--   ),(
--     5,
--     'Activo',
--     'P.S I Love You - Cecelia Ahern',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FCecelia%20Ahern%20-%20P_%20S.%20I%20Love%20You.%20I%20Love%20You.%20I%20Love%20You.jpg?alt=media&token=bbc78647-5f18-43f1-a4b7-9cc5a03a6875'
--   ),(
--     6,
--     'Activo',
--     'Cien Anos de Soledad - Gabriel García Marquez',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FCien%20Anos%20de%20Soledad%2C%20Gabriel%20Garcia%20Marquez.jpg?alt=media&token=8f796eef-cfa1-45b7-8629-c5c995296d01'
--   ),(
--     7,
--     'Activo',
--     'Como Agura Para Chocolate',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fcomo-agua-para-chocolate.jpg?alt=media&token=2cf7cf83-e17e-4172-8d65-8beb1aa711ee'
--   ),(
--     8,
--     'Activo',
--     'El amor en tiempos de colera',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FEL%20AMOR%20EN%20TIEMPOS%20DE%20COLERA%20.jpg?alt=media&token=ef79a15c-2ba7-4641-b5f0-55c3acccc14a'
--   ),(
--     9,
--     'Activo',
--     'El Pirata - Eloy',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fel-pirata-portada.jpg?alt=media&token=861b9231-84e7-4b79-a8a6-1af2b2d72fde'
--   ),(
--     10,
--     'Activo',
--     'Fausto',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Ffausto.jpg?alt=media&token=9be12b68-06ef-436d-a3f2-60a7068e1e05'
--   ),(
--     11,
--     'Activo',
--     'Game of Thrones',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FGame-Thrones.jpg?alt=media&token=37f2878e-fce7-4ab2-af20-c11ce9601d48'
--   ),(
--     12,
--     'Activo',
--     'Girl Dragon Tattoo',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FGirl-Dragon-Tattoo.jpg?alt=media&token=e93a2687-7d06-42d9-a37c-f5d5e1980cd6'
--   ),(
--     13,
--     'Activo',
--     'Hp 1',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fhp-1.jpg?alt=media&token=f23e9c6c-162a-4f25-87d7-616ff67435d7'
--   ),(
--     14,
--     'Activo',
--     'Hp 6',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fhp-6.jpg?alt=media&token=97871998-493b-4673-b953-8fcc4f2ef718'
--   ),(
--     15,
--     'Activo',
--     'Kafka-la-metamorfosis',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fkafka-la-metamorfosis.jpg?alt=media&token=67d1f170-d496-4590-9cbd-aa0ca4b25d10'
--   ),(
--     16,
--     'Activo',
--     'la-divina-comedia',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fla-divina-comedia.jpg?alt=media&token=71d47d63-c487-4d25-9ad0-870d960d1a89'
--   ),(
--     17,
--     'Activo',
--     'lolitaa',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Flolita.jpg?alt=media&token=c1cbb685-a756-4566-bb0e-d80e9cc291f8'
--   ),(
--     18,
--     'Activo',
--     'Madame Bovary',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FMadame%20Bovary.jpg?alt=media&token=4d34e821-6c4c-411a-9bff-e420e19241d5'
--   ),(
--     19,
--     'Activo',
--     'orgullo-prejuicio',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Forgullo-prejucio.jpg?alt=media&token=9fe333d4-bad5-4ef7-ab12-c67f9a327775'
--   ),(
--     20,
--     'Activo',
--     'origen-ritmos',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Forigen-ritmos.jpg?alt=media&token=107bd4fa-bf52-442a-93b0-80b3129e4cad'
--   ),(
--     21,
--     'Activo',
--     'El Arte de Conocerse A Sí Mismo',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FSchopenhauer%2C%20El%20Arte%20de%20Conocerse%20a%20S%C3%AD%20Mismo.jpg?alt=media&token=0d5756ef-36d7-4a8f-a407-7a678b02e028'
--   ),(
--     22,
--     'Activo',
--     'the-great-gatsby',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fthe-great-gatsby.jpg?alt=media&token=82cad557-b2ea-42c8-9acc-9d31e017c5be'
--   ),(
--     23,
--     'Activo',
--     'the-notebook',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fthe-notebook.jpg?alt=media&token=e9ffaca0-8b0a-4c3f-b8a7-2731c53b149a'
--   ),(
--     24,
--     'Activo',
--     'the-old-man-and-the-sea',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fthe-old-man-and-the-sea.jpg?alt=media&token=e245c869-e405-4a49-bfd2-2a317f8afbf2'
--   ),(
--     25,
--     'Activo',
--     'the-outsider',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fthe-outsider-stephen-king.jpg?alt=media&token=55d83c46-9c07-4e53-b0a3-2642baf90ef3'
--   ),(
--     26,
--     'Activo',
--     'the-picture-of-dorian-gray',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fthe-picture-dorian-gray.jpg?alt=media&token=e6a2e873-e052-456e-bca6-17ab0575a9b9'
--   ),(
--     27,
--     'Activo',
--     'the-raven',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fthe-raven.jpg?alt=media&token=5f0f0337-76a2-4062-8908-b887d46baad3'
--   ),(
--     28,
--     'Activo',
--     'the-shining',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2Fthe-shining.jpg?alt=media&token=7bd30e37-5ca6-4434-8e3f-66f0a80aecfb'
--   ),(
--     29,
--     'Activo',
--     'Viaje al centro de la tierra',
--     'https://firebasestorage.googleapis.com/v0/b/aprumed.appspot.com/o/Books%2FViaje%20al%20centro%20de%20la%20tierra_%20Julio%20Verne.jpg?alt=media&token=298ab2f8-7f10-4852-8080-b9cea57ec061'
--   );

-- INSERT INTO
--   `categoria`
-- VALUES
--   ('Novela', 1, 'Activo'),('Ciencia ficción', 2, 'Activo'),('Literatura peruana', 3, 'Activo'),('Infantil', 4, 'Activo'),('Filosofía', 5, 'Activo'),('Crecimiento personal', 6, 'Activo'),('Idiomas', 7, 'Activo'),('Educación', 8, 'Activo'),('Terror', 9, 'Activo'),('Fantasía', 10, 'Activo'),('Aventura', 11, 'Activo');

-- INSERT INTO
--   `libro`
-- VALUES
--   (
--     'Stephen King',
--     '1977-01-28',
--     '978849032872',
--     49.000,
--     4,
--     'El Resplandor',
--     1,
--     9,
--     'Activo',
--     28
--   ),(
--     'Julio Verne',
--     '1864-11-25',
--     '97895830010',
--     29.000,
--     6,
--     'Viaje Al Centro De La Tierra',
--     2,
--     11,
--     'Activo',
--     29
--   ),(
--     'Ernest Hemingway',
--     '1953-03-15',
--     '9787500120742',
--     29.000,
--     8,
--     'El Viejo Y El Mar',
--     3,
--     1,
--     'Activo',
--     24
--   ),(
--     'Cecelia Ahern',
--     '2004-02-01',
--     '9789603642534',
--     55.000,
--     7,
--     'P.S. I Love You',
--     4,
--     1,
--     'Activo',
--     5
--   ),(
--     'Gabriel García Márquez',
--     '1986-10-28',
--     '9783423113601',
--     30.000,
--     10,
--     'El Amor En Tiempos De Cólera',
--     5,
--     1,
--     'Activo',
--     8
--   ),(
--     'Nicholas Sparks',
--     '1996-10-01',
--     '9788478883356',
--     49.000,
--     9,
--     'The Notebook',
--     6,
--     1,
--     'Activo',
--     23
--   ),(
--     'J.K. Rowling',
--     '1997-06-26',
--     '9788700631625',
--     49.000,
--     9,
--     'Harry Potter y la piedra filosofal',
--     7,
--     10,
--     'Activo',
--     13
--   ),(
--     'J.K. Rowling',
--     '2005-07-16',
--     '9788884516374',
--     59.000,
--     9,
--     'Harry Potter y el misterio del príncipe',
--     8,
--     10,
--     'Activo',
--     14
--   );

-- INSERT INTO
--   `ejemplar`
-- VALUES
--   ('Boo/ElR/Ste1', 3, 'Vendido', 1),('Boo/ElR/Ste/2', 4, 'Vendido', 1),('Boo/ElR/Ste/3', 5, 'Vendido', 1),('Boo/ElR/Ste/4', 6, 'Vendido', 1),('Boo/ElR/Ste/5', 7, 'Vendido', 1),('Boo/ElR/Ste/6', 8, 'En Carrito', 1),('Boo/ElR/Ste/7', 9, 'Activo', 1),('Boo/ElR/Ste/8', 10, 'Activo', 1),('Boo/ElR/Ste/9', 11, 'Activo', 1),('Boo/ElR/Ste/10', 12, 'Activo', 1),('Boo/Via/Jul/1', 13, 'Vendido', 2),('Boo/Via/Jul/2', 14, 'Vendido', 2),('Boo/Via/Jul/3', 15, 'Vendido', 2),('Boo/Via/Jul/4', 16, 'Vendido', 2),('Boo/Via/Jul/5', 17, 'Activo', 2),('Boo/Via/Jul/6', 18, 'Activo', 2),('Boo/Via/Jul/7', 19, 'Activo', 2),('Boo/Via/Jul/8', 20, 'Activo', 2),('Boo/Via/Jul/9', 21, 'Activo', 2),('Boo/Via/Jul/10', 22, 'Activo', 2),('Boo/ElV/Ern/1', 23, 'Vendido', 3),('Boo/ElV/Ern/2', 24, 'Vendido', 3),('Boo/ElV/Ern/3', 25, 'Activo', 3),('Boo/ElV/Ern/4', 26, 'Activo', 3),('Boo/ElV/Ern/5', 27, 'Activo', 3),('Boo/ElV/Ern/6', 28, 'Activo', 3),('Boo/ElV/Ern/7', 29, 'Activo', 3),('Boo/ElV/Ern/8', 30, 'Activo', 3),('Boo/ElV/Ern/9', 31, 'Activo', 3),('Boo/ElV/Ern/10', 32, 'Activo', 3),('Boo/P.S/Cec/1	', 33, 'Vendido', 4),('Boo/P.S/Cec/2', 34, 'Vendido', 4),('Boo/P.S/Cec/3', 35, 'Vendido', 4),('Boo/P.S/Cec/4', 36, 'Activo', 4),('Boo/P.S/Cec/5', 37, 'Activo', 4),('Boo/P.S/Cec/6', 38, 'Activo', 4),('Boo/P.S/Cec/7', 39, 'Activo', 4),('Boo/P.S/Cec/8', 40, 'Activo', 4),('Boo/P.S/Cec/9', 41, 'Activo', 4),('Boo/P.S/Cec/10', 42, 'Activo', 4),('Boo/ElA/Gab/1', 43, 'Activo', 5),('Boo/ElA/Gab/2', 44, 'Activo', 5),('Boo/ElA/Gab/3', 45, 'Activo', 5),('Boo/ElA/Gab/4', 47, 'Activo', 5),('Boo/ElA/Gab/5', 48, 'Activo', 5),('Boo/ElA/Gab/6', 49, 'Activo', 5),('Boo/ElA/Gab/7', 50, 'Activo', 5),('Boo/ElA/Gab/8', 51, 'Activo', 5),('Boo/ElA/Gab/9', 52, 'Activo', 5),('Boo/ElA/Gab/10', 53, 'Activo', 5),('Boo/The/Nic/1', 54, 'Vendido', 6),('Boo/The/Nic/2', 55, 'Activo', 6),('Boo/The/Nic/3', 56, 'Activo', 6),('Boo/The/Nic/4', 57, 'Activo', 6),('Boo/The/Nic/5', 58, 'Activo', 6),('Boo/The/Nic/6', 59, 'Activo', 6),('Boo/The/Nic/7', 60, 'Activo', 6),('Boo/The/Nic/8', 61, 'Activo', 6),('Boo/The/Nic/9', 62, 'Activo', 6),('Boo/The/Nic/10', 63, 'Activo', 6),('Boo/Har/J.K/1', 64, 'Vendido', 7),('Boo/Har/J.K/2', 65, 'Activo', 7),('Boo/Har/J.K/3', 66, 'Activo', 7),('Boo/Har/J.K/4', 67, 'Activo', 7),('Boo/Har/J.K/5', 68, 'Activo', 7),('Boo/Har/J.K/6', 69, 'Activo', 7),('Boo/Har/J.K/7', 70, 'Activo', 7),('Boo/Har/J.K/8', 71, 'Activo', 7),('Boo/Har/J.K/9', 72, 'Activo', 7),('Boo/Har/J.K/10', 73, 'Activo', 7),('Boo/Har/J.K/6/1', 74, 'Activo', 8),('Boo/Har/J.K/6/2', 75, 'Activo', 8),('Boo/Har/J.K/6/3', 76, 'Activo', 8),('Boo/Har/J.K/6/4', 77, 'Activo', 8),('Boo/Har/J.K/6/5', 78, 'Activo', 8),('Boo/Har/J.K/6/6', 79, 'Activo', 8),('Boo/Har/J.K/6/7', 80, 'Activo', 8),('Boo/Har/J.K/6/8', 81, 'Activo', 8),('Boo/Har/J.K/6/9', 82, 'Activo', 8);

-- INSERT INTO
--   `tipousuario`
-- VALUES
--   ('Cliente', 'Activo', 1),('Administrador', 'Activo', 2),('Cajero', 'Activo', 3);

-- DELIMITER $ $
-- create trigger usuarioDefaultSale
-- after
-- insert
--   on usuario for each row begin
-- insert into
--   venta(FechaVenta, HoraVenta, Estado, UsuarioID)
-- values(null, null, 'Activo', new.UsuarioID);

-- end $ $ 
-- DELIMITER ;

-- INSERT INTO
--   `usuario`
-- VALUES
--   (
--     'Cornejo Chunga',
--     'Daniel Badinho',
--     'Masculino',
--     '977969843',
--     'badinhocornejo@gmail.com',
--     'Activo',
--     'cisco123',
--     1,
--     1,
--     2
--   ),(
--     'Cornejo ',
--     'Daniel Admin',
--     'Masculino',
--     '947903931',
--     'badinhocornejo@aprumed.pe',
--     'Activo',
--     'cisco123',
--     2,
--     2,
--     1
--   ),(
--     'Detal',
--     'Fulano',
--     'Masculino',
--     '987264569',
--     'fulanitodetal@gmail.com',
--     'Activo',
--     'cisco123',
--     3,
--     1,
--     1
--   );
