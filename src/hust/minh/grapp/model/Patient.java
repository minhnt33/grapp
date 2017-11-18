package hust.minh.grapp.model;

import java.util.Date;

public class Patient {
    public enum Gender {MALE, FEMALE, OTHER}

    private int _id;
    private String _firstName;
    private String _lastName;
    private Gender _gender;
    private Date _dob;
    private String _address;
    private String _phoneNumber;
    private String _email;

    public  Patient(int id)
    {
        _id = id;
    }

}
