package com.example.springbootdatamongo.web.dto;

import com.example.springbootdatamongo.domain.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardRequestDto {
    private String title;
    private String content;

    @Builder
    public BoardRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Board toEntity() {
        return new Board(this.title, this.content);
    }
}
