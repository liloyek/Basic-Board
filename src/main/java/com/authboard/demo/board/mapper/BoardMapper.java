package com.authboard.demo.board.mapper;

import com.authboard.demo.board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDto> selectBoardList() throws Exception;

    void insertBoard(BoardDto board) throws Exception;

    void updateHitCount(int idx) throws Exception;

    BoardDto selectBoardDetail(int idx) throws Exception;

    void updateBoard(BoardDto board) throws Exception;

    void deleteBoard(int idx) throws Exception;
}
