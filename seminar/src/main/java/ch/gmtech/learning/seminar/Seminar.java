public class Seminar {
	private Course _course;
	private String _location;
	private List<Enrollment> _enrollments;

	public String getName() {
		return _course.getName() + _course.getNumber();
	}

	public String getDescription() {
		return _course.getDescription();
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

}
