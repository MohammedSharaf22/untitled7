package model;

public class Studying {
    private Student student;
    private Course course;
    private String studyYear;
    private double studyWork;
    private double midTerm;
    private String notes;

    public Studying(Student student, Course course, String studyYear, double studyWork, double midTerm, String notes) {
        this.student = student;
        this.course = course;
        this.studyYear = studyYear;
        this.studyWork = studyWork;
        this.midTerm = midTerm;
        this.notes = notes;
    }

    public double totalGrade(){
        return midTerm+studyWork;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(String studyYear) {
        this.studyYear = studyYear;
    }

    public double getStudyWork() {
        return studyWork;
    }

    public void setStudyWork(double studyWork) {
        this.studyWork = studyWork;
    }

    public double getMidTerm() {
        return midTerm;
    }

    public void setMidTerm(double midTerm) {
        this.midTerm = midTerm;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
