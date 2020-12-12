package controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.Data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Admin {
    @FXML
    private Button _returnBtn;

    @FXML
    private TableView<Data> _adminTable;

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
    private Button _getDataBtn;

    @FXML
    void _getData() {
        _adminTable.setEditable(true);

        _studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        _studentIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        _studentNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        _studentNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());


        _studentCourseColumn.setCellValueFactory(new PropertyValueFactory<>("Course"));
        _studentCourseColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        _studentClassColumn.setCellValueFactory(new PropertyValueFactory<>("Klass"));
        _studentClassColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        _studentGradeColumn.setCellValueFactory(new PropertyValueFactory<>("Garde"));
        _studentGradeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        System.out.println(Arrays.toString(Login.data.toArray()));

        _adminTable.setItems(Login.data);

        //This will allow the table to select multiple rows at once
        _adminTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //System.out.println(Arrays.toString(Login.lstData.toArray()));
    }

    @FXML
    void _returnToMenu()  {
        Main.load("Login");
    }

    @FXML
    void _saveData() {
        try (FileOutputStream file = new FileOutputStream("admin.ser")) {
            try (ObjectOutputStream object = new ObjectOutputStream(file)) {
                object.writeObject(new ArrayList<>(Login.data));
                object.flush();
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @FXML
    void _changeId(TableColumn.CellEditEvent event) {
        Data dataSelected = _adminTable.getSelectionModel().getSelectedItem();
        dataSelected.setId(event.getNewValue().toString());
    }

    @FXML
    void _changeName(TableColumn.CellEditEvent event) {
        Data dataSelected = _adminTable.getSelectionModel().getSelectedItem();
        dataSelected.setName(event.getNewValue().toString());
    }

    @FXML
    void _changeCourse(TableColumn.CellEditEvent event) {
        Data dataSelected = _adminTable.getSelectionModel().getSelectedItem();
        dataSelected.setCourse(event.getNewValue().toString());
    }

    @FXML
    void _changeClassroom(TableColumn.CellEditEvent event) {
        Data dataSelected = _adminTable.getSelectionModel().getSelectedItem();
        dataSelected.setKlass(event.getNewValue().toString());
    }

    @FXML
    void _changeGrade(TableColumn.CellEditEvent event) {
        Data dataSelected = _adminTable.getSelectionModel().getSelectedItem();
        dataSelected.setGarde(event.getNewValue().toString());
    }
}
