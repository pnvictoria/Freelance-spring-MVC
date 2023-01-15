package ua.edu.sumdu.ponomarenko.models;

public class Account {

    private int id;
    private String email;
    private String password;
    private String phone;
    private String description;
    private Country country;
    private Role role;
    private String name;
    private String surname;
    private Boolean sex;

    public Account() {

    }

    public Account(int id) {
        this.id = id;
    }

    public Account(String email) {
        this.email = email;
    }

    public Account(int id, String email, String password, String phone, String description,
                   Country country, Role role, String name, String surname, Boolean sex) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.description = description;
        this.country = country;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                ", country=" + country +
                ", role=" + role +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex=" + sex +
                '}';
    }
}
