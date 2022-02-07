package com.catbreedchooser.catbreedchooserbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "profiles")
public class UserProfile {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "userProfile")
    private User user;


    public UserProfile() {
    }

    public UserProfile(User user) {
        this.user = user;
    }

    public UserProfile(Long id, User user) {
        this.id = id;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
