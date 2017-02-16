/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import javax.persistence.*;
import play.data.validation.Constraints;
/**
 *
 * @author luisf
 */
@Entity
public class Algorithm {
    public static String TABLE = Algorithm.class.getSimpleName();
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int PKAlgorithm;
    
    private String name;
    public Algorithm(){}

    public static String getTABLE() {
        return TABLE;
    }

    public static void setTABLE(String TABLE) {
        Algorithm.TABLE = TABLE;
    }

    public int getPKAlgorithm() {
        return PKAlgorithm;
    }

    public void setPKAlgorithm(int PKAlgorithm) {
        this.PKAlgorithm = PKAlgorithm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
