package com.studentmanagement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileHandler {

    public static void saveStudents(List<Student> students) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("students.txt"))) {

            for (Student s : students) {

                writer.write(
                        s.getId() + "," +
                                s.getName() + "," +
                                s.getAge() + "," +
                                s.getGrade() + "," +
                                String.join(";", s.getSubjects())
                );

                writer.newLine();
            }

            System.out.println("Students saved successfully!");

        } catch (IOException e) {

            System.out.println("Error saving file!");
        }
    }
}