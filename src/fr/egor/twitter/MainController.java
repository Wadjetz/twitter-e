package fr.egor.twitter;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
  TwitterAPI twitterAPI;
  ObservableList<Status> tweetsList = FXCollections.observableArrayList();

  @FXML
  public ListView<Status> tweets;
  public ImageView userPictureByUrl;
  public String urlUserPicture;
  public Label fullNameProfil,screenNameProfil,tweetsNombers,abonnementsNumbers,abonnesNumbers;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    twitterAPI = new TwitterAPI();
    try {
      tweetsList = FXCollections.observableArrayList(twitterAPI.getHomeTimeline());
      urlUserPicture = twitterAPI.getProfileImageUrl();

      tweetsList = FXCollections.observableArrayList(twitterAPI.getHomeTimeline());
      tweets.setItems(tweetsList);
      Image image = new Image(urlUserPicture);
      userPictureByUrl.setImage(image);
      fullNameProfil.setText(twitterAPI.getFullName());
      screenNameProfil.setText("@"+twitterAPI.getFullScreenName());
      tweetsNombers.setText(twitterAPI.getTweetsCountProfil());
      abonnementsNumbers.setText(twitterAPI.getFriendsCountProfil());
      abonnesNumbers.setText(twitterAPI.getFollowersCountProfil());
    } catch (TwitterException e) {
      e.printStackTrace();
    }
  }
}
