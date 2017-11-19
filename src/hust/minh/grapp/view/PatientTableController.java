package hust.minh.grapp.view;

import hust.minh.grapp.model.Patient;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class PatientTableController {
    @FXML
    private TableView<Patient> _patientTable;

    @FXML
    private TableColumn<Patient, Integer> _idCol;

    @FXML
    private TableColumn<Patient, String> _firstNameCol;

    @FXML
    private TableColumn<Patient, String> _lastNameCol;

    @FXML
    private TableColumn<Patient, LocalDate> _birthDateCol;

    @FXML
    private TableColumn<Patient, String> _genderCol;

    @FXML
    private TableColumn<Patient, String> _addressCol;

    @FXML
    private TableColumn<Patient, String> _phoneNumberCol;

    @FXML
    private TableColumn<Patient, String> _emailCol;

    public PatientTableController() {

    }

    @FXML
    private void initialize() {
        // Set data delegate
        _idCol.setCellValueFactory(cellData -> cellData.getValue().getIdProp().asObject());
        _firstNameCol.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProp());
        _lastNameCol.setCellValueFactory(cellData -> cellData.getValue().getLastNameProp());
        _genderCol.setCellValueFactory(cellData -> cellData.getValue().getGenderProp());
        _birthDateCol.setCellValueFactory(cellData -> cellData.getValue().getBirthDateProp());
        _addressCol.setCellValueFactory(cellData -> cellData.getValue().getAddressProp());
        _phoneNumberCol.setCellValueFactory(cellData -> cellData.getValue().getPhoneNumberProp());
        _emailCol.setCellValueFactory(cellData -> cellData.getValue().getEmailProp());
    }

    public void setTableItems(ObservableList<Patient> patients) {
        _patientTable.setItems(patients);
    }
}
