#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Tue Apr 18 21:58:46 2017
Lambda function that lists a given list of projects(PKProject list separated by commas)
@author: luis
"""
import pymysql.cursors


def get_project_by_id(event,context):
    #TODO: 
    ## - Add error handling and return statusCode in function of that. 
    ## - Handle None values(null in DB)
    ## - Test and implement if a single shared DB connection end point can be used between lambdas 
    ## - What to do in case an empty list of ids is sent, or the requested IDs are not in the DB 
    connection = pymysql.connect(host='#',
                             user='#',
                             password='#',
                             db='#',
                             charset='#',
                             cursorclass=pymysql.cursors.DictCursor)
    project_id_list = event["params"]["path"]["project_id_list"]
    projects = list()
    try:
        with connection.cursor(pymysql.cursors.DictCursor) as cursor:
            sql = "SELECT PKProject,Name,Description,ContentDirectory FROM Project WHERE PKProject IN("+project_id_list+")"
            cursor.execute(sql)
            projects = cursor.fetchall()
    finally:
        connection.close()
    
          
    return {"statusCode": 200,"headers":{"Content-Type": "application/json"},'body':{"projects":projects}}

#event = {"body":{"project_id_list":"1"},"headers":"testing","params":{"querystring":{"phone":"1"}}}

#print(get_project_by_id(event,event))


