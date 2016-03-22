package org.openshift.quickstarts.todolist.servlet;

import org.openshift.quickstarts.todolist.model.ProjectActivitiesIndicators;
import org.openshift.quickstarts.todolist.service.ProjectActivitiesIndicatorsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;

import java.util.Date; 


import org.openshift.quickstarts.todolist.dao.JdbcProjectActivitiesIndicatorsDAO;
import org.openshift.quickstarts.todolist.dao.ProjectActivitiesIndicatorsDAO;



/** 
  * The MainServletActivities is the controller
  * 
  * The servlet uses the service and the model(ProjectActivities
 */ 

public class MainServletIndicators extends HttpServlet {

	    private static final long serialVersionUID = 1L;
	    private static String INSERT_OR_EDIT = "/projectActivities.jsp";
	    private static String LIST_PROJECT = "/listProjectActivities.jsp";
	 
	    private ProjectActivitiesIndicatorsService dao = new ProjectActivitiesIndicatorsServicee();

	    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	
    	ProjectActivitiesIndicators entry = new ProjectActivitiesIndicators();
    	
    	entry.setActivity_name(req.getParameter("activity_name"));
    	entry.setIndicator_name(req.getParameter("indicator_name"));
     	entry.setIndicator_category(req.getParameter(" indicator_category"));
     	entry.setName(req.getParameter("name"));
     	entry.setIndicator_type(req.getParameter("indicator_type"));
     	
    	entry.setActive(req.getParameter("active"));
     	entry.setData_type(req.getParameter("data_type"));
     	
       
        String id = req.getParameter("id");
        entry.setId(Integer.parseInt(id));
        
        String id_activity = req.getParameter("id_activity");
        entry.setId_activity (Integer.parseInt(Id_activity ));
       
           
         
         String  id_indicator = req.getParameter("id_indicator");
         
        if(id_indicator== null || id_indicator.isEmpty())
        {
            dao.addEntry(entry);
        }
        else
        {
            entry.setId_indicator(Integer.parseInt(id_indicator));
            dao.update(entry);
        }
        RequestDispatcher view = req.getRequestDispatcher(LIST_PROJECT);
        req.setAttribute("list", dao.getAllEntries());
        view.forward(req, resp);
    }
   
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	 String forward="";
         String action = req.getParameter("action");
         
         if (action.equalsIgnoreCase("delete")){
             int projectId = Integer.parseInt(req.getParameter("projectId"));
             dao.delete(projectId);
             forward = LIST_PROJECT;
             req.setAttribute("list", dao.getAllEntries());  
         } else if (action.equalsIgnoreCase("edit")){
             forward = INSERT_OR_EDIT;
             int projectId = Integer.parseInt(req.getParameter("projectId"));
             ProjectActivities entry = dao.get(projectId);
             req.setAttribute("entry", entry);
         } else if (action.equalsIgnoreCase("listProjectActivities")){
             forward = LIST_PROJECT;
             req.setAttribute("list", dao.getAllEntries());  
         } else {
             forward = INSERT_OR_EDIT;
         }
         
         RequestDispatcher view = req.getRequestDispatcher(forward);
         view.forward(req, resp);
     }

         
 
        
}
