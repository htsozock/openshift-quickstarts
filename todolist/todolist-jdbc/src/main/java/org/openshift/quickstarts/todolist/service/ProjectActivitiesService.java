package org.openshift.quickstarts.todolist.service;

import org.openshift.quickstarts.todolist.dao.JdbcProjectActivitiesDAO;
import org.openshift.quickstarts.todolist.dao.ProjectActivitiesDAO;
import org.openshift.quickstarts.todolist.model.ProjectActivities;

import java.util.List;

/**
 * The service will call JJdbcProjectActivitiesDAO; class methods and this class  implements ProjectActivitiesDAO;DAO interface - 
 *
 */
public class ProjectActivitiesService{

    private ProjectActivitiesDAO dao = new JdbcProjectActivitiesDAO(); //Using polymorphism 

    public void addEntry(ProjectActivities entry) {
        dao.addProjectActivity(entry); ///call JdbcTodoListDAO() methods
    }

    public List<ProjectActivities> getAllEntries() {  
        return dao.getAllProjectsActivity();
    }
    
     public void delete(int projectId) {
        dao.deleteProjectActivity(projectId);
    } 
 
     public void update(ProjectActivities entry) {
        dao.updateProjectActivity(entry); 
    }
        
    public ProjectActivities get(int projectId) {    // will return ONLY one project
           return dao.getProjectActivityById(projectId);
       }
    
   
    
    

    
}


