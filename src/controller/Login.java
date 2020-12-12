package controller;

import application.Main;
import data.User;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import model.Data;

public class Login {
    public static ObservableList<Data> lstData;
    private final ObservableList<String> types = FXCollections.observableArrayList("Admin", "Lecturer", "Practitioner", "Student");

    @FXML
    private ChoiceBox<String> type;

    @FXML
    private TextField user;

    @FXML
    private PasswordField pass;

    @FXML
    private Button login;

    @FXML
    public void initialize() {
        this.type.setValue("Choose Option");
        this.type.setItems(this.types);
    }

    @FXML
    void click() {
        try {
            for (User user : User.read()) {
                if (user.getType().equalsIgnoreCase(this.type.getValue()) &&
                        user.getUser().equals(this.user.getText()) &&
                        user.getPass().equals(this.pass.getText())) {

                    switch (this.type.getValue())
                    {
                        case "Student" -> Main.load("Student");
                        case "Admin" -> Main.load("Admin");
                        case "Lecturer" -> {
                            Data data1 = new Data("1","tt","aa","cc","ff");
                            Data data2 = new Data("2","dd","bb","dd","hh");
                            ObservableList<Data> data = FXCollections.observableArrayList(data1, data2);
                            lstData = data;
                            Main.load("Lecturer");
                        }
                    }
                    return;
                }
            }

            setAlert();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void setAlert ()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setContentText("Enter Valid UserID or Password");
        alert.show();
    }
}
