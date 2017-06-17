package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public int getAge() {
        return age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        Student studentFound = null;
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade)
                studentFound = student;
        }
        return studentFound;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student studentFound = null;
        double maxGrade = 0;
        for (Student student : students) {
            if (student.getAverageGrade() > maxGrade) {
                maxGrade = student.getAverageGrade();
                studentFound = student;
            }
        }
        return studentFound;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        Student studentFound = null;
        double minGrade = students.get(0).getAverageGrade();
        for (Student student : students) {
            if (student.getAverageGrade() < minGrade) {
                minGrade = student.getAverageGrade();
                studentFound = student;
            }
        }
        return studentFound;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}