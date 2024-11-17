package body;

import Controller.ScannerSJ;

import java.util.ArrayList;
import java.util.Iterator;

public class Choice {
    private static ScannerSJ usu = new ScannerSJ();

    public static int getAnswer(ArrayList<String> data){
        return usu.toInt("Elija una opcion");
    }

    public static int getAnswer(){
        return usu.toInt("Elija una opcion");
    }
    public static ArrayList<String> getAnswers(ArrayList<String> data,String question){
        ArrayList<String> choices = new ArrayList<String>();
        int options = usu.toInt(question);
        int choice;
        do {
            choice = usu.toInt();
            if (choice > 0 && choice < data.size()){
                choices.add(data.get(choice));
            }else {
                System.out.println("La opcion que ha elegido ha sido erronea");
            }
        }while (choices.size() < options);
        return choices;
    }
    public static ArrayList<String> newValues(ArrayList<String> data){
        ArrayList<String> newValues = new ArrayList<String>();
        for (int i = 0; i < data.size(); i++) {
            newValues.add(usu.toString("Rellena el valor para : " + data.get(i)));
        }
        return newValues;
    }
}
