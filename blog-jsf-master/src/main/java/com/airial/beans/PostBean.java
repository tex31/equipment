package com.airial.beans;

import com.airial.domain.Post;
import com.airial.service.PostService;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.RequestScoped;
import java.util.List;

@Component
@RequestScoped
@URLMappings(mappings = {
        @URLMapping(id = "posts", pattern = "/posts/", viewId = "/faces/posts/list.xhtml"),
        @URLMapping(id = "new", pattern = "/posts/new", viewId = "/faces/posts/new.xhtml")
})
public class PostBean {

    @Autowired
    private PostService postService;

    private List<Post> posts;

    private Post post = new Post();

    public List<Post> getPosts() {
        return postService.findAll();
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String create(Post post) {
        postService.save(post);
        return "pretty:posts";
    }

    public String destroy(Post post) {
        postService.destroy(post);
        return "pretty:posts";
    }
}
