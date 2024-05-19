package services;


import manage.Admin;
import bean.Person;
import bean.Personality;
import bean.Student;
import bean.Teacher;
import projectExceptions.InvalidNumberException;
import servicesInter.RegistrationServiceInter;

import java.io.IOException;
import java.util.Scanner;

public class RegistrationService implements RegistrationServiceInter {
    @Override
    public void process() {
        Personality p = null;
        try {
            p = selecting();
        }catch (IOException e){
            process();
        }
        System.out.println(p.getMessage()+" registration");
        Person registeredPerson = register(p);
        LoginService l=new LoginService();
        l.registeredLogin(registeredPerson);
    }

    public Person register(Personality personality) {
        return switch (personality) {
            case STUDENT -> new Student();
            case TEACHER -> new Teacher();
            case ADMIN -> new Admin();
            case UNKOWN -> null;
        };
    }


    private Personality selecting() throws IOException {
        Personality.showPersons();
        Scanner s = new Scanner(System.in);
        int index = s.nextInt();
        return switch (index) {
            case 1 -> Personality.STUDENT;
            case 2 -> Personality.TEACHER;
            case 3 -> Personality.ADMIN;
            default -> throw new InvalidNumberException("False Number entered");
        };
    }

}