package com.catbreedchooser.catbreedchooserbackend.thecatapi;

import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class CatController {

    private static final Logger LOGGER = Logger.getLogger(CatController.class.getName());
    private CatService catservice;

    @Autowired
    public void setCatService(CatService catservice) {
        this.catservice = catservice;
    }

    @GetMapping(path = "/breeds")
    public JSONArray getCatApiBreeds() {
        LOGGER.info("calling getCatApiBreeds from catcontroller");
        return catservice.getCatApiBreeds();
    }

}
