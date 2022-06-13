package com.company;

import java.util.ArrayList;

public class Client extends Person{

    private String KifPool;
    private ArrayList<Sefaresh> sefareshList = new ArrayList<>();
    private ArrayList<Sefaresh> SabadeKharid = new ArrayList<>();

    public Client(String name, String lastName, String user, String pass, String phoneNumber) {
        super(name, lastName, user, pass, phoneNumber);
    }

    public String getKifPool() {
        return KifPool;
    }
    public void SetKifPool(String pool){
        this.KifPool = pool;
    }

    public void setKifPool(String kifPool) {
        KifPool = kifPool;
    }

    public ArrayList<Sefaresh> getSefareshList() {
        return sefareshList;
    }
    public ArrayList<Sefaresh> getSabadeKharid() {
        return SabadeKharid;
    }

    public void setSefareshList(Sefaresh sefaresh) {
        sefareshList.add(sefaresh);
    }

    public void setSabadeKharid(Sefaresh sefaresh) {
        SabadeKharid.add(sefaresh);
    }

    @Override
    public String toString() {
        return "Client{"  + super.getName()+
                '}';
    }
}
