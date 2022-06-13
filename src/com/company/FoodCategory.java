package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class FoodCategory implements Serializable {

     private String nameFoodCategory;
     private String Id;
     private OR RS;
     private ArrayList<Food> FoodList = new ArrayList<>();

    public FoodCategory(String nameFoodCategory, String id, OR RS) {
        this.nameFoodCategory = nameFoodCategory;
        this.Id = id;
        this.RS = RS;
    }

    public String getNameFoodCategory() {
        return nameFoodCategory;
    }

    public void setNameFoodCategory(String nameFoodCategory) {
        this.nameFoodCategory = nameFoodCategory;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public OR getRS() {
        return RS;
    }

    public void setRS(OR RS) {
        this.RS = RS;
    }

    public ArrayList<Food> getFoodList() {
        return FoodList;
    }

    public void setFoodList(Food food) {
        FoodList.add(food);
    }

    @Override
    public String toString() {
        return "FoodCategory{"  + nameFoodCategory + '\'' +
                '}';
    }
}
