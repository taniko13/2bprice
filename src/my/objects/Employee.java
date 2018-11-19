package my.objects;

import java.util.ArrayList;

public class Employee extends Person {

	protected  String _position;
	private ArrayList<String> _myTasks;
	
	/*Constructors*/
	public Employee() {
		super();
		_position = "";
		_myTasks = new ArrayList<String>();
	}
	
	public Employee (
			String firstName,
			String lastName,
			String position,
			ArrayList<String> myTasks) {
		super(firstName, lastName);
		this._position = position;
		this._myTasks = myTasks != null ? myTasks : new ArrayList<String>();
	}
	
	public Employee (
			String id,
			String firstName,
			String lastName,
			String position,
			ArrayList<String> myTasks) {
		super(id, firstName, lastName);
		this._position = position;
		this._myTasks = myTasks != null ? myTasks : new ArrayList<String>();
	}
	
	//Setters
	public void setPosition(String position) {
		if(this != null)	
			this._position = position;
	}
	
	public void setMyTasks(ArrayList<String> myTasks) {
		if(this != null) {
			this._myTasks = myTasks;
		}
	}
	
	//Getters
	public String getPosition() {
		if(this != null)
			return this._position;
		return "";
	}
	
	public ArrayList<String> getMyTasks(){
		if(this != null)
		{
			return this._myTasks;
		}
		return null;
	}
	
	//Methods
	public Report createNewReport(String text) {
		Report newReport = new Report(this.getId(), text);
		return newReport;
	}
	
	public void addNewTask (String task) {
		if (this != null && task != null) {
			if(this._myTasks == null) {
				this._myTasks = new ArrayList<String>();
			}
			this._myTasks.add(task);
		}
	}
	
	public void removedTask(String task) {
		if(this != null && this._myTasks != null && task != null) {
			this._myTasks.remove(task);
		}
	}
	
	@Override
	public  String toString() {
		String toString =  this.getId() + ", " + this.getFirstName() + ", " + this.getLastName() + ", "+ this.getPosition();
		if(this.getMyTasks() != null && this.getMyTasks().size() >0) {
			toString += ", Tasks";
			//get all tasks ids 
			for(String taskId : this.getMyTasks()) {
				toString += ", " + taskId;
			}
		}
		return toString;
	}
}

