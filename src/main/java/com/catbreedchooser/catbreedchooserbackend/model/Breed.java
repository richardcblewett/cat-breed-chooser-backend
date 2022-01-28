package com.catbreedchooser.catbreedchooserbackend.model;

import com.catbreedchooser.catbreedchooserbackend.thecatapi.CatBreedToAdd;

import javax.persistence.*;

@Entity
@Table(name="breed")
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
    private Integer vocalisation;

    public Breed() {
    }

    public Breed(CatBreedToAdd catBreedToAdd){
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
    }

    public Breed(String breed_id, String name, String reference_image_id, Integer adaptability, Integer affection_level, Integer child_friendly, Integer dog_friendly, Integer energy_level, Integer hypoallergenic, Integer intelligence, Integer lap, Integer shedding_level, Integer social_needs, Integer vocalization, String description) {
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

    public Integer getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(Integer adaptability) {
        this.adaptability = adaptability;
    }

    public Integer getAffection_level() {
        return affection_level;
    }

    public void setAffection_level(Integer affection_level) {
        this.affection_level = affection_level;
    }

    public Integer getChild_friendly() {
        return child_friendly;
    }

    public void setChild_friendly(Integer child_friendly) {
        this.child_friendly = child_friendly;
    }

    public Integer getDog_friendly() {
        return dog_friendly;
    }

    public void setDog_friendly(Integer dog_friendly) {
        this.dog_friendly = dog_friendly;
    }

    public Integer getEnergy_level() {
        return energy_level;
    }

    public void setEnergy_level(Integer energy_level) {
        this.energy_level = energy_level;
    }

    public Integer getHypoallergenic() {
        return hypoallergenic;
    }

    public void setHypoallergenic(Integer hypoallergenic) {
        this.hypoallergenic = hypoallergenic;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getLap() {
        return lap;
    }

    public void setLap(Integer lap) {
        this.lap = lap;
    }

    public Integer getShedding_level() {
        return shedding_level;
    }

    public void setShedding_level(Integer shedding_level) {
        this.shedding_level = shedding_level;
    }

    public Integer getSocial_needs() {
        return social_needs;
    }

    public void setSocial_needs(Integer social_needs) {
        this.social_needs = social_needs;
    }

    public Integer getVocalisation() {
        return vocalisation;
    }

    public void setVocalisation(Integer vocalization) {
        this.vocalisation = vocalization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
