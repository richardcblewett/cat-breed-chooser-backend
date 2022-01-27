package com.catbreedchooser.catbreedchooserbackend.service;

import com.catbreedchooser.catbreedchooserbackend.exception.InformationMissingException;
import com.catbreedchooser.catbreedchooserbackend.model.Breed;
import com.catbreedchooser.catbreedchooserbackend.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BreedService {
    private BreedRepository breedRepository;
    private static final Logger LOGGER = Logger.getLogger(BreedService.class.getName());

    @Autowired
    public void setBreedRepository(BreedRepository breedRepository) {this.breedRepository = breedRepository;}

    //add breed to database
    public Breed createBreed(String name){
        Breed breed = breedRepository.findBreedByNameIgnoreCase(name);
        if (breed != null) {return breed;}
        else {
            Breed breedObject = new Breed();
            //add api object to breed//
            return breedRepository.save(breedObject);
        }
    }

    //get all breeds
    public List<Breed> getBreeds() {
        LOGGER.info("calling getBreeds from service");
        List<Breed> breeds = breedRepository.findAllByNameNotNull();
        if (breeds.isEmpty()) {
            throw new InformationMissingException("there are no breeds in the database");
        } else {
            return breeds;
        }
    }
}
