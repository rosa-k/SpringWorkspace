package com.example.intermediate.entity;

import com.example.intermediate.type.Hardware;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "COMPUTER_TYPE")
@Table(name = "TBL_COMPUTER")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Computer {
    @Id
    @GeneratedValue
    @Column(name = "COMPUTER_ID")
    private Long computerId;
    @Column(name = "COMPUTER_SCREEN")
    private String computerScreen;
    @Column(name = "COMPUTER_BRAND")
    private String computerBrand;
    @Column(name = "COMPUTER_NAME")
    private String computerName;
    @Column(name = "COMPUTER_PRICE")
    private int computerPrice;
    @Column(name = "COMPUTER_RELEASE_DATE")
    private LocalDateTime computerReleaseDate;

    @Embedded
    private Hardware hardware;

    @Column(name = "COMPUTER_CREATED_DATE")
    private LocalDateTime computerCreatedDate;
    @Column(name = "COMPUTER_UPDATED_DATE")
    private LocalDateTime computerUpdatedDate;

    public void create(String computerScreen, String computerBrand, String computerName, int computerPrice, LocalDateTime computerReleaseDate, Hardware hardware, LocalDateTime computerCreatedDate, LocalDateTime computerUpdatedDate) {
        this.computerScreen = computerScreen;
        this.computerBrand = computerBrand;
        this.computerName = computerName;
        this.computerPrice = computerPrice;
        this.computerReleaseDate = computerReleaseDate;

        this.hardware = hardware;

        this.computerCreatedDate = computerCreatedDate;
        this.computerUpdatedDate = computerUpdatedDate;
    }
}
