package org.openshift.quickstarts.todolist.dao;

import org.openshift.quickstarts.todolist.model.TodoEntry;

import java.util.List;

/**
 *  This interface will be implemented by JdbcTodoListDAO class 
 *  Programming to Interfaces
 */  
public interface TodoListDAO {

    void save(TodoEntry entry);
    List<TodoEntry> list(); // will return all the projects
    void delete((TodoEntry entry);
    void update(TodoEntry entry);
    public List<TodoEntry> read() // will return ONLY one project
    public List<TodoEntry> search() // will return one or many  projects based on some criterias 
}
