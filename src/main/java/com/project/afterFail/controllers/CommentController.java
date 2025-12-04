package com.project.afterFail.controllers;

import com.project.afterFail.entities.Comment;
import com.project.afterFail.requests.CommentRequest;
import com.project.afterFail.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
        return commentService.getAllComments(userId, postId);
    }

    @PostMapping
    public Comment createComment(@RequestBody CommentRequest request) {
        return commentService.createOneComment(request.getUserId(), request.getPostId(), request.getComment());
    }

}
