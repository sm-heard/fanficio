package com.smheard.fanficio;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.smheard.fanficio.service.FanficioDatabase;

public class FanficioApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    FanficioDatabase.setApplicationContext(this);
    final FanficioDatabase database = FanficioDatabase.getInstance();
  }
}
