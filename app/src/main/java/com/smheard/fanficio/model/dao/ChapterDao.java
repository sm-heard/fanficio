package com.smheard.fanficio.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.smheard.fanficio.model.entity.Chapter;

/**
 * Specifies database access for chapters
 */
@Dao
public interface ChapterDao {

  /**
   * add a chapter
   * @param chapter
   * @return
   */
  @Insert
  long addChapter(Chapter chapter);

  /**
   * get a chapter
   * @param chapterId
   * @return
   */
  @Query("SELECT * FROM chapter WHERE chapter_id = :chapterId")
  Chapter getChapter(long chapterId);

  /**
   * update a chapter
   * @param chapter
   * @return
   */
  @Update
  int update(Chapter chapter);

  /**
   * delete chapters
   * @param chapters
   * @return
   */
  @Delete
  int delete(Chapter...chapters);

}
