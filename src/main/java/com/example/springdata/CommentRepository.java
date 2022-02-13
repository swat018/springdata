package com.example.springdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;
import java.util.stream.Stream;

public interface CommentRepository extends MyRepository<Comment, Long> {

//    List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThan(String keyword, int likeCount);
//    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountDesc(String keyword);
//    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountAsc(String keyword);
//    Page<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);
    Stream<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);
}
