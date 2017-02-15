package models;

import javax.persistence.*;
import play.data.validation.Constraints;
import play.data.format.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Project", catalog = "ML_log_book")
public class Project {
    public static String TABLE = Project.class.getSimpleName();
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer PKProject;
    private String name;
    private String contentDirectory;
    private String description;

    public Project(){}

    public static String getTABLE() {
        return TABLE;
    }

    public static void setTABLE(String TABLE) {
        Project.TABLE = TABLE;
    }

    public Integer getPKProject() {
        return PKProject;
    }

    public void setPKProject(Integer PKProject) {
        this.PKProject = PKProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentDirectory() {
        return contentDirectory;
    }

    public void setContentDirectory(String contentDirectory) {
        this.contentDirectory = contentDirectory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
