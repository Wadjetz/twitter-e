package fr.egor.twitter;

import twitter4j.*;

import java.util.List;

public class TwitterAPI {

  public List<Status> getHomeTimeline() throws TwitterException {
    Twitter twitter = new TwitterFactory().getInstance();
    User user = twitter.verifyCredentials();
    return twitter.getHomeTimeline();
  }

  public String getProfileImageUrl()throws TwitterException{
    Twitter twitter = new TwitterFactory().getInstance();
    User user = twitter.verifyCredentials();
    return user.getOriginalProfileImageURL().toString();
  }
  public String getFullName() throws TwitterException{
    Twitter twitter = new TwitterFactory().getInstance();
    User user = twitter.verifyCredentials();
    return user.getName();
  }

  public String getFullScreenName() throws TwitterException{
    Twitter twitter = new TwitterFactory().getInstance();
    User user = twitter.verifyCredentials();
    return user.getScreenName();
  }
  public String getTweetsCountProfil() throws TwitterException{
    Twitter twitter = new TwitterFactory().getInstance();
    User user = twitter.verifyCredentials();
    return String.valueOf(user.getStatusesCount());
  }
  public String getFriendsCountProfil() throws TwitterException{
    Twitter twitter = new TwitterFactory().getInstance();
    User user = twitter.verifyCredentials();
    return String.valueOf(user.getFriendsCount());
  }
  public String getFollowersCountProfil() throws TwitterException{
    Twitter twitter = new TwitterFactory().getInstance();
    User user = twitter.verifyCredentials();
    return String.valueOf(user.getFollowersCount());
  }




  public void setListener(StatusListener statusListener) {
    TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
    twitterStream.addListener(statusListener);
    twitterStream.user();
  }
}
