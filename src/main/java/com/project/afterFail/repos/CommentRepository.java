package com.project.afterFail.repos;

import com.project.afterFail.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByUserId(Long UserId);
    List<Comment> findByPostId(Long CommentId);

}
