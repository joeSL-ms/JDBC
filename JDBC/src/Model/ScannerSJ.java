package Model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ScannerSJ {
    private Scanner usu = null;
    private String respuestaString = "";
    private char respuestaChar;


    public ScannerSJ() {
        usu = new Scanner(System.in);
    }

    public String toString(String contenido) {
        System.out.println(contenido);
        respuestaString = usu.nextLine();
        return respuestaString;
    }

    public int toInt(String value) {
        int respuestaInt = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println(value);
            try {
                respuestaInt = usu.nextInt();
                usu.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.err.println("Por favor ingrese un número válido.");
                usu.nextLine();
            }
        }

        return respuestaInt;
    }

    public int toInt() {
        int respuestaInt = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                respuestaInt = usu.nextInt();
                usu.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.err.println("Por favor ingrese un número válido.");
                usu.nextLine();
            }
        }

        return respuestaInt;
    }

    //This method automatically loop one array and get a specific answer that is on witch length
    public int toIntByArray(ArrayList<String> item, String question) {
        int choice;
        choice = toInt(question);
        while (choice > item.size() || choice < 0) {
            System.out.println("Se encuentra fuera de los limites");
            choice = toInt(question);
        }
        return choice;
    }

    public char toChar(String contenido) {
        System.out.println(contenido);
        String respuesta;
        try {
            respuesta = usu.nextLine();
            if (respuesta.isEmpty()) {
                respuestaChar = '\0';
            } else {
                respuestaChar = respuesta.charAt(0);
            }
        } catch (InputMismatchException e) {
            System.err.println(e);
        }
        return respuestaChar;
    }
}
