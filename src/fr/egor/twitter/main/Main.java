package fr.egor.twitter.main;

import fr.egor.twitter.api.FakeTwitterAPI;
import fr.egor.twitter.api.ITwitterAPI;
import fr.egor.twitter.view.profile.ProfileControl;
import fr.egor.twitter.view.tweet.list.ListTweetControl;
import fr.egor.twitter.view.tweet.send.PostTweetControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("twitter-e.fxml"));

    ITwitterAPI twitterAPI = new FakeTwitterAPI();

    PostTweetControl postTweetControl = new PostTweetControl();
    HBox hbox = new HBox();
    hbox.getChildren().add(postTweetControl);

    ListTweetControl listTweetControl = new ListTweetControl();
    hbox.getChildren().add(listTweetControl);

    ProfileControl profileControl = new ProfileControl();
    hbox.getChildren().add(profileControl);

    primaryStage.setTitle("TwitterE");
    primaryStage.setScene(new Scene(root, 1200, 700));
    primaryStage.show();
  }


  public static void main(String[] args) {
    launch(args);
  }
}
