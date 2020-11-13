package org.imd.jpa.sample1.exception.postcomment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class PostCommentAlreadyExistsException extends Exception {
    private final String title;
}
