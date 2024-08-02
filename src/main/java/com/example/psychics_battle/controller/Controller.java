package com.example.psychics_battle.controller;

import com.example.psychics_battle.entity.Psychic;
import com.example.psychics_battle.entity.User;
import com.example.psychics_battle.service.MainServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping()
@RequiredArgsConstructor
@Slf4j
public class Controller {

    private final MainServiceImpl mainServiceImpl;

    @GetMapping("/")
    public String getIndexPage(HttpSession session, Model model) {
        User userSession = getUserFromSession(session);
        List <Psychic> psySession = getPsychicSession(session);
        String sessionId = session.getId();
        model.addAttribute("userHiddenNumber", userSession.getUserHiddenNumber());
        model.addAttribute("psychics", psySession);
        model.addAttribute("sessionId", sessionId);

        return mainServiceImpl.index(userSession,  psySession, sessionId);
    }

    @PostMapping("/submit")
    public String addGuessNumber(int userHiddenNumber,  HttpSession session) {
        User userSession = getUserFromSession(session);
        List <Psychic> psySession = getPsychicSession(session);
        String sessionId = session.getId();

        return mainServiceImpl.guess(userSession, psySession, userHiddenNumber, sessionId);
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        String sessionId = session.getId();
        session.invalidate();
        return mainServiceImpl.logout(sessionId);
    }


    private User getUserFromSession(HttpSession session) {
        return session.getAttribute("user") != null ?
                (User) session.getAttribute("user") : createNewUserSession(session);
    }

    private User createNewUserSession(HttpSession session) {
        User newUser = new User();
        session.setAttribute("user", newUser);
        return newUser;
    }

    private List<Psychic> getPsychicSession(HttpSession session) {
        List<Psychic> psychicsList = (List<Psychic>) session.getAttribute("psychics");
        if (psychicsList == null) {
            psychicsList = new ArrayList<>();
            session.setAttribute("psychics", psychicsList);
            psychicsList.add(new Psychic("Экстрасенс 1", 0));
            psychicsList.add(new Psychic("Экстрасенс 2", 0));
            psychicsList.add(new Psychic("Экстрасенс 3", 0));
            psychicsList.add(new Psychic("Экстрасенс 4", 0));
            psychicsList.add(new Psychic("Экстрасенс 5", 0));
            psychicsList.add(new Psychic("Экстрасенс 6", 0));
            psychicsList.add(new Psychic("Экстрасенс 7", 0));
            psychicsList.add(new Psychic("Экстрасенс 8", 0));
            psychicsList.add(new Psychic("Экстрасенс 9", 0));
            psychicsList.add(new Psychic("Экстрасенс 10", 0));
        }
        return psychicsList;
    }

}
