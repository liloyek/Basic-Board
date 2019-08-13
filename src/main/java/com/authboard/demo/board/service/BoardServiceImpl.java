package com.authboard.demo.board.service;

import com.authboard.demo.board.dto.BoardDto;
import com.authboard.demo.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;
    /*
    At this moment, boardMapper is not registered as bean yet.
    So IDE tell you it is not bean so that you can't use @Autowired
    After build this project, you won't find any error.

    See also here : https://okky.kr/article/451576
    */

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

        BoardDto board = boardMapper.selectBoardDetail(idx);

        return board;
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