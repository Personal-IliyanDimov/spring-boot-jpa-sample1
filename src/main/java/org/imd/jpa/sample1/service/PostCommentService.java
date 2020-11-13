package org.imd.jpa.sample1.service;

import org.imd.jpa.sample1.model.domain.PostComment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCommentService {
    public List<PostComment> findAll(Long pid) {
        return null;
    }

    public PostComment findPostComment(Long pid, Long cid) {
        return null;
    }

    public PostComment createPostComment(Long pid, PostComment pc) {
        return null;
    }

    public PostComment updatePostComment(Long pid, Long cid, PostComment pc) {
        return null;
    }

    public void deletePostById(Long pid, Long cid) {
        return ;
    }
}
