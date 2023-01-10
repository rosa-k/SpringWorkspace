package com.example.order.service;

import com.example.order.domain.vo.ItemVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ItemServiceTest {
    @Autowired
    private ItemService itemService;

    //    전체 조회 테스트
    @Test
    public void showAllTest(){
        itemService.showAll().stream().map(ItemVO::toString).forEach(log::info);
    }
}
