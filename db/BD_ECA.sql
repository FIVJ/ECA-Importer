CREATE DATABASE  IF NOT EXISTS `DB_ECA` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `DB_ECA`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: DB_ECA
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
-- Table structure for table `tb_action`
--

DROP TABLE IF EXISTS `tb_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_action` (
  `id_action` int(11) NOT NULL AUTO_INCREMENT,
  `str_cod_action` varchar(4) NOT NULL,
  `str_name_action` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_action`),
  UNIQUE KEY `str_cod_action_UNIQUE` (`str_cod_action`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_action`
--

LOCK TABLES `tb_action` WRITE;
/*!40000 ALTER TABLE `tb_action` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_beneficiaries`
--

DROP TABLE IF EXISTS `tb_beneficiaries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_beneficiaries` (
  `id_beneficiaries` bigint(20) NOT NULL AUTO_INCREMENT,
  `str_nis` varchar(14) NOT NULL,
  `str_name_person` varchar(255) NOT NULL,
  PRIMARY KEY (`id_beneficiaries`),
  UNIQUE KEY `str_nis_UNIQUE` (`str_nis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_beneficiaries`
--

LOCK TABLES `tb_beneficiaries` WRITE;
/*!40000 ALTER TABLE `tb_beneficiaries` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_beneficiaries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_city`
--

DROP TABLE IF EXISTS `tb_city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_city` (
  `id_city` int(11) NOT NULL AUTO_INCREMENT,
  `str_name_city` varchar(255) DEFAULT NULL,
  `str_cod_siafi_city` varchar(4) NOT NULL,
  `tb_state_id_state` int(11) NOT NULL,
  PRIMARY KEY (`id_city`),
  UNIQUE KEY `str_cod_siafi_city_UNIQUE` (`str_cod_siafi_city`),
  KEY `fk_tb_city_tb_state_idx` (`tb_state_id_state`),
  CONSTRAINT `fk_tb_city_tb_state` FOREIGN KEY (`tb_state_id_state`) REFERENCES `tb_state` (`id_state`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_city`
--

LOCK TABLES `tb_city` WRITE;
/*!40000 ALTER TABLE `tb_city` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_files`
--

DROP TABLE IF EXISTS `tb_files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_files` (
  `id_file` int(11) NOT NULL AUTO_INCREMENT,
  `str_name_file` varchar(45) NOT NULL,
  `str_month` varchar(2) DEFAULT NULL,
  `str_year` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id_file`),
  UNIQUE KEY `str_name_file_UNIQUE` (`str_name_file`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_files`
--

LOCK TABLES `tb_files` WRITE;
/*!40000 ALTER TABLE `tb_files` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_functions`
--

DROP TABLE IF EXISTS `tb_functions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_functions` (
  `id_function` int(11) NOT NULL AUTO_INCREMENT,
  `str_cod_function` varchar(4) NOT NULL,
  `str_name_function` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_function`),
  UNIQUE KEY `str_cod_function_UNIQUE` (`str_cod_function`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_functions`
--

LOCK TABLES `tb_functions` WRITE;
/*!40000 ALTER TABLE `tb_functions` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_functions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_payments`
--

DROP TABLE IF EXISTS `tb_payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_payments` (
  `id_payment` bigint(20) NOT NULL AUTO_INCREMENT,
  `tb_city_id_city` int(11) NOT NULL,
  `tb_functions_id_function` int(11) NOT NULL,
  `tb_subfunctions_id_subfunction` int(11) NOT NULL,
  `tb_program_id_program` int(11) NOT NULL,
  `tb_action_id_action` int(11) NOT NULL,
  `tb_beneficiaries_id_beneficiaries` bigint(20) NOT NULL,
  `tb_source_id_source` int(11) NOT NULL,
  `tb_files_id_file` int(11) NOT NULL,
  `db_value` double NOT NULL,
  PRIMARY KEY (`id_payment`),
  KEY `fk_tb_payments_tb_city1_idx` (`tb_city_id_city`),
  KEY `fk_tb_payments_tb_program1_idx` (`tb_program_id_program`),
  KEY `fk_tb_payments_tb_action1_idx` (`tb_action_id_action`),
  KEY `fk_tb_payments_tb_source1_idx` (`tb_source_id_source`),
  KEY `fk_tb_payments_tb_files1_idx` (`tb_files_id_file`),
  KEY `fk_tb_payments_tb_functions1_idx` (`tb_functions_id_function`),
  KEY `fk_tb_payments_tb_subfunctions1_idx` (`tb_subfunctions_id_subfunction`),
  KEY `fk_tb_payments_tb_beneficiaries1_idx` (`tb_beneficiaries_id_beneficiaries`),
  CONSTRAINT `fk_tb_payments_tb_action1` FOREIGN KEY (`tb_action_id_action`) REFERENCES `tb_action` (`id_action`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_payments_tb_beneficiaries1` FOREIGN KEY (`tb_beneficiaries_id_beneficiaries`) REFERENCES `tb_beneficiaries` (`id_beneficiaries`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_payments_tb_city1` FOREIGN KEY (`tb_city_id_city`) REFERENCES `tb_city` (`id_city`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_payments_tb_files1` FOREIGN KEY (`tb_files_id_file`) REFERENCES `tb_files` (`id_file`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_payments_tb_functions1` FOREIGN KEY (`tb_functions_id_function`) REFERENCES `tb_functions` (`id_function`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_payments_tb_program1` FOREIGN KEY (`tb_program_id_program`) REFERENCES `tb_program` (`id_program`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_payments_tb_source1` FOREIGN KEY (`tb_source_id_source`) REFERENCES `tb_source` (`id_source`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_payments_tb_subfunctions1` FOREIGN KEY (`tb_subfunctions_id_subfunction`) REFERENCES `tb_subfunctions` (`id_subfunction`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_payments`
--

LOCK TABLES `tb_payments` WRITE;
/*!40000 ALTER TABLE `tb_payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_program`
--

DROP TABLE IF EXISTS `tb_program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_program` (
  `id_program` int(11) NOT NULL AUTO_INCREMENT,
  `str_cod_program` varchar(4) NOT NULL,
  `str_name_program` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_program`),
  UNIQUE KEY `str_cod_program_UNIQUE` (`str_cod_program`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_program`
--

LOCK TABLES `tb_program` WRITE;
/*!40000 ALTER TABLE `tb_program` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_region`
--

DROP TABLE IF EXISTS `tb_region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_region` (
  `id_region` int(11) NOT NULL AUTO_INCREMENT,
  `str_name_region` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id_region`),
  UNIQUE KEY `str_name_region_UNIQUE` (`str_name_region`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_region`
--

LOCK TABLES `tb_region` WRITE;
/*!40000 ALTER TABLE `tb_region` DISABLE KEYS */;
INSERT INTO `tb_region` VALUES (5,'Centro-Oeste'),(2,'Nordeste'),(1,'Norte'),(3,'Sudeste'),(4,'Sul');
/*!40000 ALTER TABLE `tb_region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_source`
--

DROP TABLE IF EXISTS `tb_source`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_source` (
  `id_source` int(11) NOT NULL AUTO_INCREMENT,
  `str_goal` varchar(255) NOT NULL,
  `str_origin` varchar(255) DEFAULT NULL,
  `str_periodicity` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`id_source`),
  UNIQUE KEY `str_goal_UNIQUE` (`str_goal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_source`
--

LOCK TABLES `tb_source` WRITE;
/*!40000 ALTER TABLE `tb_source` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_source` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_state`
--

DROP TABLE IF EXISTS `tb_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_state` (
  `id_state` int(11) NOT NULL AUTO_INCREMENT,
  `str_uf` varchar(2) NOT NULL,
  `str_name` varchar(19) DEFAULT NULL,
  `tb_region_id_region` int(11) NOT NULL,
  PRIMARY KEY (`id_state`),
  UNIQUE KEY `str_uf_UNIQUE` (`str_uf`),
  UNIQUE KEY `str_name_UNIQUE` (`str_name`),
  KEY `fk_tb_state_tb_region1_idx` (`tb_region_id_region`),
  CONSTRAINT `fk_tb_state_tb_region1` FOREIGN KEY (`tb_region_id_region`) REFERENCES `tb_region` (`id_region`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_state`
--

LOCK TABLES `tb_state` WRITE;
/*!40000 ALTER TABLE `tb_state` DISABLE KEYS */;
INSERT INTO `tb_state` VALUES (1,'AC','Acre',1),(2,'AP','Amapá',1),(3,'AM','Amazonas',1),(4,'RO','Rondônia',1),(5,'RR','Roraima',1),(6,'TO','Tocantins',1),(7,'AL','Alagoas',2),(8,'BA','Bahia',2),(9,'CE','Ceará',2),(10,'MA','Maranhão',2),(11,'PB','Paraíba',2),(12,'PA','Pará',2),(13,'PE','Pernambuco',2),(14,'PI','Piauí',2),(15,'RN','Rio Grande do Norte',2),(16,'SE','Sergipe',2),(17,'ES','Espírito Santo',3),(18,'MG','Minas Gerais',3),(19,'RJ','Rio de Janeiro',3),(20,'SP','São Paulo',3),(21,'PR','Paraná',4),(22,'RS','Rio Grande do Sul',4),(23,'SC','Santa Catarina',4),(24,'DF','Distrito Federal',5),(25,'GO','Goiás',5),(26,'MT','Mato Grosso',5),(27,'MS','Mato Grosso do Sul',5);
/*!40000 ALTER TABLE `tb_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_subfunctions`
--

DROP TABLE IF EXISTS `tb_subfunctions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_subfunctions` (
  `id_subfunction` int(11) NOT NULL AUTO_INCREMENT,
  `str_cod_subfunction` varchar(4) NOT NULL,
  `str_name_subfunction` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_subfunction`),
  UNIQUE KEY `str_cod_subfunction_UNIQUE` (`str_cod_subfunction`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_subfunctions`
--

LOCK TABLES `tb_subfunctions` WRITE;
/*!40000 ALTER TABLE `tb_subfunctions` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_subfunctions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-05 15:59:56
