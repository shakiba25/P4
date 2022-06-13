package com.company.Daavat;

import com.company.Client;
import com.company.CodeTakhfif;
import com.company.JavaMail;
import com.company.Main;
import com.company.client.ClientPageController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.security.SecureRandom;
import java.util.regex.Pattern;

public class DavatController {

    @FXML
    private TextField EmailFLD;

    @FXML
    private Button OkBTN;

    @FXML
    private Text ErorTXT;

    private Stage stage;
    private Client client;

    public void initFunction(Stage stage , Client client){
        this.stage=stage;
        this.client = client;
        ErorTXT.setText("");
        EmailFLD.clear();
    }
    @FXML
    private void Ok(ActionEvent event){
        if(!EmailFLD.getText().isEmpty()){
            if(CheckEmail(EmailFLD.getText())){

                String CodeMoaref= randomString(5);
                System.out.print(CodeMoaref + "\n");
                String CodeTakhfif = randomString(5);

                CodeTakhfif S = new CodeTakhfif(client.getUser() , 20 , CodeTakhfif , CodeMoaref);
                S.setStatus(false);
                CodeTakhfif R = new CodeTakhfif(EmailFLD.getText() , 15, CodeTakhfif , CodeMoaref);
                R.setStatus(false);
                ErorTXT.setText("Ersal Shod !");
                EmailFLD.clear();

                //JavaMail Mail = new JavaMail( CodeMoaref ,EmailFLD.getText());

            }else {ErorTXT.setText("Email Eshtebah Ast !");}
        }

    }

    private  boolean CheckEmail(String text) {             // check Email
        boolean check = false;
        boolean check3 = true;
        int index = text.indexOf("@");
        if ( index != -1 ){

            String s = text.substring(index);
            String str = text.substring(0,index);
            int check2 = s.compareToIgnoreCase("@gmail.com");
            boolean check1 = Pattern.matches("[a-z,A-Z,0-9,.]+", str);

            for (int i = 0; i< Main.Clientlist.size() ; i++){
                if(Main.Clientlist.get(i).getUser().equals(text) ){
                    check3 = false;
                    break;
                }
            }
            for (int i = 0; i< Main.Takhfiflist.size() ; i++){
                if(Main.Takhfiflist.get(i).getEmail().equals(text) ){
                    check3 = false;
                    break;
                }
            }


            if(check1 && check2==0 && check3) {
                check = true;
            }  }
        return check;
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


    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    String randomString(int len){
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}
