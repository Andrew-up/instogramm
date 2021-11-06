package com.example.instogramm.repository;

import com.example.instogramm.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    Optional<Image> findByUserId(Long userId);

    Optional<Image> findByPostId(Long postId);

}
