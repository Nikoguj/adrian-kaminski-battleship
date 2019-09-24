package com.battleship;

import org.junit.Test;

public class ComputerTest {
    @Test
    public void testRandomShot() {
        Logic ship = new Logic();
        Computer computer = new Computer();
        Array array = new Array();
        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.PLACE},
                                 {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.PLACE},
                                 {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.PLACE},
                                 {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.PLACE},
                                 {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.PLACE}};
        computer.RandomShot(ship, startArray);
        array.PrintArray(startArray);
    }
}
