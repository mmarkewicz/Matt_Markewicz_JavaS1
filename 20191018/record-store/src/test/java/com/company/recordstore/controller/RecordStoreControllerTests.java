package com.company.recordstore.controller;

import com.company.recordstore.models.Record;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RecordStoreController.class)
public class RecordStoreControllerTests {

    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // a List of Records for testing purposes
    private List<Record> recordList;

    @Before
    public void setUp() throws Exception {

        // Standard set up method, for instantiating test objects
        // Don't have to do anything special for mockMvc since it's Autowired
        int idCounter = 1;

        recordList = new ArrayList<>();

        recordList.add(new Record("The Beach Boys", "Pet Sounds", "1966", idCounter++));
        recordList.add(new Record("Billy Joel", "The Stranger", "1977", idCounter++));
        recordList.add(new Record("The Beatles", "Revolver", "1966", idCounter++));
        recordList.add(new Record("Kanye West", "My Beautiful Dark Twisted Fantasy", "2010", idCounter++));
        recordList.add(new Record("Sturgill Simpson", "Metamodern Sounds in Country Music", "2014", idCounter++));
    }

    // testing GET /records
    @Test
    public void shouldReturnAllRecordsInCollection() throws Exception {

        // ARRANGE
        // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(recordList);

        // ACT
        mockMvc.perform(get("/records"))                 // perform the GET request
                .andDo(print())                          // print results to console
                .andExpect(status().isOk())              // ASSERT (status code is 200)
                .andExpect(content().json(outputJson));  // ASSERT (output is as expected)
    }

    // testing POST /records
    @Test
    public void shouldReturnNewRecordOnPostRequest() throws Exception {

        // ARRANGE
        Record inputRecord = new Record();
        inputRecord.setArtist("Bruce Springsteen");
        inputRecord.setAlbum("The River");
        inputRecord.setYear("1980");

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(inputRecord);

        Record outputRecord = new Record();
        outputRecord.setArtist("Bruce Springsteen");
        outputRecord.setAlbum("The River");
        outputRecord.setYear("1980");
        outputRecord.setId(6);

        String outputJson = mapper.writeValueAsString(outputRecord);

        // ACT
        mockMvc.perform(
                post("/records")                                // perform the POST request
                        .content(inputJson)                         // Set the request body
                        .contentType(MediaType.APPLICATION_JSON)    // Tell the server it's in JSON format
        )
                .andDo(print())                                     // print results to console
                .andExpect(status().isCreated())                    // ASSERT (status code is 201)
                .andExpect(content().json(outputJson));             // ASSERT (output is as expected)
    }

    @Test
    public void shouldReturn422StatusCodeWithInvalidRequestBody() throws Exception {
        // ARRANGE
        Record inputRecord = new Record();
        inputRecord.setArtist("Bruce Springsteen");
        inputRecord.setAlbum("The River");

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(inputRecord);

        Record outputRecord = new Record();
        outputRecord.setArtist("Bruce Springsteen");
        outputRecord.setAlbum("The River");
        outputRecord.setId(6);

        String outputJson = mapper.writeValueAsString(outputRecord);

        // ACT
        mockMvc.perform(
                post("/records")                                // perform the POST request
                        .content(inputJson)                         // Set the request body
                        .contentType(MediaType.APPLICATION_JSON)    // Tell the server it's in JSON format
        )
                .andDo(print())                                     // print results to console
                .andExpect(status().isUnprocessableEntity());                   // ASSERT (status code is 422)
    }

    // testing GET record/{id}
    @Test
    public void shouldReturnRecordById() throws Exception {

        Record outputRecord = new Record();
        outputRecord.setArtist("Billy Joel");
        outputRecord.setAlbum("The Stranger");
        outputRecord.setYear("1977");
        outputRecord.setId(2);

        String outputJson = mapper.writeValueAsString(outputRecord);

        mockMvc.perform(get("/records/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturn404StatusCodeIfRecordNotFound() throws Exception {
        mockMvc.perform(get("/records/0"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    // testing PUT /records/{id}
    @Test
    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content

        Record inputRecord = new Record();
        inputRecord.setArtist("William Joel");
        inputRecord.setAlbum("The Stranger");
        inputRecord.setYear("1977");
        inputRecord.setId(2);

        String inputJson = mapper.writeValueAsString(inputRecord);

        mockMvc.perform(
                put("/records/2")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldReturn422StatusCodeIfIdsDoNotMatch() throws Exception {
        Record inputRecord = new Record();
        inputRecord.setArtist("William Joel");
        inputRecord.setAlbum("The Stranger");
        inputRecord.setYear("1977");
        inputRecord.setId(2);

        String inputJson = mapper.writeValueAsString(inputRecord);

        mockMvc.perform(
                put("/records/5")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturn422StatusCodeIfRequestBodyIsInvalid() throws Exception {
        Record inputRecord = new Record();
        inputRecord.setArtist("William Joel");
        inputRecord.setAlbum("The Stranger");
        inputRecord.setId(2);

        String inputJson = mapper.writeValueAsString(inputRecord);

        mockMvc.perform(
                put("/records/2")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    // testing DELETE /records/{id}
    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        mockMvc.perform(delete("/records/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

}
