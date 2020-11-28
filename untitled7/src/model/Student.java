package model;

public class Student extends Person {

	private Group group;

	public Student(int ID, String name, char gender, String phone, String email, Group group) {
		super(ID, name, gender, phone, email);
		this.group = group;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
}