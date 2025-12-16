package service;

import model.Student;

public class RuleEngine {

    public static String evaluateRisk(Student student) {

        double attendance = student.getAttendance();
        double marks = student.getMarks();

        if (attendance < 50 || marks < 40) {
            return "HIGH RISK";
        } else if (attendance < 65 || marks < 55) {
            return "MEDIUM RISK";
        } else {
            return "LOW RISK";
        }
    }
}
