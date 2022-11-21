package com.example.advanced.entity;

import com.example.advanced.repository.CarOwnerRepository;
import com.example.advanced.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class CarTest {
    @Autowired
    private CarOwnerRepository carOwnerRepository;
    @Autowired
    private CarRepository carRepository;

    @Test
    public void saveTest(){
        CarOwner carOwner = new CarOwner();
        Car car1 = new Car();
        Car car2 = new Car();

        carOwner.setCarOwnerName("ABC");
        carOwner.setCarOwnerAge(27);
        carOwner.setCarOwnerZipCode("15249");
        carOwner.setCarOwnerAddress("경기도");
        carOwner.setCarOwnerAddressDetail("안산시");

        carOwnerRepository.save(carOwner);

        car1.setCarBrand("PORSCHE");
        car1.setCarName("포르쉐911");
        car1.setCarColor("BLACK");
        car1.setCarPrice(17000000);
        car1.setCarReleaseDate(LocalDateTime.now());
        car1.setCarOwner(carOwner);

        car2.setCarBrand("BENTLEY");
        car2.setCarName("벤틀리");
        car2.setCarColor("YELLOW");
        car2.setCarPrice(15000000);
        car2.setCarReleaseDate(LocalDateTime.now());
        car2.setCarOwner(carOwner);

        carRepository.save(car1);
        carRepository.save(car2);
    }

    @Test
    public void findTest(){
        Optional<Car> findCar = carRepository.findById(2L);

        if(findCar.isPresent()){
            Assertions.assertThat(findCar.get().getCarName()).isEqualTo("포르쉐911");

            log.info("car owner name : " + findCar.get().getCarOwner().getCarOwnerName());
            log.info("car : " + findCar.get().getCarOwner().getClass());
        }
    }

    @Test
    public void updateTest(){
        carRepository.findAll().get(0).getCarOwner().setCarOwnerName("Lazy Kim");
    }

}
