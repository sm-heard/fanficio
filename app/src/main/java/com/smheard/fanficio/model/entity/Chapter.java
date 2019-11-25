package com.smheard.fanficio.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

/**
 * Chapter object
 */
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
  private long chapterId;

  @ColumnInfo(name = "story_id", index = true )
  private long storyId;

  @NonNull
  private String chapterName;

  @NonNull
  private Date lastUpdate = new Date();

  @NonNull
  private Date lastRead = new Date();

  /**
   * get chapterid
   * @return
   */
  public long getChapterId() {
    return chapterId;
  }

  /**
   * set chapterid
   * @param chapterId
   */
  public void setChapterId(long chapterId) {
    this.chapterId = chapterId;
  }

  /**
   * get storyid
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
   * get chapter name
   * @return
   */
  @NonNull
  public String getChapterName() {
    return chapterName;
  }

  /**
   * set chapter name
   * @param chapterName
   */
  public void setChapterName(@NonNull String chapterName) {
    this.chapterName = chapterName;
  }

  /**
   * get last update
   * @return
   */
  @NonNull
  public Date getLastUpdate() {
    return lastUpdate;
  }

  /**
   * set last update
   * @param lastUpdate
   */
  public void setLastUpdate(@NonNull Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  /**
   * get last read
   * @return
   */
  @NonNull
  public Date getLastRead() {
    return lastRead;
  }

  /**
   * set last read
   * @param lastRead
   */
  public void setLastRead(@NonNull Date lastRead) {
    this.lastRead = lastRead;
  }
}
