package com.company.client;

import com.company.*;
import com.company.Daavat.DavatController;
import com.company.KifPool.KifPoolController;
import com.company.Login.LoginPageController;
import com.company.SabadeKharid.SabadeKharidController;
import com.company.SabtSefaresh.SabtSefareshController;
import com.company.Sefareshat.SefareshatController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

public class ClientPageController {
    @FXML
    private Text HelloTXT;

    @FXML
    private Button KifPoolFLD;

    @FXML
    private Button SKhBTN;

    @FXML
    private Button NextBTN;

    @FXML
    private TextField LocationFLD;

    @FXML
    private ListView<Coffee> CoffeeList;

    @FXML
    private ListView<Restaurant> RestList;

    private Stage stage;
    private Client client;

    public void initFunction(Stage stage , Client client){
        this.client = client;
        this.stage = stage;
        AddInfo();
    }

    private void AddInfo(){
        HelloTXT.setText("Hello " + client.getName() );
    }

    @FXML
    private void NextBTNHandler(ActionEvent event){
        if( !LocationFLD.getText().isEmpty()){
            CoffeeList.getItems().clear();
            RestList.getItems().clear();

            for (int i=0 ; i< Main.admin.getCoffees().size() ; i++){
               if(Main.admin.getCoffees().get(i).getAddres().equals(LocationFLD.getText()))
               {CoffeeList.getItems().add(Main.admin.getCoffees().get(i));}
            }
            for (int i=0 ; i< Main.admin.getRestaurants().size() ; i++){
                if(Main.admin.getRestaurants().get(i).getAddres().equals(LocationFLD.getText()))
                {RestList.getItems().add(Main.admin.getRestaurants().get(i));}
            }

        }
    }

    @FXML
    public void RListhandle(MouseEvent click) {

        System.out.print("handle\n");
        if (click.getClickCount() == 2) {
            System.out.print("2click\n");
            Restaurant selected = RestList.getSelectionModel().getSelectedItem();
            SabtRestaurant(selected);
            System.out.print(selected+"\n");

        }
    }
    @FXML
    public void CListhandle(MouseEvent click) {

        System.out.print("handle\n");
        if (click.getClickCount() == 2) {
            System.out.print("2click\n");
            Coffee selected = CoffeeList.getSelectionModel().getSelectedItem();
            SabtCoffee(selected);
            System.out.print(selected+"\n");

        }
    }

    private void SabtCoffee(Coffee coffee){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../SabtSefaresh/SabtSefareshPage.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        SabtSefareshController controller = loader.getController();
        controller.initFunction(this.stage , this.client , null , coffee  );
        stage.setScene(new Scene(loader.getRoot()));
    }

    private void SabtRestaurant(Restaurant restaurant){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../SabtSefaresh/SabtSefareshPage.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        SabtSefareshController controller = loader.getController();
        controller.initFunction(this.stage , this.client , restaurant , null  );
        stage.setScene(new Scene(loader.getRoot()));
    }
    @FXML
    private void BackHAndler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Login/LoginPage.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        LoginPageController controller = loader.getController();
        controller.initFunction(stage);
        stage.setScene(new Scene(loader.getRoot()));
    }
    @FXML
    private void SabadeKharid(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../SabadeKharid/SabadeKharid.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        SabadeKharidController controller = loader.getController();
        controller.initFunction(stage , this.client);
        stage.setScene(new Scene(loader.getRoot()));
    }

    @FXML
    private void KifPool(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../KifPool/KifPoolPage.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        KifPoolController controller = loader.getController();
        controller.initFunction(stage , this.client);
        stage.setScene(new Scene(loader.getRoot()));
    }
    @FXML
    private void DavatDosstan(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Daavat/DavatPage.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        DavatController controller = loader.getController();
        controller.initFunction(stage , this.client);
        stage.setScene(new Scene(loader.getRoot()));
    }
    @FXML
    private void Sefareshat(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Sefareshat/Sefareshat.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        SefareshatController controller = loader.getController();
        controller.initFunction(stage , this.client);
        stage.setScene(new Scene(loader.getRoot()));
    }

    public void backHAndler(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Login/LoginPage.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        LoginPageController controller = loader.getController();
        controller.initFunction(stage);
        stage.setScene(new Scene(loader.getRoot()));}
}




