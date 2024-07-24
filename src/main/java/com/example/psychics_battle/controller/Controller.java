package com.example.psychics_battle.controller;

import com.example.psychics_battle.service.MainServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
@RequestMapping()
@RequiredArgsConstructor
public class Controller {

    private final MainServiceImpl mainServiceImpl;


    @GetMapping("/")
    public String getIndexPage(HttpSession session, Model model) {
        return mainServiceImpl.index(session, model);
    }

    @PostMapping("/submit")
    public String addGuessNumber(int userHiddenNumber, HttpSession session) {
        return mainServiceImpl.guess(userHiddenNumber, session);
    }

}
