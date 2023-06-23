package com.example.icsbackend.service;

import com.example.icsbackend.entity.ImageTagConfidence;
import com.example.icsbackend.repository.ImageTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageTagService {

    @Autowired
    private ImageTagRepository imageTagRepository;

    public ImageTagService(ImageTagRepository imageTagRepository) {
        this.imageTagRepository = imageTagRepository;
    }

    public void saveImageTag(ImageTagConfidence imageTagConfidence) {
        getImageTagRepository().save(imageTagConfidence);
    }

    public List<ImageTagConfidence> getAllImageTags() {
        return getImageTagRepository().findAll();
    }


    public ImageTagRepository getImageTagRepository() {
        return imageTagRepository;
    }
}
