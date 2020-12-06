package controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class StudentPageCantroller {

    @FXML
    private TableView<?> _studentTable;

    @FXML
    private Button _getStatusBtn;

    @FXML
    private Button _returnBtn;

    @FXML
    void _getStatus() {

    }

    @FXML
    void _returnToMain() {
        Main.load("Login");
    }

}
