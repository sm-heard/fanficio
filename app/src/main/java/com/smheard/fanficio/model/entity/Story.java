package com.smheard.fanficio.model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity
public class Story {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "story_id")
  long storyId;

  String storyName;

  @NonNull
  Date lastUpdated = new Date();

  @NonNull
  boolean favorite;

  @NonNull
  boolean alert;

  public long getStoryId() {
    return storyId;
  }

  public void setStoryId(long storyId) {
    this.storyId = storyId;
  }

  public String getStoryName() {
    return storyName;
  }

  public void setStoryName(String storyName) {
    this.storyName = storyName;
  }

  @NonNull
  public Date getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(@NonNull Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public boolean isFavorite() {
    return favorite;
  }

  public void setFavorite(boolean favorite) {
    this.favorite = favorite;
  }

  public boolean isAlert() {
    return alert;
  }

  public void setAlert(boolean alert) {
    this.alert = alert;
  }
}
