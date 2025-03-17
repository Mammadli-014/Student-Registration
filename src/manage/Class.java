package manage;

import annotations.UsableForAdmin;
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
    public static ArrayList<Student> emptyClass=new ArrayList<>();


    public String getClassName() {
        return className;
    }

    public Teacher getTeacher() {
        return t;
    }

    public ArrayList<Student> getStudents() {
        if (SessionManager.getP()==PersonType.TEACHER || SessionManager.getP()== PersonType.ADMIN) return (ArrayList<Student>) students.clone();
        else System.err.println("You can not enter this proccess");
        return null;
    }

    // Method to set teacher (requires administrator permission)
    public void setTeacher(Teacher t) {
        if (SessionManager.getP()==PersonType.ADMIN) this.t = t;
        else System.err.println("You can not use this proccess");
    }

    @UsableForAdmin
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
        Config.addObjectToFile(this);
    }
}
