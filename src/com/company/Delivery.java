package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Delivery extends Person implements Serializable {

    private ArrayList<Sefaresh> ListSefareshat = new ArrayList<>();

    public Delivery(String name, String lastName, String user, String pass, String phoneNumber) {
        super(name, lastName, user, pass, phoneNumber);
    }

    public ArrayList<Sefaresh> getListSefareshat() {

        return ListSefareshat;
    }

    public void setListSefareshat(ArrayList<Sefaresh> listSefareshat) {
        ListSefareshat = listSefareshat;
    }
}
