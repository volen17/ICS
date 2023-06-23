package com.example.icsbackend.model.imagga;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImaggaStatus {
    @JsonProperty("text")
    public String text;

    @JsonProperty("type")
    public String type;
}
