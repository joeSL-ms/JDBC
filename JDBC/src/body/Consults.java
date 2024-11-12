package body;

import java.util.ArrayList;

public class Consults {
    public static void create(String tablename, ArrayList<String> columnas) {
        String consult = "CREATE TABLE " + tablename + "(" + alldata(columnas) + ");";
    }
    public static void alter(){
        String consult = "";
    }
    public static void update(String tablename, ArrayList<String> columns, ArrayList<String> values){
        String consult = "UPDATE" + tablename + "\n" +
                "SET" + columnValue(columns,values) + "\n" +   //Depends on number of columns
                "WHERE condición;";     //Depends on number of conditions, need to be specific
    }
    public static void delete(String tablename, String columns, ArrayList<String> data){
        String consult = "DELETE FROM tabla_nombre WHERE condición;";
    }
    public static void insert(String tablename, String columns, ArrayList<String> data) {
        String consult = "INSERT INTO " + tablename + "(" + columns + ")" + "VALUES" + "(" + alldata(data) + ")";
    }
    private static String columnValue(ArrayList<String> columns, ArrayList<String> values){
        StringBuilder content = new StringBuilder();
        for (int i = 0 ; i < columns.size() ; i++){
            content.append(columns.get(i)).append(" = ").append(values.get(i));
        }
        return String.valueOf(content);
    }
    private static String alldata(ArrayList<String> contenido){
        return String.join(",", contenido);
    }
}
