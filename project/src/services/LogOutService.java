package services;

import servicesInter.LogOutServiceInter;

public class LogOutService implements LogOutServiceInter {


    @Override
    public void process() {
        System.out.println("LogOut");
    }
}
