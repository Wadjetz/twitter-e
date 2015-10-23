package fr.egor.twitter.api;

import twitter4j.*;
import java.util.List;

public interface ITwitterAPI {
  List<Status> getHomeTimeline(Paging p) throws TwitterException;
  User getUser() throws TwitterException;
  Status postTweet(String content) throws TwitterException;
}
