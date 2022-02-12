package com.example.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @Autowired
//    PostRepository postRepository;
    Jinwoo jinwoo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        postRepository.findAll().forEach(System.out::println);
        System.out.println("=======================");
        System.out.println(jinwoo.getName());
    }
}
