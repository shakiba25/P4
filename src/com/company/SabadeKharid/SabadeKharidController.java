package com.company.SabadeKharid;
import com.company.*;
import javafx.event.ActionEvent;
import com.company.client.ClientPageController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SabadeKharidController {
    @FXML
    private Button PardakhtBTN;

    @FXML
    private Text ErorTXT;
    @FXML
    private Text TotalPrice;

    @FXML
    private TextField CodeTakhfif;
    @FXML
    private ListView<Sefaresh> ListSabad;
    private Stage stage;
    private Client client;

    private int price = 0;
    private int Tprice = 0;
    private int Tedad = 0;
    private CodeTakhfif codeTakhfif = null;

    public void initFunction(Stage stage , Client client){
        this.stage = stage;
        this.client = client;
        Tedad = 0;
        AddToSabadList();
    }

    private void AddToSabadList(){
        price = 0;
        ListSabad.getItems().clear();

        ArrayList<Sefaresh> Sabad = client.getSabadeKharid();

        for (int i=0 ; i<Sabad.size() ; i++){
            if(Sabad.get(i).getCoffee()!=null){
            ListSabad.getItems().add(Sabad.get(i));}
            else{ListSabad.getItems().add(Sabad.get(i));}
            price = price + Integer.parseInt( Sabad.get(i).getFood().getMoney());
        }
        ErorTXT.setText("");
        TotalPrice.setText("Mablaghe kol : "+ price);
    }

    @FXML
    private void OkHandle(ActionEvent event){
        if(Tedad==0) {
            Tprice = 0;
            if (!CodeTakhfif.getText().isEmpty()) {

                for (int i = 0; i < Main.Takhfiflist.size(); i++) {
                    if (Main.Takhfiflist.get(i).getCodeTakhfif().equals(CodeTakhfif.getText())) {
                        if (Main.Takhfiflist.get(i).getEmail().equals(client.getUser())) {
                            if (Main.Takhfiflist.get(i).getStatus()) {
                                Tprice = price * (Main.Takhfiflist.get(i).getDarsad()) / 100;
                                price = price - Tprice;
                                TotalPrice.setText("Mablaghe kol : " + price);
                                codeTakhfif = Main.Takhfiflist.get(i);
                                Tedad = 1;
                            }
                        } else {
                            ErorTXT.setText("Wrong Code Takhfif");
                        }
                    }
                }
            } else {

            }

        }else{
            ErorTXT.setText("Yekbar Takhfif emal shode");
        }
    }


    @FXML
    private void PardakhtHadler(ActionEvent e){

        if(client.getKifPool()!=null){

        int KifPool = Integer.parseInt(client.getKifPool());
        if(KifPool>=price){

            ErorTXT.setText( "Ba Movafhagiat Pardakht Shod !");
            int baghimande = KifPool - price;
            client.setKifPool(String.valueOf(baghimande));

            for(int i=0 ; i<client.getSabadeKharid().size() ; i++){
                client.getSabadeKharid().get(i).StartHandler();
                client.setSefareshList(client.getSabadeKharid().get(i));
                Coffee C = client.getSabadeKharid().get(i).getCoffee();
                Restaurant R = client.getSabadeKharid().get(i).getRestaurant();
                if(C!=null){C.getDelivery().getListSefareshat().add(client.getSabadeKharid().get(i));}
                if(R!=null){R.getDelivery().getListSefareshat().add(client.getSabadeKharid().get(i));}
            }

            for(int i=0 ; i<client.getSefareshList().size() ; i++){
               System.out.print(client.getSefareshList().get(i) + "\n");
            }

            client.getSabadeKharid().clear();
            AddToSabadList();
            if(codeTakhfif!=null){
                Main.Takhfiflist.remove(codeTakhfif);
            }

        }else{
            ErorTXT.setText( "Mojoodi kafi nist !");
        }
    }else{
            ErorTXT.setText( "Mojoodi kafi nist !");
        }

    }
    @FXML
    private void BackHandler(javafx.event.ActionEvent event){
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


    @FXML
    private void DeleteSafaresh(){
        Sefaresh selected = ListSabad.getSelectionModel().getSelectedItem();
        if(selected!=null){
            client.getSabadeKharid().remove(selected);
        }
        AddToSabadList();
    }

}
