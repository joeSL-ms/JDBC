package Controller;

import body.Choice;
import views.Menu;

import java.util.ArrayList;

public class ControllerMenu {
    public static int mainMenu() {
        //change variable
        String[] menu = new String[0];
        Menu.mostrarMenu(menu);
        return Choice.getAnswer(menu);
    }

    public static int crudMenu() {
        String[] CRUD = new String[0];
        Menu.mostrarMenu(CRUD);
        return Choice.getAnswer(CRUD);
    }

    public static String tables(ArrayList<String> tables){
        Menu.mostrarMenu(tables);
        return tables.get(Choice.getAnswer(tables));
    }
}
