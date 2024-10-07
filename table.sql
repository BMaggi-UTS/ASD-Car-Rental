-- CarRental-ASD

-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS `CarRental-ASD`;
USE `CarRental-ASD`;

-- `CarRental-ASD`.Car definition

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

INSERT INTO `CarRental-ASD`.Car (Car_Make,Car_Model,Car_Trim,Car_Odometer,Car_Image,Car_Transmission,Car_Fuel,Car_Seats,Car_Body_Style,Car_Quip,Car_Purchase_Price,Car_Current_Price,Car_Price_KM,Car_Rating,Location_ID) VALUES
	 ('MG','3','Excite',20000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/mg-mg3-my19-index.png','M','P',5,'Hatch','Fuel Efficient',25000,1,1,4,1),
	 ('Toyota','Corolla','GXL',15000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/toyota-corolla-my19-index-%281%29.png','A','H',5,'Hatch','Handles Well',30000,1,3,5,1),
	 ('Toyota','Camry','LE',50000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/toyota-camry-my21-index-1.png','A','P',5,'Sedan','Reliable and spacious',20000,18000,1,5,2),
	 ('Honda','Civic','EX',30000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/honda-civic-index.png','M','P',5,'Sedan','Fuel efficient and compact',18000,16000,1,5,5),
	 ('Ford','Escape','Titanium',40000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/ford-escape-my21-index-1.png','A','P',5,'SUV','Adventure-ready',25000,22000,1,4,1),
	 ('Holden','Cruze','LS',60000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/Holden-Cruze.png','A','P',5,'Sedan','Comfortable and smooth',22000,20000,1,4,4),
	 ('BMW','3 Series','330i',35000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/bmw-3-series-index.png','A','P',5,'Sedan','Luxury and performance',35000,32000,1,5,3),
	 ('Audi','Q5','Premium Plus',45000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/audi-q5-my21-index-1.png','A','P',5,'SUV','Elegant and powerful',40000,37000,1,5,1),
	 ('Nissan','Pulsar','ST',25000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/Nissan-Pulsar_0.png','A','P',5,'Sedan','Stylish and efficient',19000,17000,1,5,4),
	 ('Hyundai','Elantra','SE',20000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/Elantra-Active-index-1200x800-%281%29.png','M','P',5,'Sedan','Affordable and reliable',16000,14000,1,4,1);
INSERT INTO `CarRental-ASD`.Car (Car_Make,Car_Model,Car_Trim,Car_Odometer,Car_Image,Car_Transmission,Car_Fuel,Car_Seats,Car_Body_Style,Car_Quip,Car_Purchase_Price,Car_Current_Price,Car_Price_KM,Car_Rating,Location_ID) VALUES
	 ('Subaru','Outback','Limited',55000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/subaru-outback-my21-index-01.png','A','P',5,'SUV','Versatile and rugged',28000,25000,1,5,2),
	 ('Mercedes-Benz','C-Class','C300',30000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/merc%20c300%20small_0.png','A','P',5,'Sedan','Luxury and class',42000,40000,1,5,7);

-- `CarRental-ASD`.Location definition

CREATE TABLE `Location` (
  `Location_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Location_Street_Number` int(4) NOT NULL,
  `Location_Street_Name` varchar(100) NOT NULL,
  `Location_State` varchar(100) NOT NULL,
  `Location_Postcode` int(4) NOT NULL,
  `Location_Name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Location_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `CarRental-ASD`.Location (Location_Street_Number,Location_Street_Name,Location_State,Location_Postcode,Location_Name) VALUES
	 (10,'Airport Dr','New South Wales',2020,'Sydney Airport'),
	 (5,'Arrival Dr','Victoria',3045,'Melbourne Airport'),
	 (22,'Airport Dr','Queensland',4008,'Brisbane Airport'),
	 (45,'St Georges Terrace','Western Australia',6000,'Perth City'),
	 (1,'James Schofield Dr','South Australia',5950,'Adelaide Airport'),
	 (150,'Surfers Paradise Blvd','Queensland',4217,'Gold Coast'),
	 (8,'Airport Ave','Queensland',4870,'Cairns Airport'),
	 (50,'Henry Wrigley Dr','Northern Territory',820,'Darwin Airport'),
	 (120,'Elizabeth St','Tasmania',7000,'Hobart City'),
	 (3,'Terminal Ave','Australian Capital Territory',2609,'Canberra Airport');
INSERT INTO `CarRental-ASD`.Location (Location_Street_Number,Location_Street_Name,Location_State,Location_Postcode,Location_Name) VALUES
	 (35,'Hunter St','New South Wales',2300,'Newcastle City'),
	 (78,'Crown St','New South Wales',2500,'Wollongong'),
	 (90,'Ryrie St','Victoria',3220,'Geelong'),
	 (24,'Sturt St','Victoria',3350,'Ballarat'),
	 (12,'Flinders St','Queensland',4810,'Townsville'),
	 (3,'Stuart Hwy','Northern Territory',870,'Alice Springs'),
	 (10,'Evandale Rd','Tasmania',7212,'Launceston Airport'),
	 (65,'East St','Queensland',4700,'Rockhampton'),
	 (12,'Friendship Ave','Queensland',4564,'Sunshine Coast Airport'),
	 (101,'Boundary Rd E','Queensland',4740,'Mackay Airport');


CREATE USER 'wy5jR63bAEYi1GxT'@'%' IDENTIFIED BY '6JcL1ECgLzQnmH75';
GRANT ALL PRIVILEGES ON *.* TO wy5jR63bAEYi1GxT IDENTIFIED BY '6JcL1ECgLzQnmH75';
FLUSH PRIVILEGES;
-- '%' allows access from any IP address. Should replace with dest IP
