package fr.egor.twitter;
import com.sun.org.apache.bcel.internal.generic.NEW;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
  TwitterAPI twitterAPI;
  ObservableList<Status> tweetsListHome = FXCollections.observableArrayList();
  ObservableList<Status> tweetsListUser = FXCollections.observableArrayList();
  ObservableList<String> tweetsListUserToString=FXCollections.observableArrayList();
  @FXML
  public ListView<String> tweets;
  public ImageView userPictureByUrl;
  public Label fullNameProfil,screenNameProfil,tweetsNombers,abonnementsNumbers,abonnesNumbers;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    twitterAPI = new TwitterAPI();

    try {
      tweetsListHome = FXCollections.observableArrayList(twitterAPI.getHomeTimeline());

      tweetsListUser = FXCollections.observableArrayList(twitterAPI.getUserTimeline());
/*
List of my tweets
 tweetsListUserToString=FXCollections.observableArrayList(twitterAPI.getUserTimeLineToString(tweetsListUser));
 List of all tweets
 tweetsListUserToString=FXCollections.observableArrayList(twitterAPI.getUserTimeLineToString(tweetsListHome));
* */
      tweetsListUserToString=FXCollections.observableArrayList(twitterAPI.getUserTimeLineToString(tweetsListHome));

      tweets.setItems(tweetsListUserToString);
      userPictureByUrl.setImage(new Image(twitterAPI.getProfileImageUrl()));
      fullNameProfil.setText(twitterAPI.getFullName());
      screenNameProfil.setText("@"+twitterAPI.getFullScreenName());
      tweetsNombers.setText(twitterAPI.getTweetsCountProfil());
      abonnementsNumbers.setText(twitterAPI.getFriendsCountProfil());
      abonnesNumbers.setText(twitterAPI.getFollowersCountProfil());
      System.out.println("liste status : "+ twitterAPI.getAllStatus(tweetsListUser)+" \n");



    } catch (TwitterException e) {
      e.printStackTrace();
    }

  }
  @FXML
        public void getAllTweets(MouseEvent event) throws Exception{
          System.out.println("Ok");
  }
}
