package controller;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.Data;


import java.util.Arrays;
import java.util.SortedMap;
import java.util.stream.Collectors;

public class LecturerPageController{

    // private ObservableList<Data> oldData = FXCollections.observableArrayList ();
    private ObservableList<Data> newData = FXCollections.observableArrayList ();


/*    private void cloneTheData (ObservableList<Data> data)
    {
        for (Data d: Login.lstData)
        {
            oldData.add(new Data(d));
        }
    }*/


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
    void _returnToMenu() { Main.load("Login",null); }



    @FXML
    private Button _getDataBtn;



    @FXML
    void _getData() {

        // cloneTheData(Login.lstData);
        newData = Login.lstData;

        _lecturerTable.setEditable(true);

        _studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));


        _studentNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));


        _studentCourseColumn.setCellValueFactory(new PropertyValueFactory<>("Course"));
        _studentCourseColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        _studentClassColumn.setCellValueFactory(new PropertyValueFactory<>("Klass"));
        _studentClassColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        _studentGradeColumn.setCellValueFactory(new PropertyValueFactory<>("Garde"));
        _studentGradeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        System.out.println(Arrays.toString(Login.lstData.toArray()));

        _lecturerTable.setItems(newData);


        //This will allow the table to select multiple rows at once
        _lecturerTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //System.out.println(Arrays.toString(Login.lstData.toArray()));

    }




    @FXML
    void _changeClass(TableColumn.CellEditEvent event) {

        Data dataSelected = _lecturerTable.getSelectionModel().getSelectedItem();
        dataSelected.setKlass(event.getNewValue().toString());
        //System.out.println(Arrays.toString(Login.lstData.toArray()));

    }

    @FXML
    void _changeCourse(TableColumn.CellEditEvent event) {

        Data dataSelected = _lecturerTable.getSelectionModel().getSelectedItem();
        dataSelected.setCourse(event.getNewValue().toString());
        //System.out.println(Arrays.toString(Login.lstData.toArray()));

    }

    @FXML
    void _changeGrade(TableColumn.CellEditEvent event) {

        Data dataSelected = _lecturerTable.getSelectionModel().getSelectedItem();
        dataSelected.setGarde(event.getNewValue().toString());
        //System.out.println(Arrays.toString(Login.lstData.toArray()));

    }

    @FXML
    void _saveData() {

        System.out.println(Arrays.toString(Login.lstData.toArray()));

    }




/*
    @FXML
    void _getDataForCancelation( ObservableList<Data> data) {

         ObservableList<Data> canceledData = FXCollections.observableArrayList (data);


        _lecturerTable.setEditable(true);

        _studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));


        _studentNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));


        _studentCourseColumn.setCellValueFactory(new PropertyValueFactory<>("Course"));
        _studentCourseColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        _studentClassColumn.setCellValueFactory(new PropertyValueFactory<>("Klass"));
        _studentClassColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        _studentGradeColumn.setCellValueFactory(new PropertyValueFactory<>("Garde"));
        _studentGradeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        System.out.println(Arrays.toString(Login.lstData.toArray()));

        _lecturerTable.setItems(canceledData);




    }*/

}
