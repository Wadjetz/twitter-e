package fr.egor.twitter.api;

import twitter4j.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FakeTwitterAPI implements ITwitterAPI {

  @Override
  public List<Status> getHomeTimeline(Paging p) throws TwitterException {
    return new ArrayList<>();
  }

  @Override
  public User getUser() throws TwitterException {
    return new User() {
      @Override
      public long getId() {
        return 0;
      }

      @Override
      public String getName() {
        return "Egor";
      }

      @Override
      public String getScreenName() {
        return "Wadjetz";
      }

      @Override
      public String getLocation() {
        return null;
      }

      @Override
      public String getDescription() {
        return null;
      }

      @Override
      public boolean isContributorsEnabled() {
        return false;
      }

      @Override
      public String getProfileImageURL() {
        return null;
      }

      @Override
      public String getBiggerProfileImageURL() {
        return null;
      }

      @Override
      public String getMiniProfileImageURL() {
        return null;
      }

      @Override
      public String getOriginalProfileImageURL() {
        return null;
      }

      @Override
      public String getProfileImageURLHttps() {
        return null;
      }

      @Override
      public String getBiggerProfileImageURLHttps() {
        return null;
      }

      @Override
      public String getMiniProfileImageURLHttps() {
        return null;
      }

      @Override
      public String getOriginalProfileImageURLHttps() {
        return null;
      }

      @Override
      public boolean isDefaultProfileImage() {
        return false;
      }

      @Override
      public String getURL() {
        return null;
      }

      @Override
      public boolean isProtected() {
        return false;
      }

      @Override
      public int getFollowersCount() {
        return 0;
      }

      @Override
      public Status getStatus() {
        return null;
      }

      @Override
      public String getProfileBackgroundColor() {
        return null;
      }

      @Override
      public String getProfileTextColor() {
        return null;
      }

      @Override
      public String getProfileLinkColor() {
        return null;
      }

      @Override
      public String getProfileSidebarFillColor() {
        return null;
      }

      @Override
      public String getProfileSidebarBorderColor() {
        return null;
      }

      @Override
      public boolean isProfileUseBackgroundImage() {
        return false;
      }

      @Override
      public boolean isDefaultProfile() {
        return false;
      }

      @Override
      public boolean isShowAllInlineMedia() {
        return false;
      }

      @Override
      public int getFriendsCount() {
        return 0;
      }

      @Override
      public Date getCreatedAt() {
        return null;
      }

      @Override
      public int getFavouritesCount() {
        return 0;
      }

      @Override
      public int getUtcOffset() {
        return 0;
      }

      @Override
      public String getTimeZone() {
        return null;
      }

      @Override
      public String getProfileBackgroundImageURL() {
        return null;
      }

      @Override
      public String getProfileBackgroundImageUrlHttps() {
        return null;
      }

      @Override
      public String getProfileBannerURL() {
        return null;
      }

      @Override
      public String getProfileBannerRetinaURL() {
        return null;
      }

      @Override
      public String getProfileBannerIPadURL() {
        return null;
      }

      @Override
      public String getProfileBannerIPadRetinaURL() {
        return null;
      }

      @Override
      public String getProfileBannerMobileURL() {
        return null;
      }

      @Override
      public String getProfileBannerMobileRetinaURL() {
        return null;
      }

      @Override
      public boolean isProfileBackgroundTiled() {
        return false;
      }

      @Override
      public String getLang() {
        return null;
      }

      @Override
      public int getStatusesCount() {
        return 0;
      }

      @Override
      public boolean isGeoEnabled() {
        return false;
      }

      @Override
      public boolean isVerified() {
        return false;
      }

      @Override
      public boolean isTranslator() {
        return false;
      }

      @Override
      public int getListedCount() {
        return 0;
      }

      @Override
      public boolean isFollowRequestSent() {
        return false;
      }

      @Override
      public URLEntity[] getDescriptionURLEntities() {
        return new URLEntity[0];
      }

      @Override
      public URLEntity getURLEntity() {
        return null;
      }

      @Override
      public String[] getWithheldInCountries() {
        return new String[0];
      }

      @Override
      public int compareTo(User o) {
        return 0;
      }

      @Override
      public RateLimitStatus getRateLimitStatus() {
        return null;
      }

      @Override
      public int getAccessLevel() {
        return 0;
      }
    };
  }

  @Override
  public Status postTweet(String content) throws TwitterException {
    System.out.println("Post Tweet: " + content);
    return null;
  }

}
