package com.battleship;

public class Bridge {
    public void PlayerChooseShip(int howManyMasted, Logic logic, String[][] array)
    {
        logic.SetLockAroundPlace(array);
        VariableContainer.FIRST_PLACED = false;
        VariableContainer.HOW_MANY_LEFT_TO_PLACE = howManyMasted;
    }

    public boolean PlayerClickButtonInBoard(Logic logic, String[][] array, int column, int row, Player player) {
        System.out.println(VariableContainer.HOW_MANY_LEFT_TO_PLACE);
        if (VariableContainer.HOW_MANY_LEFT_TO_PLACE > 0) {
            if (VariableContainer.FIRST_PLACED) {
                if (array[row][column].equals(VariableContainer.UNLOCK)) {
                    VariableContainer.LASTPLACE.x = row;
                    VariableContainer.LASTPLACE.y = column;
                    logic.SetStatus(array, VariableContainer.PLACE, column, row);
                    logic.SetUnlockPlace(array);
                    VariableContainer.HOW_MANY_LEFT_TO_PLACE = VariableContainer.HOW_MANY_LEFT_TO_PLACE - 1;
                    player.setNumberBoxesLeft(player.getNumberBoxesLeft() - 1);
                    if(VariableContainer.HOW_MANY_LEFT_TO_PLACE == 0)
                    {
                        logic.SetLockAroundPlace(array);
                    }
                    return true;
                }
            } else {
                if (array[row][column].equals(VariableContainer.EMPTY) || array[row][column].equals(VariableContainer.UNLOCK)) {
                    VariableContainer.LASTPLACE.x = row;
                    VariableContainer.LASTPLACE.y = column;
                    logic.SetStatus(array, VariableContainer.PLACE, column, row);
                    logic.SetUnlockAroundFirstPlace(array);
                    VariableContainer.HOW_MANY_LEFT_TO_PLACE = VariableContainer.HOW_MANY_LEFT_TO_PLACE - 1;
                    VariableContainer.FIRST_PLACED = true;
                    player.setNumberBoxesLeft(player.getNumberBoxesLeft() - 1);
                    if(VariableContainer.HOW_MANY_LEFT_TO_PLACE == 0)
                    {
                        logic.SetLockAroundPlace(array);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void PlayerShotInBoard(Logic logic, String[][] array, int column, int row)
    {
        if (array[row][column].equals(VariableContainer.PLACE)) {
            logic.SetStatus(array, VariableContainer.HIT, column, row);
            logic.HitSink(array);
        }else{
            logic.SetStatus(array, VariableContainer.MISS, column, row);
        }
    }
}
