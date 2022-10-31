package com.example.ex00.qualifier;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("desktop")
@ToString
public class Desktop implements Computer{
    @Override
    public int getScreenWidth() {
        return 2048;
    }
}
