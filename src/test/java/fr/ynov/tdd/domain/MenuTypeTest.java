package fr.ynov.tdd.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuTypeTest {

    @Test
    void should_parsing_menu_with_option() {
        // given
        String excepted = "### MENU START ###\n1 - Jouer\n2 - Options\n3 - Quitter\nQuel est votre choix ?\n";

        // when
        String parsing = MenuType.START_APP_MENU.parseMenu();

        // then
        assertEquals(excepted, parsing);
    }
}