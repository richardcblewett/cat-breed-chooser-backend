package com.catbreedchooser.catbreedchooserbackend.controller;

import com.catbreedchooser.catbreedchooserbackend.model.Breed;
import com.catbreedchooser.catbreedchooserbackend.service.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api")
public class BreedController {

    private static final Logger LOGGER = Logger.getLogger(BreedController.class.getName());
    private BreedService breedService;

    @Autowired
    public void setBreedService(BreedService breedService) {
        this.breedService = breedService;
    }

    // returns everything
    // http:localhost:9092/api/breeds
    @GetMapping("/breeds")
    public List<Breed> getBreeds() {
        LOGGER.info("calling getBreeds from controller");
        return breedService.getBreeds();
    }

    // returns only the photo reference string
    // http:localhost:9092/api/pictures
    @GetMapping("/pictures")
    public List<List<String>> getPictures() {
        LOGGER.info("calling getPictures from controller");
        return breedService.getPictures();
    }

    // http:localhost:9092/api/names
    @GetMapping("/names")
    public List<List<String>> getBreedNames() {
        LOGGER.info("calling getPictures from controller");
        return breedService.getBreedNames();
    }

    // returns a breed when searched for by name
    // http:localhost:9092/api/id
    @GetMapping("/id")
    public Breed getBreedById(String id) {
        LOGGER.info("calling getPictures from controller");
        return breedService.getBreedById(id);
    }

    // http:localhost:9092/api/search?query
    @GetMapping("/search")
    public List<Breed> searchBreeds(Long childFriendly, Long grooming, Long energyLevel, Long intelligence, Long sheddingLevel, Long socialNeeds, Long vocalisation) {
        LOGGER.info("calling search from controller");
        return breedService.searchBreeds(childFriendly, grooming, energyLevel, intelligence, sheddingLevel, socialNeeds, vocalisation);
    }

}
