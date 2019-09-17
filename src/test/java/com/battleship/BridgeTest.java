package com.battleship;

import org.junit.Assert;
import org.junit.Test;

public class BridgeTest {
    @Test
    public void testPlayerChooseShip()
    {
        Ship ship = new Ship();
        Bridge bridge = new Bridge();

        String[][] array = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        bridge.PlayerChooseShip(VariableContainer.FOUR_MASTED, ship, array);

        Assert.assertEquals(4, VariableContainer.HOW_MANY_LEFT_TO_PLACE);
    }

    @Test
    public void testPlayerClickButtonInBoard()
    {
        Ship ship = new Ship();
        Bridge bridge = new Bridge();

        String[][] array = new String[][]{
            {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
            {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
            {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
            {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
            {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        String[][] exceptedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.UNLOCK, VariableContainer.PLACE, VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        bridge.PlayerChooseShip(VariableContainer.FOUR_MASTED, ship, array);
        bridge.PlayerClickButtonInBoard(ship, array, 1,2);

        Assert.assertEquals(exceptedArray, array);
    }

    @Test
    public void test2PlayerClickButtonInBoard()
    {
        Ship ship = new Ship();
        Bridge bridge = new Bridge();

        String[][] array = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        String[][] exceptedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.UNLOCK, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.UNLOCK, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        bridge.PlayerChooseShip(VariableContainer.FOUR_MASTED, ship, array);
        bridge.PlayerClickButtonInBoard(ship, array, 1,2);
        bridge.PlayerClickButtonInBoard(ship, array, 2, 2);

        Assert.assertEquals(exceptedArray, array);
    }

    @Test
    public void test3PlayerClickButtonInBoard()
    {
        Ship ship = new Ship();
        Bridge bridge = new Bridge();

        String[][] array = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        String[][] exceptedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        bridge.PlayerChooseShip(VariableContainer.FOUR_MASTED, ship, array);
        bridge.PlayerClickButtonInBoard(ship, array, 1,4);
        bridge.PlayerClickButtonInBoard(ship, array, 1, 3);
        bridge.PlayerClickButtonInBoard(ship, array, 1, 2);

        Assert.assertEquals(exceptedArray, array);
    }

    @Test
    public void test4PlayerClickButtonInBoard()
    {
        Ship ship = new Ship();
        Bridge bridge = new Bridge();

        String[][] array = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        String[][] exceptedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.PLACE, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.PLACE, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.PLACE, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        bridge.PlayerChooseShip(VariableContainer.FOUR_MASTED, ship, array);
        bridge.PlayerClickButtonInBoard(ship, array, 0,4);
        bridge.PlayerClickButtonInBoard(ship, array, 0, 3);
        bridge.PlayerClickButtonInBoard(ship, array, 0, 2);

        Assert.assertEquals(exceptedArray, array);
    }

    @Test
    public void test5PlayerClickButtonInBoard()
    {
        Ship ship = new Ship();
        Bridge bridge = new Bridge();

        String[][] array = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        String[][] exceptedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        bridge.PlayerChooseShip(VariableContainer.FOUR_MASTED, ship, array);
        bridge.PlayerClickButtonInBoard(ship, array, 0,4);
        bridge.PlayerClickButtonInBoard(ship, array, 1, 4);

        Assert.assertEquals(exceptedArray, array);
    }

    @Test
    public void test6PlayerClickButtonInBoard()
    {
        Ship ship = new Ship();
        Bridge bridge = new Bridge();

        String[][] array = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        String[][] exceptedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.UNLOCK, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.PLACE},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        bridge.PlayerChooseShip(VariableContainer.FOUR_MASTED, ship, array);

        bridge.PlayerClickButtonInBoard(ship, array, 1,2);
        bridge.PlayerClickButtonInBoard(ship, array, 2,2);
        bridge.PlayerClickButtonInBoard(ship, array, 3,2);
        bridge.PlayerClickButtonInBoard(ship, array, 4,2);

        Assert.assertEquals(exceptedArray, array);
    }

    @Test
    public void test7PlayerClickButtonInBoard()
    {
        Ship ship = new Ship();
        Bridge bridge = new Bridge();

        String[][] array = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        String[][] exceptedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.UNLOCK, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.UNLOCK},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        bridge.PlayerChooseShip(VariableContainer.FOUR_MASTED, ship, array);

        bridge.PlayerClickButtonInBoard(ship, array, 1,2);
        bridge.PlayerClickButtonInBoard(ship, array, 2,2);
        bridge.PlayerClickButtonInBoard(ship, array, 3,2);

        Assert.assertEquals(exceptedArray, array);
    }

    @Test
    public void test8PlayerClickButtonInBoard()
    {
        Ship ship = new Ship();
        Bridge bridge = new Bridge();

        String[][] array = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        String[][] exceptedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.UNLOCK},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.PLACE},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.PLACE},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.PLACE},
        };

        bridge.PlayerChooseShip(VariableContainer.FOUR_MASTED, ship, array);

        bridge.PlayerClickButtonInBoard(ship, array, 4,4);
        bridge.PlayerClickButtonInBoard(ship, array, 4,3);
        bridge.PlayerClickButtonInBoard(ship, array, 4,2);

        Assert.assertEquals(exceptedArray, array);
    }

    @Test
    public void test9PlayerClickButtonInBoard()
    {
        Ship ship = new Ship();
        Bridge bridge = new Bridge();

        String[][] array = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        String[][] exceptedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.UNLOCK},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.PLACE},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.PLACE},
        };

        bridge.PlayerChooseShip(VariableContainer.TWO_MASTED, ship, array);

        bridge.PlayerClickButtonInBoard(ship, array, 4,4);
        bridge.PlayerClickButtonInBoard(ship, array, 4,3);
        bridge.PlayerClickButtonInBoard(ship, array, 4,2);
        bridge.PlayerClickButtonInBoard(ship, array, 1,3);

        Assert.assertEquals(exceptedArray, array);
    }
}
