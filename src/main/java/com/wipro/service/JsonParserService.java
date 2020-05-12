package com.wipro.service;

import com.wipro.model.JSONData;
import com.wipro.model.MongoDbModel;
import com.wipro.repository.JSONDataRepository;
import com.wipro.repository.MongoDbModelRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JsonParserService {

    private static final Logger logger = LogManager.getLogger(JsonParserService.class);

    @Autowired
    private MongoDbModelRepository mongoDbModelRepository;

    @Autowired
    private JSONDataRepository jsonDataRepository;

   /**
     * This method is used to validate the incoming JSON data
     */
    public boolean validateJSONData(JSONData jsonData){
        return true;
    }

    /**
     * Save the incoming json request
     */
    public void saveIncomingJSONData(JSONData jsonData){
        jsonDataRepository.save(jsonData);
    }

    /**
     * Save the outgoing mongodb json request
     */
    public void saveOutgoingModelData(MongoDbModel mongoDbModel){
        mongoDbModelRepository.save(mongoDbModel);
    }

    /**
     *Find duplicate characters in a given string
     */
    public List<String> findDuplicates(String inputString){
        Map<String, Long> charCount = inputString.chars().mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List duplicateCharacters = charCount.entrySet().stream().filter(value -> {
            if(value.getValue() >=2)
                return true;
            return false;
        }).map(map -> map.getKey()).collect(Collectors.toList());
        return duplicateCharacters;
    }

    /**
     * Method to remove white spaces with out using replace function
     */
    public String removeWhiteSpace(String string){
        String leanString = Arrays.stream(string.split(" ")).map(
                s -> s.trim()).collect(Collectors.joining());
        return leanString;
    }

    /**
     *Find the largest number in a give integer array
     */
    public int fetchLargestNumber(int[] inputArray){
        return Arrays.stream(inputArray).max().getAsInt();
    }

    public MongoDbModel constructOutgoingModelData(JSONData jsonData) {
        MongoDbModel mongoDbModel = new MongoDbModel();
        mongoDbModel.setDuplicateCharacters(findDuplicates(jsonData.getFindDuplicates()));
        mongoDbModel.setId(new Random().nextLong());
        mongoDbModel.setMaxNumber(fetchLargestNumber(jsonData.getNumbersMeetNumbers()));
        mongoDbModel.setStringWithNoSpaces(removeWhiteSpace(jsonData.getWhiteSpacesGalore()));
        return mongoDbModel;
    }
}
