package Model;

import java.util.List;
import java.util.Objects;

public class Actor {
    private int id;
    private String name;
    private String birthday;

    public Actor(int id, String name, String birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public Actor(List<String> data) {
        this.id = Integer.parseInt(data.get(0));
        this.name = data.get(1);
        this.birthday = data.get(2);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actors = (Actor) o;
        return id == actors.id && Objects.equals(name, actors.name) && Objects.equals(birthday, actors.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthday);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
