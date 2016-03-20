package org.openshift.quickstarts.todolist.servlet;

import org.openshift.quickstarts.todolist.model.ProjectActivities;
import org.openshift.quickstarts.todolist.service.ProjectActivitiesService;

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


import org.openshift.quickstarts.todolist.dao.JdbcProjectActivitiesDAO;
import org.openshift.quickstarts.todolist.dao.ProjectActivitiesDAO;



/** 
  * The MainServletActivities is the controller
  * 
  * The servlet uses the service and the model(ProjectActivities
 */ 

public class MainServletActivities extends HttpServlet {

	    private static final long serialVersionUID = 1L;
	    private static String INSERT_OR_EDIT = "/projectActivities.jsp";
	    private static String LIST_PROJECT = "/listProjectActivities.jsp";
	 
	    private ProjectActivitiesService dao = new ProjectActivitiesService();

	    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	
    	ProjectActivities entry = new ProjectActivities();
    	
    	entry.setActivity_name(req.getParameter("Activity_name"));
    	entry.setCountry(req.getParameter("country"));
     	entry.setDescription(req.getParameter("description"));
        String award_number =  req.getParameter("award_number");
        entry.setAward_number(Integer.parseInt(award_number));
        
        String obligation_amount = req.getParameter("obligation_amount");
        entry.setObligation_amount(Integer.parseInt(obligation_amount));
       
        String id = req.getParameter("id");
        entry.setId(Integer.parseInt(id));
        
        
           String id_activity = req.getParameter("id_activity");
        if(id_activity == null || id_activity.isEmpty())
        {
            dao.addEntry(entry);
        }
        else
        {
            entry.setId_activity(Integer.parseInt(id_activity));
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
