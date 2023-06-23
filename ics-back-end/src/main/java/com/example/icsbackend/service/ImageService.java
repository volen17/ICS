package com.example.icsbackend.service;

import com.example.icsbackend.entity.*;
import com.example.icsbackend.exception.ResourceNotFoundException;
import com.example.icsbackend.model.imagga.ImaggaResponse;
import com.example.icsbackend.model.imagga.ImaggaTag;
import com.example.icsbackend.model.internal.ImageWithTags;
import com.example.icsbackend.model.internal.TagWithConfidence;
import com.example.icsbackend.repository.ImageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Autowired
    private TagService tagService;

    @Autowired
    private ImageTagService imageTagService;

    // TODO: IMAGE CHECKSUM

    public ImageWithTags saveImage(String url) throws IOException {
        List<Image> images = getImageRepository().findByUrl(url);
        if(images.size() > 1) {
            throw new RuntimeException("Invalid data state");
        } else if(images.size() == 1) {
            return transformImage(images.get(0));
        }

        List<ImaggaTag> tags = tagService.getTags(url);
        return persistImageData(url, tags);
    }

    private ImageWithTags persistImageData(String imageUrl, List<ImaggaTag> tags) throws IOException {
        Image image = saveImageByUrl(imageUrl);

        tags.forEach(imaggaTag -> {
            Tag tag = new Tag();
            tag.setName(imaggaTag.tag.tagName);
            tagService.saveTag(tag);

            List<Tag> insertedTags = tagService.findByName(imaggaTag.tag.tagName);
            if (insertedTags.size() > 1) {

                throw new RuntimeException("Invalid data state");
            }

            Tag insertedTag = insertedTags.get(0);

            ImageTagConfidence imageTagConfidence = new ImageTagConfidence();

            imageTagConfidence.setId(new ImageTagKey());
            imageTagConfidence.setImage(image);
            imageTagConfidence.setTag(insertedTag);
            imageTagConfidence.setConfidence(imaggaTag.confidence);

            imageTagService.saveImageTag(imageTagConfidence);

            image.addTag(imageTagConfidence);
        });
        return transformImage(image);
    }


    private Image saveImageByUrl(String urlString) throws IOException {
        Image image = new Image();
        URL url =new URL(urlString);
        BufferedImage imageData = ImageIO.read(url);
        image.setUrl(urlString);
        image.setWidth(imageData.getWidth());
        image.setHeight(imageData.getHeight());
        image.setAnalysedAt(Services.IMAGGA.toString());
        image.setAnalysedOn(new Date());

        getImageRepository().save(image);

        return image;
    }

    private ImageWithTags transformImage(Image image) {
        List<ImageTagConfidence> tags = image.getTags();
        List <TagWithConfidence> tagsWithConfidence = tags.stream().map(tag -> {
            TagWithConfidence tagWithConfidence = new TagWithConfidence();
            tagWithConfidence.setTagName(tag.getTag().getName());
            tagWithConfidence.setConfidence(tag.getConfidence());
            return tagWithConfidence;
        }).collect(Collectors.toList());
        ImageWithTags imageWithTags = new ImageWithTags();
        imageWithTags.setHeight(image.getHeight());
        imageWithTags.setWidth(image.getWidth());
        imageWithTags.setId(image.getId());
        imageWithTags.setAnalysedAt(image.getAnalysedAt());
        imageWithTags.setUrl(image.getUrl());
        imageWithTags.setAnalysedOn(image.getAnalysedOn());
        imageWithTags.setTags(tagsWithConfidence);
        return imageWithTags;
    }

    public List<ImageWithTags> getAllImages(String order, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, order.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, "analysedOn");;
        Page<Image> page = getImageRepository().findAll(pageable);
        List<Image> images = page.getContent();
        List<ImageWithTags> transformedImages = images.stream().map(image -> transformImage(image)).collect(Collectors.toList());
        return transformedImages;
    }

    public ImageWithTags getImageById(Integer id) throws ResourceNotFoundException {
        Optional<Image> image = getImageRepository().findById(id);
        if (image.isPresent()) {
            return transformImage(image.get());
        }
        throw new ResourceNotFoundException();
    }

    public void deleteImage(Image image) {
        getImageRepository().delete(image);
    }

    public ImageRepository getImageRepository() {
        return imageRepository;
    }
}

