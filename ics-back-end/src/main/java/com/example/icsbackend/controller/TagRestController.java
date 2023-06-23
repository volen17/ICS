package com.example.icsbackend.controller;

import com.example.icsbackend.entity.Image;
import com.example.icsbackend.entity.Tag;
import com.example.icsbackend.model.internal.TagWithConfidence;
import com.example.icsbackend.model.internal.TagWithImageCount;
import com.example.icsbackend.service.ImageService;
import com.example.icsbackend.model.internal.ImageWithTags;
import com.example.icsbackend.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class TagRestController {

    private final TagService tagService;

    public TagRestController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("tags/{name}")
    @CrossOrigin
    public ResponseEntity<List<Image>> getImagesByTag(@PathVariable String name) {
        return new ResponseEntity<>(tagService.getImagesByTag(name), HttpStatus.OK);
    }

    @GetMapping("tags")
    @CrossOrigin
    public ResponseEntity<List<TagWithImageCount>> getSuggestions(@RequestParam String tagPrefix) {
        return new ResponseEntity<>(tagService.getSuggestions(tagPrefix), HttpStatus.OK);
    }
}
