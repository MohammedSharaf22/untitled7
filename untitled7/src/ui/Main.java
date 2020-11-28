package ui;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Collage> collages= new ArrayList<>();
    public static ArrayList<Department> departments= new ArrayList<>();
    public static ArrayList<Group> groups= new ArrayList<>();
    public static ArrayList<Staff> staff= new ArrayList<>();
    public static ArrayList<Student> students= new ArrayList<>();

    public static void main(String[] args) {
        printTitle("Welcome to University Application");

        while (true){
            printList("List of operation:","Collage", "Department", "Group", "Staff", "Student");
            System.out.println("Enter no operation: ");
            switch (new Scanner(System.in).nextInt()){
                case 1:new CollageOperation().mainMenu();
                    break;
                case 2:new DepartmentOperation().mainMenu();
                    break;
                case 3:new GroupOperation().mainMenu();
                    break;
                case 4:new StaffOperation().mainMenu();
                    break;
                case 5:new StudentOperation().mainMenu();
                    break;
                case 0: return;
            }
        }
    }

    public static void printTitle(String mess){
        int starCount=2*mess.length();
        String stars="*".repeat(starCount);
        int spacesCount=(starCount-mess.length())/2;
        String spaces=" ".repeat(spacesCount);
        System.out.println("\n"+stars);
        System.out.print(spaces);
        System.out.print(mess);
        System.out.println(spaces);
        System.out.println(stars+"\n");
    }

    public static void printList(String title,String ...arg){
        System.out.println(title);
        System.out.println("0. to back");
        for (int i=0; i<arg.length; i++){
            System.out.println((i+1)+". "+arg[i]);
        }
        System.out.println("\n");
    }
}
