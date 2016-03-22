package org.openshift.quickstarts.todolist.dao;

import org.openshift.quickstarts.todolist.model.ProjectActivitiesIndicators;

import java.util.List;

/**
 *  This interface contains project CRUD operations and it will be implemented by JdbcProjectActivitiesIndicatorDAO class 
 *  Programming to Interfaces Approach -----Hilaire
 */  
public interface ProjectActivitiesIndicatorsDAO {

    void addProjectActivityIndicator(ProjectActivitiesIndicators entry);
    void deleteProjectActivityIndicator(int project_activityId);
    void updateProjectActivityIndicator(ProjectActivitiesIndicators entry);
    
    List<ProjectActivitiesIndicators> getAllProjectsActivityIndicator();
    ProjectActivitiesIndicators getProjectActivityIndicatorById(int project_activityId);
}
    