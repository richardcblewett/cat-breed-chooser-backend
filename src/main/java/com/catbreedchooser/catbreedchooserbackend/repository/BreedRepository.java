package com.catbreedchooser.catbreedchooserbackend.repository;

import com.catbreedchooser.catbreedchooserbackend.model.Breed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BreedRepository extends JpaRepository<Breed, Long> {
    boolean existsByName(String name);
    List<Breed> findByNameNotNullAndIdNotNull();
    List<Breed> findByChildFriendlyIsGreaterThanEqualAndGroomingIsLessThanEqualAndEnergyLevelIsGreaterThanEqualAndIntelligenceIsGreaterThanEqualAndSheddingLevelIsLessThanEqualAndSocialNeedsIsGreaterThanEqualAndVocalisationIsGreaterThanEqual
            (Long childFriendly, Long grooming, Long energyLevel, Long intelligence, Long sheddingLevel, Long socialNeeds, Long vocalisation);
    Breed findById(String id);
}
