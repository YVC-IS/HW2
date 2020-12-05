package controller;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import javax.swing.*;

public class menuLoginController {

    ObservableList list = FXCollections.observableArrayList("Admin","Teacher","Assistant","Student");

    @FXML
    private TextField _userIdText;

    @FXML
    private TextField _passwordIdText;

    @FXML
    private Button _loginBtn;

    @FXML
    private ChoiceBox<String> _choiseBox;

    public void initialize ()
    {
        _choiseBox.setValue("Choose Option");
        _choiseBox.setItems(list);
    }


    @FXML
    void _LoginAction() {

        _userIdText.getText();
        _passwordIdText.getText();
        String user = _choiseBox.getValue();
        System.out.println(user);
        if ((user.equals("Admin"))&& (_userIdText.getText().equals("ADMIN")) && (_passwordIdText.getText().equals("ADMIN")))

        {
            Main.load("Admin");
        }
        else
            {
                Alert alrt = new Alert(Alert.AlertType.ERROR);
                alrt.setTitle("Error Message");
                alrt.setContentText("Enter Valid UserID or Password");
                alrt.show();
            }
    }

}
