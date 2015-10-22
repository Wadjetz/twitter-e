package fr.egor.twitter.view.profile;

import fr.egor.twitter.api.TwitterAPI;
import fr.egor.twitter.async.Async;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

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

}
