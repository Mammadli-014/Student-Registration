package bean;

import manage.Admin;
import manage.Class;
import manage.Config;

import java.io.Serializable;
import java.util.Scanner;

// Class representing a student
public class Student extends Person implements Serializable {
    // Properties
    private String name, password, ID;
    private Class studentClass;

    // Getter for student's class
    public Class getStudentClass() {
        return studentClass;
    }

    // Method to set student's class (requires administrator permission)
    public void setStudentClass(Admin z, Class studentClass) {
        // Remove student from previous class
        getStudentClass().getStudents().remove(this);
        // Set new class for the student
        this.studentClass = studentClass;
        // Add student to the new class
        getStudentClass().getStudents().add(this);
        Config.getInstance().writeConfig();
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Method to set password
    public void setPassword(String oldPassword, String newPassword) {
        // Change password if old password matches
        this.password = (password.equals(oldPassword)) ? newPassword : oldPassword;
    }

    // Setter for student name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for student name
    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    // Constructor to initialize Student object with name, password, and class

    public Student() {
        this.ID = Admin.createID(this.getClass());
        System.out.println("Name:");
        Scanner s=new Scanner(System.in);
        this.name=s.nextLine();
        Scanner s1=new Scanner(System.in);
        System.out.println("Password:");
        this.password=s1.nextLine();
        System.out.println("Your ID:"+ID);

        // Add student to the class
        try{
        studentClass.getStudents().add(this);
        }catch (NullPointerException n){}

        // Add student to the list of all students managed by Admin
        Admin.personAdd(this);
    }
}
