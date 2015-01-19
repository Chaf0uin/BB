package com.kerboocorp.bb.managers.impl;

import com.kerboocorp.bb.managers.PostManager;
import com.kerboocorp.bb.model.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit.RestAdapter;

/**
 * Created by cgo on 16/01/2015.
 */
public class PostManagerImpl  {

    private PostManager service;
    private static PostManagerImpl instance = new PostManagerImpl();

    private PostManagerImpl() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://evening-brushlands-1756.herokuapp.com/api/v1")
                .build();

        service = restAdapter.create(PostManager.class);
    }

    //public static PostManager getInstance() {
   //     return instance;
   // }

//    @Override
//    public List<Post> findPostList(int page) {
//
//        List<Post> postList = new ArrayList<Post>();
//
//        Post post = new Post();
//        post.setCreatedAt("12/12/2015");
//        postList.add(post);
//
//        post = new Post();
//        post.setCreatedAt("12/12/2015");
//        postList.add(post);
//
//        return postList;
//    }

//    @Override
//    public void findPostList() {
//        service.findPostList();
//    }
}
