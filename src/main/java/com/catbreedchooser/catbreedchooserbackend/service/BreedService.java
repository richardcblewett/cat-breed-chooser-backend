package com.catbreedchooser.catbreedchooserbackend.service;

import com.catbreedchooser.catbreedchooserbackend.exception.InformationMissingException;
import com.catbreedchooser.catbreedchooserbackend.model.Breed;
import com.catbreedchooser.catbreedchooserbackend.repository.BreedRepository;
import com.catbreedchooser.catbreedchooserbackend.thecatapi.CatBreedToAdd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class BreedService {
    private static final Logger LOGGER = Logger.getLogger(BreedService.class.getName());
    private BreedRepository breedRepository;

    @Autowired
    public void setBreedRepository(BreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }

    //add breed to database
    public void createBreed(CatBreedToAdd catBreed) {
        LOGGER.info("calling createBreed from service");
        Breed newBreed = new Breed(catBreed);
        if (!breedRepository.existsByName(newBreed.getName())) {
            breedRepository.save(newBreed);
        } else {
            LOGGER.info("the breed " + newBreed.getName() + " is already in the database");
        }
    }

    //get all breeds
    public List<Breed> getBreeds() {
        LOGGER.info("calling getBreeds from service");
        List<Breed> breeds = breedRepository.findByNameNotNullAndIdNotNull();
        if (breeds.isEmpty()) {
            throw new InformationMissingException("there are no breeds in the database");
        } else {
            return breeds;
        }
    }

    //get list of pictures
    public List<List<String>> getPictures() {
        LOGGER.info("calling getPictures from service");
        List<List<String>> pictures = new ArrayList<>();
        List<Breed> breeds = breedRepository.findByNameNotNullAndIdNotNull();
        breeds.forEach((element) -> {
            String refId = element.getImageId();
            if (refId != null) {
                List<String> pictureId = new ArrayList<>();
                pictureId.add(refId);
                pictureId.add(element.getId());
                pictures.add(pictureId);
            }
        });
        return pictures;
    }

    //get list of breed names
    public List<List<String>> getBreedNames() {
        LOGGER.info("calling getBreedNames from service");
        List<List<String>> names = new ArrayList<>();
        List<Breed> breeds = breedRepository.findByNameNotNullAndIdNotNull();
        breeds.forEach((element) -> {
            String name = element.getName();
            String id = element.getId();
            if (name != null && id != null) {
                List<String> nameId = new ArrayList<>();
                nameId.add(name);
                nameId.add(id);
                names.add(nameId);
            }
        });
        return names;
    }

    //get a single breed by name
    public Breed getBreedById(String id) {
        LOGGER.info("calling getBreedById from service");
        return breedRepository.findById(id);
    }

    //does the breed already exist
    public boolean existsByName(String name) {
        LOGGER.info("calling existsByName from service");
        return breedRepository.existsByName(name);
    }

    public List<Breed> searchBreeds(Long childFriendly, Long intelligence, Long grooming) {
        LOGGER.info("calling searchBreeds from service");
        return breedRepository.findByChildFriendlyIsGreaterThanEqualAndIntelligenceIsGreaterThanEqualAndGroomingIsLessThanEqual(childFriendly,intelligence,grooming);
    }
}