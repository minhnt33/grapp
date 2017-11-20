package hust.minh.grapp.view;

import hust.minh.grapp.Main;
import hust.minh.grapp.model.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class PatientTableController {
    @FXML
    private TableView<Patient> _patientTable;

    @FXML
    private TableColumn<Patient, String> _idCol;

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

    private Main _main;

    public PatientTableController() {

    }

    @FXML
    private void initialize() {
        // Initialize table data in all columns
        _idCol.setCellValueFactory(cellData -> cellData.getValue().getIdProp());
        _firstNameCol.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProp());
        _lastNameCol.setCellValueFactory(cellData -> cellData.getValue().getLastNameProp());
        _genderCol.setCellValueFactory(cellData -> cellData.getValue().getGenderProp());
        _birthDateCol.setCellValueFactory(cellData -> cellData.getValue().getBirthDateProp());
        _addressCol.setCellValueFactory(cellData -> cellData.getValue().getAddressProp());
        _phoneNumberCol.setCellValueFactory(cellData -> cellData.getValue().getPhoneNumberProp());
        _emailCol.setCellValueFactory(cellData -> cellData.getValue().getEmailProp());
    }

    private void setColumnData(Patient patient) {

    }

    public void showPatientData(Patient patient) {

    }

    @FXML
    private void onClickAdd() {
        Patient tempPerson = new Patient();
        boolean okClicked = _main.showPatientForm(tempPerson);
        if (okClicked) {
            _main.getPatientList().add(tempPerson);
        }
    }

    @FXML
    private void onClickEdit() {
        Patient selectedPerson = _patientTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = _main.showPatientForm(selectedPerson);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(_main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a patient in the table.");

            alert.showAndWait();
        }
    }

    @FXML
    private void onClickRemove() {
        int selectedIndex = _patientTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            _patientTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(_main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a patient in the table.");

            alert.showAndWait();
        }
    }

    public void setMain(Main main) {
        _main = main;
        _patientTable.setItems(main.getPatientList());
    }
}
