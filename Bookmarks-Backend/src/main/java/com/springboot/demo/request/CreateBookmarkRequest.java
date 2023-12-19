package com.springboot.demo.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateBookmarkRequest {

  @NotNull(message = "Title can't be null")
  @NotEmpty(message = "Title is mandatory")
  private String title;

  @NotNull(message = "URL can't be null")
  @NotEmpty(message = "URL is mandatory")
  private String url;

}
