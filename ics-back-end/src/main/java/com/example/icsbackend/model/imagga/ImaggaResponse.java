package com.example.icsbackend.model.imagga;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImaggaResponse {
    @JsonProperty("result")
    public Result result;

    @JsonProperty("status")
    public ImaggaStatus status;
}
