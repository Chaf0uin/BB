package com.kerboocorp.bb.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.kerboocorp.bb.R;
import com.kerboocorp.bb.adapters.PostAdapter;
import com.kerboocorp.bb.managers.PostClient;
import com.kerboocorp.bb.model.Post;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.toolbar) Toolbar toolbar;
    @InjectView(R.id.postList) RecyclerView postListView;
    @InjectView(R.id.progressLayout) RelativeLayout progressLayout;

    private LinearLayoutManager linearLayoutManager;
    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        linearLayoutManager = new LinearLayoutManager(this);
        postListView.setLayoutManager(linearLayoutManager);
        postListView.setItemAnimator(new DefaultItemAnimator());

        postAdapter = new PostAdapter(R.layout.list_item_post, this);
        postListView.setAdapter(postAdapter);

        List<Post> postList = new ArrayList<Post>();

        postAdapter.addPostList(postList);

        PostClient.getPostService().findPostList(new Callback<List<Post>>() {
            @Override
            public void success(List<Post> posts, Response response) {
                progressLayout.setVisibility(View.GONE);
                List<Post> p = posts;
                postAdapter.addPostList(p);
                Log.d("TEST", "OKEEEEE");
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
