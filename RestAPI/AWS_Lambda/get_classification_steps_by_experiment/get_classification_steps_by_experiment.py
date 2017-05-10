#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created 2017-05-09 22:30
Function that gets the classification steps(of a given type) of a given experiment
@author: luis
"""
import pymysql.cursors


def get_classification_steps_by_experiment(event,context):
    #TODO: 
    ## - Add error handling and return statusCode in function of that. 
    ## - Test and implement if a single shared DB connection end point can be used between lambdas  
    ## - Improve security(store encrypted credentials and decrypt them)
    ## - Change query by stored procedure call
    connection = pymysql.connect(host='#',
                             user='#',
                             password='#',
                             db='#',
                             charset='utf8mb4',
                             cursorclass=pymysql.cursors.DictCursor)
    classification_steps = list()
    step_type = event["params"]["path"]["step_type"]
    experiment = event["params"]["path"]["experiment"]
    
    try:
        with connection.cursor(pymysql.cursors.DictCursor) as cursor:
            sql = """SELECT ClassificationStep.FKBinaryClassificationExperiment,
					ClassificationStep.step_number,
					ClassificationStep.FKExperimentType,
					ClassificationStep.TrainCostErrorLoss,
					ClassificationStep.TrainAccuracyRate,
					ClassificationStep.TrainMisclassificationRate,
					ClassificationStep.TrainRightPredictions,
					ClassificationStep.TrainWrongPredictions,
					ClassificationStep.TrainTruePositives,
					ClassificationStep.TrainFalsePositives,
					ClassificationStep.TrainTrueNegatives,
					ClassificationStep.TrainFalseNegatives,
					ClassificationStep.TrainPrecission,
					ClassificationStep.TrainRecall,
					ClassificationStep.TrainF1Score,
					ClassificationStep.ValidationCostErrorLoss,
					ClassificationStep.ValidationAccuracyRate,
					ClassificationStep.ValidationMisclassificationRate,
					ClassificationStep.ValidationRightPredictions,
					ClassificationStep.ValidationWrongPredictions,
					ClassificationStep.ValidationTruePositives,
					ClassificationStep.ValidationFalsePositives,
					ClassificationStep.ValidationTrueNegatives,
					ClassificationStep.ValidationFalseNegatives,
					ClassificationStep.ValidationPrecision,
					ClassificationStep.ValidationRecall,
					ClassificationStep.ValidationF1Score,
					ClassificationStep.TestCostErrorLoss,
					ClassificationStep.TestAcurracyRate,
					ClassificationStep.TestMisclassificationRate,
					ClassificationStep.TestRightPredictions,
					ClassificationStep.TestWrongPredictions,
					ClassificationStep.TestTruePositives,
					ClassificationStep.TestFalsePositives,
					ClassificationStep.TestTrueNegatives,
					ClassificationStep.TestFalseNegatives,
					ClassificationStep.TestPrecision,
					ClassificationStep.TestRecall,
					ClassificationStep.TestF1Score
					FROM ML_log_book.ClassificationStep
					WHERE FKBinaryClassificationExperiment= """+  str(experiment) +" AND FKExperimentType = "+str(step_type)
            cursor.execute(sql)
            classification_steps = cursor.fetchall()


 
    finally:
        connection.close()
    
          
    return {"statusCode": 200,"headers":{"Content-Type": "application/json"},'body':{'classification_steps':classification_steps}}


