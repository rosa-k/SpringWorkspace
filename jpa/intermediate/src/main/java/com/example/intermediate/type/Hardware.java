package com.example.intermediate.type;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//상속 관계가 아니다
@Embeddable  //모듈화
public class Hardware {
    @Column(name = "COMPUTER_RAM")
    private String computerRam;
    @Column(name = "COMPUTER_SSD")
    private String computerSSD;
    @Column(name = "COMPUTER_GPU")
    private String computerGPU;
    @Column(name = "COMPUTER_PROCESSOR")
    private String computerProcessor;

    public void create(String computerRam, String computerSSD, String computerGPU, String computerProcessor) {
        this.computerRam = computerRam;
        this.computerSSD = computerSSD;
        this.computerGPU = computerGPU;
        this.computerProcessor = computerProcessor;
    }
}
