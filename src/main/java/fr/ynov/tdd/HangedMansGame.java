package fr.ynov.tdd;

import fr.ynov.tdd.domain.MenuType;

import java.util.Scanner;

import fr.ynov.tdd.domain.services.GameService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HangedMansGame {

    public static void main(String[] args) {
        boolean isReady = false;
        String categorie = null;
        String dificulty = "Facile";
        String language = "Français";
        while (!isReady) {
            Scanner sc = new Scanner(System.in);
            System.out.println(MenuType.START_APP_MENU.parseMenu());
            int choixMain = sc.nextInt();
            while (choixMain > MenuType.START_APP_MENU.getOptions().size() || choixMain < 1) {
                sc = new Scanner(System.in);
                System.out.println(MenuType.START_APP_MENU.parseMenu());
                choixMain = sc.nextInt();
            }
            switch (choixMain) {
                case 1:
                    int choixCategory = -1;
                    while (choixCategory > MenuType.CHOOSE_CATEGORY_MENU.getOptions().size() || choixCategory < 1) {
                        sc = new Scanner(System.in);
                        System.out.println(MenuType.CHOOSE_CATEGORY_MENU.parseMenu());
                        choixCategory = sc.nextInt();
                    }
                    categorie = MenuType.CHOOSE_CATEGORY_MENU.getOptions().get(choixCategory - 1);
                    isReady = true;
                    break;
                case 2:
                    int choixOption = -1;
                    while (choixOption > MenuType.OPTION_MENU.getOptions().size() || choixOption < 1) {
                        sc = new Scanner(System.in);
                        System.out.println(MenuType.OPTION_MENU.parseMenu());
                        choixOption = sc.nextInt();
                    }
                    switch (choixOption) {
                        case 1:
                            int choixDificulty = -1;
                            while (choixDificulty > MenuType.CHOOSE_DIFICULTY_MENU.getOptions().size() || choixDificulty < 1) {
                                sc = new Scanner(System.in);
                                System.out.println(MenuType.CHOOSE_DIFICULTY_MENU.parseMenu());
                                choixDificulty = sc.nextInt();
                                dificulty = MenuType.CHOOSE_DIFICULTY_MENU.getOptions().get(choixDificulty - 1);
                            }
                            break;
                        case 2:
                            int choixLanguage = -1;
                            while (choixLanguage > MenuType.CHOOSE_LANGUAGE_MENU.getOptions().size() || choixLanguage < 1) {
                                sc = new Scanner(System.in);
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
                    System.out.println("GAME OVER !");
                    System.exit(0);
                    break;
            }
        }
        System.out.println(categorie + "   " + dificulty + "    " + language);

        String game = new GameService(new ArrayList<>(Arrays.asList("ACDC", "BABAB"))).startGame(new Scanner(System.in));
        if (game.equals("")) {
            System.out.println("LOOOOSSERRR");
        } else {
            System.out.println("Bravo vous avez trouvé le mot " + game);
        }
    }
}
