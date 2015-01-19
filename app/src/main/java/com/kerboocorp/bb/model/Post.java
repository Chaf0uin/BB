package com.kerboocorp.bb.model;

import java.util.Date;

/**
 * Created by cgo on 16/01/2015.
 */
public class Post extends BaseModel {

    private String title;
    private String imageUrl;
    private Date uploadDate;

//    private String creationDate;
//    private String urlImage;
//    private String createdAt;
//    private String updatedAt;
//    private Object validated;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
}
