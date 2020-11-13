package org.imd.jpa.sample1.model.mapper.domain;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.imd.jpa.sample1.model.domain.Post;
import org.imd.jpa.sample1.model.entity.PostEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-13T12:06:02+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.9.1 (Ubuntu)"
)
@Component
public class PostDomainMapperImpl implements PostDomainMapper {

    @Override
    public Post toPost(PostEntity pe) {
        if ( pe == null ) {
            return null;
        }

        Post post = new Post();

        post.setId( pe.getId() );
        post.setTitle( pe.getTitle() );

        return post;
    }

    @Override
    public PostEntity toPostEntity(Post post) {
        if ( post == null ) {
            return null;
        }

        PostEntity postEntity = new PostEntity();

        postEntity.setId( post.getId() );
        postEntity.setTitle( post.getTitle() );

        return postEntity;
    }

    @Override
    public void transfer(Post post, PostEntity existingPostEntity) {
        if ( post == null ) {
            return;
        }

        existingPostEntity.setId( post.getId() );
        existingPostEntity.setTitle( post.getTitle() );
    }

    @Override
    public List<Post> toPosts(List<PostEntity> allEntities) {
        if ( allEntities == null ) {
            return null;
        }

        List<Post> list = new ArrayList<Post>( allEntities.size() );
        for ( PostEntity postEntity : allEntities ) {
            list.add( toPost( postEntity ) );
        }

        return list;
    }
}
