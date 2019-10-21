package com.company.U1M4SummativeMarkewiczMatthew.controller;

import com.company.U1M4SummativeMarkewiczMatthew.model.Answer;
import com.company.U1M4SummativeMarkewiczMatthew.model.Quote;
import com.company.U1M4SummativeMarkewiczMatthew.model.Word;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class SummativeController {

    private Random rand = new Random();

    private Quote quoteOne = new Quote("Baron Harkonnen", "The Spice must flow!");
    private Quote quoteTwo = new Quote("Paul Atreides", "He who can destroy a thing, controls a thing.");
    private Quote quoteThree = new Quote("Duke Leto Atreides", "Here I am, here I remain!");
    private Quote quoteFour = new Quote("Gurney Halleck", "The slow blade penetrates the shield.");
    private Quote quoteFive = new Quote("Piter De Vries", "It is by will alone I set my mind in motion.");
    private Quote quoteSix = new Quote("Reverend Mother", "The willow submits to the wind and prospers until one day it is many willows - a wall against the wind. This is the willow's purpose.");
    private Quote quoteSeven = new Quote("Bewt", "The action had taken, also, a knowledge of personal power. Water was, indeed, power here.");
    private Quote quoteEight = new Quote("Baron Harkonnen", "The way to control a Mentat is through is information. False information - false results.");
    private Quote quoteNine = new Quote("Baron Harkonnen", "Observe the plans within plans within plans.");
    private Quote quoteTen = new Quote("Duke Leto Atreides", "Power and fear ... The tools of statecraft.");

    private Word wordOne = new Word("pelter", "a thrower of missiles");
    private Word wordTwo = new Word("concretize", "make something concrete");
    private Word wordThree = new Word("canvass", "get opinions by asking specific questions");
    private Word wordFour = new Word("lubberly", "clumsy and unskilled");
    private Word wordFive = new Word("cordial", "politely warm and friendly");
    private Word wordSix = new Word("jocular", "characterized by jokes and good humor");
    private Word wordSeven = new Word("tamp", "press down tightly");
    private Word wordEight = new Word("subnormality", "the state of being less than normal");
    private Word wordNine = new Word("obbligato", "a part of the score that must be performed without change or omission");
    private Word wordTen = new Word("satrap", "a governor of a province in ancient Persia");

    private String answerOne = "My sources say no.";
    private String answerTwo = "Very doubtful.";
    private String answerThree = "It is certain.";
    private String answerFour = "Cannot predict that now.";
    private String answerFive = "Without a doubt.";
    private String answerSix = "Reply hazy, try again.";

    private List<Quote> quoteList = new ArrayList<>();
    private List<Word> wordList = new ArrayList<>();
    private List<String> answerList = new ArrayList<>();
    private List<Answer> answerObjectList = new ArrayList<>();

    public SummativeController() {
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

    @RequestMapping(path = "/quote", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Quote getRandomQuote() {
        int randomInt = rand.nextInt(10);
        return quoteList.get(randomInt);
    }

    @RequestMapping(path = "/word", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Word getRandomWord() {
        int randomInt = rand.nextInt(10);
        return wordList.get(randomInt);
    }

    @RequestMapping(path = "/magic", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String getRandomAnswer(@RequestBody String question) {
        int randomInt = rand.nextInt(6);
        String randomAns = answerList.get(randomInt);
        Answer answerToBePosted = new Answer(question, randomAns);
        answerObjectList.add(answerToBePosted);
        return randomAns;
    }

}
