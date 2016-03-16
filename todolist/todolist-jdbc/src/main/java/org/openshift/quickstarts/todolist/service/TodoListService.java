package org.openshift.quickstarts.todolist.service;

import org.openshift.quickstarts.todolist.dao.JdbcTodoListDAO;
import org.openshift.quickstarts.todolist.dao.TodoListDAO;
import org.openshift.quickstarts.todolist.model.TodoEntry;

import java.util.List;

/**
 * The service will call JdbcTodoListDAO class methods and this calss  implements  TodoListDAO interface - 
 * Using TodoEntry data class 
 */
public class TodoListService {

    private TodoListDAO dao = new JdbcTodoListDAO(); //Using polymorphism 

    public void addEntry(TodoEntry entry) {
        dao.addProject(entry); ///call JdbcTodoListDAO() methods
    }

    public List<TodoEntry> getAllEntries() {  
        return dao.getAllProjects();
    }
    
   /* public void delete(int projectI) {
        dao.deleteProject(int projectId);
    } 
 
    
    public void update(TodoEntry entry) {
        dao.updateProject(TodoEntry entry); 
    }
    

    
    public TodoEntry getProject(int projectId) {    // will return ONLY one project
           return dao.getProjectById(projectId);
       }
    */
   
    
    

    
}


