package com.kerboocorp.bb.managers;

import retrofit.RestAdapter;

/**
 * Created by chris on 19/01/15.
 */
public class PostClient {

    private static PostManager postService;

    public static PostManager getPostService() {
        if (postService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("http://evening-brushlands-1756.herokuapp.com/api/v1")
                    .build();

            postService = restAdapter.create(PostManager.class);

        }
        return postService;
    }
}
