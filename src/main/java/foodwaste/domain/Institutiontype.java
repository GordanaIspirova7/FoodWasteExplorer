package foodwaste.domain;
// Generated May 1, 2017 2:32:57 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Institutiontype generated by hbm2java
 */
public class Institutiontype  implements java.io.Serializable {


     private int insttypeid;
     private String insttype;
     private Set institutions = new HashSet(0);

    public Institutiontype() {
    }

	
    public Institutiontype(int insttypeid, String insttype) {
        this.insttypeid = insttypeid;
        this.insttype = insttype;
    }
    public Institutiontype(int insttypeid, String insttype, Set institutions) {
       this.insttypeid = insttypeid;
       this.insttype = insttype;
       this.institutions = institutions;
    }
   
    public int getInsttypeid() {
        return this.insttypeid;
    }
    
    public void setInsttypeid(int insttypeid) {
        this.insttypeid = insttypeid;
    }
    public String getInsttype() {
        return this.insttype;
    }
    
    public void setInsttype(String insttype) {
        this.insttype = insttype;
    }
    public Set getInstitutions() {
        return this.institutions;
    }
    
    public void setInstitutions(Set institutions) {
        this.institutions = institutions;
    }




}


