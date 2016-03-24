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
	    private static String INSERT_OR_EDIT = "/ProjectActivitiesIndicators.jsp";
	    private static String LIST_PROJECT = "/listProjectIndicators.jsp";
	 
	    private ProjectActivitiesIndicatorsService dao = new ProjectActivitiesIndicatorsService();

	    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	
    	ProjectActivitiesIndicators entry = new ProjectActivitiesIndicators();
    	
    	entry.setActivity_name(req.getParameter("activity_name"));
    	entry.setIndicator_name(req.getParameter("indicator_name"));
     	entry.setIndicator_category(req.getParameter("indicator_category"));
     	entry.setName(req.getParameter("name"));
     	entry.setValue(req.getParameter("value"));
     	
     	try {
            Date period = new SimpleDateFormat("MM/DD/YYYY").parse(req.getParameter("period"));
            entry.setPeriod(period);
           
        } catch (ParseException e) {
            e.printStackTrace();
        }
     	
        String id_activity = req.getParameter("id_activity");
        entry.setId_activity(Integer.parseInt(id_activity));
          
     	entry.setData_type(req.getParameter("data_type"));
                 
         
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
             ProjectActivitiesIndicators  entry = dao.get(projectId);
             req.setAttribute("entry", entry);
         } else if (action.equalsIgnoreCase("listProjectIndicators")){
             forward = LIST_PROJECT;
             req.setAttribute("list", dao.getAllEntries());  
         } else {
             forward = INSERT_OR_EDIT;
         }
         
         RequestDispatcher view = req.getRequestDispatcher(forward);
         view.forward(req, resp);
     }

         
 
        
}
