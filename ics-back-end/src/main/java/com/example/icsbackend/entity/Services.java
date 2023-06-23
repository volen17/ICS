package com.example.icsbackend.entity;

public enum Services {
    IMAGGA ("https://imagga.com/"),
    XIMILAR ("https://www.ximilar.com/"),
    CLARIFAI ("https://www.clarifai.com/");

    private final String service_url;

    Services(final String service_url){
        this.service_url = service_url;
    }

    @Override
    public String toString(){
        return service_url;
    }
}
