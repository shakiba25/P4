package com.company;

import java.io.Serializable;

public class Person implements Serializable {

    private String Name;
    private String LastName;
    private String User;
    private String Pass;
    private String PhoneNumber;

    public Person(String name,String lastName , String user , String pass , String phoneNumber) {
        this.Name = name;
        this.LastName = lastName;
        this.Pass = pass;
        this.PhoneNumber = phoneNumber;
        this.User = user;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
