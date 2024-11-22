package Model;

import java.util.Objects;

public class FullData {
    private String nameActor;
    private String birthdayActor;
    private String nameDirector;
    private String birthdayDirector;
    private String nameFilm;
    private int year;
    private String genre;
    private float duration;
    private String synopsis;

    public FullData(String nameActor, String birthdayActor, String nameDirector, String birthdayDirector, String nameFilm, int year, String genre, float duration, String synopsis) {
        this.nameActor = nameActor;
        this.birthdayActor = birthdayActor;
        this.nameDirector = nameDirector;
        this.birthdayDirector = birthdayDirector;
        this.nameFilm = nameFilm;
        this.year = year;
        this.genre = genre;
        this.duration = duration;
        this.synopsis = synopsis;
    }

    public String getNameActor() {
        return nameActor;
    }

    public void setNameActor(String nameActor) {
        this.nameActor = nameActor;
    }

    public String getBirthdayActor() {
        return birthdayActor;
    }

    public void setBirthdayActor(String birthdayActor) {
        this.birthdayActor = birthdayActor;
    }

    public String getNameDirector() {
        return nameDirector;
    }

    public void setNameDirector(String nameDirector) {
        this.nameDirector = nameDirector;
    }

    public String getBirthdayDirector() {
        return birthdayDirector;
    }

    public void setBirthdayDirector(String birthdayDirector) {
        this.birthdayDirector = birthdayDirector;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullData fullData = (FullData) o;
        return year == fullData.year && Float.compare(duration, fullData.duration) == 0 && Objects.equals(nameActor, fullData.nameActor) && Objects.equals(birthdayActor, fullData.birthdayActor) && Objects.equals(nameDirector, fullData.nameDirector) && Objects.equals(birthdayDirector, fullData.birthdayDirector) && Objects.equals(nameFilm, fullData.nameFilm) && Objects.equals(genre, fullData.genre) && Objects.equals(synopsis, fullData.synopsis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameActor, birthdayActor, nameDirector, birthdayDirector, nameFilm, year, genre, duration, synopsis);
    }

    @Override
    public String
    toString() {
        return "FullData{" +
                "nameActor='" + nameActor + '\'' +
                ", birthdayActor='" + birthdayActor + '\'' +
                ", nameDirector='" + nameDirector + '\'' +
                ", birthdayDirector='" + birthdayDirector + '\'' +
                ", nameFilm='" + nameFilm + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }
}
