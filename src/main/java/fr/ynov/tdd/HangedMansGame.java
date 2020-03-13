package fr.ynov.tdd;

import fr.ynov.tdd.database.DatabaseProvider;
import fr.ynov.tdd.domain.MenuType;
import fr.ynov.tdd.domain.services.GameService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HangedMansGame {

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

        boolean isReady = false;
        String categorie = null;
        String difficulty = "Facile";
        String language = "Français";
        Scanner sc = new Scanner(System.in);

        String categorySelected = "";

        while (!isReady) {
            System.out.println(MenuType.START_APP_MENU.parseMenu());
            int choiceUser = sc.nextInt();
            while (choiceUser > MenuType.START_APP_MENU.getOptions().size() || choiceUser < 1) {
                System.out.println(MenuType.START_APP_MENU.parseMenu());
                choiceUser = sc.nextInt();
            }
            switch (choiceUser) {
                case 1:
                    int choixCategory = -1;

                    ArrayList<String> allCategories = databaseProvider.getAllCategories();
                    MenuType chooseCategoryMenu = MenuType.CHOOSE_CATEGORY_MENU;
                    chooseCategoryMenu.setOptions(allCategories);

                    while (choixCategory > chooseCategoryMenu.getOptions().size() || choixCategory < 1) {
                        System.out.println(chooseCategoryMenu.parseMenu());
                        choixCategory = sc.nextInt();
                        categorySelected = chooseCategoryMenu.getOptions().get(choixCategory - 1);
                    }
                    categorie = chooseCategoryMenu.getOptions().get(choixCategory - 1);
                    isReady = true;
                    break;
                case 2:
                    int choixOption = -1;
                    while (choixOption > MenuType.OPTION_MENU.getOptions().size() || choixOption < 1) {
                        System.out.println(MenuType.OPTION_MENU.parseMenu());
                        choixOption = sc.nextInt();
                    }
                    switch (choixOption) {
                        case 1:
                            int choixDificulty = -1;
                            while (choixDificulty > MenuType.CHOOSE_DIFICULTY_MENU.getOptions().size() || choixDificulty < 1) {
                                System.out.println(MenuType.CHOOSE_DIFICULTY_MENU.parseMenu());
                                choixDificulty = sc.nextInt();
                                difficulty = MenuType.CHOOSE_DIFICULTY_MENU.getOptions().get(choixDificulty - 1);
                            }
                            break;
                        case 2:
                            int choixLanguage = -1;
                            while (choixLanguage > MenuType.CHOOSE_LANGUAGE_MENU.getOptions().size() || choixLanguage < 1) {
                                System.out.println(MenuType.CHOOSE_LANGUAGE_MENU.parseMenu());
                                choixLanguage = sc.nextInt();
                                language = MenuType.CHOOSE_LANGUAGE_MENU.getOptions().get(choixLanguage - 1);
                            }
                            break;
                        case 3:
                            System.out.println("#### CREDITS ####\n" +
                                    "Roquelaure Vincent\n" +
                                    "Hebuterne Fabien\n" +
                                    "Madaule Damien\n\n" +
                                    "IntelliJ IDEA");
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
        System.out.println(categorie + " - " + difficulty + " - " + language);

        String game = new GameService(databaseProvider.getWordsByCatId(databaseProvider.getCatIdByName(categorySelected))).startGame(new Scanner(System.in));
        if (game.equals("")) {
            System.out.println("LOOOOSSERRR");
        } else {
            System.out.println("Bravo vous avez trouvé le mot " + game);
        }
    }
}
