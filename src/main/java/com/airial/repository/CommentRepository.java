package com.airial.repository;

import com.airial.domain.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by scambour on 25/04/14.
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {
    public List<Comment> findByTextIgnoreCase(String text);
}
