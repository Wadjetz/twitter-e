package fr.egor.twitter.main;

import fr.egor.twitter.api.TwitterAPI;
import fr.egor.twitter.async.Async;
import fr.egor.twitter.view.tweet.list.TweetCell;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.User;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
  private HashMap<String, List<Status>> save = new HashMap<>();
  private ObservableList<Status> tweetsList = FXCollections.observableArrayList();
  private int page = 1;
  private int nb = 20;
  @FXML
  public ImageView userPictureByUrl;
  @FXML
  public Label fullNameProfil;
  @FXML
  public Label currentPage;
  @FXML
  public Label screenNameProfil;
  @FXML
  public Label tweetsNombers;
  @FXML
  public Label abonnementsNumbers;
  @FXML
  public Label abonnesNumbers;
  @FXML
  public ListView<Status> tweets;
  @FXML
  public TextArea tweetContent;
  @FXML
  public Label wordCount;
  @FXML
  public Button tweetSend;
  @FXML
  public Button update;

  @FXML
  protected void sendTweetButtonAction(ActionEvent event) {
    String text = tweetContent.getText();
    System.out.println(text);
    Async.async(() -> {
      Status s = TwitterAPI.getInstance().postTweet(text);
      Platform.runLater(() -> {
        tweetsList.add(0, s);
        tweetContent.setText("");
      });
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

  @FXML
  protected void updateTweets(Event event) {
    System.out.println("updateTweets");
    Async.async(() -> {
      List<Status> list = TwitterAPI.getInstance().getHomeTimeline(new Paging(page, nb));
      save.put(page+"", list);
      tweetsList.addAll(list);
      return null;
    });
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    Async.async(() -> {
      User user = TwitterAPI.getInstance().getUser();

      Platform.runLater(() -> {
        userPictureByUrl.setImage(new Image(user.getOriginalProfileImageURL()));
        fullNameProfil.setText(user.getName());
        screenNameProfil.setText("@" + user.getScreenName());
        tweetsNombers.setText(user.getStatusesCount() + "");
        abonnementsNumbers.setText(user.getFriendsCount() + "");
        abonnesNumbers.setText(user.getFollowersCount() + "");
      });
      return null;
    });

    Async.async(() -> {
      List<Status> list = TwitterAPI.getInstance().getHomeTimeline(new Paging(page, nb));
      save.put(page+"", list);
      Platform.runLater(() -> {
        tweetsList.addAll(list);
      });
      return null;
    });

    tweets.setItems(tweetsList);
    tweets.setCellFactory(param -> new TweetCell());
  }

  public void nextTweets(ActionEvent e) {
    page++;
    System.out.println("nextTweets page=" + page);
    List<Status> saved = save.get(page+"");
    if (saved == null) {
      System.out.println("previousTweets saved=null");
      Async.async(() -> {
        Paging paging = new Paging(page, nb);
        List<Status> list = TwitterAPI.getInstance().getHomeTimeline(paging);
        save.put(page+"", list);
        Platform.runLater(() -> {
          tweetsList.setAll(list);
          currentPage.setText(page+"");
        });
        return null;
      });
    } else {
      System.out.println("previousTweets saved=" + saved.size());
      Platform.runLater(() -> tweetsList.setAll(saved));
    }
  }

  public void previousTweets(ActionEvent e) {
    if (page > 1) {
      page--;
      System.out.println("previousTweets page=" + page);
      List<Status> saved = save.get(page+"");
      if (saved == null) {
        System.out.println("previousTweets saved=null");
        Async.async(() -> {
          Paging paging = new Paging(page, nb);
          List<Status> list = TwitterAPI.getInstance().getHomeTimeline(paging);
          save.put(page+"", list);

          Platform.runLater(() -> {
            tweetsList.setAll(list);
            currentPage.setText(page+"");
          });
          return null;
        });
      } else {
        System.out.println("previousTweets saved=" + saved.size());
        Platform.runLater(() -> tweetsList.setAll(saved));
      }
    }
  }
}
