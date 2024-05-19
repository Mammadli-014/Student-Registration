package manage;

import bean.Student;
import bean.Teacher;

import java.io.Serializable;
import java.util.ArrayList;

// Class representing a school class
public class Class implements Serializable {
    // Properties
    private String className;
    private Teacher t;
    private ArrayList<Student> students;

    // Getter for class name
    public String getClassName() {
        return className;
    }

    // Getter for teacher
    public Teacher getTeacher() {
        return t;
    }

    // Getter for students
    public ArrayList<Student> getStudents() {
        return students;
    }

    // Method to set class name (requires administrator permission)
    public void setName(Admin z, String name) {
        this.className = name;
    }

    // Method to set teacher (requires administrator permission)
    public void setTeacher(Admin z, Teacher t) {
        this.t = t;
    }

    // Method to display all information about the class
    public void showAll() {
        System.out.println("Teacher: " + getTeacher());
        System.out.println("Students:");
        for (Student s : students)
            System.out.print(s.getName() + " ");
    }

    // Constructor to initialize Class object with class name
    Class(String className) {
        this.className = className;
        students = new ArrayList<>();
    }
}
