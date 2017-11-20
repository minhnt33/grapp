package hust.minh.grapp.model;

import hust.minh.grapp.util.LocalDateAdapter;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

public class Patient {
    private final StringProperty id;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty gender;
    private final ObjectProperty<LocalDate> dob;
    private final StringProperty address;
    private final StringProperty phoneNumber;
    private final StringProperty email;

    public Patient() {
        id = new SimpleStringProperty(null);
        firstName = new SimpleStringProperty(null);
        lastName = new SimpleStringProperty(null);
        gender = new SimpleStringProperty(null);
        dob = new SimpleObjectProperty(null);
        address = new SimpleStringProperty(null);
        phoneNumber = new SimpleStringProperty(null);
        email = new SimpleStringProperty(null);
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public void setBirthdate(int year, int month, int day) {
        this.dob.set(LocalDate.of(year, month, day));
    }

    public void setBirthdate(LocalDate date)
    {
        dob.set(date);
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getId() {
        return id.get();
    }

    public String getFirstName() {
        return firstName.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public String getGender() {
        return gender.get();
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getBirthdate() {
        return dob.get();
    }

    public String getAddress() {
        return address.get();
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty getIdProp() {
        return id;
    }

    public StringProperty getFirstNameProp() {
        return firstName;
    }

    public StringProperty getLastNameProp() {
        return lastName;
    }

    public StringProperty getGenderProp() {
        return gender;
    }

    public ObjectProperty<LocalDate> getBirthDateProp() {
        return dob;
    }

    public StringProperty getAddressProp() {
        return address;
    }

    public StringProperty getPhoneNumberProp() {
        return phoneNumber;
    }

    public StringProperty getEmailProp() {
        return email;
    }
}
