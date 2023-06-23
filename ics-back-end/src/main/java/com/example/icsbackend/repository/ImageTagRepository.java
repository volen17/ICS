package com.example.icsbackend.repository;

import com.example.icsbackend.entity.ImageTagConfidence;
import com.example.icsbackend.entity.ImageTagKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageTagRepository extends JpaRepository<ImageTagConfidence, ImageTagKey> {
}
