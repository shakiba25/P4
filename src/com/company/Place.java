package com.company;

import java.io.Serializable;

public class Place implements Serializable {

    private String Name;
    private String Addres;

    public Place(String name,String addres ) {
        this.Name = name;
        this.Addres = addres;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddres() {
        return Addres;
    }

    public void setAddres(String addres) {
        Addres = addres;
    }
}
