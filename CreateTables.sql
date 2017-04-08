CREATE TABLE `Product` (
  `product_id` 	varchar(20) NOT NULL,
  `P_G_price` 		int(10) DEFAULT NULL,
  `Name` 		varchar(60) DEFAULT NULL,
  `AVG_cost` 	numeric(12,4) DEFAULT NULL,
  `O_place` 	varchar(20) DEFAULT NULL,
  `S_life` 		    int(10) DEFAULT NULL,
  `Suppier_id` 	    char(4) DEFAULT NULL,
  `fileName`   varchar (60) DEFAULT NULL,
  `productImage`     longblob     DEFAULT NULL,
  `on_shelf`     		BOOLEAN  ,
  
	CONSTRAINT Product_product_id_PK PRIMARY KEY (`product_id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `Taste` (
  `Taste_id` 	varchar(4) NOT NULL,
  `Taste_Name` 	varchar(60) DEFAULT NULL,
  
	CONSTRAINT Taste_Taste_id_PK PRIMARY KEY (`Taste_id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE `Package` (
  `Package_id` 	    varchar(20) NOT NULL,
  `Description` 	varchar(60) DEFAULT NULL,

  
	CONSTRAINT Package_Package_id_PK PRIMARY KEY (`Package_Id`)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `Product_Taste_Package` (
  `Product_id` 	    varchar(20) NOT NULL,
  `Taste_id` 	    varchar(4)  NOT NULL,
  `Package_id` 	    varchar(20) NOT NULL,
  
	CONSTRAINT P_T_P_Product_id_FK FOREIGN KEY (Product_id) 
		REFERENCES Product(Product_id),
	CONSTRAINT P_T_P_Taste_id_FK FOREIGN KEY (Taste_id) 
		REFERENCES Taste(Taste_id),
	CONSTRAINT P_T_P_Package_id_FK FOREIGN KEY (Package_id) 
		REFERENCES Package(Package_id),
	CONSTRAINT P_T_P_P_T_P_id_PK PRIMARY KEY (Product_id,Taste_id,Package_id)
) CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `Stock` (

  `Stock_id` 	    varchar(20) NOT NULL,
  `product_id` 	    varchar(20) NOT NULL,
  `S_life` 		    int(10) NOT NULL,
  `MFG` 	DATETIME NOT NULL,
  `EXP` 	DATETIME NOT NULL,
  `quantity` 	varchar(6) NOT NULL,

	CONSTRAINT `Stock_Product_id_FK` FOREIGN KEY (`product_id`) 
		REFERENCES `product`(`product_id`),
	CONSTRAINT `Stock_S_life_FK` FOREIGN KEY (`S_life`) 
		REFERENCES `product`(`S_life`),
	CONSTRAINT `Stock_PK` PRIMARY KEY (`Stock_id`)
	
)	CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE `Member`(			
	M_Username		VARCHAR(40) NOT NULL,
	M_Password		VARCHAR(60) NOT NULL,
	M_Name			VARCHAR(20) NOT NULL,
	M_Cellphone		VARCHAR(20) NOT NULL,
	M_Birthday		date NOT NULL,
	M_Insertdate	datetime,
	M_Updatedate	datetime,
	M_Level			CHAR(1) default 0,		
	M_BonusPoints	INT,					
	M_Total			NUMERIC(15,2),			
	M_Certification tinyint(1) default 0,
	
	CONSTRAINT Member_M_Username PRIMARY KEY (M_Username)
	
)	CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `User`(
	userId 			VARCHAR(20) NOT NULL,
	password		VARCHAR(20) NOT NULL,
	name 			VARCHAR(20) NOT NULL,
	grade			VARCHAR(4) NOT NULL,
	
	CONSTRAINT User_userId PRIMARY KEY (userId)
	
)	CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `Order`(
	OrderId 			VARCHAR(20) NOT NULL,
	OrderDate			DATETIME NOT NULL,
	ShippedDate 		DATETIME NOT NULL,
	M_Username			VARCHAR(20) NOT NULL,
	OrderTotal			INT NOT NULL,
	
	CONSTRAINT `Order_M_Username_FK` FOREIGN KEY (`M_Username`) 
		REFERENCES `Member`(`M_Username`),
	CONSTRAINT `Order_OrderId_PK` PRIMARY KEY (OrderId)
		
)	CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `OrderDetail`(
	OrderId 			VARCHAR(20) NOT NULL,
	product_id			VARCHAR(20) NOT NULL,
	product_name		VARCHAR(20) NOT NULL,
	P_G_price 			INT NOT NULL,
	Quantity			INT NOT NULL,
	SubTotal			INT NOT NULL,
	score				INT,
	
	
	CONSTRAINT `OrderDetail_OrderId_FK` FOREIGN KEY (`OrderId`) 
		REFERENCES `Order`(`OrderId`),
	CONSTRAINT `OrderDetail_product_id_FK` FOREIGN KEY (`product_id`) 
		REFERENCES `Product`(`product_id`),
	CONSTRAINT `OrderDetail_PK` PRIMARY KEY (`OrderId`,`product_id`)
	
)	CHARACTER SET utf8 COLLATE utf8_general_ci;
