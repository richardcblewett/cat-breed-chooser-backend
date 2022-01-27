package com.catbreedchooser.catbreedchooserbackend.model;

import javax.persistence.*;

@Entity
@Table(name="breed")
public class Breed {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //string values
    @Column
    private String breed_id; //specific to thecatapi for internal linking

    @Column
    private String name;

    @Column
    private String reference_image_id; //used to store an id for the main image rather than the entire url

    // number fields
    @Column
    private Integer adaptability;

    @Column
    private Integer affection_level;

    @Column
    private Integer child_friendly;

    @Column
    private Integer dog_friendly;

    @Column
    private Integer energy_level;

    @Column
    private Integer hypoallergenic;

    @Column
    private Integer intelligence;

    @Column
    private Integer lap;

    @Column
    private Integer shedding_level;

    @Column
    private Integer social_needs;

    @Column
    private Integer vocalization;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "description_id", referencedColumnName = "id")
    private Description description;

}
