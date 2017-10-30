package com.airial.beans;

/**
 * Created by scambour on 14/05/14.
 */

import com.airial.domain.Comment;
import com.airial.domain.Post;
import com.airial.service.PostService;
import com.google.common.collect.Lists;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@Component
@ManagedBean
@RequestScoped
@URLMappings(mappings={
        @URLMapping(id = "comments", pattern = "/posts/#{commentBean.post_id}/comments", viewId = "/faces/posts/show.xhtml")
})
public class CommentBean {

    @Autowired
    private PostService postService;

    private Post post;

    private List <Comment> comments = new ArrayList<>();

    private Long post_id;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @URLAction
    public void loadPost() {
        this.post = postService.findById(post_id);
    }

    public List<Comment> getComments() {
        return Lists.newArrayList(post.getComments());
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }
}
