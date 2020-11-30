package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

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

}
