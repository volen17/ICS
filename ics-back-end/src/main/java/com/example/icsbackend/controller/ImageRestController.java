package com.example.icsbackend.controller;

import com.example.icsbackend.service.ImageService;
import com.example.icsbackend.model.internal.ImageWithTags;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class ImageRestController {

    private final ImageService imageService;


    public ImageRestController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("images")
    @CrossOrigin
    public ResponseEntity<ImageWithTags> createImage(@RequestParam String imageUrl) throws IOException {
        return new ResponseEntity<>(imageService.saveImage(imageUrl), HttpStatus.CREATED);
    }

    @GetMapping("images/{id}")
    @CrossOrigin
    public ResponseEntity<ImageWithTags> getImageById(@PathVariable Integer id) {
        return new ResponseEntity<>(imageService.getImageById(id), HttpStatus.OK);
    }

    @GetMapping("images")
    @CrossOrigin
    public ResponseEntity<List<ImageWithTags>> getAllImages(@RequestParam(defaultValue = "desc") String order, @RequestParam(defaultValue = "12") int pageSize, @RequestParam(defaultValue = "1") int pageNumber) {
        return new ResponseEntity<>(imageService.getAllImages(order, pageNumber, pageSize), HttpStatus.OK);
    }
}
