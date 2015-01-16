package com.kerboocorp.bb.managers;

import com.kerboocorp.bb.model.Post;

import java.util.List;

/**
 * Created by cgo on 16/01/2015.
 */
public interface PostManager {

    public List<Post> findPostList(int page);
}
