package my.objects;

import java.util.Date;

public class Task extends Document{
	
	private Date _dueDate;
	
	 //Constructors
	public Task(String managerId) {
		super();
		this._managers.add(managerId);
		this._dueDate = new Date();
	}
	
	public Task(String managerId, String text) {
		super(text);
		this._managers.add(managerId);
		this._dueDate = new Date();
	}
	
	public Task(String managerId, String text, Date dueDate) {
		super(text);
		this._managers.add(managerId);
		this._dueDate = dueDate != null ? dueDate : new Date();
	}
	
	public Task(String id, String text, String date, String dueDate) {
		super(id,text, date);
		this._dueDate = new Date(dueDate);
	}
	
	@SuppressWarnings("deprecation")
	public Task(String id, String text, String date, String dueDate, String employee, String managerId) {
		super(id, text, date);
		this._managers.add(managerId);
		this._dueDate = dueDate != null ?new Date(dueDate) : new Date();
	}
	//Getter
	public Date getDueDate() {
		if(this != null)
			return this._dueDate;
		return null;
	}
	
	//Methods
	@Override
	public String toString() {
		String toString =  this.getId() + ", "+ this.getText() + ", " +this.getDate().toString()+ 
				this.getDueDate().toString();
		for(String managerId : this._managers) {
			toString += ", " + managerId;
		}
		return toString;
	}

}
