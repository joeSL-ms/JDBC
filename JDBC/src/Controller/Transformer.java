package Controller;

import body.Consults;
import body.DB;

import java.sql.SQLException;
import java.util.ArrayList;

public class Transformer {
    //this class
    private static DB db;

    private static void initDB() {
    }

    private static String columns(String tablename) {
        return db.getColumans(tablename);
    }

    public static void initDB(String username, String password, String database, String servername) {
        db = new DB(username, database, password, servername);
        try {
            db.connection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initDB(String username, String password, String database) {
        db = new DB(username, database, password);
        try {
            db.connection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateTable(String tablename, ArrayList<String> columns, ArrayList<String> values, int id) {
        Consults.update(tablename, columns, values, id);
    }

    public static void deleteOfTable(String tablename, int id) {
        Consults.delete(tablename, id);
    }

    public static void insertOnTable(String tablename, ArrayList<String> data) {
        Consults.insert(tablename, columns(tablename), data);
    }

    public static void showColumns(String tablename){
        System.out.println("Las columnas de la tabla" + tablename + "son: " + columns(tablename));
    }

    public static ArrayList<String> showTables(){
        return db.getTables();
    }

    public static void getData(){

    }
}
