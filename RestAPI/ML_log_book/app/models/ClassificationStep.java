/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
/**
 *
 * @author luisf
 */
@Entity      
public class ClassificationStep implements Serializable 
{
    
    public static String TABLE = ClassificationStep.class.getSimpleName();
        
//    @ManyToOne
//    @JoinColumn(name = "FKBinaryClassificationExperiment")
    @Id
    private Integer FKBinaryClassificationExperiment;
    @Id
    private Integer step_number;
//    @ManyToOne
//    @JoinColumn(name = "FKExperimentType")
    private Integer FKExperimentType;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date estartTime;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endTime;
    //private Date endTime;
//    /** Field mapping. */
//    private Date estartTime;
    private Double trainCostErrorLoss;
    private Double trainAccuracyRate;
    private Double trainMisclassificationRate;
    private Integer trainRightPredictions;
    private Integer trainWrongPredictions;
    private Integer trainTruePositives;
    private Integer trainFalsePositives;
    private Integer trainTrueNegatives;
    private Integer trainFalseNegatives;
    private Double trainPrecission;
    private Double trainRecall;
    private Double trainF1Score;
    private Double validationCostErrorLoss;
    private Double validationAccuracyRate;
    private Double validationMisclassificationRate;
    private Integer validationRightPredictions;
    private Integer validationWrongPredictions;
    private Integer validationTruePositives;
    private Integer validationFalsePositives;
    private Integer validationTrueNegatives;
    private Integer validationFalseNegatives;
    private Double validationPrecision;
    private Double validationRecall;
    private Double validationF1Score;
    private Double testCostErrorLoss;
    private Double testAcurracyRate;
    private Double testMisclassificationRate;
    private Integer testRightPredictions;
    private Integer  testWrongPredictions;
    private Integer testTruePositives;
    private Integer testFalsePositives;
    private Integer testTrueNegatives;
    private Integer  testFalseNegatives;
    private Double testPrecision;
    private Double testRecall;
    private Double testF1Score;
    
    public ClassificationStep(){}

    public Integer getFKBinaryClassificationExperiment() {
        return FKBinaryClassificationExperiment;
    }

    public void setFKBinaryClassificationExperiment(Integer FKBinaryClassificationExperiment) {
        this.FKBinaryClassificationExperiment = FKBinaryClassificationExperiment;
    }

    public Integer getStep_number() {
        return step_number;
    }

    public void setStep_number(Integer step_number) {
        this.step_number = step_number;
    }

    public Integer getFKExperimentType() {
        return FKExperimentType;
    }

    public void setFKExperimentType(Integer FKExperimentType) {
        this.FKExperimentType = FKExperimentType;
    }

//    public Date getEstartTime() {
//        return estartTime;
//    }
//
//    public void setEstartTime(Date estartTime) {
//        this.estartTime = estartTime;
//    }
//
//    public Date getEndTime() {
//        return endTime;
//    }
//
//    public void setEndTime(Date endTime) {
//        this.endTime = endTime;
//    }

    public Double getTrainCostErrorLoss() {
        return trainCostErrorLoss;
    }

    public void setTrainCostErrorLoss(Double trainCostErrorLoss) {
        this.trainCostErrorLoss = trainCostErrorLoss;
    }

    public Double getTrainAccuracyRate() {
        return trainAccuracyRate;
    }

    public void setTrainAccuracyRate(Double trainAccuracyRate) {
        this.trainAccuracyRate = trainAccuracyRate;
    }

    public Double getTrainMisclassificationRate() {
        return trainMisclassificationRate;
    }

    public void setTrainMisclassificationRate(Double trainMisclassificationRate) {
        this.trainMisclassificationRate = trainMisclassificationRate;
    }

    public Integer getTrainRightPredictions() {
        return trainRightPredictions;
    }

    public void setTrainRightPredictions(Integer trainRightPredictions) {
        this.trainRightPredictions = trainRightPredictions;
    }

    public Integer getTrainWrongPredictions() {
        return trainWrongPredictions;
    }

    public void setTrainWrongPredictions(Integer trainWrongPredictions) {
        this.trainWrongPredictions = trainWrongPredictions;
    }

    public Integer getTrainTruePositives() {
        return trainTruePositives;
    }

    public void setTrainTruePositives(Integer trainTruePositives) {
        this.trainTruePositives = trainTruePositives;
    }

    public Integer getTrainFalsePositives() {
        return trainFalsePositives;
    }

    public void setTrainFalsePositives(Integer trainFalsePositives) {
        this.trainFalsePositives = trainFalsePositives;
    }

    public Integer getTrainTrueNegatives() {
        return trainTrueNegatives;
    }

    public void setTrainTrueNegatives(Integer trainTrueNegatives) {
        this.trainTrueNegatives = trainTrueNegatives;
    }

    public Integer getTrainFalseNegatives() {
        return trainFalseNegatives;
    }

    public void setTrainFalseNegatives(Integer trainFalseNegatives) {
        this.trainFalseNegatives = trainFalseNegatives;
    }

    public Double getTrainPrecission() {
        return trainPrecission;
    }

    public void setTrainPrecission(Double trainPrecission) {
        this.trainPrecission = trainPrecission;
    }

    public Double getTrainRecall() {
        return trainRecall;
    }

    public void setTrainRecall(Double trainRecall) {
        this.trainRecall = trainRecall;
    }

    public Double getTrainF1Score() {
        return trainF1Score;
    }

    public void setTrainF1Score(Double trainF1Score) {
        this.trainF1Score = trainF1Score;
    }

    public Double getValidationCostErrorLoss() {
        return validationCostErrorLoss;
    }

    public void setValidationCostErrorLoss(Double validationCostErrorLoss) {
        this.validationCostErrorLoss = validationCostErrorLoss;
    }

    public Double getValidationAccuracyRate() {
        return validationAccuracyRate;
    }

    public void setValidationAccuracyRate(Double validationAccuracyRate) {
        this.validationAccuracyRate = validationAccuracyRate;
    }

    public Double getValidationMisclassificationRate() {
        return validationMisclassificationRate;
    }

    public void setValidationMisclassificationRate(Double validationMisclassificationRate) {
        this.validationMisclassificationRate = validationMisclassificationRate;
    }

    public Integer getValidationRightPredictions() {
        return validationRightPredictions;
    }

    public void setValidationRightPredictions(Integer validationRightPredictions) {
        this.validationRightPredictions = validationRightPredictions;
    }

    public Integer getValidationWrongPredictions() {
        return validationWrongPredictions;
    }

    public void setValidationWrongPredictions(Integer validationWrongPredictions) {
        this.validationWrongPredictions = validationWrongPredictions;
    }

    public Integer getValidationTruePositives() {
        return validationTruePositives;
    }

    public void setValidationTruePositives(Integer validationTruePositives) {
        this.validationTruePositives = validationTruePositives;
    }

    public Integer getValidationFalsePositives() {
        return validationFalsePositives;
    }

    public void setValidationFalsePositives(Integer validationFalsePositives) {
        this.validationFalsePositives = validationFalsePositives;
    }

    public Integer getValidationTrueNegatives() {
        return validationTrueNegatives;
    }

    public void setValidationTrueNegatives(Integer validationTrueNegatives) {
        this.validationTrueNegatives = validationTrueNegatives;
    }

    public Integer getValidationFalseNegatives() {
        return validationFalseNegatives;
    }

    public void setValidationFalseNegatives(Integer validationFalseNegatives) {
        this.validationFalseNegatives = validationFalseNegatives;
    }

    public Double getValidationPrecision() {
        return validationPrecision;
    }

    public void setValidationPrecision(Double validationPrecision) {
        this.validationPrecision = validationPrecision;
    }

    public Double getValidationRecall() {
        return validationRecall;
    }

    public void setValidationRecall(Double validationRecall) {
        this.validationRecall = validationRecall;
    }

    public Double getValidationF1Score() {
        return validationF1Score;
    }

    public void setValidationF1Score(Double validationF1Score) {
        this.validationF1Score = validationF1Score;
    }

    public Double getTestCostErrorLoss() {
        return testCostErrorLoss;
    }

    public void setTestCostErrorLoss(Double testCostErrorLoss) {
        this.testCostErrorLoss = testCostErrorLoss;
    }

    public Double getTestAcurracyRate() {
        return testAcurracyRate;
    }

    public void setTestAcurracyRate(Double testAcurracyRate) {
        this.testAcurracyRate = testAcurracyRate;
    }

    public Double getTestMisclassificationRate() {
        return testMisclassificationRate;
    }

    public void setTestMisclassificationRate(Double testMisclassificationRate) {
        this.testMisclassificationRate = testMisclassificationRate;
    }

    public Integer getTestRightPredictions() {
        return testRightPredictions;
    }

    public void setTestRightPredictions(Integer testRightPredictions) {
        this.testRightPredictions = testRightPredictions;
    }

    public Integer getTestWrongPredictions() {
        return testWrongPredictions;
    }

    public void setTestWrongPredictions(Integer testWrongPredictions) {
        this.testWrongPredictions = testWrongPredictions;
    }

    public Integer getTestTruePositives() {
        return testTruePositives;
    }

    public void setTestTruePositives(Integer testTruePositives) {
        this.testTruePositives = testTruePositives;
    }

    public Integer getTestFalsePositives() {
        return testFalsePositives;
    }

    public void setTestFalsePositives(Integer testFalsePositives) {
        this.testFalsePositives = testFalsePositives;
    }

    public Integer getTestTrueNegatives() {
        return testTrueNegatives;
    }

    public void setTestTrueNegatives(Integer testTrueNegatives) {
        this.testTrueNegatives = testTrueNegatives;
    }

    public Integer getTestFalseNegatives() {
        return testFalseNegatives;
    }

    public void setTestFalseNegatives(Integer testFalseNegatives) {
        this.testFalseNegatives = testFalseNegatives;
    }

    public Double getTestPrecision() {
        return testPrecision;
    }

    public void setTestPrecision(Double testPrecision) {
        this.testPrecision = testPrecision;
    }

    public Double getTestRecall() {
        return testRecall;
    }

    public void setTestRecall(Double testRecall) {
        this.testRecall = testRecall;
    }

    public Double getTestF1Score() {
        return testF1Score;
    }

    public void setTestF1Score(Double testF1Score) {
        this.testF1Score = testF1Score;
    }

    public Date getEstartTime() {
        return estartTime;
    }

    public void setEstartTime(Date estartTime) {
        this.estartTime = estartTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    
}
