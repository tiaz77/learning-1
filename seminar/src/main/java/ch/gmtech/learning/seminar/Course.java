package ch.gmtech.learning.seminar;

import java.util.ArrayList;
import java.util.List;

import ch.gmtech.learning.seminar.view.Html;

public class Course {
	
	private String _name;
	private String _number;
	private String _location;
	private int _numberOfSeats;
	
	private List<Student> _students;

	public Course(String name, String number, String location, int numberOfSeats, List<Student> students) {
		_name = name;
		_number = number;
		_location = location;
		_numberOfSeats = numberOfSeats;
		_students = students;
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
	
	public String getLocation() {
		return _location;
	}
	
	public List<String> getStudentList() {
		List<String> studentsDescription = new ArrayList<String>();
		for (Student student : _students) {
			studentsDescription.add(student.getInfo());
		}
		return studentsDescription;
	}

	public int getSeatsLeft() {
		return _numberOfSeats - _students.size();
	}
	
	public String render() {
		List<Html> studentList = new ArrayList<Html>();
		for (String student : getStudentList()) {
			studentList.add(new Html().li(student));
		}
		
		return new Html().html(
				new Html().head(
						new Html().title(_name)),
				new Html().body(
						new Html().div("Nome Corso:"),
						new Html().ul(
								new Html().li(getDescription()), 
								new Html().li(_location), 
								new Html().li(String.valueOf(getSeatsLeft()))),
						new Html().div("Partecipanti:"),
						new Html().ul(studentList.toArray(new Html[]{}))))
		.render();
	}
	
}