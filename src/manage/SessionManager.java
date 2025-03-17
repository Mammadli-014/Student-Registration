package manage;

import bean.Person;
import personService.AdminService;
import personService.StudentService;
import personService.TeacherService;

public class SessionManager {

    private static PersonType p;

    public static PersonType getP() {
        return p;
    }

    public static void setP(PersonType p) {
        SessionManager.p = p;
    }

    private static Person currentUser;
    static boolean isLogedIn;

    public static Person getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Person user) {
        currentUser = user;
    }

    public static void logout() {
        currentUser = null;
        System.out.println("User logged out successfully.");
    }

    public static void setLoggedIn(boolean loggedIn,PersonType personType) {
        isLogedIn=loggedIn;
        if (loggedIn) SessionManager.setP(personType);
        switch (personType){
            case ADMIN -> new AdminService();
            case STUDENT -> StudentService.getInstance();
            case TEACHER -> new TeacherService();
        }
    }
}
