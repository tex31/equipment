package com.airial.service.jpa;

import com.airial.service.PostService;
import com.airial.domain.Post;
import com.airial.repository.PostRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by scambour on 15/04/14.
 */
@Service("postService")
@Repository
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Post> findAll() {
        return Lists.newArrayList(postRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Post findById(Long id) {
        return postRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Post findByTitleIgnoreCase(String title) {
        return postRepository.findByTitleIgnoreCase(title);
    }


    @Override
    @Transactional
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void destroy(Post post) {
        postRepository.delete(post);
    }
}
