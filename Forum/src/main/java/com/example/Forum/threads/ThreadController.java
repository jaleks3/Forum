package com.example.Forum.threads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/thread")
public class ThreadController {
    private final ThreadService threadService;

    @Autowired
    public ThreadController(ThreadService threadService) {
        this.threadService = threadService;
    }
    // Get all threads
    @GetMapping
    public List<ForumThread> getThreads() {
        return threadService.getThreads();
    }
    // Get a single thread by id
    @GetMapping("/{id}")
    public ForumThread getThreadById(@PathVariable Long id) {
        return threadService.getThreadById(id);
    }
    // Create a new thread
    @PostMapping
    public ForumThread createThread(@RequestBody ForumThread forumThread) {
        return threadService.createThread(forumThread);
    }
    // Update an existing thread
    @PutMapping("/{id}")
    public ForumThread updateThread(@PathVariable Long id, @RequestBody ForumThread forumThread) {
        return threadService.updateThread(id, forumThread);
    }

    // Delete a thread by id
    @DeleteMapping("/{id}")
    public void deleteThread(@PathVariable Long id) {
        threadService.deleteThread(id);
    }
}
