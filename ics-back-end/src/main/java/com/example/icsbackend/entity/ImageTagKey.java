package com.example.icsbackend.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ImageTagKey implements Serializable {

    @Column(name = "image_id")
    int imageId;

    @Column(name = "tag_id")
    int tagId;

    public ImageTagKey() {}

    public ImageTagKey(int imageId, int tagId) {
        setImageId(imageId);
        setTagId(tagId);
    }

    public int getImageId() {
        return imageId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }
}
