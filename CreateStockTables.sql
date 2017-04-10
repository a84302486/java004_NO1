
CREATE TABLE `Stock` (
	
  `StockId` 	    varchar(20) NOT NULL,
  `product_id` 	    varchar(20) NOT NULL,
  `MFG` 	DATE NOT NULL,
  `EXP` 	DATE NOT NULL,
  `quantity` 	int NOT NULL,

	CONSTRAINT `Stock_Product_id_FK` FOREIGN KEY (`product_id`) 
		REFERENCES `product`(`product_id`),
	CONSTRAINT `Stock_PK` PRIMARY KEY (StockId)
	
)	CHARACTER SET utf8 COLLATE utf8_general_ci;
