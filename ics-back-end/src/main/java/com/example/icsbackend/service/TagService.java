package com.example.icsbackend.service;

import com.example.icsbackend.entity.Image;
import com.example.icsbackend.entity.Tag;
import com.example.icsbackend.exception.ResourceNotFoundException;
import com.example.icsbackend.model.imagga.ImaggaResponse;
import com.example.icsbackend.model.imagga.ImaggaTag;
import com.example.icsbackend.model.internal.ImageWithTags;
import com.example.icsbackend.model.internal.TagWithConfidence;
import com.example.icsbackend.model.internal.TagWithImageCount;
import com.example.icsbackend.repository.TagRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    @Value("${spring.datasource.imaggaApiKey}")
    private String imaggaApiKey;


    @Value("${spring.datasource.imaggaApiSecret}")
    private String imaggaApiSecret;

    @Value("${spring.datasource.imaggaApiEndpoint}")
    private String imaggaApiEndpoint;

    @Autowired
    private TagRepository tagRepository;

    public void saveTag(Tag tag) {
        List<Tag> tags = getTagRepository().findByName(tag.getName());
        if(tags.size() > 0) {
            return;
        }
        getTagRepository().save(tag);
    }

    public List<Tag> findByName(String name) {
        return getTagRepository().findByName(name);
    }

    public List<Tag> getAllTags() {
        return getTagRepository().findAll();
    }

    public void deleteTag(Tag tag) {
        getTagRepository().delete(tag);
    }

    public TagRepository getTagRepository() {
        return tagRepository;
    }

    public List<ImaggaTag> getTags(String imageUrl) throws IOException {
        String credentialsToEncode = String.format("%s:%s", imaggaApiKey, imaggaApiSecret);
        String basicAuth = Base64.getEncoder().encodeToString(credentialsToEncode.getBytes(StandardCharsets.UTF_8));

        String endpoint_url = imaggaApiEndpoint + "/v2/tags";

        String url = endpoint_url + "?image_url=" + URLEncoder.encode(imageUrl, "UTF-8");
        URL urlObject = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();

        connection.setRequestProperty("Authorization", "Basic " + basicAuth);

        BufferedReader connectionInput = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String jsonResponse = connectionInput.readLine();

        connectionInput.close();

        ObjectMapper mapper = new ObjectMapper();
        ImaggaResponse parsedResponse = mapper.readValue(jsonResponse, ImaggaResponse.class);

        List<ImaggaTag> tags = parsedResponse.result.tags;

        return tags;
    }

    public List<Image> getImagesByTag(String name) {
        List<Tag> tags = getTagRepository().findByName(name);
        if(tags.size() > 1) {
            throw new RuntimeException("Invalid data state");
        } else if(tags.size() == 0) {
            throw new ResourceNotFoundException();
        }
        Tag tag = tags.get(0);
        return tag.getImages().stream().map(imageTagConfidence -> imageTagConfidence.getImage()).collect(Collectors.toList());
    }

    public List<TagWithImageCount> getSuggestions(String tagPrefix) {
        List<Tag> tags = getTagRepository().findByNameStartsWith(tagPrefix);
        List<TagWithImageCount> tagsWithImageCount = tags.stream().map(tag -> new TagWithImageCount(tag.getId(), tag.getName(), tag.getImages().size())).collect(Collectors.toList());
        Collections.sort(tagsWithImageCount, (tic1, tic2) -> {
            if(tic1.getCount() < tic2.getCount()){
                return 1;
            } else if(tic1.getCount() > tic2.getCount()) {
                return -1;
            } else {
                return 0;
            }
        });
        return tagsWithImageCount;
    }
}
