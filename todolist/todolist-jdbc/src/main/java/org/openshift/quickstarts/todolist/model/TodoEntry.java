package org.openshift.quickstarts.todolist.model;

import java.io.Serializable;

/**
 *
 */
public class TodoEntry {

   // private Serializable project_code;
    private String  project_code;
    private String name;

    private String status;

    public TodoEntry() {
    }

    public TodoEntry(String project_code, String name, String status) {
      // -- this(null, summary, description);
		this(project_code, name, status);
    }

    public TodoEntry(Serializable project_code, String name, String status) {
        this.project_code= project_code;
        this.name = name;
        this.status = satus;
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

   // public Serializable getId() {
     //   return id;
    //}
       public String getProject_name() {
        return project_name;
    }
   // public void setId(Serializable id) {
     //   this.id = id;
    //}
	
	  public void setProject_name(String project_name) {
        this.project_name = project_name;
    }
}
