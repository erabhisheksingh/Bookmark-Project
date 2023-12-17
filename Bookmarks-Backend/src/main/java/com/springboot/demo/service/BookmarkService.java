package com.springboot.demo.service;

import com.springboot.demo.dto.BookmarkDTO;
import com.springboot.demo.repository.BookmarkRepository;
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
        Pageable pageable = PageRequest. of(pageNo, pageSize, Sort.by(sortBy));
        return new BookmarkDTO(repository.findAllBookmarks(pageable));
    }
}
