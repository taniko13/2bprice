package my.system;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import my.objects.Employee;
import my.objects.Manager;
import my.objects.Report;
import my.objects.Task;

public class Demo {

	public static void main(String[] args) {		
		
		Employee e1 = new Employee("Yaakov", "Cohen","employee", null);
		Employee e2 = new Employee("Nick", "Smith","employee", null);
		
		Manager m1 = new Manager("Ohad", "Levi","manager", null, null);
		Manager m2 = new Manager("Ofir", "Or","manager", null, null);
		
		Task t1 = m1.createNewTask("It's my new task", null);
		Task t2 = m1.createNewTask("second", new Date(29, 05,16));
		Task t3 = m2.createNewTask("third", new Date (28,12,31));
		
		Report r1 = e1.createNewReport("First report ");
		Report r2 = e2.createNewReport("second report");
		
		
		Dictionary<String, Object> employees = new Hashtable<String, Object>();
		employees.put(e1.getId(), e1);
		employees.put(e2.getId(), e2);
		employees.put(m1.getId(), m1);
		employees.put(m2.getId(), m2);
		
		Dictionary<String, Object> tasks = new Hashtable<String, Object>();
		tasks.put(t1.getId(), t1);
		tasks.put(t2.getId(), t2);
		tasks.put(t3.getId(), t3);
		
		Dictionary<String, Object> reports = new Hashtable<String, Object>();
		reports.put(r1.getId(), r1);
		reports.put(r2.getId(), r2);
		
		//write the employees to the  file
		/*try {
			ExportImport.writeFile(employees, EMPLOYEES_FILE);
		}
		catch(IOException e) {
			System.out.println(e.toString());
		}
		
		finally {

			 for (Enumeration<Object> e = employees.elements(); e.hasMoreElements();)
			       System.out.println(e.nextElement().toString());
		}
		
		//write the tasks to the  file
		try {
			ExportImport.writeFile(tasks, TASKS_FILE);
		}
		catch(IOException e) {
			System.out.println(e.toString());
		}
				
		finally {
			for (Enumeration<Object> e = tasks.elements(); e.hasMoreElements();)
				System.out.println(e.nextElement().toString());
		}
		 
		//write the reports to the  file
		try {
			ExportImport.writeFile(reports, REPORTS_FILE);
		}
		catch(IOException e) {
			System.out.println(e.toString());
		}
						
		finally {
			for (Enumeration<Object> e = reports.elements(); e.hasMoreElements();)
				System.out.println(e.nextElement().toString());
		}*/
		final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        Path workingDirectory=Paths.get("").toAbsolutePath();
        System.out.println("workingDirectory dir = " + workingDirectory);
        
        URL location = Demo.class.getProtectionDomain().getCodeSource().getLocation();
        System.out.println("URL location " + location.getFile());
        
		System.out.println("********************************************************************");
		System.out.println("From File");
		System.out.println("********************************************************************");
		
		ExportImport importFromFile = new ExportImport();
		Dictionary<String, Employee> importImploeeys = importFromFile.importImploeeys();
		 for (Enumeration<Employee> e = importImploeeys.elements(); e.hasMoreElements();)
		       System.out.println(e.nextElement().toString());
		
	}

}
