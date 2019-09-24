package com.battleship;

import org.junit.Assert;
import org.junit.Test;


public class BattleshipApplicationTests {

    @Test
    public void testSetStatus() {
        Logic ship = new Logic();

        String[][] emptyArray = new String[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                emptyArray[i][j] = VariableContainer.EMPTY;
            }
        }

        String[][] expectedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HITSINK, VariableContainer.EMPTY, VariableContainer.UNLOCK},
                {VariableContainer.EMPTY, VariableContainer.LOCK, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.PLACE},
                {VariableContainer.EMPTY, VariableContainer.LOCK, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        ship.SetStatus(emptyArray, VariableContainer.HITSINK, 2, 0);
        ship.SetStatus(emptyArray, VariableContainer.LOCK, 1, 1);
        ship.SetStatus(emptyArray, VariableContainer.LOCK, 1, 3);
        ship.SetStatus(emptyArray, VariableContainer.UNLOCK, 4, 0);
        ship.SetStatus(emptyArray, VariableContainer.PLACE, 4, 2);
        ship.SetStatus(emptyArray, VariableContainer.PLACE, 1, 2);
        ship.SetStatus(emptyArray, VariableContainer.HIT, 3, 2);

        Assert.assertArrayEquals(expectedArray, emptyArray);
    }

    @Test
    public void testSetLockAroundPlaceOneShip() {
        Logic ship = new Logic();
        String[][] emptyArray = new String[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                emptyArray[i][j] = VariableContainer.EMPTY;
            }
        }
        ship.SetStatus(emptyArray, VariableContainer.PLACE, 2, 2);
        String[][] expectedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.LOCK, VariableContainer.LOCK, VariableContainer.LOCK, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.LOCK, VariableContainer.PLACE, VariableContainer.LOCK, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.LOCK, VariableContainer.LOCK, VariableContainer.LOCK, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        ship.SetLockAroundPlace(emptyArray);

        /*for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(emptyArray[i][j] + "   ");
            }
            System.out.println();
        }*/

        Assert.assertEquals(expectedArray, emptyArray);
    }


    @Test
    public void testSetLockAroundPlaceTwoShip() {
        Logic ship = new Logic();
        String[][] emptyArray = new String[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                emptyArray[i][j] = VariableContainer.EMPTY;
            }
        }
        ship.SetStatus(emptyArray, VariableContainer.PLACE, 2, 2);
        ship.SetStatus(emptyArray, VariableContainer.PLACE, 3, 2);
        String[][] expectedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.LOCK, VariableContainer.LOCK, VariableContainer.LOCK, VariableContainer.LOCK},
                {VariableContainer.EMPTY, VariableContainer.LOCK, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.LOCK},
                {VariableContainer.EMPTY, VariableContainer.LOCK, VariableContainer.LOCK, VariableContainer.LOCK, VariableContainer.LOCK},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        ship.SetLockAroundPlace(emptyArray);

        Assert.assertEquals(expectedArray, emptyArray);
    }

    @Test
    public void testSetLockAroundPlaceThreeShip() {
        Logic ship = new Logic();
        String[][] emptyArray = new String[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                emptyArray[i][j] = VariableContainer.EMPTY;
            }
        }
        ship.SetStatus(emptyArray, VariableContainer.PLACE, 2, 2);
        ship.SetStatus(emptyArray, VariableContainer.PLACE, 3, 2);
        ship.SetStatus(emptyArray, VariableContainer.PLACE, 1, 2);
        String[][] expectedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.LOCK, VariableContainer.LOCK, VariableContainer.LOCK, VariableContainer.LOCK, VariableContainer.LOCK},
                {VariableContainer.LOCK, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.LOCK},
                {VariableContainer.LOCK, VariableContainer.LOCK, VariableContainer.LOCK, VariableContainer.LOCK, VariableContainer.LOCK},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        ship.SetLockAroundPlace(emptyArray);

        Assert.assertEquals(expectedArray, emptyArray);
    }

    @Test
    public void testSetUnlockAroundFirstPlace() {
        Logic ship = new Logic();
        String[][] emptyArray = new String[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                emptyArray[i][j] = VariableContainer.EMPTY;
            }
        }
        ship.SetStatus(emptyArray, VariableContainer.PLACE, 2, 2);
        String[][] expectedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.PLACE, VariableContainer.UNLOCK, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        ship.SetUnlockAroundFirstPlace(emptyArray);


        Assert.assertEquals(expectedArray, emptyArray);
    }

    @Test
    public void testSetUnlockAroundFirstPlaceBorder() {
        Logic ship = new Logic();
        String[][] emptyArray = new String[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                emptyArray[i][j] = VariableContainer.EMPTY;
            }
        }
        ship.SetStatus(emptyArray, VariableContainer.PLACE, 4, 4);
        String[][] expectedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.UNLOCK},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.PLACE},
        };

        ship.SetUnlockAroundFirstPlace(emptyArray);


        Assert.assertEquals(expectedArray, emptyArray);
    }

    @Test
    public void testHorizontally()
    {
        Logic ship = new Logic();
        String[][] startArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.UNLOCK, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        boolean exceptedHorizontally = true;
        boolean returnHorizontally = ship.Horizontally(startArray);

        Assert.assertEquals(exceptedHorizontally, returnHorizontally);
    }


    @Test
    public void test1SetUnlockPlace()
    {
        Logic ship = new Logic();
        String[][] startArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        String[][] exceptedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.UNLOCK, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.UNLOCK, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        ship.SetUnlockPlace(startArray);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(startArray[i][j] + "   ");
            }
            System.out.println();
        }

        Assert.assertEquals(exceptedArray, startArray);
    }

    @Test
    public void test2SetUnlockPlace()
    {
        Logic ship = new Logic();
        String[][] startArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        String[][] exceptedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.UNLOCK, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.UNLOCK},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        ship.SetUnlockPlace(startArray);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(startArray[i][j] + "   ");
            }
            System.out.println();
        }

        Assert.assertEquals(exceptedArray, startArray);
    }

    @Test
    public void test3SetUnlockPlace()
    {
        Logic ship = new Logic();
        String[][] startArray = new String[][]{
                {VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        String[][] exceptedArray = new String[][]{
                {VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        ship.SetUnlockPlace(startArray);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(startArray[i][j] + "   ");
            }
            System.out.println();
        }

        Assert.assertEquals(exceptedArray, startArray);
    }

    @Test
    public void test4SetUnlockPlace()
    {
        Logic ship = new Logic();
        String[][] startArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.UNLOCK},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.PLACE},
        };

        String[][] exceptedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.PLACE, VariableContainer.PLACE, VariableContainer.PLACE},
        };

        ship.SetUnlockPlace(startArray);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(startArray[i][j] + "   ");
            }
            System.out.println();
        }

        Assert.assertEquals(exceptedArray, startArray);
    }

    @Test
    public void test5SetUnlockPlace()
    {
        Logic ship = new Logic();
        String[][] startArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.UNLOCK, VariableContainer.PLACE, VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.UNLOCK, VariableContainer.PLACE, VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        String[][] exceptedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        ship.SetUnlockPlace(startArray);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(startArray[i][j] + "   ");
            }
            System.out.println();
        }

        Assert.assertEquals(exceptedArray, startArray);
    }

    @Test
    public void test6SetUnlockPlace()
    {
        Logic ship = new Logic();
        String[][] startArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.PLACE, VariableContainer.UNLOCK},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.PLACE, VariableContainer.UNLOCK},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        String[][] exceptedArray = new String[][]{
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.UNLOCK, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
        };

        ship.SetUnlockPlace(startArray);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(startArray[i][j] + "   ");
            }
            System.out.println();
        }

        Assert.assertEquals(exceptedArray, startArray);
    }
}
