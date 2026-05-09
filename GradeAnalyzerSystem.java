/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;

class GradeAnalyzerSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("      STUDENT GRADE CALCULATOR");
        System.out.println("====================================");

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Number of Subjects: ");
        int subjects = sc.nextInt();

        int[] marks = new int[subjects];

        int total = 0;
        int highest = 0;
        int lowest = 100;

        // Taking marks input
        for (int i = 0; i < subjects; i++) {

            while (true) {

                System.out.print("Enter marks for Subject " + (i + 1) + " (0-100): ");
                marks[i] = sc.nextInt();

                if (marks[i] >= 0 && marks[i] <= 100) {
                    break;
                } else {
                    System.out.println("Invalid marks! Please enter between 0 and 100.");
                }
            }

            total += marks[i];

            if (marks[i] > highest) {
                highest = marks[i];
            }

            if (marks[i] < lowest) {
                lowest = marks[i];
            }
        }

        double average = (double) total / subjects;

        String grade;
        String resultStatus;

        // Grade calculation
        if (average >= 90) {
            grade = "A+";
            resultStatus = "Outstanding";
        } else if (average >= 80) {
            grade = "A";
            resultStatus = "Excellent";
        } else if (average >= 70) {
            grade = "B";
            resultStatus = "Very Good";
        } else if (average >= 60) {
            grade = "C";
            resultStatus = "Good";
        } else if (average >= 50) {
            grade = "D";
            resultStatus = "Pass";
        } else {
            grade = "F";
            resultStatus = "Fail";
        }

        // Display section
        System.out.println("\n========== RESULT SUMMARY ==========");
        System.out.println("Student Name     : " + studentName);
        System.out.println("Subjects Count   : " + subjects);
        System.out.println("Total Marks      : " + total + " / " + (subjects * 100));
        System.out.printf("Average Percent  : %.2f%%\n", average);
        System.out.println("Highest Mark     : " + highest);
        System.out.println("Lowest Mark      : " + lowest);
        System.out.println("Final Grade      : " + grade);
        System.out.println("Performance      : " + resultStatus);
        System.out.println("====================================");

        // Simple performance message
        if (average >= 75) {
            System.out.println("Great job! Keep shining.");
        } else if (average >= 50) {
            System.out.println("Good effort! You can improve more.");
        } else {
            System.out.println("Work harder and try again.");
        }

        sc.close();
    }
}
