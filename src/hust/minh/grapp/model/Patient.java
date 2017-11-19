package hust.minh.grapp.model;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Patient {
    private final IntegerProperty _id;
    private final StringProperty _firstName;
    private final StringProperty _lastName;
    private final StringProperty _gender;
    private final ObjectProperty<LocalDate> _dob;
    private final StringProperty _address;
    private final StringProperty _phoneNumber;
    private final StringProperty _email;

    public Patient(int id) {
        _id = new SimpleIntegerProperty(id);
        _firstName = new SimpleStringProperty("Minh");
        _lastName = new SimpleStringProperty("Nguyen");
        _gender = new SimpleStringProperty("Male");
        _dob = new SimpleObjectProperty(LocalDate.of(1995, 3, 3));
        _address = new SimpleStringProperty("Hanoi");
        _phoneNumber = new SimpleStringProperty("1234567890");
        _email = new SimpleStringProperty("minh@gmail.com");
    }

    public void setFirstName(String firstName) {
        _firstName.set(firstName);
    }

    public void setLastName(String lastName) {
        _lastName.set(lastName);
    }

    public void setGender(String gender) {
        _gender.set(gender);
    }

    public void setBirthdate(int year, int month, int day) {
        _dob.set(LocalDate.of(year, month, day));
    }

    public void setAddress(String address) {
        _address.set(address);
    }

    public void setPhoneNumber(String phoneNumber) {
        _phoneNumber.set(phoneNumber);
    }

    public void setEmail(String email) {
        _email.set(email);
    }

    public int getId() {
        return _id.get();
    }

    public String getFirsName() {
        return _firstName.get();
    }

    public String getLasName() {
        return _lastName.get();
    }

    public String getGender() {
        return _gender.get();
    }

    public LocalDate getBirthdate() {
        return _dob.get();
    }

    public String getAddress() {
        return _address.get();
    }

    public String getPhoneNumber() {
        return _phoneNumber.get();
    }

    public String getEmail() {
        return _email.get();
    }

    public IntegerProperty getIdProp() {
        return _id;
    }

    public StringProperty getFirstNameProp() {
        return _firstName;
    }

    public StringProperty getLastNameProp() {
        return _lastName;
    }

    public StringProperty getGenderProp() {
        return _gender;
    }

    public ObjectProperty<LocalDate> getBirthDateProp() {
        return _dob;
    }

    public StringProperty getAddressProp() {
        return _address;
    }

    public StringProperty getPhoneNumberProp() {
        return _phoneNumber;
    }

    public StringProperty getEmailProp() {
        return _email;
    }
}
