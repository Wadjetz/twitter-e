package fr.egor.twitter.api;

import twitter4j.*;

import java.util.List;

public class TwitterAPI {

  private static ITwitterAPI twitterAPI = null;

  private TwitterAPI() throws TwitterException {}

  public static ITwitterAPI getInstance() throws TwitterException {
    if (twitterAPI == null) {
      twitterAPI = new RealTwitterAPI();
    }
    return twitterAPI;
  }

}
