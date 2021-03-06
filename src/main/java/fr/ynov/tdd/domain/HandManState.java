package fr.ynov.tdd.domain;

public enum HandManState {
    HAND_MAN_STATE_0(
            0,
            "#################################################################################\n" +
                    "                       #                          #                              \n" +
                    " ,=============Y====== #                          # Tentatives {0}/{1}\n" +
                    "    ||  /      |       # Mot à trouver:           #                              \n" +
                    "    || /       |       #                          ###############################\n" +
                    "    ||/                #                                                         \n" +
                    "    ||                 #                                                         \n" +
                    "    ||                 # {2}\n" +
                    "    ||                 #                                                         \n" +
                    "   /||                 ##########################################################\n" +
                    "  //||                 # Lettres déjà tentées: {3}\n" +
                    " ===================== #                                                         \n" +
                    "                       #                                                         \n" +
                    "#################################################################################\n"
    ),
    HAND_MAN_STATE_1(
            1,
            "#################################################################################\n" +
                    "                       #                          #                              \n" +
                    " ,=============Y====== #                          # Tentatives {0}/{1}\n" +
                    "    ||  /      |       # Mot à trouver:           #                              \n" +
                    "    || /       |       #                          ###############################\n" +
                    "    ||/        O       #                                                         \n" +
                    "    ||                 #                                                         \n" +
                    "    ||                 # {2}\n" +
                    "    ||                 #                                                         \n" +
                    "   /||                 ##########################################################\n" +
                    "  //||                 # Lettres déjà tentées: {3}\n" +
                    " ===================== #                                                         \n" +
                    "                       #                                                         \n" +
                    "#################################################################################\n"
    ),
    HAND_MAN_STATE_2(
            2,
            "#################################################################################\n" +
                    "                       #                          #                              \n" +
                    " ,=============Y====== #                          # Tentatives {0}/{1}\n" +
                    "    ||  /      |       # Mot à trouver:           #                              \n" +
                    "    || /       |       #                          ###############################\n" +
                    "    ||/        O       #                                                         \n" +
                    "    ||         |       #                                                         \n" +
                    "    ||                 # {2}\n" +
                    "    ||                 #                                                         \n" +
                    "   /||                 ##########################################################\n" +
                    "  //||                 # Lettres déjà tentées: {3}\n" +
                    " ===================== #                                                         \n" +
                    "                       #                                                         \n" +
                    "#################################################################################\n"
    ),
    HAND_MAN_STATE_3(
            3,
            "#################################################################################\n" +
                    "                       #                          #                              \n" +
                    " ,=============Y====== #                          # Tentatives {0}/{1}\n" +
                    "    ||  /      |       # Mot à trouver:           #                              \n" +
                    "    || /       |       #                          ###############################\n" +
                    "    ||/        O       #                                                         \n" +
                    "    ||        \\|       #                                                         \n" +
                    "    ||                 # {2}\n" +
                    "    ||                 #                                                         \n" +
                    "   /||                 ##########################################################\n" +
                    "  //||                 # Lettres déjà tentées: {3}\n" +
                    " ===================== #                                                         \n" +
                    "                       #                                                         \n" +
                    "#################################################################################\n"
    ),
    HAND_MAN_STATE_4(
            4,
            "#################################################################################\n" +
                    "                       #                          #                              \n" +
                    " ,=============Y====== #                          # Tentatives {0}/{1}\n" +
                    "    ||  /      |       # Mot à trouver:           #                              \n" +
                    "    || /       |       #                          ###############################\n" +
                    "    ||/        O       #                                                         \n" +
                    "    ||        \\|/      #                                                         \n" +
                    "    ||         |       # {2}\n" +
                    "    ||                 #                                                         \n" +
                    "   /||                 ##########################################################\n" +
                    "  //||                 # Lettres déjà tentées: {3}\n" +
                    " ===================== #                                                         \n" +
                    "                       #                                                         \n" +
                    "#################################################################################\n"
    ),
    HAND_MAN_STATE_5(
            5,
            "#################################################################################\n" +
                    "                       #                          #                              \n" +
                    " ,=============Y====== #                          # Tentatives {0}/{1}\n" +
                    "    ||  /      |       # Mot à trouver:           #                              \n" +
                    "    || /       |       #                          ###############################\n" +
                    "    ||/        O       #                                                         \n" +
                    "    ||        \\|/      #                                                         \n" +
                    "    ||         |       # {2}\n" +
                    "    ||         /       #                                                         \n" +
                    "   /||                 ##########################################################\n" +
                    "  //||                 # Lettres déjà tentées: {3}\n" +
                    " ===================== #                                                         \n" +
                    "                       #                                                         \n" +
                    "#################################################################################\n"
    ),
    HAND_MAN_STATE_6(
            6,
                    "#################################################################################\n" +
                    "                       #                          #                              \n" +
                    " ,=============Y====== #                          # Tentatives {0}/{1}\n" +
                    "    ||  /      |       # Mot à trouver:           #                              \n" +
                    "    || /       |       #                          ###############################\n" +
                    "    ||/        O       #                                                         \n" +
                    "    ||        \\|/     #                                                         \n" +
                    "    ||         |       # {2}\n" +
                    "    ||         /\\      #                                                         \n" +
                    "   /||                 ##########################################################\n" +
                    "  //||                 # Lettres déjà tentées: {3}\n" +
                    " ===================== #                                                         \n" +
                    "                       #                                                         \n" +
                    "#################################################################################\n"
    );

    private int state;
    private String asciiArt;

    HandManState(int state, String asciiArt) {
        this.state = state;
        this.asciiArt = asciiArt;
    }

    public int getState() {
        return state;
    }

    public String getAsciiArt() {
        return asciiArt;
    }
}
