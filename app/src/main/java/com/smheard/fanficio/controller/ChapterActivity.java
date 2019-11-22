package com.smheard.fanficio.controller;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.smheard.fanficio.R;
import com.smheard.fanficio.view.ChapterListAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ChapterActivity extends AppCompatActivity {

  private RecyclerView recyclerView;

  private ArrayList<String> storyLinks = new ArrayList<>();
  private int position;



  private ArrayList<String> chapterTitles = new ArrayList<>();

  private ChapterListAdapter chapterListAdapter;
  private ProgressBar progressBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    int position = getIntent().getExtras().getInt("position");
    this.position = position;

    setContentView(R.layout.activity_main);
    recyclerView = findViewById(R.id.recycler_view);

    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor editor = preferences.edit();
    editor.putInt("story",position);
    editor.commit();
    editor.apply();

    initRecyclerView();
    new Load2().execute();
  }


  private class Load2 extends AsyncTask<Void,Void, Document> {

    @Override
    protected void onPreExecute() {
      progressBar = findViewById(R.id.progress_circular);
    }

    @Override
    protected Document doInBackground(Void... voids) {
      Document document = null;
      try {
        String root = "https://www.fanfiction.net/u/2819468/Samghost";

        document = Jsoup.connect(root)
            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:70.0) Gecko/20100101 Firefox/70.0")
            .followRedirects(true)
            .get();

      } catch (IOException e) {
        e.printStackTrace();
      }
        return document;
      }

      @Override
      protected void onPostExecute (Document document){
        progressBar.setVisibility(View.GONE);


        Elements stitles = document.getElementsByClass("stitle");
        for (Element stitle : stitles) {

          Pattern pattern = Pattern.compile("(s/\\d+/)");
          Matcher matcher = pattern.matcher(stitle.attr("href"));
          while (matcher.find()) {
            storyLinks.add(matcher.group().trim());
          }
        }
        new Load3().execute();
      }
    }



  private class Load3 extends AsyncTask<Void,Void, Document> {

    @Override
    protected void onPreExecute() {
      progressBar = findViewById(R.id.progress_circular);
    }

    @Override
    protected Document doInBackground(Void... voids) {
      Document document = null;

      try {
        String root = "https://www.fanfiction.net/"+storyLinks.get(position);
        document = Jsoup.connect(root)
            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:70.0) Gecko/20100101 Firefox/70.0")
            .followRedirects(true)
            .get();
      } catch (IOException e) {
        e.printStackTrace();
      }

      return document;
    }

    @Override
    protected void onPostExecute (Document document){

      Pattern pattern = Pattern.compile("Chapters: (\\d+)");
      Matcher matcher = pattern.matcher(document.body().text());

      int numOfChapters = 0;
      while (matcher.find()) {
        numOfChapters = Integer.parseInt(matcher.group(1));
      }
      if (numOfChapters == 0) {
        numOfChapters = 1;
      }

      for (int i = 1; i < numOfChapters+1; i++) {
        chapterTitles.add(String.valueOf(i));
      }

      progressBar.setVisibility(View.GONE);
      chapterListAdapter.notifyDataSetChanged();
    }
  }


    private void initRecyclerView() {
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
      chapterListAdapter = new ChapterListAdapter(chapterTitles);

      recyclerView.setLayoutManager(linearLayoutManager);
      recyclerView.setAdapter(chapterListAdapter);
    }

  }


