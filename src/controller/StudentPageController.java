package controller;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import model.Person;
import model.Student;

import java.time.LocalDate;
import java.util.Arrays;
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
        System.out.println(Arrays.toString(students.toArray()));


        //This will allow the table to select multiple rows at once
        _studentTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    void _returnToMain() {
        Main.load("Login",null);
    }




    @FXML
    void _onEditChanged(TableColumn.CellEditEvent<Student,String> event) {

        Student st = _studentTable.getSelectionModel().getSelectedItem();


    }


    /**
     * This method will remove the selected row(s) from the table
     */


    public void deleteButtonPushed()
    {
        ObservableList<Student> selectedRows, allPeople;
        allPeople = _studentTable.getItems();

        //this gives us the rows that were selected
        selectedRows = _studentTable.getSelectionModel().getSelectedItems();

        //loop over the selected rows and remove the Person objects from the table
        for (Student st: selectedRows)
        {
            allPeople.remove(st);
        }
    }


    /**
     * This method will create a new Student object and add it to the table
     */
    public void newStudentButtonPushed()
    {
        Student newStudent = new Student(_columnName.getText(),new Date());

        //Get all the items from the table as a list, then add the new student to
        //the list
        _studentTable.getItems().add(newStudent);
    }

}
