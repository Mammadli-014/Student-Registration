package personService;

import annotations.UsableForStudent;
import bean.Student;

import java.lang.reflect.Method;

public class StudentService extends PersonService{
    {
        showServices();
    }

    void showServices(){
        Method [] methods=Student.class.getDeclaredMethods();
        for (Method m:methods){
            if (m.isAnnotationPresent(UsableForStudent.class)){
                System.out.println(m.getName());
            }
        }
    }
}
