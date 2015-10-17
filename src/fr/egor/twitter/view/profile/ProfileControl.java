package fr.egor.twitter.view.profile;

import fr.egor.twitter.api.TwitterAPI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import twitter4j.TwitterException;

import java.io.IOException;

public class ProfileControl extends VBox {

  @FXML
  public ImageView userPictureByUrl;
  public Label fullNameProfil;
  public Label screenNameProfil;
  public Label tweetsNombers;
  public Label abonnementsNumbers;
  public Label abonnesNumbers;

  public ProfileControl() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profile-control.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
      fxmlLoader.load();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    }

    try {
      TwitterAPI twitterAPI = new TwitterAPI();
      userPictureByUrl.setImage(new Image(twitterAPI.getProfileImageUrl()));
      fullNameProfil.setText(twitterAPI.getFullName());
      screenNameProfil.setText("@"+twitterAPI.getFullScreenName());
      tweetsNombers.setText(twitterAPI.getTweetsCountProfil() + " tweets");
      abonnementsNumbers.setText(twitterAPI.getFriendsCountProfil());
      abonnesNumbers.setText(twitterAPI.getFollowersCountProfil());
    } catch (TwitterException e) {
      e.printStackTrace();
    }
  }

}
