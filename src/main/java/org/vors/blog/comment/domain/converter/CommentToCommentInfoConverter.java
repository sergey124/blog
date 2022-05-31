package org.vors.blog.comment.domain.converter;

import org.springframework.stereotype.Component;
import org.vors.blog.comment.domain.Comment;
import org.vors.blog.comment.domain.dto.CommentInfo;

@Component
public class CommentToCommentInfoConverter {
    public CommentInfo convert(Comment source){
        CommentInfo target = new CommentInfo();
        target.setPostId(source.getKey().getPostId());
        target.setId(source.getKey().getId());
        target.setContent(source.getContent());

        return target;
    }
}
