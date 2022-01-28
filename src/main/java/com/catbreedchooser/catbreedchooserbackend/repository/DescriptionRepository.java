package com.catbreedchooser.catbreedchooserbackend.repository;

import com.catbreedchooser.catbreedchooserbackend.model.Description;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescriptionRepository extends JpaRepository<Description,Long> {
    Long findDescriptionById(Long id);
}
