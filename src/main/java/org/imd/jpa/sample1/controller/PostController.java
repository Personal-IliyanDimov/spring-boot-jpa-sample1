package org.imd.jpa.sample1.controller;

import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.imd.jpa.sample1.exception.post.PostAlreadyExistsException;
import org.imd.jpa.sample1.exception.post.PostNotFoundException;
import org.imd.jpa.sample1.exception.post.PostNotUpdatedException;
import org.imd.jpa.sample1.model.domain.Post;
import org.imd.jpa.sample1.model.dto.PostDto;
import org.imd.jpa.sample1.model.dto.group.CreateGroup;
import org.imd.jpa.sample1.model.dto.group.UpdateGroup;
import org.imd.jpa.sample1.model.mapper.dto.PostMapper;
import org.imd.jpa.sample1.service.PostService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/posts")
@Validated
@RequiredArgsConstructor
public class PostController {

    private final PostMapper postMapper;
    private final PostService postService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<PostDto>> getPosts() {
        final List<Post> posts = postService.findAll();
        return ResponseEntity.ok(postMapper.toPostDtos(posts));
    }

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PostDto> getPost(@PathVariable(name = "id") final Long id) throws PostNotFoundException {
        checkPostExists(id);

        final Optional<Post> postOptional = postService.findPost(id);
        if (! postOptional.isPresent()) {
            throw new PostNotFoundException(id);
        }

        return ResponseEntity.ok(postMapper.toPostDto(postOptional.get()));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PostDto> createPost(@RequestBody @Validated(CreateGroup.class) @Valid PostDto postDto) throws PostAlreadyExistsException {
        final Post post = postMapper.toPost(postDto);
        final Post createdPost = postService.createPost(post);
        return ResponseEntity.ok(postMapper.toPostDto(createdPost));
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<PostDto> updatePost(@PathVariable(name = "id") @NotNull Long id,
                                       @RequestBody @Validated(UpdateGroup.class) @Valid PostDto postDto) throws PostNotFoundException, PostNotUpdatedException {
        checkPostExists(id);

        final Post post = postMapper.toPost(postDto);
        final Post updatedPost = postService.updatePost(id, post);
        return ResponseEntity.ok(postMapper.toPostDto(updatedPost));
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<?> deletePost(@PathVariable(name = "id") Long id) throws PostNotFoundException {
        checkPostExists(id);

        postService.deletePostById(id);
        return ResponseEntity.ok().build();
    }

    private void checkPostExists(Long pid) throws PostNotFoundException {
        if (! postService.postExists(pid)) {
            throw new PostNotFoundException(pid);
        }
    }
}
