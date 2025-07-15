package models;

public class Student extends User {

	public Student(String userId, String name) {
		super(userId, name);
	}

	@Override
	public String getRole() {
		return "Student";
	}

}
