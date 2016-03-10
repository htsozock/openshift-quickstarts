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

/** 
  * The MainServlet returns the to-do list html on GET requests and handles the 
  * creation of new to-do list entries on POST requests. 
  * *
 */ 

public class MainServlet extends HttpServlet {

    private TodoListService todoListService = new TodoListService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
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
                    for (TodoEntry entry : todoListService.getAllEntries()) {
                        out.println(
                                entryTemplate
								       // .replace("{{ id }}", escapeHtml(entry.getId()))
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

    private String escapeHtml(String text) {
        return text.replace("<", "&lt;");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // project id is generated --- will be use using sequence 
		String name = req.getParameter("name");
        String status = req.getParameter("status");
    	String manager = req.getParameter("manager");
        String organization = req.getParameter("organization");
    	String startdt = req.getParameter("startdt");
        String enddt = req.getParameter("enddt");
        String description = req.getParameter("description");
        
        todoListService.addEntry(new TodoEntry( name,startdt, enddt, organization, manager, status, description));
        
        resp.sendRedirect("index.html");
    }
}
