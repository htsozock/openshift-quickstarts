package org.openshift.quickstarts.todolist.dao;

import org.openshift.quickstarts.todolist.model.TodoEntry;
import org.openshift.quickstarts.todolist.model.ProjectActivities;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


/**
 *  - Proper exception handling
 *  - Initialize schema whenever necessary (what if db is not persistent and is restarted while app is running)
 *  - Contains the logic for Project object operations (CRUD)
 */
public class JdbcTodoListDAO implements TodoListDAO {

    private final DataSource dataSource;

      // constructor
    public JdbcTodoListDAO() {
        dataSource = lookupDataSource();// retrurn the datasource
        initializeSchemaIfNeeded();
    }
    

    private DataSource lookupDataSource() {    
        try {
            Context initialContext = new InitialContext();
            try {
                return (DataSource) initialContext.lookup(System.getenv("DB_JNDI"));
            } catch (NameNotFoundException e) {
                Context envContext = (Context) initialContext.lookup("java:comp/env");  // Tomcat places datasources inside java:comp/env
                return (DataSource) envContext.lookup(System.getenv("DB_JNDI"));
            }
        } catch (NamingException e) {
            throw new RuntimeException("Could not look up datasource", e);
        }
    }
    
    
   private void initializeSchemaIfNeeded() {
        try {
            Connection connection = getConnection();
            try {
                if (!isSchemaInitialized(connection)) {
                    connection.setAutoCommit(true);
                    Statement statement = connection.createStatement();
                    try {
                         statement.executeUpdate(" CREATE TABLE project (id int(11) NOT NULL AUTO_INCREMENT , name VARCHAR(50), startdt DATE, enddt DATE, organization "
                        		+ "VARCHAR(50), manager VARCHAR(50), status VARCHAR(25), description  TEXT,	PRIMARY KEY(id))ENGINE=InnoDB AUTO_INCREMENT=001 DEFAULT CHARSET=utf8");
                                  
                    } finally {
                        statement.close();
                    }
                }
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isSchemaInitialized(Connection connection) throws SQLException {
        ResultSet rset = connection.getMetaData().getTables(null, null, "project", null);
        try {
            return rset.next();
        } finally {
            rset.close();
        }
    }

    /**
     *  Implement the project object CRUD operations
     *  
     */
    
    
    //// Implement the "addProject" interface method -- Create a new project
    
    @Override
    public void addProject(TodoEntry entry) {
        try {
            Connection connection = getConnection();
            try {
                connection.setAutoCommit(true);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO project (name,startdt, enddt ,organization,manager, status,description ) "
				   		+ "VALUES ( ?, ?,?, ?, ?,?, ?)");
                // Parameters start with 1
				  try {
                    statement.setString(1, entry.getName());
                    statement.setDate(2, new java.sql.Date(entry.getStartdt().getTime()));
                    statement.setDate(3, new java.sql.Date(entry.getEnddt().getTime()));
                    statement.setString(4, entry.getOrganization());
                    statement.setString(5, entry.getManager());
                    statement.setString(6, entry.getStatus());
                    statement.setString(7, entry.getDescription());
                    statement.executeUpdate();
                	System.out.println("Record is Created!");
                  } finally {
                    statement.close();
                }
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
   //// Implement the "deleteProject" interface method -- delete an existing project
    
    @Override
    public void deleteProject(int projectId) {
        try {
            Connection connection = getConnection();
            try {
                connection.setAutoCommit(true);
                PreparedStatement statement = connection.prepareStatement("DELETE FROM project WHERE id =?");
			   try {
                     statement.setInt(1, projectId);
                     statement.executeUpdate();
                 	 System.out.println("Record is deleted!");          
                } finally {
                    statement.close();
                }
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
  
    
////Implement the "updateProject" interface method -- update record for  an existing project
    
    @Override
    public void updateProject(TodoEntry entry) {
        try {
            Connection connection = getConnection();
            try {
               connection.setAutoCommit(true);
               PreparedStatement statement = connection.prepareStatement("UPDATE  project SET name=?, manager=?, organization=?, status=?, description=?, enddt=?,startdt=? "
                		+ "WHERE id =? ");
                	
			   try {
				   
                   statement.setString(1, entry.getName());
                   statement.setString(2, entry.getManager());
                   statement.setString(3, entry.getOrganization());
                   statement.setString(4, entry.getStatus());
                   statement.setString(5, entry.getDescription());
                   statement.setDate(6, new java.sql.Date(entry.getEnddt().getTime()));
                   statement.setDate(7, new java.sql.Date(entry.getStartdt().getTime()));
                   statement.setInt(8, entry.getId());
          
                   statement.executeUpdate();
                   System.out.println("Project  "  + entry.getName() +  " is updated!");
               
                } finally {
                    statement.close();
                }
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
     
    
////Implement the "getProjectById" interface method -- search project by id
    
    @Override
    public ProjectActivities getProjectDetailsById(int projectId) {
    	 /* TodoEntry entry = new TodoEntry();*/
    	  ProjectActivities entry1 = new  ProjectActivities();
         
            try {
               Connection connection = getConnection();
               PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, id_activity,name, activty_name, country, description  FROM project_activity  WHERE id=? ");
               preparedStatement.setInt(1, projectId);
               ResultSet rset = preparedStatement.executeQuery();
               if (rset.next()){
            	   entry1.setId(rset.getInt("id"));
            	   entry1.setId_activity(rset.getInt("id_activity"));
                  // entry.setName(rset.getString("name"));
                   entry1.setActivity_name(rset.getString("activity_name"));
                   entry1.setCountry(rset.getString("country"));
                   entry1.setDescription(rset.getString("description"));
                          }
      } catch (SQLException e) {
        e.printStackTrace();
    }

    return entry1;
}

    public TodoEntry getProjectById(int projectId) {
  	  TodoEntry entry = new TodoEntry();
       
          try {
             Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name,startdt, enddt ,organization,manager, status, description  FROM project WHERE id =? ");
             preparedStatement.setInt(1, projectId);
             ResultSet rset = preparedStatement.executeQuery();
             if (rset.next()){
            	
             	entry.setId(rset.getInt("id"));
                 entry.setName(rset.getString("name"));
                 entry.setStartdt(rset.getDate("startdt"));
                 entry.setEnddt(rset.getDate("enddt"));
              
                 entry.setOrganization(rset.getString("organization")); 
                 entry.setManager(rset.getString("manager"));
                 entry.setStatus(rset.getString("status"));
                 entry.setDescription(rset.getString("description"));
             
             
             }
    } catch (SQLException e) {
      e.printStackTrace();
  }

  return entry;
}
  
   
   ///    Implement the "getAllProjects()"  interface method - --return  all the existing projects 

    @Override
    public List<TodoEntry> getAllProjects() {
        try {
            Connection connection = getConnection();
            try {
                Statement statement = connection.createStatement();
                List<TodoEntry> list;
                try {
                    ResultSet rset = statement.executeQuery(" SELECT  *  FROM project ");
                    try {
                        list = new ArrayList<TodoEntry>();
                        while (rset.next()) {
                        	TodoEntry entry = new TodoEntry();
                        	entry.setId(rset.getInt("id"));
                            entry.setName(rset.getString("name"));
                            entry.setStartdt(rset.getDate("startdt"));
                            entry.setEnddt(rset.getDate("enddt"));
                         
                            entry.setOrganization(rset.getString("organization")); 
                            entry.setManager(rset.getString("manager"));
                            entry.setStatus(rset.getString("status"));
                            entry.setDescription(rset.getString("description"));
                            
                            list.add(entry);
                        }
                    } finally {
                        rset.close();
                    }
                } finally {
                    statement.close();
                }
                return list;
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   
    
    public Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    private DataSource getDataSource() {
        return dataSource;
    }
}
