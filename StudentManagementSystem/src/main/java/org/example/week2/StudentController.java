package org.example.week2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField idField;

    @FXML
    private TextField majorField;

    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> surnameColumn;

    @FXML
    private TableColumn<Student, String> idColumn;

    @FXML
    private TableColumn<Student, String> majorColumn;

    //For Error message display
    @FXML
    private Label message;

    private ObservableList<Student> studentData = FXCollections.observableArrayList();

    @FXML
    private void addStudent(ActionEvent event) {
        String name = nameField.getText();
        String surname = surnameField.getText();
        String major = majorField.getText();
        String id = idField.getText();

        //check if the fields are empty
        if(id.isEmpty()||name.isEmpty()||surname.isEmpty()||major.isEmpty()){
            //if not all the fields are input
            message.setText("Please fill in all info.");
        } else {
            Student newStudent = new Student(name,surname,id, major);
            studentData.add(newStudent);
            clearFields();
        }
    // Create a new Student from text field data
    // Add the new Student to the table
    }

    private void clearFields() {
        idField.clear();
        nameField.clear();
        surnameField.clear();
        majorField.clear();
    }

    @FXML
    private void deleteStudent(ActionEvent event) {

        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if(selectedStudent == null){
            message.setText("Please select an item to delete.");
        }else {
            studentData.remove(selectedStudent);
        }

        // Delete the selected Student from the table
        studentTable.getItems().remove(studentTable.getSelectionModel().getSelectedItem());

    }
    @FXML
    public void initialize() {

        // Initialize the table
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        majorColumn.setCellValueFactory(new PropertyValueFactory<>("major"));
        //link the student table with the student data list
        studentTable.setItems(studentData);

        studentTable.setPlaceholder(new Label("No rows to display"));

    }
}