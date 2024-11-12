package body;

import java.util.Objects;

public class Farmacos {
    private int ID;
    private String doctor;
    private String medicamentos;
    private String fecha;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Farmacos{" +
                "ID=" + ID +
                ", doctor='" + doctor + '\'' +
                ", medicamentos='" + medicamentos + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Farmacos farmacos = (Farmacos) o;
        return getID() == farmacos.getID() && Objects.equals(getDoctor(), farmacos.getDoctor()) && Objects.equals(getMedicamentos(), farmacos.getMedicamentos()) && Objects.equals(getFecha(), farmacos.getFecha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getDoctor(), getMedicamentos(), getFecha());
    }
}
