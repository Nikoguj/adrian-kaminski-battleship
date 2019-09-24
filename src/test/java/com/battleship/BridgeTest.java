package com.battleship;

import org.junit.Assert;
import org.junit.Test;

public class BridgeTest {
    @Test
    public void testPlayerChooseShip()
    {
        Logic ship = new Logic();
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
        Logic ship = new Logic();
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

        Player player = new Player("Player", false);

        bridge.PlayerChooseShip(VariableContainer.FOUR_MASTED, ship, array);
        bridge.PlayerClickButtonInBoard(ship, array, 1,2, player);

        Assert.assertEquals(exceptedArray, array);
    }

    @Test
    public void test2PlayerClickButtonInBoard()
    {
        Logic ship = new Logic();
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

        Player player = new Player("Player", false);

        bridge.PlayerChooseShip(VariableContainer.FOUR_MASTED, ship, array);
        bridge.PlayerClickButtonInBoard(ship, array, 1,2, player);
        bridge.PlayerClickButtonInBoard(ship, array, 2, 2, player);

        Assert.assertEquals(exceptedArray, array);
    }

    @Test
    public void test3PlayerClickButtonInBoard()
    {
        Logic ship = new Logic();
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


        Player player = new Player("Player", false);

        bridge.PlayerChooseShip(VariableContainer.FOUR_MASTED, ship, array);
        bridge.PlayerClickButtonInBoard(ship, array, 1,4, player);
        bridge.PlayerClickButtonInBoard(ship, array, 1, 3, player);
        bridge.PlayerClickButtonInBoard(ship, array, 1, 2, player);

        Assert.assertEquals(exceptedArray, array);
    }

    @Test
    public void test4PlayerClickButtonInBoard()
    {
        Logic ship = new Logic();
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

        Player player = new Player("Player", false);

        bridge.PlayerChooseShip(VariableContainer.FOUR_MASTED, ship, array);
        bridge.PlayerClickButtonInBoard(ship, array, 0,4, player);
        bridge.PlayerClickButtonInBoard(ship, array, 0, 3, player);
        bridge.PlayerClickButtonInBoard(ship, array, 0, 2, player);

        Assert.assertEquals(exceptedArray, array);
    }

    @Test
    public void test5PlayerClickButtonInBoard()
    {
        Logic ship = new Logic();
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


        Player player = new Player("Player", false);

        bridge.PlayerChooseShip(VariableContainer.FOUR_MASTED, ship, array);
        bridge.PlayerClickButtonInBoard(ship, array, 0,4, player);
        bridge.PlayerClickButtonInBoard(ship, array, 1, 4, player);

        Assert.assertEquals(exceptedArray, array);
    }

    @Test
    public void test7PlayerClickButtonInBoard()
    {
        Logic ship = new Logic();
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
        Player player = new Player("Player", false);

        bridge.PlayerClickButtonInBoard(ship, array, 1,2, player);
        bridge.PlayerClickButtonInBoard(ship, array, 2,2, player);
        bridge.PlayerClickButtonInBoard(ship, array, 3,2, player);

        Assert.assertEquals(exceptedArray, array);
    }
}
