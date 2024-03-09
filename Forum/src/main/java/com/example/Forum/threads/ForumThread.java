package com.example.Forum.threads;

import com.example.Forum.users.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "forum_thread")
public class ForumThread {

    @Id
    @SequenceGenerator(
            name = "forum_sequence",
            sequenceName = "forum_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "forum_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private LocalDateTime creationDate;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public ForumThread() {
    }
    public ForumThread(String title, LocalDateTime creationDate, User user) {
        this.title = title;
        this.creationDate = creationDate;
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
