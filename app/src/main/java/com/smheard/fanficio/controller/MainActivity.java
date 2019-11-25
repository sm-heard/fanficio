package com.smheard.fanficio.controller;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.smheard.fanficio.FanficioApplication;
import com.smheard.fanficio.R;
import com.smheard.fanficio.model.entity.Story;
import com.smheard.fanficio.service.FanficioDatabase;
import com.smheard.fanficio.view.StoryListAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainActivity extends AppCompatActivity {

  private RecyclerView recyclerView;

  private FanficioDatabase database;

  private ArrayList<String> storyTitles = new ArrayList<>();

  private StoryListAdapter storyListAdapter;

  private ProgressBar progressBar;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    final FanficioDatabase database = FanficioDatabase.getInstance();
    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.HORIZONTAL));

    initRecyclerView();
    new Load().execute();

  }

  private class Load extends AsyncTask<Void,Void,Document>{

    @Override
    protected void onPreExecute() {
      progressBar = findViewById(R.id.progress_circular);
    }

    @Override
    protected Document doInBackground(Void... voids) {
      Document document = null;
      try {
        String root ="https://www.fanfiction.net/u/2819468/Samghost";

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
    protected void onPostExecute(Document document) {
      Elements stitles =  document.getElementsByClass("stitle");
      for (Element stitle:stitles) {
        storyTitles.add(stitle.text());
        //adding story to db
//        Story story = new Story();
//        story.setStoryName(stitle.text());
//        database.getStoryDao().addStory(story);
      }

      progressBar.setVisibility(View.GONE);
      storyListAdapter.notifyDataSetChanged();
    }
  }

  private void initRecyclerView(){
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    storyListAdapter = new StoryListAdapter(storyTitles);

    recyclerView.setLayoutManager(linearLayoutManager);
    recyclerView.setAdapter(storyListAdapter);

  }
}
