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
  `valorAnterior` text,
  `valorPosterior` text,
  `Usuario_Codigo` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_Auditoria_Usuario1_idx` (`Usuario_Codigo`),
  CONSTRAINT `fk_Auditoria_Usuario1` FOREIGN KEY (`Usuario_Codigo`) REFERENCES `usuario` (`Codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditoria`
--

LOCK TABLES `auditoria` WRITE;
/*!40000 ALTER TABLE `auditoria` DISABLE KEYS */;
INSERT INTO `auditoria` VALUES (8,'2015-10-05 23:36:08','Update usuario','Campo nome: teste','Campo nome: teste',3),(9,'2015-10-05 23:36:42','Update usuario','Campo nome: teste','Campo nome: teste',3),(10,'2015-10-05 23:38:50','Update usuario','Campo nome: teste','Campo nome: teste',3),(11,'2015-10-05 23:50:52','Update cliente','Campo nome: Teste','Campo nome: Teste22',3),(12,'2015-10-05 23:53:28','Update cliente','Campo nome: teste_Murilo Campo telefone: (11)1111-1111 Campo celular: (11)1111-1111Campo email: email11','Campo nome: teste_Murilo Campo telefone: (11)1111-1111 Campo celular: (11)1111-1111Campo email: email11Campo email: email',3),(13,'2015-10-05 23:54:59','Update usuario','Campo nome: teste2 Campo email: email2 Campo telefone: (22)2222-2222','Campo nome: teste Campo email: email Campo telefone: (22)2222-2224',3),(14,'2015-10-06 00:09:13','Update usuario','Campo nome: teste Campo cidade: Lajeado','Campo nome: teste2 Campo cidade Estrela',3),(15,'2015-10-06 00:14:02','Update usuario','Campo descricao: Produto Campo marca: Samsung','Campo descricao: Produto1 Campo marca: Samsung',3),(16,'2015-10-08 00:26:31','Update produtos','Campo descricao: Produto1 Campo marca: Samsung','Campo descricao: Produto1 Campo marca: Samsung',1),(17,'2015-10-08 00:28:34','Update produtos','Campo descricao: Produto1 Campo marca: Samsung','Campo descricao: Produto1 Campo marca: Samsung',1),(18,'2015-10-08 00:37:28','Update produtos','Campo descricao: Produto1 Campo marca: Samsung','Campo descricao: Produto1 Campo marca: Samsung',1),(19,'2015-10-08 00:38:01','Update produtos','Campo descricao: Produto3 Campo marca: Samsung','Campo descricao: Produto4 Campo marca: Samsung',1),(20,'2015-10-12 15:47:43','Update cliente: 2','Campo nome: teste Campo telefone: (11)1111-1111 Campo celular: (11)1111-1111 Campo email: email','Campo nome: teste Campo telefone: (11)1111-1111 Campo celular: (11)1111-1111 Campo email: email Campo email: email',1),(21,'2015-10-12 15:47:49','Update usuario','Campo nome: teste Campo email: email Campo telefone: (22)2222-2222','Campo nome: teste Campo email: email Campo telefone: (22)2222-2222',1),(22,'2015-10-12 15:47:57','Update produtos','Campo descricao: Produto1 Campo marca: Samsung','Campo descricao: Produto1 Campo marca: Samsung',1),(23,'2015-10-12 15:50:19','Update filial','Campo nome: TESTE2 Campo cidade: Estrela','Campo nome: TESTE2 Campo cidade Estrela',3),(24,'2015-10-12 16:07:08','Update produtoEstoque: 1 6','Campo dtEntrada: 12/10/2015','Campo dtEntrada: 12/10/2015',1),(25,'2015-10-12 16:09:33','Update produtoEstoque: 1 7','Campo dtEntrada: 12/10/2015','Campo dtEntrada: 12/10/2015',1),(26,'2015-10-12 16:11:04','Update produtoEstoque: 1 7','Campo dtEntrada: 12/10/2015','Campo dtEntrada: 12/10/2015',1),(27,'2015-10-12 16:14:20','Update produtoEstoque: 2 7','Campo dtEntrada: 12/10/2015','Campo dtEntrada: 12/10/2015',1),(28,'2015-10-12 16:17:22','Update produtoEstoque: 1 8','null Campo valorVenda: 150.0 Campo dtEntrada: 12/10/2015','null Campo valorVenda: 200.0 Campo dtEntrada: 12/10/2015',2),(29,'2015-10-12 16:22:05','Update filial','Campo data: 12/10/2015','Campo data: 11/10/2015',1),(30,'2015-11-02 15:42:10','Update produtoEstoque: 1 2','null Campo dtEntrada: 0016-03-07','null Campo dtEntrada: 07/03/0016',1),(31,'2015-11-04 22:33:31','Update orcamento: 27','Campo data: 04/11/2015','Campo data: 04/11/2015',1),(32,'2015-11-05 00:33:01','Update orcamento: 38','Campo data: 04/11/2015','Campo data: 04/11/2015',1),(33,'2015-11-05 01:13:37','Update orcamento: 45','Campo data: 04/11/2015 Campo cliente: 1','Campo data: 04/11/2015 Campo cliente 10',1),(34,'2015-11-05 01:13:46','Update orcamento: 45','Campo data: 04/11/2015 Campo cliente: 10','Campo data: 04/11/2015 Campo cliente 17',1),(35,'2015-11-07 01:09:54','Update orcamento: 47','Campo data: 06/11/2015','Campo data: 06/11/2015',1),(36,'2015-11-07 01:45:49','Update orcamento: 49','Campo data: 06/11/2015','Campo data: 06/11/2015',1),(37,'2015-11-07 01:47:34','Update orcamento: 49','Campo data: 06/11/2015','Campo data: 06/11/2015',1),(38,'2015-11-07 01:51:45','Update orcamento: 50','Campo data: ','Campo data: ',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Teste21','(11)1111-1111','(11)1111-1111','email22'),(2,'teste','(11)1111-1111','(11)1111-1111','email'),(10,'Teste22','(11)1111-1111','(11)1111-1111','email2'),(11,'Murilo','(11)1111-1112','(11)1111-1111','email'),(12,'teste33','(22)2222-2222','(22)2222-2222','email12'),(14,'Murilo','(11)1111-1111','(11)1111-1111','murilo_schonarth@hotmail.com'),(15,'teste15','(11)1111-1111','(11)1111-1111','eeeeee'),(16,'Teste162222','(11)1111-1111','(11)1111-1111','email'),(17,'teste','(11)1111-1111','(11)1111-1111','email'),(18,'teste','(11)1111-1111','(11)1111-1111','email'),(19,'teste','(22)2222-2222','(22)2222-2222','email'),(20,'teste','(11)1111-1111','(11)1111-1111','email'),(21,'teste','(11)1111-1111','(11)1111-1111','email'),(22,'teste','(11)1111-1111','(11)1111-1111','email'),(23,'teste','(  )    -    ','(11)1111-1111','email'),(24,'teste','(11)1111-1111','(11)1111-1111','email'),(25,'teste','(11)1111-1111','(11)1111-1111','email'),(26,'teste','(11)1111-1111','(11)1111-1111','email'),(27,'teste','(11)1111-1111','(11)1111-1111','email'),(28,'teste','(11)1111-1111','(11)1111-1111','email'),(29,'TESTE','(11)1111-1111','(11)1111-1111','EMAIL'),(30,'cliente','(22)2222-2222','(22)2222-2222','emailcliente'),(31,'cliente','(11)1111-1111','(22)2222-2222','emailcliente'),(32,'cliente','(11)1111-1111','(22)2222-2222','emailcliente'),(33,'cliente','(11)1111-1111','(22)2222-2222','emailcliente'),(34,'cliente','(11)1111-1111','(22)2222-2222','emailcliente'),(35,'cliente','(11)1111-1111','(22)2222-2222','emailcliente'),(36,'cli000','(11)1111-1111','(11)1111-1111','email'),(37,'clientenovo','(33)3333-3333','(33)3333-3333','emailCli'),(38,'eee','(33)3333-3333','(33)3333-3333','emailCli'),(39,'testeFuncao','(11)1111-1111','(11)1111-1111','email'),(40,'novoCli','(22)2222-2222','(22)2222-2222','2eee'),(41,'teste','(11)1111-1111','(11)1111-1111','eeeee');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `consauditoria`
--

DROP TABLE IF EXISTS `consauditoria`;
/*!50001 DROP VIEW IF EXISTS `consauditoria`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `consauditoria` (
  `codigo` tinyint NOT NULL,
  `dataHora` tinyint NOT NULL,
  `acao` tinyint NOT NULL,
  `valorAnterior` tinyint NOT NULL,
  `valorPosterior` tinyint NOT NULL,
  `Usuario_Codigo` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `estoque`
--

DROP TABLE IF EXISTS `estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estoque` (
  `Produto` int(11) NOT NULL,
  `Qtd` int(11) DEFAULT NULL,
  PRIMARY KEY (`Produto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estoque`
--

LOCK TABLES `estoque` WRITE;
/*!40000 ALTER TABLE `estoque` DISABLE KEYS */;
INSERT INTO `estoque` VALUES (1,4),(2,4);
/*!40000 ALTER TABLE `estoque` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filial`
--

LOCK TABLES `filial` WRITE;
/*!40000 ALTER TABLE `filial` DISABLE KEYS */;
INSERT INTO `filial` VALUES (1,'TESTE2','Estrela',1),(2,'teste2','Estrela',1),(3,'Nome','Passo Fundo',1),(4,'Teste','Lajeado',1),(5,'TESTE4','Estrela',3);
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
  `Data` varchar(10) DEFAULT NULL,
  `Cliente_Codigo` int(11) NOT NULL,
  PRIMARY KEY (`Codigo`),
  KEY `fk_Orcamento_Cliente1_idx` (`Cliente_Codigo`),
  CONSTRAINT `fk_Orcamento_Cliente1` FOREIGN KEY (`Cliente_Codigo`) REFERENCES `cliente` (`Codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orcamento`
--

LOCK TABLES `orcamento` WRITE;
/*!40000 ALTER TABLE `orcamento` DISABLE KEYS */;
INSERT INTO `orcamento` VALUES (51,'06/11/2015',1);
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
  `Qtd` int(11) NOT NULL,
  PRIMARY KEY (`ProdutoEstoque_Produtos_Codigo`,`ProdutoEstoque_CodigoEstoque`,`Orcamento_Codigo`),
  KEY `fk_Orcamento_ProdutoEstoque_ProdutoEstoque1_idx` (`ProdutoEstoque_Produtos_Codigo`,`ProdutoEstoque_CodigoEstoque`),
  KEY `fk_Orcamento_ProdutoEstoque_Orcamento1_idx` (`Orcamento_Codigo`),
  CONSTRAINT `fk_Orcamento_ProdutoEstoque_Orcamento1` FOREIGN KEY (`Orcamento_Codigo`) REFERENCES `orcamento` (`Codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orcamento_ProdutoEstoque_ProdutoEstoque1` FOREIGN KEY (`ProdutoEstoque_Produtos_Codigo`, `ProdutoEstoque_CodigoEstoque`) REFERENCES `produtoestoque` (`Produtos_Codigo`, `CodigoEstoque`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orcamento_produtoestoque`
--

LOCK TABLES `orcamento_produtoestoque` WRITE;
/*!40000 ALTER TABLE `orcamento_produtoestoque` DISABLE KEYS */;
INSERT INTO `orcamento_produtoestoque` VALUES (1,1,51,80);
/*!40000 ALTER TABLE `orcamento_produtoestoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `pesqcli`
--

DROP TABLE IF EXISTS `pesqcli`;
/*!50001 DROP VIEW IF EXISTS `pesqcli`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `pesqcli` (
  `Codigo` tinyint NOT NULL,
  `Nome` tinyint NOT NULL,
  `Telefone` tinyint NOT NULL,
  `Ceuluar` tinyint NOT NULL,
  `Email` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `pesqfilial`
--

DROP TABLE IF EXISTS `pesqfilial`;
/*!50001 DROP VIEW IF EXISTS `pesqfilial`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `pesqfilial` (
  `Codigo` tinyint NOT NULL,
  `Nome` tinyint NOT NULL,
  `Cidade` tinyint NOT NULL,
  `Usuario_Codigo` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `pesqorcamento`
--

DROP TABLE IF EXISTS `pesqorcamento`;
/*!50001 DROP VIEW IF EXISTS `pesqorcamento`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `pesqorcamento` (
  `CODIGO` tinyint NOT NULL,
  `DATA` tinyint NOT NULL,
  `CLIENTE_CODIGO` tinyint NOT NULL,
  `NOME` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `pesqorcpe`
--

DROP TABLE IF EXISTS `pesqorcpe`;
/*!50001 DROP VIEW IF EXISTS `pesqorcpe`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `pesqorcpe` (
  `PRODUTOESTOQUE_PRODUTOS_CODIGO` tinyint NOT NULL,
  `PRODUTOESTOQUE_CODIGOESTOQUE` tinyint NOT NULL,
  `DESCRICAO` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `pesqpe`
--

DROP TABLE IF EXISTS `pesqpe`;
/*!50001 DROP VIEW IF EXISTS `pesqpe`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `pesqpe` (
  `PRODUTOS_CODIGO` tinyint NOT NULL,
  `CODIGOESTOQUE` tinyint NOT NULL,
  `DESCRICAO` tinyint NOT NULL,
  `CUSTO` tinyint NOT NULL,
  `VALORVENDA` tinyint NOT NULL,
  `QTD` tinyint NOT NULL,
  `DTENTRADA` tinyint NOT NULL,
  `MARCA` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `pesqprod`
--

DROP TABLE IF EXISTS `pesqprod`;
/*!50001 DROP VIEW IF EXISTS `pesqprod`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `pesqprod` (
  `Codigo` tinyint NOT NULL,
  `Descricao` tinyint NOT NULL,
  `Marca` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `pesqusu`
--

DROP TABLE IF EXISTS `pesqusu`;
/*!50001 DROP VIEW IF EXISTS `pesqusu`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `pesqusu` (
  `Codigo` tinyint NOT NULL,
  `Nome` tinyint NOT NULL,
  `Email` tinyint NOT NULL,
  `NivelAcesso` tinyint NOT NULL,
  `Ativo` tinyint NOT NULL,
  `Telefone` tinyint NOT NULL,
  `Senha` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

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
  `DtEntrada` varchar(10) NOT NULL,
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
INSERT INTO `produtoestoque` VALUES (1,1,140.2,199.9,10,'0014-02-05'),(1,2,160,250,10,'07/03/0016'),(1,3,90,150,10,'2014-10-10'),(1,4,120,200,10,'2015-02-12'),(1,5,150,300,10,'2015-10-12'),(1,6,100,200,10,'12/10/2015'),(1,7,100,200,10,'12/10/2015'),(1,8,100,200,10,'12/10/2015'),(2,1,100,150,10,'0014-02-05'),(2,2,120,300,15,'0013-12-06'),(2,3,100,150,10,'2015-10-12'),(2,4,150,200,10,'2015-10-12'),(2,5,100,200,15,'12/10/2015'),(2,6,100,200,10,'12/10/2015'),(2,7,100,200,10,'12/10/2015'),(3,1,120,260,10,'2015-03-08'),(3,2,100,200,10,'2015-10-12'),(3,3,150,250,10,'2015-10-12'),(3,4,100,150,10,'23/10/2015'),(4,1,100,200,10,'2015-10-12'),(4,2,100,200,10,'12/10/2015');
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
  `Marca` varchar(100) NOT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (1,'Produto1','Samsung'),(2,'Produtoy','LG'),(3,'Produtox','LG'),(4,'Produto4','Samsung'),(5,'testeFunc','Função'),(6,'teste2','Marca'),(7,'teste','teste');
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
  `Senha` varchar(20) NOT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'teste','email',2,1,'(22)2222-2222','senha'),(2,'teste','email',2,1,'(22)2222-2222','senha2'),(3,'teste','email',1,1,'(22)2222-2224','senha'),(4,'teste','email',1,1,'(22)2222-2222','senha');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `consauditoria`
--

/*!50001 DROP TABLE IF EXISTS `consauditoria`*/;
/*!50001 DROP VIEW IF EXISTS `consauditoria`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `consauditoria` AS select `auditoria`.`codigo` AS `codigo`,`auditoria`.`dataHora` AS `dataHora`,`auditoria`.`acao` AS `acao`,`auditoria`.`valorAnterior` AS `valorAnterior`,`auditoria`.`valorPosterior` AS `valorPosterior`,`auditoria`.`Usuario_Codigo` AS `Usuario_Codigo` from `auditoria` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `pesqcli`
--

/*!50001 DROP TABLE IF EXISTS `pesqcli`*/;
/*!50001 DROP VIEW IF EXISTS `pesqcli`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `pesqcli` AS select `cliente`.`Codigo` AS `Codigo`,`cliente`.`Nome` AS `Nome`,`cliente`.`Telefone` AS `Telefone`,`cliente`.`Ceuluar` AS `Ceuluar`,`cliente`.`Email` AS `Email` from `cliente` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `pesqfilial`
--

/*!50001 DROP TABLE IF EXISTS `pesqfilial`*/;
/*!50001 DROP VIEW IF EXISTS `pesqfilial`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `pesqfilial` AS select `filial`.`Codigo` AS `Codigo`,`filial`.`Nome` AS `Nome`,`filial`.`Cidade` AS `Cidade`,`filial`.`Usuario_Codigo` AS `Usuario_Codigo` from `filial` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `pesqorcamento`
--

/*!50001 DROP TABLE IF EXISTS `pesqorcamento`*/;
/*!50001 DROP VIEW IF EXISTS `pesqorcamento`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `pesqorcamento` AS select `orc`.`Codigo` AS `CODIGO`,`orc`.`Data` AS `DATA`,`orc`.`Cliente_Codigo` AS `CLIENTE_CODIGO`,`cli`.`Nome` AS `NOME` from (`orcamento` `orc` left join `cliente` `cli` on((`cli`.`Codigo` = `orc`.`Cliente_Codigo`))) order by `orc`.`Codigo` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `pesqorcpe`
--

/*!50001 DROP TABLE IF EXISTS `pesqorcpe`*/;
/*!50001 DROP VIEW IF EXISTS `pesqorcpe`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `pesqorcpe` AS select `ope`.`ProdutoEstoque_Produtos_Codigo` AS `PRODUTOESTOQUE_PRODUTOS_CODIGO`,`ope`.`ProdutoEstoque_CodigoEstoque` AS `PRODUTOESTOQUE_CODIGOESTOQUE`,`produtos`.`Descricao` AS `DESCRICAO` from (`orcamento_produtoestoque` `ope` left join `produtos` on((`produtos`.`Codigo` = `ope`.`ProdutoEstoque_Produtos_Codigo`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `pesqpe`
--

/*!50001 DROP TABLE IF EXISTS `pesqpe`*/;
/*!50001 DROP VIEW IF EXISTS `pesqpe`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `pesqpe` AS select `pe`.`Produtos_Codigo` AS `PRODUTOS_CODIGO`,`pe`.`CodigoEstoque` AS `CODIGOESTOQUE`,`produtos`.`Descricao` AS `DESCRICAO`,`pe`.`Custo` AS `CUSTO`,`pe`.`ValorVenda` AS `VALORVENDA`,`pe`.`Qtd` AS `QTD`,`pe`.`DtEntrada` AS `DTENTRADA`,`produtos`.`Marca` AS `MARCA` from (`produtoestoque` `pe` left join `produtos` on((`produtos`.`Codigo` = `pe`.`Produtos_Codigo`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `pesqprod`
--

/*!50001 DROP TABLE IF EXISTS `pesqprod`*/;
/*!50001 DROP VIEW IF EXISTS `pesqprod`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `pesqprod` AS select `produtos`.`Codigo` AS `Codigo`,`produtos`.`Descricao` AS `Descricao`,`produtos`.`Marca` AS `Marca` from `produtos` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `pesqusu`
--

/*!50001 DROP TABLE IF EXISTS `pesqusu`*/;
/*!50001 DROP VIEW IF EXISTS `pesqusu`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `pesqusu` AS select `usuario`.`Codigo` AS `Codigo`,`usuario`.`Nome` AS `Nome`,`usuario`.`Email` AS `Email`,`usuario`.`NivelAcesso` AS `NivelAcesso`,`usuario`.`Ativo` AS `Ativo`,`usuario`.`Telefone` AS `Telefone`,`usuario`.`Senha` AS `Senha` from `usuario` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-07 15:40:50
