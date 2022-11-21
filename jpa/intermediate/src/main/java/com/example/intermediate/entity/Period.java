package com.example.intermediate.entity;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@MappedSuperclass
public abstract class Period { //abstract 단독으로 사용할 수 없어서 붙여준다
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public void created(){
        this.createdDate = LocalDateTime.now();
    }

    public Period(LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
