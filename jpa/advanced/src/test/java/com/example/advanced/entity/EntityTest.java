package com.example.advanced.entity;

import com.example.advanced.repository.OwnerRepository;
import com.example.advanced.repository.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.Optional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class EntityTest {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    public void saveTest(){
        Owner owner = new Owner();
        Pet pet1 = new Pet();
        Pet pet2 = new Pet();

        owner.setOwnerName("한동석");
        owner.setOwnerPhone("01012345678");

        ownerRepository.save(owner);

        pet1.setPetName("Tom");
        pet1.setPetGender("Male");
        pet1.setPetDisease("Cold");
        pet1.setOwner(owner);

        pet2.setPetName("Tommy");
        pet2.setPetGender("Male");
        pet2.setPetDisease("Cold");
        pet2.setOwner(owner);

        petRepository.save(pet1);
        petRepository.save(pet2);
    }

    @Test
    public void findTest(){
        Optional<Pet> findPet = petRepository.findById(2L);

        if(findPet.isPresent()){
            Assertions.assertThat(findPet.get().getPetName()).isEqualTo("Tom");
//            기존에 연관객체를 필드로 가지고 있는 객체를 조회할 경우
//            지연 로딩으로 설정했다면, 필드에 있는 연관 객체에는 Proxy가 주입된다
//            이 때 최초 Proxy는 원본 객체를 상속받고 필드도 그대로 가지고 있다
//            하지만 ID 값만 들어가고 나머지 필드는 NULL로 되어 있고,
//            ID 외에 다른 필드를 조회 할 때 새로운 쿼리가 발생한다

//            entityManager.flush();
//            entityManager.clear();

//            영속성 컨텍스트를 비우면 매핑 정보를 가지고 있던 객체가 없어지므로,
//            더 이상 필드에 있던 연관객체 조회 시 Proxy에 있던 ID를 제외한 다른 필드 조회가 불가능 해진다.
            log.info("owner Phone" + findPet.get().getOwner().getOwnerPhone());
            log.info("owner : "+ findPet.get().getOwner().getClass());
        }
    }

    @Test
    public void updateTest(){
        petRepository.findAll().get(0).getOwner().setOwnerName("Lazy Kim");
    }


}
