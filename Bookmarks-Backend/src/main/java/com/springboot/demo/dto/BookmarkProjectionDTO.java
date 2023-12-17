package com.springboot.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkProjectionDTO {

    private Long id;

    private String title;

    private String url;

    private LocalDateTime createdAt;
}
