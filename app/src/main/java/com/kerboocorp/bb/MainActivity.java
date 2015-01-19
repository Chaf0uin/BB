package com.kerboocorp.bb;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.kerboocorp.bb.adapters.PostAdapter;
import com.kerboocorp.bb.managers.PostManager;
import com.kerboocorp.bb.managers.impl.PostManagerImpl;
import com.kerboocorp.bb.model.Post;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.toolbar) Toolbar toolbar;
    @InjectView(R.id.postList) RecyclerView postListView;

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

        postAdapter = new PostAdapter(R.layout.list_card_post, this);
        postListView.setAdapter(postAdapter);

        List<Post> posts = PostManagerImpl.getInstance().findPostList();

        postAdapter.addPostList(PostManagerImpl.getInstance().findPostList(1));

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
