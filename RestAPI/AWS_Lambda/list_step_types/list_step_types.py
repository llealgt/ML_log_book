#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Tue Apr 18 21:58:46 2017
Lambda function that list all step types in database
returns the list of step types
@author: luis
"""
import pymysql.cursors


def list_step_types(event,context):
    #TODO: 
    ## - Add error handling and return statusCode in function of that. 
    ## - Test and implement if a single shared DB connection end point can be used between lambdas  
    ## - Change query by stored procedure call
    connection = pymysql.connect(host='#',
                             user='#',
                             password='#',
                             db='ML_log_book',
                             charset='utf8mb4',
                             cursorclass=pymysql.cursors.DictCursor)
    step_types = list()
    try:
        with connection.cursor(pymysql.cursors.DictCursor) as cursor:
            sql = "select PKExperimentType,Name from ExperimentStepType"
            cursor.execute(sql)
            step_types = cursor.fetchall()
 
    finally:
        connection.close()
    
          
    return {"statusCode": 200,"headers":{"Content-Type": "application/json"},'body':{'step_types':step_types}}

#event = {"body":{"email":"wichofer89@gmail.com","password":"waitlines"},"headers":"testing","params":{"querystring":{"phone":"1"}}}

#print(verify_valid_credentials(event,event))

