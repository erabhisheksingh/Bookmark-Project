package com.springboot.demo.controller;

import com.springboot.demo.dto.BookmarkDTO;
import com.springboot.demo.dto.BookmarkProjectionDTO;
import com.springboot.demo.request.CreateBookmarkRequest;
import com.springboot.demo.service.BookmarkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

  private final BookmarkService service;

  @GetMapping
  public BookmarkDTO getAllBookmarks(@RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @RequestParam(defaultValue = "id") String sortBy,
      @RequestParam(required = false) String query) {

    if (!StringUtils.hasText(query)) {
      return service.getAllBookmarks(pageNo, pageSize, sortBy);
    }
    return service.searchBookmarks(pageNo, pageSize, sortBy, query);

  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BookmarkProjectionDTO createBookmark(@RequestBody @Valid CreateBookmarkRequest createBookmarkRequest) {
    return service.createBookmark(createBookmarkRequest);
  }
}
