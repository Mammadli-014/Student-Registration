package bean;

import manage.Admin;
import manage.Class;
import manage.Config;
import manage.PersonType;

import java.io.Serializable;
import java.util.Scanner;

// Class representing a student
public class Student extends Person implements Serializable {
    // Properties
    private String name, password, ID;
    private Class studentClass;

    public void setStudentClass(Class studentClass) {
        if (Config.getLoginedAs() == PersonType.ADMIN) {
            this.studentClass = studentClass;
        } else System.err.println("You are not Admin, that's why the class is not changed");
    }


    public Class getStudentClass() {
        return studentClass;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String oldPassword, String newPassword) {
        if (Config.getLoginedAs() == PersonType.ADMIN) {
            this.password = (password.equals(oldPassword)) ? newPassword : oldPassword;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public Student() {
        this.ID = Admin.createID(this.getClass());
        System.out.println("Name:");
        Scanner s = new Scanner(System.in);
        this.name = s.nextLine();
        Scanner s1 = new Scanner(System.in);
        System.out.println("Password:");
        this.password = s1.nextLine();
        System.out.println("Your ID:" + ID);

        Class.emptyClass.add(this);

        // Add student to the class
        try {
            studentClass.getStudents().add(this);
        } catch (NullPointerException ignored) {}

        // Add student to the list of all students managed by Admin
        Admin.addObjectToFile(this);
    }
}
