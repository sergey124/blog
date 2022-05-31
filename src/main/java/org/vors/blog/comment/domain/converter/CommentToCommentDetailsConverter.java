package org.vors.blog.comment.domain.converter;

import org.springframework.stereotype.Component;
import org.vors.blog.comment.domain.Comment;
import org.vors.blog.comment.domain.dto.CommentDetails;

@Component
public class CommentToCommentDetailsConverter {
    public CommentDetails convert(Comment source){
        CommentDetails target = new CommentDetails();
        target.setPostId(source.getKey().getPostId());
        target.setId(source.getKey().getId());
        target.setCreatedDate(source.getCreatedDate());
        target.setContent(source.getContent());

        return target;
    }
}
