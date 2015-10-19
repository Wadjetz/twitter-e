package fr.egor.twitter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import twitter4j.*;

import java.util.List;

public class TwitterAPI {
  Twitter twitter;
  User user;
  public TwitterAPI() {
    try {
      twitter= new TwitterFactory().getInstance();
      user=twitter.verifyCredentials();

    }catch (Exception e){
        e.printStackTrace();
    }

  }


  public List<Status> getHomeTimeline() throws TwitterException {
    return twitter.getHomeTimeline();
  }
  public List<Status> getUserTimeline() throws TwitterException {
    return twitter.getUserTimeline();
  }
  public ObservableList<String> getUserTimeLineToString(ObservableList<Status> list) throws TwitterException{
    ObservableList<String> names = FXCollections
            .observableArrayList();

    for (Status status : list) {
     names.add(status.getUser().getScreenName() + " : " + status.getText());
    }
    return names;
  }

  public String getProfileImageUrl()throws TwitterException{
    return user.getOriginalProfileImageURL().toString();
  }
  public String getFullName() throws TwitterException{
    return user.getName();
  }

  public String getFullScreenName() throws TwitterException{
    return user.getScreenName();
  }
  public String getTweetsCountProfil() throws TwitterException{
    return String.valueOf(user.getStatusesCount());
  }
  public String getFriendsCountProfil() throws TwitterException{
    return String.valueOf(user.getFriendsCount());
  }
  public String getFollowersCountProfil() throws TwitterException{
    return String.valueOf(user.getFollowersCount());
  }
  public void getTrendsProfile() throws TwitterException{
      Trends trends = twitter.getPlaceTrends(1);
    //return "";
  }
  public String getAllStatus(List<Status> statuses){
    String str="";
    for (Status status : statuses) {
      str+=("@" + status.getUser().getScreenName() + " - " + status.getText());
    }
    return str;
  }







  public void setListener(StatusListener statusListener) {
    TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
    twitterStream.addListener(statusListener);
    twitterStream.user();
  }
}

