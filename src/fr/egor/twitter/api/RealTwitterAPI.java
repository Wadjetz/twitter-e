package fr.egor.twitter.api;

import twitter4j.*;
import java.util.List;

public class RealTwitterAPI implements ITwitterAPI {

  private Twitter twitter = null;
  private User user = null;

  public RealTwitterAPI() throws TwitterException {
    this.twitter = new TwitterFactory().getInstance();
    this.user = this.twitter.verifyCredentials();
  }

  @Override
  public List<Status> getHomeTimeline() throws TwitterException {
    return twitter.getHomeTimeline();
  }

  @Override
  public String getProfileImageUrl() throws TwitterException {
    String url = user.getOriginalProfileImageURL().toString();
    System.out.println(url);
    return url;
  }

  @Override
  public String getFullName() throws TwitterException {
    return user.getName();
  }

  @Override
  public String getFullScreenName() throws TwitterException {
    return user.getScreenName();
  }

  @Override
  public String getTweetsCountProfil() throws TwitterException {
    return String.valueOf(user.getStatusesCount());
  }

  @Override
  public String getFriendsCountProfil() throws TwitterException {
    return String.valueOf(user.getFriendsCount());
  }

  @Override
  public String getFollowersCountProfil() throws TwitterException {
    return String.valueOf(user.getFollowersCount());
  }

  @Override
  public void getTrendsProfile() throws TwitterException {
    Trends trends = twitter.getPlaceTrends(1);
    System.out.println(trends);
  }

  @Override
  public void postTweet(String content) throws TwitterException {
    twitter.updateStatus(content);
  }

  @Override
  public void setListener(StatusListener statusListener) {
    TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
    twitterStream.addListener(statusListener);
    twitterStream.user();
  }
}
