package com.company;

import javafx.application.Platform;

import java.io.Serializable;

public class Sefaresh implements Serializable {

    private Client client;
    private Restaurant restaurant;
    private Coffee coffee;
    private Food food;
    private String Star;
    private boolean running100;
    private boolean running50;
    private int S ;

    public Sefaresh(Restaurant restaurant, Coffee coffee, Food food , Client client) {
        this.restaurant = restaurant;
        this.coffee = coffee;
        this.food = food;
        this.client = client;

    }

    public Client getClient() {
        return client;
    }

    public boolean getRunning50(){return this.running50;}
    public boolean getRunning100(){return this.running100;}

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setStar(int a){
        if(a==0){ Star = "✩✩✩✩✩";  }
        if(a==1){ Star = "★✩✩✩✩";  }
        if(a==2){ Star = "★★✩✩✩";  }
        if(a==3){ Star = "★★★✩✩";  }
        if(a==4){ Star = "★★★★✩";  }
        if(a==5){ Star = "★★★★★";  }
    }
    public String getStar(){
        return Star;
    }

    @Override
    public String toString() {
        String place = null;
        if(restaurant!=null){
            place = ", restaurant= " + restaurant.toString();
        }
        if (coffee!=null){
            place =  ", coffee= " + coffee.toString();
        }
        return "Sefaresh{" +
                  place +
                ", food=" + food.getName() +
                ", Price=" + food.getMoney() +
                '}';
    }
    public void StartHandler( ){

        this.running100 = true;
        this.running50 = true;

        S = 0;

        Thread thread = new Thread(() -> {
            for(;;){try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        S = S + 1;
                        System.out.print(S);
                    }

                });
            }catch (Exception e){
                System.out.print(e.getMessage());
            }


                if(running50){

                    if(S==60){
                        this.running50=false;
                        System.out.print(running50);
                    }
                    if(S==30){
                        System.out.print(running100);
                        this.running100=false;
                    }

                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }}else{
                    break;
                }

            }});thread.start();


    }
}
