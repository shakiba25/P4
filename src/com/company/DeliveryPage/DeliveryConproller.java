package com.company.DeliveryPage;

import com.company.Coffee;
import com.company.Delivery;
import com.company.Food;
import com.company.Login.LoginPageController;
import com.company.Restaurant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class DeliveryConproller {
    @FXML
    private Text HelloTXT;

    @FXML
    private Button BackBTN;

    @FXML
    private VBox Vbox;
    private Delivery delivery;
    private Stage stage;

    public void initFunction(Stage stage , Delivery delivery ){
        this.stage = stage;
        this.delivery = delivery;
        Add();
    }
    private void Add(){                                                      // add sefareshat to admin page
        HelloTXT.setText("Hello " + delivery.getName());
        if(delivery.getListSefareshat()!=null){
        for (int i=0 ; i<delivery.getListSefareshat().size() ; i++){
            Food food = delivery.getListSefareshat().get(i).getFood();
            Restaurant R = delivery.getListSefareshat().get(i).getRestaurant();
            Coffee C = delivery.getListSefareshat().get(i).getCoffee();
            Text RC = new Text();
            if(R!=null){RC.setText("Restaurant => " +R.getName());}
            if(C!=null){RC.setText("CoffeeShop => " +C.getName());}
            Text NameClient = new Text("NameClient  => "
                    + delivery.getListSefareshat().get(i).getClient().getName() +delivery.getListSefareshat().get(i).getClient().getLastName() );
            Text Name = new Text("Name  => " + food.getName());
            Text Price = new Text("Price => " +food.getMoney());

            VBox vBox = new VBox(RC, NameClient , Name , Price);

            TextFlow foodTextFlow = new TextFlow(vBox);
            Vbox.getChildren().add(foodTextFlow);
            foodTextFlow.setPrefWidth(vBox.getPrefWidth());
            foodTextFlow.setPrefHeight(vBox.getPrefHeight());

            vBox.setSpacing(20);

            vBox.setPadding( new Insets(10,10,10,10));
            foodTextFlow.setStyle("-fx-border-color: #5F9EA0");
            foodTextFlow.setStyle("-fx-background-color:  #D3D3D3");

            Vbox.setPadding( new Insets(10,10,10,10));
            foodTextFlow.setPadding( new Insets(10,10,10,10));
            Vbox.setMargin(foodTextFlow , new Insets(10,10,10,10));

        }}
    }

    @FXML
    public void backHAndler(ActionEvent event) {                          // Back to login page
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
