package Controller;

import body.Consults;
import body.DB;

import javax.swing.plaf.PanelUI;
import java.sql.SQLException;
import java.util.ArrayList;

public class Transformer {
    //this class
    private static DB db;
    private static void initDB(){}
    private static String columns(String tablename) {
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
    public static void updateTable(String tablename, ArrayList<String> columns, ArrayList<String> values, int id){
        Consults.update(tablename,columns,values,id);
    }
    public static void deleteTable(String tablename, int id){
        Consults.delete(tablename,id);
    }
    public static void insertTable(String tablename, columns(), ArrayList<String> data){
        Consults.insert(tablename,columns,data);
    }
}
