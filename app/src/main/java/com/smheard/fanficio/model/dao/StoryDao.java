package com.smheard.fanficio.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.smheard.fanficio.model.entity.Story;

/**
 * specifies database access for stories
 */
@Dao
public interface StoryDao {

  /**
   * add a story
   * @param story
   * @return
   */
  @Insert
  long addStory(Story story);

  /**
   * get a story
   * @param storyId
   * @return
   */
  @Query("SELECT * FROM story WHERE story_id = :storyId")
  Story getStory(long storyId);

  /**
   * update a story
   * @param story
   * @return
   */
  @Update
  int update(Story story);

  /**
   * delete stories
   * @param storys
   * @return
   */
  @Delete
  int delete(Story...storys);
}
