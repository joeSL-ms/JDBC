package Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerSJ {
    Scanner usu = null;
    String respuestaString;
    int respuestaInt;
    char respuestaChar;

    public ScannerSJ() {
        usu = new Scanner(System.in);
    }

    public String toString(String contenido) {
        System.out.println(contenido);
        respuestaString = usu.nextLine();
        return respuestaString;
    }

    public int toInt(String contenido) {
        System.out.println(contenido);
        try {
            respuestaInt = usu.nextInt();
            usu.nextLine();
        } catch (InputMismatchException e) {
            System.err.println(e);
        }
        return respuestaInt;
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
