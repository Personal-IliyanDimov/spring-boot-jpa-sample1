package org.imd.jpa.sample1.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.imd.jpa.sample1.model.dto.group.CreateGroup;
import org.imd.jpa.sample1.model.dto.group.UpdateGroup;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Getter
@Setter
public class PostCommentDto {
    @Null(groups = {CreateGroup.class})
    @NotNull(groups = {UpdateGroup.class})
    private Long id;

    @NotNull
    private String review;
}
