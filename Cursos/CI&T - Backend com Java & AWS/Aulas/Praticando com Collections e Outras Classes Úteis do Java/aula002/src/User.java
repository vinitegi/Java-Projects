import java.util.Objects;

import static java.util.Objects.hash;
import static java.util.Objects.isNull;

public class User {
    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return String.format("{'id': %s, 'name': %s}", id, name);
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) return true; // ve se aponta para o msm endereco de memoria
        if ((isNull(obj)) || (!(obj instanceof User user))) return false; //se ele nao for a instancia de usuario
        return this.id == user.getId() && Objects.equals(user.getName(), this.getName());
    }

    @Override
    public int hashCode() {
        return hash(this.id, this.name);

    }

}
