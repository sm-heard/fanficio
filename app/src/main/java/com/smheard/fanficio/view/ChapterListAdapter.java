package com.smheard.fanficio.view;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.smheard.fanficio.R;
import com.smheard.fanficio.controller.ChapterActivity;
import com.smheard.fanficio.controller.ChapterTextActivity;
import com.smheard.fanficio.view.ChapterListAdapter.ViewHolder;
import java.util.ArrayList;

/**
 * adds chapters to recyclerview
 */
public class ChapterListAdapter extends RecyclerView.Adapter<ViewHolder> {



  private ArrayList<String> chapterTitles = new ArrayList<>();

  public ArrayList<String> getChapterTitles() {
    return chapterTitles;
  }

  public ChapterListAdapter(ArrayList<String> chapterTitles) {
    this.chapterTitles = chapterTitles;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater
        .from(parent.getContext()).inflate(R.layout.story_list_item,parent,false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.chapterTitle.setText(chapterTitles.get(position));
    holder.chapterTitle.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), ChapterTextActivity.class);
        intent.putExtra("position",position);
        v.getContext().startActivity(intent);
      }
    });

  }

  @Override
  public int getItemCount() {return chapterTitles.size(); }


  public class ViewHolder extends RecyclerView.ViewHolder{

    TextView chapterTitle;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      chapterTitle = itemView.findViewById(R.id.story_title);
    }
  }

}
