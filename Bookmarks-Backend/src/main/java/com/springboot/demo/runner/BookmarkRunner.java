package com.springboot.demo.runner;

import com.springboot.demo.domain.Bookmark;
import com.springboot.demo.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookmarkRunner implements CommandLineRunner {

    private final BookmarkRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.saveAll(List.of(
                new Bookmark(null, "Google", "www.google.com", LocalDateTime.now()),
                new Bookmark(null, "Youtube", "www.youtube.com", LocalDateTime.now()),
                new Bookmark(null, "Golang", "www.go.dev", LocalDateTime.now()),
                new Bookmark(null, "Spring", "www.start.spring.io", LocalDateTime.now()),
                new Bookmark(null, "Java", "www.dev.java", LocalDateTime.now()),
                new Bookmark(null, "Twitter", "www.twitter.com", LocalDateTime.now()),
                new Bookmark(null, "Instagram", "www.instagram.com", LocalDateTime.now()),
                new Bookmark(null, "Google News", "www.news.google.com", LocalDateTime.now()),
                new Bookmark(null, "Leetcode", "www.leetcode.com", LocalDateTime.now()),
                new Bookmark(null, "Neetcode", "www.neetcode.io", LocalDateTime.now())
        ));
    }
}
