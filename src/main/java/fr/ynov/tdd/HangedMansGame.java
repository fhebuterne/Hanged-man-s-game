package fr.ynov.tdd;

import fr.ynov.tdd.database.DatabaseProvider;
import fr.ynov.tdd.domain.MenuType;
import fr.ynov.tdd.domain.services.GameService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HangedMansGame {

    private static String language = "Français";
    private static String difficulty = "Facile";
    private static String categoryName = null;

    private static void addDefaultTable(DatabaseProvider databaseProvider) {
        if (databaseProvider.getAllCategories().size() == 1) {
            databaseProvider.addCategory("FILMS");
            databaseProvider.addCategory("ANIMAUX");
            databaseProvider.addCategory("LIEUX");

            databaseProvider.addWords(new ArrayList<>(Arrays.asList("AVATAR", "TERMINATOR", "INTOUCHABLES")), databaseProvider.getCatIdByName("FILMS"));
            databaseProvider.addWords(new ArrayList<>(Arrays.asList("CHIEN", "CHAT", "TORTUE")), databaseProvider.getCatIdByName("ANIMAUX"));
            databaseProvider.addWords(new ArrayList<>(Arrays.asList("BORDEAUX", "PARIS", "BREST")), databaseProvider.getCatIdByName("LIEUX"));
        }
    }

    public static void main(String[] args) {
        DatabaseProvider databaseProvider = new DatabaseProvider(false);
        databaseProvider.initDatabase();
        addDefaultTable(databaseProvider);

        Scanner sc = new Scanner(System.in);

        menuSelector(sc, databaseProvider);

        System.out.println(categoryName + " - " + difficulty + " - " + language);

        String game = new GameService(databaseProvider.getWordsByCatId(databaseProvider.getCatIdByName(categoryName))).startGame(new Scanner(System.in));
        if (game.equals("")) {
            System.out.println("LOOOOSSERRR");
        } else {
            System.out.println("Bravo vous avez trouvé le mot " + game);
        }
    }

    // TODO : Put in other class
    private static void menuSelector(Scanner sc, DatabaseProvider databaseProvider) {
        boolean isReady = false;
        int optionChoice = -1, difficultyChoice = -1, languageChoice = -1, categoryChoice = -1;

        while (!isReady) {
            int userChoice = menuAppFirstStart(sc);
            switch (userChoice) {
                case 1:
                    MenuType chooseCategoryMenu = MenuType.CHOOSE_CATEGORY_MENU;
                    putCategoryInMenu(databaseProvider, chooseCategoryMenu);
                    categoryChoice = checkInputScanner(sc, categoryChoice, chooseCategoryMenu);
                    categoryName = chooseCategoryMenu.getOptions().get(categoryChoice - 1);
                    isReady = true;
                    break;
                case 2:
                    optionChoice = checkInputScanner(sc, optionChoice, MenuType.OPTION_MENU);
                    switch (optionChoice) {
                        case 2:
                            difficultyChoice = checkInputScanner(sc, difficultyChoice, MenuType.CHOOSE_DIFFICULTY_MENU);
                            difficulty = MenuType.CHOOSE_DIFFICULTY_MENU.getOptions().get(difficultyChoice - 1);
                            break;
                        case 3:
                            languageChoice = checkInputScanner(sc, difficultyChoice, MenuType.CHOOSE_LANGUAGE_MENU);
                            language = MenuType.CHOOSE_LANGUAGE_MENU.getOptions().get(languageChoice - 1);
                            break;
                        case 4:
                            System.out.println(
                                    "#### CREDITS ####\n" +
                                    "Roquelaure Vincent\n" +
                                    "Hebuterne Fabien\n" +
                                    "Madaule Damien\n\n" +
                                    "IntelliJ IDEA");
                            break;
                        case 5:
                            menuSelector(sc, databaseProvider);
                            break;
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }

    private static int menuAppFirstStart(Scanner sc) {
        System.out.println(MenuType.START_APP_MENU.parseMenu());
        int userChoice = sc.nextInt();
        return checkInputScanner(sc, userChoice, MenuType.START_APP_MENU);
    }

    private static MenuType putCategoryInMenu(DatabaseProvider databaseProvider, MenuType categoryMenu) {
        ArrayList<String> allCategories = databaseProvider.getAllCategories();
        categoryMenu.setOptions(allCategories);
        return categoryMenu;
    }

    private static int checkInputScanner(Scanner sc, int choixCategory, MenuType chooseCategoryMenu) {
        while (choixCategory > chooseCategoryMenu.getOptions().size() || choixCategory < 1) {
            System.out.println(chooseCategoryMenu.parseMenu());
            try {
                choixCategory = sc.nextInt();
            } catch (InputMismatchException e) {
                choixCategory = 1;
            }
        }
        return choixCategory;
    }


}
