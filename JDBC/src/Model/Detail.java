package Model;

import java.util.List;
import java.util.Objects;

public class Detail {
    private int id_film;
    private float duration;
    private String synopsis;

    public Detail(int id_film, float duration, String synopsis) {
        this.id_film = id_film;
        this.duration = duration;
        this.synopsis = synopsis;
    }
    public Detail(List<String> data) {
        this.id_film = Integer.parseInt(data.get(0));
        this.duration = Float.parseFloat(data.get(1));
        this.synopsis = data.get(2);
    }

    public int getId_film() {
        return id_film;
    }

    public void setId_film(int id_film) {
        this.id_film = id_film;
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
        Detail details = (Detail) o;
        return id_film == details.id_film && Float.compare(duration, details.duration) == 0 && Objects.equals(synopsis, details.synopsis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_film, duration, synopsis);
    }

    @Override
    public String toString() {
        return "Details{" +
                "id_film=" + id_film +
                ", duration=" + duration +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }
}
