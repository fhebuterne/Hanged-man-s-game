package fr.ynov.tdd.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTypeTest {

    @Test
    void parseMenu() {
        assertEquals("### MENU START ###\n1 - Jouer\n2 - Options\n3 - Quitter\nQuel est votre choix ?\n",MenuType.START_APP_MENU.parseMenu());
    }
}