package fr.ynov.tdd.utils;

import fr.ynov.tdd.domain.HandManState;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleUI {

    public static String showUI(String wordName, HandManState handManState, int currentAttempt, int maxAttempt, ArrayList<Character> lettersAlreadyTried) {
        String ui = handManState.getAsciiArt();

        int lenghtWord =  wordName.replace(" ", "").toCharArray().length;
        String letters = lettersAlreadyTried.stream().map(String::valueOf).collect(Collectors.joining(","));

        StringBuilder hiddenWord = new StringBuilder();
        IntStream.range(0, lenghtWord).mapToObj(i -> "_ ").forEachOrdered(hiddenWord::append);

        return MessageFormat.format(ui, currentAttempt, maxAttempt, hiddenWord, letters);
    }

    public static void printUIInConsole(String ui) {
        //System.out.println(ui);
    }

}
