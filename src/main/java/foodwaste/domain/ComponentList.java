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
public class ComponentList implements Serializable {
    
    private int compid;
    private String cftc;
    private int compgroupid;
    private String compsubgroup;

    public ComponentList() {
    }

    public int getCompid() {
        return compid;
    }

    public void setCompid(int compid) {
        this.compid = compid;
    }

    public String getCftc() {
        return cftc;
    }

    public void setCftc(String cftc) {
        this.cftc = cftc;
    }

    public int getCompgroupid() {
        return compgroupid;
    }

    public void setCompgroupid(int compgroupid) {
        this.compgroupid = compgroupid;
    }

    public String getCompsubgroup() {
        return compsubgroup;
    }

    public void setCompsubgroup(String compsubgroup) {
        this.compsubgroup = compsubgroup;
    }
    
    
}
