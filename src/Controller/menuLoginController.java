package Controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class menuLoginController {

    @FXML
    private Button adminBtn;

    @FXML
    private Button studentBtn;

    @FXML
    private Button teacherBtn;

    @FXML
    void goToAdminLogin() {

    	Main.menuSwitch("Admin");
    }

}