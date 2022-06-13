package com.company.EditRC;

import com.company.AddRC.AddController;
import com.company.Admin.AdminPageController;
import com.company.Coffee;
import com.company.FoodCategory;
import com.company.Main;
import com.company.Restaurant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ChooseController {

    @FXML
    private Button backBTN;

    @FXML
    private ListView<Restaurant> RestList;

    @FXML
    private ListView<Coffee> CoffeeList;
    private Stage Stage;

    public void initFunction(Stage stage){
        this.Stage = stage;
        AddToList();
    }

    public void AddToList(){                                        // add all coffee restaurant to list
        RestList.getItems().clear();
        CoffeeList.getItems().clear();
        for (int i=0 ; i< Main.admin.getCoffees().size() ; i++){
            CoffeeList.getItems().add(Main.admin.getCoffees().get(i));
        }
        for (int i=0 ; i< Main.admin.getRestaurants().size() ; i++){
            RestList.getItems().add(Main.admin.getRestaurants().get(i));
        }

    }

    @FXML
    public void handleC(MouseEvent click) {

        if (click.getClickCount() == 2) {                                    // 2click item -> open edit page
            Coffee coffee = CoffeeList.getSelectionModel().getSelectedItem();
            EditCoffee(coffee);
        }
    }
    @FXML
    public void handleR(MouseEvent click) {

        if (click.getClickCount() == 2) {                                                  // 2click item -> open edit page
            Restaurant restaurant = RestList.getSelectionModel().getSelectedItem();
            EditRest(restaurant);
        }
    }

    private void EditCoffee(Coffee coffee){                          // Show Edit  coffee Page

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EditPage.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        EditPageController controller = loader.getController();
        controller.initFunctionC(Stage , coffee);
        Stage.setScene(new Scene(loader.getRoot()));
    }

    private void EditRest(Restaurant restaurant){                                   // Show Edit  restaurant Page

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EditPage.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        EditPageController controller = loader.getController();
        controller.initFunctionR(Stage , restaurant);
        Stage.setScene(new Scene(loader.getRoot()));
    }


    @FXML
    private void BackHandler(ActionEvent event){                                  // back to Admin Page
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



}
