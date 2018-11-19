package my.objects;
import java.util.UUID;

public abstract class Person {
	protected final String _id;
	protected  String _firstName;
	protected  String _lastName;
	
	/*Constructors*/
	public Person() {
		this._id = UUID.randomUUID().toString();
		this._firstName = "";
		this._lastName = "";
	}
	
	public Person (String firstName, String lastName) {
		this._id = UUID.randomUUID().toString();
		this._firstName = firstName;
		this._lastName = lastName;
	}

	public Person (String id, String firstName, String lastName) {
		this._id = id;
		this._firstName = firstName;
		this._lastName = lastName;
	}
	
	//Setters
	public void setFirstName(String name) {
		if(this != null)
			this._firstName = name;
	}
	
	public void setLastName(String name) {
		if(this != null)
			this._lastName = name;
	}
	
	//Getters
	public String getId() {
		if(this != null) {
			return this._id;
		}
		return "";
	}
	public String getFirstName() {
		if(this != null)
			return this._firstName;
		return "";
	}
	
	public String getLastName() {
		if(this != null)
			return this._lastName;
		return "";
	}
}
