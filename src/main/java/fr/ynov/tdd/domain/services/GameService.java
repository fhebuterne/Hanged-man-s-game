package fr.ynov.tdd.domain.services;

import fr.ynov.tdd.domain.HandManState;
import fr.ynov.tdd.utils.ConsoleUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class GameService {

    private int currentAttempt = 0;
    private int maxAttempt = 6;
    private ArrayList<Character> lettersAlreadyTried = new ArrayList<>();
    private String word;
    private boolean endGame = false;
    private HandManState handManState = HandManState.HAND_MAN_STATE_0;

    public GameService(ArrayList<String> words) {
        this.word = words.get(new Random().nextInt(words.size())).replace(" ", "");
        this.word = this.word.toUpperCase();
    }

    public String startGame(Scanner scanner) {
        int lenghtWord = word.toCharArray().length;

        System.out.println("--------------{ JEU DU PENDU }--------------");
        while (!endGame) {
            String hiddenWord = this.revealeHiddenWord();
            String gameUi = new ConsoleUI().showGameUi(hiddenWord, handManState, currentAttempt, maxAttempt, lettersAlreadyTried);
            System.out.println(gameUi);
            checkInputUser(scanner);
            endGame = gameIsFinish(lenghtWord);
        }

        if (currentAttempt == maxAttempt) {
            return word.toLowerCase();
        }

        return word;
    }

    private void checkInputUser(Scanner scanner) {
        System.out.println("Merci d'entrer une lettre ...");
        if (scanner.hasNext() && !endGame) {
            Character character = scanner.nextLine().toUpperCase().charAt(0);
            if (isAnError(character)) {
                currentAttempt++;
                handManState = HandManState.valueOf("HAND_MAN_STATE_" + currentAttempt);
            }
            lettersAlreadyTried.add(character);
        }
    }

    private boolean isAnError(Character character) {
        String[] splitedWord = word.split("");
        return Arrays.stream(splitedWord)
                .noneMatch(s -> s.contains(character.toString()));
    }

    private String revealeHiddenWord() {
        int lenghtWord = word.toCharArray().length;

        StringBuilder hiddenWord = new StringBuilder();
        range(0, lenghtWord).mapToObj(i -> {
            if (lettersAlreadyTried.contains(word.charAt(i))) {
                return word.charAt(i) + " ";
            }

            return "_ ";
        }).forEachOrdered(hiddenWord::append);

        return hiddenWord.toString();
    }

    private boolean gameIsFinish(int lenghtWord) {
        boolean finishGame = IntStream.range(0, lenghtWord)
                .allMatch(i -> lettersAlreadyTried.contains(word.replace(" ", "").charAt(i)));
        return finishGame || currentAttempt == maxAttempt;
    }


}
