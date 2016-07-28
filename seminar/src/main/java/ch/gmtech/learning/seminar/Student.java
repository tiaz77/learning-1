package ch.gmtech.learning.seminar;
public class Student {

	private String _firstName;
	private String _lastName;

	public Student(String firstName, String lastName) {
		_firstName = firstName;
		_lastName = lastName;
	}
	
	public String getInfo() {
		return getFullName();
	}

	public String getFullName() {
		return _firstName + " " + _lastName;
	}

}
