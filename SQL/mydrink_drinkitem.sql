CREATE DATABASE  IF NOT EXISTS `mydrink` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mydrink`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: mydrink
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `drinkitem`
--

DROP TABLE IF EXISTS `drinkitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drinkitem` (
  `drinkid` int NOT NULL AUTO_INCREMENT COMMENT '飲料id',
  `mydrinkparentid` int DEFAULT NULL COMMENT '飲料大分類id',
  `drinkname` varchar(45) DEFAULT NULL COMMENT '飲料名稱',
  `drinkprice` int DEFAULT NULL COMMENT '飲料單價',
  `drinkdescription` varchar(45) DEFAULT NULL COMMENT '飲料描述',
  `drinkcategory` varchar(45) DEFAULT NULL COMMENT '飲料種類',
  PRIMARY KEY (`drinkid`) USING BTREE,
  UNIQUE KEY `索引 3` (`drinkname`,`mydrinkparentid`) USING BTREE,
  KEY `FK_drinkitem_mydrinkparent` (`mydrinkparentid`),
  CONSTRAINT `FK_drinkitem_mydrinkparent` FOREIGN KEY (`mydrinkparentid`) REFERENCES `mydrinkparent` (`mydrinkparentid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品基本資料';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drinkitem`
--

LOCK TABLES `drinkitem` WRITE;
/*!40000 ALTER TABLE `drinkitem` DISABLE KEYS */;
INSERT INTO `drinkitem` VALUES (1,1,'素鬆玉米蛋',40,NULL,NULL),(2,1,'吉士蛋',45,NULL,NULL),(3,2,'蔥香蛋餅',30,NULL,NULL),(4,3,'培根',500,NULL,NULL),(5,1,'蔬菜蛋',30,NULL,NULL),(6,4,'鮪魚總匯',65,NULL,NULL),(7,5,'蔥抓蛋餅',45,NULL,NULL),(8,7,'紅茶',15,NULL,NULL),(9,7,'奶茶',20,NULL,NULL),(10,24,'XXX',45,'XXX',''),(11,34,'AAA',34,'ZZZ',''),(12,34,'大麥克',20,'sss','');
/*!40000 ALTER TABLE `drinkitem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-13  9:39:23
