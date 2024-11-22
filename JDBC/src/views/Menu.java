package views;

import java.util.ArrayList;

public class Menu {
    public static void mostrarMenu(ArrayList<String> opciones) {
        System.out.println("Menu:");
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i));
        }
    }

    public static void mostrarMenu(String[] opciones) {
        System.out.println("Menu:");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
    }
}
