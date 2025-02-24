package bean;

import manage.Admin;
import manage.Class;
import manage.Config;

import java.io.Serializable;
import java.util.Scanner;

// Class representing a teacher
public class Teacher extends Person implements Serializable {
    // Properties
    private final String teacherID;
    private String name;
    private String password;
    private Class c;

    // Method to set teacher name (requires administrator permission)
    public void setName(Admin z, String name) {
        this.name = name;
        Config.getInstance().writeConfig();
    }

    // Method to set teacher password
    public void setPassword(String oldPassword, String password) {
        // Change password if old password matches
        this.password = (oldPassword.equals(password)) ? password : oldPassword;
        Config.getInstance().writeConfig();
    }

    // Method to set class for the teacher (requires administrator permission)
    public void setClass(Admin z, Class c) {
        // Set the class for the teacher
        this.c = c;
        // Assign this teacher as the teacher for the class
        getC().setTeacher(this);
        Config.getInstance().writeConfig();
    }

    // Getter for teacher's class
    public Class getC() {
        return c;
    }

    // Getter for teacher name
    public String getName() {
        return name;
    }

    // Getter for teacher password
    public String getPassword() {
        return password;
    }

    public String getID() {
        return teacherID;
    }

    // Constructor to initialize Teacher object with name, password, and class
    public Teacher() {
        teacherID=Admin.createID(this.getClass());
        System.out.println("Name:");
        Scanner s=new Scanner(System.in);
        this.name=s.nextLine();
        Scanner s1=new Scanner(System.in);
        System.out.println("Password:");
        this.password=s1.nextLine();
        System.out.println("Your ID:"+teacherID);
        // Add teacher to the list of all teachers managed by Admin
        Admin.addObjectToFile(this);
    }
}
