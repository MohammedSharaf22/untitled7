package model;

public abstract class Person {
    protected int ID;
    protected String name;
    protected char gender;
    protected String phone;
    protected String email;

    public Person(int ID, String name, char gender, String phone, String email) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
