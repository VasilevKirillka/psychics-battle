package com.example.psychics_battle.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    private List<Integer> userHiddenNumber;

    public User() {
        this.userHiddenNumber = new ArrayList<>();
    }

    public void addUserHiddenNumber(int number) {
        userHiddenNumber.add(number);
    }
}
