package com.catbreedchooser.catbreedchooserbackend.repository;


import com.catbreedchooser.catbreedchooserbackend.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
