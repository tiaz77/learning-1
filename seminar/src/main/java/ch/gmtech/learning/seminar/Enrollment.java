package ch.gmtech.learning.seminar;

public class Enrollment {
	
	private Student _student;	

	public Enrollment(Student student) {
		_student = student;
	}
	
	public String getInfo() {
		return _student.getInfo();
	}

}