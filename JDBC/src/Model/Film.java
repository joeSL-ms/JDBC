package Model;

import java.util.List;
import java.util.Objects;

public class Film {
    private int id;
    private String title;
    private int year;


    public Film(int id, String title, int year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }

    public Film(List<String> data) {
        this.id = Integer.parseInt(data.get(0));
        this.title = data.get(1);
        this.year = Integer.parseInt(data.get(2));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film films = (Film) o;
        return id == films.id && year == films.year && Objects.equals(title, films.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
