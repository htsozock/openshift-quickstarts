
package org.openshift.quickstarts.todolist.model;

import java.util.Date;


/**Hide data access behind an API 

* contains the POJO (Plain Old Java Object). Each class in this package represents the database table.

* project_activitiesindicators table

*/

public class ProjectActivitiesIndicators {


private int id_activity ;
private int id ;
private int id_indicator;

private String name;
private String activity_name;
private String indicator_name;
private String indicator_category;
private String indicator_type;
private String active;

private Date  period;
private int value_ind;


// overloaded constructors --- 

 public ProjectActivitiesIndicators() {

}

 public ProjectActivitiesIndicators(int id_activity, int id ,int id_indicator,String name, String activity_name, String indicator_name, String indicator_type, 
	String indicator_category,  String active, Date period, int value_ind)
 {
  this.id_activity= id_activity;
  this.id=id;
  this.id=id_indicator;
  this.name = name;
  this.activity_name = activity_name;
  this.indicator_name = indicator_name;
  this.indicator_category = indicator_category;
  this.indicator_type = indicator_type;
  this.active = active;
  this.period = period;
  this.value_ind = value_ind;

}


 // SETTERS AND GETTERS -- 

 public String getIndicator_type() {
	 return indicator_type;
	}
 public void setIndicator_type(String indicator_type) {
	 this.indicator_type = indicator_type;
	}
  public String getIndicator_category() {
	 return indicator_name;
	}
		 public void setIndicator_category(String indicator_category) {
		 this.indicator_category = indicator_category;
		}
 
 public String getActive() {
 return active;
 }
 public void setActive(String active) {
 this.active = active;
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
	

public int getValue_ind() {
 return value_ind;
}

public void setValue_ind(int value_ind) {
 this.value_ind = value_ind;
}

public Date getPeriod() {
return  period;
}


 public Date setPeriod(Date period) {
 this.period = period;
 
}

 @Override 

 public String toString() { 

	 return "ProjectActivitiesIndicators{" + 
			

	 "id='"  + id +  '\'' + 
	 
	 ",  id_activity='" + id_activity +  '\'' + 
	 
	 ",  id_indicator='" + id_indicator  + '\'' + 
	 
	 ",  indicator_name='" + indicator_name +  '\'' + 
	  
	 ",  indicator_category ='" + indicator_category  + '\'' + 
	   
	 ", indicator_type ='" + indicator_type  + '\'' + 
	   
	  ",  active ='" + active  + '\'' + 
	   
	  ",  name='" + name  + '\'' + 

	 ",  value_ind='" +  value_ind  + '\'' + 

	 ",  activity_name='" + activity_name  + '\'' + 
	 
	 ",  period='" + period  + '\'' + 

	 '}'; 


	}




	}
	 