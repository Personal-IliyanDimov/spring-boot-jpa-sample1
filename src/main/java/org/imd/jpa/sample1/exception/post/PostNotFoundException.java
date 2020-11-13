package org.imd.jpa.sample1.exception.post;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class PostNotFoundException extends Exception {
    private final Long id;

}
