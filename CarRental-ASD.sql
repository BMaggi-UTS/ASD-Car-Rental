-- MariaDB dump 10.19  Distrib 10.11.6-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: CarRental-ASD
-- ------------------------------------------------------
-- Server version	10.11.6-MariaDB-0+deb12u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
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
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Car`
--

LOCK TABLES `Car` WRITE;
/*!40000 ALTER TABLE `Car` DISABLE KEYS */;
INSERT INTO `Car` VALUES
(13,'MG','3','Excite',20000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/mg-mg3-my19-index.png','M','P',5,'Hatch','Fuel Efficient',25000,1,1,4,1),
(14,'Toyota','Corolla','GXL',15000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/toyota-corolla-my19-index-%281%29.png','A','H',5,'Hatch','Handles Well',30000,1,3,5,1),
(15,'Toyota','Camry','LE',50000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/toyota-camry-my21-index-1.png','A','P',5,'Sedan','Reliable and spacious',20000,18000,1,5,2),
(16,'Honda','Civic','EX',30000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/honda-civic-index.png','M','P',5,'Sedan','Fuel efficient and compact',18000,16000,1,5,5),
(17,'Ford','Escape','Titanium',40000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/ford-escape-my21-index-1.png','A','P',5,'SUV','Adventure-ready',25000,22000,1,4,1),
(18,'Holden','Cruze','LS',60000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/Holden-Cruze.png','A','P',5,'Sedan','Comfortable and smooth',22000,20000,1,4,4),
(19,'BMW','3 Series','330i',35000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/bmw-3-series-index.png','A','P',5,'Sedan','Luxury and performance',35000,32000,1,5,3),
(20,'Audi','Q5','Premium Plus',45000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/audi-q5-my21-index-1.png','A','P',5,'SUV','Elegant and powerful',40000,37000,1,5,1),
(21,'Nissan','Pulsar','ST',25000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/Nissan-Pulsar_0.png','A','P',5,'Sedan','Stylish and efficient',19000,17000,1,5,4),
(22,'Hyundai','Elantra','SE',20000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/Elantra-Active-index-1200x800-%281%29.png','M','P',5,'Sedan','Affordable and reliable',16000,14000,1,4,1),
(23,'Subaru','Outback','Limited',55000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/subaru-outback-my21-index-01.png','A','P',5,'SUV','Versatile and rugged',28000,25000,1,5,2),
(24,'Mercedes-Benz','C-Class','C300',30000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/merc%20c300%20small_0.png','A','P',5,'Sedan','Luxury and class',42000,40000,1,5,7);
/*!40000 ALTER TABLE `Car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Location`
--

DROP TABLE IF EXISTS `Location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `Location` VALUES
(1,10,'Airport Dr','New South Wales',2020,'Sydney Airport'),
(2,5,'Arrival Dr','Victoria',3045,'Melbourne Airport'),
(3,22,'Airport Dr','Queensland',4008,'Brisbane Airport'),
(4,45,'St Georges Terrace','Western Australia',6000,'Perth City'),
(5,1,'James Schofield Dr','South Australia',5950,'Adelaide Airport'),
(6,150,'Surfers Paradise Blvd','Queensland',4217,'Gold Coast'),
(7,8,'Airport Ave','Queensland',4870,'Cairns Airport'),
(8,50,'Henry Wrigley Dr','Northern Territory',820,'Darwin Airport'),
(9,120,'Elizabeth St','Tasmania',7000,'Hobart City'),
(10,3,'Terminal Ave','Australian Capital Territory',2609,'Canberra Airport'),
(11,35,'Hunter St','New South Wales',2300,'Newcastle City'),
(12,78,'Crown St','New South Wales',2500,'Wollongong'),
(13,90,'Ryrie St','Victoria',3220,'Geelong'),
(14,24,'Sturt St','Victoria',3350,'Ballarat'),
(15,12,'Flinders St','Queensland',4810,'Townsville'),
(16,3,'Stuart Hwy','Northern Territory',870,'Alice Springs'),
(17,10,'Evandale Rd','Tasmania',7212,'Launceston Airport'),
(18,65,'East St','Queensland',4700,'Rockhampton'),
(19,12,'Friendship Ave','Queensland',4564,'Sunshine Coast Airport'),
(20,101,'Boundary Rd E','Queensland',4740,'Mackay Airport');
/*!40000 ALTER TABLE `Location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Roles`
--

DROP TABLE IF EXISTS `Roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `Roles` VALUES
(1,'Customer',''),
(2,'Staff',''),
(3,'Admin','');
/*!40000 ALTER TABLE `Roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Suppliers`
--

DROP TABLE IF EXISTS `Suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Suppliers` (
  `Supplier_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Business_Name` varchar(50) DEFAULT NULL,
  `ABN` varchar(11) DEFAULT NULL,
  `ACN` varchar(9) DEFAULT NULL,
  `Contact_Name` varchar(50) DEFAULT NULL,
  `Contact_Phone` varchar(20) DEFAULT NULL,
  `Image_Path` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Supplier_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Suppliers`
--

LOCK TABLES `Suppliers` WRITE;
/*!40000 ALTER TABLE `Suppliers` DISABLE KEYS */;
INSERT INTO `Suppliers` VALUES
(1,NULL,NULL,NULL,NULL,NULL,'1.png'),
(2,'Car Supplies Pty Ltd','23456789012','234567890','Jane Smith','0423456789','2.png'),
(3,'Drive Safe Supplies','34567890123','345678901','Alice Johnson','0434567890','3.png'),
(4,'Quality Auto Components','45678901234','456789012','Bob Brown','0445678901','4.png'),
(5,'Vehicle Essentials','56789012345','567890123','Chris White','0456789012','5.png'),
(6,'Rapid Car Supplies','67890123456','678901234','Emily Davis','0467890123','6.png'),
(7,'Motorway Supplies','78901234567','789012345','Michael Wilson','0478901234','7.png'),
(8,'Parts & More','89012345678','890123456','Sarah Miller','0489012345','8.png'),
(9,'Super Auto Supply','90123456789','901234567','David Anderson','0490123456','9.png'),
(10,'Ultimate Vehicle Parts','01234567890','012345678','Laura Thompson','0401234567','10.png');
/*!40000 ALTER TABLE `Suppliers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_Roles`
--

DROP TABLE IF EXISTS `User_Roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
INSERT INTO `User_Roles` VALUES
(1,3),
(2,2),
(3,1),
(5,1),
(396,1);
/*!40000 ALTER TABLE `User_Roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=553 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES
(1,'Michael','Lunn','Michael','m.lunn54@gmail.com','0400000000','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8','2001-09-15'),
(2,'Hulk','Hogan','Hulk','h.hogan@gmail.com','0400000001','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8','1996-08-05'),
(3,'Jeff','Bezos','Jeff','j.bezos@gmail.com','0400000002','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8','1986-11-07'),
(4,'Michael','Lunn',NULL,'m.lunn55@gmail.com','0413525166','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','2024-08-27'),
(5,'Michael','Lunn',NULL,'m.lunn4@gmail.com','0413525166','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','2024-08-28'),
(396,'Test','Test',NULL,'test@test.com','0412345678','b1c788abac15390de987ad17b65ac73c9b475d428a51f245c645a442fddd078b','2000-10-25');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

-- Table structure for table `Reports`
DROP TABLE IF EXISTS `Reports`;
CREATE TABLE `Reports` (
  `Report_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Report_Type` varchar(20) NOT NULL,         -- Type of report (sales, rental, feedback)
  `Start_Date` date NOT NULL,                 -- Start date for the report
  `End_Date` date NOT NULL,                   -- End date for the report
  `Total_Revenue` decimal(10,2) NOT NULL,     -- Total revenue in this period
  `Total_Rentals` int(11) NOT NULL,           -- Total number of rentals
  `Total_Customers` int(11) NOT NULL,         -- Total number of customers
  PRIMARY KEY (`Report_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Data for Reports
INSERT INTO `Reports` (`Report_Type`, `Start_Date`, `End_Date`, `Total_Revenue`, `Total_Rentals`, `Total_Customers`) VALUES
('Sales', '2024-09-01', '2024-09-30', 15000.00, 120, 110),
('Rental', '2024-09-01', '2024-09-30', 8000.00, 80, 75),
('Feedback', '2024-09-01', '2024-09-30', 0.00, 0, 95);


-- Table structure for table `Shipments`
DROP TABLE IF EXISTS `Shipments`;
CREATE TABLE `Shipments` (
  `Shipment_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Order_ID` int(11) NOT NULL,               -- Associated Order ID
  `Shipment_Status` varchar(50) NOT NULL,    -- Status (e.g., "In Progress", "Delivered", etc.)
  `Shipment_Tracking` varchar(255) DEFAULT NULL,  -- Tracking details
  `Shipment_Date` date NOT NULL,             -- Shipment date
  `Estimated_Arrival` date DEFAULT NULL,     -- Estimated arrival date
  PRIMARY KEY (`Shipment_ID`),
  FOREIGN KEY (`Order_ID`) REFERENCES `Order`(`Order_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Data for Shipments
INSERT INTO `Shipments` (`Order_ID`, `Shipment_Status`, `Shipment_Tracking`, `Shipment_Date`, `Estimated_Arrival`) VALUES
(1, 'In Progress', 'TRACK12345', '2024-10-01', '2024-10-03'),
(2, 'Delivered', 'TRACK12346', '2024-09-25', '2024-09-27'),
(3, 'Awaiting Dispatch', NULL, '2024-10-02', '2024-10-05');


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-07 10:11:22
