package com.catbreedchooser.catbreedchooserbackend.thecatapi;

public class CatBreedToAdd {
    private String id;
    private String name;
    private String reference_image_id;
    private Integer adaptability;
    private Integer affection_level;
    private Integer child_friendly;
    private Integer dog_friendly;
    private Integer energy_level;
    private Integer hypoallergenic;
    private Integer intelligence;
    private Integer lap;
    private Integer shedding_level;
    private Integer social_needs;
    private Integer vocalisation;
    private Integer description_id;
    private String description;
    private Integer grooming;

    public CatBreedToAdd() {
    }

    public CatBreedToAdd(String breed_id, String name, String reference_image_id, Integer adaptability, Integer affection_level, Integer child_friendly, Integer dog_friendly, Integer energy_level, Integer hypoallergenic, Integer intelligence, Integer lap, Integer shedding_level, Integer social_needs, Integer vocalization, Integer grooming) {
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
        this.grooming = grooming;
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

    public void setVocalisation(Integer vocalisation) {
        this.vocalisation = vocalisation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getGrooming() {
        return grooming;
    }

    public void setGrooming(Integer grooming) {
        this.grooming = grooming;
    }
}
