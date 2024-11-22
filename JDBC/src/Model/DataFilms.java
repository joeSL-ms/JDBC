package Model;

import java.util.ArrayList;
import java.util.Objects;

public class DataFilms {
    private ArrayList<FullData> data;

    public DataFilms() {
        this.data = new ArrayList<>();
    }

    public ArrayList<FullData> getData() {
        return data;
    }

    public void setData(ArrayList<FullData> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataFilms dataFilms = (DataFilms) o;
        return Objects.equals(data, dataFilms.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }

    @Override
    public String toString() {
        return "DataFilms{" +
                "data=" + data +
                '}';
    }
}
