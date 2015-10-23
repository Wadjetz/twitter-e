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
  public List<Status> getHomeTimeline(Paging p) throws TwitterException {
    return twitter.getHomeTimeline(p);
  }

  @Override
  public User getUser() throws TwitterException {
    return user;
  }


  @Override
  public Status postTweet(String content) throws TwitterException {
    return twitter.updateStatus(content);
  }

}
