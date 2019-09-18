package com.battleship;

import javafx.scene.control.Button;

import java.util.ArrayList;

public class Bridge {
    public void PlayerChooseShip(int howManyMasted, Ship ship, String[][] array)
    {
        ship.SetLockAroundPlace(array);
        VariableContainer.FIRST_PLACED = false;
        VariableContainer.HOW_MANY_LEFT_TO_PLACE = howManyMasted;
    }

    public boolean PlayerClickButtonInBoard(Ship ship, String[][] array, int column, int row) {
        System.out.println(VariableContainer.HOW_MANY_LEFT_TO_PLACE);
        if (VariableContainer.HOW_MANY_LEFT_TO_PLACE > 0) {
            if (VariableContainer.FIRST_PLACED) {
                if (array[row][column].equals(VariableContainer.UNLOCK)) {
                    VariableContainer.LASTPLACE.x = row;
                    VariableContainer.LASTPLACE.y = column;
                    ship.SetStatus(array, VariableContainer.PLACE, column, row);
                    ship.SetUnlockPlace(array);
                    VariableContainer.HOW_MANY_LEFT_TO_PLACE = VariableContainer.HOW_MANY_LEFT_TO_PLACE - 1;
                    if(VariableContainer.HOW_MANY_LEFT_TO_PLACE == 0)
                    {
                        ship.SetLockAroundPlace(array);
                    }
                    return true;
                }
            } else {
                if (array[row][column].equals(VariableContainer.EMPTY) || array[row][column].equals(VariableContainer.UNLOCK)) {
                    VariableContainer.LASTPLACE.x = row;
                    VariableContainer.LASTPLACE.y = column;
                    ship.SetStatus(array, VariableContainer.PLACE, column, row);
                    ship.SetUnlockAroundFirstPlace(array);
                    VariableContainer.HOW_MANY_LEFT_TO_PLACE = VariableContainer.HOW_MANY_LEFT_TO_PLACE - 1;
                    VariableContainer.FIRST_PLACED = true;
                    if(VariableContainer.HOW_MANY_LEFT_TO_PLACE == 0)
                    {
                        ship.SetLockAroundPlace(array);
                    }
                }
                return true;
            }
        }
        return false;
    }



}
