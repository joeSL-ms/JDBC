package Controller;

import Model.GetPublicIp;
import Model.ScannerSJ;
import Model.Choice;

import java.sql.SQLException;
import java.util.ArrayList;


public class MainController {
    public static void run() throws SQLException {
        boolean malicious = false;
        String table = null;
        String user;
        String psw;
        String database;
        int day;
        int month;
        int year;
        int sl = 0;
        //ArrayData
        ArrayList<String> columns;

        ScannerSJ usu = new ScannerSJ();
        do {
            sl = ControllerMenu.sesionDB();//Numeric election, dont admit string
            switch (sl) {
                case 1:
                    do {
                        //Data whitch need to be secure(Method to protected this door)
                        user = usu.toString("Indica el nombre de usuario de la base de datos");
                        psw = usu.toString("Inserta tu contraseña");
                        database = usu.toString("Como se llama la base de datos que vas a acceder?");
                        Transformer.initDB(user, psw, database);
                        if (Transformer.isConnect()) {
                            ControllerDBFilms.initDBMain();
                            Transformer.createTables();
                        }
                    } while (!Transformer.isConnect());
                    do {
                        if (Transformer.isConnect()) {
                            sl = ControllerMenu.mainMenu();//Numeric election, don't admit string
                            switch (sl) {
                                case 1://CRUD
                                    do {
                                        //Options that you can do.
                                        sl = ControllerMenu.crudMenu();//Numeric election, don't admit string
                                        switch (sl) {
                                            case 1:
                                                //UPDATE
                                                table = ControllerMenu.uniqInfo(Transformer.showTables());//Numeric election, don't admit string
                                                //First show columns that table have it
                                                //Need to be controlled, sql injection possibility(Class to be protected:Choice)
                                                columns = ControllerMenu.multiInfo(Transformer.showColumns(table), "Cuantas columnas vas a modificar?");
                                                //Need to be controlled, sql injection possibility(Class to be protected:Choice)
                                                ArrayList<String> valuesup = Choice.newValues(columns);
                                                malicious = Transformer.securityData(valuesup);
                                                if (malicious) {
                                                    System.out.println("No vuelvas a intentar poner un codigo malicioso :)");
                                                    Transformer.disconnect();
                                                    GetPublicIp.getIP();
                                                } else {
                                                    Transformer.updateTable(table, columns, Choice.newValues(columns), usu.toInt("Indica la ID que deseas cambiar"));
                                                }
                                                break;
                                            case 2:
                                                //DELETE
                                                table = ControllerMenu.uniqInfo(Transformer.showTables());//Numeric election, don't admit string
                                                //Need to be controlled, sql injection possibility(Class to be protected:Choice)
                                                Transformer.deleteOfTable(table, usu.toInt("Indica la ID que deseas borrar"));
                                                break;
                                            case 3:
                                                //INSERT
                                                table = ControllerMenu.uniqInfo(Transformer.showTables());//Numeric election, don't admit string
                                                //Need to be controlled, sql injection possibility(Class to be protected:Choice)
                                                ArrayList<String> valuesin = Choice.newValues(Transformer.showColumns(table));
                                                malicious = Transformer.securityData(valuesin);
                                                if (malicious) {
                                                    System.out.println("No vuelvas a intentar poner un codigo malicioso :)");
                                                    Transformer.disconnect();
                                                    GetPublicIp.getIP();
                                                } else {
                                                    Transformer.insertOnTable(table, Choice.newValues(Transformer.showColumns(table)));
                                                }
                                                break;
                                            default:
                                                System.out.println("La opcion elegida no se reconoce, vuelva a intentarlo" +
                                                        "Si se ha equivocado vuelva a atras :)");
                                                break;
                                        }
                                    } while (sl != 4 && !malicious);


                                    break;
                                case 2:
                                    //SHOW ALL DATA
                                    Transformer.showAllTables();
                                    break;
                                case 3:
                                    //SEARCH INFO BY DATE
                                    //This case is controlled by class Date(class personalize by joe)
                                    day = usu.toInt("Elige un dia");
                                    month = usu.toInt("Elige un mes");
                                    year = usu.toInt("Elige un año");
                                    table = ControllerMenu.uniqInfo(Transformer.showTables());
                                    Transformer.showTableByDate(table, year, month, day);
                                    break;
                                case 4:
                                    //GOOGLE SEARCH
                                    //Need to be controlled, sql injection possibility
                                    String data = usu.toString("Que vas a buscar?");
                                    malicious = Transformer.securityData(data);
                                    if (malicious) {
                                        System.out.println("No vuelvas a intentar poner un codigo malicioso :)");
                                        Transformer.disconnect();
                                        GetPublicIp.getIP();
                                    } else {
                                        Transformer.showDataSearch(data);
                                    }
                                    break;
                                case 5:
                                    //EXIT
                                    Transformer.disconnect();
                                    System.out.println("Hasta pronto");
                                default:
                                    break;
                            }
                        }
                    } while (sl != 5 && !malicious);
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Gracias, hasta la proxima ^^");
                    break;
                default:
                    System.out.println("Ha ingresado un valor erroneo");
                    break;
            }
        } while (sl != 3 && !malicious);
    }
}
