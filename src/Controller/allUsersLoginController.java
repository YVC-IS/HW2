package Controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class allUsersLoginController  {


    // -------------------------------------------    Admin  -------------------------------------------



    @FXML
    private TextField _adminLoginUserName;

    @FXML
    private PasswordField _adminLoginPassword;

    @FXML
    private Button _adminLoginBtnEnter;

    @FXML
    private Button _adminLoginBtnCancel;

    @FXML
    void _adminBtnCancelClick() {

        Main.menuSwitch("Menu");

    }


    //-------------------------------------------------- Teacher  -------------------------------------------


    @FXML
    private TextField _teacherLoginUserName;

    @FXML
    private PasswordField _teacherLoginPassword;

    @FXML
    private Button _teacherLoginBtnEnter;

    @FXML
    private Button _teacherLoginBtnCancel;

    @FXML
    void _teacherLoginBtnCancelClick()
    {
        Main.menuSwitch("Menu");

    }


//-------------------------------------------------- Student  -------------------------------------------


    @FXML
    private TextField _studentLoginUserName;

    @FXML
    private PasswordField _studentLoginPassword;

    @FXML
    private Button _studentLoginBtnEnter;

    @FXML
    private Button _studentLoginBtnCancel;

    @FXML
    void _studentLoginBtnCancelClick()
    {

        Main.menuSwitch("Menu");

    }


}
