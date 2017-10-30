package com.airial.repository;

import com.airial.domain.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by scambour on 15/04/14.
 */
public interface PostRepository extends CrudRepository<Post, Long> {
    public Post findByTitleIgnoreCase(String title);
}
