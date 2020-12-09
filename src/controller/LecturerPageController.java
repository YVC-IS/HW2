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
import model.Person;
import model.Student;

import java.util.Arrays;

public class LecturerPageController {

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
    void _saveData() {

    }

    @FXML
    private Button _getDataBtn;


    Data data1 = new Data("1","tt","aa","cc","ff");
    Data data2 = new Data("2","dd","bb","dd","hh");
    ObservableList<Data> data = FXCollections.observableArrayList (
            data1,
            data2);

    //  List<Data> lst1 = new ArrayList<>();
    //  lst1.add(data1);
    //  lst1.add(data2);


    @FXML
    void _getData() {

        _lecturerTable.setEditable(true);
        _studentCourseColumn.setCellValueFactory(new PropertyValueFactory<Data,String>("Course"));
       // _studentCourseColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        _studentClassColumn.setCellValueFactory(new PropertyValueFactory<Data,String>("Klass"));
       // _studentClassColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        _studentGradeColumn.setCellValueFactory(new PropertyValueFactory<Data,String>("Grade"));
        //_studentGradeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        System.out.println(Arrays.toString(data.toArray()));

        _lecturerTable.setItems(data);


        //This will allow the table to select multiple rows at once
        //_lecturerTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //System.out.println(Arrays.toString(Login.lstData.toArray()));

    }

}