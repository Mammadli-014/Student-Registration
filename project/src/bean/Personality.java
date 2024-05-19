package bean;

public enum Personality {
    STUDENT("Student"),TEACHER("Teacher"),ADMIN("Admin"),UNKOWN;

    private String message;
    Personality(String message) {
        this.message=message;
    }
    Personality(){
    }

    public String getMessage() {
        return message;
    }

    public static void showPersons(){
        int i=1;
        Personality[] personalities= Personality.values();
        for (Personality p1:personalities){
            if (p1.getMessage() != null)System.out.println(i+" "+p1.getMessage());
            i++;
        }
    }
}