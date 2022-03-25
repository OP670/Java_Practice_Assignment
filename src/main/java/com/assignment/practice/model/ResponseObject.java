package com.assignment.practice.model;

import java.util.ArrayList;
import java.util.Collections;

public class ResponseObject {
    private String word;
    private ArrayList<SentenceCountObject> sentences = new ArrayList<SentenceCountObject>();

    public String getWord(){
        return this.word;
    }

    public ArrayList<SentenceCountObject> getSentences(){
        return this.sentences;
    }

    public void setWord(String word){
        this.word = word;
    }

    public ArrayList<SentenceCountObject> addSentenceCountObject(String line, int count){
        this.sentences.add(new SentenceCountObject(line,count));
        return sentences;
    }

    public ArrayList<SentenceCountObject> orderSentences() {
        Collections.sort(this.sentences);
        return sentences;
    }
}
