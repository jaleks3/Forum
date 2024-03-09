package com.example.Forum;

import com.example.Forum.posts.Post;
import com.example.Forum.posts.PostRepository;
import com.example.Forum.threads.ForumThread;
import com.example.Forum.threads.ThreadRepository;
import com.example.Forum.users.User;
import com.example.Forum.users.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class ForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(ThreadRepository threadRepository, UserRepository userRepository, PostRepository postRepository) {
		return args -> {
			User user1 = new User(
					"john_doe",
					"john.doe@example.com",
					"password123"
			);
			User user2 = new User(
					"jane_smith",
					"jane.smith@example.com",
					"securepassword"
			);

			userRepository.saveAll(List.of(user1, user2));

			ForumThread thread1 = new ForumThread(
					"First Thread",
					LocalDateTime.now(),
					user1
			);
			ForumThread thread2 = new ForumThread(
					"Second Thread",
					LocalDateTime.now(),
					user2
			);

			threadRepository.saveAll(List.of(thread1, thread2));

			Post post1 = new Post(
					"First post content",
					LocalDateTime.now(),
					thread1,
					user1
			);
			Post post2 = new Post(
					"Second post content",
					LocalDateTime.now(),
					thread1,
					user2
			);

			postRepository.saveAll(List.of(post1, post2));
		};
	}

}
