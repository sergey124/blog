package org.vors.blog.domain.comment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Table
@Getter @Setter
public class Comment {
    @PrimaryKey
    private Key key;

    @Column("created_date")
    private LocalDateTime createdDate;

    @Column
    private String comment;

    @PrimaryKeyClass
    @AllArgsConstructor
    @Getter
    public static class Key implements Serializable {

        @PrimaryKeyColumn(
                name = "post_id",
                ordinal = 0,
                type = PrimaryKeyType.PARTITIONED,
                ordering = Ordering.DESCENDING)
        private UUID postId;

        @PrimaryKeyColumn(
                name = "id",
                ordinal = 1,
                type = PrimaryKeyType.CLUSTERED,
                ordering = Ordering.DESCENDING)
        private UUID id;
    }
}