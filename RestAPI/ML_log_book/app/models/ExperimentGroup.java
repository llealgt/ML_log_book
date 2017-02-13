package models;

import javax.persistence.*;
import play.data.validation.Constraints;
import play.data.format.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Entity
public class ExperimentGroup {

    public static String TABLE = ExperimentGroup.class.getSimpleName();
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer PKExperimentGroup;

    public String Description;
    
    public ExperimentGroup(){}
    public ExperimentGroup(int id,String title){
    	this.PKExperimentGroup = id;
    	this.Description = title;
    }
   
}
