package controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import model.Person;

public class LecturerPageController {

    @FXML
    private Button _returnBtn;

    @FXML
    private TableColumn<Person, Integer> _studentIdColumn;

    @FXML
    private TableColumn<Person, String> _studentNameColumn;

    @FXML
    private TableColumn<?, ?> _studentCourseColumn;

    @FXML
    private TableColumn<?, ?> _studentClassColumn;

    @FXML
    private TableColumn<?, ?> _studentGradeColumn;

    @FXML
    private Button _saveBtn;

    @FXML
    void _returnToMenu() { Main.load("Login"); }

    @FXML
    void _saveData() {

    }

}