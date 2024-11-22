package Model;

import java.util.ArrayList;

public class Consults {
    public static String update(String tablename, ArrayList<String> columns, ArrayList<String> values, int id) {
        String consult = "UPDATE " + tablename + " " +
                "SET " + columnValue(columns, values) + " " +   //Depends on number of columns
                condition() + id + ";";
        return consult;
    }

    public static String delete(String tablename, int id) {
        String consult = "DELETE FROM " + tablename + condition() + id + ";";
        return consult;
    }

    public static String insert(String tablename, String columns, ArrayList<String> data) {
        String consult = "INSERT INTO " + tablename + " (" + columns + ") " + "VALUES" + " (" + alldata(data) + ");";
        return consult;
    }

    private static String columnValue(ArrayList<String> columns, ArrayList<String> values) {
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < columns.size(); i++) {
            content.append(columns.get(i)).append(" = '").append(values.get(i) + "'");
        }
        return String.valueOf(content);
    }

    private static String condition() {
        return " WHERE ID = ";
    }

    private static String alldata(ArrayList<String> contenido) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < contenido.size(); i++) {
            if (i == 0) {
                result.append(contenido.get(i));
            } else {
                result.append(",'").append(contenido.get(i)).append("'");
            }
        }

        return result.toString();
    }
}
