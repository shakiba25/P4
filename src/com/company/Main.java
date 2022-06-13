package com.company;

import com.company.StartPage.StartPageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Main extends Application  {

    public static final ArrayList<Delivery> Deliverylist= new ArrayList<>();
    public static final ArrayList<Client> Clientlist= new ArrayList<>();
    public static final ArrayList<CodeTakhfif> Takhfiflist= new ArrayList<>();
    public static ADMIN admin = null;
    public static String fileDelivery = "C:\\Users\\Asus\\Desktop\\P4\\DeliveryFood.txt";
    public static String fileAdmin = "C:\\Users\\Asus\\Desktop\\P4\\AdminFood.txt";
    public static String fileClient = "C:\\Users\\Asus\\Desktop\\P4\\ClientFood.txt";
    public static String fileTakhfif = "C:\\Users\\Asus\\Desktop\\P4\\TakhfifFood.txt";
    public static void main(String[] args) {

        //CodeTakhfif codeTakhfif = new CodeTakhfif("a",10);


        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {                                             //add people to list
            ReadFileToList();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }


        for (int i=0 ; i<Clientlist.size() ; i++){
            System.out.print(Clientlist.get(i)+"\n");
        }


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("StartPage/StartPage.fxml"));
        try {
            loader.load();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        StartPageController controller = loader.getController();
        controller.initFunction(primaryStage);
        primaryStage.setScene(new Scene(loader.getRoot()));
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(event ->{
            try {
                WriteToFile();
            }catch (Exception e){
                System.out.print(e.getMessage());
            }
            System.out.print("Ok-W");
            primaryStage.close();
        });}


    public static void ReadFileToList() {

        try {
            FileInputStream fileIn = new FileInputStream(fileClient);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            FileInputStream fileInA = new FileInputStream(fileAdmin);
            ObjectInputStream objectInA = new ObjectInputStream(fileInA);

            FileInputStream fileInD = new FileInputStream(fileDelivery);
            ObjectInputStream objectInD = new ObjectInputStream(fileInD);

            FileInputStream fileInT = new FileInputStream(fileTakhfif);
            ObjectInputStream objectInT = new ObjectInputStream(fileInT);

            Client client = new Client("a" ,"a" , "a" , "a" , "a");
            Clientlist.add(client);

            while(true) {
                try{
                    Object  Client = objectIn.readObject();
                    if(Client!=null){
                        Clientlist.add((Client) Client);   // reading object from file & add to list
                    }


                }catch(IOException ex){
                    // end of file case
                    break;
                }

            }
            while(true) {
                try{
                    Object  takhfif  = objectInT.readObject();
                    if(takhfif!=null){
                        Takhfiflist.add((CodeTakhfif) takhfif);   // reading object from file & add to list
                    }


                }catch(IOException ex){
                    // end of file case
                    break;
                }

            }
            while(true) {
                try{
                    Object  Delivery = objectInD.readObject();
                    if(Delivery!=null){
                        Deliverylist.add((Delivery) Delivery);
                        // reading object from file & add to list
                    }


                }catch(IOException ex){
                    // end of file case
                    break;
                }

            }
            try {
                Object  Admin = objectInA.readObject();
                admin = (ADMIN) Admin;
                System.out.print(admin.getName());
            }catch (Exception e){
                System.out.print(e.getMessage());
                 admin = new ADMIN("Admin","Admin" , "Admin" , "Admin" , "09161111111");
            }


        } catch (Exception ex) {
            ex.printStackTrace();

        }
        System.out.print(Takhfiflist.size());
        System.out.print("Ok-R");
    }
    public static void WriteToFile() throws IOException {
        clearTheFile();
        try {

            FileOutputStream fileOutput = new FileOutputStream(fileClient);   //writing contact file
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOutput);

            FileOutputStream fileOutputAdmin = new FileOutputStream(fileAdmin);   //writing contact file
            ObjectOutputStream objectOutAdmin = new ObjectOutputStream(fileOutputAdmin);

            FileOutputStream fileOutputDelivery = new FileOutputStream(fileDelivery);   //writing contact file
            ObjectOutputStream objectOutD = new ObjectOutputStream(fileOutputDelivery);

            FileOutputStream fileOutputTakhfif = new FileOutputStream(fileTakhfif);   //writing contact file
            ObjectOutputStream objectOutT = new ObjectOutputStream(fileOutputTakhfif);

            for (int i=0 ; i< Clientlist.size() ; i++){
                Object  Client = Clientlist.get(i);              //writing list in file
                objectOut.writeObject(Client);
            }
            for (int i=0 ; i< Deliverylist.size() ; i++){
                Object  Delivery = Deliverylist.get(i);              //writing list in file
                objectOutD.writeObject(Delivery);
            }

            for (int i=0 ; i< Takhfiflist.size() ; i++){
                Object  CodeTakhfif  = Takhfiflist.get(i);               //writing list in file
                objectOutT.writeObject(CodeTakhfif);
            }

           // admin = new ADMIN("Admin","Admin" , "Admin" , "Admin" , "09161111111");
            Object Admin = admin;
            objectOutAdmin.writeObject(Admin);



            objectOut.close();
            objectOutAdmin.close();
            objectOutD.close();
            objectOutT.close();
            //  System.out.print("The Object  was succesfully written to a file");

        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public static void clearTheFile() throws IOException {                             //Clear file person
        FileWriter fwOb = new FileWriter(fileClient, false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
        FileWriter fwObA = new FileWriter(fileAdmin, false);
        PrintWriter pwObA = new PrintWriter(fwOb, false);
        pwObA.flush();
        pwObA.close();
        fwObA.close();
        FileWriter fwObD = new FileWriter(fileDelivery, false);
        PrintWriter pwObD = new PrintWriter(fwObD, false);
        pwObD.flush();
        pwObD.close();
        fwObD.close();
        FileWriter fwObT = new FileWriter(fileTakhfif, false);
        PrintWriter pwObT = new PrintWriter(fwObD, false);
        pwObT.flush();
        pwObT.close();
        fwObT.close();
    }
}
