package com.gulukal.blogspringtrestapi.dto;

import lombok.*;

import java.util.List;

/**
 * @author Gulten Ulukal
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PostResponse {
    private List<PostDto> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
