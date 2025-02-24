package manage;

import bean.Person;
import bean.Student;
import bean.Teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

// Admin class responsible for managing students, teachers, and classes
public class Admin extends Person {
    // Properties
    private String name, password;
    private String adminID;

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for ID
    public String getID() {
        return adminID;
    }

    // Getter for password (private)

    public String getPassword() {
        return password;
    }

    // Method to add students and teachers
    public static void addObjectToFile(Object o) {
        try {
            Config.getInstance().addObjectToArrayList(o);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Check the all ides that empty
    public static boolean isEmptyID(String id) {
        ArrayList<Person> allPersons = new ArrayList<>();
        allPersons.addAll(Config.getInstance().getAllAdmins());
        allPersons.addAll(Config.getInstance().getAllStudents());
        allPersons.addAll(Config.getInstance().getAllTeachers());
        for (Person p:allPersons) if (p.getID().equals(id)) return false;
        return true;
    }

    void setStudentClass(String id,Class classToChange) {
        findStudentByID(id).setStudentClass(classToChange);
    }

    // Method to add a class
    Class createClass() {
        Scanner s=new Scanner(System.in);
        System.out.println("Class Name?");
        Class c = new Class(s.nextLine());
        try {
            Config.getInstance().addObjectToArrayList(c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    // Method to search students by name
    public ArrayList<Student> searchStudent(String name) {
        ArrayList<Student> allStudent = Config.getInstance().getAllStudents();
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : allStudent)
            if (s.getName().contains(name))
                result.add(s);
        return result;
    }

    // Method to find students by id
    public Student findStudentByID(String id) {
        ArrayList<Student> allStudent = Config.getInstance().getAllStudents();
        for (Student s : allStudent) {
            if (s.getID().equals(id))
                return s;
        }
        return null;
    }

    // Method to find teachers by name
    public ArrayList<Teacher> searchTeacher(String name) {
        ArrayList<Teacher> allTeachers = Config.getInstance().getAllTeachers();
        ArrayList<Teacher> result = new ArrayList<>();
        for (Teacher t : allTeachers)
            if (getName().contains(name))
                result.add(t);
        return result;
    }

    // Method to find teachers by name
    public Teacher findTeacher(String name) {
        ArrayList<Teacher> allTeachers = Config.getInstance().getAllTeachers();
        for (Teacher t : allTeachers)
            if (t.getName().equals(name))
                return t;
        return null;
    }


    // Method to search classes by name
    public ArrayList<Class> searchClass(String name) {
        ArrayList<Class> allClasses = Config.getInstance().getAllClasses();
        ArrayList<Class> result = new ArrayList<>();
        for (Class c : allClasses)
            if (getName().contains(name))
                result.add(c);
        return result;
    }

    // Method to find classes by name
    public Class findClass(String name) {
        ArrayList<Class> allClasses = Config.getInstance().getAllClasses();
        for (Class c : allClasses)
            if (getName().equals(name))
                return c;
        return null;
    }

    public static String createID(java.lang.Class c) {
        int id;
        do {
            Calendar calendar = Calendar.getInstance();
            int currentYear = calendar.get(Calendar.YEAR);
            Random r = new Random();
            id = (currentYear % 100) * 1000000 + r.nextInt(100000);
            if (c.getName().equals( Admin.class.getName()))
                id+=900_00_0;
            else if (c.getName().equals( Student.class.getName()))
                id += 200_00_0;
            else if (c.getName().equals(Teacher.class.getName()))
                id += 100_00_0;

        } while (!Admin.isEmptyID(Integer.toString(id)));
        return Integer.toString(id);
    }


    // Constructor to initialize Admin object with name and password
    public Admin() {
        this.adminID = createID(this.getClass());
        System.out.println(adminID);
        Scanner s = new Scanner(System.in);
        System.out.println("Name:");
        this.name = s.nextLine();
        System.out.println("Password:");
        this.password = s.nextLine();

        try {
            Config.getInstance().addObjectToArrayList(this); // Add newly created admin to the list of all admins
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
