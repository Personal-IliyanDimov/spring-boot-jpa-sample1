package org.imd.jpa.sample1.repository;

import org.imd.jpa.sample1.model.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostEntity, Long> {

}