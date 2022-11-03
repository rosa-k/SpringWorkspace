package com.example.app.mapper;

import com.example.app.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
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
        boardMapper.getList().stream().map(BoardVO::toString).forEach(log::info);
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
        BoardVO boardVO = boardMapper.getBoard(13L, "ro");
        boardVO.setBoardTitle("제목 수정_ro");
        boardVO.setBoardContent("내용 수정_ro");
        boardMapper.update(boardVO);
    }

    @Test
    public void deleteTest(){
        boardMapper.delete(5L);
    }
}
