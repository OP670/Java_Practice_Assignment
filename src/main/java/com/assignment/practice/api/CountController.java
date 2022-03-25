package com.assignment.practice.api;

import com.assignment.practice.model.Greeting;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.assignment.practice.model.ResponseObject;
import com.assignment.practice.service.WordCountingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountController {
    private WordCountingService wordCountingService;

    public CountController(WordCountingService wordCountingService){
        this.wordCountingService = wordCountingService;
    }

    @GetMapping("/")
    public String greet() {
        String introText = "Hello World!<br/>Consider adding \"/count?word=word_you_want_counted\" to the URL<br/>";
        introText += "so that you can see how many times your word appears in each line of<br/>fileNameGoesHere";
        return introText;
    }

    @GetMapping("/count")
    public String querryResponse(@RequestParam(value="word") String word) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        ResponseObject response = wordCountingService.countWord(word);
        return mapper.writeValueAsString(response);
    }
}
