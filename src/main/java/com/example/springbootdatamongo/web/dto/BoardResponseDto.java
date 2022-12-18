package com.example.springbootdatamongo.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardResponseDto {
    private final String _id;
    private final String title;
    private final String content;

    @Builder
    public BoardResponseDto(String id, String title, String content) {
        this._id = id;
        this.title = title;
        this.content = content;
    }
}
