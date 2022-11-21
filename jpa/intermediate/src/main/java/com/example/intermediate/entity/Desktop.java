package com.example.intermediate.entity;

import com.example.intermediate.type.Hardware;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("Desktop")
@Table(name = "TBL_DESKTOP")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Desktop extends Computer {
    @Column(name = "DESKTOP_KEYBOARD")
    private String desktopKeyboard;

    public void create(String computerScreen, String computerBrand, String computerName, int computerPrice, LocalDateTime computerReleaseDate, Hardware hardware, LocalDateTime computerCreatedDate, LocalDateTime computerUpdatedDate, String desktopKeyboard) {
        super.create(computerScreen, computerBrand, computerName, computerPrice, computerReleaseDate, hardware, computerCreatedDate, computerUpdatedDate);
        this.desktopKeyboard = desktopKeyboard;
    }

}
