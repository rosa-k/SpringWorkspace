package com.example.ex00.dependency;

import com.example.ex00.qualifier.Computer;
import com.example.ex00.qualifier.Restaurant;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
@ToString
public class QualifierTest {
    @Autowired
    private Computer computer;
    @Autowired @Qualifier("desktop")
    private Computer desktop;
    @Autowired @Qualifier("laptop")
    private Computer laptop;

    @Autowired
    private Restaurant restaurant;
    @Autowired @Qualifier("outback")
    private Restaurant outback;
    @Autowired @Qualifier("vips")
    private Restaurant vips;


    @Test
    public void qualifierTest() {
        log.info(computer + "");
        log.info(desktop + "");
        log.info(laptop + "");

        log.info(restaurant + "");
        log.info(outback + "");
        log.info(vips + "");
    }

}

