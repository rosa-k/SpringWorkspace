package com.example.advanced.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_CAR_OWNER")
@Getter @Setter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarOwner {
    @Id @GeneratedValue
    private Long carOwnerId;
    private String carOwnerName;
    private int carOwnerAge;
    private String carOwnerZipCode;
    private String carOwnerAddress;
    private String carOwnerAddressDetail;
}
