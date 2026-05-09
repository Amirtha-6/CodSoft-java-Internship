/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.ArrayList;
import java.util.Scanner;

class StudentRecord {

    private int rollNumber;
    private String studentName;
    private String department;
    private double cgpa;

    // Constructor
    StudentRecord(int rollNumber, String studentName,
                  String department, double cgpa) {

        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.department = department;
        this.cgpa = cgpa;
    }

    // Getters
    int getRollNumber() {
        return rollNumber;
    }

    String getStudentName() {
        return studentName;
    }

    String getDepartment() {
        return department;
    }

    double getCgpa() {
        return cgpa;
    }

    // Update Method
    void updateDetails(String newName,
                       String newDepartment,
                       double newCgpa) {

        studentName = newName;
        department = newDepartment;
        cgpa = newCgpa;
    }

    // Display Student Info
    void displayStudent() {

        System.out.println("--------------------------------");
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Student Name: " + studentName);
        System.out.println("Department  : " + department);
        System.out.println("CGPA        : " + cgpa);
        System.out.println("--------------------------------");
    }
}

public class CampusStudentManager {

    static ArrayList<StudentRecord> studentList =
            new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    // Add Student
    public static void addStudent() {

        System.out.print("\nEnter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        // Duplicate check
        for (StudentRecord s : studentList) {

            if (s.getRollNumber() == roll) {
                System.out.println("Roll Number already exists!");
                return;
            }
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();

        studentList.add(
                new StudentRecord(roll, name, dept, cgpa));

        System.out.println("Student Added Successfully!");
    }

    // Display All Students
    public static void displayStudents() {

        if (studentList.isEmpty()) {
            System.out.println("\nNo Student Records Found.");
            return;
        }

        System.out.println("\n===== STUDENT RECORDS =====");

        for (StudentRecord s : studentList) {
            s.displayStudent();
        }
    }

    // Search Student
    public static void searchStudent() {

        System.out.print("\nEnter Roll Number to Search: ");
        int roll = sc.nextInt();

        for (StudentRecord s : studentList) {

            if (s.getRollNumber() == roll) {

                System.out.println("\nStudent Found!");
                s.displayStudent();
                return;
            }
        }

        System.out.println("Student Record Not Found.");
    }

    // Remove Student
    public static void removeStudent() {

        System.out.print("\nEnter Roll Number to Remove: ");
        int roll = sc.nextInt();

        for (StudentRecord s : studentList) {

            if (s.getRollNumber() == roll) {

                studentList.remove(s);

                System.out.println("Student Removed Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    // Update Student
    public static void updateStudent() {

        System.out.print("\nEnter Roll Number to Update: ");
        int roll = sc.nextInt();
        sc.nextLine();

        for (StudentRecord s : studentList) {

            if (s.getRollNumber() == roll) {

                System.out.print("Enter New Name: ");
                String name = sc.nextLine();

                System.out.print("Enter New Department: ");
                String dept = sc.nextLine();

                System.out.print("Enter New CGPA: ");
                double cgpa = sc.nextDouble();

                s.updateDetails(name, dept, cgpa);

                System.out.println("Student Details Updated!");
                return;
            }
        }

        System.out.println("Student Record Not Found.");
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("    CAMPUS STUDENT MANAGER");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Remove Student");
            System.out.println("6. Exit");
            System.out.println("================================");

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
                    updateStudent();
                    break;

                case 5:
                    removeStudent();
                    break;

                case 6:
                    System.out.println("\nExiting Student Manager...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
