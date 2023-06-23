package com.example.icsbackend;

import com.example.icsbackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class IcsBackEndApplication {

    @Autowired
    private ImageService imageService;

    @Autowired
    private TagService tagService;

    @Autowired
    private ImageTagService imageTagService;

//    @EventListener(ApplicationReadyEvent.class)
//    public void runAfterStartup() {
//
//        List<ImageWithTags> allImages = imageService.getAllImages();
//        logger.info("Number of images: " + allImages.size());
//
//        Image image = new Image();
//        image.setUrl("abc");
//        image.setAnalysedAt(Services.IMAGGA);
//        image.setWidth(640);
//        image.setHeight(480);
//
//        Tag tag = new Tag();
//        tag.setName("bike");
//
//        ImageTagConfidence imageTagConfidence = new ImageTagConfidence();
//        imageTagConfidence.setId(new ImageTagKey());
//        imageTagConfidence.setImage(image);
//        imageTagConfidence.setTag(tag);
//        imageTagConfidence.setConfidence(95);
//
//
//        imageService.saveImage(image);
//        tagService.saveTag(tag);
//        imageTagService.saveImageTag(imageTagConfidence);
//
//
//        allImages = imageService.getAllImages();
//        logger.info("Number of images: " + allImages.size());
//        logger.info("\n");
//        for (ImageWithTags i :allImages) {
//            for(TagWithConfidence tc : i.getTags()) {
//                logger.info(i.getId() + " " + String.valueOf(tc.getConfidence()) + " " + tc.getTagName());
//            }
//        }
//
//        Tag tag1 = new Tag("sunset");
//        Tag tag2 = new Tag("sea");
//        Tag tag3 = new Tag("sky");
//
//
//        List<Tag> tags = new ArrayList<>();
//        tags.add(tag1);
//        tagRepository.save(tag1);
//        logger.info("Saving new tag: " + tag1);
//        tags.add(tag2);
//        tagRepository.save(tag2);
//        logger.info("Saving new tag: " + tag2);
//        tags.add(tag3);
//        tagRepository.save(tag3);
//        logger.info("Saving new tag: " + tag3);
//
//
//
//        logger.info("Saving new image...");
//        this.repository.save(image);
//
//        allImages = this.repository.findAll();
//        logger.info("Number of images: " + allImages.size());
//        logger.info("\n");
//        for (Image i :allImages) {
//            logger.info(i.toString());
//        }
//    }

    public static void main(String[] args) {
                SpringApplication.run(IcsBackEndApplication.class, args);
    }
}
