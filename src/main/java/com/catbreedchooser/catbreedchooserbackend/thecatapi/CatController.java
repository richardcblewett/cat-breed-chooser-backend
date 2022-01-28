//uses an endpoint to test the api
package com.catbreedchooser.catbreedchooserbackend.thecatapi;

import com.catbreedchooser.catbreedchooserbackend.exception.InformationExistsException;
import com.catbreedchooser.catbreedchooserbackend.exception.InformationMissingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class CatController {

    private SearchResult searchResult;

    @Autowired
    private RestTemplate restTemplate;

    private String key = "f4fb05db-2de9-4da7-9987-6b58b7d5b6d8";
    private static String url = "https://api.thecatapi.com/v1/breeds";

    @GetMapping(path = "breeds")
    public void getBreeds() {
        SearchResult searchResult = restTemplate.getForObject(url + "?api_key=" + key,  SearchResult.class);
        if (searchResult == null) {
            throw new InformationMissingException("getBreeds request returned a null value");
        } else if ( 1 == 2 ) {
            throw new InformationMissingException("unable to locate cat breeds from api");
        } else {
            throw new InformationExistsException("ha!") ;   //return new CatApiBreed();
        }
    }

    @GetMapping(path = "json")
    public void getJson() {

    }
}
