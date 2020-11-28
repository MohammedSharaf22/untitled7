package model;

import java.util.ArrayList;

public class Department {
    private int id;
    public String name;
    private Collage collage;
    private Staff header;
    private ArrayList<Group> groups;
    private ArrayList<Staff> staff;


    public Department(int id, String name, Collage collage, Staff header) {
        this.id = id;
        this.name = name;
        this.collage = collage;
        this.header = header;
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

    public Collage getCollage() {
        return collage;
    }

    public void setCollage(Collage collage) {
        this.collage = collage;
    }

    public Staff getHeader() {
        return header;
    }

    public void setHeader(Staff header) {
        this.header = header;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }

    public void setStaff(ArrayList<Staff> staff) {
        this.staff = staff;
    }
}