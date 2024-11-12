package Controller;

import body.Consults;
import body.DB;

import javax.swing.plaf.PanelUI;
import java.sql.SQLException;

public class Transformer {
    //this class
    private static DB db;
    private static void initDB(){}
    private static String columnas(String tablename) {
        return db.getColumans(tablename);
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
    public static void alterTable(){
        Consults.alter();
    }
    public static void updateTable(){
        Consults.update();
    }
    public static void deleteTable(){
        Consults.delete();
    }
    public static void insertTable(){
        Consults.insert();
    }
}
