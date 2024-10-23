CREATE DATABASE  IF NOT EXISTS `FernandoCastillo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `FernandoCastillo`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: bdbiblioteca
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `bibliotecario`
--

DROP TABLE IF EXISTS `bibliotecario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bibliotecario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `idcategoria` int NOT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idcategoria` (`idcategoria`),
  CONSTRAINT `bibliotecario_ibfk_1` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bibliotecario`
--

LOCK TABLES `bibliotecario` WRITE;
/*!40000 ALTER TABLE `bibliotecario` DISABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleprestamo`
--

DROP TABLE IF EXISTS `detalleprestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalleprestamo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idprestamo` int NOT NULL,
  `idlibro` int NOT NULL,
  `instrucciones` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idprestamo` (`idprestamo`),
  KEY `idlibro` (`idlibro`),
  CONSTRAINT `detalleprestamo_ibfk_1` FOREIGN KEY (`idprestamo`) REFERENCES `prestamo` (`id`),
  CONSTRAINT `detalleprestamo_ibfk_2` FOREIGN KEY (`idlibro`) REFERENCES `libro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleprestamo`
--

LOCK TABLES `detalleprestamo` WRITE;
/*!40000 ALTER TABLE `detalleprestamo` DISABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `autor` varchar(100) DEFAULT NULL,
  `precio` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `miembro`
--

DROP TABLE IF EXISTS `miembro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `miembro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `fechanacimiento` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `miembro`
--

LOCK TABLES `miembro` WRITE;
/*!40000 ALTER TABLE `miembro` DISABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prestamo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idmiembro` int NOT NULL,
  `idlibro` int NOT NULL,
  `fecha_prestamo` date NOT NULL,
  `fecha_devolucion` date DEFAULT NULL,
  `motivo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idmiembro` (`idmiembro`),
  KEY `idlibro` (`idlibro`),
  CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`idmiembro`) REFERENCES `miembro` (`id`),
  CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`idlibro`) REFERENCES `libro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamo`
--

LOCK TABLES `prestamo` WRITE;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-23  6:46:14

-- Insertar 8 nuevos datos en la tabla `bibliotecario`
INSERT INTO `bibliotecario` VALUES 
(9, 'Lucía Martínez', 2, '912345678', 'lmartinez@biblioteca.com'),
(10, 'Pedro Rojas', 3, '912345679', 'projas@biblioteca.com'),
(11, 'Sofía González', 1, '987654322', 'sgonzalez@biblioteca.com'),
(12, 'Andrés Flores', 4, '923456780', 'aflores@biblioteca.com'),
(13, 'Daniela Ortega', 5, '934567891', 'dortega@biblioteca.com'),
(14, 'Roberto Paredes', 6, '945678902', 'rparedes@biblioteca.com'),
(15, 'Carmen Vásquez', 7, '956789013', 'cvasquez@biblioteca.com'),
(16, 'Francisco Herrera', 8, '967890124', 'fherrera@biblioteca.com');

-- Insertar 8 nuevos datos en la tabla `categoria`
INSERT INTO `categoria` VALUES 
(9, 'Biblioteca Digital', 'Gestiona colecciones y recursos en formato digital'),
(10, 'Conservación y Restauración', 'Preserva y restaura materiales deteriorados'),
(11, 'Consultoría', 'Ofrece asesoría a usuarios sobre fuentes de información'),
(12, 'Referencias Rápidas', 'Ayuda a encontrar información de manera rápida'),
(13, 'Investigación Académica', 'Apoyo especializado en investigaciones académicas'),
(14, 'Recursos Multimedia', 'Se especializa en recursos no textuales como videos y audio'),
(15, 'Documentación Legal', 'Manejo de documentos legales en la biblioteca'),
(16, 'Gestión de Proyectos', 'Coordina proyectos y programas dentro de la biblioteca');

-- Insertar 8 nuevos datos en la tabla `detalleprestamo`
INSERT INTO `detalleprestamo` VALUES 
(9, 1, 4, 'Mantener el libro fuera del alcance de niños'),
(10, 2, 5, 'Devolver en 15 días sin daños'),
(11, 3, 6, 'No doblar las esquinas de las páginas'),
(12, 4, 7, 'Devolver antes de la fecha límite'),
(13, 5, 8, 'No usar marcador en el libro'),
(14, 6, 1, 'Mantener el libro limpio'),
(15, 7, 2, 'Leer con cuidado'),
(16, 8, 3, 'Consultar con el bibliotecario si hay daños');

-- Insertar 8 nuevos datos en la tabla `libro`
INSERT INTO `libro` VALUES 
(9, 'Rayuela', 'Julio Cortázar', 32.50),
(10, 'La sombra del viento', 'Carlos Ruiz Zafón', 27.00),
(11, 'El señor de los anillos', 'J.R.R. Tolkien', 40.00),
(12, 'Harry Potter y la piedra filosofal', 'J.K. Rowling', 35.00),
(13, 'El nombre de la rosa', 'Umberto Eco', 38.00),
(14, 'El alquimista', 'Paulo Coelho', 25.00),
(15, 'Los miserables', 'Victor Hugo', 42.00),
(16, 'Orgullo y prejuicio', 'Jane Austen', 30.00);

-- Insertar 8 nuevos datos en la tabla `miembro`
INSERT INTO `miembro` VALUES 
(9, 'Fernando Castillo', 'Av. Literario 101', '945678901', '1987-11-02'),
(10, 'Isabel Torres', 'Calle Cultura 505', '956789123', '1992-08-17'),
(11, 'José Gutiérrez', 'Av. Libros 600', '912345670', '1980-04-12'),
(12, 'Mariana Espinoza', 'Jr. Novelas 202', '921234568', '1991-07-23'),
(13, 'Laura Paredes', 'Av. Autores 300', '923456781', '1996-11-05'),
(14, 'Raúl Zárate', 'Av. Páginas 404', '911223345', '1982-03-18'),
(15, 'Sandra Pérez', 'Jr. Lectura 707', '922233345', '1977-09-27'),
(16, 'Mónica Chávez', 'Av. Historias 606', '931234568', '1993-02-14');

-- Insertar 8 nuevos datos en la tabla `prestamo`
INSERT INTO `prestamo` VALUES 
(9, 9, 9, '2024-10-11', NULL, 'Lectura recreativa'),
(10, 10, 10, '2024-10-12', '2024-10-20', 'Estudio personal'),
(11, 11, 11, '2024-10-13', NULL, 'Lectura en grupo'),
(12, 12, 12, '2024-10-14', '2024-10-21', 'Investigación académica'),
(13, 13, 13, '2024-10-15', NULL, 'Consulta rápida'),
(14, 14, 14, '2024-10-16', '2024-10-23', 'Revisión para examen'),
(15, 15, 15, '2024-10-17', NULL, 'Uso profesional'),
(16, 16, 16, '2024-10-18', '2024-10-25', 'Lectura para ocio');

