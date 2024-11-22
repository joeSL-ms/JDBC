package Controller;

import Model.Choice;
import views.Menu;

import java.util.ArrayList;

public class ControllerMenu {
    public static int sesionDB() {
        String[] menu = {"Login", "Register"};
        Menu.mostrarMenu((menu));
        return Choice.getAnswer();
    }

    public static int mainMenu() {
        //change variable
        String[] menu = {"CRUD", "SHOW ALL DATA", "SEARCH INFO BY DATE", "GOOGLE SEARCH", "SALIR"};
        Menu.mostrarMenu(menu);
        return Choice.getAnswer();
    }

    //Show options that you can do with your data
    public static int crudMenu() {
        String[] CRUD = {"Update", "Delete", "Insert", "Volver"};
        Menu.mostrarMenu(CRUD);
        return Choice.getAnswer();
    }

    //take one choice about your menu
    public static String uniqInfo(ArrayList<String> data) {
        Menu.mostrarMenu(data);
        return data.get(Choice.getAnswer(data) - 1);
    }

    //take more than one choice about your menu
    public static ArrayList<String> multiInfo(ArrayList<String> data, String question) {
        Menu.mostrarMenu(data);
        return Choice.getAnswers(data, question);
    }
}
