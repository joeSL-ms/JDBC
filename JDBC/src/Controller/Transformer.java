package Controller;

import data.DB;

import java.sql.SQLException;
import java.util.ArrayList;

public class Transformer {
    private static DB db;
    public static void create(String tablename, ArrayList<String>columnas) {
        String consult = "CREATE TABLE " + tablename + "(" + alldata(columnas) + ")";
    }

    public static void insert(String tablename, ArrayList<String> data) {
        String consult = "INSERT INTO " + tablename + "(" + columnas(tablename) + ")" + "VALUES" + "(" + alldata(data) + ")";
    }
    private static void initDB(){
    }
    public static void initDB(String username,String password,String database, String servername){
        db = new DB(username,database,password,servername);
        try {
            db.connection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void initDB(String username,String password,String database){
        db = new DB(username,database,password);
        try {
            db.connection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static String columnas(String tablename) {
        return db.getColumans(tablename);
    }
    private static String alldata(ArrayList<String> contenido){
        return String.join(",", contenido);
    }
}
