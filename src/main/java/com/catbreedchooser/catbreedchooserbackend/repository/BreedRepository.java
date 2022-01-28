package com.catbreedchooser.catbreedchooserbackend.repository;

import com.catbreedchooser.catbreedchooserbackend.model.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreedRepository extends JpaRepository<Breed,Long> {
    boolean existsByName(String name);
    List<Breed> findAllByNameNotNull();//returns all breeds
}
