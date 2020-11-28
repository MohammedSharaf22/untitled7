package ui;

import model.Department;
import model.Group;
import model.Student;

import java.util.Scanner;

public class StudentOperation {
    public void mainMenu() {
        while (true) {
            System.out.println("\n");
            Main.printTitle("Student Operations");
            Main.printList("", "add Student", "edit Student", "view all Student", "delete Student");
            System.out.println("Enter no operation: ");
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    add();
                    break;
                case 2:
                    edit();
                    break;
                case 3:
                    view();
                    break;
                case 4:
                    delete();
                    break;
                case 0:
                    return;
            }
        }
    }

    public void add() {
        add(null);
    }

    private void add(Student student) {
        String x = "Enter student ";
        System.out.print(x + "ID: ");
        int id = new Scanner(System.in).nextInt();
        System.out.print(x + "name: ");
        String name = new Scanner(System.in).next();
        System.out.print(x + "gender: ");
        char gender = new Scanner(System.in).next().charAt(0);
        System.out.print(x + "phone: ");
        String phone = new Scanner(System.in).next();
        System.out.print(x + "email: ");
        String email = new Scanner(System.in).next();

        System.out.print(x + "department ID: ");
        int groupId = new Scanner(System.in).nextInt();
        Group group = searchGroup(groupId);
        Student s = new Student(id, name, gender, phone, email, group);
        if (group == null)
            System.out.println("Not found Group with ID= " + groupId);
        else
            new GroupOperation().addStudent(group, s);

        if (student != null) {
            int i = Main.students.indexOf(student);
            Main.students.set(i, s);
        } else
            Main.students.add(s);
        System.out.println("Done");
    }

    private Group searchGroup(int id) {
        if (id != 0 && !Main.groups.isEmpty())
            for (Group group : Main.groups) {
                if (group.getID() == id)
                    return group;
            }
        return null;
    }

    private void edit() {
        String x = "Enter student ";
        System.out.print(x + "ID: ");
        int id = new Scanner(System.in).nextInt();
        Student student = null;
        for (Student s : Main.students) {
            if (s.getID() == id)
                student = s;
        }
        if (student != null)
            add(student);
        else
            System.out.println("Not found student with ID= " + id);
    }

    private void view() {
        if (!Main.students.isEmpty()) {
            int no = 1;
            for (Student s : Main.students) {
                String group = s.getGroup() != null ? s.getGroup().getName() : "empty";
                System.out.println((no++) + "ID: " + s.getID() + ",  name: " + s.getName() + ",  gender: " + s.getGender() + ",  phone: " + s.getPhone() + ",  email: " + s.getEmail() + ",  group: " + group);
            }
        } else
            System.out.println("empty");
    }

    private void delete() {
        System.out.println("Enter student ID: ");
        int id = new Scanner(System.in).nextInt();
        boolean isRemoved = false;
        for (Student g : Main.students)
            if (g.getID() == id) {
                Main.students.remove(g);
                isRemoved = true;
            }
        if (isRemoved)
            System.out.println("Done");
        else
            System.out.println("Not found student with ID= " + id);
    }
}
