package ui;

import model.Department;
import model.Group;
import model.Student;

import java.util.Scanner;

public class GroupOperation {
    public void mainMenu() {
        while (true) {
            System.out.println("\n");
            Main.printTitle("Group Operations");
            Main.printList("", "add group", "edit group", "view all group", "delete group");
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
                case 0:return;
            }
        }
    }

    public void add() {
        add(null);
    }

    public void add(Group group) {
        String x = "Enter group ";
        System.out.print(x + "ID: ");
        int id = new Scanner(System.in).nextInt();
        System.out.print(x + "name: ");
        String name = new Scanner(System.in).next();

        System.out.print(x + "department ID: ");
        int deptId = new Scanner(System.in).nextInt();
        Department dept=searchDept(deptId);
        Group g = new Group(id, name, dept);
        if (dept == null)
            new DepartmentOperation().add(dept);
        else
            new DepartmentOperation().addGroup(dept, g);

        if (group != null) {
            int i = Main.groups.indexOf(group);
            Main.groups.set(i, g);
        } else
            Main.groups.add(g);
        System.out.println("Done");
    }

    private Department searchDept(int id) {
        if (id != 0 && !Main.departments.isEmpty())
            for (Department department : Main.departments) {
                if (department.getId() == id)
                    return department;
            }
        return null;
    }

    private void edit() {
        String x = "Enter group ";
        System.out.print(x + "ID: ");
        int id = new Scanner(System.in).nextInt();
        Group group = null;
        for (Group g : Main.groups) {
            if (g.getID() == id)
                group = g;
        }
        if (group != null)
            add(group);
        else
            System.out.println("Not found group with ID= " + id);
    }

    private void view() {
        if (!Main.groups.isEmpty()) {
            int no=1;
            for (Group g : Main.groups) {
                String dept=g.getDept()!=null?g.getDept().getName():"empty";
                System.out.println((no++)+"ID: "+g.getID()+",  name: "+g.getName()+",  department: "+dept);
            }
        }
        else
            System.out.println("empty");
    }

    private void delete() {
        System.out.println("Enter group ID: ");
        int id=new Scanner(System.in).nextInt();
        boolean isRemoved=false;
        for (Group g : Main.groups)
            if (g.getID() == id) {
                Main.groups.remove(g);
                isRemoved=true;
            }
        if (isRemoved)
            System.out.println("Done");
        else
            System.out.println("Not found group with ID= " + id);
    }

    public void addStudent(Group group, Student student){
        if (!group.getStudents().contains(student))
            group.getStudents().add(student);
        /*else{
            group.getStudents().set(group.getStudents().indexOf(student), student);
        }*/
    }
}
