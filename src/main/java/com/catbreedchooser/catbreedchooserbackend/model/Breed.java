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
    private String imageId; //used to store an id for the main image rather than the entire url

    @Column(columnDefinition = "text") //not sure how long a breed description is.
    private String description;

    // number fields
    @Column
    private Long adaptability;

    @Column
    private Long affectionLevel;

    @Column
    private Long childFriendly;

    @Column
    private Long dogFriendly;

    @Column
    private Long energyLevel;

    @Column
    private Long hypoallergenic;

    @Column
    private Long intelligence;

    @Column
    private Long lap;

    @Column
    private Long sheddingLevel;

    @Column
    private Long socialNeeds;

    @Column
    private Long vocalisation;

    @Column
    private Long grooming;

    public Breed() {
    }

    public Breed(CatBreedToAdd catBreedToAdd) {
        this.id = catBreedToAdd.getId();
        this.name = catBreedToAdd.getName();
        this.imageId = catBreedToAdd.getReference_image_id();
        this.adaptability = catBreedToAdd.getAdaptability();
        this.affectionLevel = catBreedToAdd.getAffection_level();
        this.childFriendly = catBreedToAdd.getChild_friendly();
        this.dogFriendly = catBreedToAdd.getDog_friendly();
        this.energyLevel = catBreedToAdd.getEnergy_level();
        this.hypoallergenic = catBreedToAdd.getHypoallergenic();
        this.intelligence = catBreedToAdd.getIntelligence();
        this.lap = catBreedToAdd.getLap();
        this.sheddingLevel = catBreedToAdd.getShedding_level();
        this.socialNeeds = catBreedToAdd.getSocial_needs();
        this.vocalisation = catBreedToAdd.getVocalisation();
        this.description = catBreedToAdd.getDescription();
        this.grooming = catBreedToAdd.getGrooming();
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

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public Long getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(Long adaptability) {
        this.adaptability = adaptability;
    }

    public Long getAffectionLevel() {
        return affectionLevel;
    }

    public void setAffectionLevel(Long affectionLevel) {
        this.affectionLevel = affectionLevel;
    }

    public Long getChildFriendly() {
        return childFriendly;
    }

    public void setChildFriendly(Long childFriendly) {
        this.childFriendly = childFriendly;
    }

    public Long getDogFriendly() {
        return dogFriendly;
    }

    public void setDogFriendly(Long dogFriendly) {
        this.dogFriendly = dogFriendly;
    }

    public Long getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(Long energyLevel) {
        this.energyLevel = energyLevel;
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

    public Long getSheddingLevel() {
        return sheddingLevel;
    }

    public void setSheddingLevel(Long sheddingLevel) {
        this.sheddingLevel = sheddingLevel;
    }

    public Long getSocialNeeds() {
        return socialNeeds;
    }

    public void setSocialNeeds(Long socialNeeds) {
        this.socialNeeds = socialNeeds;
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
