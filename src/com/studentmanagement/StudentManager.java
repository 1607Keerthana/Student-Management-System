package com.studentmanagement;

import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-10s %-10s %-30s%n",
                "ID", "NAME", "AGE", "GRADE", "SUBJECTS");
        System.out.println("--------------------------------------------------------------------------------");

        for (Student s : students) {
            System.out.printf("%-10d %-15s %-10d %-10.2f %-30s%n",
                    s.getId(),
                    s.getName(),
                    s.getAge(),
                    s.getGrade(),
                    String.join(", ", s.getSubjects()));
        }

        System.out.println("--------------------------------------------------------------------------------");
    }

    public Student searchById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public Student searchByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public boolean updateStudent(int id, double newGrade) {

        Student student = searchById(id);

        if (student != null) {
            student.setGrade(newGrade);
            return true;
        }

        return false;
    }

    public boolean deleteStudent(int id) {

        Student student = searchById(id);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }

    public double calculateAverageGrade() {

        if (students.isEmpty()) {
            return 0;
        }

        double total = 0;

        for (Student s : students) {
            total += s.getGrade();
        }

        return total / students.size();
    }

    public Student getTopPerformer() {

        if (students.isEmpty()) {
            return null;
        }

        Student topStudent = students.get(0);

        for (Student s : students) {

            if (s.getGrade() > topStudent.getGrade()) {
                topStudent = s;
            }
        }

        return topStudent;
    }
    public int getStudentCount() {
        return students.size();
    }
}