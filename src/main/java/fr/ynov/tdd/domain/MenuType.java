package fr.ynov.tdd.domain;

import java.util.ArrayList;
import java.util.Arrays;

public enum MenuType {
    START_APP_MENU("START", new ArrayList<>(Arrays.asList("Jouer", "Options", "Quitter"))),
    OPTION_MENU(" OPTION", new ArrayList<>(Arrays.asList("Ajouter une catégorie", "Difficulté", "Language", "Credit", "Retour"))),
    CHOOSE_CATEGORY_MENU("CATEGORIE", new ArrayList<>(Arrays.asList("Animaux", "Personne"))),
    CHOOSE_DIFFICULTY_MENU("DIFFICULTE", new ArrayList<>(Arrays.asList("Facile", "Difficile"))),
    CHOOSE_LANGUAGE_MENU("LANGUE", new ArrayList<>(Arrays.asList("Français", "Bèlge", "Québécois")));

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

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public String parseMenu() {
        StringBuilder str;
        str = new StringBuilder("### MENU " + this.menuType + " ###\n");
        for (String item : this.options) {
            str.append(this.options.indexOf(item) + 1).append(" - ").append(item).append("\n");
        }
        str.append("Quel est votre choix ?\n");
        return str.toString();
    }
}