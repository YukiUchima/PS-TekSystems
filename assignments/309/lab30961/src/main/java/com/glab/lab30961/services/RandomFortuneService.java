package com.glab.lab30961.services;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component("randomFortune")
public class RandomFortuneService implements IFortuneServices{
    private String[] data = {
            "Beware of the wolf in sheep's clothing",
            "Diligence is the mother of good luck",
            "The journey is the reward"
    };

    private Random randNum = new Random();
    @Override
    public String getFortune() {
        int index = randNum.nextInt(data.length);
        return data[index];
    }
}
