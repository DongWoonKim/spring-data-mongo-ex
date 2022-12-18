package com.example.springbootdatamongo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "board")
@Getter
@RequiredArgsConstructor
public class Board {

    @Id
    private String _id;
    private final String title;
    private final String content;

    public void set_id(String id) {
        this._id = id;
    }

}
