package com.example.ex00.dependency;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//log 출력할때 필요
@Slf4j
@ToString
public class DependencyTest {
    //주입해줘
    @Autowired
    private Coding coding;
    @Autowired
    private Restaurant restaurant;

    @Test
    public void dependencyTest(){
        log.info(coding + "");
        log.info(restaurant + "");

    }


}
