package body;

import Controller.ScannerSJ;

import java.util.ArrayList;

public class Choice {
    private static ScannerSJ usu = new ScannerSJ();

    public static int getAnswer(ArrayList<String> data){
        return usu.toInt("Elija una opcion");
    }

    public static int getAnswer(String[] data){
        return usu.toInt("Elija una opcion");
    }
}
