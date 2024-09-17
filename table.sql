-- CarRental-ASD

-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS `CarRental-ASD`;
USE `CarRental-ASD`;

-- Car Table
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Car DATA
INSERT INTO `Car` (Car_Make, Car_Model, Car_Trim, Car_Odometer, Car_Image, Car_Transmission, Car_Fuel, Car_Seats, Car_Body_Style, Car_Quip, Car_Purchase_Price, Car_Current_Price, Car_Price_KM, Car_Location, Car_Rating) VALUES
  ('MG','3','Excite',20000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/mg-mg3-my19-index.png','M','P',5,'Hatch','Fuel Efficient',25000,1,1,'1',4),
  ('Toyota','Corolla','GXL',15000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/toyota-corolla-my19-index-%281%29.png','A','H',5,'Hatch','Handles Well',30000,1,3,'1',5),
  ('Toyota','Camry','LE',50000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/toyota-camry-my21-index-1.png','A','P',5,'Sedan','Reliable and spacious',20000,18000,1,'1',5),
  ('Honda','Civic','EX',30000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/honda-civic-index.png','M','P',5,'Sedan','Fuel efficient and compact',18000,16000,1,'1',5),
  ('Ford','Escape','Titanium',40000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/ford-escape-my21-index-1.png','A','P',5,'SUV','Adventure-ready',25000,22000,1,'1',4),
  ('Holden','Cruze','LS',60000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/Holden-Cruze.png','A','P',5,'Sedan','Comfortable and smooth',22000,20000,1,'1',4),
  ('BMW','3 Series','330i',35000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/bmw-3-series-index.png','A','P',5,'Sedan','Luxury and performance',35000,32000,1,'1',5),
  ('Audi','Q5','Premium Plus',45000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/audi-q5-my21-index-1.png','A','P',5,'SUV','Elegant and powerful',40000,37000,1,'1',5),
  ('Nissan','Pulsar','ST',25000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/Nissan-Pulsar_0.png','A','P',5,'Sedan','Stylish and efficient',19000,17000,1,'1',5),
  ('Hyundai','Elantra','SE',20000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/Elantra-Active-index-1200x800-%281%29.png','M','P',5,'Sedan','Affordable and reliable',16000,14000,1,'1',4);

-- Insert additional data
INSERT INTO `Car` (Car_Make, Car_Model, Car_Trim, Car_Odometer, Car_Image, Car_Transmission, Car_Fuel, Car_Seats, Car_Body_Style, Car_Quip, Car_Purchase_Price, Car_Current_Price, Car_Price_KM, Car_Location, Car_Rating) VALUES
  ('Subaru','Outback','Limited',55000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/subaru-outback-my21-index-01.png','A','P',5,'SUV','Versatile and rugged',28000,25000,1,'1',5),
  ('Mercedes-Benz','C-Class','C300',30000,'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_low/v1/editorial/vhs/merc%20c300%20small_0.png','A','P',5,'Sedan','Luxury and class',42000,40000,1,'1',5);


CREATE USER 'root'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON your_database.* TO 'root'@'%';
FLUSH PRIVILEGES;
-- '%' allows access from any IP address. Should replace with dest IP