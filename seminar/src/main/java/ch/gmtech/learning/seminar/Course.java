package ch.gmtech.learning.seminar;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import ch.gmtech.learning.seminar.view.CsvRender;
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
	
	public void enroll(Student student) {
		
		if (_students.size() < getSeatsLeft()) {
			_students.add(student); 
		} else {
			throw new RuntimeException("Enrollment failed because of seats terminated!");
		}
	}
	
	public String renderHtml() {
		
		List<Html> studentList = new ArrayList<Html>();
		for (Student student : _students) {
			studentList.add(new Html().li(student.firstName() + " " + student.lastName()));
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
	
	public String renderCsv() {
		
		List<List<String>> data = new ArrayList<List<String>>();
		
		data.add(asList(_number, _name, getDescription(), _location, String.valueOf(getSeatsLeft())));
		
		for (Student student : _students) {
			data.add(asList(student.firstName(), student.lastName()));
		}
		
		return new CsvRender().render(data);
	}
	
	public String render() {
		
		String newLine = IOUtils.LINE_SEPARATOR;
		String studentList = "";

		for (Student student : _students) {
			studentList += student.firstName() + " " + student.lastName() + newLine;
		}
		
		return _name + " " + _number + ": " + getDescription() + newLine 
				+ "location: " + _location + newLine 
				+ "seats left: " + getSeatsLeft() + newLine 
			    +  newLine  
			    + "Enrollment:" + newLine  
			    + studentList;
	}
	
	private String getDescription() {
		return _name + " " + _number;
	}
	
	private int getSeatsLeft() {
		return _numberOfSeats - _students.size();
	}
	
}