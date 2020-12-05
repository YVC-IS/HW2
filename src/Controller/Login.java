package controller;

import application.Main;
import application.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.List;

public class Login {
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

    @FXML
    void click() {
        try {
            for (User user : User.read()) {
                if (user.getType().equalsIgnoreCase(this.type.getValue()) &&
                        user.getUser().equals(this.user.getText()) &&
                        user.getPass().equals(this.pass.getText())) {
                    Main.load("Admin");
                    return;
                }
            }
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setContentText("Enter Valid UserID or Password");
            alert.show();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
