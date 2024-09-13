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
-- Table structure for table `mydrinkparent`
--

DROP TABLE IF EXISTS `mydrinkparent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mydrinkparent` (
  `mydrinkparentid` int NOT NULL AUTO_INCREMENT COMMENT '父分類名稱 id',
  `myDrinkParenNtame` varchar(45) DEFAULT NULL COMMENT '父分類名稱',
  `myDrinkParentDescription` varchar(45) DEFAULT NULL COMMENT '父分類描述',
  `myDrinkParentCategory` varchar(45) DEFAULT NULL COMMENT '父分類種類\n',
  PRIMARY KEY (`mydrinkparentid`) USING BTREE,
  UNIQUE KEY `id_UNIQUE` (`myDrinkParenNtame`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品大分類資料';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mydrinkparent`
--

LOCK TABLES `mydrinkparent` WRITE;
/*!40000 ALTER TABLE `mydrinkparent` DISABLE KEYS */;
INSERT INTO `mydrinkparent` VALUES (1,'漢堡類','各式漢堡','各式漢堡'),(2,'手工蛋餅','各式手工蛋餅','各式手工蛋餅'),(3,'中式餐點','各式中式餐點','各式中式餐點'),(4,'總匯','各式總匯餐點','各式總匯餐點'),(5,'抓餅','抓餅','抓餅'),(6,'鐵板麵加蛋','鐵板麵加蛋','鐵板麵加蛋'),(7,'飲料類','飲料類','飲料類'),(8,'炸物類','炸物類','炸物類'),(9,'牛角堡','牛堡','牛角堡'),(24,'牛排類',NULL,''),(34,'kkkkkkk','AA','');
/*!40000 ALTER TABLE `mydrinkparent` ENABLE KEYS */;
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
