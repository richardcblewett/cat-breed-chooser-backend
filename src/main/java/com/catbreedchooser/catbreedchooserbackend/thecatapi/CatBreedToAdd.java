package com.catbreedchooser.catbreedchooserbackend.thecatapi;

public class CatBreedToAdd {
    private String id;
    private String name;
    private String reference_image_id;
    private Long adaptability;
    private Long affection_level;
    private Long child_friendly;
    private Long dog_friendly;
    private Long energy_level;
    private Long hypoallergenic;
    private Long intelligence;
    private Long lap;
    private Long shedding_level;
    private Long social_needs;
    private Long vocalisation;
    private Long description_id;
    private String description;
    private Long grooming;

    public CatBreedToAdd() {
    }

    public CatBreedToAdd(String breed_id, String name, String reference_image_id, Long adaptability, Long affection_level, Long child_friendly, Long dog_friendly, Long energy_level, Long hypoallergenic, Long intelligence, Long lap, Long shedding_level, Long social_needs, Long vocalization, Long grooming) {
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

    public void setVocalisation(Long vocalisation) {
        this.vocalisation = vocalisation;
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
