package com.company;

import java.util.ArrayList;

public class Restaurant extends Place{

    private Delivery Delivery;
    private ArrayList<FoodCategory> foodCategoryList = new ArrayList<>();

    public Restaurant(String name, String addres , Delivery  delivery) {
        super(name, addres);
        this.Delivery = delivery;

    }
    public ArrayList<FoodCategory> getFoodCategoryList() {
        return foodCategoryList;
    }

    public void setFoodCategoryList(FoodCategory foodCategory) {
        foodCategoryList.add(foodCategory);
    }

    public com.company.Delivery getDelivery() {
        return Delivery;
    }

    @Override
    public String toString() {
        return "Restaurant{ "+super.getName()+" }";
    }
}
