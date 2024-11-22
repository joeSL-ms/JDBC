package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.List;

public class ControllerDBFilms {
    private static BDMain dbMain;

    public static BDMain getDBMain() {
        return dbMain;
    }

    public static void initDBMain() {
        dbMain = new BDMain();
    }

    public static void crateActor(int columns, ArrayList<List<String>> data) {
        for (int i = 0; i < data.size(); i++) {
            dbMain.addActor(new Actor(data.get(i)));
        }
    }

    public static void crateDirectors(int columns, ArrayList<List<String>> data) {
        for (int i = 0; i < data.size(); i++) {
            dbMain.addDirector(new Director(data.get(i)));
        }
    }

    public static void crateGenres(int columns, ArrayList<List<String>> data) {
        for (int i = 0; i < data.size(); i++) {
            dbMain.addGenres(new Genre(data.get(i)));
        }
    }

    public static void crateFilms(int columns, ArrayList<List<String>> data) {
        for (int i = 0; i < data.size(); i++) {
            dbMain.addFilms(new Film(data.get(i)));
        }
    }

    public static void crateDetails(int columns, ArrayList<List<String>> data) {
        for (int i = 0; i < data.size(); i++) {
            dbMain.addDetails(new Detail(data.get(i)));
        }
    }

    public static void crateFActor(int columns, ArrayList<List<String>> data) {
        for (int i = 0; i < data.size(); i++) {
            dbMain.addFActors(new Factor(data.get(i)));
        }
    }

    public static void crateFGenres(int columns, ArrayList<List<String>> data) {
        for (int i = 0; i < data.size(); i++) {
            dbMain.addFGenres(new Fgenre(data.get(i)));
        }
    }

    public static void crateFDirectors(int columns, ArrayList<List<String>> data) {
        for (int i = 0; i < data.size(); i++) {
            dbMain.addFDirectors(new Fdirector(data.get(i)));
        }
    }

    public static Actor getActor(int pos) {
        return dbMain.getActor(pos);
    }

    public static Director getDirector(int pos) {
        return dbMain.getDirector(pos);
    }

    public static Genre getGenre(int pos) {
        return dbMain.getGenre(pos);
    }

    public static Detail getDetail(int pos) {
        return dbMain.getDetail(pos);
    }

    public static Film getFilm(int pos) {
        return dbMain.getFilm(pos);
    }

    public static void showDataSearch(String word) {
        dbMain.showDataSearch(word);
    }

    public static ArrayList<Actor> getActors() {
        return dbMain.getActors();
    }

    public static ArrayList<Director> getDirectors() {
        return dbMain.getDirectors();
    }

    public static ArrayList<Genre> getGenres() {
        return dbMain.getGenres();
    }

    public static ArrayList<Film> getFilms() {
        return dbMain.getFilms();
    }

    public static ArrayList<Detail> getDetails() {
        return dbMain.getDetails();
    }


}