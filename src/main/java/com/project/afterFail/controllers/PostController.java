package com.project.afterFail.controllers;

import com.project.afterFail.entities.Post;
import com.project.afterFail.services.PostService;
import com.project.afterFail.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
        return postService.getAllPosts(userId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody Post newPost){
        return postService.createOnePost(newPost);
    }

    @DeleteMapping
    public void deleteOnePost(@RequestParam Long postId){
        postService.deleteOnePost(postId);
    }

    @GetMapping("{postId}")
    public Post getOnePost(@PathVariable Long postId){
        return postService.getOnePostById(postId);
    }


}
