package models;

import javax.persistence.*;
import play.data.validation.Constraints;
import play.data.format.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class ExperimentGroup {

    public static String TABLE = ExperimentGroup.class.getSimpleName();
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer PKExperimentGroup;
    @ManyToOne
    @JoinColumn(name="FKProject")
    private Project project;
    @ManyToOne
    @JoinColumn(name = "FKAlgorithm")
    private Algorithm algorithm;
    @ManyToOne
    @JoinColumn(name = "FKToolFramework")
    private ToolFramework toolFramework;
    private String description;
    private String executionHost;
    private String contentDirectory;
    private String comments;
    private Date endTime;
    private Date estartTime;
    
    public ExperimentGroup(){}
//    public ExperimentGroup(int id,String title){
//    	this.PKExperimentGroup = id;
//    	this.Description = title;
//    }

    public static String getTABLE() {
        return TABLE;
    }

    public static void setTABLE(String TABLE) {
        ExperimentGroup.TABLE = TABLE;
    }

    public Integer getPKExperimentGroup() {
        return PKExperimentGroup;
    }

    public void setPKExperimentGroup(Integer PKExperimentGroup) {
        this.PKExperimentGroup = PKExperimentGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public String getExecutionHost() {
        return executionHost;
    }

    public void setExecutionHost(String ExecutionHost) {
        this.executionHost = ExecutionHost;
    }

    public String getContentDirectory() {
        return contentDirectory;
    }

    public void setContentDirectory(String ContentDirectory) {
        this.contentDirectory = ContentDirectory;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEstartTime() {
        return estartTime;
    }

    public void setEstartTime(Date estartTime) {
        this.estartTime = estartTime;
    }

    @ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
    @JoinColumn(name = "FKProject", nullable = false )
    public Project getProject() {
            return this.project;

    }

    public void setProject(Project FkProject) {
        this.project = FkProject;
    }

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinColumn(name = "FKAlgorithm",nullable = false)
    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinColumn(name = "FKToolFramework",nullable = false)
    public ToolFramework getToolFramework() {
        return toolFramework;
    }

    public void setToolFramework(ToolFramework toolFramework) {
        this.toolFramework = toolFramework;
    }
   
    
    
}
