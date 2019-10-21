package com.company.U1M4SummativeMarkewiczMatthew.controller;

import com.company.U1M4SummativeMarkewiczMatthew.models.Answer;
import com.company.U1M4SummativeMarkewiczMatthew.models.Quote;
import com.company.U1M4SummativeMarkewiczMatthew.models.Word;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummativeController {

    // initialize objects
    Quote quoteOne = new Quote("Baron Harkonnen", "The Spice must flow!");
    Quote quoteTwo = new Quote("Paul Atreides", "He who can destroy a thing, controls a thing.");
    Quote quoteThree = new Quote("Duke Leto Atreides", "Here I am, here I remain!");
    Quote quoteFour = new Quote("Gurney Halleck", "The slow blade penetrates the shield.");
    Quote quoteFive = new Quote("Piter De Vries", "It is by will alone I set my mind in motion.");
    Quote quoteSix = new Quote("Reverend Mother", "The willow submits to the wind and prospers until one day it is many willows-a wall against the wind. This is the willow's purpose.");
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

    Answer answerOne = new Answer();
    Answer answerTwo = new Answer();
    Answer answerThree = new Answer();
    Answer answerFour = new Answer();
    Answer answerFive = new Answer();
    Answer answerSix = new Answer();

}
