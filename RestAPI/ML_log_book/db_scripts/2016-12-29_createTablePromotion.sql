CREATE TABLE `Library`.`Promotion` (
  `idPromotion` INT NOT NULL,
  `Title` VARCHAR(50) NOT NULL,
  `Description` VARCHAR(50) NOT NULL,
  `StartDate` VARCHAR(50) NULL,
  `EndDate` VARCHAR(45) NULL,
  `CreationDate` timestamp NOT NULL DEFAULT current_timestamp,
  `CreatedBy` VARCHAR(50) NULL,
  `LastModificationDate` DATETIME NULL,
  `LastModifiedBy` VARCHAR(50) NULL,
  PRIMARY KEY (`idPromotion`));
