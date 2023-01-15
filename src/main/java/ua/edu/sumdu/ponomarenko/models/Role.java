package ua.edu.sumdu.ponomarenko.models;

public class Role {
    private int id;
    private String name;

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id == 2) {
            this.name = "USER_CUSTOMER";
        }
        if (id == 3) {
            this.name = "ROLE_EXECUTOR";
        }
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
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
