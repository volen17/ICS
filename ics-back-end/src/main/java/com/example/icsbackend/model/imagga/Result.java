package com.example.icsbackend.model.imagga;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Result {
    @JsonProperty("tags")
    public List<ImaggaTag> tags;
}
