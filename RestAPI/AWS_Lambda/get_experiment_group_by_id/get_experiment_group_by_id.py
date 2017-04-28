#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Tue Apr 18 21:58:46 2017
Function that list experimeng groups given their id(comma separated list)
@author: luis
"""
import pymysql.cursors


def get_experiment_group_by_id(event,context):
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
    experimeng_group_list = event["params"]["path"]["experiment_group_list"]
    try:
        with connection.cursor(pymysql.cursors.DictCursor) as cursor:
            sql = """SELECT ExperimentGroup.PKExperimentGroup,
					ExperimentGroup.FKAlgorithm,
					Algorithm.Name as Algorithm,
					ExperimentGroup.FKToolFramework,
					ToolFramework.Name as ToolFramework,
					ExperimentGroup.FKProject,
					Project.Name as Project,
					ExperimentGroup.Description,
					ExperimentGroup.ExecutionHost,
					ExperimentGroup.ContentDirectory,
					ExperimentGroup.Comments
					FROM ML_log_book.ExperimentGroup
					LEFT OUTER JOIN Algorithm on FKAlgorithm = PKAlgorithm
					LEFT OUTER JOIN ToolFramework ON FKToolFramework = PKToolFramework
					LEFT OUTER JOIN Project ON FKProject = PKProject
					LEFT OUTER JOIN Tool ON FKTool = PKTool WHERE PKExperimentGroup IN ("""+experimeng_group_list+")"
            cursor.execute(sql)
            experiments = cursor.fetchall()
 
    finally:
        connection.close()
    
          
    return {"statusCode": 200,"headers":{"Content-Type": "application/json"},'body':{'experiment_groups':experiments}}

#event = {"body":{"email":"wichofer89@gmail.com","password":"waitlines"},"headers":"testing","params":{"path":{"experimeng_group_list":"2"}}}

#print(get_experiment_group_by_id(event,event))


