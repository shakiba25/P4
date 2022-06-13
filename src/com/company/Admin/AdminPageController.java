package com.company.Admin;

import com.company.AddRC.AddController;
import com.company.EditRC.ChooseController;
import com.company.EditRC.EditPageController;
import com.company.Login.LoginPageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminPageController {

    private javafx.stage.Stage Stage;

    public void initFunction(Stage stage){
        this.Stage = stage;
    }

    @FXML
    private void AddHAndler(ActionEvent event){                             // Add restaurant or coffeeshop page
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../AddRC/AddPage.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        AddController controller = loader.getController();
        controller.initFunction(Stage);
        Stage.setScene(new Scene(loader.getRoot()));
    }


    @FXML
    private void EditHandler(ActionEvent event){                               // show choosepage for select item for edit
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../EditRC/ChoosePage.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        ChooseController controller = loader.getController();
        controller.initFunction(Stage);
        Stage.setScene(new Scene(loader.getRoot()));
    }


    @FXML
    private void backHAndler(ActionEvent event){                          // back to login page
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Login/LoginPage.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        LoginPageController controller = loader.getController();
        controller.initFunction(Stage);
        Stage.setScene(new Scene(loader.getRoot()));
    }

}
