package com.gulukal.blogspringtrestapi.service;

import com.gulukal.blogspringtrestapi.dto.CommentDto;

import java.util.List;

/**
 * @author Gulten Ulukal
 */

public interface CommentService {

    CommentDto createComment (long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);

    CommentDto getCommentById(long postId , long commentId);

    CommentDto updateComment(long postId , long commentId , CommentDto commentRequest);

    void deleteComment( long postId, long commentId);
}
