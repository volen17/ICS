package com.example.icsbackend.model.internal;

import com.example.icsbackend.entity.Services;

import java.util.Date;
import java.util.List;

public class ImageWithTags {
    private int id;

    private String url;

    private String analysedAt;

    private Date analysedOn;

    public Date getAnalysedOn() {
        return analysedOn;
    }

    public void setAnalysedOn(Date analysedOn) {
        this.analysedOn = analysedOn;
    }

    private int width;

    private int height;
    private List<TagWithConfidence> tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAnalysedAt() {
        return analysedAt;
    }

    public void setAnalysedAt(String analysedAt) {
        this.analysedAt = analysedAt;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<TagWithConfidence> getTags() {
        return tags;
    }

    public ImageWithTags() {
    }

    public void setTags(List<TagWithConfidence> tags) {
        this.tags = tags;
    }
}
