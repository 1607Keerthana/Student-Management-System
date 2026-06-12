package com.studentmanagement;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Calculate Average Grade");
            System.out.println("7. Save Data");
            System.out.println("8. Top Performer");
            System.out.println("9. Total Student Count");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    sc.nextLine();

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Grade: ");
                    double grade = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Subjects (comma separated): ");
                    String subjectsInput = sc.nextLine();

                    List<String> subjects =
                            Arrays.asList(subjectsInput.split(","));

                    Student student =
                            new Student(id, name, age, grade, subjects);

                    manager.addStudent(student);

                    break;

                case 2:

                    manager.displayAllStudents();

                    break;

                case 3:

                    System.out.println("\n1. Search By ID");
                    System.out.println("2. Search By Name");

                    System.out.print("Choose: ");
                    int searchChoice = sc.nextInt();
                    sc.nextLine();

                    if (searchChoice == 1) {

                        System.out.print("Enter Student ID: ");
                        int searchId = sc.nextInt();

                        Student found = manager.searchById(searchId);

                        if (found != null) {

                            System.out.println("\nStudent Found!");
                            System.out.println("ID      : " + found.getId());
                            System.out.println("Name    : " + found.getName());
                            System.out.println("Age     : " + found.getAge());
                            System.out.println("Grade   : " + found.getGrade());
                            System.out.println("Subjects: " +
                                    String.join(", ", found.getSubjects()));

                        } else {

                            System.out.println("Student Not Found!");
                        }

                    } else if (searchChoice == 2) {

                        System.out.print("Enter Student Name: ");
                        String searchName = sc.nextLine();

                        Student found = manager.searchByName(searchName);

                        if (found != null) {

                            System.out.println("\nStudent Found!");
                            System.out.println("ID      : " + found.getId());
                            System.out.println("Name    : " + found.getName());
                            System.out.println("Age     : " + found.getAge());
                            System.out.println("Grade   : " + found.getGrade());
                            System.out.println("Subjects: " +
                                    String.join(", ", found.getSubjects()));

                        } else {

                            System.out.println("Student Not Found!");
                        }
                    }

                    break;


                case 4:

                    System.out.print("Enter Student ID to Update: ");
                    int updateId = sc.nextInt();

                    Student studentToUpdate = manager.searchById(updateId);

                    if (studentToUpdate != null) {

                        System.out.println("Current Grade: "
                                + studentToUpdate.getGrade());

                        System.out.print("Enter New Grade: ");
                        double newGrade = sc.nextDouble();

                        manager.updateStudent(updateId, newGrade);

                        System.out.println("Student Updated Successfully!");

                    } else {

                        System.out.println("Student Not Found!");
                    }

                    break;

                case 5:



                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = sc.nextInt();

                    if (manager.deleteStudent(deleteId)) {
                        System.out.println("Student Deleted Successfully!");
                    } else {
                        System.out.println("Student Not Found!");
                    }

                    break;

                case 6:



                    double average = manager.calculateAverageGrade();

                    System.out.println("Class Average Grade: " + average);

                    break;

                case 7:

                    FileHandler.saveStudents(manager.getStudents());

                    break;

                case 8:

                    Student top = manager.getTopPerformer();

                    if (top != null) {

                        System.out.println("\n===== TOP PERFORMER =====");
                        System.out.println("ID      : " + top.getId());
                        System.out.println("Name    : " + top.getName());
                        System.out.println("Grade   : " + top.getGrade());

                    } else {

                        System.out.println("No Students Available!");
                    }

                    break;

                case 9:

                    System.out.println("Total Students: "
                            + manager.getStudentCount());

                    break;

                case 10:

                    System.out.println("Thank You!");

                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 10);

        sc.close();
    }
}