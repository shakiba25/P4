package com.company.StartPage;

import com.company.Login.LoginPageController;
import com.company.Signin.SigninPageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class StartPageController {

    @FXML
    private Button LoginBTN;

    @FXML
    private Button SignupBTN;

    private Stage Stage;

    public void initFunction(Stage stage){
    this.Stage = stage;
}

    @FXML
    private void LoginHandler(ActionEvent event){                              //load loginPAge

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

    @FXML
    private void SigninHandler(ActionEvent event){                       //load Sighnin Page

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Signin/SigninPage.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        SigninPageController controller = loader.getController();
        controller.initFunction(Stage);
        Stage.setScene(new Scene(loader.getRoot()));

    }

}
