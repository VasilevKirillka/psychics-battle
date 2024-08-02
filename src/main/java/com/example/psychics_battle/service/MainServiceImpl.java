package com.example.psychics_battle.service;

import com.example.psychics_battle.entity.Psychic;
import com.example.psychics_battle.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class MainServiceImpl implements MainService {

    @Override
    public String index(User userSession, List<Psychic> psychicList, String id) {
        log.info("Переход на главную страницу пользователя с ID {}", id);

        return "index";
    }

    @Override
    public String guess(User userSession, List<Psychic> psychics, int userHiddenNumber, String id) {
        userSession.addUserHiddenNumber(userHiddenNumber);
        psychics.forEach(psychic -> psychic.updatePsychicsGuess(userHiddenNumber));
        log.info("Ввод пользователем с ID {} загаданного числа {}", id, userHiddenNumber);
        log.info("Вывод данных о догадках экстрасенсов {}", psychics);

        return "redirect:/";
    }

    @Override
    public String logout(String id) {
        log.info("Текущая сессия: {}  завершена!", id);

        return "index";
    }
}
