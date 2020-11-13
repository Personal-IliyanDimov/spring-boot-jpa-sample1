package org.imd.jpa.sample1.model.mapper.dto;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.imd.jpa.sample1.model.domain.PostComment;
import org.imd.jpa.sample1.model.dto.PostCommentDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-13T12:06:02+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.9.1 (Ubuntu)"
)
@Component
public class PostCommentMapperImpl implements PostCommentMapper {

    @Override
    public PostCommentDto toPostCommentDto(PostComment postComment) {
        if ( postComment == null ) {
            return null;
        }

        PostCommentDto postCommentDto = new PostCommentDto();

        return postCommentDto;
    }

    @Override
    public PostComment toPostComment(PostCommentDto postDto) {
        if ( postDto == null ) {
            return null;
        }

        PostComment postComment = new PostComment();

        return postComment;
    }

    @Override
    public List<PostCommentDto> toPostCommentDtos(List<PostComment> users) {
        if ( users == null ) {
            return null;
        }

        List<PostCommentDto> list = new ArrayList<PostCommentDto>( users.size() );
        for ( PostComment postComment : users ) {
            list.add( toPostCommentDto( postComment ) );
        }

        return list;
    }
}
