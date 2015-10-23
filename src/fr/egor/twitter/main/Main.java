package fr.egor.twitter.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("../twitter-e.fxml"));
    primaryStage.setTitle("TwitterE");
    primaryStage.setScene(new Scene(root, 1200, 700));
    primaryStage.show();
  }


  public static void main(String[] args) {
    launch(args);
  }
}
