package foodwaste.domain;
// Generated May 1, 2017 2:32:57 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Country generated by hbm2java
 */
public class Country  implements java.io.Serializable {


     private int ccid;
     private String countrycode;
     private Set fcdbs = new HashSet(0);
     private Set institutions = new HashSet(0);
     private String countryName;
    public Country() {
    }

	
    public Country(int ccid, String countrycode) {
        this.ccid = ccid;
        this.countrycode = countrycode;
    }
    public Country(int ccid, String countrycode, Set fcdbs, Set institutions) {
       this.ccid = ccid;
       this.countrycode = countrycode;
       this.fcdbs = fcdbs;
       this.institutions = institutions;
    }
   
    public int getCcid() {
        return this.ccid;
    }
    
    public void setCcid(int ccid) {
        this.ccid = ccid;
    }
    public String getCountrycode() {
        return this.countrycode;
    }
    
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }
    public Set getFcdbs() {
        return this.fcdbs;
    }
    
    public void setFcdbs(Set fcdbs) {
        this.fcdbs = fcdbs;
    }
    public Set getInstitutions() {
        return this.institutions;
    }
    
    public void setInstitutions(Set institutions) {
        this.institutions = institutions;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }




}


