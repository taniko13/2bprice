package my.objects;

import java.util.ArrayList;
import java.util.Date;

public class Manager extends Employee {
	private ArrayList<String> _myReports;
	
	/*Constructors*/
	public Manager() {
		super();
		this._myReports = new ArrayList<String>();
	}
	
	public Manager(
			String firstName,
			String lastName,
			String position,
			ArrayList<String> myTasks,
			ArrayList<String> myReports) {
		super(firstName, lastName, position, myTasks);
		this._myReports = myReports != null ? myReports : new ArrayList<String>();
	}
	
	public Manager (
			String id,
			String firstName,
			String lastName,
			String position,
			ArrayList<String> myTasks,
			ArrayList<String> myReports) {
		super(id, firstName, lastName, position, myTasks);
		this._myReports = myReports != null ? myReports : new ArrayList<String>();
	}
	
	//Setters
	public void setReports(ArrayList<String> myReports) {
		if (this != null && myReports != null) {
			this._myReports = myReports;
		}
	}
	
	//Getters
	public ArrayList<String> getReports(){
		if(this != null) {
			return this._myReports;
		}
		return null;
	}
	
	//Methods 
	public Task createNewTask(String text, Date dueDate) {
		Task newTask = new Task(this.getId(), text, dueDate);
		return newTask;
	}
	       
	public void addReport(String report) {
		if(this != null) {
			if(this._myReports == null) {
				this._myReports = new ArrayList<String>();
			}
			this._myReports.add(report);
		}
	}
	
	public void removeReport(String report) {
		if(this != null && this._myReports != null && report != null) {
			this._myReports.remove(report);
		}
	}
	
	@Override
	public  String toString() {
		String toString =  this.getId() + ", " + this.getFirstName() + ", " + this.getLastName() + ", "+ this.getPosition();
		if(this.getMyTasks() != null && this.getMyTasks().size() >0) {
			toString += ", Tasks";
			//get all tasks ids 
			for(String taskId : this.getMyTasks()) {
				toString += ", " + taskId ;
			}
		}
		if(this.getReports() != null && this.getReports().size() >0) {
			toString += ", Reports";
			//get all tasks ids 
			for(String reportId : this.getReports()) {
				toString += ", " +reportId;
			}
		}
		return toString;
	}
}
