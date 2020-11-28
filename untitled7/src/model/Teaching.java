package model;

public class Teaching {
    private Course course;
    private Staff staff;
    private String teachYear;

    public Teaching(Course course, Staff staff, String teachYear) {
        this.course = course;
        this.staff = staff;
        this.teachYear = teachYear;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getTeachYear() {
        return teachYear;
    }

    public void setTeachYear(String teachYear) {
        this.teachYear = teachYear;
    }
}
