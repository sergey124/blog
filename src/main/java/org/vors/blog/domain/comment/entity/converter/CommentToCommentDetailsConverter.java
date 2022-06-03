package org.vors.blog.domain.comment.entity.converter;

import org.springframework.stereotype.Component;
import org.vors.blog.domain.comment.entity.Comment;
import org.vors.blog.domain.comment.entity.dto.CommentDetails;


@Component
public class CommentToCommentDetailsConverter {
    public CommentDetails convert(Comment source){
        CommentDetails target = new CommentDetails();
        target.setPostId(source.getKey().getPostId());
        target.setId(source.getKey().getId());
        target.setCreatedDate(source.getCreatedDate());
        target.setComment(source.getComment());

        return target;
    }
}
