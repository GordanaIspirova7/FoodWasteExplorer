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
public class WsvaluePostAdd implements Serializable{
    private int wsid;
    private String wastestream;
    private int compid;
    private String cftc;
    private int compgroupid;
    private String compgroup;
    private Double value;
    private int unitid;
    private String uftc;
    private String email;
    private String citation;

    public WsvaluePostAdd() {
    }

    public String getWastestream() {
        return wastestream;
    }

    public void setWastestream(String wastestream) {
        this.wastestream = wastestream;
    }

    public int getWsid() {
        return wsid;
    }

    public void setWsid(int wsid) {
        this.wsid = wsid;
    }

    public String getUftc() {
        return uftc;
    }

    public void setUftc(String uftc) {
        this.uftc = uftc;
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

    public String getCompgroup() {
        return compgroup;
    }

    public void setCompgroup(String compgroup) {
        this.compgroup = compgroup;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getUnitid() {
        return unitid;
    }

    public void setUnitid(int unitid) {
        this.unitid = unitid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCitation() {
        return citation;
    }

    public void setCitation(String citation) {
        this.citation = citation;
    }
    
    
    
}
