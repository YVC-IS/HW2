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

        System.out.println(Arrays.toString(Login.lstData.toArray()));

        _adminTable.setItems(Login.lstData);

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
        for (Data data : Login.lstData) {
            data.write(data.getId());
        }
    }

    public void _changeCourse(TableColumn.CellEditEvent cellEditEvent) {
    }

    public void _changeClass(TableColumn.CellEditEvent cellEditEvent) {
    }

    public void _changeGrade(TableColumn.CellEditEvent cellEditEvent) {
    }
}