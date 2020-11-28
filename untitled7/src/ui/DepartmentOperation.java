package ui;

import model.Collage;
import model.Department;
import model.Group;
import model.Staff;

import java.util.Scanner;

public class DepartmentOperation {

    public void mainMenu() {
        while (true) {
            System.out.println("\n");
            Main.printTitle("Department Operations");
            Main.printList("", "add department", "edit department", "view all department", "delete department");
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

    public void add(Department department) {
        String x = "Enter department ";
        System.out.print(x + "ID: ");
        int id = new Scanner(System.in).nextInt();
        System.out.print(x + "name: ");
        String name = new Scanner(System.in).next();

        System.out.print(x + "header ID or 0 to later: ");
        int headerId = new Scanner(System.in).nextInt();
        Staff header = null;
        if (headerId != 0 && !Main.staff.isEmpty())
            for (Staff staff : Main.staff) {
                if (staff.getID() == headerId)
                    header = staff;
            }
        if (header == null)
            System.out.println("Not found Staff with ID= " + headerId);

        System.out.print(x + "collage ID or 0 to later: ");
        int collageId = new Scanner(System.in).nextInt();
        Collage collage=searchCollage(collageId);
        Department d = new Department(id, name, collage, header);
        if (collage == null && collageId!=0)
            System.out.println("Not found Collage with ID= " + collageId);
        else
            new CollageOperation().addDept(collage, d);

        if (department != null) {
            int i = Main.departments.indexOf(department);
            Main.departments.set(i, d);
        } else
            Main.departments.add(d);
        System.out.println("Done");
    }

    private Collage searchCollage(int id) {
        if (id != 0 && !Main.collages.isEmpty())
            for (Collage collage : Main.collages) {
                if (collage.getId() == id)
                    return collage;
            }
        return null;
    }

    private void edit() {
        String x = "Enter Department ";
        System.out.print(x + "ID: ");
        int id = new Scanner(System.in).nextInt();
        Department department = null;
        for (Department d : Main.departments) {
            if (d.getId() == id)
                department = d;
        }
        if (department != null)
            add(department);
        else
            System.out.println("Not found Department with ID= " + id);
    }

    private void view() {
        if (!Main.departments.isEmpty()) {
            int no=1;
            for (Department d : Main.departments) {
                String header=d.getHeader()!=null?d.getHeader().getName():"empty";
                String collage=d.getCollage()!=null?d.getCollage().getName():"empty";
                System.out.println((no++)+"ID: "+d.getId()+",  name: "+d.getName()+",  collage: "+collage+",  header: "+header);
            }
        }
        else
            System.out.println("empty");
    }

    private void delete() {
        System.out.println("Enter department ID: ");
        int id=new Scanner(System.in).nextInt();
        boolean isRemoved=false;
        for (Department d : Main.departments)
            if (d.getId() == id) {
                Main.departments.remove(d);
                isRemoved=true;
            }
        if (isRemoved)
            System.out.println("Done");
        else
            System.out.println("Not found department with ID= " + id);
    }

    public void addStaff(Department dept, Staff staff) {
        if (!dept.getStaff().contains(staff))
            dept.getStaff().add(staff);
    }

    public void addGroup(Department dept, Group group) {
        if (!dept.getGroups().contains(group))
            dept.getGroups().add(group);
    }
}
