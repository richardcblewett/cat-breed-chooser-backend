package com.catbreedchooser.catbreedchooserbackend.service;

import com.catbreedchooser.catbreedchooserbackend.exception.InformationExistsException;
import com.catbreedchooser.catbreedchooserbackend.exception.InformationMissingException;
import com.catbreedchooser.catbreedchooserbackend.model.Breed;
import com.catbreedchooser.catbreedchooserbackend.model.Description;
import com.catbreedchooser.catbreedchooserbackend.repository.BreedRepository;
import com.catbreedchooser.catbreedchooserbackend.repository.DescriptionRepository;
import com.catbreedchooser.catbreedchooserbackend.thecatapi.CatBreedToAdd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BreedService {
    private BreedRepository breedRepository;
    private DescriptionRepository descriptionRepository;
    private static final Logger LOGGER = Logger.getLogger(BreedService.class.getName());

    @Autowired
    public void setBreedRepository(BreedRepository breedRepository) {this.breedRepository = breedRepository;}

    @Autowired
    public void  setDescriptionRepository(DescriptionRepository descriptionRepository){this.descriptionRepository = descriptionRepository;}

    //add breed to database
    public void createBreed(CatBreedToAdd catBreed){
        LOGGER.info("calling createBreed from service");
        Breed newBreed = new Breed(catBreed);
        if (!breedRepository.existsByName(newBreed.getName())) {
            Description newDescription = new Description(catBreed.getDescription());
            descriptionRepository.save(newDescription);
            newBreed.setDescription(newDescription);
            breedRepository.save(newBreed);
        } else {
            //this else should never happen because the code should only be run once to seed the database.
            LOGGER.info("the breed "+newBreed.getName()+" is already in the database");
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
