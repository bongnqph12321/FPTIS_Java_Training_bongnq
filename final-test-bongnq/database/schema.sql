-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: fis_training
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
                          `id` bigint NOT NULL,
                          `firstName` varchar(255) DEFAULT NULL,
                          `hiringDate` datetime(6) NOT NULL,
                          `lastName` varchar(255) DEFAULT NULL,
                          `password` varchar(255) DEFAULT NULL,
                          `username` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
                         `roleId` bigint NOT NULL,
                         `roleName` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_customer`
--

DROP TABLE IF EXISTS `tbl_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_customer` (
                                `id` bigint NOT NULL AUTO_INCREMENT,
                                `address` varchar(200) DEFAULT NULL,
                                `mobile` varchar(10) DEFAULT NULL,
                                `name` varchar(100) DEFAULT NULL,
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_customer`
--

LOCK TABLES `tbl_customer` WRITE;
/*!40000 ALTER TABLE `tbl_customer` DISABLE KEYS */;
INSERT INTO `tbl_customer` VALUES (1,'Ha Noi','0868851795','Quyen'),(3,'Quoc Oai','0329043953','bong'),(4,'Quoc Oai','0329043953','bong');
/*!40000 ALTER TABLE `tbl_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_customer_orders`
--

DROP TABLE IF EXISTS `tbl_customer_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_customer_orders` (
                                       `customer_id` bigint NOT NULL,
                                       `orders_id` bigint NOT NULL,
                                       UNIQUE KEY `UK_jmav4gu0t7ccrv4ifrjt9147e` (`orders_id`),
                                       KEY `FKsp7vkx5j7gtm3bmysk1ui9gyu` (`customer_id`),
                                       CONSTRAINT `FKmx8jijygo81okhkymbnm4hkgr` FOREIGN KEY (`orders_id`) REFERENCES `tbl_order` (`id`),
                                       CONSTRAINT `FKsp7vkx5j7gtm3bmysk1ui9gyu` FOREIGN KEY (`customer_id`) REFERENCES `tbl_customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_customer_orders`
--

LOCK TABLES `tbl_customer_orders` WRITE;
/*!40000 ALTER TABLE `tbl_customer_orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_customer_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_order`
--

DROP TABLE IF EXISTS `tbl_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_order` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `order_datetime` datetime(6) DEFAULT NULL,
                             `status` varchar(255) DEFAULT NULL,
                             `total_amount` double DEFAULT NULL,
                             `customer_id` bigint DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             KEY `FKdbbvj4affcu7x13tjn0a12htw` (`customer_id`),
                             CONSTRAINT `FKdbbvj4affcu7x13tjn0a12htw` FOREIGN KEY (`customer_id`) REFERENCES `tbl_customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_order`
--

LOCK TABLES `tbl_order` WRITE;
/*!40000 ALTER TABLE `tbl_order` DISABLE KEYS */;
INSERT INTO `tbl_order` VALUES (1,'2022-06-28 11:44:19.000000','CREATED',8.7,1),(2,'2022-06-28 11:44:19.000000','CREATED',8.7,1),(3,'2022-06-28 11:44:19.000000','CREATED',8.7,1),(4,'2022-06-28 11:44:19.000000','CANCELLED',8.7,1);
/*!40000 ALTER TABLE `tbl_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_order_item`
--

DROP TABLE IF EXISTS `tbl_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_order_item` (
                                  `id` bigint NOT NULL AUTO_INCREMENT,
                                  `amount` double DEFAULT NULL,
                                  `quantity` int DEFAULT NULL,
                                  `order_id` bigint NOT NULL,
                                  `product_id` bigint DEFAULT NULL,
                                  PRIMARY KEY (`id`),
                                  KEY `FKmkqpajkg6p2wq4owcv1v08pc5` (`order_id`),
                                  KEY `FK1oy9x003q55eqmuiv0y8a15e` (`product_id`),
                                  CONSTRAINT `FK1oy9x003q55eqmuiv0y8a15e` FOREIGN KEY (`product_id`) REFERENCES `tbl_product` (`id`),
                                  CONSTRAINT `FKmkqpajkg6p2wq4owcv1v08pc5` FOREIGN KEY (`order_id`) REFERENCES `tbl_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_order_item`
--

LOCK TABLES `tbl_order_item` WRITE;
/*!40000 ALTER TABLE `tbl_order_item` DISABLE KEYS */;
INSERT INTO `tbl_order_item` VALUES (1,200,20,1,1);
/*!40000 ALTER TABLE `tbl_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_product`
--

DROP TABLE IF EXISTS `tbl_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_product` (
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `available` bigint DEFAULT NULL,
                               `name` varchar(255) DEFAULT NULL,
                               `price` double DEFAULT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_product`
--

LOCK TABLES `tbl_product` WRITE;
/*!40000 ALTER TABLE `tbl_product` DISABLE KEYS */;
INSERT INTO `tbl_product` VALUES (1,19,'Giay Dinh',20000);
/*!40000 ALTER TABLE `tbl_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userrole`
--

DROP TABLE IF EXISTS `userrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userrole` (
                            `userRoleId` bigint NOT NULL,
                            `person_id` bigint DEFAULT NULL,
                            `role_roleId` bigint DEFAULT NULL,
                            PRIMARY KEY (`userRoleId`),
                            KEY `FKigb009n7o06ol3kgl2qkb61t3` (`person_id`),
                            KEY `FK769isy0oqc6f24kspvlvtxhpf` (`role_roleId`),
                            CONSTRAINT `FK769isy0oqc6f24kspvlvtxhpf` FOREIGN KEY (`role_roleId`) REFERENCES `roles` (`roleId`),
                            CONSTRAINT `FKigb009n7o06ol3kgl2qkb61t3` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userrole`
--

LOCK TABLES `userrole` WRITE;
/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-28 22:44:25
