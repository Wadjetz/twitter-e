package fr.egor.twitter;

import twitter4j.*;

import java.util.List;

public class TwitterAPI {

  public List<Status> getHomeTimeline() throws TwitterException {
    Twitter twitter = new TwitterFactory().getInstance();
    User user = twitter.verifyCredentials();
    return twitter.getHomeTimeline();
  }

  public void setListener(StatusListener statusListener) {
    TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
    twitterStream.addListener(statusListener);
    twitterStream.user();
  }
}
