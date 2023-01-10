package com.example.advanced.entity.task;

import javax.persistence.*;

@Entity
@Table(name = "TBL_CAR_REGISTRATION")
public class CarRegistration extends Period{
    @Id @GeneratedValue
    private Long carRegistrationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_ID")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_OWNER_ID")
    private CarOwner carOwner;
}
