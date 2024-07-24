package com.example.psychics_battle.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

public interface MainService {

    String index(HttpSession session, Model model);

    String guess(int userHiddenNumber, HttpSession session);
}
