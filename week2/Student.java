public class Student {

	private String _firstName;
	private String _lastName;

	public String getInfo() {
		return getFullName();
	}

	public String getFullName() {
		return _firstName + " " + _lastName;
	}

}
