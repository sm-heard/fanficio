package com.smheard.fanficio.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import com.smheard.fanficio.model.dao.ChapterDao;
import com.smheard.fanficio.model.dao.StoryDao;
import com.smheard.fanficio.model.entity.Chapter;
import com.smheard.fanficio.model.entity.Story;
import java.util.Date;

@Database(
    entities = {Story.class, Chapter.class},
version = 1,exportSchema = true
)
@TypeConverters(FanficioDatabase.Converters.class)
public abstract class FanficioDatabase extends RoomDatabase {

  private static Application applicationContext;
  protected FanficioDatabase(){};

  public static void setApplicationContext(Application applicationContext) {
    FanficioDatabase.applicationContext = applicationContext;
  }

  private static class InstanceHolder {
    private static final FanficioDatabase INSTANCE;
    static {
      INSTANCE =
          Room.databaseBuilder(applicationContext, FanficioDatabase.class, "fanficio_db").build();
    }
  }

  public static FanficioDatabase getInstance(){
    return InstanceHolder.INSTANCE;
  }

  public abstract ChapterDao getChapterDao();
  public abstract StoryDao getStoryDao();

  public static class Converters {
    @TypeConverter
    public Long dateToLong(Date date) {
      return (date != null) ? date.getTime() : null;
    }

    @TypeConverter
    public Date longToDate(Long milliseconds) {
      return (milliseconds != null) ? new Date(milliseconds) : null; }

  }

}
