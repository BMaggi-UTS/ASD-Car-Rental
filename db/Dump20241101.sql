-- MySQL dump 10.13  Distrib 8.0.36, for macos14 (arm64)
--
-- Host: 13.55.60.202    Database: CarRental-ASD
-- ------------------------------------------------------
-- Server version	5.5.5-10.11.6-MariaDB-0+deb12u1

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
-- Table structure for table `Availability`
--

DROP TABLE IF EXISTS `Availability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Availability` (
  `Availability_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Order_ID` int(11) NOT NULL,
  `Availability_Start_Date` date NOT NULL,
  `Availability_Finish_Date` date NOT NULL,
  `Car_ID` int(11) NOT NULL,
  PRIMARY KEY (`Availability_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=100733 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Availability`
--

LOCK TABLES `Availability` WRITE;
/*!40000 ALTER TABLE `Availability` DISABLE KEYS */;
INSERT INTO `Availability` VALUES (1,2,'2024-12-02','2025-10-26',2),(2,3,'2025-10-01','2024-10-05',22),(3,3,'2024-10-11','2024-10-15',23),(4,1,'2024-10-01','2024-10-05',4),(5,1,'2024-10-06','2024-10-10',45),(6,6,'2024-10-11','2024-10-15',1),(7,7,'2024-10-01','2024-10-05',2),(8,8,'2024-10-06','2024-10-10',8),(9,9,'2024-10-11','2024-10-15',9),(10,10,'2024-10-01','2024-10-15',10),(99999,100977,'2024-10-10','2024-10-15',14),(100310,101798,'2024-10-10','2024-10-15',13),(100686,104130,'2024-10-10','2024-10-15',13),(100704,104328,'2024-10-29','2024-11-03',20),(100707,104342,'2024-10-29','2024-11-03',14),(100709,104356,'2024-10-29','2024-11-02',13),(100710,104357,'2024-10-29','2024-11-23',14),(100711,104358,'2024-10-29','2024-12-07',14);
/*!40000 ALTER TABLE `Availability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Car`
--

DROP TABLE IF EXISTS `Car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Car` (
  `Car_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Car_Make` varchar(15) NOT NULL,
  `Car_Model` varchar(15) NOT NULL,
  `Car_Trim` varchar(15) DEFAULT NULL,
  `Car_Odometer` int(11) NOT NULL,
  `Car_Image` varchar(300) DEFAULT NULL,
  `Car_Transmission` char(1) NOT NULL,
  `Car_Fuel` char(1) NOT NULL,
  `Car_Seats` int(11) NOT NULL,
  `Car_Body_Style` varchar(10) NOT NULL,
  `Car_Quip` varchar(50) DEFAULT NULL,
  `Car_Purchase_Price` int(11) NOT NULL,
  `Car_Current_Price` int(11) DEFAULT NULL,
  `Car_Price_KM` int(11) NOT NULL,
  `Car_Rating` int(11) DEFAULT NULL,
  `Location_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`Car_ID`),
  KEY `Car_Location_FK` (`Location_ID`),
  CONSTRAINT `Car_Location_FK` FOREIGN KEY (`Location_ID`) REFERENCES `Location` (`Location_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=100094 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Car`
--

LOCK TABLES `Car` WRITE;
/*!40000 ALTER TABLE `Car` DISABLE KEYS */;
INSERT INTO `Car` VALUES (13,'MGa','a',NULL,20000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/mg-mg3-my19-index.png','A','P',5,'Hatch','Fuel Efficient',25000,1,1,4,1),(14,'Toyota','Corolla',NULL,15000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/toyota-corolla-my19-index-%281%29.png','A','H',5,'Hatch','Handles Well',30000,1,3,5,1),(15,'Toyota','Camry',NULL,50000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/toyota-camry-my21-index-1.png','A','P',5,'Sedan','Reliable and spacious',20000,18000,1,5,2),(16,'Hondaa','Civic',NULL,30000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/honda-civic-index.png','A','P',5,'Sedan','Fuel efficient and compact',18000,16000,1,5,5),(17,'Ford','Escape',NULL,40000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/ford-escape-my21-index-1.png','A','P',5,'SUV','Adventure-ready',25000,22000,1,4,1),(18,'Holden','Cruze',NULL,60000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/Holden-Cruze.png','A','P',5,'Sedan','Comfortable and smooth',22000,20000,1,4,4),(19,'BMW','3 Series',NULL,35000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/bmw-3-series-index.png','A','P',5,'Sedan','Luxury and performance',35000,32000,1,5,3),(20,'Audi','Q5',NULL,45000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/audi-q5-my21-index-1.png','A','P',5,'SUV','Elegant and powerful',40000,37000,1,5,1),(21,'Nissan','Pulsar',NULL,25000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/Nissan-Pulsar_0.png','A','P',5,'Sedan','Stylish and efficient',19000,17000,1,5,4),(22,'Hyundai','Elantra',NULL,20000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/Elantra-Active-index-1200x800-%281%29.png','M','P',5,'Sedan','Affordable and reliable',16000,14000,1,4,1),(23,'Subaru','Outback',NULL,55000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/subaru-outback-my21-index-01.png','A','P',5,'SUV','Versatile and rugged',28000,25000,1,5,2),(24,'Mercedes-Benz','C-Class',NULL,30000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/merc%20c300%20small_0.png','A','P',5,'Sedan','Luxury and class',42000,40000,1,5,7),(25,'bmwe','a',NULL,1,'1','a','m',1,'n','u',1,1,1,1,1);
/*!40000 ALTER TABLE `Car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Location`
--

DROP TABLE IF EXISTS `Location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Location` (
  `Location_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Location_Street_Number` int(4) NOT NULL,
  `Location_Street_Name` varchar(100) NOT NULL,
  `Location_State` varchar(100) NOT NULL,
  `Location_Postcode` int(4) NOT NULL,
  `Location_Name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Location_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Location`
--

LOCK TABLES `Location` WRITE;
/*!40000 ALTER TABLE `Location` DISABLE KEYS */;
INSERT INTO `Location` VALUES (1,10,'Airport Dr','New South Wales',2020,'Sydney Airport'),(2,5,'Arrival Dr','Victoria',3045,'Melbourne Airport'),(3,22,'Airport Dr','Queensland',4008,'Brisbane Airport'),(4,45,'St Georges Terrace','Western Australia',6000,'Perth City'),(5,1,'James Schofield Dr','South Australia',5950,'Adelaide Airport'),(6,150,'Surfers Paradise Blvd','Queensland',4217,'Gold Coast'),(7,8,'Airport Ave','Queensland',4870,'Cairns Airport'),(8,50,'Henry Wrigley Dr','Northern Territory',820,'Darwin Airport'),(9,120,'Elizabeth St','Tasmania',7000,'Hobart City'),(10,3,'Terminal Ave','Australian Capital Territory',2609,'Canberra Airport'),(11,35,'Hunter St','New South Wales',2300,'Newcastle City'),(12,78,'Crown St','New South Wales',2500,'Wollongong'),(13,90,'Ryrie St','Victoria',3220,'Geelong'),(14,24,'Sturt St','Victoria',3350,'Ballarat'),(15,12,'Flinders St','Queensland',4810,'Townsville'),(16,3,'Stuart Hwy','Northern Territory',870,'Alice Springs'),(17,10,'Evandale Rd','Tasmania',7212,'Launceston Airport'),(18,65,'East St','Queensland',4700,'Rockhampton'),(19,12,'Friendship Ave','Queensland',4564,'Sunshine Coast Airport'),(20,101,'Boundary Rd E','Queensland',4740,'Mackay Airport');
/*!40000 ALTER TABLE `Location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Orders`
--

DROP TABLE IF EXISTS `Orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Orders` (
  `Order_ID` int(11) NOT NULL AUTO_INCREMENT,
  `User_ID` int(11) NOT NULL,
  `Car_ID` int(11) NOT NULL,
  `Order_Date_Time` datetime NOT NULL,
  `Rental_Date_Start` date NOT NULL,
  `Rental_Date_Finish` date NOT NULL,
  `Odometer_Start` int(11) NOT NULL,
  `Odometer_Finish` int(11) DEFAULT NULL,
  `License_Number` varchar(20) NOT NULL,
  `Tax_Price` varchar(100) DEFAULT NULL,
  `Base_Price` varchar(100) DEFAULT NULL,
  `Total_Price` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Order_ID`),
  KEY `User_ID` (`User_ID`),
  KEY `Car_ID` (`Car_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=104632 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Orders`
--

LOCK TABLES `Orders` WRITE;
/*!40000 ALTER TABLE `Orders` DISABLE KEYS */;
INSERT INTO `Orders` VALUES (104619,3,13,'2024-10-09 10:00:00','2024-10-10','2024-10-15',1000,1200,'123456','50.00','200.00','250.00');
/*!40000 ALTER TABLE `Orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Payments`
--

DROP TABLE IF EXISTS `Payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Payments` (
  `Payment_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Order_ID` int(11) NOT NULL,
  `User_ID` int(11) NOT NULL,
  `Name_on_Card` varchar(100) NOT NULL,
  `Card_Number` varchar(16) NOT NULL,
  `Expiry_Date` varchar(7) NOT NULL,
  `CVV` varchar(4) NOT NULL,
  PRIMARY KEY (`Payment_ID`),
  KEY `Order_ID` (`Order_ID`),
  KEY `User_ID` (`User_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1635 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Payments`
--

LOCK TABLES `Payments` WRITE;
/*!40000 ALTER TABLE `Payments` DISABLE KEYS */;
INSERT INTO `Payments` VALUES (1634,13,3,'John Doe','4111111111111111','2025-10','123');
/*!40000 ALTER TABLE `Payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Roles`
--

DROP TABLE IF EXISTS `Roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Roles` (
  `Role_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Role_Name` varchar(255) DEFAULT NULL,
  `Role_Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Role_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Roles`
--

LOCK TABLES `Roles` WRITE;
/*!40000 ALTER TABLE `Roles` DISABLE KEYS */;
INSERT INTO `Roles` VALUES (1,'Customer',''),(2,'Staff',''),(3,'Admin','');
/*!40000 ALTER TABLE `Roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Suppliers`
--

DROP TABLE IF EXISTS `Suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Suppliers` (
  `Supplier_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Business_Name` varchar(50) DEFAULT NULL,
  `ABN` varchar(11) DEFAULT NULL,
  `ACN` varchar(9) DEFAULT NULL,
  `Contact_Name` varchar(50) DEFAULT NULL,
  `Contact_Phone` varchar(20) DEFAULT NULL,
  `Image_Path` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Supplier_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6304 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Suppliers`
--

LOCK TABLES `Suppliers` WRITE;
/*!40000 ALTER TABLE `Suppliers` DISABLE KEYS */;
INSERT INTO `Suppliers` VALUES (1,'Auto Parts Co','12345678912','123456789','John Doe','0412121212','1.png'),(2,'Car Supplies','23456789012','','Blake Smith','0498765432','2.png'),(3,'Drive Safe Supplies','34567890123','345678901','Alice Johnson','0434567890','3.png'),(4,'Quality Auto Components','45678901234','456789012','Rob Waters','0445678901','4.png'),(5,'Vehicle Essentials Pty Ltd','56789012345','567890123','Chris White','0456789012','5.png'),(6,'Rapid Car Supplies Pty Ltd','67890123456','678901234','Emily Davis','0467890123','6.png'),(7,'Motorway Supplies','78901234567','789012345','Michael Wilson','0478901234','7.png'),(8,'Parts & More','89012345678','890123456','Sarah Miller','0489012345','8.png'),(9,'Super Auto Supply','90123456789','901234567','David Anderson','0490123456','9.png'),(10,'Ultimate Vehicle Parts','01234567890','012345678','Laura Thompson','0401234567','10.png');
/*!40000 ALTER TABLE `Suppliers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_Roles`
--

DROP TABLE IF EXISTS `User_Roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User_Roles` (
  `User_ID` int(11) NOT NULL,
  `Role_ID` int(11) NOT NULL,
  PRIMARY KEY (`User_ID`,`Role_ID`),
  KEY `Role_ID` (`Role_ID`),
  CONSTRAINT `user_roles_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `Users` (`User_ID`),
  CONSTRAINT `user_roles_ibfk_2` FOREIGN KEY (`Role_ID`) REFERENCES `Roles` (`Role_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_Roles`
--

LOCK TABLES `User_Roles` WRITE;
/*!40000 ALTER TABLE `User_Roles` DISABLE KEYS */;
INSERT INTO `User_Roles` VALUES (1,3),(2,2),(3,1),(5,1),(396,1),(553,1),(993,1),(3878,1);
/*!40000 ALTER TABLE `User_Roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Users` (
  `User_ID` int(11) NOT NULL AUTO_INCREMENT,
  `User_FName` varchar(25) DEFAULT NULL,
  `User_LName` varchar(25) DEFAULT NULL,
  `User_PrefName` varchar(25) DEFAULT NULL,
  `User_Email` varchar(255) DEFAULT NULL,
  `User_Phone` varchar(10) DEFAULT NULL,
  `User_Password` varchar(64) DEFAULT NULL,
  `User_DOB` date DEFAULT NULL,
  PRIMARY KEY (`User_ID`),
  UNIQUE KEY `User_email` (`User_Email`),
  UNIQUE KEY `User_Email_2` (`User_Email`)
) ENGINE=InnoDB AUTO_INCREMENT=15185 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES (1,'Michael','Lunn','Micky','m.lunn54@gmail.com','0411222222','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8','2001-08-20'),(2,'Hulk','Hogan','Hulk','h.hogan@gmail.com','0400000001','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8','1996-08-05'),(3,'Jeff','Bezos','Jeff','j.bezos@gmail.com','0400000002','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8','1986-11-07'),(4,'Michael','Lunn',NULL,'m.lunn55@gmail.com','0413525166','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','2024-08-27'),(5,'Michael','Lunn',NULL,'m.lunn4@gmail.com','0413525166','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','2024-08-28'),(396,'Test','Test',NULL,'test@test.com','0412345678','b1c788abac15390de987ad17b65ac73c9b475d428a51f245c645a442fddd078b','2000-10-25'),(553,'Bob','Patterson',NULL,'bob@gmail.com','0412822222','81b637d8fcd2c6da6359e6963113a1170de795e4b725b84d1e0b4cfd9ec58ce9','2024-09-30'),(993,'Bob','Hawke','Bob','bobhawke@gmail.com','0412345678','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8','2000-02-23'),(3878,'Bradley','Madgwick',NULL,'bradmaggi9@gmail.com','0477555920','61be55a8e2f6b4e172338bddf184d6dbee29c98853e0a0485ecee7f27b9af0b4','2024-10-22');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-01 14:27:18
