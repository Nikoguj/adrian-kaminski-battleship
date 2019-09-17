package com.battleship;

public class Array {

    public void PrintArray() {
        for(int i = 0; i < VariableContainer.array.length; i++)
        {
            for(int j = 0; j < VariableContainer.array.length; j++)
            {
                System.out.print(VariableContainer.array[i][j] + "     ");
            }
            System.out.println();
        }
    }

    public void SetArrayEmpty()
    {
        for(int i = 0; i < VariableContainer.array.length; i++)
        {
            for(int j = 0; j < VariableContainer.array.length; j++)
            {
                VariableContainer.array[i][j] = VariableContainer.EMPTY;
            }
        }
    }
}
