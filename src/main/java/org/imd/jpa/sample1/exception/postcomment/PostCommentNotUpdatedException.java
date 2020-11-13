package org.imd.jpa.sample1.exception.postcomment;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PostCommentNotUpdatedException extends Exception {
    public PostCommentNotUpdatedException(Exception causedBy) {
        super(causedBy);
    }
}
