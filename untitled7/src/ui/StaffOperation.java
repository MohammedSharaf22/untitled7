package ui;

import model.Department;
import model.Staff;

import java.util.Scanner;

public class StaffOperation {
    public void mainMenu() {
        while (true) {
            System.out.println("\n");
            Main.printTitle("Staff Operations");
            Main.printList("", "add Staff", "edit Staff", "view all Staff", "delete Staff");
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

    private void add(Staff staff) {
        String x = "Enter staff ";
        System.out.print(x + "ID: ");
        int id = new Scanner(System.in).nextInt();
        System.out.print(x + "name: ");
        String name = new Scanner(System.in).next();
        System.out.print(x + "gender: ");
        char gender = new Scanner(System.in).next().charAt(0);
        System.out.print(x + "qualification: ");
        String qualification = new Scanner(System.in).next();
        System.out.print(x + "phone: ");
        String phone = new Scanner(System.in).next();
        System.out.print(x + "email: ");
        String email = new Scanner(System.in).next();

        System.out.print(x + "department ID: ");
        int deptId = new Scanner(System.in).nextInt();
        Department dept=searchDept(deptId);

        Staff s=new Staff(id, name, gender, phone,email,qualification, dept);
        if (dept == null)
            System.out.println("Not found Department with ID= " + deptId);
        else
            new DepartmentOperation().addStaff(dept, s);

        if (staff != null) {
            int i = Main.staff.indexOf(staff);
            Main.staff.set(i, s);
        } else
            Main.staff.add(s);
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
        String x = "Enter staff ";
        System.out.print(x + "ID: ");
        int id = new Scanner(System.in).nextInt();
        Staff staff = null;
        for (Staff s : Main.staff) {
            if (s.getID() == id)
                staff = s;
        }
        if (staff != null)
            add(staff);
        else
            System.out.println("Not found staff with ID= " + id);
    }

    private void view() {
        if (!Main.staff.isEmpty()) {
            int no=1;
            for (Staff s : Main.staff) {
                String dept=s.getDept()!=null?s.getDept().getName():"empty";
                System.out.println((no++)+"ID: "+s.getID()+",  name: "+s.getName()+",  gender: "+s.getGender()+",  phone: "+s.getPhone()+",  email: "+s.getEmail()+",  qualification: "+s.getQualification()+",  department: "+dept);
            }
        }
        else
            System.out.println("empty");
    }

    private void delete() {
        System.out.println("Enter staff ID: ");
        int id=new Scanner(System.in).nextInt();
        boolean isRemoved=false;
        for (Staff g : Main.staff)
            if (g.getID() == id) {
                Main.staff.remove(g);
                isRemoved=true;
            }
        if (isRemoved)
            System.out.println("Done");
        else
            System.out.println("Not found staff with ID= " + id);
    }
}
