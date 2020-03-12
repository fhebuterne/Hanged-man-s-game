package fr.ynov.tdd.utils;

import fr.ynov.tdd.domain.HandManState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleUITest {

    @Test
    void should_print_ui_with_information() {
        // given
        String wordName = "TESTWORD";
        HandManState stateHandMan = HandManState.HAND_MAN_STATE_0;
        int currentAttempt = 0;
        int maxAttempt = 6;

        String expected =
                        "#################################################################################\n" +
                        "                       #                          #                              \n" +
                        " ,=============Y====== #                          # Tentatives 0/6               \n" +
                        "    ||  /      |       # Mot à trouver:           #                              \n" +
                        "    || /       |       #                          ###############################\n" +
                        "    ||/                #                                                         \n" +
                        "    ||                 #                                                         \n" +
                        "    ||                 # _ _ _ _ _ _ _                                           \n" +
                        "    ||                 #                                                         \n" +
                        "   /||                 ##########################################################\n" +
                        "  //||                 # Lettres déjà tentées:                                   \n" +
                        " ===================== #                                                         \n" +
                        "                       #                                                         \n" +
                        "#################################################################################\n";

        // when
        String ui = ConsoleUI.showUI(wordName, stateHandMan, currentAttempt, maxAttempt);

        // then
        assertEquals(expected, ui);
    }

}