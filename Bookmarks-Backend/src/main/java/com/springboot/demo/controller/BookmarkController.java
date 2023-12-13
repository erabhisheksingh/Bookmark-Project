package com.springboot.demo.controller;

import com.springboot.demo.dto.BookmarkDTO;
import com.springboot.demo.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService service;

    @GetMapping
    public BookmarkDTO getAllBookmarks(@RequestParam(defaultValue = "0") Integer pageNo,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       @RequestParam(defaultValue = "id") String sortBy) {
        return service.getAllBookmarks(pageNo, pageSize, sortBy);
    }
}
