package com.project.afterFail.services;

import com.project.afterFail.entities.Post;
import com.project.afterFail.repos.PostRepository;

import com.project.afterFail.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()) {
            return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();

    }

    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }


    public Post createOnePost(Post newPost) {
        return postRepository.save(newPost);
    }

    public void deleteOnePost(Long postId) {
        postRepository.deleteById(postId);
    }

}
