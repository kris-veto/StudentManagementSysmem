package org.example.week2;
import javafx.fxml.FXML;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    @FXML
    private StringProperty name;
    @FXML
    private StringProperty surname;
    @FXML
    private StringProperty id;
    @FXML
    private StringProperty major;

    public Student(String name, String surname, String id, String major) {
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.id = new SimpleStringProperty(id);
        this.major = new SimpleStringProperty(major);

    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getMajor() {
        return major.get();
    }

    public StringProperty majorProperty() {
        return major;
    }

    public void setMajor(String major) {
        this.major.set(major);
    }
}

