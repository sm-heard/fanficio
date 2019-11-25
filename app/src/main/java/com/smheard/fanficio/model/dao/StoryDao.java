package com.smheard.fanficio.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.smheard.fanficio.model.entity.Story;

@Dao
public interface StoryDao {

  @Insert
  long addStory(Story story);

  @Query("SELECT * FROM story WHERE story_id = :storyId")
  Story getStory(long storyId);

  @Update
  int update(Story story);

  @Delete
  int delete(Story...storys);
}
