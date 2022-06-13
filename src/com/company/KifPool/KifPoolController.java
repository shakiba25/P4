package com.company.KifPool;

import com.company.Client;
import com.company.CodeTakhfif;
import com.company.Main;
import com.company.client.ClientPageController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.util.regex.Pattern;

public class KifPoolController {

    @FXML
    private Text MojoodiTXT;

    @FXML
    private TextField MablaghFLD;

    @FXML
    private Button ChargeBTN;

    @FXML
    private ListView<CodeTakhfif> CodeTakhfifList;
    private Client client;
    private Stage stage;

    public void initFunction(Stage stage, Client client){
        this.stage = stage;
        this.client = client;
        AddCodeTakhfif();
    }

    private void AddCodeTakhfif(){
        CodeTakhfifList.getItems().clear();

        for (int i = 0; i<Main.Takhfiflist.size() ; i++){
            if(Main.Takhfiflist.get(i).getEmail().equals(client.getUser())){
                if(Main.Takhfiflist.get(i).getStatus()){
                    CodeTakhfifList.getItems().add(Main.Takhfiflist.get(i));
                }
            }
        }

        if(client.getKifPool()==null){
            MojoodiTXT.setText("Mojoodi : 0"   );
        }else {
            MojoodiTXT.setText("Mojoodi : " + client.getKifPool());
        }

    }

    @FXML
    private void ChargeBTN(ActionEvent e ){
        if(!MablaghFLD.getText().isEmpty()){
        if(checkNumber(MablaghFLD.getText())){
            if(client.getKifPool()==null){
            int Mojoodi = 0;
            int Charge = Integer.parseInt(MablaghFLD.getText());
            client.setKifPool(String.valueOf(Mojoodi+Charge));
            MablaghFLD.clear();
            AddCodeTakhfif();}
            else {
                int Mojoodi =Integer.parseInt(client.getKifPool());;
                int Charge = Integer.parseInt(MablaghFLD.getText());
                client.setKifPool(String.valueOf(Mojoodi+Charge));
                MablaghFLD.clear();
                AddCodeTakhfif();
            }

        }}
    }
    private boolean checkNumber(String number){                           // check number
        boolean check2 = false;
        boolean check = Pattern.matches("[0-9]+", number);
        boolean check1 = number.substring(0,1).equals("0");
        if( !check1 && check)
            check2 = true;
        return check2;
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
