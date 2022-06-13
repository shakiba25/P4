package com.company.Signin;

import com.company.Client;
import com.company.Main;
import com.company.StartPage.StartPageController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.regex.Pattern;

public class SigninPageController {
    @FXML
    private TextField NameFLD;

    @FXML
    private TextField LNameFLD;

    @FXML
    private TextField PhNumberFLD;

    @FXML
    private TextField EmailFLD;

    @FXML
    private TextField PassFLD;

    @FXML
    private Button SignupBTN;

    @FXML
    private Button BackBTN;

    @FXML
    private TextField CodeMoaref;
    private Stage Stage;

    public void initFunction(Stage stage){
        this.Stage = stage;
    }

    @FXML
    private void SignupHandler(ActionEvent event){

        if(checkEmpty()){
            if(checkNumber(PhNumberFLD.getText()) && CheckEmail(EmailFLD.getText())){
                Client client = new Client(NameFLD.getText(),LNameFLD.getText(),EmailFLD.getText(),PassFLD.getText(),PhNumberFLD.getText());
                Main.Clientlist.add(client);
                for (int i=0 ; i< Main.Clientlist.size() ; i++){
                    System.out.print( Main.Clientlist.get(i)+"\n");
                }
                CodeMoaref();
                BackHandler(event);


            }else { System.out.print("Wrong info\n");       }
        }else { System.out.print("Wrong info\n");       }


    }

    @FXML
    private void BackHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../StartPage/StartPage.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        StartPageController controller = loader.getController();
        controller.initFunction(Stage);
        Stage.setScene(new Scene(loader.getRoot()));
    }

private void CodeMoaref(){
        if(!CodeMoaref.getText().isEmpty()){
            for (int i=0 ; i<Main.Takhfiflist.size() ; i++){
                if(Main.Takhfiflist.get(i).getCodeMoaref().equals(CodeMoaref.getText())){
                    Main.Takhfiflist.get(i).setStatus(true);
                }
            }
        }
}




//---------------------------------------------------------------------------------------------
private boolean checkEmpty(){                         // check Field
    boolean check = true;
    if(NameFLD.getText().isEmpty() || LNameFLD.getText().isEmpty() || EmailFLD.getText().isEmpty()
            || PassFLD.getText().isEmpty() || PhNumberFLD.getText().isEmpty()){
        check = false;
    }
    return check;
    }
//---------------------------------------------------------------------------------------------
private  boolean CheckEmail(String text) {             // check Email
    boolean check = false;
    boolean check3 = true;
    int index = text.indexOf("@");
    if ( index != -1 ){

        String s = text.substring(index);
        String str = text.substring(0,index);
        int check2 = s.compareToIgnoreCase("@gmail.com");
        boolean check1 = Pattern.matches("[a-z,A-Z,0-9,.]+", str);

        for (int i=0 ; i< Main.Clientlist.size() ; i++){
            if(Main.Clientlist.get(i).getUser().equals(text) ){
                check3 = false;
                break;
            }
        }
        for (int i=0 ; i< Main.Deliverylist.size() ; i++){
            if(Main.Deliverylist.get(i).getUser().equals(text) ){
                check3 = false;
                break;
            }
        }


        if(check1 && check2==0 && check3) {
            check = true;
        }  }
    return check;
}
//---------------------------------------------------------------------------------------------
private boolean checkNumber(String number){                           // check number
    boolean check2 = false;
    boolean check = Pattern.matches("[0-9]{11}", number);
    boolean check1 = number.substring(0,2).equals("09");
    if( check1 && check)
        check2 = true;
    return check2;
}



}

