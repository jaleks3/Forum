package com.example.Forum.posts;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Get all posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Get a single post by id
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post with id: " + id + " not found"));
    }

    // Create a new post
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    // Update an existing post
    public Post updatePost(Long id, Post newPost) {
        Post existingPost = getPostById(id);
        existingPost.setContent(newPost.getContent());
        existingPost.setPublicationDate(newPost.getPublicationDate());
        existingPost.setForumThread(newPost.getForumThread());
        existingPost.setUser(newPost.getUser());
        return postRepository.save(existingPost);
    }

    // Delete a post by id
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
