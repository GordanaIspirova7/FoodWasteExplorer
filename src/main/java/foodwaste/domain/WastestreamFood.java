/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.domain;

/**
 *
 * @author gorda
 */
public class WastestreamFood implements java.io.Serializable {
    
     private int wsid;
     private String wastestream;
     private String wsdesc;
     private String foodex2;
     private Double edible;
     private Double specgravity;
     private Double ncf;
     private Double gcf;
     private String remark;
     private int foodid;

    public WastestreamFood(int wsid, String wastestream, String wsdesc, String foodex2, Double edible, Double specgravity, Double ncf, Double gcf, String remark, int foodid) {
        this.wsid = wsid;
        this.wastestream = wastestream;
        this.wsdesc = wsdesc;
        this.foodex2 = foodex2;
        this.edible = edible;
        this.specgravity = specgravity;
        this.ncf = ncf;
        this.gcf = gcf;
        this.remark = remark;
        this.foodid = foodid;
    }

    public WastestreamFood() {
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

    public String getWsdesc() {
        return wsdesc;
    }

    public void setWsdesc(String wsdesc) {
        this.wsdesc = wsdesc;
    }

    public String getFoodex2() {
        return foodex2;
    }

    public void setFoodex2(String foodex2) {
        this.foodex2 = foodex2;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }
     
     
     
}