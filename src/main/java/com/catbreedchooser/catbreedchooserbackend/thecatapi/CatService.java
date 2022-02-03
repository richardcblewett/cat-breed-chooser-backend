//implements the api
package com.catbreedchooser.catbreedchooserbackend.thecatapi;

import com.catbreedchooser.catbreedchooserbackend.exception.InformationMissingException;
import com.catbreedchooser.catbreedchooserbackend.service.BreedService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            CatBreedToAdd catBreedToAdd = objectMapper.convertValue(object,CatBreedToAdd.class);
            String ref = catBreedToAdd.getReference_image_id();
            //in order to be added to the database, there must be a picture
            if (ref == null) {
            } else if (breedService.existsByName(catBreedToAdd.getName())) {
            } else if (!ref.contains("\n") ) {
                try {
                    String s = getHttpResponse(catBreedToAdd.getReference_image_id());
                    //the picture must be accessible
                    if (s.endsWith("200")) {
                        addResultToDatabase(catBreedToAdd);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        return jsonArray;
    }

    //add single one
    public void addResultToDatabase(CatBreedToAdd catBreed) {
        LOGGER.info("calling addResultToDatabase from service");
        breedService.createBreed(catBreed);
    }

    public String getHttpResponse(String ref) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://cdn2.thecatapi.com/images/"+ref+".jpg"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.toString();
    }
}
