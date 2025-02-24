import util.Menu;


public class Main {
    public static void main(String[] args) {
        Menu.showServices();
        Menu m=Menu.selectMenu();
        m.service();

        //Admin admin=new Admin();
        //Class c1=admin.createClass("11A");
        //Class c2=admin.createClass("11B");
        //Class c3=admin.createClass("11C");
    }
}