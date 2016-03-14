package org.openshift.quickstarts.todolist.dao;

import org.openshift.quickstarts.todolist.model.TodoEntry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Date;

/**
 *  TODO: proper exception handling
 *  TODO: initialize schema whenever necessary (what if db is not persistent and is restarted while app is running)
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
// create project table if it does not exist
    
   private void initializeSchemaIfNeeded() {
        try {
            Connection connection = getConnection();
            try {
                if (!isSchemaInitialized(connection)) {
                    connection.setAutoCommit(true);
                    Statement statement = connection.createStatement();
                    try {
                         statement.executeUpdate(" CREATE TABLE project (id VARCHAR(10), name VARCHAR(50), startdt VARCHAR(50), enddt VARCHAR(50), organization "
                        		+ "VARCHAR(50), manager VARCHAR(50), status VARCHAR(25), description  TEXT,	PRIMARY KEY(id))");
                       
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

  //// Implement the "save" interface method -- Create a new project
    
    @Override
    public void save(TodoEntry entry) {
        try {
            Connection connection = getConnection();
            try {
                connection.setAutoCommit(true);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO project (id, name,startdt, enddt ,organization,manager, status,description ) "
				   		+ "VALUES (?, ?, ?,?, ?, ?,?, ?)");
				  try {
                    statement.setString(1, entry.getId());
                    statement.setString(2, entry.getName());
                    statement.setString(3, entry.getStartdt());
                    statement.setString(4, entry.getEnddt());
                    statement.setString(5, entry.getOrganization());
                    statement.setString(6, entry.getManager());
                    statement.setString(7, entry.getStatus());
                    statement.setString(8, entry.getDescription());
                    statement.executeUpdate();
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

    //// Implement the "delete" interface method -- delete an existing project
    
    @Override
    public void delete(String project_id) {
        try {
            Connection connection = getConnection();
            try {
                connection.setAutoCommit(true);
                PreparedStatement statement = connection.prepareStatement("DELETE FROM project WHERE id =?");
			   try {
                     statement.setString(1, project_id);
                   //  statement.setString(1, entry.getId());
                     statement.executeUpdate();
                    // System.out.println("Project  "  + entry.getName() +  " is deleted!");
               
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
////Implement the "update" interface method -- update record for  an existing project
    
   /* @Override
    public void update(TodoEntry entry) {
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
                   statement.setString(6, entry.getEnddt());
                   statement.setString(7, entry.getStartdt());
                   statement.setString(8, entry.getId());
          
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
    
    
    
////Implement the "read" interface method -- search for a only one  existing project
    
    @Override
    public List<TodoEntry> read() {
    	try {
            Connection connection = getConnection();
            try {
                Statement statement = connection.createStatement();
                List<TodoEntry> list;
                try {
                    ResultSet rset = statement.executeQuery(" SELECT  id, name,startdt, enddt ,organization,manager, status, description  FROM project WHERE id =? ");
                    try {
                    	 statement.setString(1, entry.getId());
                    	 list = new ArrayList<TodoEntry>();
                        while (rset.next()) {
                        	String  id = rset.getString(1);
                            String  name = rset.getString(2);
                            String  startdt = rset.getString(3);
                            String  enddt = rset.getString(4);
                            String  organization = rset.getString(5);
                            String  manager= rset.getString(6);
                            String status = rset.getString(7);
                            String description  = rset.getString(8);
                            list.add(new TodoEntry(id, name,startdt, enddt ,organization,manager, status, description)); ///only one record is processed
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

////Implement the "search" interface method -- search for some   existing projects
    
    @Override
    public List<TodoEntry> search() {
    	try {
            Connection connection = getConnection();
            try {
                Statement statement = connection.createStatement();
                List<TodoEntry> list;
                try {
                    ResultSet rset = statement.executeQuery(" SELECT  id, name,startdt, enddt ,organization,manager, status, description "
                    		+ " FROM project WHERE id =?  OR name=? OR  organization =? OR manager=? OR status=? ");
                    try {
                    	 statement.setString(1, entry.getId());
                    	 statement.setString(2, entry.getName());
                    	 statement.setString(3, entry.getOrganization());
                         statement.setString(4, entry.getManager());
                         statement.setString(5, entry.getStatus());
                    
                    	 list = new ArrayList<TodoEntry>();
                        while (rset.next()) {
                        	String  id = rset.getString(1);
                            String  name = rset.getString(2);
                            String  startdt = rset.getString(3);
                            String  enddt = rset.getString(4);
                            String  organization = rset.getString(5);
                            String  manager= rset.getString(6);
                            String status = rset.getString(7);
                            String description  = rset.getString(8);
                            list.add(new TodoEntry(id, name,startdt, enddt ,organization,manager, status, description)); ///may return one or many projects
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
*/
    
   ///    Implement the "List"  interface method - --return  all the existing projects 

    @Override
    public List<TodoEntry> list() {
        try {
            Connection connection = getConnection();
            try {
                Statement statement = connection.createStatement();
                List<TodoEntry> list;
                try {
                    ResultSet rset = statement.executeQuery(" SELECT  id, name,startdt, enddt ,organization,manager, status, description  FROM project ");
                    try {
                        list = new ArrayList<TodoEntry>();
                        while (rset.next()) {
                        	String  id = rset.getString(1);
                            String  name = rset.getString(2);
                            String  startdt = rset.getString(3);
                            String  enddt = rset.getString(4);
                            String  organization = rset.getString(5);
                            String  manager= rset.getString(6);
                            String status = rset.getString(7);
                            String description  = rset.getString(8);
                            list.add(new TodoEntry(id, name,startdt, enddt ,organization,manager, status, description));
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
