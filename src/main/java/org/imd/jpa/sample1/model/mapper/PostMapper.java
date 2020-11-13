package org.imd.jpa.sample1.model.mapper;

import org.imd.jpa.sample1.model.domain.Post;
import org.imd.jpa.sample1.model.dto.PostDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostDto toPostDto(Post post);
    Post toPost(PostDto postDto);

    List<PostDto> toPostDtos(List<Post> users);


}
