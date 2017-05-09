#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created 2017-05-08 22:40
Function that get classification experiments by the experiment group they belong to
@author: luis
"""
import pymysql.cursors


def get_classification_experiment_by_experiment_group(event,context):
    #TODO: 
    ## - Add error handling and return statusCode in function of that. 
    ## - Test and implement if a single shared DB connection end point can be used between lambdas  
    ## - Improve security(store encrypted credentials and decrypt them)
    ## - Change query by stored procedure call
    connection = pymysql.connect(host='#',
                             user='#',
                             password='#',
                             db='ML_log_book',
                             charset='utf8mb4',
                             cursorclass=pymysql.cursors.DictCursor)
    experiments = list()
    experiment_group_id = event["params"]["path"]["experiment_group_id"]
    try:
        with connection.cursor(pymysql.cursors.DictCursor) as cursor:
            sql = """SELECT ClassificationExperiment.PKClassificationExperiment,
						ClassificationExperiment.FKExperimentGroup,
						ClassificationExperiment.Architecture,
						ClassificationExperiment.TrainSize,
						ClassificationExperiment.ValidationSize,
						ClassificationExperiment.TestSize,
						ClassificationExperiment.TrainingSteps,
						ClassificationExperiment.TrainingEpochs,
						ClassificationExperiment.Complexity,
						ClassificationExperiment.RegularizationFactor,
						ClassificationExperiment.ExperimentDirectory,
						ClassificationExperiment.TrainCostErrorLoss,
						ClassificationExperiment.TrainAccuracyRate,
						ClassificationExperiment.TrainMisclassificationRate,
						ClassificationExperiment.TrainRightPredictions,
						ClassificationExperiment.TrainWrongPredictions,
						ClassificationExperiment.TrainTruePositives,
						ClassificationExperiment.TrainFalsePositives,
						ClassificationExperiment.TrainTrueNegatives,
						ClassificationExperiment.TrainFalseNegatives,
						ClassificationExperiment.TrainPrecission,
						ClassificationExperiment.TrainRecall,
						ClassificationExperiment.TrainF1Score,
						ClassificationExperiment.ValidationCostErrorLoss,
						ClassificationExperiment.ValidationAccuracyRate,
						ClassificationExperiment.ValidationMisclassificationRate,
						ClassificationExperiment.ValidationRightPredictions,
						ClassificationExperiment.ValidationWrongPredictions,
						ClassificationExperiment.ValidationTruePositives,
						ClassificationExperiment.ValidationFalsePositives,
						ClassificationExperiment.ValidationTrueNegatives,
						ClassificationExperiment.ValidationFalseNegatives,
						ClassificationExperiment.ValidationPrecision,
						ClassificationExperiment.ValidationRecall,
						ClassificationExperiment.ValidationF1Score,
						ClassificationExperiment.TestCostErrorLoss,
						ClassificationExperiment.TestAcurracyRate,
						ClassificationExperiment.TestMisclassificationRate,
						ClassificationExperiment.TestRightPredictions,
						ClassificationExperiment.TestWrongPredictions,
						ClassificationExperiment.TestTruePositives,
						ClassificationExperiment.TestFalsePositives,
						ClassificationExperiment.TestTrueNegatives,
						ClassificationExperiment.TestFalseNegatives,
						ClassificationExperiment.TestPrecision,
						ClassificationExperiment.TestRecall,
						ClassificationExperiment.TestF1Score,
						ClassificationExperiment.FinalComments
						FROM ML_log_book.ClassificationExperiment WHERE FKExperimentGroup =  """+experiment_group_id+";"""
            cursor.execute(sql)
            experiments = cursor.fetchall()


 
    finally:
        connection.close()
    
          
    return {"statusCode": 200,"headers":{"Content-Type": "application/json"},'body':{'classification_experiments':experiments}}

#event = {"body":{"email":"wichofer89@gmail.com","password":"waitlines"},"headers":"testing","params":{"querystring":{"phone":"1"}}}

#print(verify_valid_credentials(event,event))


