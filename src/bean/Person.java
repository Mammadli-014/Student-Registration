package bean;

public class Person {
    String password,name,ID;

    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public static void showAllPeople(){
            System.out.println("1 Student");
            System.out.println("2 Teacher");
            System.out.println("3 Admin");
    }
}
