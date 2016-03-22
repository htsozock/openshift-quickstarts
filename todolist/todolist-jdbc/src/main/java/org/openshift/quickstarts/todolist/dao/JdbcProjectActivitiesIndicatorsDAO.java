package org.openshift.quickstarts.todolist.dao;

import org.openshift.quickstarts.todolist.model.ProjectActivitiesIndicators;
 
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
 * - Proper exception handling
 * - Initialize schema whenever necessary (what if db is not persistent and is restarted while app is running)
 * - Contains the logic for Project_activities object operations (CRUD)
 */

 
public class JdbcProjectActivitiesIndicatorsDAO implements ProjectActivitiesIndicatorsDAO {
 

 private final DataSource dataSource;

 // constructor

public JdbcProjectActivitiesIndicatorsDAO() {

 dataSource = lookupDataSource();// retrurn the datasource

 //initializeSchemaIfNeeded();
}
 private DataSource lookupDataSource() { 
 try {
 Context initialContext = new InitialContext();
 try {
  return (DataSource) initialContext.lookup(System.getenv("DB_JNDI"));
   } catch (NameNotFoundException e) {
     Context envContext = (Context) initialContext.lookup("java:comp/env"); // Tomcat places datasources inside java:comp/env
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
      statement.executeUpdate(" CREATE TABLE project_activity_indicator (id_indicator int (11) not null AUTO_INCREMENT ,"
    		  + "id int(11) not null , id_activity  int(11) not null, name VARCHAR(45), activity_name VARCHAR(45), "
    		  + "indicator_name VARCHAR(45),indicator_category VARCHAR(30), data_type VARCHAR(30),indicator_type  VARCHAR(30),  "
    		  + "active VARCHAR(30), PRIMARY KEY(id_indicator , id, id_activity))  ");
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

 ResultSet rset = connection.getMetaData().getTables(null, null, "project_activity_indicator", null);
 try {
  return rset.next();
   } finally {
    rset.close();
   }
}

 /**
 
* 
* Implement the project_activities object CRUD operations
*
*/
 
 //// Implement the "addProjectActivity" interface method -- Create a new project

@Override
 public void addProjectActivityIndicator(ProjectActivitiesIndicators entry) {

try {
  Connection connection = getConnection();
 try {
 connection.setAutoCommit(true);
 PreparedStatement statement = connection.prepareStatement("INSERT INTO project_activity_indicator (id_activity,activity_name, indicator_name,"
 		+ " indicator_category , name,"
		+ "data_type , indicator_type, id,active ) "
 + "VALUES ( ?, ?,?, ?,?, ?,?, ?,?)");

// Parameters start with 1
 try {
	 statement.setInt(1, entry.getId_activity());
	 statement.setString(2, entry.getActivity_name());
	 statement.setString(3, entry.getIndicator_name());
	 statement.setString(4, entry.getIndicator_category());
	 statement.setString(5, entry.getName());
	 statement.setString(6, entry.getData_type());
	 statement.setString(7, entry.getIndicator_type());
	  statement.setInt(8, entry.getId());
	  statement.setString(9, entry.getActive());
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

 //// Implement the "deleteProjectActivity" interface method -- delete an existing project

 @Override
 public void deleteProjectActivityIndicator(int project_activityId) {
 try {
  Connection connection = getConnection();
  try {
   connection.setAutoCommit(true);
   PreparedStatement statement = connection.prepareStatement("DELETE FROM project_activity_indicator  WHERE id_indicator =?");
   try {
   statement.setInt(1, project_activityId);
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

 
 

////Implement the "updateProjectActivity" interface method -- update record for an existing project

@Override
 public void updateProjectActivityIndicator(ProjectActivitiesIndicators entry) {

try {
  Connection connection = getConnection();
  try {
   connection.setAutoCommit(true);
   PreparedStatement statement = connection.prepareStatement("UPDATE project_activity_indicator SET activity_name=?, "
   		+ "indicator_name=?, active=? , name=?, "
   		+ "indicator_category=?, indicator_type =?"
    + "WHERE id_indicator =? ");
 	try {
     statement.setString(1, entry.getActivity_name());
     statement.setString(2, entry.getIndicator_name());
     statement.setString(3, entry.getActive());
     statement.setString(4, entry.getName());
     statement.setString(5, entry.getIndicator_category());
     statement.setString(6, entry.getIndicator_type());
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

////Implement the "getProjectActivityById" interface method -- search project by id



 @Override
 public ProjectActivitiesIndicators getProjectActivityIndicatorById(int project_activityId) {

	 ProjectActivitiesIndicators entry = new ProjectActivitiesIndicators();
   try {
   Connection connection = getConnection();
   PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, id_activity,id_indicator, name, activity_name,indicator_name, active FROM project_activity_indicator  WHERE id_indicator =? ");
   
   preparedStatement.setInt(1, project_activityId);
   ResultSet rset = preparedStatement.executeQuery();
   if (rset.next()){
	   entry.setId(rset.getInt("id"));
	   entry.setId_activity(rset.getInt("id_activity"));
	   entry.setId_indicator(rset.getInt("id_indicator"));
	   entry.setName(rset.getString("name"));
	   entry.setActivity_name(rset.getString("activity_name"));
       entry.setIndicator_name(rset.getString("indicator_name")); 
       entry.setActive(rset.getString("active"));
       statement.executeUpdate();
  
  }
  } catch (SQLException e) {
  e.printStackTrace();
 }
 return entry;
}

 /// Implement the "getAllProjectsActivityIndicators()" interface method - --return all the existing projects 

@Override
 public List<ProjectActivitiesIndicators> getAllProjectsActivityIndicator() {
 try {
  Connection connection = getConnection();
   try {
    Statement statement = connection.createStatement();
  List<ProjectActivitiesIndicators> list;
  try {
   ResultSet rset = statement.executeQuery(" SELECT id, id_activity,id_indicator, name, activity_name,indicator_name, active FROM project_activity_indicator  ");
  try {
  list = new ArrayList<ProjectActivitiesIndicators>();
  while (rset.next()) {
	  ProjectActivitiesIndicators entry = new ProjectActivitiesIndicators();
   
	  entry.setId(rset.getInt("id"));
	   entry.setId_activity(rset.getInt("id_activity"));
	    entry.setId_indicator(rset.getInt("id_indicator"));
	   entry.setName(rset.getString("name"));
	   entry.setActivity_name(rset.getString("activity_name"));
       entry.setIndicator_name(rset.getString("indicator_name")); 
      entry.setActive(rset.getString("active"));
      
   statement.executeUpdate();
  
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
 

 
