
package org.openshift.quickstarts.todolist.model;

import java.util.Date;


/**Hide data access behind an API 

* contains the POJO (Plain Old Java Object). Each class in this package represents the database table.

* project_activitiesindicators table
* * 
* Note: No time to write a  good application and in addition openshift environment is not stable

*/

public class ProjectActivitiesIndicators {


private int id_indicator;
private int id_activity ;
private int id ;
private String name;
private String activity_name;
private String indicator_name;
private String indicator_category;
private String value;
private String data_type;
private String period ;

// overloaded constructors --- 

 public ProjectActivitiesIndicators() {

}

 public ProjectActivitiesIndicators(int id_activity, int id ,int id_indicator,String name, String activity_name, String indicator_name, String indicator_category, 
	String value, String period,String data_type)
 {
  this.id_activity= id_activity;
  this.id=id;
  this.id_indicator  =id_indicator;
  this.name = name;
  this.activity_name = activity_name;
  this.indicator_name = indicator_name;
  this.indicator_category = indicator_category;
  this.value = value;
  this.period = period;
  this.data_type= data_type;
}


 // SETTERS AND GETTERS -- 
 
 public String getData_type() {
	 return data_type;
	}
 public void setData_type(String data_type) {
	 this.data_type = data_type;
	}
 
 public String getPeriod() {
	 return period;
	}
 public void setPeriod(String period) {
	 this.period = period;
	}
  public String getIndicator_category() {
	 return indicator_name;
	}
  public void setIndicator_category(String indicator_category) {
	 this.indicator_category = indicator_category;
	}
 
 public String getValue() {
 return value;
 }
 public void setValue(String value) {
 this.value = value;
 }
  
 public String getActivity_name() {
	 return activity_name;
	}
	 public void setActivity_name(String activity_name) {
	 this.activity_name = activity_name;
	}
 public String getIndicator_name() {
 return indicator_name;
}
 public void setIndicator_name(String indicator_name) {
 this.indicator_name = indicator_name;
}

 public String getName() {
 return name;
}
public void setName(String name) {
 this.name = name;
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

public int getId_indicator() {
	 return id_indicator;
	}
	public void setId_indicator(int id_indicator) {
	 this.id_indicator = id_indicator;
	}
	
 
 
 @Override 

 public String toString() { 

	 return "ProjectActivitiesIndicators{" + 
			

	 "id='"  + id +  '\'' + 
	 
	 ",  id_activity='" + id_activity +  '\'' + 
	 
	 ",  id_indicator='" +  id_indicator  + '\'' + 
	 
	 ",  indicator_name='" + indicator_name +  '\'' + 
	  
	 ",  indicator_category ='" + indicator_category  + '\'' + 
	   
	 ", period ='" + period  + '\'' + 
	   
	  ",  value ='" + value  + '\'' + 
	
	  ",  data_type ='" + data_type  + '\'' + 
	   
	  ",  name='" + name  + '\'' + 

	 ",  activity_name='" + activity_name  + '\'' + 
	 
	 '}'; 


	}




	}
	 