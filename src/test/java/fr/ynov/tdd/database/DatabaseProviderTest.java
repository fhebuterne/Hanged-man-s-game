package fr.ynov.tdd.database;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseProviderTest {
    private static DatabaseProvider databaseProvider;

    @BeforeAll
    public static void set_up_database() {
        databaseProvider = new DatabaseProvider(true);
        databaseProvider.initDatabase();
    }

    @Test
    @Order(1)
    public void should_add_category() {
        String catName = "MMORPG";

        databaseProvider.addCategory(catName);
        assertEquals(2, databaseProvider.getCatIdByName(catName));
    }

    @Test
    @Order(2)
    public void should_add_word_in_a_category() {
        ArrayList<String> words = new ArrayList<>();
        words.add("Orianna");
        words.add("Lux");
        words.add("Garen");

        int catId = 2;

        databaseProvider.addCategory("MMORPG");
        databaseProvider.addWords(words, catId);
        assertEquals(3, databaseProvider.getWordsByCatId(2).size());
    }

    @Test
    @Order(3)
    public void should_add_word_without_category() {
        ArrayList<String> words = new ArrayList<>();
        words.add("Cinema");
        words.add("Patate");

        int catId = -1;

        databaseProvider.addWords(words, catId);
        assertEquals(2, databaseProvider.getWordsByCatId(catId).size());
    }
}
