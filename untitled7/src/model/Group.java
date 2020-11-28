package model;

import java.util.ArrayList;

public class Group {
	private int ID;
	private String name;
	private Department dept;
	private ArrayList<Student> students;

	public Group(int ID, String name, Department dept) {
		this.ID = ID;
		this.name = name;
		this.dept = dept;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
}