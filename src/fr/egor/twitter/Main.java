package fr.egor.twitter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  TwitterAPI twitterAPI;

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
    primaryStage.setTitle("TwitterE");
    System.out.println("Hello");
    primaryStage.setScene(new Scene(root, 400, 375));
    primaryStage.show();

    twitterAPI = new TwitterAPI();
    twitterAPI.getHomeTimeline().forEach(s -> {
      System.out.println(s.getText());
    });
  }


  public static void main(String[] args) {
    launch(args);
  }
}
