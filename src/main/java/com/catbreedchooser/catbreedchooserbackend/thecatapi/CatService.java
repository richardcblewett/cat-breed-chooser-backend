//implements the api
package com.catbreedchooser.catbreedchooserbackend.thecatapi;

import com.catbreedchooser.catbreedchooserbackend.exception.InformationMissingException;
import com.catbreedchooser.catbreedchooserbackend.model.Breed;
import com.catbreedchooser.catbreedchooserbackend.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.naming.directory.SearchResult;
import java.util.Arrays;
import java.util.logging.Logger;

@Service
public class CatService {

    private static final Logger LOGGER = Logger.getLogger(CatService.class.getName());
    private BreedRepository breedRepository;

    @Autowired
    public void setBreedRepository(BreedRepository breedRepository) {this.breedRepository = breedRepository;}

    @Autowired
    private RestTemplate restTemplate;

    private String key = "f4fb05db-2de9-4da7-9987-6b58b7d5b6d8";
    private String url = "https://api.thecatapi.com/v1/breeds";

    public CatApiBreedsResult getCatApiBreeds() {
        LOGGER.info("calling getCatApiBreeds from service");
        CatApiBreedsResult catApiBreedsResult = restTemplate.getForObject(url + "?api_key=" + key, CatApiBreedsResult.class);
        if (catApiBreedsResult == null) {
            throw new InformationMissingException("getBreeds request returned a null value");
        } else {
            //this should be good data ready to add to the database
            return addResultsToDatabase(catApiBreedsResult);
        }
    }

    //add them all
    public CatApiBreedsResult addResultsToDatabase(CatApiBreedsResult catApiBreedsResult) {
        LOGGER.info("calling addResultSToDatabase from service");
        for (CatApiBreeds catApiBreeds : catApiBreedsResult.catApiBreed) {
            addResultToDatabase(catApiBreeds);
        }
        return catApiBreedsResult;
    }

    //add single one
    public void addResultToDatabase(CatApiBreeds catBreed) {
        LOGGER.info("calling addResultToDatabase from service");
        Breed newBreed = new Breed(catBreed);
    }
}
