package com.kerboocorp.bb.managers;

import com.kerboocorp.bb.model.Post;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by cgo on 16/01/2015.
 */
public interface PostManager {

    //public List<Post> findPostList(int page);

    @GET("/posts")
    public void findPostList(Callback<List<Post>> postList);
}
