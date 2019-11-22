package com.smheard.fanficio.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Story.class,
            childColumns = "story_id",
            parentColumns = "story_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class Chapter {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "chapter_id")
  long chapterId;

  @ColumnInfo(name = "story_id", index = true )
  private long storyId;

  @NonNull
  String chapterName;

  @NonNull
  Date lastUpdate = new Date();

  @NonNull
  Date lastRead = new Date();

  public long getChapterId() {
    return chapterId;
  }

  public void setChapterId(long chapterId) {
    this.chapterId = chapterId;
  }

  public long getStoryId() {
    return storyId;
  }

  public void setStoryId(long storyId) {
    this.storyId = storyId;
  }

  @NonNull
  public String getChapterName() {
    return chapterName;
  }

  public void setChapterName(@NonNull String chapterName) {
    this.chapterName = chapterName;
  }

  @NonNull
  public Date getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(@NonNull Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  @NonNull
  public Date getLastRead() {
    return lastRead;
  }

  public void setLastRead(@NonNull Date lastRead) {
    this.lastRead = lastRead;
  }
}
