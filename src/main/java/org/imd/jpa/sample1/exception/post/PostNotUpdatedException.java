package org.imd.jpa.sample1.exception.post;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PostNotUpdatedException extends Exception {
    public PostNotUpdatedException(Exception causedBy) {
        super(causedBy);
    }
}
