//implements the api
package com.catbreedchooser.catbreedchooserbackend.thecatapi;

import com.catbreedchooser.catbreedchooserbackend.exception.InformationMissingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.naming.directory.SearchResult;
import java.util.Arrays;

@Service
public class CatService {

    @Autowired
    private RestTemplate restTemplate;

    private String key = "f4fb05db-2de9-4da7-9987-6b58b7d5b6d8";
    private String url = "https://api.thecatapi.com/v1/breeds";

    public CatApiBreed getBreeds() {

        //adding the api key to the headers
        //https://howtodoinjava.com/spring-boot2/resttemplate/spring-restful-client-resttemplate-example/#get-example
        // 3.4
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("x-api-key", key);
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<SearchResult> searchResult = restTemplate.exchange(url, HttpMethod.POST, entity, SearchResult.class);
        if (searchResult == null) {
            throw new InformationMissingException("getBreeds request returned a null value");
        } else if (!searchResult.hasBody()) {
            throw new InformationMissingException("unable to locate cat breeds from api");
        } else {
            return new CatApiBreed();
        }
    }
}
