public class SeminarDetails {

	public void main(String[] args) {

		Seminar serminar = new Seminar();
		
		String seminarName = seminar.getName();

		String description = seminar.getDescription();
		String location = seminar.getLocation();
		String seatsLeft = seminar.getSeatsLeft();

		List<String> students = seminar.getStudentList();
	
	}

}
