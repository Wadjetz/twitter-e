package fr.egor.twitter.view.tweet.list;

import fr.egor.twitter.api.TwitterAPI;
import fr.egor.twitter.async.Async;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import twitter4j.Status;

import java.io.IOException;
import java.util.List;

public class ListTweetControl extends VBox {

  private ObservableList<Status> tweetsList = FXCollections.observableArrayList();

  @FXML
  public ListView<Status> tweets;

  public ListTweetControl() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("list-tweet-control.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    }

    Async.async(() -> {
      List<Status> list = new TwitterAPI().getHomeTimeline();
      tweetsList.addAll(list);
      return null;
    });

    tweets.setItems(tweetsList);
    tweets.setCellFactory(param -> new TweetCell());
  }

}
