package com.example.advanced.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_CAR")
@Getter @Setter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Car extends Period{
    @Id @GeneratedValue
    private Long carId;
    private String carBrand;
    private String carName;
    private String carColor;
    private int carPrice;
    private LocalDateTime carReleaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_OWNER_ID")
    private CarOwner carOwner;
}
