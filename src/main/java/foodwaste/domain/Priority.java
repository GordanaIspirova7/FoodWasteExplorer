package foodwaste.domain;
// Generated May 1, 2017 2:32:57 PM by Hibernate Tools 4.3.1



/**
 * Priority generated by hbm2java
 */
public class Priority  implements java.io.Serializable {


     private int priorityid;
     private User user;
     private Wastestream wastestream;
     private int priority;

    public Priority() {
    }

    public Priority(int priorityid, User user, Wastestream wastestream, int priority) {
       this.priorityid = priorityid;
       this.user = user;
       this.wastestream = wastestream;
       this.priority = priority;
    }
   
    public int getPriorityid() {
        return this.priorityid;
    }
    
    public void setPriorityid(int priorityid) {
        this.priorityid = priorityid;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public Wastestream getWastestream() {
        return this.wastestream;
    }
    
    public void setWastestream(Wastestream wastestream) {
        this.wastestream = wastestream;
    }
    public int getPriority() {
        return this.priority;
    }
    
    public void setPriority(int priority) {
        this.priority = priority;
    }




}


