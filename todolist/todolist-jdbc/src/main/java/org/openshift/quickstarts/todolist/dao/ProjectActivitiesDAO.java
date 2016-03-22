package org.openshift.quickstarts.todolist.dao;

import org.openshift.quickstarts.todolist.model.ProjectActivities;

import java.util.List;

/**
 *  This interface contains project CRUD operations and it will be implemented by JdbcProjectActivitiesDAO class 
 *  Programming to Interfaces
 */  
public interface ProjectActivitiesDAO {

    void addProjectActivity(ProjectActivities entry);
    void deleteProjectActivity(int project_activityId);
    void updateProjectActivity(ProjectActivities entry);
    
    List<ProjectActivities> getAllProjectsActivity();
  ProjectActivities getProjectActivityById(int project_activityId);
}
    