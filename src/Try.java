import annotations.UsableForStudent;
import bean.Student;

import java.lang.reflect.Method;

public class Try {
    public static void main(String[] args) throws Exception {
        for (Method method : Student.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(UsableForStudent.class)) {
                System.out.println(method.getName());// Eğer annotation varsa
                method.invoke(null); // Static metot olduğu için null geçiyoruz
            }
        }
    }
}
