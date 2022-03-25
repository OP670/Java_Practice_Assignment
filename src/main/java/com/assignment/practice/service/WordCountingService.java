package com.assignment.practice.service;

import com.assignment.practice.model.ResponseObject;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.io.File;
import java.util.Locale;
import java.util.Scanner;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WordCountingService {
    //private final String configPath = "config.txt";
    private String config = "";
    private ArrayList<String> data = new ArrayList<>();

    public WordCountingService(){
        try {
            File myObj = new File("config.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                this.config += myReader.nextLine();
            }

            myReader.close();
            Pattern pattern = Pattern.compile("^readFrom:.+;$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(config);
            boolean matchFound = matcher.find();
            if(matchFound) {
                String textPath = matcher.group(0);
                textPath = textPath.substring(9,textPath.length()-1);
                myObj = new File(textPath);
                myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    this.data.add(myReader.nextLine());
                }

                myReader.close();
            } else {
                System.out.println("Can't find text file path in configuration file...");
            }

        } catch (IOException e){
            System.out.println(e);
        }
    }

    public ResponseObject countWord(String word){
        ResponseObject response = new ResponseObject();
        response.setWord(word);
        word = word.toLowerCase(Locale.ROOT);
        for (String line : data){
            String temp = line.toLowerCase(Locale.ROOT);
            /*int count = temp.split(word).length-1;*/
            int lastIndex = 0;
            int count = 0;
            while (lastIndex != -1) {
                lastIndex = temp.indexOf(word, lastIndex);
                if (lastIndex != -1) {
                    count++;
                    lastIndex += word.length();
                }
            }

            //System.out.println(count);
            if (count != 0) response.addSentenceCountObject(line, count);
        }
        if (response.getSentences() != null) response.orderSentences();
        return response;
    }
}
