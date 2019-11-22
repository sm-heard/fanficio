package com.smheard.fanficio.controller;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.text.HtmlCompat;
import com.smheard.fanficio.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ChapterTextActivity extends AppCompatActivity {


  private ArrayList<String> storyLinks = new ArrayList<>();
  private ArrayList<String> chapterText = new ArrayList<>();
  //String chapterText;

  private int storyPosition;
  private int chapterPosition;

  private ProgressBar progressBar;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    chapterPosition = getIntent().getExtras().getInt("position") + 1;

    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    storyPosition = preferences.getInt("story",0);

    setContentView(R.layout.activity_chapter_text);
    //TextView textView = findViewById(R.id.chapter_text);

    //chapterText.add("fuck u arraylist");
    new Load5().execute();


  }

  private class Load5 extends AsyncTask<Void,Void, Document> {

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
      new Load4().execute();
    }
  }


  private class Load4 extends AsyncTask<Void,Void, Document> {

    @Override
    protected void onPreExecute() {
      progressBar = findViewById(R.id.progress_circular);
    }

    @Override
    protected Document doInBackground(Void... voids) {
      Document document = null;

      try {
        String root = "https://www.fanfiction.net/"+storyLinks.get(storyPosition)+chapterPosition;
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

      Spanned formatText = HtmlCompat.fromHtml(document.getElementById("storytext").toString(),HtmlCompat.FROM_HTML_MODE_LEGACY);

      //chapterText.add(formatText);

      progressBar.setVisibility(View.GONE);

      TextView textView = findViewById(R.id.chapter_text);
      textView.setMovementMethod(new ScrollingMovementMethod());
      //textView.setText(chapterText.get(chapterText.size()-1));
      textView.setText(formatText);



    }
  }


}