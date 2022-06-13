package com.company.Sefareshat;

import com.company.*;
import com.company.client.ClientPageController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.util.regex.Pattern;

public class SefareshatController {
    @FXML
    private TextField RCFLD;

    @FXML
    private TextField NameFoodFLD;

    @FXML
    private TextField PriceFoodFLD;

    @FXML
    private Text StarTXT;
    @FXML
    private ListView<Sefaresh> SefareshList;
    @FXML
    private TextField NazarFLD;
    private Stage stage;
    private Client client;
    private Sefaresh Selected;

    public void initFunction(Stage stage , Client client){
        this.client=client;
        this.stage=stage;
        Add();
    }

    private void Add(){                                                       // add sefareshat to list
        SefareshList.getItems().clear();
        SefareshList.getItems().addAll(client.getSefareshList());
    }
    @FXML
    public void Listhandle(MouseEvent click) {
        System.out.print("handle\n");

        if (click.getClickCount() == 2) {
            Sefaresh selected = SefareshList.getSelectionModel().getSelectedItem();
            Selected = selected;
            StarTXT.setText("");
            NameFoodFLD.clear();
            RCFLD.clear();
            PriceFoodFLD.clear();
            AddInfo(selected);        }
    }

    private void AddInfo(Sefaresh sefaresh){                               // set Sefaresh informations
        if (sefaresh.getCoffee()!=null)
            RCFLD.setText(sefaresh.getCoffee().getName());
        if (sefaresh.getRestaurant()!=null)
            RCFLD.setText(sefaresh.getRestaurant().getName());
        NameFoodFLD.setText(sefaresh.getFood().getName());
        PriceFoodFLD.setText(sefaresh.getFood().getName());
        StarTXT.setText(sefaresh.getStar());

    }

    @FXML
    private void OkHandler(ActionEvent event){                   // sabt setare
        if(!NazarFLD.getText().isEmpty()){
            System.out.print("1");
            if(checkNumber(NazarFLD.getText())){
                System.out.print("2");
                if(Selected!=null){
                    System.out.print("3");
                     Selected.setStar(Integer.parseInt(NazarFLD.getText()));
                     System.out.print(Selected.getStar());
                     StarTXT.setText(Selected.getStar());
                }
            }
        }
    }

    @FXML
    private void LaghvHAndler(ActionEvent event){                                   // Cancel Sefaresh
       Sefaresh selectedSefaresh = SefareshList.getSelectionModel().getSelectedItem();
       if(selectedSefaresh!=null){

           Restaurant r = selectedSefaresh.getRestaurant();
           Coffee c = selectedSefaresh.getCoffee();

           boolean darsad50 = selectedSefaresh.getRunning50();
           boolean darsad100 = selectedSefaresh.getRunning100();

           if(darsad100){                                                                       // cancel sefaresh befor 30 S
               int mojoodi = Integer.parseInt(client.getKifPool());
               int bazghashti = Integer.parseInt(selectedSefaresh.getFood().getMoney());
               client.setKifPool(String.valueOf(mojoodi+ (bazghashti)));
               client.getSefareshList().remove(selectedSefaresh);
               if(r!=null){r.getDelivery().getListSefareshat().remove(selectedSefaresh);}
               if(c!=null){c.getDelivery().getListSefareshat().remove(selectedSefaresh);}
           System.out.print(darsad100+"Bazghash 100 darsad\n");}

           if(darsad50 && !darsad100){                                                           // cancle befor 60 s
               int mojoodi = Integer.parseInt(client.getKifPool());
               int bazghashti = Integer.parseInt(selectedSefaresh.getFood().getMoney());
               client.setKifPool(String.valueOf(mojoodi + ( bazghashti / 2 )));
               client.getSefareshList().remove(selectedSefaresh);
               if(r!=null){r.getDelivery().getListSefareshat().remove(selectedSefaresh);}
               if(c!=null){c.getDelivery().getListSefareshat().remove(selectedSefaresh);}
               System.out.print(darsad100+"Bazghash 50 darsad\n");}

           System.out.print(darsad50+"etmam time\n"+darsad100);
       }
       Add();
    }

    @FXML
    private void BackHandler(ActionEvent event){                         // back to client page
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


    private boolean checkNumber(String number){                           // check number
        boolean check = Pattern.matches("[0-5]{1}", number);
        System.out.print(check);
        return check;

    }

}
