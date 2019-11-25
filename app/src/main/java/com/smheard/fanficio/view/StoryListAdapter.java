package com.smheard.fanficio.view;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.smheard.fanficio.R;
import com.smheard.fanficio.controller.ChapterActivity;
import com.smheard.fanficio.view.StoryListAdapter.ViewHolder;
import java.util.ArrayList;

/**
 * adds stories to recyclerview
 */
public class StoryListAdapter extends RecyclerView.Adapter<ViewHolder> {

  private ArrayList<String> storyTitles = new ArrayList<>();

  public ArrayList<String> getStoryTitles() {
    return storyTitles;
  }

  public StoryListAdapter(ArrayList<String> storyTitles) {
    this.storyTitles = storyTitles;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_list_item,parent,false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.storyTitle.setText(storyTitles.get(position));
    holder.storyTitle.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), ChapterActivity.class);
        intent.putExtra("position",position);
        v.getContext().startActivity(intent);
      }
    });

  }

  @Override
  public int getItemCount() {
    return storyTitles.size();
  }


  public class ViewHolder extends RecyclerView.ViewHolder{

    TextView storyTitle;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      storyTitle = itemView.findViewById(R.id.story_title);
    }
  }

}
