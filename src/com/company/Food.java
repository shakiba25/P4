package com.company;

import java.io.Serializable;

public class Food implements Serializable {

    String Name;
    String Money;

    public Food(String name, String money) {
        this.Name = name;
        this.Money = money;
    }

    public String getName() {
        return Name;
    }

    public String getMoney() {
        return Money;
    }

    @Override
    public String toString() {
        return "Food{" +
                "Name='" + Name + '\'' +
                '}';
    }
}
