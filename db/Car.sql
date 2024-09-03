-- MySQL dump 10.13  Distrib 8.3.0, for macos14 (arm64)
--
-- Host: localhost    Database: CarRental
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Car`
--

DROP TABLE IF EXISTS `Car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Car` (
  `Car_ID` int NOT NULL AUTO_INCREMENT,
  `Car_Make` varchar(15) NOT NULL,
  `Car_Model` varchar(15) NOT NULL,
  `Car_Trim` varchar(15) DEFAULT NULL,
  `Car_Odometer` int NOT NULL,
  `Car_Image` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Car_Transmission` char(1) NOT NULL,
  `Car_Fuel` char(1) NOT NULL,
  `Car_Seats` int NOT NULL,
  `Car_Body_Style` varchar(10) NOT NULL,
  `Car_Quip` varchar(50) DEFAULT NULL,
  `Car_Purchase_Price` int NOT NULL,
  `Car_Current_Price` int DEFAULT NULL,
  `Car_Price_KM` int NOT NULL,
  `Car_Location` varchar(30) DEFAULT NULL,
  `Car_Rating` int DEFAULT NULL,
  PRIMARY KEY (`Car_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Car`
--

LOCK TABLES `Car` WRITE;
/*!40000 ALTER TABLE `Car` DISABLE KEYS */;
INSERT INTO `Car` VALUES (13,'MG','3','Excite',20000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/mg-mg3-my19-index.png','M','P',5,'Hatch','Fuel Efficient',25000,1,1,'1',4),(14,'Toyota','Corolla','GXL',15000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/toyota-corolla-my19-index-%281%29.png','A','H',5,'Hatch','Handles Well',30000,1,3,'1',5),(15,'Toyota','Camry','LE',50000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/toyota-camry-my21-index-1.png','A','P',5,'Sedan','Reliable and spacious',20000,18000,1,'1',5),(16,'Honda','Civic','EX',30000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/honda-civic-index.png','M','P',5,'Sedan','Fuel efficient and compact',18000,16000,1,'1',5),(17,'Ford','Escape','Titanium',40000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/ford-escape-my21-index-1.png','A','P',5,'SUV','Adventure-ready',25000,22000,1,'1',4),(18,'Holden','Cruze','LS',60000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/Holden-Cruze.png','A','P',5,'Sedan','Comfortable and smooth',22000,20000,1,'1',4),(19,'BMW','3 Series','330i',35000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/bmw-3-series-index.png','A','P',5,'Sedan','Luxury and performance',35000,32000,1,'1',5),(20,'Audi','Q5','Premium Plus',45000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/audi-q5-my21-index-1.png','A','P',5,'SUV','Elegant and powerful',40000,37000,1,'1',5),(21,'Nissan','Pulsar','ST',25000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/Nissan-Pulsar_0.png','A','P',5,'Sedan','Stylish and efficient',19000,17000,1,'1',5),(22,'Hyundai','Elantra','SE',20000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/Elantra-Active-index-1200x800-%281%29.png','M','P',5,'Sedan','Affordable and reliable',16000,14000,1,'1',4),(23,'Subaru','Outback','Limited',55000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/subaru-outback-my21-index-01.png','A','P',5,'SUV','Versatile and rugged',28000,25000,1,'1',5),(24,'Mercedes-Benz','C-Class','C300',30000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/merc%20c300%20small_0.png','A','P',5,'Sedan','Luxury and class',42000,40000,1,'1',5);
/*!40000 ALTER TABLE `Car` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-03 21:12:32
