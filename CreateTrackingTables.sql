CREATE TABLE `tracking` (
	
  `username` 	    varchar(20) NOT NULL,
  `product_Id` 	    varchar(20) NOT NULL,

	CONSTRAINT `Tracking_Product_id_FK` FOREIGN KEY (`username`) 
		REFERENCES `Member`(`M_Username`),
	CONSTRAINT `tracking_PK` PRIMARY KEY (product_Id)
	
)	CHARACTER SET utf8 COLLATE utf8_general_ci;