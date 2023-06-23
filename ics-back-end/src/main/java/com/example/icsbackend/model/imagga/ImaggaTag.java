package com.example.icsbackend.model.imagga;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImaggaTag {
    @JsonProperty("confidence")
    public double confidence;

    @JsonProperty("tag")
    public ImaggaTagWithLanguage tag;
}
