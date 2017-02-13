package models;

import javax.persistence.*;
import play.data.validation.Constraints;
import play.data.format.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Entity
public class Project {
	public static String TABLE = "Project";
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer PKProject;

    @Constraints.Required
    public String Name;
    
    public Project(){}
    public Project(int id,String title){
    	this.PKProject = id;
    	this.Name = title;
    }
   
}
