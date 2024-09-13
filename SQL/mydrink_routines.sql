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
-- Temporary view structure for view `view_mydrinkdata`
--

DROP TABLE IF EXISTS `view_mydrinkdata`;
/*!50001 DROP VIEW IF EXISTS `view_mydrinkdata`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_mydrinkdata` AS SELECT 
 1 AS `mydrinkparentid`,
 1 AS `myDrinkParenNtame`,
 1 AS `myDrinkParentDescription`,
 1 AS `myDrinkParentCategory`,
 1 AS `drinkid`,
 1 AS `drinkname`,
 1 AS `drinkprice`,
 1 AS `drinkdescription`,
 1 AS `drinkcategory`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_orderinfo`
--

DROP TABLE IF EXISTS `view_orderinfo`;
/*!50001 DROP VIEW IF EXISTS `view_orderinfo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_orderinfo` AS SELECT 
 1 AS `orderid`,
 1 AS `orderdatetime`,
 1 AS `memberid`,
 1 AS `membername`,
 1 AS `levelname`,
 1 AS `levelid`,
 1 AS `drinkid`,
 1 AS `drinkname`,
 1 AS `drinkprice`,
 1 AS `orderqty`,
 1 AS `ordersum`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `view_mydrinkdata`
--

/*!50001 DROP VIEW IF EXISTS `view_mydrinkdata`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_mydrinkdata` AS select `b`.`mydrinkparentid` AS `mydrinkparentid`,`b`.`myDrinkParenNtame` AS `myDrinkParenNtame`,`b`.`myDrinkParentDescription` AS `myDrinkParentDescription`,`b`.`myDrinkParentCategory` AS `myDrinkParentCategory`,`a`.`drinkid` AS `drinkid`,`a`.`drinkname` AS `drinkname`,`a`.`drinkprice` AS `drinkprice`,`a`.`drinkdescription` AS `drinkdescription`,`a`.`drinkcategory` AS `drinkcategory` from (`drinkitem` `a` left join `mydrinkparent` `b` on((`a`.`mydrinkparentid` = `b`.`mydrinkparentid`))) order by `a`.`mydrinkparentid` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_orderinfo`
--

/*!50001 DROP VIEW IF EXISTS `view_orderinfo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_orderinfo` AS select `a`.`orderid` AS `orderid`,`a`.`orderdatetime` AS `orderdatetime`,`a`.`memberid` AS `memberid`,`b`.`membername` AS `membername`,`b`.`level` AS `levelname`,`b`.`levelid` AS `levelid`,`e`.`drinkid` AS `drinkid`,`e`.`drinkname` AS `drinkname`,`e`.`drinkprice` AS `drinkprice`,`a`.`orderqty` AS `orderqty`,`a`.`ordersum` AS `ordersum` from ((`myorder` `a` left join `member` `b` on((`a`.`memberid` = `b`.`memberid`))) left join `drinkitem` `e` on((`a`.`drinkid` = `e`.`drinkid`))) */;
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

-- Dump completed on 2024-09-13  9:39:23
