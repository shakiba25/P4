package com.company.Login;

import com.company.Admin.AdminPageController;
import com.company.Client;
import com.company.Delivery;
import com.company.DeliveryPage.DeliveryConproller;
import com.company.Main;
import com.company.StartPage.StartPageController;
import com.company.client.ClientPageController;
import com.sun.jmx.remote.internal.ClientListenerInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPageController {
    @FXML
    private Button LoginBTN;

    @FXML
    private TextField UserFLD;

    @FXML
    private TextField PassFLD;

    @FXML
    private Button BackBTN;

    private Stage Stage;

    public void initFunction(Stage stage){
        this.Stage = stage;
    }

    @FXML
    private void LoginBTNHandler(ActionEvent event){
        Login();
    }


    private void Login(){

        for (int i=0 ; i< Main.Clientlist.size() ; i++){

            if(Main.Clientlist.get(i).getPass().equals(PassFLD.getText()) &&Main.Clientlist.get(i).getUser().equals(UserFLD.getText()) ){
                LoginClient(Main.Clientlist.get(i));
            }
        }
        for (int i=0 ; i< Main.Deliverylist.size() ; i++){
            if(Main.Deliverylist.get(i).getPass().equals(PassFLD.getText()) &&Main.Deliverylist.get(i).getUser().equals(UserFLD.getText()) ){
                LoginDelivery(Main.Deliverylist.get(i));
            }
        }

        if(Main.admin.getPass().equals(PassFLD.getText())&&Main.admin.getUser().equals(UserFLD.getText())){
            LoginAdmin();
        }

    }

    private void LoginDelivery(Delivery delivery) {                        // if was delivery show delivery page
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../DeliveryPage/Delivery.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        DeliveryConproller controller = loader.getController();
        controller.initFunction(Stage , delivery);
        Stage.setScene(new Scene(loader.getRoot()));
    }

    private void LoginAdmin(){                                   // if was Admin show Admin page

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Admin/AdminPage.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        AdminPageController controller = loader.getController();
        controller.initFunction(Stage);
        Stage.setScene(new Scene(loader.getRoot()));

    }
    private void LoginClient(Client client){                                   // if was Client show Client page
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../client/ClientPage.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        ClientPageController controller = loader.getController();
        controller.initFunction(Stage , client);
        Stage.setScene(new Scene(loader.getRoot()));
    }



    @FXML
    private void BackBTNHandler(ActionEvent event){                            // back to stsrtPage

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../StartPage/StartPage.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        StartPageController controller = loader.getController();
        controller.initFunction(Stage);
        Stage.setScene(new Scene(loader.getRoot()));
    }
}
