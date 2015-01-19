package com.kerboocorp.bb.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kerboocorp.bb.R;
import com.kerboocorp.bb.model.Post;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by cgo on 16/01/2015.
 */
public class PostAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Post> postList;
    private int rowLayout;
    private Context context;

    public PostAdapter(int rowLayout, Context context) {
        this.postList = new ArrayList<Post>();
        this.rowLayout = rowLayout;
        this.context = context;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void addPostList(List<Post> postList) {
        this.postList.addAll(postList);
        notifyDataSetChanged();
    }

    public void addEvent(Post post) {
        postList.add(post);
        notifyDataSetChanged();
    }

    public void removeEvent(Post post) {
        postList.remove(post);
        notifyDataSetChanged();
    }


    public void clearPostList() {
        postList.clear();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new EventViewHolder(v);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

        if (viewHolder instanceof EventViewHolder) {

            EventViewHolder eventViewHolder = (EventViewHolder) viewHolder;
            Post post = postList.get(i);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            eventViewHolder.date.setText(dateFormat.format(post.getUploadDate()));
        }

    }

    @Override
    public int getItemCount() {
        return (postList == null ? 0 : postList.size());
    }


    public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView date;
        public GifImageView boobsImageView;
        public GifDrawable boobsDrawable;
        public LinearLayout playButtonLayout;
        //public Context context;

        public EventViewHolder(View itemView) {
            super(itemView);

            date = ButterKnife.findById(itemView, R.id.dateTextView);
            boobsImageView = ButterKnife.findById(itemView, R.id.boobsImageView);
            boobsImageView.setAlpha(0.5f);

//            Picasso.
//                    with(context).
//                    load("http://38.media.tumblr.com/tumblr_m3jyvcqp5Y1qjlzdho1_500.gif").
//                    into(boobsImageView);

            playButtonLayout = ButterKnife.findById(itemView, R.id.playButtonLayout);

            boobsDrawable = (GifDrawable) boobsImageView.getDrawable();
            boobsDrawable.stop();

            boobsImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (boobsDrawable.isPlaying()) {
                        boobsDrawable.stop();
                        boobsImageView.setAlpha(0.5f);
                        playButtonLayout.setVisibility(View.VISIBLE);
                    } else {
                        boobsDrawable.start();
                        boobsImageView.setAlpha(1f);
                        playButtonLayout.setVisibility(View.GONE);
                    }
                }
            });

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            Intent intent = new Intent(context, EventActivity.class);
//            intent.putExtra("event", (Parcelable)event);
//            intent.putExtra("action", "update");
//            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//            EventAdapter.this.activity.startActivityForResult(intent, 2);
        }
    }
}