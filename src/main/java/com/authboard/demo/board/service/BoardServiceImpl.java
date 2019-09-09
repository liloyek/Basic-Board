package com.authboard.demo.board.service;

import com.authboard.demo.board.dto.BoardDto;
import com.authboard.demo.board.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    /*
    At this moment, boardMapper is not registered as bean yet.
    So IDE tell you it is not bean so that you can't use @Autowired
    After build this project, you won't find any error.

    See also here : https://okky.kr/article/451576
    */

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<BoardDto> selectBoardList() throws Exception{
        return boardMapper.selectBoardList();
    }

    @Override
    public void insertBoard(BoardDto board) throws Exception{
        boardMapper.insertBoard(board);
    }

    @Override
    public BoardDto selectBoardDetail(int idx) throws Exception{
        boardMapper.updateHitCount(idx);

        return boardMapper.selectBoardDetail(idx);
    }

    @Override
    public void updateBoard(BoardDto board) throws Exception{
        boardMapper.updateBoard(board);
    }

    @Override
    public void deleteBoard(int idx) throws Exception{
        boardMapper.deleteBoard(idx);
    }
}