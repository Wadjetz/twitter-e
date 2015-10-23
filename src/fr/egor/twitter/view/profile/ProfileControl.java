package fr.egor.twitter.view.profile;

import fr.egor.twitter.api.TwitterAPI;
import fr.egor.twitter.async.Async;
import fr.egor.twitter.view.tweet.list.TweetCell;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import twitter4j.Paging;
import twitter4j.Status;

import java.io.IOException;
import java.util.List;

public class ProfileControl extends VBox {

  @FXML
  public ImageView userPictureByUrl;
  public Label fullNameProfil;
  public Label screenNameProfil;
  public Label tweetsNombers;
  public Label abonnementsNumbers;
  public Label abonnesNumbers;
  public TextField txtCountTweet;
  public ListView<Status> tweets;

  public ObservableList<Status> tweetsListCount = FXCollections.observableArrayList();

  public ProfileControl() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profile-control.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    }

    Async.async(() -> {
      Image image = new Image(TwitterAPI.getInstance().getProfileImageUrl());
      Platform.runLater(() ->
        userPictureByUrl.setImage(image)
      );
      return null;
    });

    Async.async(() -> {
      String fullname = TwitterAPI.getInstance().getFullName();
      Platform.runLater(() ->
        fullNameProfil.setText(fullname)
      );
      return null;
    });

    Async.async(() -> {
      String fullScreenName = TwitterAPI.getInstance().getFullScreenName();
      Platform.runLater(() ->
        screenNameProfil.setText("@" + fullScreenName)
      );
      return null;
    });

    Async.async(() -> {
      String tweetsCount = TwitterAPI.getInstance().getTweetsCountProfil();
      Platform.runLater(() ->
        tweetsNombers.setText(tweetsCount + " tweets")
      );
      return null;
    });

    Async.async(() -> {
      String friendsCount = TwitterAPI.getInstance().getFriendsCountProfil();
      Platform.runLater(() ->
        abonnementsNumbers.setText(friendsCount)
      );
      return null;
    });

    Async.async(() -> {
      String followersCount = TwitterAPI.getInstance().getFollowersCountProfil();
      Platform.runLater(() ->
        abonnesNumbers.setText(followersCount)
      );
      return null;
    });
  }


  @FXML
  protected void setListTweetWithCount() {
    String s = txtCountTweet.getText();
    if(txtCountTweet.getStylesheets().contains("text-field-error")){
      txtCountTweet.getStylesheets().remove("text-field-error");
    }

    if(isInteger(s)){
      Paging paging = new Paging(Integer.parseInt(txtCountTweet.getText()));

      Async.async(() -> {
        List<Status> list = TwitterAPI.getInstance().getHomeTimeline(paging);
        tweetsListCount.addAll(list);
        return null;
      });

      tweets.setItems(tweetsListCount);
      tweets.setCellFactory(param -> new TweetCell());


    }else {
      txtCountTweet.getStyleClass().add("text-field-error");
    }

  }
  public static boolean isInteger(String s) {
    try {
      Integer.parseInt(s);
    } catch(NumberFormatException e) {
      return false;
    } catch(NullPointerException e) {
      return false;
    }
    // only got here if we didn't return false
    return true;
  }

}
