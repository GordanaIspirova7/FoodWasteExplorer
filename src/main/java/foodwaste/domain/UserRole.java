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
public class UserRole implements java.io.Serializable {
    private int userid;
    private String email;
    private int roleid;
    private String roledesc;

   public UserRole(int userid, String email, int roleid, String roledesc) {
       this.userid = userid;
       this.email = email;
       this.roleid = roleid;
       this.roledesc = roledesc;
   }

   public UserRole()  {
   }



   public int getUserid() {
       return userid;
   }

   public void setUserid(int userid) {
       this.userid = userid;
   }

   public String getEmail() {
       return email;
   }

   public void setEmail(String email) {
       this.email = email;
   }

   public int getRoleid() {
       return roleid;
   }

   public void setRoleid(int roleid) {
       this.roleid = roleid;
   }

   public String getRoledesc() {
       return roledesc;
   }

   public void setRoledesc(String roledesc) {
       this.roledesc = roledesc;
   }


}