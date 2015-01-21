package com.kerboocorp.bb.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.kerboocorp.bb.R;
import com.kerboocorp.bb.model.Post;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
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
        return new PostViewHolder(v);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

        if (viewHolder instanceof PostViewHolder) {

            final PostViewHolder postViewHolder = (PostViewHolder) viewHolder;
            Post post = postList.get(i);

            SimpleDateFormat inDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            SimpleDateFormat outDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            try {
                postViewHolder.date.setText(outDateFormat.format(inDateFormat.parseObject(post.getCreatedAt())));
            } catch (ParseException e) {
                postViewHolder.date.setText(post.getCreatedAt());
            }

            Glide.with(context).load(post.getUrlImage()).into(new GlideDrawableImageViewTarget(postViewHolder.boobsImageView) {
                @Override
                public void onResourceReady(final GlideDrawable drawable, GlideAnimation anim) {
                    super.onResourceReady(drawable, anim);
                    drawable.stop();

                    postViewHolder.boobsImageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (drawable.isRunning()) {
                                drawable.stop();
                                postViewHolder.boobsImageView.setAlpha(0.5f);
                            } else {
                                drawable.start();
                                postViewHolder.boobsImageView.setAlpha(1f);
                            }
                        }
                    });

                }
            });

            //Glide.with(context).load(post.getUrlImage()).into(postViewHolder.boobsImageView);
        }

    }

    @Override
    public int getItemCount() {
        return (postList == null ? 0 : postList.size());
    }


    public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView date;
        public ImageView boobsImageView;
        public LinearLayout playButtonLayout;

        public PostViewHolder(View itemView) {
            super(itemView);

            date = ButterKnife.findById(itemView, R.id.dateTextView);
            boobsImageView = ButterKnife.findById(itemView, R.id.boobsImageView);
            boobsImageView.setAlpha(0.5f);

            playButtonLayout = ButterKnife.findById(itemView, R.id.playButtonLayout);

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