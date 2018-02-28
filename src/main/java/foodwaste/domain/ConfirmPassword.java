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
public class ConfirmPassword {
    
    
     private String confPassword;
     private int userid;  
     private String name;
     private String surname;
     private String email;
     private String password;
     private int insttypeid;
     private int instid;
     private String insttype;
     private String insname;
     private int ccid;
     private String countrycode;
     private int intareaid;
     private String interestarea;
     
     
     
public ConfirmPassword(String name, String surname, String email, String password, String confPassword, int instid, int intareaid) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.instid = instid;
        this.intareaid = intareaid;
        this.confPassword=confPassword;
    }

    public ConfirmPassword() {
    }

    public ConfirmPassword(String name, String surname, String email, String password, String confPassword, String insname, String interestarea) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.confPassword=confPassword;
        this.insname = insname;
        this.interestarea = interestarea;
    }

    public ConfirmPassword(String name, String surname, String email, String password, String confPassword, String insttype, String insname, String countrycode, String interestarea) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.insttype = insttype;
        this.insname = insname;
        this.countrycode = countrycode;
        this.interestarea = interestarea;
        this.confPassword=confPassword;
    }

 

   
    public String getInsttype() {
        return insttype;
    }

    public void setInsttype(String insttype) {
        this.insttype = insttype;
    }

    public String getInterestarea() {
        return interestarea;
    }

    public void setInterestarea(String interestarea) {
        this.interestarea = interestarea;
    }

    

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public String getconfPassword() {
        return confPassword;
    }
    public void setconfPassword(String password) {
        this.confPassword = password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getInsttypeid() {
        return insttypeid;
    }

    public void setInsttypeid(int insttypeid) {
        this.insttypeid = insttypeid;
    }

    public int getInstid() {
        return instid;
    }

    public void setInstid(int instid) {
        this.instid = instid;
    }

    public String getInsname() {
        return insname;
    }

    public void setInsname(String insname) {
        this.insname = insname;
    }

    public int getCcid() {
        return ccid;
    }

    public void setCcid(int ccid) {
        this.ccid = ccid;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public int getIntareaid() {
        return intareaid;
    }

    public void setIntareaid(int intareaid) {
        this.intareaid = intareaid;
    } 
}
