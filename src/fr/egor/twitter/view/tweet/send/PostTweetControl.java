package fr.egor.twitter.view.tweet.send;

import fr.egor.twitter.api.ITwitterAPI;
import fr.egor.twitter.api.TwitterAPI;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import twitter4j.TwitterException;
import java.io.IOException;

public class PostTweetControl extends VBox {

  private ITwitterAPI twitterAPI;

  @FXML
  public TextArea tweetContent;
  @FXML
  public Label wordCount;
  @FXML
  public Button tweetSend;

  public void setApi(TwitterAPI twitterAPI) {
    this.twitterAPI = twitterAPI;
  }

  public PostTweetControl() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("post-tweet-control.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    }
  }

  @FXML
  protected void sendTweetButtonAction(ActionEvent event) {
    String text = tweetContent.getText();
    try {
      twitterAPI.postTweet(text);
    } catch (TwitterException e) {
      e.printStackTrace();
    }
  }

  @FXML
  protected void changeTweetContentAction(Event event) {
    int tweetLength = tweetContent.getText().length();
    wordCount.setText(tweetLength + "");
    if (tweetLength > 140) {
      wordCount.setTextFill(Paint.valueOf("#c61111"));
      tweetSend.setDisable(true);
    } else {
      wordCount.setTextFill(Paint.valueOf("#000000"));
      tweetSend.setDisable(false);
    }
  }
}
