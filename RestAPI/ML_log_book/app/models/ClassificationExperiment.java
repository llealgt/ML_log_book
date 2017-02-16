/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import javax.persistence.*;
/**
 *
 * @author luisf
 */
@Entity
public class ClassificationExperiment {
    public static String TABLE = ClassificationExperiment.class.getSimpleName();
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int PKClassificationExperiment;
    @ManyToOne
    @JoinColumn(name ="FKExperimentGroup")
    private ExperimentGroup experimentGroup;
    
    private String architecture;
    /** Field mapping. */
    private Double complexity;
    /** Field mapping. */
    private Date endTime;
    /** Field mapping. */
    private Date estartTime;
    /** Field mapping. */
    private String experimentDirectory;
    /** Field mapping. */
    private String finalComments;
    /** Field mapping. */
    private Double regularizationFactor;
    /** Field mapping. */
    private Double testAcurracyRate;
    /** Field mapping. */
    private Double testCostErrorLoss;
    /** Field mapping. */
    private Double testf1Score;
    /** Field mapping. */
    private Integer testFalseNegatives;
    /** Field mapping. */
    private Integer testFalsePositives;
    /** Field mapping. */
    private Double testMisclassificationRate;
    /** Field mapping. */
    private Double testPrecision;
    /** Field mapping. */
    private Double testRecall;
    /** Field mapping. */
    private Integer testRightPredictions;
    /** Field mapping. */
    private Integer testSize;
    /** Field mapping. */
    private Integer testTrueNegatives;
    /** Field mapping. */
    private Integer testTruePositives;
    /** Field mapping. */
    private Integer testWrongPredictions;
    /** Field mapping. */
    private Double trainAccuracyRate;
    /** Field mapping. */
    private Double trainCostErrorLoss;
    /** Field mapping. */
    private Double trainf1Score;
    /** Field mapping. */
    private Integer trainFalseNegatives;
    /** Field mapping. */
    private Integer trainFalsePositives;
    /** Field mapping. */
    private Integer trainingEpochs;
    /** Field mapping. */
    private Integer trainingSteps;
    /** Field mapping. */
    private Double trainMisclassificationRate;
    /** Field mapping. */
    private Double trainPrecission;
    /** Field mapping. */
    private Double trainRecall;
    /** Field mapping. */
    private Integer trainRightPredictions;
    /** Field mapping. */
    private Integer trainSize;
    /** Field mapping. */
    private Integer trainTrueNegatives;
    /** Field mapping. */
    private Integer trainTruePositives;
    /** Field mapping. */
    private Integer trainWrongPredictions;
    /** Field mapping. */
    private Double validationAccuracyRate;
    /** Field mapping. */
    private Double validationCostErrorLoss;
    /** Field mapping. */
    private Double validationf1Score;
    /** Field mapping. */
    private Integer validationFalseNegatives;
    /** Field mapping. */
    private Integer validationFalsePositives;
    /** Field mapping. */
    private Double validationMisclassificationRate;
    /** Field mapping. */
    private Double validationPrecision;
    /** Field mapping. */
    private Double validationRecall;
    /** Field mapping. */
    private Integer validationRightPredictions;
    /** Field mapping. */
    private Integer validationSize;
    /** Field mapping. */
    private Integer validationTrueNegatives;
    /** Field mapping. */
    private Integer validationTruePositives;
    /** Field mapping. */
    private Integer validationWrongPredictions;
    //-------
    public ClassificationExperiment(){}

    public static String getTABLE() {
        return TABLE;
    }

    public static void setTABLE(String TABLE) {
        ClassificationExperiment.TABLE = TABLE;
    }

    public int getPKClassificationExperiment() {
        return PKClassificationExperiment;
    }

    public void setPKClassificationExperiment(int PKClassificationExperiment) {
        this.PKClassificationExperiment = PKClassificationExperiment;
    }

    public ExperimentGroup getExperimentGroup() {
        return experimentGroup;
    }

    public void setExperimentGroup(ExperimentGroup experimentGroup) {
        this.experimentGroup = experimentGroup;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public Double getComplexity() {
        return complexity;
    }

    public void setComplexity(Double complexity) {
        this.complexity = complexity;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEstartTime() {
        return estartTime;
    }

    public void setEstartTime(Date estartTime) {
        this.estartTime = estartTime;
    }

    public String getExperimentDirectory() {
        return experimentDirectory;
    }

    public void setExperimentDirectory(String experimentDirectory) {
        this.experimentDirectory = experimentDirectory;
    }

    public String getFinalComments() {
        return finalComments;
    }

    public void setFinalComments(String finalComments) {
        this.finalComments = finalComments;
    }

    public Double getRegularizationFactor() {
        return regularizationFactor;
    }

    public void setRegularizationFactor(Double regularizationFactor) {
        this.regularizationFactor = regularizationFactor;
    }

    public Double getTestAcurracyRate() {
        return testAcurracyRate;
    }

    public void setTestAcurracyRate(Double testAcurracyRate) {
        this.testAcurracyRate = testAcurracyRate;
    }

    public Double getTestCostErrorLoss() {
        return testCostErrorLoss;
    }

    public void setTestCostErrorLoss(Double testCostErrorLoss) {
        this.testCostErrorLoss = testCostErrorLoss;
    }

    public Double getTestf1Score() {
        return testf1Score;
    }

    public void setTestf1Score(Double testf1Score) {
        this.testf1Score = testf1Score;
    }

    public Integer getTestFalseNegatives() {
        return testFalseNegatives;
    }

    public void setTestFalseNegatives(Integer testFalseNegatives) {
        this.testFalseNegatives = testFalseNegatives;
    }

    public Integer getTestFalsePositives() {
        return testFalsePositives;
    }

    public void setTestFalsePositives(Integer testFalsePositives) {
        this.testFalsePositives = testFalsePositives;
    }

    public Double getTestMisclassificationRate() {
        return testMisclassificationRate;
    }

    public void setTestMisclassificationRate(Double testMisclassificationRate) {
        this.testMisclassificationRate = testMisclassificationRate;
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

    public Integer getTestRightPredictions() {
        return testRightPredictions;
    }

    public void setTestRightPredictions(Integer testRightPredictions) {
        this.testRightPredictions = testRightPredictions;
    }

    public Integer getTestSize() {
        return testSize;
    }

    public void setTestSize(Integer testSize) {
        this.testSize = testSize;
    }

    public Integer getTestTrueNegatives() {
        return testTrueNegatives;
    }

    public void setTestTrueNegatives(Integer testTrueNegatives) {
        this.testTrueNegatives = testTrueNegatives;
    }

    public Integer getTestTruePositives() {
        return testTruePositives;
    }

    public void setTestTruePositives(Integer testTruePositives) {
        this.testTruePositives = testTruePositives;
    }

    public Integer getTestWrongPredictions() {
        return testWrongPredictions;
    }

    public void setTestWrongPredictions(Integer testWrongPredictions) {
        this.testWrongPredictions = testWrongPredictions;
    }

    public Double getTrainAccuracyRate() {
        return trainAccuracyRate;
    }

    public void setTrainAccuracyRate(Double trainAccuracyRate) {
        this.trainAccuracyRate = trainAccuracyRate;
    }

    public Double getTrainCostErrorLoss() {
        return trainCostErrorLoss;
    }

    public void setTrainCostErrorLoss(Double trainCostErrorLoss) {
        this.trainCostErrorLoss = trainCostErrorLoss;
    }

    public Double getTrainf1Score() {
        return trainf1Score;
    }

    public void setTrainf1Score(Double trainf1Score) {
        this.trainf1Score = trainf1Score;
    }

    public Integer getTrainFalseNegatives() {
        return trainFalseNegatives;
    }

    public void setTrainFalseNegatives(Integer trainFalseNegatives) {
        this.trainFalseNegatives = trainFalseNegatives;
    }

    public Integer getTrainFalsePositives() {
        return trainFalsePositives;
    }

    public void setTrainFalsePositives(Integer trainFalsePositives) {
        this.trainFalsePositives = trainFalsePositives;
    }

    public Integer getTrainingEpochs() {
        return trainingEpochs;
    }

    public void setTrainingEpochs(Integer trainingEpochs) {
        this.trainingEpochs = trainingEpochs;
    }

    public Integer getTrainingSteps() {
        return trainingSteps;
    }

    public void setTrainingSteps(Integer trainingSteps) {
        this.trainingSteps = trainingSteps;
    }

    public Double getTrainMisclassificationRate() {
        return trainMisclassificationRate;
    }

    public void setTrainMisclassificationRate(Double trainMisclassificationRate) {
        this.trainMisclassificationRate = trainMisclassificationRate;
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

    public Integer getTrainRightPredictions() {
        return trainRightPredictions;
    }

    public void setTrainRightPredictions(Integer trainRightPredictions) {
        this.trainRightPredictions = trainRightPredictions;
    }

    public Integer getTrainSize() {
        return trainSize;
    }

    public void setTrainSize(Integer trainSize) {
        this.trainSize = trainSize;
    }

    public Integer getTrainTrueNegatives() {
        return trainTrueNegatives;
    }

    public void setTrainTrueNegatives(Integer trainTrueNegatives) {
        this.trainTrueNegatives = trainTrueNegatives;
    }

    public Integer getTrainTruePositives() {
        return trainTruePositives;
    }

    public void setTrainTruePositives(Integer trainTruePositives) {
        this.trainTruePositives = trainTruePositives;
    }

    public Integer getTrainWrongPredictions() {
        return trainWrongPredictions;
    }

    public void setTrainWrongPredictions(Integer trainWrongPredictions) {
        this.trainWrongPredictions = trainWrongPredictions;
    }

    public Double getValidationAccuracyRate() {
        return validationAccuracyRate;
    }

    public void setValidationAccuracyRate(Double validationAccuracyRate) {
        this.validationAccuracyRate = validationAccuracyRate;
    }

    public Double getValidationCostErrorLoss() {
        return validationCostErrorLoss;
    }

    public void setValidationCostErrorLoss(Double validationCostErrorLoss) {
        this.validationCostErrorLoss = validationCostErrorLoss;
    }

    public Double getValidationf1Score() {
        return validationf1Score;
    }

    public void setValidationf1Score(Double validationf1Score) {
        this.validationf1Score = validationf1Score;
    }

    public Integer getValidationFalseNegatives() {
        return validationFalseNegatives;
    }

    public void setValidationFalseNegatives(Integer validationFalseNegatives) {
        this.validationFalseNegatives = validationFalseNegatives;
    }

    public Integer getValidationFalsePositives() {
        return validationFalsePositives;
    }

    public void setValidationFalsePositives(Integer validationFalsePositives) {
        this.validationFalsePositives = validationFalsePositives;
    }

    public Double getValidationMisclassificationRate() {
        return validationMisclassificationRate;
    }

    public void setValidationMisclassificationRate(Double validationMisclassificationRate) {
        this.validationMisclassificationRate = validationMisclassificationRate;
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

    public Integer getValidationRightPredictions() {
        return validationRightPredictions;
    }

    public void setValidationRightPredictions(Integer validationRightPredictions) {
        this.validationRightPredictions = validationRightPredictions;
    }

    public Integer getValidationSize() {
        return validationSize;
    }

    public void setValidationSize(Integer validationSize) {
        this.validationSize = validationSize;
    }

    public Integer getValidationTrueNegatives() {
        return validationTrueNegatives;
    }

    public void setValidationTrueNegatives(Integer validationTrueNegatives) {
        this.validationTrueNegatives = validationTrueNegatives;
    }

    public Integer getValidationTruePositives() {
        return validationTruePositives;
    }

    public void setValidationTruePositives(Integer validationTruePositives) {
        this.validationTruePositives = validationTruePositives;
    }

    public Integer getValidationWrongPredictions() {
        return validationWrongPredictions;
    }

    public void setValidationWrongPredictions(Integer validationWrongPredictions) {
        this.validationWrongPredictions = validationWrongPredictions;
    }
    
    
}
