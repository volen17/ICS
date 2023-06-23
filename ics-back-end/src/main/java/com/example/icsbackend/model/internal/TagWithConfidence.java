package com.example.icsbackend.model.internal;

public class TagWithConfidence {
    private String tagName;
    private double confidence;

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public TagWithConfidence() {}
}
