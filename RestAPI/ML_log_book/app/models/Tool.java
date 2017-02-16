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
public class Tool {
    
    public static String TABLE = Tool.class.getSimpleName();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int PKTool;
    private String siteURL;
    private String name;
    
    public Tool(){}

    public void setPKTool(int PKTool) {
        this.PKTool = PKTool;
    }

    public void setSiteURL(String siteURL) {
        this.siteURL = siteURL;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String getTABLE() {
        return TABLE;
    }

    public int getPKTool() {
        return PKTool;
    }

    public String getSiteURL() {
        return siteURL;
    }
    
    
}
