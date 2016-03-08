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

/**
 *
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
								        .replace("{{ project_code }}", escapeHtml(entry.getProject_code()))
                                        .replace("{{ name }}", escapeHtml(entry.getName()))
                                        .replace("{{ status }}", escapeHtml(entry.getStatus()))
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
         String project_code = req.getParameter("project_code"); //not required if the project code is generated
		String name = req.getParameter("name");
        String status = req.getParameter("status");

        todoListService.addEntry(new TodoEntry(project_code, name, status));

        resp.sendRedirect("index.html");
    }
}
