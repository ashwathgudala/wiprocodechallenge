package com.wipro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "OutGoingJsonData")
public class MongoDbModel {
    @Id
    private long id;
    private List<String> duplicateCharacters;
    private String stringWithNoSpaces;
    private int maxNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStringWithNoSpaces() {
        return stringWithNoSpaces;
    }

    public void setStringWithNoSpaces(String stringWithNoSpaces) {
        this.stringWithNoSpaces = stringWithNoSpaces;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public List<String> getDuplicateCharacters() {
        return duplicateCharacters;
    }

    public void setDuplicateCharacters(List<String> duplicateCharacters) {
        this.duplicateCharacters = duplicateCharacters;
    }
}
