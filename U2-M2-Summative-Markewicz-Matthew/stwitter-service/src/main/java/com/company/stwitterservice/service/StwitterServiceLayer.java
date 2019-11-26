package com.company.stwitterservice.service;

import com.company.stwitterservice.feign.CommentServiceFeign;
import com.company.stwitterservice.feign.PostServiceFeign;
import com.company.stwitterservice.model.Post;
import com.company.stwitterservice.model.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StwitterServiceLayer {

    @Autowired
    CommentServiceFeign commentServiceFeign;

    @Autowired
    PostServiceFeign postServiceFeign;

    // create posts, get posts, get posts by poster
    public Post createPost(PostViewModel postViewModel) {
        Post post = new Post();
        post.setPosterName(postViewModel.getPosterName());
        post.setPostDate(postViewModel.getPostDate());
        post.setPost(postViewModel.getPost());

        // get the id from adding new post via feign and return the completed Post
        post = postServiceFeign.postPost(post);

        // add comments through comment service
        Post finalPost = post;
        postViewModel.getComments().stream()
                .forEach(comment -> {
                    comment.setPostId(finalPost.getPostID());
                    commentServiceFeign.postComment(comment);
                });

        // set comments to just comment and commenter name
        finalPost.setComments(
            postViewModel.getComments().stream()
                .map(comment -> comment.getComment() + " by " + comment.getCommenterName())
                .collect(Collectors.toList())
        );


        return finalPost;
    }

    public Post getPost(int id) {
        return postServiceFeign.getPostById(id);
    }

    public List<Post> getPostsByPoster(String posterName) {
        return postServiceFeign.getPostsByPosterName(posterName);
    }
}
