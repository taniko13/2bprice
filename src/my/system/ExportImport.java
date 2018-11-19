package my.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import my.objects.Employee;
import my.objects.Manager;
import my.objects.Report;
import my.objects.Task;


/***********Export ***********/
public class ExportImport {
	final String EMPLOYEES_FILE = "C:\\Users\\tania\\eclipse-workspace\\2bprice\\Employees.txt";
	final String TASKS_FILE = "Tasks.txt";
	final String REPORTS_FILE = "Reports.txt";
	
	public static void writeFile(Dictionary<String, Object> data, String fileName) throws IOException {
		PrintWriter pw = new PrintWriter(fileName);
	 
		//write the employees to the  file
		 for (Enumeration<Object> e = data.elements(); e.hasMoreElements();)
			 pw.println(e.nextElement().toString());
		pw.close();
	}
	
/***********Import ***********/
	
	public Dictionary<String, Employee> importImploeeys(){
		Dictionary<String, Employee> employees = null;
		try {
			ArrayList<String> lines = readFromFile(EMPLOYEES_FILE);
			if(lines != null) {
				employees = new Hashtable<String, Employee>();
				for (String line: lines) {
				    String [] employee =  line.split(",");
				    if (employee.length >= 4) {
				    	Employee em = new Employee(employee[0], employee[1], employee[2], employee[3] , null);
				    	if(employee.length > 4 && employee[4].equals("Tasks")) {
				    		ArrayList<String> tasks = new ArrayList<String>();
				    		for(int i = 5; i < employee.length; i++) {
				    			tasks.add(employee[i]);
				    		}
				    		em.setMyTasks(tasks);
				    	}
				    	employees.put(em.getId(), em);
				    }
				}
			}
		}
		catch (IOException e) {
			System.out.println(e.toString());
		}
		return employees;
	}
	
	public Dictionary<String, Manager> importManagers(String fileName){
		Dictionary<String, Manager> employees = null;
		try {
			ArrayList<String> lines = readFromFile(fileName);
			if(lines != null) {
				employees = new Hashtable<String, Manager>();
				for (String line: lines) {
				    System.out.println(line);
				    String [] manager =  line.split(",");
				    if (manager.length >= 4) {
				    	Manager man = new Manager(manager[0], manager[1], manager[2], manager[3], null, null );
				    	if(manager.length > 4 && manager[4].equals("Tasks")) {
				    		ArrayList<String> tasks = new ArrayList<String>();
				    		int reportIndex = -1;
				    		for(int i = 5; i < manager.length; i++) {
				    			if(manager[i] == "Reports") {
				    				reportIndex = i;
				    				break;
				    			}
				    			tasks.add(manager[i]);
				    		}
				    		if(reportIndex > -1) {
				    			ArrayList<String> reports = new ArrayList<String>();
				    			for(int i = reportIndex +1 ; i < manager.length; i++) {
				    				reports.add(manager[i]);
				    			}
				    			man.setReports(reports);
				    		}
				    		man.setMyTasks(tasks);
				    	}
				    	employees.put(man.getId(), man);
				    }
				}
			}
		}
		catch (IOException e) {
			System.out.println(e.toString());
		}
		return employees;
	}
	
	public Dictionary<String, Report> importReports(String fileName){
		Dictionary<String, Report> reports = null;
		try {
			ArrayList<String> lines = readFromFile(fileName);
			if(lines != null) {
				reports = new Hashtable<String, Report>();
				for (String line: lines) {
				    System.out.println(line);
				    String [] report =  line.split(",");
				    if (report.length >=3) {
				    	Report pr = new Report(report[0], report[1], report[2]);
				    	ArrayList<String> employees = new ArrayList<String>();
				    	for(int i = 3; i < report.length; i++) {
				    		employees.add(report[i]);
				    	}
				    	pr.setEmployees(employees);
				    	reports.put(pr.getId(), pr);
				    }
				}
			}
		}
		catch (IOException e) {
			System.out.println(e.toString());
		}
		return reports;
	}
	
	public Dictionary<String, Task> importTasks(String fileName){
		Dictionary<String, Task> tasks = null;
		try {
			ArrayList<String> lines = readFromFile(fileName);
			if(lines != null) {
				tasks = new Hashtable<String, Task>();
				for (String line: lines) {
				    System.out.println(line);
				    String [] task =  line.split(",");
				    if (task.length >= 4) {
				    	Task pr = new Task(task[0], task[1], task[2], task[3]);
				    	ArrayList<String> employees = new ArrayList<String>();
				    	for(int i = 3; i < task.length; i++) {
				    		employees.add(task[i]);
				    	}
				    	pr.setEmployees(employees);
				    	tasks.put(pr.getId(), pr);
				    }
				}
			}
		}
		catch (IOException e) {
			System.out.println(e.toString());
		}
		return tasks;
	}
	
	//Read from file return array of chars
	public ArrayList<String>  readFromFile(String fileName) throws IOException {
	ArrayList<String> lines = null;
	FileReader fr = new FileReader(fileName);
    BufferedReader br = new BufferedReader(fr);
    try {
    	lines = new ArrayList<String>();
        String line = br.readLine();
        while (line != null) {
        	lines.add(line);
            line = br.readLine();
        }
        
    } 
    catch (Exception e) {
		System.out.println(e.toString());
	}
    finally {
        br.close();
    }
    return lines;
}
}

