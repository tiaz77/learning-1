package ch.gmtech.learning.seminar;

import java.util.ArrayList;
import java.util.List;

public class Seminar {
	
	private String _location;
	private int _numberOfSeats;
	
	private Course _course;
	private List<Enrollment> _enrollments;

	public Seminar(Course course, List<Enrollment> enrollments, String location, int numberOfSeats) {
		_course = course;
		_location = location;
		_enrollments = enrollments;
		_numberOfSeats = numberOfSeats;
	}
	
	public String getName() {
		return _course.getName() + _course.getNumber();
	}

	public String getDescription() {
		return _course.getDescription() + " @" + _location;
	}

	public String getLocation() {
		return _location;
	}

	public List<String> getStudentList() {
		List<String> lastNames = new ArrayList<String>();
		for (Enrollment enrollment : _enrollments) {
			lastNames.add(enrollment.getInfo());
		}
		return lastNames;
	}

	public int getSeatsLeft() {
		return _numberOfSeats - _enrollments.size();
	}

}