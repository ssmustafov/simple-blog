package com.example.blog.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

/**
 * @author smustafov
 */
public class Post extends BaseModel {

    @NotNull
    @Size(min = 1, max = 100, message = "Must contain between 1 and 100 characters")
    private String title;

    @NotNull
    @Size(min = 1, message = "Must contain at least one character")
    private String content;

    private Date createdAt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) &&
                Objects.equals(content, post.content) &&
                Objects.equals(createdAt, post.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, content, createdAt);
    }

}