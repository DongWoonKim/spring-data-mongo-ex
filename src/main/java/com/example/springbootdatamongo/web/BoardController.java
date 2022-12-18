package com.example.springbootdatamongo.web;

import com.example.springbootdatamongo.domain.Board;
import com.example.springbootdatamongo.domain.BoardRepository;
import com.example.springbootdatamongo.web.dto.BoardRequestDto;
import com.example.springbootdatamongo.web.dto.BoardResponseDto;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping("/board")
    public List<BoardResponseDto> findAll() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream()
                .map(m -> BoardResponseDto.builder()
                        .id(m.get_id())
                        .title(m.getTitle())
                        .content(m.getContent())
                        .build()
                ).collect(Collectors.toList());

    }

    @GetMapping("/board/title")
    public List<BoardResponseDto> findByTitle(@PathParam("title") String title) {
        List<Board> boards = boardRepository.findByTitle( title );
        return boards.stream()
                .map(m -> BoardResponseDto.builder()
                .id(m.get_id())
                .title(m.getTitle())
                .content(m.getContent())
                .build()).collect(Collectors.toList());
    }

    @GetMapping("/board/{id}")
    public BoardResponseDto findById(@PathVariable String id) {
        Board board = boardRepository.findById(id).get();
        return BoardResponseDto.builder()
                .id(board.get_id())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }

    @PostMapping("/board")
    public BoardResponseDto save(@RequestBody BoardRequestDto requestDto) {
        Board save = boardRepository.save(requestDto.toEntity());
        return BoardResponseDto.builder()
                .id(save.get_id())
                .title(save.getTitle())
                .content(save.getContent())
                .build();
    }

    @PutMapping("/board/{id}")
    public void update(@PathVariable String id, @RequestBody BoardRequestDto requestDto) {
        Board board = requestDto.toEntity();
        board.set_id(id);
        boardRepository.save(board);
    }

    @DeleteMapping("/board/{id}")
    public void delete(@PathVariable String id) {
        boardRepository.deleteById(id);
    }

}
