package fr.egor.twitter.api;

import twitter4j.Status;
import twitter4j.StatusListener;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.List;

public class FakeTwitterAPI implements ITwitterAPI {

  @Override
  public List<Status> getHomeTimeline() throws TwitterException {
    return new ArrayList<>();
  }

  @Override
  public String getProfileImageUrl() throws TwitterException {
    return "http://pbs.twimg.com/profile_images/378800000529911160/f77734e24b62d1ea212a1eb4f57bfd52.jpeg";
  }

  @Override
  public String getFullName() throws TwitterException {
    return "Egor";
  }

  @Override
  public String getFullScreenName() throws TwitterException {
    return "Wadjetz";
  }

  @Override
  public String getTweetsCountProfil() throws TwitterException {
    return "43";
  }

  @Override
  public String getFriendsCountProfil() throws TwitterException {
    return "4";
  }

  @Override
  public String getFollowersCountProfil() throws TwitterException {
    return "56";
  }

  @Override
  public void getTrendsProfile() throws TwitterException {

  }

  @Override
  public void postTweet(String content) throws TwitterException {
    System.out.println("Post Tweet: " + content);
  }

  @Override
  public void setListener(StatusListener statusListener) {

  }
}
