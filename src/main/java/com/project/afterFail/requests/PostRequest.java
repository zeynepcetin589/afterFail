package com.project.afterFail.requests;

import lombok.Data;

@Data
public class PostRequest {
    Long id;
    String text;
    String title;
    Long userId;
}