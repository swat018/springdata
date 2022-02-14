package com.example.springdata;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() throws ExecutionException, InterruptedException {
        this.createComment(100, "spring data jpa");
        this.createComment(55, "HIBEATE SPRING");
        commentRepository.flush();

        List<Comment> all = commentRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "LikeCount"));

        ListenableFuture<List<Comment>> future =
                commentRepository.findByCommentContainsIgnoreCase("Spring", pageRequest);
        System.out.println("================");
        System.out.println("is done?" + future.isDone());

        future.addCallback(new ListenableFutureCallback<List<Comment>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println(ex);
            }

            @Override
            public void onSuccess(@Nullable List<Comment> result) {
                System.out.println("======= ASYNC ======");
                System.out.println(result.size());
            }
        });

        Thread.sleep(5000l);
//
//        List<Comment> comments = future.get();
//        comments.forEach(System.out::println);
    }

    private void createComment(int likeCount, String comment) {
        Comment newComment = new Comment();
        newComment.setLikeCount(likeCount);
        newComment.setComment(comment);
        commentRepository.save(newComment);
    }
}