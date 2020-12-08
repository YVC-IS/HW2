package controller;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import model.Person;
import model.Student;

import java.util.Date;

public class StudentPageController {



    @FXML
    private TableView<Student> _studentTable;


    @FXML
    private TableColumn<Student, Integer> _columnId;

    @FXML
    private TableColumn<Student, String> _columnName;

    @FXML
    private TableColumn<Student, Date> _columnBirthday;

    @FXML
    private Button _getStatusBtn;

    @FXML
    private Button _returnBtn;




    /*public ObservableList<Student> getStudents ()
    {
        ObservableList<Student> students = FXCollections.observableArrayList();

        students.add(new Student("Idan", new Date()));
        return students;
    }
*/

        private ObservableList<Student> students = FXCollections.observableArrayList(

        new Student("Idan", new Date(2000,11,12)),
        new Student("Denis", new Date(2000,12,12)));

    @FXML
    void _getStatus() {
        // have to do that for each column
        _studentTable.setEditable(true); // make the table editable
        _columnName.setCellValueFactory(new PropertyValueFactory<Student,String>("Name")); // on column _columnName set the name of the object (Student)
        _columnName.setCellFactory(TextFieldTableCell.forTableColumn());

        // _columnId.setCellValueFactory(new PropertyValueFactory<Student,Integer>("ID"));
        //_columnBirthday.setCellValueFactory(new PropertyValueFactory<Student,Date>("Birthday"));
        _studentTable.setItems(students);
    }

    @FXML
    void _returnToMain() {
        Main.load("Login");
    }




    @FXML
    void _onEditChanged(TableColumn.CellEditEvent<Student,String> event) {

        Student st = _studentTable.getSelectionModel().getSelectedItem();


    }

}
