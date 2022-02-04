package com.catbreedchooser.catbreedchooserbackend.repository;

import com.catbreedchooser.catbreedchooserbackend.model.Breed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BreedRepository extends JpaRepository<Breed, Long> {
    boolean existsByName(String name);

    List<Breed> findByNameNotNull();//returns all breeds
    List<Breed> findByChildFriendlyIsGreaterThanEqualAndIntelligenceIsGreaterThanEqualAndGroomingIsGreaterThanEqual(Long childFriendly, Long intelligence, Long grooming);
    Breed findById(String id);
}
