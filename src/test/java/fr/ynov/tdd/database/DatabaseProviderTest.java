package fr.ynov.tdd.database;

import fr.ynov.tdd.domain.Statistic;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

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

    @Test
    @Order(4)
    public void should_add_stats_when_game_end() {
        ArrayList<Statistic> statistics = new ArrayList<>();
        statistics.add(new Statistic("Poney", 6, new Date()));
        statistics.add(new Statistic("Hamburger", 4, new Date()));
        statistics.add(new Statistic("Mistermv", 5, new Date()));

        for (Statistic statistic : statistics) {
            databaseProvider.addStatisticsAtEndGame(statistic);
        }

        assertEquals(3, databaseProvider.getAllStatistics().size());
    }
}
