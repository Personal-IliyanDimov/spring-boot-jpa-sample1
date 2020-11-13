package org.imd.jpa.sample1.service;

import org.imd.jpa.sample1.model.domain.PostComment;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostCommentService {

    @Transactional
    public List<PostComment> findAll(Long pid) {
        return null;
    }

    @Transactional
    public PostComment findPostComment(Long pid, Long cid) {
        return null;
    }

    @Transactional
    public PostComment createPostComment(Long pid, PostComment pc) {
        return null;
    }

    @Transactional
    public PostComment updatePostComment(Long pid, Long cid, PostComment pc) {
        return null;
    }

    @Transactional
    public void deletePostById(Long pid, Long cid) {
        return ;
    }
}
