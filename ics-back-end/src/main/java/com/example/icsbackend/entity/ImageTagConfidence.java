package com.example.icsbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "images_tags")
public class ImageTagConfidence {

    @EmbeddedId
    ImageTagKey id;

    @JsonIgnore
    @ManyToOne
    @MapsId("imageId")
    @JoinColumn(name = "image_id")
    private Image image;


    @JsonIgnore
    @ManyToOne
    @MapsId("tagId")
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @Column(name = "confidence")
    private double confidence;

    public ImageTagConfidence() {

    }

    public void setId(ImageTagKey id) {
        this.id = id;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public ImageTagKey getId() {
        return id;
    }

    public Image getImage() {
        return image;
    }

    public Tag getTag() {
        return tag;
    }

    public double getConfidence() {
        return confidence;
    }
}
