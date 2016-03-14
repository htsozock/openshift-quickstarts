package org.openshift.quickstarts.todolist.dao;

import org.openshift.quickstarts.todolist.model.TodoEntry;

import java.util.List;

/**
 *  This interface will be implemented by JdbcTodoListDAO class 
 *  Programming to Interfaces
 */  
public interface TodoListDAO {

    void save(TodoEntry entry);
    List<TodoEntry> list(); 
}
