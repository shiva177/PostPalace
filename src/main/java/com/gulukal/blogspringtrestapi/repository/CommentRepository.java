package com.gulukal.blogspringtrestapi.repository;

import com.gulukal.blogspringtrestapi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Gulten Ulukal
 */

// @Repository // infact no need to add...
// @Transactional // infact no need to add...
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByPostId(long postId);
}
