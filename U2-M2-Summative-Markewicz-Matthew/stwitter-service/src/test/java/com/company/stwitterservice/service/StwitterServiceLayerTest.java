package com.company.stwitterservice.service;

import com.company.stwitterservice.feign.PostServiceFeign;
import com.company.stwitterservice.model.Comment;
import com.company.stwitterservice.model.Post;
import com.company.stwitterservice.model.PostViewModel;
import com.company.stwitterservice.util.message.CommentMessage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class StwitterServiceLayerTest {

    StwitterServiceLayer service;

    @Mock
    PostServiceFeign postServiceFeign;

    @Mock
    RabbitTemplate rabbitTemplate;

    @Before
    public void setUp() {
        setUpMocks();
        service = new StwitterServiceLayer(postServiceFeign, rabbitTemplate);
    }

    @Test
    public void shouldReturnPostFromCreatePost() {
        Comment commentWithoutId = new Comment();
        commentWithoutId.setComment("Test Comment");
        commentWithoutId.setCommenterName("Test Commenter Name");
        commentWithoutId.setCreateDate(LocalDate.of(2019, 1, 1));

        List<Comment> commentListWithoutIds = new ArrayList<>();
        commentListWithoutIds.add(commentWithoutId);

        PostViewModel postViewModel = new PostViewModel();
        postViewModel.setPosterName("Test Poster Name");
        postViewModel.setPost("Test Post");
        postViewModel.setPostDate(LocalDate.of(2019, 1, 1));
        postViewModel.setComments(commentListWithoutIds);

        List<String> commentList = new ArrayList<>();
        commentList.add("Test Comment by Test Commenter Name");

        Post post = new Post();
        post.setPosterName("Test Poster Name");
        post.setPostDate(LocalDate.of(2019, 1, 1));
        post.setPost("Test Post");
        post.setPostID(5);
        post.setComments(commentList);

        assertEquals(service.createPost(postViewModel).toString(), post.toString());
    }

    @Test
    public void shouldReturnPostFromGetPostById() {
        List<String> commentList = new ArrayList<>();
        commentList.add("Test Comment by Test Commenter Name");

        Post post = new Post();
        post.setPosterName("Test Poster Name");
        post.setPostDate(LocalDate.of(2019, 1, 1));
        post.setPost("Test Post");
        post.setPostID(5);
        post.setComments(commentList);

        assertEquals(post.toString(), service.getPost(5).toString());
    }

    @Test
    public void shouldReturnListOfPostsFromGetPostsByPoster() {
        List<String> commentList = new ArrayList<>();
        commentList.add("Test Comment by Test Commenter Name");

        Post post = new Post();
        post.setPosterName("Test Poster Name");
        post.setPostDate(LocalDate.of(2019, 1, 1));
        post.setPost("Test Post");
        post.setPostID(5);
        post.setComments(commentList);

        List<Post> postList = new ArrayList<>();
        postList.add(post);

        assertEquals(postList.toString(), service.getPostsByPoster("Test Poster Name").toString());
    }

    private void setUpMocks() {
        Comment commentWithoutId = new Comment();
        commentWithoutId.setComment("Test Comment");
        commentWithoutId.setCommenterName("Test Commenter Name");
        commentWithoutId.setCreateDate(LocalDate.of(2019, 1, 1));

        List<Comment> commentListWithoutIds = new ArrayList<>();
        commentListWithoutIds.add(commentWithoutId);

        PostViewModel postViewModel = new PostViewModel();
        postViewModel.setPosterName("Test Poster Name");
        postViewModel.setPost("Test Post");
        postViewModel.setPostDate(LocalDate.of(2019, 1, 1));
        postViewModel.setComments(commentListWithoutIds);

        Comment comment = new Comment();
        comment.setCommenterName("Test Commenter Name");
        comment.setComment("Test Comment");
        comment.setCreateDate(LocalDate.of(2019, 1, 1));
        comment.setPostId(5);
        comment.setCommentId(1);

        List<String> commentList = new ArrayList<>();
        commentList.add("Test Comment by Test Commenter Name");

        Post post = new Post();
        post.setPosterName("Test Poster Name");
        post.setPostDate(LocalDate.of(2019, 1, 1));
        post.setPost("Test Post");
        post.setPostID(5);
        post.setComments(commentList);

        Post postPost = new Post();
        postPost.setPosterName("Test Poster Name");
        postPost.setPostDate(LocalDate.of(2019, 1, 1));
        postPost.setPost("Test Post");

        Post postPostWithId = new Post();
        postPostWithId.setPosterName("Test Poster Name");
        postPostWithId.setPostDate(LocalDate.of(2019, 1, 1));
        postPostWithId.setPost("Test Post");
        postPostWithId.setPostID(5);

        List<Post> postList = new ArrayList<>();
        postList.add(post);

        doReturn(post).when(postServiceFeign).getPostById(5);
        doReturn(postPostWithId).when(postServiceFeign).postPost(postPost);
        doReturn(postList).when(postServiceFeign).getPostsByPosterName("Test Poster Name");
        doNothing().when(rabbitTemplate).convertAndSend(anyString(), anyString(), any(CommentMessage.class));
    }
}
