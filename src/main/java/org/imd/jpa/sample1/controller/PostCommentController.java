package org.imd.jpa.sample1.controller;

import lombok.RequiredArgsConstructor;
import org.imd.jpa.sample1.exception.post.PostNotFoundException;
import org.imd.jpa.sample1.exception.post.PostNotUpdatedException;
import org.imd.jpa.sample1.exception.postcomment.PostCommentAlreadyExistsException;
import org.imd.jpa.sample1.exception.postcomment.PostCommentNotFoundException;
import org.imd.jpa.sample1.exception.postcomment.PostCommentNotUpdatedException;
import org.imd.jpa.sample1.model.domain.PostComment;
import org.imd.jpa.sample1.model.dto.PostCommentDto;
import org.imd.jpa.sample1.model.dto.group.CreateGroup;
import org.imd.jpa.sample1.model.dto.group.UpdateGroup;
import org.imd.jpa.sample1.model.mapper.dto.PostCommentMapper;
import org.imd.jpa.sample1.service.PostCommentService;
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

@RestController
@RequestMapping(path = "/posts/{pid}/comments")
@Validated
@RequiredArgsConstructor
public class PostCommentController {

    private final PostCommentMapper pcMapper;
    private final PostCommentService pcService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<PostCommentDto>> getPostComments(@PathVariable(name = "pid") final Long pid) {
        final List<PostComment> posts = pcService.findAll(pid);
        return ResponseEntity.ok(pcMapper.toPostCommentDtos(posts));
    }

    @GetMapping(value = "/{cid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PostCommentDto> getPostComment(@PathVariable(name = "pid") final Long pid,
                                                  @PathVariable(name = "cid") final Long cid) throws PostNotFoundException, PostCommentNotFoundException {
        final PostComment postComment = pcService.findPostComment(pid, cid);
        return ResponseEntity.ok(pcMapper.toPostCommentDto(postComment));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PostCommentDto> createPostComment(@PathVariable(name = "pid") final Long pid,
                                                     @RequestBody @Validated(CreateGroup.class) @Valid PostCommentDto pcDto) throws PostCommentAlreadyExistsException {
        final PostComment pc = pcMapper.toPostComment(pcDto);
        final PostComment createdPc = pcService.createPostComment(pid, pc);
        return ResponseEntity.ok(pcMapper.toPostCommentDto(createdPc));
    }

    @PutMapping(value = "/{cid}")
    ResponseEntity<PostCommentDto> updatePost(@PathVariable(name = "pid") final Long pid,
                                              @PathVariable(name = "cid") final Long cid,
                                              @RequestBody @Validated(UpdateGroup.class) @Valid PostCommentDto pcDto)
            throws PostNotFoundException, PostNotUpdatedException, PostCommentNotFoundException, PostCommentNotUpdatedException {
        final PostComment pc = pcMapper.toPostComment(pcDto);
        final PostComment createdPc = pcService.updatePostComment(pid, cid, pc);
        return ResponseEntity.ok(pcMapper.toPostCommentDto(createdPc));
    }

    @DeleteMapping(value = "/{cid}")
    ResponseEntity<?> deletePost(@PathVariable(name = "pid") final Long pid,
                                 @PathVariable(name = "cid") final Long cid) throws PostNotFoundException, PostCommentNotFoundException {
        pcService.deletePostById(pid, cid);
        return ResponseEntity.ok().build();
    }
}
