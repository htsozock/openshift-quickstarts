package org.openshift.quickstarts.todolist.service;

import org.openshift.quickstarts.todolist.dao.JdbcProjectActivitiesIndicatorsDAO;
import org.openshift.quickstarts.todolist.dao.ProjectActivitiesIndicatorsDAO;
import org.openshift.quickstarts.todolist.model.ProjectActivitiesIndicators;

import java.util.List;

/**
 * The service will call JJdbcProjectActivitiesDAO; class methods and this class  implements ProjectActivitiesIndicatorsDAO;DAO interface - 
 *
 */
public class ProjectActivitiesIndicatorService{

    private ProjectActivitiesIndicatorsDAO dao = new JdbcProjectActivitiesIndicatorsDAO(); //Using polymorphism 

    public void addEntry(ProjectActivitiesIndicators entry) {
        dao.addProjectActivityIndicator(entry); ///call JdbcTodoListDAO() methods
    }

    public List<ProjectActivitiesIndicators> getAllEntries() {  
        return dao.getAllProjectsActivity();
    }
    
     public void delete(int projectId) {
        dao.deleteProjectActivityIndicator(projectId);
    } 
 
     public void update(ProjectActivitiesIndicators entry) {
        dao.updateProjectActivityIndicator(entry); 
    }
        
    public ProjectActivitiesIndicators get(int projectId) {    // will return ONLY one project
           return dao.getProjectActivityIndicatorById(projectId);
       }
    
   
    
    

    
}


