//implements the api
package com.catbreedchooser.catbreedchooserbackend.thecatapi;

import com.catbreedchooser.catbreedchooserbackend.exception.InformationExistsException;
import com.catbreedchooser.catbreedchooserbackend.exception.InformationMissingException;
import com.catbreedchooser.catbreedchooserbackend.model.Breed;
import com.catbreedchooser.catbreedchooserbackend.repository.BreedRepository;
import com.catbreedchooser.catbreedchooserbackend.service.BreedService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.logging.Logger;

@Service
public class CatService {

    private static final Logger LOGGER = Logger.getLogger(CatService.class.getName());
    private BreedService breedService;

    @Autowired
    public void setBreedService(BreedService breedService) {this.breedService = breedService;}

    @Autowired
    private RestTemplate restTemplate;

    private String key = "f4fb05db-2de9-4da7-9987-6b58b7d5b6d8";
    private String url = "https://api.thecatapi.com/v1/breeds";

    public JSONArray getCatApiBreeds() {
        LOGGER.info("calling getCatApiBreeds from service");
        JSONArray jsonArray = restTemplate.getForObject(url + "?api_key=" + key, JSONArray.class);
        //CatApiBreedsResult catApiBreedsResult = restTemplate.getForObject(url + "?api_key=" + key, CatApiBreedsResult.class);
        if (jsonArray == null) {
            throw new InformationMissingException("getBreeds request returned a null value");
        } else {
            //this should be good data ready to add to the database
            return addResultsToDatabase(jsonArray);
        }
    }

    //add them all
    public JSONArray addResultsToDatabase(JSONArray jsonArray) {
        LOGGER.info("calling addResultSToDatabase from service");
        jsonArray.forEach( object -> {
            //System.out.println(object.toString());//prints individual json objects
            //System.out.println('\n');
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            CatBreedToAdd catBreedToAdd = objectMapper.convertValue(object,CatBreedToAdd.class);
            //System.out.println(catBreedToAdd.toString());
            addResultToDatabase(catBreedToAdd);

        });
        return jsonArray;
    }

    //add single one
    public void addResultToDatabase(CatBreedToAdd catBreed) {
        LOGGER.info("calling addResultToDatabase from service");
        breedService.createBreed(catBreed);
    }
}
