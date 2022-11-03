package com.example.app.domain.dao;

import com.example.app.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardDAOTest {
    @Autowired
    private BoardDAO boardDAO;

    @Test
    public void getListTest(){
        boardDAO.findAll().stream().map(BoardVO::toString).forEach(log::info);
    }

    @Test
    public void insertTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("테스트 제목2");
        boardVO.setBoardWriter("ro");
        boardVO.setBoardContent("테스트 내용2");
        boardDAO.save(boardVO);
        log.info("추가된 게시글 번호: " + boardVO.getBoardNumber());
    }

    @Test
    public void updateTest(){
        BoardVO boardVO  = boardDAO.findById(27L);
        Assertions.assertNotNull(boardVO);
        boardVO.setBoardTitle("수정된 게시글 제목");
        log.info("UPDATE COUNT: " + boardDAO.setBoard(boardVO));
    }

    @Test
    public void deleteTest(){
        Long boardNumber = 27L;
        BoardVO boardVO = boardDAO.findById(boardNumber);
        Assertions.assertNotNull(boardVO);
        boardDAO.deleteById(boardNumber);
    }


}
