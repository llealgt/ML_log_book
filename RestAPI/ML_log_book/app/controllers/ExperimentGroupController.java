package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import play.libs.Json;
import play.mvc.*;
import play.db.Database;
import play.db.NamedDatabase;
import play.db.jpa.JPAApi;
import java.util.ArrayList;
import java.util.List;
import models.ExperimentGroup;
import models.Project;
/**
 * Controller to handle request related to promotion actions
 * @author luisf
 *
 */
public class ExperimentGroupController extends Controller{
	
	private final JPAApi jpaApi;

	@javax.inject.Inject
	public ExperimentGroupController(JPAApi jpaApi){
		this.jpaApi = jpaApi;
		
	}
	
        
        /**
         * 
         * @param projectId
         * @return 
         */
        @play.db.jpa.Transactional
        public Result getExperimentGroupsById(int projectId){
            
            if(projectId == -1){
                List<ExperimentGroup> experimentGroups = 
                        (List<ExperimentGroup>)this.jpaApi.em().createQuery("SELECT eg FROM "+ExperimentGroup.TABLE+" eg ORDER BY PKExperimentGroup").getResultList();
                return Controller.ok(Json.toJson(experimentGroups)).as("application/json; charset=utf-8");
            }
            else{
                ExperimentGroup experimentGroup = (ExperimentGroup) jpaApi.em().find(ExperimentGroup.class, projectId);
                return Controller.ok(Json.toJson(experimentGroup)).as("application/json; charset=utf-8");
            }
            
        }
        
        /**
         * 
         * @param projectId
         * @return 
         */
        @play.db.jpa.Transactional
        public Result getExperimentGroupsByProject(int projectId){
            
            List<ExperimentGroup> experimentGroups = 
                    (List<ExperimentGroup>) jpaApi.em().createQuery("SELECT eg FROM "+ExperimentGroup.TABLE+" eg WHERE FKProject = "+projectId).getResultList();            
            return Controller.ok(Json.toJson(experimentGroups)).as("application/json; charset=utf-8");
        }
	
 
}
