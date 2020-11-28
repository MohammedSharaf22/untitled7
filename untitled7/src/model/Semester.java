package model;

import java.util.ArrayList;

public class Semester {
    private int ID;
    private ArrayList<Semester> semesters;
    private ArrayList<Teaching> teachings;

    public Semester(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName(){
        switch (getID()){
            case 1: return "First Semester";
            case 2: return "Second Semester";
            case 3: return "Third Semester";
            case 4: return "Fourth Semester";
            case 5: return "Fifth Semester";
            case 6: return "Sixth Semester";
            case 7: return "Seventh Semester";
            case 8: return "Eighth Semester";
            case 9: return "Ninth Semester";
            case 10: return "Tenth Semester";
            default: return "is empty";
        }
    }

    public ArrayList<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(ArrayList<Semester> semesters) {
        this.semesters = semesters;
    }

    public ArrayList<Teaching> getTeachings() {
        return teachings;
    }

    public void setTeachings(ArrayList<Teaching> teachings) {
        this.teachings = teachings;
    }
}
