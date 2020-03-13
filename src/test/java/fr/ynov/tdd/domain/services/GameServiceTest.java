package fr.ynov.tdd.domain.services;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameServiceTest {

    @Test
    void should_start_game_and_find_hidden_word() {
        // given
        String wordNameExcepted = "ABC";
        ArrayList<String> words = new ArrayList<>(Collections.singletonList(wordNameExcepted));
        String initialString = "A\nB\nC\n";
        System.setIn(new ByteArrayInputStream(initialString.getBytes()));
        Scanner scanner = new Scanner(System.in);

        // when
        String wordResult = new GameService(words).startGame(scanner);

        // then
        assertEquals(wordNameExcepted, wordResult);
    }

    @Test
    void should_start_game_and_do_not_find_hidden_word_and_return_nothing() {
        // given
        String wordNameExcepted = "ABC";
        ArrayList<String> words = new ArrayList<>(Collections.singletonList(wordNameExcepted));
        String initialString = "c\nQ\nd\nm\np\nj\nl\n";
        System.setIn(new ByteArrayInputStream(initialString.getBytes()));
        Scanner scanner = new Scanner(System.in);

        // when
        String wordResult = new GameService(words).startGame(scanner);

        // then
        assertEquals("", wordResult);
    }

}