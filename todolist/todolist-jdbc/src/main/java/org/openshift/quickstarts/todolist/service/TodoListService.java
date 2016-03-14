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
        dao.save(entry); ///call JdbcTodoListDAO() methods
    }

    public void deleteProject(TodoEntry entry) {
        dao.delete(entry.getId); ///call JdbcTodoListDAO() methods
    } 
     
    //public void updateProject(TodoEntry entry) {
      //  dao.update(entry); ///call JdbcTodoListDAO() methods
    //} 
    public List<TodoEntry> getAllEntries() {  // will return ALL the projects
        return dao.list();
    }
    
  //  public List<TodoEntry> getProject() {    // will return ONLY one project
     //   return dao.read();
   // }
    
   // public List<TodoEntry> getSearchProject() {    // will return one or many  projecs
     //   return dao.search();
    //}
}


