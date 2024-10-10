package com.gulukal.blogspringtrestapi.service;

import com.gulukal.blogspringtrestapi.dto.PostDto;
import com.gulukal.blogspringtrestapi.dto.PostResponse;


/**
 * @author Gulten Ulukal
 */

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo , int pageSize, String sortBy, String sortDir);

    PostDto getPostById( long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

}
