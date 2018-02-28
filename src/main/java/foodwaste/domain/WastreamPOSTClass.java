/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.domain;

import java.io.Serializable;

/**
 *
 * @author Tome
 */
public class WastreamPOSTClass implements Serializable {
     private int wsid;
     private String wastestream;
     private Double edible;
     private Double specgravity;
     private Double ncf;
     private Double gcf;
     int foodid;

    public WastreamPOSTClass() {
    }

    public WastreamPOSTClass(int wsid, String wastestream, Double edible, Double specgravity, Double ncf, Double gcf, int foodid) {
        this.wsid = wsid;
        this.wastestream = wastestream;
        this.edible = edible;
        this.specgravity = specgravity;
        this.ncf = ncf;
        this.gcf = gcf;
        this.foodid = foodid;
    }

    public int getWsid() {
        return wsid;
    }

    public void setWsid(int wsid) {
        this.wsid = wsid;
    }

    public String getWastestream() {
        return wastestream;
    }

    public void setWastestream(String wastestream) {
        this.wastestream = wastestream;
    }

    public Double getEdible() {
        return edible;
    }

    public void setEdible(Double edible) {
        this.edible = edible;
    }

    public Double getSpecgravity() {
        return specgravity;
    }

    public void setSpecgravity(Double specgravity) {
        this.specgravity = specgravity;
    }

    public Double getNcf() {
        return ncf;
    }

    public void setNcf(Double ncf) {
        this.ncf = ncf;
    }

    public Double getGcf() {
        return gcf;
    }

    public void setGcf(Double gcf) {
        this.gcf = gcf;
    }

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }
     
     
   
    
}
