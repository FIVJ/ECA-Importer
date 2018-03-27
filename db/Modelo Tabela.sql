CREATE DATABASE  IF NOT EXISTS `DB_ECA` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `DB_ECA`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: DB_ECA
-- ------------------------------------------------------
-- Server version	5.7.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_PBFPayments2011`
--

DROP TABLE IF EXISTS `tb_PBFPayments2011`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_PBFPayments2011` (
  `idPBFPayments2011` bigint(11) NOT NULL AUTO_INCREMENT,
  `NIS` varchar(14) NOT NULL,
  `Name` varchar(60) NOT NULL,
  `Siafi` varchar(45) NOT NULL,
  `City` varchar(60) NOT NULL,
  `State` varchar(2) NOT NULL,
  `Region` varchar(12) NOT NULL,
  `File` varchar(45) NOT NULL,
  `Month` int(2) NOT NULL,
  `Year` int(4) NOT NULL,
  `Program` int(2) NOT NULL,
  `Action` int(2) NOT NULL,
  `Function` int(2) NOT NULL,
  `SubFunction` int(2) NOT NULL,
  `Source` varchar(45) NOT NULL,
  `Value` double NOT NULL,
  PRIMARY KEY (`idPBFPayments2011`),
  KEY `iNIS` (`NIS`),
  KEY `iName` (`Name`),
  KEY `iSiafi` (`Siafi`),
  KEY `iCity` (`City`),
  KEY `iState` (`State`),
  KEY `iRegion` (`Region`),
  KEY `iFile` (`File`),
  KEY `iMonth` (`Month`),
  KEY `iYear` (`Year`),
  KEY `iValue` (`Value`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-14 12:24:35
