package Model;

import java.util.List;
import java.util.Objects;

public class Factor {
    private int idActor;
    private int idFilms;

    public Factor(int idFilms, int idActor) {
        this.idFilms = idFilms;
        this.idActor = idActor;
    }

    public Factor(List<String> data) {
        this.idFilms = Integer.parseInt(data.get(0));
        this.idActor = Integer.parseInt(data.get(1));
    }

    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    public int getIdFilms() {
        return idFilms;
    }

    public void setIdFilms(int idFilms) {
        this.idFilms = idFilms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factor factors = (Factor) o;
        return idActor == factors.idActor && idFilms == factors.idFilms;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idActor, idFilms);
    }

    @Override
    public String toString() {
        return "Factor{" +
                "idActor=" + idActor +
                ", idFilms=" + idFilms +
                '}';
    }
}
