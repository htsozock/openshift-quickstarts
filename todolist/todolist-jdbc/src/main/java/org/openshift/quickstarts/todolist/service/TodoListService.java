package org.openshift.quickstarts.todolist.service;

import org.openshift.quickstarts.todolist.dao.JdbcTodoListDAO;
import org.openshift.quickstarts.todolist.dao.TodoListDAO;
import org.openshift.quickstarts.todolist.model.TodoEntry;

import java.util.List;

/**
 * The service will call JdbcTodoListDAO class methods and this class  implements  TodoListDAO interface - 
 *
 */
public class TodoListService {

    private TodoListDAO dao = new JdbcTodoListDAO(); //Using polymorphism 

    public void addEntry(TodoEntry entry) {
        dao.addProject(entry); ///call JdbcTodoListDAO() methods
    }

    public List<TodoEntry> getAllEntries() {  
        return dao.getAllProjects();
    }
    
     public void delete(int projectId) {
        dao.deleteProject(projectId);
    } 
 
     public void update(TodoEntry entry) {
        dao.updateProject(entry); 
    }
        
    public TodoEntry get(int projectId) {    // will return ONLY one project
           return dao.getProjectById(projectId);
       }
    
    public TodoEntry getdetails(int projectId) {    // will return ONLY one project awith all the activities
        return dao.getProjectDeailsById(projectId);
    }
 
    

    
}


