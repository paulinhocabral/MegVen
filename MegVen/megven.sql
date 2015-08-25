-- MySQL dump 10.13  Distrib 5.6.16, for Win64 (x86_64)
--
-- Host: localhost    Database: megven
-- ------------------------------------------------------
-- Server version	5.6.16-log

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
-- Table structure for table `auditoria`
--

DROP TABLE IF EXISTS `auditoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auditoria` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `dataHora` timestamp NULL DEFAULT NULL,
  `acao` varchar(256) DEFAULT NULL,
  `valorAnterior` varchar(256) DEFAULT NULL,
  `valorPosterior` varchar(256) DEFAULT NULL,
  `Usuario_Codigo` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_Auditoria_Usuario1_idx` (`Usuario_Codigo`),
  CONSTRAINT `fk_Auditoria_Usuario1` FOREIGN KEY (`Usuario_Codigo`) REFERENCES `usuario` (`Codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditoria`
--

LOCK TABLES `auditoria` WRITE;
/*!40000 ALTER TABLE `auditoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `auditoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  `Telefone` varchar(20) DEFAULT NULL,
  `Ceuluar` varchar(20) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Teste','(11)1111-1111','(11)1111-1111','email');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filial`
--

DROP TABLE IF EXISTS `filial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filial` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  `Cidade` varchar(45) NOT NULL,
  `Usuario_Codigo` int(11) NOT NULL,
  PRIMARY KEY (`Codigo`),
  KEY `fk_Filial_Usuario1_idx` (`Usuario_Codigo`),
  CONSTRAINT `fk_Filial_Usuario1` FOREIGN KEY (`Usuario_Codigo`) REFERENCES `usuario` (`Codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filial`
--

LOCK TABLES `filial` WRITE;
/*!40000 ALTER TABLE `filial` DISABLE KEYS */;
/*!40000 ALTER TABLE `filial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orcamento`
--

DROP TABLE IF EXISTS `orcamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orcamento` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `Data` date DEFAULT NULL,
  `Cliente_Codigo` int(11) NOT NULL,
  PRIMARY KEY (`Codigo`),
  KEY `fk_Orcamento_Cliente1_idx` (`Cliente_Codigo`),
  CONSTRAINT `fk_Orcamento_Cliente1` FOREIGN KEY (`Cliente_Codigo`) REFERENCES `cliente` (`Codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orcamento`
--

LOCK TABLES `orcamento` WRITE;
/*!40000 ALTER TABLE `orcamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `orcamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orcamento_produtoestoque`
--

DROP TABLE IF EXISTS `orcamento_produtoestoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orcamento_produtoestoque` (
  `ProdutoEstoque_Produtos_Codigo` int(11) NOT NULL,
  `ProdutoEstoque_CodigoEstoque` int(11) NOT NULL,
  `Orcamento_Codigo` int(11) NOT NULL,
  KEY `fk_Orcamento_ProdutoEstoque_ProdutoEstoque1_idx` (`ProdutoEstoque_Produtos_Codigo`,`ProdutoEstoque_CodigoEstoque`),
  KEY `fk_Orcamento_ProdutoEstoque_Orcamento1_idx` (`Orcamento_Codigo`),
  CONSTRAINT `fk_Orcamento_ProdutoEstoque_ProdutoEstoque1` FOREIGN KEY (`ProdutoEstoque_Produtos_Codigo`, `ProdutoEstoque_CodigoEstoque`) REFERENCES `produtoestoque` (`Produtos_Codigo`, `CodigoEstoque`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orcamento_ProdutoEstoque_Orcamento1` FOREIGN KEY (`Orcamento_Codigo`) REFERENCES `orcamento` (`Codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orcamento_produtoestoque`
--

LOCK TABLES `orcamento_produtoestoque` WRITE;
/*!40000 ALTER TABLE `orcamento_produtoestoque` DISABLE KEYS */;
/*!40000 ALTER TABLE `orcamento_produtoestoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtoestoque`
--

DROP TABLE IF EXISTS `produtoestoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtoestoque` (
  `Produtos_Codigo` int(11) NOT NULL,
  `CodigoEstoque` int(11) NOT NULL,
  `Custo` double NOT NULL,
  `ValorVenda` double NOT NULL,
  `Qtd` int(11) NOT NULL,
  `DtEntrada` date NOT NULL,
  PRIMARY KEY (`Produtos_Codigo`,`CodigoEstoque`),
  KEY `fk_ProdutoEstoque_Produtos_idx` (`Produtos_Codigo`),
  CONSTRAINT `fk_ProdutoEstoque_Produtos` FOREIGN KEY (`Produtos_Codigo`) REFERENCES `produtos` (`Codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtoestoque`
--

LOCK TABLES `produtoestoque` WRITE;
/*!40000 ALTER TABLE `produtoestoque` DISABLE KEYS */;
/*!40000 ALTER TABLE `produtoestoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtos` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(200) NOT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `NivelAcesso` int(11) NOT NULL,
  `Ativo` tinyint(1) NOT NULL,
  `Telefone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'teste','email',1,1,'(22)2222-2222');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-25 19:27:28
