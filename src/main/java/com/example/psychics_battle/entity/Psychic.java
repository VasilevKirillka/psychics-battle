package com.example.psychics_battle.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class Psychic {
    private String name;
    private int rating;
    private List<Integer> guessNumber;

    public Psychic(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.guessNumber = new ArrayList<>();
    }

}
