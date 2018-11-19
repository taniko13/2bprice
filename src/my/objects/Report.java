package my.objects;

public class Report extends Document {
	
	public Report(String employeeId) {
		super();
		this._employees.add(employeeId);
	}
	
	public Report(String employeeId, String text) {
		super(text);
		this._employees.add(employeeId);
	}
	
	public Report(String id, String text, String date) {
		super(id, text, date);
	}
	
	//Methods
	@Override
	public String toString() {
		String toString =  this.getId() + ", "+ this.getText() + ", " 
				+this.getDate().toString();
		for(String employeeId : this._employees) {
			toString += ", " + employeeId;
		}
			return toString;
	}
}

