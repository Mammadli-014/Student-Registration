package manage;

import bean.Student;
import bean.Teacher;
import projectExceptions.FalseObjectException;

import java.io.*;
import java.util.ArrayList;

public class Config implements Serializable {
    // Lists to hold all admins, students, classes, and teachers
    private ArrayList<Admin> allAdmins = new ArrayList<>();
    private ArrayList<Student> allStudents = new ArrayList<>();
    private ArrayList<Class> allClasses = new ArrayList<>();
    private ArrayList<Teacher> allTeachers = new ArrayList<>();
    public ArrayList<Admin> getAllAdmins() {
        return (ArrayList<Admin>) allAdmins.clone();
    }

    public ArrayList<Student> getAllStudents() {
        return (ArrayList<Student>) allStudents.clone();
    }

    public ArrayList<Class> getAllClasses() {
        return (ArrayList<Class>) allClasses.clone();
    }

    public ArrayList<Teacher> getAllTeachers() {
        return (ArrayList<Teacher>) allTeachers.clone();
    }

    private boolean isLoggedIn;

    private static Config c = null;

    private Config() {

    }

    public static Config getInstance() {
        if (c == null) c = new Config();
        return c;
}

    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public void addObjectToArrayList(Object object) throws IOException {
        if (object instanceof Admin)
            allAdmins.add((Admin) object);
        else if (object instanceof Teacher)
            allTeachers.add((Teacher) object);
        else if (object instanceof Class)
            allClasses.add((Class) object);
        else if (object instanceof Student)
            allStudents.add((Student) object);
        else throw new FalseObjectException();

        writeConfig();
    }
    private void readConfig() {
        try (ObjectInputStream o = new ObjectInputStream(new FileInputStream("config.obj"))){
            Object object = o.readObject();
            c = (Config) object;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void writeConfig(){
        try {
            ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("config.obj",false));
            o.writeObject(Config.getInstance());
        } catch (IOException ignored) {}
    }

    {readConfig();}
}