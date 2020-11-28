package model;

import java.util.ArrayList;

public class Collage {
	private int id;
	private String name;
	private Staff dean;
	private ArrayList<Department> departments;

	public Collage(int id, String name, Staff dean) {
		this.id = id;
		this.name = name;
		this.dean = dean;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Staff getDean() {
		return dean;
	}

	public void setDean(Staff dean) {
		this.dean = dean;
	}

	public ArrayList<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(ArrayList<Department> departments) {
		this.departments = departments;
	}
}