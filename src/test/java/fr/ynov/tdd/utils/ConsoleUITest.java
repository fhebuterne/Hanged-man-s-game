package fr.ynov.tdd.utils;

import fr.ynov.tdd.domain.HandManState;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleUITest {

    @Test
    void should_print_ui_with_information_and_hidden_word() {
        // given
        String wordNameHidden = "_ _ _ _ _ _ _ _ ";
        HandManState stateHandMan = HandManState.HAND_MAN_STATE_0;
        int currentAttempt = 0;
        int maxAttempt = 6;
        ArrayList<Character> chars = new ArrayList<>(Arrays.asList('A', 'B', 'C'));

        String expected =
                        "#################################################################################\n" +
                        "                       #                          #                              \n" +
                        " ,=============Y====== #                          # Tentatives 0/6\n" +
                        "    ||  /      |       # Mot à trouver:           #                              \n" +
                        "    || /       |       #                          ###############################\n" +
                        "    ||/                #                                                         \n" +
                        "    ||                 #                                                         \n" +
                        "    ||                 # _ _ _ _ _ _ _ _ \n" +
                        "    ||                 #                                                         \n" +
                        "   /||                 ##########################################################\n" +
                        "  //||                 # Lettres déjà tentées: A,B,C\n" +
                        " ===================== #                                                         \n" +
                        "                       #                                                         \n" +
                        "#################################################################################\n";

        // when
        String ui = new ConsoleUI().showGameUi(wordNameHidden, stateHandMan, currentAttempt, maxAttempt, chars);

        // then
        assertEquals(expected, ui);
    }

}