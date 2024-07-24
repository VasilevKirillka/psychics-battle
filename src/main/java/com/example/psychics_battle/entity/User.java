package com.example.psychics_battle.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {

    private List<Psychic> psychics;
    private List<Integer> userHiddenNumber;

    public User() {
        this.psychics = new ArrayList<>();
        this.userHiddenNumber = new ArrayList<>();
        psychics.add(new Psychic("Экстрасенс 1", 0));
        psychics.add(new Psychic("Экстрасенс 2", 0));
    }
}
