package com.example.mybank_system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    private  static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {

        HelloApplication.stage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        stage.setTitle("Log in");
        stage.setScene(scene);
        stage.show();
    }

    public static void SignUp () throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SignUp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        stage.setTitle("Sign Up");
        stage.setScene(scene);
        stage.show();
    }
    public static void Login () throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        stage.setTitle("Log in");
        stage.setScene(scene);
        stage.show();
    }

    public static void MainMenu () throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }

    public static void Withdraw () throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Withdraw.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        stage.setTitle("Withdrawals");
        stage.setScene(scene);
        stage.show();
    }
    public static void SentMoney () throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sent_Money.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        stage.setTitle("Send Money");
        stage.setScene(scene);
        stage.show();
    }

    public static void ChangePassword () throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Change_Password.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        stage.setTitle("Change password");
        stage.setScene(scene);
        stage.show();
    }

    public static void Thankyou () throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Thank_you.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        stage.setTitle("Thank you");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}