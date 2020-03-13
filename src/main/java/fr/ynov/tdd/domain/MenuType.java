package fr.ynov.tdd.domain;

import java.util.ArrayList;
import java.util.Arrays;

public enum MenuType {
    START_APP_MENU("START", new ArrayList<>(Arrays.asList("Jouer", "Options", "Quitter"))),
    OPTION_MENU(" OPTION", new ArrayList<>(Arrays.asList("Difficulté", "Language", "Credit","Retour"))),
    CHOOSE_CATEGORY_MENU("CATEGORIE", new ArrayList<>(Arrays.asList("Annimaux","Personne"))),
    CHOOSE_DIFICULTY_MENU("DIFICULTE", new ArrayList<>(Arrays.asList("Facile","Dificile"))),
    CHOOSE_LANGUAGE_MENU("LANGUE", new ArrayList<>(Arrays.asList("Français","Bèlge","Quebequois")));

    private String menuType;
    private ArrayList<String> options;

    MenuType(String menuType, ArrayList<String> options) {
        this.menuType = menuType;
        this.options = options;
    }

    public String getMenuType() {
        return menuType;
    }

    public ArrayList<String> getOptions() {
        return options;
    }
    public String parseMenu (){
        return "";
    }

}