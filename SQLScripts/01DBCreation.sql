-- MySQL Script generated by MySQL Workbench
-- dom 15 ene 2017 20:00:32 CST
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ML_log_book
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ML_log_book
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ML_log_book` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `ML_log_book` ;

-- -----------------------------------------------------
-- Table `ML_log_book`.`Project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ML_log_book`.`Project` (
  `PKProject` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Description` VARCHAR(100) NOT NULL,
  `ContentDirectory` VARCHAR(256) NULL,
  `CreateTime` DATETIME NOT NULL DEFAULT current_timestamp,
  `LastModificationTime` DATETIME NULL,
  `CreatedBy` VARCHAR(45) NULL,
  `LastModifiedBY` VARCHAR(45) NULL,
  PRIMARY KEY (`PKProject`))
ENGINE = InnoDB
COMMENT = 'A table to store information about the project to wich a group of experiments belong to.';


-- -----------------------------------------------------
-- Table `ML_log_book`.`Algorithm`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ML_log_book`.`Algorithm` (
  `PKAlgorithm` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  `CreateTime` DATETIME NOT NULL DEFAULT current_timestamp,
  `LastModificationTime` DATETIME NULL,
  `CreatedBy` VARCHAR(45) NULL,
  `LastModifiedBY` VARCHAR(45) NULL,
  PRIMARY KEY (`PKAlgorithm`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ML_log_book`.`Tool`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ML_log_book`.`Tool` (
  `PKTool` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  `SiteURL` VARCHAR(45) NULL,
  `CreateTime` DATETIME NOT NULL DEFAULT current_timestamp,
  `LastModificationTime` DATETIME NULL,
  `CreatedBy` VARCHAR(45) NULL,
  `LastModifiedBY` VARCHAR(45) NULL,
  PRIMARY KEY (`PKTool`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ML_log_book`.`ToolFramework`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ML_log_book`.`ToolFramework` (
  `PKToolFramework` INT NOT NULL AUTO_INCREMENT,
  `FKTool` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `CreateTime` DATETIME NOT NULL DEFAULT current_timestamp,
  `LastModificationTime` DATETIME NULL,
  `CreatedBy` VARCHAR(45) NULL,
  `LastModifiedBY` VARCHAR(45) NULL,
  PRIMARY KEY (`PKToolFramework`),
  INDEX `fk_ToolFramework_Tool1_idx` (`FKTool` ASC),
  CONSTRAINT `fk_ToolFramework_Tool1`
    FOREIGN KEY (`FKTool`)
    REFERENCES `ML_log_book`.`Tool` (`PKTool`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ML_log_book`.`ExperimentGroup`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ML_log_book`.`ExperimentGroup` (
  `PKExperimentGroup` INT NOT NULL AUTO_INCREMENT,
  `FKAlgorithm` INT NOT NULL,
  `FKToolFramework` INT NOT NULL,
  `FKProject` INT NOT NULL,
  `Description` VARCHAR(100) NULL,
  `ExecutionHost` VARCHAR(45) NULL,
  `ContentDirectory` VARCHAR(256) NULL,
  `EstartTime` DATETIME NOT NULL DEFAULT current_timestamp,
  `EndTime` DATETIME NULL,
  `Comments` VARCHAR(100) NULL,
  `CreateTime` DATETIME NOT NULL DEFAULT current_timestamp,
  `LastModificationTime` DATETIME NULL,
  `CreatedBy` VARCHAR(45) NULL,
  `LastModifiedBY` VARCHAR(45) NULL,
  PRIMARY KEY (`PKExperimentGroup`),
  INDEX `fk_ExperimentGroup_Algorithm1_idx` (`FKAlgorithm` ASC),
  INDEX `fk_ExperimentGroup_ToolFramework1_idx` (`FKToolFramework` ASC),
  INDEX `fk_ExperimentGroup_Project1_idx` (`FKProject` ASC),
  CONSTRAINT `fk_ExperimentGroup_Algorithm1`
    FOREIGN KEY (`FKAlgorithm`)
    REFERENCES `ML_log_book`.`Algorithm` (`PKAlgorithm`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ExperimentGroup_ToolFramework1`
    FOREIGN KEY (`FKToolFramework`)
    REFERENCES `ML_log_book`.`ToolFramework` (`PKToolFramework`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ExperimentGroup_Project1`
    FOREIGN KEY (`FKProject`)
    REFERENCES `ML_log_book`.`Project` (`PKProject`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ML_log_book`.`ClassificationExperiment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ML_log_book`.`ClassificationExperiment` (
  `PKClassificationExperiment` INT NOT NULL AUTO_INCREMENT,
  `FKExperimentGroup` INT NOT NULL,
  `EstartTime` DATETIME NOT NULL DEFAULT current_timestamp,
  `EndTime` DATETIME NULL,
  `Architecture` VARCHAR(150) NOT NULL,
  `TrainSize` INT NOT NULL,
  `ValidationSize` INT NULL,
  `TestSize` INT NULL,
  `TrainingSteps` INT NULL,
  `TrainingEpochs` INT NULL,
  `Complexity` DOUBLE NULL,
  `RegularizationFactor` DOUBLE NOT NULL DEFAULT 0.0 COMMENT 'Special hyper parameter(do diagnose bias variance in curves)',
  `ExperimentDirectory` VARCHAR(256) NULL,
  `TrainCostErrorLoss` DOUBLE NULL DEFAULT NULL,
  `TrainAccuracyRate` DOUBLE NULL DEFAULT NULL,
  `TrainMisclassificationRate` DOUBLE NULL DEFAULT NULL,
  `TrainRightPredictions` INT NULL DEFAULT NULL,
  `TrainWrongPredictions` INT NULL DEFAULT NULL,
  `TrainTruePositives` INT NULL DEFAULT NULL,
  `TrainFalsePositives` INT NULL DEFAULT NULL,
  `TrainTrueNegatives` INT NULL DEFAULT NULL,
  `TrainFalseNegatives` INT NULL DEFAULT NULL,
  `TrainPrecission` DOUBLE NULL DEFAULT NULL,
  `TrainRecall` DOUBLE NULL DEFAULT NULL,
  `TrainF1Score` DOUBLE NULL DEFAULT NULL,
  `ValidationCostErrorLoss` DOUBLE NULL DEFAULT NULL,
  `ValidationAccuracyRate` DOUBLE NULL DEFAULT NULL,
  `ValidationMisclassificationRate` DOUBLE NULL DEFAULT NULL,
  `ValidationRightPredictions` INT NULL DEFAULT NULL,
  `ValidationWrongPredictions` INT NULL DEFAULT NULL,
  `ValidationTruePositives` INT NULL DEFAULT NULL,
  `ValidationFalsePositives` INT NULL DEFAULT NULL,
  `ValidationTrueNegatives` INT NULL DEFAULT NULL,
  `ValidationFalseNegatives` INT NULL DEFAULT NULL,
  `ValidationPrecision` DOUBLE NULL DEFAULT NULL,
  `ValidationRecall` DOUBLE NULL DEFAULT NULL,
  `ValidationF1Score` DOUBLE NULL DEFAULT NULL,
  `TestCostErrorLoss` DOUBLE NULL DEFAULT NULL,
  `TestAcurracyRate` DOUBLE NULL DEFAULT NULL,
  `TestMisclassificationRate` DOUBLE NULL DEFAULT NULL,
  `TestRightPredictions` INT NULL DEFAULT NULL,
  `TestWrongPredictions` INT NULL DEFAULT NULL,
  `TestTruePositives` INT NULL DEFAULT NULL,
  `TestFalsePositives` INT NULL DEFAULT NULL,
  `TestTrueNegatives` INT NULL DEFAULT NULL,
  `TestFalseNegatives` INT NULL DEFAULT NULL,
  `TestPrecision` DOUBLE NULL DEFAULT NULL,
  `TestRecall` DOUBLE NULL DEFAULT NULL,
  `TestF1Score` DOUBLE NULL DEFAULT NULL,
  `FinalComments` VARCHAR(500) NULL,
  `CreateTime` DATETIME NOT NULL DEFAULT current_timestamp,
  `LastModificationTime` DATETIME NULL,
  `CreatedBy` VARCHAR(45) NULL,
  `LastModifiedBY` VARCHAR(45) NULL,
  INDEX `fk_BinaryClassificationExperiment_ExperimentGroup1_idx` (`FKExperimentGroup` ASC),
  PRIMARY KEY (`PKClassificationExperiment`),
  CONSTRAINT `fk_BinaryClassificationExperiment_ExperimentGroup1`
    FOREIGN KEY (`FKExperimentGroup`)
    REFERENCES `ML_log_book`.`ExperimentGroup` (`PKExperimentGroup`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ML_log_book`.`HyperParameter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ML_log_book`.`HyperParameter` (
  `PKHyperParameter` INT NOT NULL AUTO_INCREMENT,
  `FKClassificationExperiment` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Value` VARCHAR(45) NOT NULL,
  `CreateTime` DATETIME NOT NULL DEFAULT current_timestamp,
  `LastModificationTime` DATETIME NULL,
  `CreatedBy` VARCHAR(45) NULL,
  `LastModifiedBY` VARCHAR(45) NULL,
  PRIMARY KEY (`PKHyperParameter`),
  INDEX `fk_HyperParameter_ClassificationExperiment1_idx` (`FKClassificationExperiment` ASC),
  CONSTRAINT `fk_HyperParameter_ClassificationExperiment1`
    FOREIGN KEY (`FKClassificationExperiment`)
    REFERENCES `ML_log_book`.`ClassificationExperiment` (`PKClassificationExperiment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ML_log_book`.`ExperimentStepType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ML_log_book`.`ExperimentStepType` (
  `PKExperimentType` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `CreateTime` DATETIME NOT NULL DEFAULT current_timestamp,
  `LastModificationTime` DATETIME NULL,
  `CreatedBy` VARCHAR(45) NULL,
  `LastModifiedBY` VARCHAR(45) NULL,
  PRIMARY KEY (`PKExperimentType`))
ENGINE = InnoDB
COMMENT = 'Says if its simple step or an epoch';


-- -----------------------------------------------------
-- Table `ML_log_book`.`BinaryClassificationStep`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ML_log_book`.`BinaryClassificationStep` (
  `FKBinaryClassificationExperiment` INT NOT NULL,
  `step_number` INT NOT NULL,
  `FKExperimentType` INT NOT NULL,
  `EstartTime` DOUBLE NULL DEFAULT current_timestamp,
  `EndTime` DOUBLE NULL,
  `TrainCostErrorLoss` DOUBLE NULL DEFAULT NULL,
  `TrainAccuracyRate` DOUBLE NULL DEFAULT NULL,
  `TrainMisclassificationRate` DOUBLE NULL DEFAULT NULL,
  `TrainRightPredictions` INT NULL DEFAULT NULL,
  `TrainWrongPredictions` INT NULL DEFAULT NULL,
  `TrainTruePositives` INT NULL DEFAULT NULL,
  `TrainFalsePositives` INT NULL DEFAULT NULL,
  `TrainTrueNegatives` INT NULL DEFAULT NULL,
  `TrainFalseNegatives` INT NULL DEFAULT NULL,
  `TrainPrecission` DOUBLE NULL DEFAULT NULL,
  `TrainRecall` DOUBLE NULL DEFAULT NULL,
  `TrainF1Score` DOUBLE NULL DEFAULT NULL,
  `ValidationCostErrorLoss` DOUBLE NULL DEFAULT NULL,
  `ValidationAccuracyRate` DOUBLE NULL DEFAULT NULL,
  `ValidationMisclassificationRate` DOUBLE NULL DEFAULT NULL,
  `ValidationRightPredictions` INT NULL DEFAULT NULL,
  `ValidationWrongPredictions` INT NULL DEFAULT NULL,
  `ValidationTruePositives` INT NULL DEFAULT NULL,
  `ValidationFalsePositives` INT NULL DEFAULT NULL,
  `ValidationTrueNegatives` INT NULL DEFAULT NULL,
  `ValidationFalseNegatives` INT NULL DEFAULT NULL,
  `ValidationPrecision` DOUBLE NULL DEFAULT NULL,
  `ValidationRecall` DOUBLE NULL DEFAULT NULL,
  `ValidationF1Score` DOUBLE NULL DEFAULT NULL,
  `TestCostErrorLoss` DOUBLE NULL DEFAULT NULL,
  `TestAcurracyRate` DOUBLE NULL DEFAULT NULL,
  `TestMisclassificationRate` DOUBLE NULL DEFAULT NULL,
  `TestRightPredictions` INT NULL DEFAULT NULL,
  `TestWrongPredictions` INT NULL DEFAULT NULL,
  `TestTruePositives` INT NULL DEFAULT NULL,
  `TestFalsePositives` INT NULL DEFAULT NULL,
  `TestTrueNegatives` INT NULL DEFAULT NULL,
  `TestFalseNegatives` INT NULL DEFAULT NULL,
  `TestPrecision` DOUBLE NULL DEFAULT NULL,
  `TestRecall` DOUBLE NULL DEFAULT NULL,
  `TestF1Score` DOUBLE NULL DEFAULT NULL,
  `CreateTime` DATETIME NOT NULL DEFAULT current_timestamp,
  `LastModificationTime` DATETIME NULL,
  `CreatedBy` VARCHAR(45) NULL,
  `LastModifiedBY` VARCHAR(45) NULL,
  INDEX `fk_ExperimentStep_BinaryClassificationExperiment1_idx` (`FKBinaryClassificationExperiment` ASC),
  PRIMARY KEY (`FKBinaryClassificationExperiment`, `step_number`),
  INDEX `fk_BinaryClassificationStep_ExperimentStepType1_idx` (`FKExperimentType` ASC),
  CONSTRAINT `fk_ExperimentStep_BinaryClassificationExperiment1`
    FOREIGN KEY (`FKBinaryClassificationExperiment`)
    REFERENCES `ML_log_book`.`ClassificationExperiment` (`PKClassificationExperiment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BinaryClassificationStep_ExperimentStepType1`
    FOREIGN KEY (`FKExperimentType`)
    REFERENCES `ML_log_book`.`ExperimentStepType` (`PKExperimentType`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ML_log_book`.`BinaryClassificationEpoch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ML_log_book`.`BinaryClassificationEpoch` (
  `BinaryClassificationExperiment_idBinaryClassificationExperiment` INT NOT NULL,
  `step_number` INT NULL,
  `training_loss` DOUBLE NULL,
  `training_accuracy` DOUBLE NULL,
  `validation_loss` DOUBLE NULL,
  `vaidation_accuracy` DOUBLE NULL,
  INDEX `fk_ExperimentStep_BinaryClassificationExperiment1_idx` (`BinaryClassificationExperiment_idBinaryClassificationExperiment` ASC),
  CONSTRAINT `fk_ExperimentStep_BinaryClassificationExperiment10`
    FOREIGN KEY (`BinaryClassificationExperiment_idBinaryClassificationExperiment`)
    REFERENCES `ML_log_book`.`ClassificationExperiment` (`PKClassificationExperiment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ML_log_book`.`Feature`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ML_log_book`.`Feature` (
  `PKFeature` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Type` VARCHAR(45) NULL,
  `FKBinaryClassificationExperiment` INT NOT NULL,
  `CreateTime` DATETIME NOT NULL DEFAULT current_timestamp,
  `LastModificationTime` DATETIME NULL,
  `CreatedBy` VARCHAR(45) NULL,
  `LastModifiedBY` VARCHAR(45) NULL,
  PRIMARY KEY (`PKFeature`),
  INDEX `fk_Feature_BinaryClassificationExperiment1_idx` (`FKBinaryClassificationExperiment` ASC),
  CONSTRAINT `fk_Feature_BinaryClassificationExperiment1`
    FOREIGN KEY (`FKBinaryClassificationExperiment`)
    REFERENCES `ML_log_book`.`ClassificationExperiment` (`PKClassificationExperiment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
