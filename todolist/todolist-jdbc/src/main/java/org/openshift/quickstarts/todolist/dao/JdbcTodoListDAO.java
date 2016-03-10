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

/**
 *  TODO: proper exception handling
 *  TODO: initialize schema whenever necessary (what if db is not persistent and is restarted while app is running)
 */
public class JdbcTodoListDAO implements TodoListDAO {

    private final DataSource dataSource;

    public JdbcTodoListDAO() {
        dataSource = lookupDataSource();
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
                         statement.executeUpdate(" CREATE TABLE project (id bigint, name VARCHAR(50), startdt DATE, enddt DATE, organization "
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

    @Override
    public void save(TodoEntry entry) {
        try {
            Connection connection = getConnection();
            try {
                connection.setAutoCommit(true);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO project (id, name,startdt, enddt ,organization,manager, status,description ) "
				   		+ "VALUES (?, ?, ?,?, ?, ?,?, ?)");
				  try {
                    statement.setLong(1, getNextId);
                    statement.setString(2, entry.getName());
                    statement.setDate(3, entry.getStartdt());
                    statement.setDate(4, entry.getEnddt());
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

   
    private long getNextId() {
      return new Random().nextLong();
    // nEED use sequence  LATER -SELECT PROJECT_SEQUENCE.NEXTVAL FROM DUAL
      
    }

    @Override
    public List<TodoEntry> list() {
        try {
            Connection connection = getConnection();
            try {
                Statement statement = connection.createStatement();
                List<TodoEntry> list;
                try {
                    ResultSet rset = statement.executeQuery(" SELECT  id, name,startdt, enddt ,organization,manager, status FROM project ");
                    try {
                        list = new ArrayList<TodoEntry>();
                        while (rset.next()) {
                            String id = rset.getString(1);
                            String  name = rset.getString(2);
                            Date    startdt = rset.getDate(3);
                            Date    enddt = rset.getDate(4);
                            String  organization = rset.getString(5);
                            String  manager= rset.getString(6);
                            String status = rset.getString(7);
                            list.add(new TodoEntry(id, name,startdt, enddt ,organization,manager, status));
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
