package Model;

import java.util.List;
import java.util.Objects;

public class Fdirector {
    private int idFilm;
    private int idDirector;

    public Fdirector(int idFilm, int idDirector) {
        this.idFilm = idFilm;
        this.idDirector = idDirector;
    }

    public Fdirector(List<String> strings) {
        this.idFilm = Integer.parseInt(strings.get(0));
        this.idDirector = Integer.parseInt(strings.get(1));
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(int idDirector) {
        this.idDirector = idDirector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fdirector that = (Fdirector) o;
        return idFilm == that.idFilm && idDirector == that.idDirector;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFilm, idDirector);
    }

    @Override
    public String toString() {
        return "Fdirector{" +
                "idFilm=" + idFilm +
                ", idDirector=" + idDirector +
                '}';
    }
}
