#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created 2017-05-28 00:33
REST call to get an experiment hyperparameters
@author: luis
"""
import pymysql.cursors


def get_hyperparameters_by_experiment(event,context):
    #TODO: 
    ## - Add error handling and return statusCode in function of that. 
    ## - Test and implement if a single shared DB connection end point can be used between lambdas  
    ## - Improve security(store encrypted credentials and decrypt them)
    ## - Change query by stored procedure call
    connection = pymysql.connect(host='#',
                             user='#',
                             password='#',
                             db='#',
                             charset='#',
                             cursorclass=pymysql.cursors.DictCursor)
    hyperparameters = list()
    experiment = event["params"]["path"]["experiment"]
    
    try:
        with connection.cursor(pymysql.cursors.DictCursor) as cursor:
            sql = "SELECT PKHyperParameter,Name,Value FROM HyperParameter WHERE FKClassificationExperiment = %s"
            cursor.execute(sql,(experiment))
            hyperparameters = cursor.fetchall()


 
    finally:
        connection.close()
    
          
    return {"statusCode": 200,"headers":{"Content-Type": "application/json"},'body':{'hyperparameters':hyperparameters}}
