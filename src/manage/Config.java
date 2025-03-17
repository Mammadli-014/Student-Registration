package manage;

import bean.Student;
import bean.Teacher;
import exceptions.FalseObjectException;

import java.io.*;
import java.util.ArrayList;

public class Config implements Serializable {
    // Lists to hold all admins, students, classes, and teachers
    private final ArrayList<Admin> allAdmins = new ArrayList<>();
    private final ArrayList<Student> allStudents = new ArrayList<>();
    private final ArrayList<Class> allClasses = new ArrayList<>();
    private final ArrayList<Teacher> allTeachers = new ArrayList<>();

    @Serial
    private static final long serialVersionUID = 7062698481402950035L;
    private boolean isLoggedIn;
    private final String fileDirection = "DataBase\\config.obj";

    public ArrayList<Admin> getAllAdmins() {
        return new ArrayList<>(allAdmins);
    }

    public ArrayList<Student> getAllStudents() {
        return new ArrayList<>(allStudents);
    }

    public ArrayList<Class> getAllClasses() {
        return new ArrayList<>(allClasses);
    }

    public ArrayList<Teacher> getAllTeachers() {
        return new ArrayList<>(allTeachers);
    }

    private static Config c = null;

    private Config() {}

    public static Config getInstance() {
        if (c == null) {
            c=new Config();
            c.readConfig();   // Dosyadan veriler okunmaya çalışılıyor
        }
        return c; // Singleton nesne döndürülüyor
    }

    public boolean getIsLoggedIn() {
        return isLoggedIn;
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
        try (ObjectInputStream o = new ObjectInputStream(new FileInputStream(fileDirection))) {
            // Reading the serialized Config object
            c = (Config) o.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeConfig() {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(fileDirection));
            o.writeObject(Config.getInstance());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void addObjectToFile(Object o) {
        try {
            Config.getInstance().addObjectToArrayList(o);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}