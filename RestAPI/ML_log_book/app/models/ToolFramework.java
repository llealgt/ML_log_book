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
public class ToolFramework {
    public static String TABLE = ToolFramework.class.getSimpleName();
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int PKToolFramework;
    @ManyToOne
    @JoinColumn(name="FkTool")
    private Tool tool;
    private String name;
    
    public ToolFramework(){}

    public static String getTABLE() {
        return TABLE;
    }

    public static void setTABLE(String TABLE) {
        ToolFramework.TABLE = TABLE;
    }

    public int getPKToolFramework() {
        return PKToolFramework;
    }

    public void setPKToolFramework(int PKTookFramework) {
        this.PKToolFramework = PKTookFramework;
    }

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinColumn(name ="FKTool" ,nullable = false)
    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
