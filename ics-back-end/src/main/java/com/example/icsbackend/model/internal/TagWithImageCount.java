package com.example.icsbackend.model.internal;

public class TagWithImageCount {
    private int id;
    private String name;
    private int count;

    public TagWithImageCount(int id, String name, int count) {
        setId(id);
        setName(name);
        setCount(count);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
