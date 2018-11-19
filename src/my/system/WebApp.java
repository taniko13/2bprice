package my.system;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.objects.Employee;

@WebServlet(urlPatterns = "/employees")
public class WebApp extends HttpServlet {
	final String EMPLOYEES_FILE = "Employees.txt";
	final String TASKS_FILE = "Tasks.txt";
	final String REPORTS_FILE = "Reports.txt";
	//GET
	@Override
 	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ExportImport importFromFile = new ExportImport();
		Dictionary<String, Employee> employees = importFromFile.importImploeeys();
		
        
		req.setAttribute("employees", employees);	
		req.getRequestDispatcher("/WEB-INF/views/Employees.jsp").forward(req, resp);
	}
	//POST
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String id = req.getParameter("view");
		req.setAttribute("myEmployee", "hbjvscjhzcj");
		req.getRequestDispatcher("/WEB-INF/views/ViewEmployee.jsp").forward(req, resp);
	}
	
}
