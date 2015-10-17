package fr.egor.twitter.api;

import twitter4j.*;

import java.util.List;

public interface ITwitterAPI {
  public List<Status> getHomeTimeline() throws TwitterException;
  public String getProfileImageUrl() throws TwitterException;
  public String getFullName() throws TwitterException;
  public String getFullScreenName() throws TwitterException;
  public String getTweetsCountProfil() throws TwitterException;
  public String getFriendsCountProfil() throws TwitterException;
  public String getFollowersCountProfil() throws TwitterException;
  public void getTrendsProfile() throws TwitterException;
  public void postTweet(String content) throws TwitterException;
  public void setListener(StatusListener statusListener);
}
