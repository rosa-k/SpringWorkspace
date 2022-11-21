package com.example.app.mapper;

import com.example.app.domain.vo.BoardVO;
import com.example.app.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTest {
    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void getLiseTest(){
        Criteria criteria = new Criteria();
        criteria.createCriteria(2, 10);
        boardMapper.getList(criteria).stream().map(BoardVO::toString).forEach(log::info);
    }

//    추가, 수정, 삭제
    @Test
    public void insertTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("테스트 제목_ro");
        boardVO.setBoardContent("테스트 내용_ro");
        boardVO.setBoardWriter("ro");
        boardMapper.insert(boardVO);
    }

    @Test
    public void updateTest(){
        BoardVO boardVO  = boardMapper.select(1L);
        Assertions.assertNotNull(boardVO);
        boardVO.setBoardTitle("수정된 게시글 제목");
        log.info("UPDATE COUNT: " + boardMapper.update(boardVO));
    }

    @Test
    public void deleteTest(){
        boardMapper.delete(5L);
    }

    @Test
    public void selectCountOfBoard(){
        Criteria criteria = new Criteria();
        criteria.setType("t");
        criteria.setKeyword("새콤");
        log.info("board count: " + boardMapper.selectCountOfBoard(criteria));
    }
}
