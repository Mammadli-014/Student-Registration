package services;


import manage.Admin;
import bean.Person;
import bean.Student;
import bean.Teacher;
import exceptions.InvalidNumberException;
import servicesInter.RegistrationServiceInter;

import java.io.IOException;
import java.util.Scanner;

public class RegistrationService implements RegistrationServiceInter {
    @Override
    public void process() {
        Person p = null;

        try {
            p = selecting();
        }catch (IOException e){
            process();
        }
        LoginService l=new LoginService();
        l.registeredLogin(p);
    }

    private Person selecting() throws IOException {
        try (Scanner s = new Scanner(System.in)) {
            Person.showAllPeople();
            int index = s.nextInt();
            return switch (index) {
                case 1 -> {
                    System.out.println(Student.class.getName() + " registration");
                    yield new Student();
                }
                case 2 -> {
                    System.out.println(Teacher.class.getName() + " registration");
                    yield new Teacher();
                }
                case 3 -> {
                    System.out.println(Admin.class.getName() + " registration");
                    yield new Admin();
                }
                default -> throw new InvalidNumberException("Invalid number entered");
            };
        }
    }


}