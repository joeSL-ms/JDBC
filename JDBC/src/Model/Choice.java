package Model;

import java.util.ArrayList;

public class Choice {
    private static final ScannerSJ usu = new ScannerSJ();

    public static int getAnswer(ArrayList<String> data) {
        return usu.toIntByArray(data, "Elija una opcion");
    }

    public static int getAnswer() {
        return usu.toInt("Elija una opcion");
    }

    //take all choices and check if is in range of your array
    public static ArrayList<String> getAnswers(ArrayList<String> data, String question) {
        ArrayList<String> choices = new ArrayList<String>();
        int options;
        int choice;
        options = usu.toIntByArray(data, question);
        do {
            System.out.println("Seleccione los valores :)");
            choice = usu.toInt()-1;
            if (choice > 0 && choice < data.size()) {
                choices.add(data.get(choice));
            } else {
                System.out.println("La opcion que ha elegido ha sido erronea");
            }
        } while (choices.size() < options);
        return choices;
    }

    //get new data, can take bad words(example if you want to write banana and miss writing vamama)
    public static ArrayList<String> newValues(ArrayList<String> data) {
        ArrayList<String> newValues = new ArrayList<String>();
        for (String datum : data) {
            newValues.add(usu.toString("Rellena el valor para : " + datum));
        }
        return newValues;
    }
}
