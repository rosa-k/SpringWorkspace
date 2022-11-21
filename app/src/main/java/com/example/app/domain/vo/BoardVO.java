package com.example.app.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class BoardVO {
    private Long boardNumber;
    private String boardWriter;
    private String boardTitle;
    private String boardContent;
    private String boardRegisterDate;
    private String boardUpdateDate;

//    RDB와 관계를 맺을때마다 만들어준다
//    객체는 한방향으로만 조회되기때문에
//    게시글에서 파일을 조회할수없다
    private List<FileVO> files;
}
