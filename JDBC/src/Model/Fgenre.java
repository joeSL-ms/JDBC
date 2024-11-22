package Model;

import java.util.List;
import java.util.Objects;

public class Fgenre {
    private int idFilm;
    private int idGenre;

    public Fgenre(int idFilm, int idGenre) {
        this.idFilm = idFilm;
        this.idGenre = idGenre;
    }

    public Fgenre(List<String> data) {
        this.idFilm = Integer.parseInt(data.get(0));
        this.idGenre = Integer.parseInt(data.get(1));
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fgenre fgenres = (Fgenre) o;
        return idFilm == fgenres.idFilm && idGenre == fgenres.idGenre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFilm, idGenre);
    }

    @Override
    public String toString() {
        return "Fgenre{" +
                "idFilm=" + idFilm +
                ", idGenre=" + idGenre +
                '}';
    }
}
