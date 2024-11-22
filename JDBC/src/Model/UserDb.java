package Model;

import java.util.Objects;

public class UserDb {
    private String name;
    private String pasw;
    private String ip;

    public UserDb(String name, String pasw, String ip) {
        this.name = name;
        this.pasw = pasw;
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasw() {
        return pasw;
    }

    public void setPasw(String pasw) {
        this.pasw = pasw;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDb userDb = (UserDb) o;
        return Objects.equals(name, userDb.name) && Objects.equals(pasw, userDb.pasw) && Objects.equals(ip, userDb.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pasw, ip);
    }

    @Override
    public String toString() {
        return "UserDb{" +
                "name='" + name + '\'' +
                ", pasw='" + pasw + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
