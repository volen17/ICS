package com.example.icsbackend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "tag", fetch = FetchType.EAGER)
    private List<ImageTagConfidence> images = new ArrayList<>();


    public Tag(String name){
        this.name=name;
    }

    public Tag(){}

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<ImageTagConfidence> getImages() {
        return this.images;
    }

    @Override
    public String toString() {
        return getName();
    }
}
