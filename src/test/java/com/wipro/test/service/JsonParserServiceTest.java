package com.wipro.test.service;

import com.wipro.model.JSONData;
import com.wipro.service.JsonParserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer Test Case
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration()
public class JsonParserServiceTest {

    @InjectMocks
    private JsonParserService jsonParserService;

    //TODO: To write negative scenarios for all the cases
    //TODO: Write unit test for save operation on JSONData and MongoDbModel
    @Test
    public void testJSONValidations(){
        boolean isValid = jsonParserService.validateJSONData(constructRequestObject());
        Assert.assertTrue(isValid);
    }

    @Test
    public void testFindDuplicates(){
        String duplicatesString = "Here";
        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("e");
        List actualOutput = jsonParserService.findDuplicates(duplicatesString);
        Assert.assertEquals("e",actualOutput.get(0));
    }

    @Test
    public  void testRemoveWhiteSpace(){
        String whiteSpaceString = "Can we replace ";
        String actualOutput =  jsonParserService.removeWhiteSpace(whiteSpaceString);
        String expectedOutput = "Canwereplace";
        Assert.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void testMaxIntFromArray(){
        int[] inputArray = new int[]{2,20,10};
        int outputInt = jsonParserService.fetchLargestNumber(inputArray);
        int expectedOutputInt = 20;
        Assert.assertEquals(outputInt,expectedOutputInt);
    }

    //TODO : To move common methods to base test class : BaseTest
    private JSONData constructRequestObject() {
        JSONData jsonData = new JSONData();
        jsonData.setId(652);
        jsonData.setFindDuplicates("HereWeHaveSomeDuplicatedCharacters");
        jsonData.setNumbersMeetNumbers(new int[]{10,20,30});
        jsonData.setWhiteSpacesGalore("whiteSpacesGalore");
        jsonData.setValidateMeOnlyIActuallyShouldBeABoolean("true");
        return jsonData;
    }
}