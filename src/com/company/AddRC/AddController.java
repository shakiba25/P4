package com.company.AddRC;

import com.company.Admin.AdminPageController;
import com.company.Coffee;
import com.company.Delivery;
import com.company.Login.LoginPageController;
import com.company.Main;
import com.company.Restaurant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.regex.Pattern;

public class AddController {
    @FXML
    private RadioButton C;

    @FXML
    private RadioButton R;

    @FXML
    private TextField NameFLD;

    @FXML
    private TextField AddressFLD;

    @FXML
    private Button InfoNextBTN;

    @FXML
    private Tab DeliveryTab;

    @FXML
    private Tab InfoTab;

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
    private Button DelNext;

    private Stage Stage;

    public void initFunction(Stage stage){
        this.Stage = stage;
        NameFLD.clear();
        AddressFLD.clear();
        NumDFLD.clear();
        NameDFLD.clear();
        LNameDFLD.clear();
        EmailDFLD.clear();
        PassDFLD.clear();
        InfoTab.setDisable(false);
        DeliveryTab.setDisable(true);
    }

    @FXML
    private void InfoNextHandle(ActionEvent event){

        System.out.print(C.isSelected() + "\n");
        System.out.print(R.isSelected() + "\n");
        System.out.print(CheckEmpty());

        if(C.isSelected() && !R.isSelected()){
            if(CheckEmpty()){

                DeliveryTab.setDisable(false);
            }
        }else if(!C.isSelected() && R.isSelected()){
            if(CheckEmpty()){
                System.out.print(C.isArmed() + "\n");
                System.out.print(R.isArmed() + "\n");
                System.out.print(CheckEmpty());
                DeliveryTab.setDisable(false);
            }
        }else {
            System.out.print(" Wrong Fields \n");
        }

    }

    @FXML
    private void DelNextHandle(ActionEvent event){
        System.out.print("Save");
        System.out.print(CheckEmptyDel());
        System.out.print(CheckEmail(EmailDFLD.getText()));
        System.out.print(checkNumber(NumDFLD.getText()));
        if(CheckEmptyDel()){
            if(CheckEmail(EmailDFLD.getText()) && checkNumber(NumDFLD.getText())){
                if(C.isSelected() && !R.isSelected()){
                    if(CheckEmpty()){
                        System.out.print("1");
                        Delivery delivery = new Delivery(NameDFLD.getText(),LNameDFLD.getText(),EmailDFLD.getText(),PassDFLD.getText(),NumDFLD.getText());
                        Coffee coffee = new Coffee(NameFLD.getText() , AddressFLD.getText() , delivery );
                        Main.admin.getCoffees().add(coffee);
                        Main.Deliverylist.add(delivery);
                        DeliveryTab.setDisable(true);
                        InfoTab.setDisable(true);
                        System.out.print("1");
                    }
                }else if(!C.isSelected() && R.isSelected()){
                    if(CheckEmpty()){
                        System.out.print("2");
                        Delivery delivery = new Delivery(NameDFLD.getText(),LNameDFLD.getText(),EmailDFLD.getText(),PassDFLD.getText(),NumDFLD.getText());
                        Restaurant restaurant = new Restaurant(NameFLD.getText() , AddressFLD.getText() , delivery );
                        Main.Deliverylist.add(delivery);
                        Main.admin.getRestaurants().add(restaurant);
                        DeliveryTab.setDisable(true);
                        InfoTab.setDisable(true);
                        System.out.print("2");
                    }
                }else {
                    System.out.print(" Wrong Fields \n");
                }

            }

        }else {
            System.out.print("Wrong Delivery \n");     }


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


//------------------------------------------------------------------------------------
    private boolean CheckEmpty(){
        boolean check = true;
        if(NameFLD.getText().isEmpty() || AddressFLD.getText().isEmpty()){
            check = false;
        }
        return check;
}
    private boolean CheckEmptyDel(){
        boolean check = true;
        if(NameDFLD.getText().isEmpty() || LNameDFLD.getText().isEmpty()
                || NumDFLD.getText().isEmpty() || EmailDFLD.getText().isEmpty() || PassDFLD.getText().isEmpty()){
            check = false;
        }
        return check;
    }
    private  boolean CheckEmail(String text) {             // check Email
        boolean check = false;
        int index = text.indexOf("@");
        if ( index != -1 ){

            String s = text.substring(index);
            String str = text.substring(0,index);
            int check2 = s.compareToIgnoreCase("@gmail.com");
            boolean check1 = Pattern.matches("[a-z,A-Z,0-9,.]+", str);
            if(check1 && check2==0) {
                check = true;
            }  }
        return check;
    }

    private boolean checkNumber(String number){                           // check number
        boolean check2 = false;
        boolean check = Pattern.matches("[0-9]{11}", number);
        boolean check1 = number.substring(0,2).equals("09");
        if( check1 && check)
            check2 = true;
        return check2;
    }

//------------------------------------------------------------------------------------
}
