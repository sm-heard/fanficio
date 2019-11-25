package com.smheard.fanficio.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.smheard.fanficio.model.entity.Chapter;

@Dao
public interface ChapterDao {

  @Insert
  long addChapter(Chapter chapter);

  @Query("SELECT * FROM chapter WHERE chapter_id = :chapterId")
  Chapter getChapter(long chapterId);

  @Update
  int update(Chapter chapter);

  @Delete
  int delete(Chapter...chapters);

}
