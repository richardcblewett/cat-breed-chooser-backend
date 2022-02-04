package com.catbreedchooser.catbreedchooserbackend.model;

import com.catbreedchooser.catbreedchooserbackend.thecatapi.CatBreedToAdd;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;

@Entity
@Table(name = "breed")
public class Breed {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTable;

    //string values
    @Column
    private String id; //specific to thecatapi for internal linking

    @Column
    private String name;

    @Column
    private String reference_image_id; //used to store an id for the main image rather than the entire url

    @Column(columnDefinition = "text") //not sure how long a breed description is.
    private String description;

    // number fields
    @Column
    private Long adaptability;

    @Column
    private Long affection_level;

    @Column
    private Long child_friendly;

    @Column
    private Long dog_friendly;

    @Column
    private Long energy_level;

    @Column
    private Long hypoallergenic;

    @Column
    private Long intelligence;

    @Column
    private Long lap;

    @Column
    private Long shedding_level;

    @Column
    private Long social_needs;

    @Column
    private Long vocalisation;

    @Column
    private Long grooming;

    public Breed() {
    }

    public Breed(CatBreedToAdd catBreedToAdd) {
        this.id = catBreedToAdd.getId();
        this.name = catBreedToAdd.getName();
        this.reference_image_id = catBreedToAdd.getReference_image_id();
        this.adaptability = catBreedToAdd.getAdaptability();
        this.affection_level = catBreedToAdd.getAffection_level();
        this.child_friendly = catBreedToAdd.getChild_friendly();
        this.dog_friendly = catBreedToAdd.getDog_friendly();
        this.energy_level = catBreedToAdd.getEnergy_level();
        this.hypoallergenic = catBreedToAdd.getHypoallergenic();
        this.intelligence = catBreedToAdd.getIntelligence();
        this.lap = catBreedToAdd.getLap();
        this.shedding_level = catBreedToAdd.getShedding_level();
        this.social_needs = catBreedToAdd.getSocial_needs();
        this.vocalisation = catBreedToAdd.getVocalisation();
        this.description = catBreedToAdd.getDescription();
        this.grooming = catBreedToAdd.getGrooming();
    }

    public Breed(String breed_id, String name, String reference_image_id, Long adaptability, Long affection_level, Long child_friendly, Long dog_friendly, Long energy_level, Long hypoallergenic, Long intelligence, Long lap, Long shedding_level, Long social_needs, Long vocalization, String description, Long grooming) {
        this.id = breed_id;
        this.name = name;
        this.reference_image_id = reference_image_id;
        this.adaptability = adaptability;
        this.affection_level = affection_level;
        this.child_friendly = child_friendly;
        this.dog_friendly = dog_friendly;
        this.energy_level = energy_level;
        this.hypoallergenic = hypoallergenic;
        this.intelligence = intelligence;
        this.lap = lap;
        this.shedding_level = shedding_level;
        this.social_needs = social_needs;
        this.vocalisation = vocalization;
        this.description = description;
        this.grooming = grooming;
    }

    public Long getIdTable() {
        return idTable;
    }

    public void setIdTable(Long id) {
        this.idTable = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String breed_id) {
        this.id = breed_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference_image_id() {
        return reference_image_id;
    }

    public void setReference_image_id(String reference_image_id) {
        this.reference_image_id = reference_image_id;
    }

    public Long getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(Long adaptability) {
        this.adaptability = adaptability;
    }

    public Long getAffection_level() {
        return affection_level;
    }

    public void setAffection_level(Long affection_level) {
        this.affection_level = affection_level;
    }

    public Long getChild_friendly() {
        return child_friendly;
    }

    public void setChild_friendly(Long child_friendly) {
        this.child_friendly = child_friendly;
    }

    public Long getDog_friendly() {
        return dog_friendly;
    }

    public void setDog_friendly(Long dog_friendly) {
        this.dog_friendly = dog_friendly;
    }

    public Long getEnergy_level() {
        return energy_level;
    }

    public void setEnergy_level(Long energy_level) {
        this.energy_level = energy_level;
    }

    public Long getHypoallergenic() {
        return hypoallergenic;
    }

    public void setHypoallergenic(Long hypoallergenic) {
        this.hypoallergenic = hypoallergenic;
    }

    public Long getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Long intelligence) {
        this.intelligence = intelligence;
    }

    public Long getLap() {
        return lap;
    }

    public void setLap(Long lap) {
        this.lap = lap;
    }

    public Long getShedding_level() {
        return shedding_level;
    }

    public void setShedding_level(Long shedding_level) {
        this.shedding_level = shedding_level;
    }

    public Long getSocial_needs() {
        return social_needs;
    }

    public void setSocial_needs(Long social_needs) {
        this.social_needs = social_needs;
    }

    public Long getVocalisation() {
        return vocalisation;
    }

    public void setVocalisation(Long vocalization) {
        this.vocalisation = vocalization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getGrooming() {
        return grooming;
    }

    public void setGrooming(Long grooming) {
        this.grooming = grooming;
    }
}
