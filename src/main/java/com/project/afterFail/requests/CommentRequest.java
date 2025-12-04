package com.project.afterFail.requests;

import lombok.Data;

@Data
public class CommentRequest {
    Long id;
    Long userId;
    Long postId;
    String text;
}