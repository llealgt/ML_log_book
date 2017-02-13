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
import models.Project;
/**
 * Controller to handle request related to promotion actions
 * @author luisf
 *
 */
public class ProjectController extends Controller{
	
	private final JPAApi jpaApi;

	@javax.inject.Inject
	public ProjectController(JPAApi jpaApi){
		this.jpaApi = jpaApi;
		
	}
	/**
	 * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/new-promotion</code>.
	 */
	public Result newPromotion(){
		return super.ok(views.html.new_promotion.render());
	}
	
	@play.db.jpa.Transactional
	public Result get(int id){
            List<Project> list = new ArrayList<Project>();
            if(id == -1){
                //get all
               return super.ok("test");
            }
            else{
                Project prom =  (Project) jpaApi.em().find(Project.class, id);
                list.add(new Project(3,"3"));
                list.add(new Project(4,"4"));
                list.add(new Project(5,"five"));
                list.add(prom);
            }
        
            return super.ok(Json.toJson(list)).as("application/json; charset=utf-8");
	}
	
	
 
}
