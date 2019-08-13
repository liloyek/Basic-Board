package com.authboard.demo.board.service;

import com.authboard.demo.board.dto.BoardDto;

import java.util.List;

public interface BoardService {

    List<BoardDto> selectBoardList() throws Exception;

    void insertBoard(BoardDto board) throws Exception;

    BoardDto selectBoardDetail(int idx) throws Exception;

    void updateBoard(BoardDto board) throws Exception;

    void deleteBoard(int idx) throws Exception;
}
