package services;

import manage.Admin;
import manage.Config;
import bean.Person;
import manage.PersonType;
import manage.SessionManager;
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

        login(requestedID,requestedPassword);
    }

    @Override
    public void registeredLogin(Person person) {
        login(person.getID(),person.getPassword());
    }

    private void login(String ID,String password){
        ArrayList <Person> allPeople=new ArrayList<>();

        allPeople.addAll(Config.getInstance().getAllAdmins());
        allPeople.addAll(Config.getInstance().getAllTeachers());
        allPeople.addAll(Config.getInstance().getAllStudents());
        String loginedAccount;

        for (Person person:allPeople){
            System.out.println(person.getID()+" "+person.getName()+" "+person.getPassword());
            if (person.getID().equals(ID) && person.getPassword().equals(password)){
                loginedAccount=person.getClass().getSimpleName();

                System.out.println("You loged succesfully");
                SessionManager.setCurrentUser(person);
                SessionManager.setLoggedIn(true, PersonType.choosePerson(loginedAccount));
                return;
            }
        }
        System.err.println("The password or Id is incorrect");


    }
}