import java.util.Scanner;

class Student {
    String studentName;
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    // Parameterized constructor
    public Student(String studentName, int rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Method to calculate total course fee
    public double calculateFee() {
        return courseCredits * 1500;
    }

    // Method to check eligibility (marks >= 50)
    public boolean checkEligibility() {
        return marks >= 50;
    }

    // Method to calculate scholarship
    public double calculateScholarship() {
        double fee = calculateFee();
        if (marks >= 85) {
            return fee * 0.20;
        } else if (marks >= 70) {
            return fee * 0.10;
        } else {
            return 0;
        }
    }

    // Method to calculate final fee after deducting scholarship
    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    // Method to display student and course details
    public void displayDetails() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Eligibility: " + checkEligibility());
        System.out.println("Total Fee: " + calculateFee());
        System.out.println("Scholarship: " + calculateScholarship());
        System.out.println("Final Fee: " + calculateFinalAmount());
    }

    // Alternative helper method matching previous name convention if needed
    public double calculateFinalAmount() {
        return calculateFinalFee();
    }
}

public class Hackathon2H {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String studentName = sc.nextLine();
        int rollNumber = sc.nextInt();
        double marks = sc.nextDouble();
        sc.nextLine(); // consume newline
        String courseName = sc.nextLine();
        int courseCredits = sc.nextInt();

        Student student = new Student(studentName, rollNumber, marks, courseName, courseCredits);

        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("Student is not eligible for course registration.");
        }

        sc.close();
    }
}