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


import org.openshift.quickstarts.todolist.dao.JdbcTodoListDAO;
import org.openshift.quickstarts.todolist.dao.TodoListDAO;



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
	    private JdbcTodoListDAO dao;
	
   // private TodoListService todoListService = new TodoListService();

	    public MainServlet() {
	        super();
	        dao = new JdbcTodoListDAO();
	    }

 
   
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
            dao.addProject(entry);
        }
        else
        {
            entry.setId(Integer.parseInt(id));
            dao.updateProject(entry);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_PROJECT);
        request.setAttribute("list", dao.getAllProjects());
        view.forward(request, response);
    }
}

        
        
    	
    	/*String id = req.getParameter("id");
    	String name = req.getParameter("name");
        String status = req.getParameter("status");   // getparamaeterValues() 
    	String manager = req.getParameter("manager");
        String organization = req.getParameter("organization"); // getparamaeterValues() 
    	String startdt = req.getParameter("startdt");
        String enddt = req.getParameter("enddt");
        String description = req.getParameter("description");
        
        /// collect the data and pass the data to the service to create the project ---
        todoListService.addEntry(new TodoEntry(id,name,startdt, enddt, organization, manager, status, description));
        
        //todoListService.updateProject(new TodoEntry(id,name,startdt, enddt, organization, manager, status, description));
       
       //  todoListService.deleteProject(new TodoEntry(id,name,startdt, enddt, organization, manager, status, description));
        
        //  todoListService.getProject(new TodoEntry(id,name,startdt, enddt, organization, manager, status, description));
        
        //  todoListService.getSearchProject(new TodoEntry(id,name,startdt, enddt, organization, manager, status, description));
        
        resp.sendRedirect("index.html");
    }
    */
    
   
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	 String forward="";
         String action = request.getParameter("action");
         
         if (action.equalsIgnoreCase("delete")){
             int projectId = Integer.parseInt(request.getParameter("projectId"));
             dao.deleteProject(projectId);
             forward = LIST_PROJECT;
             request.setAttribute("list", dao.getAllProjects());  
         } else if (action.equalsIgnoreCase("edit")){
             forward = INSERT_OR_EDIT;
             int projectId = Integer.parseInt(request.getParameter("projectId"));
             TodoEntry entry = dao.getProjectById(projectId);
             request.setAttribute("entry", entry);
         } else if (action.equalsIgnoreCase("listProject")){
             forward = LIST_PROJECT;
             request.setAttribute("list", dao.getAllProjects());  
         } else {
             forward = INSERT_OR_EDIT;
         }
         
         RequestDispatcher view = request.getRequestDispatcher(forward);
         view.forward(request, response);
     }

         
 /*   	resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getServletContext().getResourceAsStream("/WEB-INF/index.html"), "UTF-8"));
        try {
            String line;
            boolean insideLoop = false;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("<!-- begin repeat for each entry -->")) {
                    insideLoop = true;
                } else if (line.trim().equals("<!-- end repeat for each entry -->")) {
                    insideLoop = false;
                    String entryTemplate = sb.toString();
                    for (TodoEntry entry : todoListService.getAllEntries()) {   ///get all the projects
                        out.println(
                                entryTemplate
								        .replace("{{ id }}", escapeHtml(entry.getId()))
                                        .replace("{{ name }}", escapeHtml(entry.getName()))
                                        .replace("{{ status }}", escapeHtml(entry.getStatus()))
                                        .replace("{{ manager }}", escapeHtml(entry.getManager()))
                                        .replace("{{ organization }}", escapeHtml(entry.getOrganization()))
                                        .replace("{{ startdt }}", escapeHtml(entry.getStartdt()))
                                        .replace("{{ enddt }}", escapeHtml(entry.getEnddt()))
                        );
                    }
                } else if (insideLoop) {
                   sb.append(line).append("\n");
                  
                  
                } else {
                    out.println(line);
                }
            }
        } finally {
            reader.close();
        }
    } 
*/
        

  //      RequestDispatcher view = request.getRequestDispatcher(forward);
    //    view.forward(request, response);
   // }

     
    
  //  private String escapeHtml(String text) {
    //    return text.replace("<", "&lt;");
   // }

}
