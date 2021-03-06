package controller;

import application.Main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import model.Data;

public class Lecturer {
    @FXML
    private TableView<Data> _lecturerTable;

    @FXML
    private Button _returnBtn;

    @FXML
    private TableColumn<Data, String> _studentIdColumn;

    @FXML
    private TableColumn<Data, String> _studentNameColumn;

    @FXML
    private TableColumn<Data, String> _studentCourseColumn;

    @FXML
    private TableColumn<Data, String> _studentClassColumn;

    @FXML
    private TableColumn<Data, String> _studentGradeColumn;

    @FXML
    private Button _saveBtn;

    @FXML
    void _returnToMenu() {
        Main.load("Login");
    }

    @FXML
    private Button _getDataBtn;

    @FXML
    void _getData() {
        _lecturerTable.setEditable(true);

        _studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        //_studentIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        _studentNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        //_studentNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        _studentCourseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
        //_studentCourseColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        _studentClassColumn.setCellValueFactory(new PropertyValueFactory<>("classroom"));
        _studentClassColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        _studentGradeColumn.setCellValueFactory(new PropertyValueFactory<>("garde"));
        _studentGradeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        System.out.println(Arrays.toString(Login.data.toArray()));

        _lecturerTable.setItems(Login.data);

        //This will allow the table to select multiple rows at once
        _lecturerTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //System.out.println(Arrays.toString(Login.lstData.toArray()));
    }

    @FXML
    void _changeClass(TableColumn.CellEditEvent event) {
        Data dataSelected = _lecturerTable.getSelectionModel().getSelectedItem();
        dataSelected.setClassroom(event.getNewValue().toString());
        System.out.println(Arrays.toString(Login.data.toArray()));

    }

    @FXML
    void _changeCourse(TableColumn.CellEditEvent event) {

    }

    @FXML
    void _changeGrade(TableColumn.CellEditEvent event) {
        Data dataSelected = _lecturerTable.getSelectionModel().getSelectedItem();
        dataSelected.setGarde(event.getNewValue().toString());
        System.out.println(Arrays.toString(Login.data.toArray()));

    }

    @FXML
    void _saveData() {
        try (FileOutputStream file = new FileOutputStream("data/lecturer.ser")) {
            try (ObjectOutputStream object = new ObjectOutputStream(file)) {
                object.writeObject(new ArrayList<>(Login.data));
                object.flush();
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
