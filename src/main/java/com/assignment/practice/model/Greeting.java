package com.assignment.practice.model;

public class Greeting {
    private String introText;

    public Greeting() {
        this.introText = "Hello World!<br/>Consider adding \"/count?word=word_you_want_counted\" to the URL<br/>";
        this.introText += "so that you can see how many times your word appears in each line of<br/>fileNameGoesHere";
    }

    public String getIntroText(){
        return this.introText;
    }
}
