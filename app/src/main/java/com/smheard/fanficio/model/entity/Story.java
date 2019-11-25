package com.smheard.fanficio.model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

/**
 * story object
 */
@Entity()
public class Story {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "story_id")
  private long storyId;

  private String storyName;

  @NonNull
  private Date lastUpdated = new Date();

  @NonNull
  private boolean favorite;

  @NonNull
  private boolean alert;

  /**
   * get story id
   * @return
   */
  public long getStoryId() {
    return storyId;
  }

  /**
   * set story id
   * @param storyId
   */
  public void setStoryId(long storyId) {
    this.storyId = storyId;
  }

  /**
   * get story name
   * @return
   */
  public String getStoryName() {
    return storyName;
  }

  /**
   * set story name
   * @param storyName
   */
  public void setStoryName(String storyName) {
    this.storyName = storyName;
  }

  /**
   * get last updated
   * @return
   */
  @NonNull
  public Date getLastUpdated() {
    return lastUpdated;
  }

  /**
   * set last updated
   * @param lastUpdated
   */
  public void setLastUpdated(@NonNull Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  /**
   * get if favorite
   * @return
   */
  public boolean isFavorite() {
    return favorite;
  }

  /**
   * set if favorite
   * @param favorite
   */
  public void setFavorite(boolean favorite) {
    this.favorite = favorite;
  }

  /**
   * get if alert
   * @return
   */
  public boolean isAlert() {
    return alert;
  }

  /**
   * set if alert
   * @param alert
   */

  public void setAlert(boolean alert) {
    this.alert = alert;
  }
}
