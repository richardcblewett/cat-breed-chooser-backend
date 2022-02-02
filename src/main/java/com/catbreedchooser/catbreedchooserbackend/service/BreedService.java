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
    private BreedRepository breedRepository;
    private static final Logger LOGGER = Logger.getLogger(BreedService.class.getName());

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
        List<Breed> breeds = breedRepository.findByNameNotNull();
        if (breeds.isEmpty()) {
            throw new InformationMissingException("there are no breeds in the database");
        } else {
            return breeds;
        }
    }

    //get list of pictures
    public List<String> getPictures() {
        LOGGER.info("calling getPictures from service");
        List<String> pictures = new ArrayList<>();
        List<Breed> breeds = breedRepository.findByNameNotNull();
        breeds.forEach((element) -> {
            String refId = element.getReference_image_id();
            if (refId != null) {
                pictures.add("https://cdn2.thecatapi.com/images/" + refId + ".jpg");
            }
        });
        return pictures;
    }

    //get list of breed names
    public List<List<String>> getBreedNames() {
        LOGGER.info("calling getBreedNames from service");
        List<List<String>> names = new ArrayList<>();
        List<Breed> breeds = breedRepository.findByNameNotNull();
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

    public List<Breed> searchBreeds(Long child_friendly, Long intelligence) {
        LOGGER.info("calling searchBreeds from service");
        List<Breed> result = new ArrayList<>();
        List<Breed> breeds = breedRepository.findByNameNotNull();
        breeds.forEach((element) -> {
            if (element.getChild_friendly() != null && element.getIntelligence() != null) {
                if (element.getIntelligence() >= intelligence && element.getChild_friendly() >= child_friendly) {
                    result.add(element);
                }
            }
        });
        return result;
    }
}