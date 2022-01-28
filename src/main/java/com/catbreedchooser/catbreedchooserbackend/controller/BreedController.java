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
@RequestMapping(path="/api")
public class BreedController {

    private BreedService breedService;
    private static final Logger LOGGER = Logger.getLogger(BreedController.class.getName());

    @Autowired
    public void setBreedService(BreedService breedService){this.breedService= breedService;}

    //http:localhost:9092/api/breeds
    @GetMapping("/breeds")
    public List<Breed> getBreeds() {
        LOGGER.info("calling getBreeds from controller");
        return breedService.getBreeds();
    }

}
