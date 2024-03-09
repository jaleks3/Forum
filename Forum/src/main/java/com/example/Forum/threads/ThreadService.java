package com.example.Forum.threads;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThreadService {
    private final ThreadRepository threadRepository;

    @Autowired
    public ThreadService(ThreadRepository threadRepository) {
        this.threadRepository = threadRepository;
    }

    // Get all threads
    public List<ForumThread> getThreads() {
        return threadRepository.findAll();
    }

    // Get a single thread by id
    public ForumThread getThreadById(Long id) {
        return threadRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Thread with id: " + id + " not found"));
    }

    // Create a new thread
    public ForumThread createThread(ForumThread forumThread) {
        return threadRepository.save(forumThread);
    }

    // Update an existing thread
    public ForumThread updateThread(Long id, ForumThread newForumThread) {
        ForumThread existingThread = getThreadById(id);
        existingThread.setTitle(newForumThread.getTitle());
        existingThread.setCreationDate(newForumThread.getCreationDate());
        existingThread.setUser(newForumThread.getUser());
        return threadRepository.save(existingThread);
    }

    // Delete a thread by id
    public void deleteThread(Long id) {
        threadRepository.deleteById(id);
    }


}
