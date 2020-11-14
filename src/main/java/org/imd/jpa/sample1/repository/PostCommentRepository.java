package org.imd.jpa.sample1.repository;

import org.imd.jpa.sample1.model.entity.PostCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<PostCommentEntity, Long> {

    List<PostCommentEntity> findAllByPostId(Long postId);
}