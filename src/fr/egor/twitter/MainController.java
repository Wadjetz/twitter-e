package fr.egor.twitter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
  TwitterAPI twitterAPI;
  ObservableList<Status> tweetsList = FXCollections.observableArrayList();

  @FXML
  public ListView<Status> tweets;


  public void lol(ActionEvent event) {
    System.out.println("lol");
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    twitterAPI = new TwitterAPI();
    try {
      tweetsList = FXCollections.observableArrayList(twitterAPI.getHomeTimeline());
      //tweets.setCellFactory((listView, listCell) -> );
      tweets.setItems(tweetsList);
    } catch (TwitterException e) {
      e.printStackTrace();
    }
  }
}
