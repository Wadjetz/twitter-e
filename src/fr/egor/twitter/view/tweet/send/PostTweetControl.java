package fr.egor.twitter.view.tweet.send;

import fr.egor.twitter.api.TwitterAPI;
import fr.egor.twitter.async.Async;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import java.io.IOException;

public class PostTweetControl extends VBox {

  @FXML
  public TextArea tweetContent;
  @FXML
  public Label wordCount;
  @FXML
  public Button tweetSend;

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
    System.out.println(text);
    Async.async(() -> {
      TwitterAPI.getInstance().postTweet(text);
      return null;
    });
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
