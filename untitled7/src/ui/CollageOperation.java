package ui;

import model.Collage;
import model.Department;
import model.Staff;

import java.util.Scanner;

public class CollageOperation {
    public void mainMenu() {
        while (true) {
            System.out.println("\n");
            Main.printTitle("Collage Operations");
            Main.printList("", "add collage", "edit collage", "view all collage", "delete collage");
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

    public void add(Collage collage) {
        String x = "Enter collage ";
        System.out.print(x + "ID: ");
        int id = new Scanner(System.in).nextInt();
        System.out.print(x + "name: ");
        String name = new Scanner(System.in).next();
        System.out.print(x + "dean ID or 0 to later: ");
        int deanId = new Scanner(System.in).nextInt();
        Staff dean = null;
        if (deanId != 0 && !Main.staff.isEmpty())
            for (Staff staff : Main.staff) {
                if (staff.getID() == deanId)
                    dean = staff;
            }
        if (dean == null)
            System.out.println("Not found Staff with ID= " + deanId);
        Collage c = new Collage(id, name, dean);
        if (collage != null) {
            int i = Main.collages.indexOf(collage);
            Main.collages.set(i, c);
        } else
            Main.collages.add(c);
        System.out.println("Done");
    }

    public void edit() {
        String x = "Enter collage ";
        System.out.print(x + "ID: ");
        int id = new Scanner(System.in).nextInt();
        Collage collage = null;
        for (Collage c : Main.collages) {
            if (c.getId() == id)
                collage = c;
        }
        if (collage != null)
            add(collage);
        else
            System.out.println("Not found Collage with ID= " + id);
    }

    public void view() {
        if (!Main.collages.isEmpty()) {
            int no=1;
            for (Collage c : Main.collages) {
                String dean=c.getDean()!=null?c.getDean().getName():"empty";
                System.out.println((no++)+"ID: "+c.getId()+",  name: "+c.getName()+",  dean: "+dean);
            }
        }
        else
            System.out.println("empty");
    }

    public void delete() {
        System.out.println("Enter collage ID: ");
        int id=new Scanner(System.in).nextInt();
        boolean isRemoved=false;
        for (Collage c : Main.collages)
            if (c.getId() == id) {
                Main.collages.remove(c);
                isRemoved=true;
            }
        if (isRemoved)
            System.out.println("Done");
        else
            System.out.println("Not found Collage with ID= " + id);
    }

    public void addDept(Collage collage, Department department) {
        if (!collage.getDepartments().contains(department))
            collage.getDepartments().add(department);
    }
}
