package fr.ynov.tdd.utils;

import fr.ynov.tdd.domain.HandManState;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ConsoleUI {

    public String showGameUi(String wordName,
                             HandManState handManState,
                             int currentAttempt,
                             int maxAttempt,
                             ArrayList<Character> lettersAlreadyTried) {
        String ui = handManState.getAsciiArt();

        String lettersJoining = lettersAlreadyTried.stream().map(String::valueOf).collect(Collectors.joining(","));

        return MessageFormat.format(ui, currentAttempt, maxAttempt, wordName, lettersJoining);
    }

}
