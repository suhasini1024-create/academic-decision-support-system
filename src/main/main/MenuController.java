package main;

import model.Student;
import service.StudentService;
import service.RuleEngine;

import java.util.Scanner;

public class MenuController {

    private Scanner scanner = new Scanner(System.in);
    private StudentService studentService = new StudentService();

    public void start() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudentReport();
                    break;
                case 3:
                    evaluateRisk();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Attendance (%): ");
        double attendance = scanner.nextDouble();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine();

        Student student = new Student(id, name, attendance, marks);
        studentService.addStudent(student);
    }

    private void viewStudentReport() {
        System.out.print("Enter Student ID to view report: ");
        String id = scanner.nextLine();

        Student student = studentService.findStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("\n--- Student Academic Report ---");
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Attendance: " + student.getAttendance());
        System.out.println("Marks: " + student.getMarks());
    }

    private void evaluateRisk() {
        System.out.print("Enter Student ID to evaluate risk: ");
        String id = scanner.nextLine();

        Student student = studentService.findStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        String risk = RuleEngine.evaluateRisk(student);

        System.out.println("\n--- Academic Risk Evaluation ---");
        System.out.println("Student: " + student.getName());
        System.out.println("Risk Level: " + risk);
    }

    private void printMenu() {
        System.out.println("\n=== Academic Decision Support System ===");
        System.out.println("1. Add Student");
        System.out.println("2. View Student Report");
        System.out.println("3. Evaluate Academic Risk");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
}
