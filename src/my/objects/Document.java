package my.objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public abstract class Document {
	protected final String _id;
	 protected String _text;
	 protected Date _date;
	 protected ArrayList <String> _managers;
	 protected ArrayList <String> _employees;
	 
	 //Constructors
	 public Document() {
		this._id = UUID.randomUUID().toString();
		this._date = new Date();
		this._text = "";
		this._employees = new ArrayList<String>();
		this._managers = new ArrayList<String>();
	}
	 
	 public Document(String text) {
		this._id = UUID.randomUUID().toString();
		this._date = new Date();
		this._text = text;
		this._employees = new ArrayList<String>();
		this._managers = new ArrayList<String>();
	}
	 
	 @SuppressWarnings("deprecation")
	public Document(String id, String text, String date) {
			this._id = id;
			this._date = new Date(date);
			this._text = text;
			this._employees = new ArrayList<String>();
			this._managers = new ArrayList<String>();
	}
	
	//Getters
	 public String getId() {
		 if(this != null) {
			 return this._id;
		 }
		 return "";
	 }
	 public String getText() {
		 if(this != null)
			 return this._text;
		 return "";
	 }
	 
	 public Date getDate() {
		 if(this != null)
			 return this._date;
		 return null;
	 }
	 
	 //Setter
	 public void setManagers(ArrayList<String> managers) {
		 if(this != null) {
			 this._managers = managers;
		 }
	 }
	 
	 public void setEmployees(ArrayList<String> employees) {
		 if(this != null) {
			 this._employees = employees;
		 }
	 }
	 
	public void addManager(String managerId) {
		if(this != null && managerId != null && !managerId.isEmpty() ) {
			if(this._managers == null)
				 this._managers = new ArrayList<String>();
			this._managers.add(managerId);
		}
	}

	public void addEmployee(String employeeId) {
		if(this != null  && employeeId != null && !employeeId.isEmpty()) {
			if(this._employees != null)
				this._employees = new ArrayList<String>();
			this._employees.add(employeeId);
		}
	}
}
