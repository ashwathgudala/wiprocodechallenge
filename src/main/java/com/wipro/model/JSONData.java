package com.wipro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "IncomingJsonData")
public class JSONData {
    @Id
    private long id;
    private String findDuplicates;
    private String whiteSpacesGalore;
    private String validateMeOnlyIActuallyShouldBeABoolean;
    private int[] numbersMeetNumbers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFindDuplicates() {
        return findDuplicates;
    }

    public void setFindDuplicates(String findDuplicates) {
        this.findDuplicates = findDuplicates;
    }

    public String getWhiteSpacesGalore() {
        return whiteSpacesGalore;
    }

    public void setWhiteSpacesGalore(String whiteSpacesGalore) {
        this.whiteSpacesGalore = whiteSpacesGalore;
    }

    public String getValidateMeOnlyIActuallyShouldBeABoolean() {
        return validateMeOnlyIActuallyShouldBeABoolean;
    }

    public void setValidateMeOnlyIActuallyShouldBeABoolean(String validateMeOnlyIActuallyShouldBeABoolean) {
        this.validateMeOnlyIActuallyShouldBeABoolean = validateMeOnlyIActuallyShouldBeABoolean;
    }

    public int[] getNumbersMeetNumbers() {
        return numbersMeetNumbers;
    }

    public void setNumbersMeetNumbers(int[] numbersMeetNumbers) {
        this.numbersMeetNumbers = numbersMeetNumbers;
    }

    @Override
    public String toString() {
        return "JSONData{" +
                "id=" + id +
                ", findDuplicates='" + findDuplicates + '\'' +
                ", whiteSpacesGalore='" + whiteSpacesGalore + '\'' +
                ", validateMeOnlyIActuallyShouldBeABoolean='" + validateMeOnlyIActuallyShouldBeABoolean + '\'' +
                ", numbersMeetNumbers=" + Arrays.toString(numbersMeetNumbers) +
                '}';
    }
}
