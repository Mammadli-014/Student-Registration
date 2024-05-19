package services;

import manage.Config;
import bean.Person;
import servicesInter.LoginServiceInter;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginService implements LoginServiceInter {


    @Override
    public void process() {
        Scanner s=new Scanner(System.in);
        System.out.println("ID ?");
        String requestedID=s.nextLine();
        System.out.println("Password ?");
        String requestedPassword=s.nextLine();

        Config.getInstance().setLoggedIn(true);
        login(requestedID,requestedPassword);
    }

    @Override
    public void registeredLogin(Person person) {
        login(person.getID(),person.getPassword());
    }

    private void login(String ID,String password){
        ArrayList <Person> allPersons=new ArrayList<>();
        boolean isLoged =false;
        allPersons.addAll(Config.getInstance().getAllAdmins());
        allPersons.addAll(Config.getInstance().getAllTeachers());
        allPersons.addAll(Config.getInstance().getAllStudents());

        for (Person person:allPersons)
            if (person.getID().equals(ID) && person.getPassword().equals(password)){
                isLoged=true;
                System.out.println("You loged succesfully");
            }

        Config.getInstance().setLoggedIn(isLoged);
    }
}