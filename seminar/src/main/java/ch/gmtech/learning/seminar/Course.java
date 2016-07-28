package ch.gmtech.learning.seminar;

public class Course {
	
	private String _name;
	private String _number;

	public Course(String name, String number) {
		_name = name;
		_number = number;
	}
	
	public String getName() {
		return _name;
	}

	public String getNumber() {
		return _number;
	}

	public String getDescription() {
		return _name + " " + _number;
	}
	
}