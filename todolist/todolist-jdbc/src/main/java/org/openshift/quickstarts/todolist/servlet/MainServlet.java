package org.openshift.quickstarts.todolist.servlet;

import org.openshift.quickstarts.todolist.model.TodoEntry;
import org.openshift.quickstarts.todolist.service.TodoListService;

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


//import org.openshift.quickstarts.todolist.dao.JdbcTodoListDAO;
//import org.openshift.quickstarts.todolist.dao.TodoListDAO;



/** 
  * The MainServlet returns the  project list html on GET requests and handles the 
  * creation of new project entries on POST requests. 
  * 
  * The servlet uses the service and the class data (todoentry)
 */ 

public class MainServlet extends HttpServlet {

	    private static final long serialVersionUID = 1L;
	    private static String INSERT_OR_EDIT = "/project.jsp";
	    private static String LIST_PROJECT = "/listProject.jsp";
	    //private JdbcTodoListDAO dao;
	
      private TodoListService dao = new TodoListService();

	   /* public MainServlet() {
	        super();
	        dao = new JdbcTodoListDAO();
	    }
*/
 
   
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	
    	TodoEntry entry = new TodoEntry();
    	
    	entry.setName(req.getParameter("name"));
    	entry.setStatus(req.getParameter("status"));
    	entry.setManager(req.getParameter("manager"));
    	entry.setOrganization(req.getParameter("organization"));
    	entry.setDescription(req.getParameter("description"));
    
        try {
            Date startdt = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("startdt"));
            entry.setStartdt(startdt);
            
            Date enddt = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("enddt"));
            entry.setEnddt(Enddt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    
        String id = request.getParameter("id");
        if(id == null || id.isEmpty())
        {
            dao.addEntry(entry);
        }
       /* else
        {
            entry.setId(Integer.parseInt(id));
            dao.updateProject(entry);
        }*/
        RequestDispatcher view = request.getRequestDispatcher(LIST_PROJECT);
        request.setAttribute("list", dao.getAllEntries());
        view.forward(request, response);
    }
   
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	 String forward="";
         String action = request.getParameter("action");
         
         if (action.equalsIgnoreCase("delete")){
             int projectId = Integer.parseInt(request.getParameter("projectId"));
            // dao.deleteProject(projectId);
           null;  
             forward = LIST_PROJECT;
             request.setAttribute("list", dao.getAllEntries());  
         } else if (action.equalsIgnoreCase("edit")){
             forward = INSERT_OR_EDIT;
             int projectId = Integer.parseInt(request.getParameter("projectId"));
            // TodoEntry entry = dao.getProjectById(projectId);
           null;
             request.setAttribute("entry", entry);
         } else if (action.equalsIgnoreCase("listProject")){
             forward = LIST_PROJECT;
             request.setAttribute("list", dao.getAllEntries());  
         } else {
             forward = INSERT_OR_EDIT;
         }
         
         RequestDispatcher view = request.getRequestDispatcher(forward);
         view.forward(request, response);
     }

         
 
        
}
