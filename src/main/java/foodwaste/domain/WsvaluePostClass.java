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
public class WsvaluePostClass implements Serializable {
    private int valueid;
    private Double value;
    private int unitid;
    private String ftc;
    private int matrixid;
    private String mftc;
    private String email;
    private String srcode;
    private String citation;
    private String rftc;

    public WsvaluePostClass() {
    }

    public WsvaluePostClass(int valueid, Double value, String ftc, String mftc, String email) {
        this.valueid = valueid;
        this.value = value;
        this.ftc = ftc;
        this.mftc = mftc;
        this.email=email;
    }

    public WsvaluePostClass(int valueid, Double value, String ftc, String mftc, String email, String srcode, String citation, String rftc) {
        this.valueid = valueid;
        this.value = value;
        this.ftc = ftc;
        this.mftc = mftc;
        this.email = email;
        this.srcode = srcode;
        this.citation = citation;
        this.rftc = rftc;
    }

    public String getSrcode() {
        return srcode;
    }

    public void setSrcode(String srcode) {
        this.srcode = srcode;
    }

    public String getCitation() {
        return citation;
    }

    public void setCitation(String citation) {
        this.citation = citation;
    }

    public String getRftc() {
        return rftc;
    }

    public void setRftc(String rftc) {
        this.rftc = rftc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getValueid() {
        return valueid;
    }

    public void setValueid(int valueid) {
        this.valueid = valueid;
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

    public String getFtc() {
        return ftc;
    }

    public void setFtc(String ftc) {
        this.ftc = ftc;
    }

    public int getMatrixid() {
        return matrixid;
    }

    public void setMatrixid(int matrixid) {
        this.matrixid = matrixid;
    }

    public String getMftc() {
        return mftc;
    }

    public void setMftc(String mftc) {
        this.mftc = mftc;
    }
    
}
