package com.example.intermediate.repository;

import com.example.intermediate.entity.Desktop;
import com.example.intermediate.entity.Phone;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class ComputerRepositoryTest {
    @Autowired
    private DesktopRepository desktopRepository;
    @Autowired
    private PhoneRepository phoneRepository;

    @Test
    public void saveTest() {
        Desktop desktop = new Desktop();
        Phone phone = new Phone();
        desktop.create("1920*1080", "LG", "Gram", 500000, LocalDateTime.now(), hardware, LocalDateTime.now(), LocalDateTime.now(),"hangle");
        phone.create("1920*1080", "Samsung", "S21", 100000, LocalDateTime.now(), "Ram", "SSD", "GPU", "Processor", LocalDateTime.now(), LocalDateTime.now(),86);

        assertThat(desktopRepository.save(desktop).getComputerName()).isEqualTo("Gram");
        assertThat(phoneRepository.save(phone).getComputerName()).isEqualTo("S21");
    }
}
