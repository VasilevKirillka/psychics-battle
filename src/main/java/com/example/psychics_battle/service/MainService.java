package com.example.psychics_battle.service;

import com.example.psychics_battle.entity.Psychic;
import com.example.psychics_battle.entity.User;


import java.util.List;

public interface MainService {

    String index(User userSession, List<Psychic> psychicList, String id );

    String guess(User UserSession, List<Psychic> psychicList, int userHiddenNumber, String id);

    String logout(String id);
}
