package com.example.psychics_battle.service;

import com.example.psychics_battle.entity.Psychic;
import com.example.psychics_battle.entity.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Service
@Slf4j
public class MainServiceImpl implements MainService {


    public String index(HttpSession session, Model model) {
        User userSession = (User) session.getAttribute("user");
        if (userSession == null) {
            userSession = new User();
            session.setAttribute("user", userSession);
        }
        String sessionId = session.getId();
        model.addAttribute("userHiddenNumber", userSession.getUserHiddenNumber());
        model.addAttribute("psychics", userSession.getPsychics());
        model.addAttribute("sessionId", sessionId);

        log.info("Переход на главную страницу пользователя с ID {}", sessionId);

        return "index";
    }

    public String guess(int userHiddenNumber, HttpSession session) {
        User userSession = (User) session.getAttribute("user");
        addUserHiddenNumber(userHiddenNumber, userSession);
        updatePsychicsGuess(userHiddenNumber, userSession);

        log.info("Ввод пользователем с ID {} загаданного числа {}", session.getId(), userHiddenNumber);
        log.info("Вывод данных о догадках экстрасенсов {}", userSession.getPsychics());
        return "redirect:/";
    }

    private void addPsychicsGuess(int guess, boolean isCorrect, Psychic psychic) {
        psychic.getGuessNumber().add(guess);
        int rating = psychic.getRating();
        if (isCorrect) {
            rating++;
            int psyRating = rating;
            psychic.setRating(psyRating);
        } else {
            rating--;
            int psyRating = rating;
            psychic.setRating(psyRating);
        }
    }


    private void addUserHiddenNumber(int number, User user) {
        user.getUserHiddenNumber().add(number);
    }

    private void updatePsychicsGuess(int userHiddenNumber, User user) {
        for (Psychic psychic : user.getPsychics()) {
            int psychicGuessNumber = (int) (Math.random() * 90 + 10);
            addPsychicsGuess(psychicGuessNumber, psychicGuessNumber == userHiddenNumber, psychic);
        }
    }
}
