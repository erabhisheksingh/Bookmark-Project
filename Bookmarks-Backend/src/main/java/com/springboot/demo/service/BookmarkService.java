package com.springboot.demo.service;

import com.springboot.demo.domain.Bookmark;
import com.springboot.demo.dto.BookmarkDTO;
import com.springboot.demo.dto.BookmarkProjectionDTO;
import com.springboot.demo.repository.BookmarkRepository;
import com.springboot.demo.request.CreateBookmarkRequest;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

  private final BookmarkRepository repository;

  @Transactional(readOnly = true)
  public BookmarkDTO getAllBookmarks(Integer pageNo, Integer pageSize, String sortBy) {
    Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
    return new BookmarkDTO(repository.findAllBookmarks(pageable));
  }

  @Transactional(readOnly = true)
  public BookmarkDTO searchBookmarks(Integer pageNo, Integer pageSize, String sortBy,
      String query) {
    Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
    return new BookmarkDTO(repository.searchBookmarks(query, pageable));
  }

  @Transactional
  public BookmarkProjectionDTO createBookmark(CreateBookmarkRequest createBookmarkRequest) {
    Bookmark bookmark = new Bookmark();
    bookmark.setTitle(createBookmarkRequest.getTitle());
    bookmark.setUrl(createBookmarkRequest.getUrl());
    bookmark.setCreatedAt(LocalDateTime.now());
    bookmark = repository.save(bookmark);

    return new BookmarkProjectionDTO(bookmark.getId(), bookmark.getTitle(), bookmark.getUrl(),
        bookmark.getCreatedAt());
  }

}
