package com.company.EditRC;

import com.company.*;
import com.company.Admin.AdminPageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;

public class EditPageController {

    @FXML
    private TextField NameDFLD;

    @FXML
    private TextField LNameDFLD;

    @FXML
    private TextField EmailDFLD;

    @FXML
    private TextField PassDFLD;

    @FXML
    private TextField NumDFLD;

    @FXML
    private RadioButton C;

    @FXML
    private RadioButton R;

    @FXML
    private TextField NameFLD;

    @FXML
    private TextField AddressFLD;

    @FXML
    private Button InfoSaveBTN;

    @FXML
    private ListView<FoodCategory> FCList;

    @FXML
    private TextField IdFLD;

    @FXML
    private TextField OrFLD;

    @FXML
    private TextField NameFCFLD;

    @FXML
    private TextField PriceFoodFLD;

    @FXML
    private TextField NameFoodFLD;

    @FXML
    private Button AddFoodBTN;

    @FXML
    private ListView<FoodCategory> FCListFoods;

    @FXML
    private ListView<FoodCategory> FoodsFClist;

    @FXML
    private ListView<Food> FoodsList;

    private Stage Stage;
    private  Restaurant Restaurant;
    private  Coffee Coffee;
    private Delivery delivery ;
    private FoodCategory FCSelected;
    private ArrayList<FoodCategory> FCL;


    public void initFunctionR(Stage stage , Restaurant restaurant){
        this.Stage = stage;
        this.Restaurant = restaurant;
        this.delivery = Restaurant.getDelivery();
        this.FCL = Restaurant.getFoodCategoryList();
        RefreshInfo();
        RefreshFCList();
        RefreshDelivery();
    }

    public void initFunctionC(Stage stage , Coffee coffee){
        this.Stage = stage;
        this.Coffee =  coffee;
        this.delivery = Coffee.getDelivery();
        this.FCL = Coffee.getFoodCategoryList();
        RefreshInfo();
        RefreshFCList();
        RefreshDelivery();
    }


    private void RefreshInfo(){

        if(Restaurant != null){
            OrFLD.setText("Restaurant");
            R.setSelected(true);
            C.setSelected(false);
            NameFLD.setText(Restaurant.getName());
            AddressFLD.setText(Restaurant.getAddres());   }

        if(Coffee!=null){
            OrFLD.setText("CoffeeShop");
            C.setSelected(true);
            R.setSelected(false);
            NameFLD.setText(Coffee.getName());
            AddressFLD.setText(Coffee.getAddres());    }
    }

    private void RefreshFCList(){
        FCList.getItems().clear();
        FoodsList.getItems().clear();
        FoodsFClist.getItems().clear();
        FCListFoods.getItems().clear();
        for (int i=0 ; i<FCL.size() ; i++){
            FCList.getItems().add(FCL.get(i));
            FCListFoods.getItems().add(FCL.get(i));
            FoodsFClist.getItems().add(FCL.get(i));}

    }
    private void RefreshDelivery(){

        NumDFLD.setText(delivery.getPhoneNumber());
        EmailDFLD.setText(delivery.getName());
        NameDFLD.setText(delivery.getName());
        LNameDFLD.setText(delivery.getLastName());
        PassDFLD.setText(delivery.getPass());

    }



    @FXML
    private void SaveInfoHAndle(ActionEvent event) {



        if (!NameFLD.getText().isEmpty() && !AddressFLD.getText().isEmpty()) {

            System.out.print(!Objects.isNull(Restaurant) + "R\n");
            System.out.print(!Objects.isNull(Coffee) + "C\n");

            if ( !Objects.isNull(Restaurant) ) {
                System.out.print(Restaurant + "R\n");
                Restaurant.setAddres(AddressFLD.getText());
                Restaurant.setName(NameFLD.getText());
               }


             if (!Objects.isNull(Coffee)) {
                    System.out.print(Coffee + "c\n");
                    Coffee.setAddres(AddressFLD.getText());
                    Coffee.setName(NameFLD.getText());

                }

            RefreshInfo();
        }
    }
    @FXML
    private void AddFCHandle(ActionEvent event){

            if(!NameFCFLD.getText().isEmpty() && !IdFLD.getText().isEmpty() && !OrFLD.getText().isEmpty()){

                FoodCategory fc = new FoodCategory(NameFCFLD.getText() , IdFLD.getText() , OR.RESTAURANT );
                FCL.add(fc);
                FCList.getItems().add(fc);
                FCListFoods.getItems().add(fc);
                FoodsFClist.getItems().add(fc);
                System.out.print("food ok \n");
                NameFCFLD.clear();
                IdFLD.clear();
            }



    }

    @FXML
    private void AddFoodHandler(ActionEvent event){
        FoodCategory  selectedFC = FCListFoods.getSelectionModel().getSelectedItem();
        if( selectedFC != null && !NameFoodFLD.getText().isEmpty() && !PriceFoodFLD.getText().isEmpty()){
            if(CheckPrice(PriceFoodFLD.getText())){
                Food food = new Food(NameFoodFLD.getText() , PriceFoodFLD.getText());
                selectedFC.setFoodList(food);
                System.out.print("food ok \n");
                PriceFoodFLD.clear();
                NameFoodFLD.clear();
            }
        }
    }

    @FXML
    public void FoodsFClisthandle(MouseEvent click) {              // Show Foods of FoodCategory  in list that 2click on FC
           FoodsList.getItems().clear();
           System.out.print("handle\n");
           if (click.getClickCount() == 2) {
               System.out.print("2click\n");
            FoodCategory selected = FoodsFClist.getSelectionModel().getSelectedItem();
            FCSelected = selected;
               System.out.print(selected+"\n");
           for (int i=0 ; i<selected.getFoodList().size() ; i++){
               FoodsList.getItems().add(selected.getFoodList().get(i));
               System.out.print(selected.getFoodList().get(i)+"\n");
           }

        }
    }
    @FXML
    private void RemoveFCHandler(ActionEvent event){
       FoodCategory selectedFC =  FoodsFClist.getSelectionModel().getSelectedItem();

       if(selectedFC!=null){
           FCL.remove(selectedFC);
        }
       RefreshFCList();
    }
    @FXML
    private void RemoveFHandler(ActionEvent event){

        Food selectedF = FoodsList.getSelectionModel().getSelectedItem();
        if(selectedF!=null){
            FCSelected.getFoodList().remove(selectedF);
        }

        RefreshFCList();
    }

    @FXML
    private void BackHandler(ActionEvent event){
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

private boolean CheckPrice(String price){
    boolean check0 = true;
    boolean check = false;
    if(price.substring(0,1).equals("0")){
        check0 = false;
    }
    boolean check1 = Pattern.matches("[0-9]+", price);
    if(check1 && check0){
        check = true;
    }
    return  check;
}



}
