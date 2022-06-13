package com.company.SabtSefaresh;

import com.company.*;
import com.company.Admin.AdminPageController;
import com.company.client.ClientPageController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class SabtSefareshController {

    @FXML
    private ListView<FoodCategory> FCList;

    @FXML
    private Text PlaceName;

    @FXML
    private VBox Vbox;

    @FXML
    private Button backBTN;
    private Stage stage;
    private Restaurant restaurant;
    private Coffee coffee;
    private Client client;

    public void initFunction(Stage stage , Client client , Restaurant restaurant , Coffee coffee){
        this.stage = stage;
        this.client = client;
        this.restaurant = restaurant;
        this.coffee = coffee;
        AddFClist();
    }

    private void AddFClist(){
        if(coffee!=null){
            FCList.getItems().clear();
            FCList.getItems().addAll(coffee.getFoodCategoryList());
            PlaceName.setText(coffee.getName() + " Coffee Shop ");
        }
        if(restaurant!=null){
            FCList.getItems().clear();
            FCList.getItems().addAll(restaurant.getFoodCategoryList());
            PlaceName.setText(restaurant.getName() + " Restaurant ");
        }
    }

    @FXML
    public void Listhandle(MouseEvent click) {

        System.out.print("handle\n");

        if (click.getClickCount() == 2) {
            FoodCategory selected = FCList.getSelectionModel().getSelectedItem();
            AddFoodInList(selected);

        }
    }

    private void AddFoodInList(FoodCategory foodCategory){
        Vbox.getChildren().clear();
        for (int i=0 ; i<foodCategory.getFoodList().size() ; i++ ){
            Food food = foodCategory.getFoodList().get(i);
            Text Name = new Text("Name  => " + food.getName());
            Text Price = new Text("Price => " +food.getMoney());
            VBox vBox = new VBox(Name , Price);

            TextFlow foodTextFlow = new TextFlow(vBox);
            Vbox.getChildren().add(foodTextFlow);

            foodTextFlow.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                        if(mouseEvent.getClickCount() == 2){
                            Sefaresh sefaresh = new Sefaresh(restaurant , coffee , food , client );
                            client.setSabadeKharid(sefaresh);

                        }
                    }
                }
            });
            foodTextFlow.setPrefWidth(vBox.getPrefWidth());
            foodTextFlow.setPrefHeight(vBox.getPrefHeight());

            vBox.setSpacing(20);

            vBox.setPadding( new Insets(10,10,10,10));
            foodTextFlow.setStyle("-fx-border-color: #5F9EA0");
            foodTextFlow.setStyle("-fx-background-color: #CFECEC");

            Vbox.setPadding( new Insets(10,10,10,10));
            foodTextFlow.setPadding( new Insets(10,10,10,10));
            Vbox.setMargin(foodTextFlow , new Insets(10,10,10,10));


        }

    }




    @FXML
    private void BackHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../client/clientPage.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        ClientPageController controller = loader.getController();
        controller.initFunction(this.stage , this.client);
        stage.setScene(new Scene(loader.getRoot()));
    }

}
