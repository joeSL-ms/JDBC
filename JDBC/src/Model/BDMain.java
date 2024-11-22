package Model;

import java.util.ArrayList;
import java.util.Objects;

public class BDMain {
    ArrayList<Actor> actors;
    ArrayList<Director> directors;
    ArrayList<Genre> genres;
    ArrayList<Film> films;
    ArrayList<Detail> details;
    ArrayList<Factor> fActors;
    ArrayList<Fgenre> fGenres;
    ArrayList<Fdirector> fDirectors;

    public BDMain() {
        this.actors = new ArrayList<Actor>();
        this.directors = new ArrayList<Director>();
        this.genres = new ArrayList<Genre>();
        this.details = new ArrayList<Detail>();
        this.fActors = new ArrayList<Factor>();
        this.fGenres = new ArrayList<Fgenre>();
        this.fDirectors = new ArrayList<Fdirector>();
        this.films = new ArrayList<Film>();
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public ArrayList<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayList<Director> directors) {
        this.directors = directors;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    public ArrayList<Detail> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<Detail> details) {
        this.details = details;
    }

    public ArrayList<Factor> getfActors() {
        return fActors;
    }

    public void setfActors(ArrayList<Factor> fActors) {
        this.fActors = fActors;
    }

    public ArrayList<Fgenre> getfGenres() {
        return fGenres;
    }

    public void setfGenres(ArrayList<Fgenre> fGenres) {
        this.fGenres = fGenres;
    }

    public ArrayList<Fdirector> getfDirectors() {
        return fDirectors;
    }

    public void setfDirectors(ArrayList<Fdirector> fDirectors) {
        this.fDirectors = fDirectors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BDMain bdMain = (BDMain) o;
        return Objects.equals(actors, bdMain.actors) && Objects.equals(directors, bdMain.directors) && Objects.equals(genres, bdMain.genres) && Objects.equals(films, bdMain.films) && Objects.equals(details, bdMain.details) && Objects.equals(fActors, bdMain.fActors) && Objects.equals(fGenres, bdMain.fGenres) && Objects.equals(fDirectors, bdMain.fDirectors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actors, directors, genres, films, details, fActors, fGenres, fDirectors);
    }

    @Override
    public String toString() {
        return "BDMain{" +
                "actors=" + actors +
                ", directors=" + directors +
                ", genres=" + genres +
                ", films=" + films +
                ", details=" + details +
                ", fActors=" + fActors +
                ", fGenres=" + fGenres +
                ", fDirectors=" + fDirectors +
                '}';
    }

    public void addActor(Actor item){
        this.actors.add(item);
    }
    public void addDirector(Director item){
        this.directors.add(item);
    }
    public void addGenres(Genre item){
        this.genres.add(item);
    }
    public void addDetails(Detail item){
        this.details.add(item);
    }
    public void addFActors(Factor item){
        this.fActors.add(item);
    }
    public void addFGenres(Fgenre item){
        this.fGenres.add(item);
    }
    public Actor getActor(int pos){
        return getActors().get(pos);
    }
    public Director getDirector(int pos){
        return getDirectors().get(pos);
    }
    public Genre getGenre(int pos){
        return getGenres().get(pos);
    }
    public Detail getDetail(int pos){
        return getDetails().get(pos);
    }
    public Film getFilm(int pos){
        return getFilms().get(pos);
    }
    public void showDataSearch(String word){
        //Estrucutra de stream con ayuda de gpt
        long count = 0;
        count += getActors().stream()
                .filter(a -> a.getName().toLowerCase().contains(word.toLowerCase()))
                .peek(a -> System.out.println(a.toString()))
                .count();
        count += getDirectors().stream()
                .filter(d -> d.getName().toLowerCase().contains(word.toLowerCase()))
                .peek(d -> System.out.println(d.toString())).count();

        count += getGenres().stream()
                .filter(g -> g.getGenre().toLowerCase().contains(word.toLowerCase()))
                .peek(g -> System.out.println(g.toString()))
                .count();

        count += getFilms().stream()
                .filter(f -> f.getTitle().toLowerCase().contains(word.toLowerCase()))
                .peek(f -> System.out.println(f.toString()))
                .count();

        count += getDetails().stream()
                .filter(d -> d.getSynopsis().toLowerCase().contains(word.toLowerCase()))
                .peek(d -> System.out.println(d.toString()))
                .count();
        if (count == 0){
            System.out.println("No hay ninguna referencia");
        }
    }
    public void addFDirectors(Fdirector item){
        this.fDirectors.add(item);
    }
    public void addFilms(Film item){
        this.films.add(item);
    }
}