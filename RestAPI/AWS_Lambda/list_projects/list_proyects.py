#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Tue Apr 18 21:58:46 2017
Lambda function that lists all proyects in DB
@author: luis
"""
import pymysql.cursors


def list_projects(event,context):
    #TODO: 
    ## - Add error handling and return statusCode in function of that. 
    ## - Handle None values(null in DB)
    ## - Test and implement if a single shared DB connection end point can be used between lambdas  
    connection = pymysql.connect(host='#',
                             user='#',
                             password='#',
                             db='ML_log_book',
                             charset='utf8mb4',
                             cursorclass=pymysql.cursors.DictCursor)
    projects = list()
    try:
        with connection.cursor() as cursor:
            sql = "SELECT PKProject,Name,Description,ContentDirectory FROM Project"
            cursor.execute(sql)
            for row in cursor.fetchall():
                projects.append({"PKProject":row['PKProject'], "Name":row['Name'],"Description":row['Description'],"ContentDirectory":row["ContentDirectory"]})
    finally:
        connection.close()
    
          
    return {"statusCode": 200,"headers":{"Content-Type": "application/json"},'body':{"projects":projects}}

#event = {"body":"this is a test","headers":"testing","params":{"querystring":{"phone":"1"}}}

#print(list_projects(event,event))

