package com.springboot.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.demo.domain.Bookmark;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class BookmarkDTO {

    private List<Bookmark> data;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    @JsonProperty("isFirst")
    private boolean isFirst;
    @JsonProperty("isLast")
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrev;

    public BookmarkDTO(Page<Bookmark> page) {
        this.data = page.getContent();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.currentPage = getCurrentPage() + 1;
        this.isFirst = page.isFirst();
        this.isLast = page.isLast();
        this.hasNext = page.hasNext();
        this.hasPrev = page.hasPrevious();
    }
}
