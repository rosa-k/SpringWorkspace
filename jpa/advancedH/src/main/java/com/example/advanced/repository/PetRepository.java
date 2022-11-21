package com.example.advanced.repository;

import com.example.advanced.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    public List<Pet> findByPetName(@Param("petName"))
}
