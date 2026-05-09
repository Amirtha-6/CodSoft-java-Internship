/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;

// Student Class
class Student {
    private int rollNo;
    private String name;
    private String department;
    private double marks;

    public Student(int rollNo, String name, String department, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.department = department;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getMarks() {
        return marks;
    }

    public String getGrade() {
        if (marks >= 90)
            return "A+";
        else if (marks >= 75)
            return "A";
        else if (marks >= 60)
            return "B";
        else if (marks >= 50)
            return "C";
        else
            return "Fail";
    }

    public void displayStudent() {
        System.out.println("------------------------------------------------");
        System.out.println("Roll No     : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Department  : " + department);
        System.out.println("Marks       : " + marks);
        System.out.println("Grade       : " + getGrade());
        System.out.println("------------------------------------------------");
    }
}

// Student Management System
public class StudentManagement{

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Student
    public static void addStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        Student s = new Student(roll, name, dept, marks);
        students.add(s);

        System.out.println("✅ Student Added Successfully!");
    }

    // Display All Students
    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n===== STUDENT RECORDS =====");
        for (Student s : students) {
            s.displayStudent();
        }
    }

    // Search Student
    public static void searchStudent() {
        System.out.print("Enter Roll Number to Search: ");
        int roll = sc.nextInt();

        boolean found = false;

        for (Student s : students) {
            if (s.getRollNo() == roll) {
                System.out.println("\nStudent Found:");
                s.displayStudent();
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ Student Not Found!");
        }
    }

    // Remove Student
    public static void removeStudent() {
        System.out.print("Enter Roll Number to Remove: ");
        int roll = sc.nextInt();

        Iterator<Student> it = students.iterator();
        boolean removed = false;

        while (it.hasNext()) {
            Student s = it.next();

            if (s.getRollNo() == roll) {
                it.remove();
                removed = true;
                System.out.println("✅ Student Removed Successfully!");
            }
        }

        if (!removed) {
            System.out.println("❌ Student Not Found!");
        }
    }

    // Topper
    public static void showTopper() {
        if (students.isEmpty()) {
            System.out.println("No records available.");
            return;
        }

        Student topper = students.get(0);

        for (Student s : students) {
            if (s.getMarks() > topper.getMarks()) {
                topper = s;
            }
        }

        System.out.println("\n🏆 CLASS TOPPER");
        topper.displayStudent();
    }

    // Main Menu
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n========== STUDENT MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Show Class Topper");
            System.out.println("6. Exit");
            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    removeStudent();
                    break;

                case 5:
                    showTopper();
                    break;

                case 6:
                    System.out.println("Thank You for Using Student Management System!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);
    }
}