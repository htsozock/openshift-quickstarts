
package org.openshift.quickstarts.todolist.model;

import java.util.Date;


/**Hide data access behind an API 

* contains the POJO (Plain Old Java Object). Each class in this package represents the database table.

* project_activities table

*/

public class ProjectActivities {


private int id_activity ;
private int id ;
private String activity_name;
/*private int obligationamount;
private int awardnumber;*/
private String country;
private String description;

// overloaded constructors --- 

 public ProjectActivities() {

}

 public ProjectActivities(int id_activity, int id , String activity_name, String description, String country) 
 {
  this.id_activity= id_activity;
  this.id=id;
  this.activity_name = activity_name;
  this.description = description;
  this.country = country;
/*  this.awardnumber =awardnumber;
  this.obligationamount = obligationamount;
*/
}


 // SETTERS AND GETTERS -- 


 public String getDescription() {
 return description;
 }
 public void setDescription(String description) {
 this.description = description;
 }

 public String getActivity_name() {
 return activity_name;
}
public void setActivity_name(String activity_name) {
 this.activity_name = activity_name;
}
public String getCountry() {
 return country;
}
public void setCountry(String country) {
 this.country = country;
}
public int getId() {
 return id;
}
public void setId(int id) {
 this.id = id;
}

public int getId_activity() {
 return id_activity;
}
public void setId_activity(int id_activity) {
 this.id_activity = id_activity;
}

/*public int getAwardnumber() {
 return awardnumber;
}

public void setAwardnumber(int awardnumber) {
 this.awardnumber = awardnumber;
}

public int getObligationamount() {
return  obligationamount;
}

 public void setObligation_amount(int obligationamount) {
 this.obligationamount = obligationamount;
}*/

 @Override 

 public String toString() { 

 return "ProjectActivities{" + 


 "id='" + id + '\'' + 
 
 "id_activity='" + id_activity + '\'' + 

 ", country='" +country + '\'' + 


 ", activity_name='" + activity_name + '\'' + 

 
 ", description='" + description + '\'' + 

 '}'; 


}







}
 