package personService;

import annotations.UsableForStudent;
import bean.Student;
import manage.SessionManager;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Scanner;

public class StudentService extends PersonService {
    HashMap<Integer, Method> methods1;
    Student student;
    static StudentService studentService = null;

    private StudentService() {
    }

    public static StudentService getInstance() {
        if (studentService == null) {
            studentService = new StudentService();
            return studentService;
        } else return studentService;
    }

    {
        student = (Student) SessionManager.getCurrentUser();
        methods1 = new HashMap<>();
        Method[] methods = student.getClass().getDeclaredMethods();
        int i = 1;
        for (Method m : methods) {
            if (m.isAnnotationPresent(UsableForStudent.class)) {
                methods1.put(i, m);
                i++;
            }
        }
        showServices();
    }

    void showServices() {
        for (int i = 0; i < methods1.size(); i++) {
            System.out.println(i + ")" + methods1.get(i).getName());
        }
    }

    void getRequest() {
        Scanner s = new Scanner(System.in);
        System.out.println("Write what you want");
        int a = s.nextInt();

    }

}
