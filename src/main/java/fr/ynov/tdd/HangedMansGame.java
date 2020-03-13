package fr.ynov.tdd;

import fr.ynov.tdd.domain.services.GameService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HangedMansGame {

    public static void main(String args[]) {
        String game = new GameService(new ArrayList<>(Arrays.asList("ACDC", "BABAB"))).startGame(new Scanner(System.in));
        if (game.equals("")) {
            System.out.println("LOOOOSSERRR");
        } else {
            System.out.println("Bravo vous avez trouvé le mot " + game);
        }
    }
}
