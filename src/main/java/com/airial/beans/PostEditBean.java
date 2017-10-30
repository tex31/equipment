package com.airial.beans;

import com.airial.domain.Post;
import com.airial.service.PostService;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by scambour on 20/05/14.
 */
@Component
@ManagedBean
@RequestScoped
@URLMapping(id = "postEdit", pattern = "/posts/#{postEditBean.id}/edit", viewId = "/faces/posts/edit.xhtml")
public class PostEditBean {

    @Autowired
    private PostService postService;

    private Long id;

    private Post post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @URLAction
    public void loadPost() {
        post = postService.findById(id);
    }

    public String update(final Post post) {
        postService.save(post);
        return "pretty:posts";
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
