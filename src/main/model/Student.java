package model;

public class Student {

    private String id;
    private String name;
    private double attendance;
    private double marks;

    public Student(String id, String name, double attendance, double marks) {
        this.id = id;
        this.name = name;
        this.attendance = attendance;
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAttendance() {
        return attendance;
    }

    public double getMarks() {
        return marks;
    }
}
