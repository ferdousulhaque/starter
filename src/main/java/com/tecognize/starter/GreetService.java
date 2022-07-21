package com.tecognize.starter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GreetService {

    private String[] greetings = {
            "Welcome buddy",
            "Swadekha",
            "Mingalabar"
    };

    public String greet(){
        Random rand = new Random();
        int randKey = rand.nextInt(greetings.length);
        return greetings[randKey];
    }
}
