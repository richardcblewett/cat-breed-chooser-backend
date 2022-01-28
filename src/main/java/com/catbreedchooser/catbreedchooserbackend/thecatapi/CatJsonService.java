package com.catbreedchooser.catbreedchooserbackend.thecatapi;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CatJsonService {

    public JSONArray readFile() throws FileNotFoundException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("catBreeds.json");
        //Read JSON file
        Object obj = jsonParser.parse(reader);
        JSONArray jsonArray = (JSONArray) obj;
        return jsonArray;
    }
}