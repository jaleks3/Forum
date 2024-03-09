package com.example.Forum.posts;

import com.example.Forum.threads.ForumThread;
import com.example.Forum.users.User;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Table(name = "forum_post")
public class Post {
    @jakarta.persistence.Id
    @Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime publicationDate;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ForumThread forumThread;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    public Post() {
    }

    public Post(String content, LocalDateTime publicationDate, ForumThread forumThread, User user) {
        this.content = content;
        this.publicationDate = publicationDate;
        this.forumThread = forumThread;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public ForumThread getForumThread() {
        return forumThread;
    }

    public void setForumThread(ForumThread forumThread) {
        this.forumThread = forumThread;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
