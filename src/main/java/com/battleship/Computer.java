package com.battleship;

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
}
