package org.imd.jpa.sample1.repository;

import org.imd.jpa.sample1.model.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    public Optional<PostEntity> findByTitle(String title);
}