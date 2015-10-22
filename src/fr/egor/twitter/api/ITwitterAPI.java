package fr.egor.twitter.api;

import twitter4j.*;
import java.util.List;

public interface ITwitterAPI {
  List<Status> getHomeTimeline() throws TwitterException;
  String getProfileImageUrl() throws TwitterException;
  String getFullName() throws TwitterException;
  String getFullScreenName() throws TwitterException;
  String getTweetsCountProfil() throws TwitterException;
  String getFriendsCountProfil() throws TwitterException;
  String getFollowersCountProfil() throws TwitterException;
  void getTrendsProfile() throws TwitterException;
  void postTweet(String content) throws TwitterException;
  void setListener(StatusListener statusListener);
}
