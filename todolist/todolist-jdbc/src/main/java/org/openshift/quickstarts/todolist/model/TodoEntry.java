package org.openshift.quickstarts.todolist.model;

import java.io.Serializable;
import java.util.Date;

/**Hide data access behind an API 
 *
 */
public class TodoEntry {

   
	private String id;
    private String name;
    private String status;
    private String startdt; 
    private String enddt;
    private String organization;
    private String manager;
    private String description;
      
    // overloaded constructors --- 
    
    public TodoEntry() {
    }

    public TodoEntry( String name,String startdt, String enddt,  String organization, String manager,  String status, String description) {
       this(null, name,startdt, enddt ,organization,manager, status, description);
    }

    public TodoEntry(String id, String name, String startdt, String enddt, String organization, String manager,  String status, String description) {
        this.id= id;
        this.name = name;
        this.startdt = startdt;
        this.enddt = enddt;
        this.organization = organization;
        this.manager = manager;
        this.status = status;
        this.description = description;
    }

// SETTERS AND GETTERS   -- 
    
     public String getStartdt() {
        return startdt;
     }

     public void setStartdt( String startdt) {
        this.startdt = startdt;
     }
     
     public  String getEnddt() {
         return enddt;
      }

      public void setEnddt( String enddt) {
         this.enddt = enddt;
      }
    
      public String getOrganization() {
          return organization;
      }

      public void setOrganization(String organization) {
          this.organization = organization;
       }
    
       public String getManager() {
           return manager;
       }

        public void setManager(String manager) {
           this.manager = manager;
        }
    
    public String getName() {
        return name;
    }

     public void setName(String name) {
        this.name = name;
     }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
      
    public String getId() {
      return id;
    }
   
    public void setId(String  id) {
      this.id = id;
    }
	
    @Override 
        public String toString() { 
    	return "TodoEntry{" + 

                         "id='" + id + '\'' + 

                       ", name='" + name + '\'' + 

                       ", status='" +  status + '\'' + 

                        ", manager='" + manager + '\'' + 

                        ", organization='" +  organization + '\'' + 

                        ", startdt='" +  startdt + '\'' + 

                         ", enddt='" +  enddt + '\'' + 

                         ", description='" +  description + '\'' + 
                     '}'; 

    }
}
