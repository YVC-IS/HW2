package controller;

import application.Main;
import application.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import model.Data;

public class Login {
    public static ObservableList<Data> data = null;

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
        this.type.setItems(FXCollections.observableArrayList("Admin", "Lecturer", "Practitioner", "Student"));
    }

    @FXML
    void click() {
        try {
            for (User user : User.read()) {
                if (this.validType(user) && this.validUser(user) && this.validPass(user)) {
                    switch (this.type.getValue())
                    {
                        case "Admin" -> {
                            Login.load("data/admin.ser");
                            Main.load("Admin");
                        }
                        case "Lecturer" -> {
                            Login.load("data/lecturer.ser");
                            Main.load("Lecturer");
                        }
                        case "Practitioner" -> {
                            Login.load("data/practitioner.ser");
                            Main.load("Practitioner");
                        }
                        case "Student" -> {
                            Login.load("data/student.ser");
                            Main.load("Student");
                        }
//                        Data data1 = new Data("1", "nizar", "java", "A", "");
//                        Data data2 = new Data("2", "murad", "java", "B", "");
//                        Data data3 = new Data("3", "gaston", "java", "A", "");
//                        Data data4 = new Data("4", "denis", "java", "A", "97");
//                        Data data5 = new Data("5", "idan", "java", "B", "92");
//                        Login.data = FXCollections.observableArrayList(data1, data2, data3, data4, data5);
                    }
                    return;
                }
            }

            setAlert();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private boolean validType(User user) {
        return user.getType().equalsIgnoreCase(this.type.getValue());
    }

    private boolean validUser(User user) {
        return user.getUser().equals(this.user.getText());
    }

    private boolean validPass(User user) {
        return user.getPass().equals(this.pass.getText());
    }

    private static void load(String name) {
        try (FileInputStream file = new FileInputStream(name)) {
            try (ObjectInputStream object = new ObjectInputStream(file)) {
                List<Data> list = (ArrayList<Data>) object.readObject();
                Login.data = FXCollections.observableArrayList(list);
            }
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void setAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setContentText("Enter Valid UserID or Password");
        alert.show();
    }
}
