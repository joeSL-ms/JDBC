package Controller;

import Model.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Transformer {
    //this class
    private static DB db;
    private static ArrayList<String> datas = new ArrayList<>();
    private static ArrayList<FullData> viewdata = new ArrayList<>();

    private static String columns(String tablename) {
        return alldata(db.getColumans(tablename));
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
            db.closeConnection();
            throw new RuntimeException(e);
        }
    }

    public static void createTables() throws SQLException {
        for (String table : showTables()) {
            switch (table) {
                case "actores":
                    ControllerDBFilms.crateActor(showColumns(table).size(), db.extracDataFromTable(table));
                    break;
                case "detalles":
                    ControllerDBFilms.crateDetails(showColumns(table).size(), db.extracDataFromTable(table));
                    break;
                case "directores":
                    ControllerDBFilms.crateDirectors(showColumns(table).size(), db.extracDataFromTable(table));
                    break;
                case "generos":
                    ControllerDBFilms.crateGenres(showColumns(table).size(), db.extracDataFromTable(table));
                    break;
                case "peliculas":
                    ControllerDBFilms.crateFilms(showColumns(table).size(), db.extracDataFromTable(table));
                    break;
                case "peliculas_actores":
                    ControllerDBFilms.crateFActor(showColumns(table).size(), db.extracDataFromTable(table));
                    break;
                case "peliculas_directores":
                    ControllerDBFilms.crateFDirectors(showColumns(table).size(), db.extracDataFromTable(table));
                    break;
                case "peliculas_generos":
                    ControllerDBFilms.crateFGenres(showColumns(table).size(), db.extracDataFromTable(table));
                    break;
            }
        }
    }


    public static void updateTable(String tablename, ArrayList<String> columns, ArrayList<String> values, int id) {
        db.udiTables(Consults.update(tablename, columns, values, id));
    }

    public static void deleteOfTable(String tablename, int id) {
        db.udiTables(Consults.delete(tablename, id));
    }

    public static void insertOnTable(String tablename, ArrayList<String> data) {
        db.udiTables(Consults.insert(tablename, columns(tablename), data));
    }

    public static ArrayList<String> showColumns(String tablename) {
        return db.getColumans(tablename);
    }

    public static ArrayList<String> showTables() {
        return db.getTables();
    }

    public static void showAllTables() {
        if (viewdata.isEmpty()) {
            viewdata = ControllerFullData.fullData();
        }
        ControllerFullData.showViewData();
    }

    private static String alldata(ArrayList<String> contenido) {
        return String.join(",", contenido);
    }

    public static boolean isConnect() {
        return db.isConnect();
    }

    public static void disconnect() {
        db.closeConnection();
    }

    public static void getData() {

    }

    public static void showTableByDate(String table, int year, int month, int day) {
        Datejs date = new Datejs(day, month, year);
        if (date.isValid()) {
            //uso de localDate con un poco de ayuda de gpt sobre como usarlo
            switch (table) {
                case "actores":
                    ControllerDBFilms.getActors().forEach(g -> {
                        LocalDate dt = LocalDate.parse(g.getBirthday(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        LocalDate dtd = LocalDate.parse(date.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        if (dt.isAfter(dtd)) {
                            System.out.println(g.toString());
                        }
                    });
                    break;
                case "directores":
                    ControllerDBFilms.getDirectors().forEach(d -> {
                        LocalDate dt = LocalDate.parse(d.getBirthday(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        LocalDate dtd = LocalDate.parse(date.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        if (dt.isAfter(dtd)) {
                            System.out.println(d.toString());
                        }
                    });
                    break;
                case "peliculas":
                    ControllerDBFilms.getFilms().forEach(p -> {
                        if (p.getYear() > date.getYear()) {
                            System.out.println(p.toString());
                        }
                    });
                    break;
            }
        } else {
            System.out.println("ha habido un error");
        }
    }

    public static void showDataSearch(String word) {
        ControllerDBFilms.showDataSearch(word);
    }

    public static boolean securityData(String data) {

        String[] cases = {".+=.+", ".+'.+", ".+OR.+", ".+AND.+", ".+WHERE.+"};
        boolean malicious = false;
        int i = 0;
        String ptn = "";
        Pattern p = null;
        Matcher m = null;


        do {
            ptn = cases[i];
            p = Pattern.compile(ptn);
            m = p.matcher(data.toUpperCase());
            if (m.matches()) {
                malicious = true;
            }
            i++;
        } while (i > cases.length);

        if (data.contains("'")) {
            datas.add(data);
            System.out.println("Nice try to do malicious code");
            Transformer.disconnect();
            malicious = true;
        }
        return malicious;
    }

    public static boolean securityData(ArrayList<String> data) {

        String[] cases = {".+=.+", ".+'.+", ".+OR.+", ".+AND.+", ".+WHERE.+"};
        boolean malicious = false;
        int i = 0;
        String ptn = "";
        Pattern p = null;
        Matcher m = null;

        do {
            ptn = cases[i];
            for (String dt : data) {
                p = Pattern.compile(ptn);
                m = p.matcher(dt.toUpperCase());
                if (m.matches()) {
                    malicious = true;
                }
            }
            i++;
        } while (i < cases.length);
        for (String dt : data) {
            if (data.contains("'")) {
                datas.add(dt);
                System.out.println("Nice try to do malicious code");
                Transformer.disconnect();
                malicious = true;
            }
        }
        return malicious;
    }
}
