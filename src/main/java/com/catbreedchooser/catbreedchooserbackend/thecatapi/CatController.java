//uses an endpoint to test the api
package com.catbreedchooser.catbreedchooserbackend.thecatapi;

import com.catbreedchooser.catbreedchooserbackend.exception.InformationExistsException;
import com.catbreedchooser.catbreedchooserbackend.exception.InformationMissingException;
import com.catbreedchooser.catbreedchooserbackend.model.Breed;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.naming.directory.SearchResult;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class CatController {

    private static final Logger LOGGER = Logger.getLogger(CatController.class.getName());
    private CatService catservice;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public void setCatService(CatService catservice){this.catservice = catservice;}

    private String key = "f4fb05db-2de9-4da7-9987-6b58b7d5b6d8";
    private static String url = "https://api.thecatapi.com/v1/breeds";

    private CatApiBreedsResult breedsResult;

    @GetMapping(path = "/breeds")
    public JSONArray getCatApiBreeds() {
        LOGGER.info("calling getCatApiBreeds from controller");
        return catservice.getCatApiBreeds();
    }

    @GetMapping(path = "json")
    public void getJson() {

    }
}
