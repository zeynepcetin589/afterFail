package com.project.afterFail.services;

import com.project.afterFail.entities.Comment;
import com.project.afterFail.entities.Post;
import com.project.afterFail.entities.User;
import com.project.afterFail.repos.CommentRepository;
import com.project.afterFail.repos.PostRepository;
import com.project.afterFail.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }


    public List<Comment> getAllComments(Optional<Long> userId, Optional<Long> postId) {
        if(userId.isPresent())
            return commentRepository.findByUserId(userId.get());
        else if(postId.isPresent())
            return commentRepository.findByPostId(postId.get());
        else
            return commentRepository.findAll();
    }

    public Comment getOneCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createOneComment(Long userId, Long postId, Comment newComment) {
        User user = userRepository.findById(userId).orElse(null);
        Post post = postRepository.findById(postId).orElse(null);
        if(user != null && post != null) {
            newComment.setUser(user);
            newComment.setPost(post);
            return commentRepository.save(newComment);
        }
        return null;
    }

    public void deleteOneComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

}