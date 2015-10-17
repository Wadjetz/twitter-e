package fr.egor.twitter.api;

import twitter4j.*;

import java.util.List;

public class TwitterAPI implements ITwitterAPI {

  private ITwitterAPI twitterAPI = null;

  public TwitterAPI() throws TwitterException {
    twitterAPI = new FakeTwitterAPI();
  }

  @Override
  public List<Status> getHomeTimeline() throws TwitterException {
    return twitterAPI.getHomeTimeline();
  }

  @Override
  public String getProfileImageUrl() throws TwitterException{
    return twitterAPI.getProfileImageUrl();
  }

  @Override
  public String getFullName() throws TwitterException{
    return twitterAPI.getFullName();
  }

  @Override
  public String getFullScreenName() throws TwitterException{
    return twitterAPI.getFullScreenName();
  }

  @Override
  public String getTweetsCountProfil() throws TwitterException{
    return twitterAPI.getTweetsCountProfil();
  }

  @Override
  public String getFriendsCountProfil() throws TwitterException{
    return twitterAPI.getFriendsCountProfil();
  }

  @Override
  public String getFollowersCountProfil() throws TwitterException{
    return twitterAPI.getFollowersCountProfil();
  }

  @Override
  public void getTrendsProfile() throws TwitterException{
    twitterAPI.getTrendsProfile();
  }

  @Override
  public void postTweet(String content) throws TwitterException {
    twitterAPI.postTweet(content);
  }

  @Override
  public void setListener(StatusListener statusListener) {
    twitterAPI.setListener(statusListener);
  }
}
