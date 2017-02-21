/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.persistence.*;
/**
 *
 * @author luisf
 */
@Entity
public class ExperimentStepType {
    public static String TABLE =  ExperimentStepType.class.getSimpleName();
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int PKExperimentType;
    private String name;
    
    public ExperimentStepType(){}

    public static String getTABLE() {
        return TABLE;
    }

    public static void setTABLE(String TABLE) {
        ExperimentStepType.TABLE = TABLE;
    }

    public int getPKExperimentType() {
        return PKExperimentType;
    }

    public void setPKExperimentType(int PKExperimentType) {
        this.PKExperimentType = PKExperimentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
