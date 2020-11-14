package org.imd.jpa.sample1.model.mapper.domain;

import org.imd.jpa.sample1.model.domain.PostComment;
import org.imd.jpa.sample1.model.entity.PostCommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostCommentDomainMapper {

    PostComment toPostComment(PostCommentEntity pcEntity);
    PostCommentEntity toPostCommentEntity(PostComment pc);

    void transfer(PostComment postComment, @MappingTarget PostCommentEntity existingPostCommentEntity);

    List<PostComment> toPostComments(List<PostCommentEntity> allEntities);


}
