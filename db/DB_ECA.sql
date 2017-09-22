CREATE DATABASE  IF NOT EXISTS `eca` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `eca`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: eca
-- ------------------------------------------------------
-- Server version	5.7.18

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
-- Table structure for table `PBF_PAGAMENTOS_2011`
--

DROP TABLE IF EXISTS `PBF_PAGAMENTOS_2011`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PBF_PAGAMENTOS_2011` (
  `idPBF_PAGAMENTOS` bigint(255) NOT NULL AUTO_INCREMENT,
  `UF` varchar(2) DEFAULT NULL,
  `Codigo_SIAFI_Municipio` int(11) DEFAULT NULL,
  `Nome_Municipio` varchar(255) DEFAULT NULL,
  `Codigo_Funcao` int(11) DEFAULT NULL,
  `Codigo_Subfuncao` int(11) DEFAULT NULL,
  `Codigo_Programa` int(11) DEFAULT NULL,
  `Codigo_Acao` int(11) DEFAULT NULL,
  `NIS_Favorecido` varchar(255) DEFAULT NULL,
  `Nome_Favorecido` varchar(255) DEFAULT NULL,
  `Fonte_Finalidade` varchar(255) DEFAULT NULL,
  `Valor_Parcela` double DEFAULT NULL,
  `Mes_Competencia` varchar(2) DEFAULT NULL,
  `Ano_Competencia` varchar(4) DEFAULT NULL,
  `Atualizacao` varchar(255) DEFAULT NULL,
  `Origem` varchar(255) DEFAULT NULL,
  `Arquivo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPBF_PAGAMENTOS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PBF_PAGAMENTOS_2012`
--

DROP TABLE IF EXISTS `PBF_PAGAMENTOS_2012`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PBF_PAGAMENTOS_2012` (
  `idPBF_PAGAMENTOS` bigint(255) NOT NULL AUTO_INCREMENT,
  `UF` varchar(2) DEFAULT NULL,
  `Codigo_SIAFI_Municipio` int(11) DEFAULT NULL,
  `Nome_Municipio` varchar(255) DEFAULT NULL,
  `Codigo_Funcao` int(11) DEFAULT NULL,
  `Codigo_Subfuncao` int(11) DEFAULT NULL,
  `Codigo_Programa` int(11) DEFAULT NULL,
  `Codigo_Acao` int(11) DEFAULT NULL,
  `NIS_Favorecido` varchar(255) DEFAULT NULL,
  `Nome_Favorecido` varchar(255) DEFAULT NULL,
  `Fonte_Finalidade` varchar(255) DEFAULT NULL,
  `Valor_Parcela` double DEFAULT NULL,
  `Mes_Competencia` varchar(2) DEFAULT NULL,
  `Ano_Competencia` varchar(4) DEFAULT NULL,
  `Atualizacao` varchar(255) DEFAULT NULL,
  `Origem` varchar(255) DEFAULT NULL,
  `Arquivo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPBF_PAGAMENTOS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PBF_PAGAMENTOS_2013`
--

DROP TABLE IF EXISTS `PBF_PAGAMENTOS_2013`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PBF_PAGAMENTOS_2013` (
  `idPBF_PAGAMENTOS` bigint(255) NOT NULL AUTO_INCREMENT,
  `UF` varchar(2) DEFAULT NULL,
  `Codigo_SIAFI_Municipio` int(11) DEFAULT NULL,
  `Nome_Municipio` varchar(255) DEFAULT NULL,
  `Codigo_Funcao` int(11) DEFAULT NULL,
  `Codigo_Subfuncao` int(11) DEFAULT NULL,
  `Codigo_Programa` int(11) DEFAULT NULL,
  `Codigo_Acao` int(11) DEFAULT NULL,
  `NIS_Favorecido` varchar(255) DEFAULT NULL,
  `Nome_Favorecido` varchar(255) DEFAULT NULL,
  `Fonte_Finalidade` varchar(255) DEFAULT NULL,
  `Valor_Parcela` double DEFAULT NULL,
  `Mes_Competencia` varchar(2) DEFAULT NULL,
  `Ano_Competencia` varchar(4) DEFAULT NULL,
  `Atualizacao` varchar(255) DEFAULT NULL,
  `Origem` varchar(255) DEFAULT NULL,
  `Arquivo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPBF_PAGAMENTOS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PBF_PAGAMENTOS_2014`
--

DROP TABLE IF EXISTS `PBF_PAGAMENTOS_2014`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PBF_PAGAMENTOS_2014` (
  `idPBF_PAGAMENTOS` bigint(255) NOT NULL AUTO_INCREMENT,
  `UF` varchar(2) DEFAULT NULL,
  `Codigo_SIAFI_Municipio` int(11) DEFAULT NULL,
  `Nome_Municipio` varchar(255) DEFAULT NULL,
  `Codigo_Funcao` int(11) DEFAULT NULL,
  `Codigo_Subfuncao` int(11) DEFAULT NULL,
  `Codigo_Programa` int(11) DEFAULT NULL,
  `Codigo_Acao` int(11) DEFAULT NULL,
  `NIS_Favorecido` varchar(255) DEFAULT NULL,
  `Nome_Favorecido` varchar(255) DEFAULT NULL,
  `Fonte_Finalidade` varchar(255) DEFAULT NULL,
  `Valor_Parcela` double DEFAULT NULL,
  `Mes_Competencia` varchar(2) DEFAULT NULL,
  `Ano_Competencia` varchar(4) DEFAULT NULL,
  `Atualizacao` varchar(255) DEFAULT NULL,
  `Origem` varchar(255) DEFAULT NULL,
  `Arquivo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPBF_PAGAMENTOS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PBF_PAGAMENTOS_2015`
--

DROP TABLE IF EXISTS `PBF_PAGAMENTOS_2015`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PBF_PAGAMENTOS_2015` (
  `idPBF_PAGAMENTOS` bigint(255) NOT NULL AUTO_INCREMENT,
  `UF` varchar(2) DEFAULT NULL,
  `Codigo_SIAFI_Municipio` int(11) DEFAULT NULL,
  `Nome_Municipio` varchar(255) DEFAULT NULL,
  `Codigo_Funcao` int(11) DEFAULT NULL,
  `Codigo_Subfuncao` int(11) DEFAULT NULL,
  `Codigo_Programa` int(11) DEFAULT NULL,
  `Codigo_Acao` int(11) DEFAULT NULL,
  `NIS_Favorecido` varchar(255) DEFAULT NULL,
  `Nome_Favorecido` varchar(255) DEFAULT NULL,
  `Fonte_Finalidade` varchar(255) DEFAULT NULL,
  `Valor_Parcela` double DEFAULT NULL,
  `Mes_Competencia` varchar(2) DEFAULT NULL,
  `Ano_Competencia` varchar(4) DEFAULT NULL,
  `Atualizacao` varchar(255) DEFAULT NULL,
  `Origem` varchar(255) DEFAULT NULL,
  `Arquivo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPBF_PAGAMENTOS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PBF_PAGAMENTOS_2016`
--

DROP TABLE IF EXISTS `PBF_PAGAMENTOS_2016`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PBF_PAGAMENTOS_2016` (
  `idPBF_PAGAMENTOS` bigint(255) NOT NULL AUTO_INCREMENT,
  `UF` varchar(2) DEFAULT NULL,
  `Codigo_SIAFI_Municipio` int(11) DEFAULT NULL,
  `Nome_Municipio` varchar(255) DEFAULT NULL,
  `Codigo_Funcao` int(11) DEFAULT NULL,
  `Codigo_Subfuncao` int(11) DEFAULT NULL,
  `Codigo_Programa` int(11) DEFAULT NULL,
  `Codigo_Acao` int(11) DEFAULT NULL,
  `NIS_Favorecido` varchar(255) DEFAULT NULL,
  `Nome_Favorecido` varchar(255) DEFAULT NULL,
  `Fonte_Finalidade` varchar(255) DEFAULT NULL,
  `Valor_Parcela` double DEFAULT NULL,
  `Mes_Competencia` varchar(2) DEFAULT NULL,
  `Ano_Competencia` varchar(4) DEFAULT NULL,
  `Atualizacao` varchar(255) DEFAULT NULL,
  `Origem` varchar(255) DEFAULT NULL,
  `Arquivo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPBF_PAGAMENTOS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PBF_PAGAMENTOS_2017`
--

DROP TABLE IF EXISTS `PBF_PAGAMENTOS_2017`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PBF_PAGAMENTOS_2017` (
  `idPBF_PAGAMENTOS` bigint(255) NOT NULL AUTO_INCREMENT,
  `UF` varchar(2) DEFAULT NULL,
  `Codigo_SIAFI_Municipio` int(11) DEFAULT NULL,
  `Nome_Municipio` varchar(255) DEFAULT NULL,
  `Codigo_Funcao` int(11) DEFAULT NULL,
  `Codigo_Subfuncao` int(11) DEFAULT NULL,
  `Codigo_Programa` int(11) DEFAULT NULL,
  `Codigo_Acao` int(11) DEFAULT NULL,
  `NIS_Favorecido` varchar(255) DEFAULT NULL,
  `Nome_Favorecido` varchar(255) DEFAULT NULL,
  `Fonte_Finalidade` varchar(255) DEFAULT NULL,
  `Valor_Parcela` double DEFAULT NULL,
  `Mes_Competencia` varchar(2) DEFAULT NULL,
  `Ano_Competencia` varchar(4) DEFAULT NULL,
  `Atualizacao` varchar(255) DEFAULT NULL,
  `Origem` varchar(255) DEFAULT NULL,
  `Arquivo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPBF_PAGAMENTOS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PBF_SAQUES_2011`
--

DROP TABLE IF EXISTS `PBF_SAQUES_2011`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PBF_SAQUES_2011` (
  `idPBF_SAQUES` bigint(255) NOT NULL AUTO_INCREMENT,
  `UF` varchar(2) DEFAULT NULL,
  `Codigo_SIAFI_Municipio` int(11) DEFAULT NULL,
  `Nome_Municipio` varchar(255) DEFAULT NULL,
  `Codigo_Funcao` int(11) DEFAULT NULL,
  `Codigo_Subfuncao` int(11) DEFAULT NULL,
  `Codigo_Programa` int(11) DEFAULT NULL,
  `Codigo_Acao` int(11) DEFAULT NULL,
  `NIS_Favorecido` varchar(255) DEFAULT NULL,
  `Nome_Favorecido` varchar(255) DEFAULT NULL,
  `Fonte_Finalidade` varchar(255) DEFAULT NULL,
  `Mes_Referencia_Parcela` varchar(255) DEFAULT NULL,
  `Valor_Parcela` double DEFAULT NULL,
  `Mes_Competencia` varchar(2) DEFAULT NULL,
  `Ano_Competencia` varchar(4) DEFAULT NULL,
  `Data_Saque` date DEFAULT NULL,
  `Atualizacao` varchar(255) DEFAULT NULL,
  `Origem` varchar(255) DEFAULT NULL,
  `Arquivo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPBF_SAQUES`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `PBF_SAQUES_2012`
--

DROP TABLE IF EXISTS `PBF_SAQUES_2012`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PBF_SAQUES_2012` (
  `idPBF_SAQUES` bigint(255) NOT NULL AUTO_INCREMENT,
  `UF` varchar(2) DEFAULT NULL,
  `Codigo_SIAFI_Municipio` int(11) DEFAULT NULL,
  `Nome_Municipio` varchar(255) DEFAULT NULL,
  `Codigo_Funcao` int(11) DEFAULT NULL,
  `Codigo_Subfuncao` int(11) DEFAULT NULL,
  `Codigo_Programa` int(11) DEFAULT NULL,
  `Codigo_Acao` int(11) DEFAULT NULL,
  `NIS_Favorecido` varchar(255) DEFAULT NULL,
  `Nome_Favorecido` varchar(255) DEFAULT NULL,
  `Fonte_Finalidade` varchar(255) DEFAULT NULL,
  `Mes_Referencia_Parcela` varchar(255) DEFAULT NULL,
  `Valor_Parcela` double DEFAULT NULL,
  `Mes_Competencia` varchar(2) DEFAULT NULL,
  `Ano_Competencia` varchar(4) DEFAULT NULL,
  `Data_Saque` date DEFAULT NULL,
  `Atualizacao` varchar(255) DEFAULT NULL,
  `Origem` varchar(255) DEFAULT NULL,
  `Arquivo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPBF_SAQUES`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `PBF_SAQUES_2013`
--

DROP TABLE IF EXISTS `PBF_SAQUES_2013`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PBF_SAQUES_2013` (
  `idPBF_SAQUES` bigint(255) NOT NULL AUTO_INCREMENT,
  `UF` varchar(2) DEFAULT NULL,
  `Codigo_SIAFI_Municipio` int(11) DEFAULT NULL,
  `Nome_Municipio` varchar(255) DEFAULT NULL,
  `Codigo_Funcao` int(11) DEFAULT NULL,
  `Codigo_Subfuncao` int(11) DEFAULT NULL,
  `Codigo_Programa` int(11) DEFAULT NULL,
  `Codigo_Acao` int(11) DEFAULT NULL,
  `NIS_Favorecido` varchar(255) DEFAULT NULL,
  `Nome_Favorecido` varchar(255) DEFAULT NULL,
  `Fonte_Finalidade` varchar(255) DEFAULT NULL,
  `Mes_Referencia_Parcela` varchar(255) DEFAULT NULL,
  `Valor_Parcela` double DEFAULT NULL,
  `Mes_Competencia` varchar(2) DEFAULT NULL,
  `Ano_Competencia` varchar(4) DEFAULT NULL,
  `Data_Saque` date DEFAULT NULL,
  `Atualizacao` varchar(255) DEFAULT NULL,
  `Origem` varchar(255) DEFAULT NULL,
  `Arquivo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPBF_SAQUES`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `PBF_SAQUES_2014`
--

DROP TABLE IF EXISTS `PBF_SAQUES_2014`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PBF_SAQUES_2014` (
  `idPBF_SAQUES` bigint(255) NOT NULL AUTO_INCREMENT,
  `UF` varchar(2) DEFAULT NULL,
  `Codigo_SIAFI_Municipio` int(11) DEFAULT NULL,
  `Nome_Municipio` varchar(255) DEFAULT NULL,
  `Codigo_Funcao` int(11) DEFAULT NULL,
  `Codigo_Subfuncao` int(11) DEFAULT NULL,
  `Codigo_Programa` int(11) DEFAULT NULL,
  `Codigo_Acao` int(11) DEFAULT NULL,
  `NIS_Favorecido` varchar(255) DEFAULT NULL,
  `Nome_Favorecido` varchar(255) DEFAULT NULL,
  `Fonte_Finalidade` varchar(255) DEFAULT NULL,
  `Mes_Referencia_Parcela` varchar(255) DEFAULT NULL,
  `Valor_Parcela` double DEFAULT NULL,
  `Mes_Competencia` varchar(2) DEFAULT NULL,
  `Ano_Competencia` varchar(4) DEFAULT NULL,
  `Data_Saque` date DEFAULT NULL,
  `Atualizacao` varchar(255) DEFAULT NULL,
  `Origem` varchar(255) DEFAULT NULL,
  `Arquivo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPBF_SAQUES`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `PBF_SAQUES_2015`
--

DROP TABLE IF EXISTS `PBF_SAQUES_2015`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PBF_SAQUES_2015` (
  `idPBF_SAQUES` bigint(255) NOT NULL AUTO_INCREMENT,
  `UF` varchar(2) DEFAULT NULL,
  `Codigo_SIAFI_Municipio` int(11) DEFAULT NULL,
  `Nome_Municipio` varchar(255) DEFAULT NULL,
  `Codigo_Funcao` int(11) DEFAULT NULL,
  `Codigo_Subfuncao` int(11) DEFAULT NULL,
  `Codigo_Programa` int(11) DEFAULT NULL,
  `Codigo_Acao` int(11) DEFAULT NULL,
  `NIS_Favorecido` varchar(255) DEFAULT NULL,
  `Nome_Favorecido` varchar(255) DEFAULT NULL,
  `Fonte_Finalidade` varchar(255) DEFAULT NULL,
  `Mes_Referencia_Parcela` varchar(255) DEFAULT NULL,
  `Valor_Parcela` double DEFAULT NULL,
  `Mes_Competencia` varchar(2) DEFAULT NULL,
  `Ano_Competencia` varchar(4) DEFAULT NULL,
  `Data_Saque` date DEFAULT NULL,
  `Atualizacao` varchar(255) DEFAULT NULL,
  `Origem` varchar(255) DEFAULT NULL,
  `Arquivo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPBF_SAQUES`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `PBF_SAQUES_2016`
--

DROP TABLE IF EXISTS `PBF_SAQUES_2016`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PBF_SAQUES_2016` (
  `idPBF_SAQUES` bigint(255) NOT NULL AUTO_INCREMENT,
  `UF` varchar(2) DEFAULT NULL,
  `Codigo_SIAFI_Municipio` int(11) DEFAULT NULL,
  `Nome_Municipio` varchar(255) DEFAULT NULL,
  `Codigo_Funcao` int(11) DEFAULT NULL,
  `Codigo_Subfuncao` int(11) DEFAULT NULL,
  `Codigo_Programa` int(11) DEFAULT NULL,
  `Codigo_Acao` int(11) DEFAULT NULL,
  `NIS_Favorecido` varchar(255) DEFAULT NULL,
  `Nome_Favorecido` varchar(255) DEFAULT NULL,
  `Fonte_Finalidade` varchar(255) DEFAULT NULL,
  `Mes_Referencia_Parcela` varchar(255) DEFAULT NULL,
  `Valor_Parcela` double DEFAULT NULL,
  `Mes_Competencia` varchar(2) DEFAULT NULL,
  `Ano_Competencia` varchar(4) DEFAULT NULL,
  `Data_Saque` date DEFAULT NULL,
  `Atualizacao` varchar(255) DEFAULT NULL,
  `Origem` varchar(255) DEFAULT NULL,
  `Arquivo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPBF_SAQUES`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Table structure for table `PBF_SAQUES_2017`
--

DROP TABLE IF EXISTS `PBF_SAQUES_2017`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PBF_SAQUES_2017` (
  `idPBF_SAQUES` bigint(255) NOT NULL AUTO_INCREMENT,
  `UF` varchar(2) DEFAULT NULL,
  `Codigo_SIAFI_Municipio` int(11) DEFAULT NULL,
  `Nome_Municipio` varchar(255) DEFAULT NULL,
  `Codigo_Funcao` int(11) DEFAULT NULL,
  `Codigo_Subfuncao` int(11) DEFAULT NULL,
  `Codigo_Programa` int(11) DEFAULT NULL,
  `Codigo_Acao` int(11) DEFAULT NULL,
  `NIS_Favorecido` varchar(255) DEFAULT NULL,
  `Nome_Favorecido` varchar(255) DEFAULT NULL,
  `Fonte_Finalidade` varchar(255) DEFAULT NULL,
  `Mes_Referencia_Parcela` varchar(255) DEFAULT NULL,
  `Valor_Parcela` double DEFAULT NULL,
  `Mes_Competencia` varchar(2) DEFAULT NULL,
  `Ano_Competencia` varchar(4) DEFAULT NULL,
  `Data_Saque` date DEFAULT NULL,
  `Atualizacao` varchar(255) DEFAULT NULL,
  `Origem` varchar(255) DEFAULT NULL,
  `Arquivo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPBF_SAQUES`)
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

-- Dump completed on 2017-09-21 19:22:25
