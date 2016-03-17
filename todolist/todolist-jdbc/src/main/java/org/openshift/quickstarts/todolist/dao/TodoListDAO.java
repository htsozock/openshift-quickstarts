package org.openshift.quickstarts.todolist.dao;

import org.openshift.quickstarts.todolist.model.TodoEntry;

import java.util.List;

/**
 *  This interface contains project CRUD operations and it will be implemented by JdbcTodoListDAO class 
 *  Programming to Interfaces
 */  
public interface TodoListDAO {

    void addProject(TodoEntry entry);
   void deleteProject(int projectId);
    void updateProject(TodoEntry entry);
    
    List<TodoEntry> getAllProjects();
    TodoEntry getProjectById(int projectId);
}
