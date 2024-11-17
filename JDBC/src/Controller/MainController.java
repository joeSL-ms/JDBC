package Controller;

import Controller.ScannerSJ;
import body.Choice;

import java.util.ArrayList;

public class MainController {
    public static void actions() {
        String table = null;
        String user;
        String psw;
        String database;
        //ArrayData
        ArrayList<String> columns;

        ScannerSJ usu = new ScannerSJ();
        int sl;
        do {
            sl = ControllerMenu.mainMenu();
            user = usu.toString("Indica el nombre de usuario");
            psw = usu.toString("Inserta tu contraseña");
            database = usu.toString("Como se llama la base de datos que vas a acceder?");

            //Initialize DB connection
            Transformer.initDB(user,psw,database);
            table = ControllerMenu.uniqInfo(Transformer.showTables());
            switch (sl) {
                case 1://CRUD
                    do {
                        //Options that you can do.
                        sl = ControllerMenu.crudMenu();
                        switch (sl) {
                            case 1:
                                //UPDATE
                                columns = ControllerMenu.multiInfo(Transformer.showColumns(table),"Cuantas columnas vas a modificar?");
                                Transformer.updateTable(table,columns, Choice.newValues(columns), usu.toInt("Indica la ID que deseas cambiar"));
                                break;
                            case 2:
                                //DELETE
                                Transformer.deleteOfTable(table,usu.toInt("Indica la ID que deseas cambiar"));
                                break;
                            case 3:
                                //INSERT
                                Transformer.insertOnTable(table,Choice.newValues(Transformer.showColumns(table)));
                                break;
                            default:
                                System.out.println("La opcion elegida no se reconoce, vuelva a intentarlo" +
                                        "Si se ha equivocado vuelva a atras");
                                break;
                        }
                    } while (sl != 4);
                    break;
                case 2:
                    //SHOW ALL DATA
                    
                    break;
                case 3:
                    //SEARCH INFO BY DATE
                    break;
                case 4:
                    //GOOGLE SEARCH
                    break;
                default:
                    break;
            }
        } while (sl != 5);
    }
}
