package org.vors.blog.domain.comment.entity.converter;

import org.springframework.stereotype.Component;
import org.vors.blog.domain.comment.entity.Comment;
import org.vors.blog.domain.comment.entity.dto.CommentInfo;


@Component
public class CommentToCommentInfoConverter {
    public CommentInfo convert(Comment source){
        CommentInfo target = new CommentInfo();
        target.setPostId(source.getKey().getPostId());
        target.setId(source.getKey().getId());
        target.setComment(source.getComment());

        return target;
    }
}
