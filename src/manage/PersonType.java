package manage;


import java.util.Locale;

public enum PersonType {
    STUDENT,TEACHER,ADMIN,NULL;


    public static PersonType choosePerson(String name){
        return switch (name.toLowerCase()){
            case "student" -> STUDENT;
            case "teacher" ->TEACHER;
            case "admin" ->ADMIN;
            default -> NULL;
        };
    }

}
