package com.catbreedchooser.catbreedchooserbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="description")
public class Description {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text") //not sure how long a breed description is.
    private String description;

    @JsonIgnore
    @OneToOne(mappedBy = "description")
    private Breed breed;

    public Description() {
    }

    public Description(String description) {
        this.description = description;
    }
}
