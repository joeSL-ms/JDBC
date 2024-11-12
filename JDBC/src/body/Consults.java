package body;

import java.util.ArrayList;

public class Consults {
    public static void create(String tablename, ArrayList<String> columnas) {
        String consult = "CREATE TABLE " + tablename + "(" + alldata(columnas) + ");";
    }
    //alter not now
    public static void alter() {
        String consult = "";
    }

    public static String update(String tablename, ArrayList<String> columns, ArrayList<String> values, int id) {
        String consult = "UPDATE" + tablename + "\n" +
                "SET" + columnValue(columns, values) + "\n" +   //Depends on number of columns
                condition() + id + ";";
        return consult;
    }

    public static String delete(String tablename, int id) {
        String consult = "DELETE FROM " + tablename + condition() + id +";";
        return consult;
    }

    public static String insert(String tablename, String columns, ArrayList<String> data) {
        String consult = "INSERT INTO " + tablename + "(" + columns + ")" + "VALUES" + "(" + alldata(data) + ")";
        return consult;
    }

    private static String columnValue(ArrayList<String> columns, ArrayList<String> values) {
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < columns.size(); i++) {
            content.append(columns.get(i)).append(" = ").append(values.get(i));
        }
        return String.valueOf(content);
    }

    private static String condition() {
        return " WHERE ID = ";
    }

    private static String alldata(ArrayList<String> contenido) {
        return String.join(",", contenido);
    }
}
