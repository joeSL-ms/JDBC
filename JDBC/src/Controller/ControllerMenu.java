package Controller;

import views.Menu;

public class ControllerMenu {
    public static int mainMenu(){
        //change variable
        String[] menu = new String[0];
        Menu.mostrarMenu(menu);
        return 0;
    };
    public static int crudMenu(){
        String[] CRUD = new String[0];
        Menu.mostrarMenu(CRUD);
        return 0;
    }
}
