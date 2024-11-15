package Controller;

import Controller.ScannerSJ;
import views.Menu;

import java.util.ArrayList;

public class MainController {
    public static void actions() {
        String table = null;
        String user;
        String psw;
        String database;
        ScannerSJ usu = new ScannerSJ();
        int sl;
        do {
            sl = ControllerMenu.mainMenu();
            user = usu.toString("Indica el nombre de usuario");
            psw = usu.toString("Inserta tu contraseña");
            database = usu.toString("Como se llama la base de datos que vas a acceder?");

            Transformer.initDB(user,psw,database);
            table = ControllerMenu.tables(Transformer.showTables());
            switch (sl) {
                case 1://CRUD
                    do {
                        sl = ControllerMenu.crudMenu();
                        switch (sl) {
                            case 1:
                                //UPDATE
                                Transformer.updateTable(table,new ArrayList<>(),);
                                break;
                            case 2:
                                //DELETE
                                Transformer.deleteOfTable(table,);
                                break;
                            case 3:

                                Transformer.insertOnTable(table,data);
                                //INSERT
                                break;
                            default:
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
