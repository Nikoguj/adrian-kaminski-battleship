package com.battleship;

import com.sun.javafx.geom.Vec2d;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class VariableContainer {
    public static String EMPTY = "EMPTY";
    public static String PLACE = "PLACE";
    public static String HIT = "HIT";
    public static String HITSINK = "HITSINK";
    public static String LOCK = "LOCK";
    public static String UNLOCK = "UNLOCK";
    public static String MISS = "MISS";

    public static String EMPTYCOLOUR = "-fx-background-color: #4acfff";
    public static String PLACECOLOUR = "-fx-background-color: #4d381f";
    public static String HITCOLOUR = "-fx-background-color: #f50016";
    public static String HITSINKCOLOUR = "-fx-background-color: #000000";
    public static String UNLOCKCOLOUR = "-fx-background-color: #8cff00";
    public static String LOCKCOLOUR = "-fx-background-color: #828282";
    public static String MISSCOLOUR = "-fx-background-color: #ffdd00";

    public static Vec2d LASTPLACE = new Vec2d(5, 5);

    public static int PLAYER1_FOUR_MASTED_SHIP = 1;
    public static int PLAYER1_THREE_MASTED_SHIP = 2;
    public static int PLAYER1_TWO_MASTED_SHIP = 3;
    public static int PLAYER1_ONE_MASTED_SHIP = 4;

    public static Label PLAYER1_FOUR_MASTED_SHIP_LABEL;
    public static Label PLAYER1_THREE_MASTED_SHIP_LABEL;
    public static Label PLAYER1_TWO_MASTED_SHIP_LABEL;
    public static Label PLAYER1_ONE_MASTED_SHIP_LABEL;


    public static int PLAYER2_FOUR_MASTED_SHIP = 1;
    public static int PLAYER2_THREE_MASTED_SHIP = 2;
    public static int PLAYER2_TWO_MASTED_SHIP = 3;
    public static int PLAYER2_ONE_MASTED_SHIP = 4;

    public static Label PLAYER2_FOUR_MASTED_SHIP_LABEL;
    public static Label PLAYER2_THREE_MASTED_SHIP_LABEL;
    public static Label PLAYER2_TWO_MASTED_SHIP_LABEL;
    public static Label PLAYER2_ONE_MASTED_SHIP_LABEL;

    public static int FOUR_MASTED = 4;
    public static int THREE_MASTED = 3;
    public static int TWO_MASTED = 2;
    public static int ONE_MASTED = 1;


    public static int HOW_MANY_LEFT_TO_PLACE = 0;
    public static boolean FIRST_PLACED = false;

    public static String[][] array = new String[10][10];
    public static Button[][] arrayButton = new Button[10][10];

    public static String[][] arrayPC = new String[10][10];
    public static Button[][] arrayButtonPC = new Button[10][10];

}
