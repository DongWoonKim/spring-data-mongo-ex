package com.example.springbootdatamongo.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BoardRepository extends MongoRepository<Board, String> {
    List<Board> findByTitle(String title);
}
