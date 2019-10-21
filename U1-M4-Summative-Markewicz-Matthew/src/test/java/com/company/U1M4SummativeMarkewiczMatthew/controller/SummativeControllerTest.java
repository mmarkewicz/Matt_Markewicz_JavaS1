package com.company.U1M4SummativeMarkewiczMatthew.controller;

import com.company.U1M4SummativeMarkewiczMatthew.model.*;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SummativeController.class)
public class SummativeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private List<Quote> quoteList =  new ArrayList<>();
    private List<Word> wordList = new ArrayList<>();
    private List<String> answerList = new ArrayList<>();
    private List<Answer> answerObjectList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        Quote quoteOne = new Quote("Baron Harkonnen", "The Spice must flow!");
        Quote quoteTwo = new Quote("Paul Atreides", "He who can destroy a thing, controls a thing.");
        Quote quoteThree = new Quote("Duke Leto Atreides", "Here I am, here I remain!");
        Quote quoteFour = new Quote("Gurney Halleck", "The slow blade penetrates the shield.");
        Quote quoteFive = new Quote("Piter De Vries", "It is by will alone I set my mind in motion.");
        Quote quoteSix = new Quote("Reverend Mother", "The willow submits to the wind and prospers until one day it is many willows - a wall against the wind. This is the willow's purpose.");
        Quote quoteSeven = new Quote("Bewt", "The action had taken, also, a knowledge of personal power. Water was, indeed, power here.");
        Quote quoteEight = new Quote("Baron Harkonnen", "The way to control a Mentat is through is information. False information - false results.");
        Quote quoteNine = new Quote("Baron Harkonnen", "Observe the plans within plans within plans.");
        Quote quoteTen = new Quote("Duke Leto Atreides", "Power and fear ... The tools of statecraft.");

        Word wordOne = new Word("pelter", "a thrower of missiles");
        Word wordTwo = new Word("concretize", "make something concrete");
        Word wordThree = new Word("canvass", "get opinions by asking specific questions");
        Word wordFour = new Word("lubberly", "clumsy and unskilled");
        Word wordFive = new Word("cordial", "politely warm and friendly");
        Word wordSix = new Word("jocular", "characterized by jokes and good humor");
        Word wordSeven = new Word("tamp", "press down tightly");
        Word wordEight = new Word("subnormality", "the state of being less than normal");
        Word wordNine = new Word("obbligato", "a part of the score that must be performed without change or omission");
        Word wordTen = new Word("satrap", "a governor of a province in ancient Persia");

        String answerOne = "My sources say no.";
        String answerTwo = "Very doubtful.";
        String answerThree = "It is certain.";
        String answerFour = "Cannot predict that now.";
        String answerFive = "Without a doubt.";
        String answerSix = "Reply hazy, try again.";

        quoteList.add(quoteOne);
        quoteList.add(quoteTwo);
        quoteList.add(quoteThree);
        quoteList.add(quoteFour);
        quoteList.add(quoteFive);
        quoteList.add(quoteSix);
        quoteList.add(quoteSeven);
        quoteList.add(quoteEight);
        quoteList.add(quoteNine);
        quoteList.add(quoteTen);

        wordList.add(wordOne);
        wordList.add(wordTwo);
        wordList.add(wordThree);
        wordList.add(wordFour);
        wordList.add(wordFive);
        wordList.add(wordSix);
        wordList.add(wordSeven);
        wordList.add(wordEight);
        wordList.add(wordNine);
        wordList.add(wordTen);

        answerList.add(answerOne);
        answerList.add(answerTwo);
        answerList.add(answerThree);
        answerList.add(answerFour);
        answerList.add(answerFive);
        answerList.add(answerSix);
    }

    @Test
    public void shouldReturnOneQuoteFromQuoteList() throws Exception {

        mockMvc.perform(get("/quote"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnOneWordFromWordList() throws Exception {

        mockMvc.perform(get("/word"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnAnAnswer() throws Exception {

        mockMvc.perform(post("/magic").content("Am I going to ask a question?").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
