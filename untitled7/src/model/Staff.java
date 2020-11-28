package model;

public class Staff extends Person {
	private String qualification;
	private Department dept;

	public Staff(int ID, String name, char gender, String phone, String email, String qualification, Department dept) {
		super(ID, name, gender, phone, email);
		this.qualification = qualification;
		this.dept = dept;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
}