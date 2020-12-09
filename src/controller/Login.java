package controller;

import application.Main;
import application.User;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public void initialize() {
        this.type.setValue("Choose Option");
        this.type.setItems(this.types);
    }

    private String _userType; // this is a variable for collecting type of User for switch case bellow
    @FXML
    void click() {
        try {
            for (User user : User.read()) {
                if (user.getType().equalsIgnoreCase(this.type.getValue()) &&
                        user.getUser().equals(this.user.getText()) &&
                        user.getPass().equals(this.pass.getText())) {
                        _userType = this.type.getValue();


                        switch (_userType)
                        {
                            case "Student" -> { Main.load("Student",null) ;break; }
                            case "Admin" -> {Main.load("Admin",null); break;}
                            case "Lecturer" -> {
                                Main.load("Lecturer", null); break;}
                    }
                        return;
                }
            }

            setAlert();  // Alert function' see bellow
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }


    }

    // Its better to see it as separate function lol

    private void setAlert ()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setContentText("Enter Valid UserID or Password");
        alert.show();
    }
}
