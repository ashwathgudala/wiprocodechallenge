package com.wipro.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.app.JsonParserApplication;
import com.wipro.model.JSONData;
import com.wipro.service.JsonParserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Controller level test cases using mockito
 */
@RunWith(SpringRunner.class)
//@WebMvcTest(JsonParserController.class)
@ContextConfiguration(classes = {JsonParserApplication.class})
@SpringBootTest
@AutoConfigureMockMvc
public class JsonParserControllerTest {

    private static final Logger logger = LogManager.getLogger(JsonParserControllerTest.class);

    @Autowired
    private MockMvc mvc;

    @MockBean
    private JsonParserService jsonParserService;

    @Test
    public void testValidateJSONData() throws Exception {
        JSONData jsonData = constructRequestObject();
        when(jsonParserService.validateJSONData(any())).thenReturn(true);
        mvc.perform(post("/incoming",jsonData)
                .content(asJsonString(constructRequestObject()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        verify(jsonParserService, times(1)).validateJSONData(any());
    }

    private JSONData constructRequestObject() {
        JSONData jsonData = new JSONData();
        jsonData.setId(652);
        jsonData.setFindDuplicates("HereWeHaveSomeDuplicatedCharacters");
        jsonData.setNumbersMeetNumbers(new int[]{10,20,30});
        jsonData.setWhiteSpacesGalore("whiteSpacesGalore");
        jsonData.setValidateMeOnlyIActuallyShouldBeABoolean("true");
       return jsonData;
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
