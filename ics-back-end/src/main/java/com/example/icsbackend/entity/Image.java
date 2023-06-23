package com.example.icsbackend.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "url")
    private String url;

    @Column(name = "analysed_at")
    private String analysedAt;

    @Column(name = "width")
    private int width;

    @Column(name = "height")
    private int height;

    @Column(name = "analysed_on")
    private Date analysedOn;

    @OneToMany(mappedBy = "image", fetch = FetchType.EAGER)
    private List<ImageTagConfidence> tags = new ArrayList<>();

    public Image() {

    }

    public Date getAnalysedOn() {
        return analysedOn;
    }

    public void setAnalysedOn(Date date) {
        this.analysedOn = date;
    }

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

    public void setAnalysedAt(String service_url) {
        this.analysedAt = service_url;
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

    public List<ImageTagConfidence> getTags() {
        return tags;
    }

    public void setTags(List<ImageTagConfidence> tags) {
        this.tags = tags;
    }

    public void addTag(ImageTagConfidence tag) {
        tags.add(tag);
    }

    public void removeTag(ImageTagConfidence tag) {
        tags.remove(tag);
    }

    @Override
    public String toString() {
        List<String> tags = new ArrayList<>();
        if (getTags() != null) {
            getTags().forEach(u -> tags.add(u.toString()));
        }
        return "Image{" +
                "id=" + getId() +
                ", url='" + getUrl() + '\'' +
                ", tags=" + Arrays.asList(getTags()) + '}';
    }
}
