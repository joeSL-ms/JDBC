package Model;

import java.util.List;
import java.util.Objects;

public class Genre {
    private int id;
    private String genre;

    public Genre(int id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    public Genre(List<String> data) {
        this.id = Integer.parseInt(data.get(0));
        this.genre = data.get(1);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genres = (Genre) o;
        return id == genres.id && Objects.equals(genre, genres.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genre);
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                '}';
    }
}
