package com.example.icsbackend.repository;

import com.example.icsbackend.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer>{
    List<Tag> findByName(String name);

    List<Tag> findByNameStartsWith(String tagPrefix);
}


