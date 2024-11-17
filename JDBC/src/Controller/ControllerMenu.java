package Controller;

import body.Choice;
import views.Menu;

import java.util.ArrayList;

public class ControllerMenu {
    public static int mainMenu() {
        //change variable
        String[] menu = {"CRUD"};
        Menu.mostrarMenu(menu);
        return Choice.getAnswer();
    }
    //Show options that you can do with your data
    public static int crudMenu() {
        String[] CRUD = {"Update","Delete","Insert","Volver"};
        Menu.mostrarMenu(CRUD);
        return Choice.getAnswer();
    }
    //Show Tables that exist in your DB
    public static String uniqInfo(ArrayList<String> data){
        Menu.mostrarMenu(data);
        return data.get(Choice.getAnswer(data));
    }
    public static ArrayList<String> multiInfo(ArrayList<String> data,String question){
        Menu.mostrarMenu(data);
        return Choice.getAnswers(data,question);
    }
}
