package hust.minh.grapp.view;

import hust.minh.grapp.model.Patient;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class PatientFormDialogController {
    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField emailField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private RadioButton maleRadioBut;

    @FXML
    private RadioButton femaleRadioBut;

    @FXML
    private RadioButton otherRadioBut;

    @FXML
    private Button okBut;

    @FXML
    private Button cancelBut;

    private final ToggleGroup toggleGroup = new ToggleGroup();
    private String gender;
    private Stage dialogStage;
    private Patient patient;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
        // Set userdata
        maleRadioBut.setUserData("Male");
        femaleRadioBut.setUserData("Female");
        otherRadioBut.setUserData("Other");

        // Create toggle group behaviour
        maleRadioBut.setToggleGroup(toggleGroup);
        femaleRadioBut.setToggleGroup(toggleGroup);
        otherRadioBut.setToggleGroup(toggleGroup);

        // Add change
        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (toggleGroup.getSelectedToggle() != null) {
                    gender = toggleGroup.getSelectedToggle().getUserData().toString();
                }
            }
        });
    }

    @FXML
    private void onClickOk() {
        if (isInputValid()) {
            patient.setFirstName(firstNameField.getText());
            patient.setLastName(lastNameField.getText());
            patient.setAddress(addressField.getText());
            patient.setPhoneNumber(phoneNumberField.getText());
            patient.setEmail(emailField.getText());
            patient.setBirthdate(datePicker.getValue());
            patient.setGender(gender);
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void onClickCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (addressField.getText() == null || addressField.getText().length() == 0) {
            errorMessage += "No valid address!\n";
        }

        String phoneNumber = phoneNumberField.getText();
        if (phoneNumber == null || (!phoneNumber.matches("^[0-9]{10}$") && !phoneNumber.matches("^[0-9]{11}$"))) {
            errorMessage += "No valid phone number!\n";
        }

        String email = emailField.getText();
        if (email == null || email.length() == 0) {
            errorMessage += "No valid email!\n";
        }

        if (gender == null || gender.length() == 0) {
            errorMessage += "No valid gender!\n";
        }

        LocalDate birthdate = datePicker.getValue();
        if (birthdate == null) {
            errorMessage += "No valid birthdate!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    public void setDialogStage(Stage stage) {
        dialogStage = stage;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;

        firstNameField.setText(patient.getFirstName());
        lastNameField.setText(patient.getLastName());
        addressField.setText(patient.getAddress());
        phoneNumberField.setText(patient.getPhoneNumber());
        emailField.setText(patient.getEmail());
        datePicker.setValue(patient.getBirthdate());
        gender = patient.getGender();
        switch (gender) {
            case "Male":
                maleRadioBut.fire();
                break;
            case "Female":
                femaleRadioBut.fire();
                break;
            case "Other":
                otherRadioBut.fire();
                break;
        }
    }

    public boolean isOkClicked() {
        return okClicked;
    }
}
