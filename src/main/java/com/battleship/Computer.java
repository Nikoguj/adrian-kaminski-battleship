package com.battleship;

import java.util.Random;

public class Computer {
    public void FillComputerArray() {
        for (int i = 0; i < VariableContainer.arrayPC.length; i++) {
            for (int j = 0; j < VariableContainer.arrayPC.length; j++) {
                VariableContainer.arrayPC[i][j] = VariableContainer.EMPTY;
            }
        }
        VariableContainer.arrayPC[0][5] = VariableContainer.PLACE;
        VariableContainer.arrayPC[1][1] = VariableContainer.PLACE;
        VariableContainer.arrayPC[1][3] = VariableContainer.PLACE;
        VariableContainer.arrayPC[1][7] = VariableContainer.PLACE;
        VariableContainer.arrayPC[1][8] = VariableContainer.PLACE;
        VariableContainer.arrayPC[1][9] = VariableContainer.PLACE;
        VariableContainer.arrayPC[2][1] = VariableContainer.PLACE;
        VariableContainer.arrayPC[3][1] = VariableContainer.PLACE;
        VariableContainer.arrayPC[4][1] = VariableContainer.PLACE;
        VariableContainer.arrayPC[3][4] = VariableContainer.PLACE;
        VariableContainer.arrayPC[4][4] = VariableContainer.PLACE;
        VariableContainer.arrayPC[4][8] = VariableContainer.PLACE;
        VariableContainer.arrayPC[4][9] = VariableContainer.PLACE;
        VariableContainer.arrayPC[6][5] = VariableContainer.PLACE;
        VariableContainer.arrayPC[7][2] = VariableContainer.PLACE;
        VariableContainer.arrayPC[8][2] = VariableContainer.PLACE;
        VariableContainer.arrayPC[9][0] = VariableContainer.PLACE;
        VariableContainer.arrayPC[9][2] = VariableContainer.PLACE;
        VariableContainer.arrayPC[9][6] = VariableContainer.PLACE;
        VariableContainer.arrayPC[9][7] = VariableContainer.PLACE;
    }

    public void RandomShot(Logic logic, String[][] array) {
        Random random = new Random();
        int row = random.nextInt(array.length);
        int column = random.nextInt(array.length);
        while(array[row][column].equals(VariableContainer.MISS) || array[row][column].equals(VariableContainer.HITSINK) || array[row][column].equals(VariableContainer.HIT))
        {
            row = random.nextInt(array.length);
            column = random.nextInt(array.length);
        }
        if (array[row][column].equals(VariableContainer.PLACE)) {
            logic.SetStatus(array, VariableContainer.HIT, column, row);
        }else{
            logic.SetStatus(array, VariableContainer.MISS, column, row);
        }
    }
}
