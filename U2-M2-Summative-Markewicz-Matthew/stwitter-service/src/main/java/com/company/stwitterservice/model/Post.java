package com.company.stwitterservice.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Post {

    private int postID;
    private LocalDate postDate;
    private String posterName;
    private String post;
    private List<String> comments;

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post1 = (Post) o;
        return postID == post1.postID &&
                Objects.equals(postDate, post1.postDate) &&
                Objects.equals(posterName, post1.posterName) &&
                Objects.equals(post, post1.post) &&
                Objects.equals(comments, post1.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postID, postDate, posterName, post, comments);
    }

    @Override
    public String toString() {
        return "Post{" +
                "postID=" + postID +
                ", postDate=" + postDate +
                ", posterName='" + posterName + '\'' +
                ", post='" + post + '\'' +
                ", comments=" + comments +
                '}';
    }
}
