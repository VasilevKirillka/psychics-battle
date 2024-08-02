package com.example.psychics_battle.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class Psychic {
    private String name;
    private int rating;
    private List<Integer> guessNumber;
    private String correctGuess;

    public Psychic(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.guessNumber = new ArrayList<>();
    }

    public void updatePsychicsGuess(int userHiddenNumber) {
        int psychicGuessNumber = (int) (Math.random() * 31 + 10); //todo поставил меньше диапазон от 10 до 40 включительно, чтоб чаще были совпадения
        addPsychicsGuess(psychicGuessNumber, psychicGuessNumber == userHiddenNumber);
    }

    private void addPsychicsGuess(int guess, boolean isCorrect) {
        guessNumber.add(guess);
        if (isCorrect) {
            rating++;
            correctGuess = "Догадка верна";
        } else {
            rating--;
            correctGuess = null;
        }
    }
}
