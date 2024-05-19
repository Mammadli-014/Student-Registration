package util;

import services.LoginService;
import servicesInter.MenuService;
import services.RegistrationService;

import java.util.Scanner;

public enum Menu {
    REGISTER("Register", new RegistrationService()),
    LOGIN("Login", new LoginService()),
    LOGOUT("Logout", new LoginService()),
    UNKNOWN;

    private String message;
    private MenuService menu;

    public String getMessage() {
        return message;
    }

    Menu(String message, MenuService menu) {
        this.message = message;
        this.menu = menu;
    }

    Menu() {}

    public void service(){
        menu.process();
    }

    public static Menu selectMenu() {
        System.out.println("Select number");
        Scanner s = new Scanner(System.in);
        int index = s.nextInt();
        switch (index) {
            case 1 -> {
                return REGISTER;
            }
            case 2 -> {
                return LOGIN;
            }
            case 3 -> {
                return LOGOUT;
            }
        }
        return UNKNOWN;
    }

    public static void showServices() {
        int i = 1;
        Menu[] m1 = Menu.values();
        for (Menu mm : m1) {
            if (mm == UNKNOWN) continue;
            System.out.println(i + " " + mm.message);
            i++;
        }
        System.out.println();
    }
}