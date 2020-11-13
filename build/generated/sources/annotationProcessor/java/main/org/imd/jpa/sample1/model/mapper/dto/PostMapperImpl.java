package org.imd.jpa.sample1.model.mapper.dto;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.imd.jpa.sample1.model.domain.Post;
import org.imd.jpa.sample1.model.dto.PostDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-13T12:06:02+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.9.1 (Ubuntu)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public PostDto toPostDto(Post post) {
        if ( post == null ) {
            return null;
        }

        PostDto postDto = new PostDto();

        postDto.setId( post.getId() );
        postDto.setTitle( post.getTitle() );

        return postDto;
    }

    @Override
    public Post toPost(PostDto postDto) {
        if ( postDto == null ) {
            return null;
        }

        Post post = new Post();

        post.setId( postDto.getId() );
        post.setTitle( postDto.getTitle() );

        return post;
    }

    @Override
    public List<PostDto> toPostDtos(List<Post> users) {
        if ( users == null ) {
            return null;
        }

        List<PostDto> list = new ArrayList<PostDto>( users.size() );
        for ( Post post : users ) {
            list.add( toPostDto( post ) );
        }

        return list;
    }
}
