package com.example.ex00.qualifier;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("laptop") @Primary
@ToString
public class Laptop implements Computer{
    @Override
    public int getScreenWidth() {
        return 1980;
    }
}
