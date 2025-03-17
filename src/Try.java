import annotations.UsableForStudent;
import bean.Student;
import manage.Admin;
import manage.SessionManager;

import java.lang.reflect.Method;

public class Try {
    public static void main(String[] args) throws Exception {
        Method [] methods= SessionManager.getCurrentUser().getClass().getDeclaredMethods();
        for (Method m:methods){
            if (m.isAnnotationPresent(UsableForStudent.class)){
                System.out.println(m.getName());
            }
        }
    }
}
