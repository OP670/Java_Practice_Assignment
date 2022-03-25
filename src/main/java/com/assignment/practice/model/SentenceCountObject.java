package com.assignment.practice.model;

public class SentenceCountObject implements Comparable<SentenceCountObject>{
    private String sentence;
    private int count;

    public SentenceCountObject(String sentence, int count) {
        this.count = count;
        this.sentence = sentence;
    }

    public String getSentence(){
        return this.sentence;
    }

    public int getCount(){
        return this.count;
    }

    @Override
    public int compareTo(SentenceCountObject sco){;
        if (this.count != sco.getCount()) {
            return sco.getCount() - this.count;
        } else {
            return this.sentence.compareTo(sco.getSentence());
        }
    }
}
