package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class ADMIN extends Person implements Serializable {

    private ArrayList<Restaurant> restaurantList = new ArrayList<>();
    private ArrayList<Coffee> coffeesList = new ArrayList<>();

    public ADMIN(String name, String lastName, String user, String pass, String phoneNumber) {
        super(name, lastName, user, pass, phoneNumber);
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurantList;
    }

    public void setRestaurants(Restaurant restaurant) {
        restaurantList.add(restaurant);
    }

    public ArrayList<Coffee> getCoffees() {
        return coffeesList;
    }

    public void setCoffees(Coffee coffees) {
        coffeesList.add(coffees);
    }


}
