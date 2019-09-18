package com.battleship;

public class Array {

    public void PrintArray(String[][] array) {
        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array.length; j++)
            {
                System.out.print(array[i][j] + "     ");
            }
            System.out.println();
        }
    }

    public void SetArrayEmpty(String[][] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array.length; j++)
            {
                array[i][j] = VariableContainer.EMPTY;
            }
        }
    }
}
