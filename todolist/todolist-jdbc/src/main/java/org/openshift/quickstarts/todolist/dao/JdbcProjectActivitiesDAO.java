package org.openshift.quickstarts.todolist.dao;

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
 * - Proper exception handling
 * - Initialize schema whenever necessary (what if db is not persistent and is restarted while app is running)
 * - Contains the logic for Project_activities object operations (CRUD)
 */

 
public class JdbcProjectActivitiesDAO implements ProjectActivitiesDAO {
 

 private final DataSource dataSource;

 // constructor

public JdbcProjectActivitiesDAO() {

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
      statement.executeUpdate(" CREATE TABLE project_activity (id_activity int(11) NOT NULL AUTO_INCREMENT, id int(11),activity_name VARCHAR(50), "
      		+ "description TEXT DEFAULT NULL, country VARCHAR(50), obligation_amount bigint DEFAULT 0,award_number int DEFAULT 0, PRIMARY KEY(id_activity,id)) ENGINE=InnoDB AUTO_INCREMENT=001 DEFAULT CHARSET=utf8 ");
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

 ResultSet rset = connection.getMetaData().getTables(null, null, "project_activity", null);
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
 public void addProjectActivity(ProjectActivities entry) {

try {
  Connection connection = getConnection();
 try {
 connection.setAutoCommit(true);
 PreparedStatement statement = connection.prepareStatement("INSERT INTO project_activity (activity_name,country, description, awardnumber, obligationamount, id ) "
 + "VALUES ( ?, ?,?, ?, ?,?)");

// Parameters start with 1
 try {
  statement.setString(1, entry.getActivity_name());
  statement.setString(2, entry.getCountry());
  statement.setString(3, entry.getDescription());
  statement.setInt(4, entry.getAwardnumber());
  statement.setInt(5, entry.getObligationamount());
  statement.setInt(6, entry.getId());
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
 public void deleteProjectActivity(int project_activityId) {
 try {
  Connection connection = getConnection();
  try {
   connection.setAutoCommit(true);
   PreparedStatement statement = connection.prepareStatement("DELETE FROM project_activity  WHERE id_activity =?");
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
 public void updateProjectActivity(ProjectActivities entry) {

try {
  Connection connection = getConnection();
  try {
   connection.setAutoCommit(true);
   PreparedStatement statement = connection.prepareStatement("UPDATE project_activity  SET activity_name=?, country=?, awardnumber=?, obligationamount=?, description=? "
    + "WHERE id_activity =? ");
 	try {
     statement.setString(1, entry.getActivity_name());
     statement.setString(2, entry.getCountry());
     statement.setInt(3, entry.getAwardnumber());
     statement.setInt(4, entry.getObligationamount());
     statement.setString(5, entry.getDescription());
     statement.executeUpdate();

     System.out.println("Project activity " + entry.getActivity_name() + " is updated!");
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
 public ProjectActivities getProjectActivityById(int project_activityId) {

  ProjectActivities entry = new ProjectActivities();
   try {
   Connection connection = getConnection();
   PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM project_activity  WHERE id_activity =? ");
   preparedStatement.setInt(1, project_activityId);
   ResultSet rset = preparedStatement.executeQuery();
   if (rset.next()){
    entry.setId_activity(rset.getInt("id_activity"));
    entry.setActivity_name(rset.getString("activity_name"));
    entry.setCountry(rset.getString("country")); 
    entry.setAwardnumber(rset.getInt("awardnumber"));
    entry.setObligationamount(rset.getInt("obligationamount"));
    entry.setDescription(rset.getString("description"));
    entry.setId(rset.getInt("id"));
  }
  } catch (SQLException e) {
  e.printStackTrace();
 }
 return entry;
}

 /// Implement the "getAllProjectsActivity()" interface method - --return all the existing projects 

 



@Override


 public List<ProjectActivities> getAllProjectsActivity() {
 try {
  Connection connection = getConnection();
   try {
    Statement statement = connection.createStatement();
  List<ProjectActivities> list;
  try {
   ResultSet rset = statement.executeQuery(" SELECT * FROM project_activity  ");
  try {
  list = new ArrayList<ProjectActivities>();
  while (rset.next()) {
   ProjectActivities entry = new ProjectActivities();
   entry.setId_activity(rset.getInt("id_activity"));
   entry.setId(rset.getInt("id"));
   entry.setActivity_name(rset.getString("activity_name"));
   entry.setCountry(rset.getString("Country")); 
   entry.setAwardnumber(rset.getInt("awardnumber"));
   entry.setObligationamount(rset.getInt("obligationamount"));
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
 

 
