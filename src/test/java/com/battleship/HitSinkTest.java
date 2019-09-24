package com.battleship;

import com.sun.javafx.geom.Vec2d;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class HitSinkTest {

    @Test
    public void test2IsOneMasted()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Assert.assertEquals(true, logic.CheckIfItIsOneMastedShip(startArray, 1, 2));
    }

    @Test
    public void testIsOneMasted()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Assert.assertEquals(false, logic.CheckIfItIsOneMastedShip(startArray, 1, 2));
    }

    @Test
    public void test1FindFirstBoxOfShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.HIT, VariableContainer.HIT, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Vec2d vec2d = new Vec2d(1,1);

        Assert.assertEquals(vec2d, logic.FindFirstBoxOfShip(startArray, 1, 2));
    }

    @Test
    public void test2FindFirstBoxOfShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Vec2d vec2d = new Vec2d(1,2);

        Assert.assertEquals(vec2d, logic.FindFirstBoxOfShip(startArray, 1, 2));
    }

    @Test
    public void test3FindFirstBoxOfShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.HIT, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Vec2d vec2d = new Vec2d(2,0);

        Assert.assertEquals(vec2d, logic.FindFirstBoxOfShip(startArray, 2, 0));
    }

    @Test
    public void test1FindLengthShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.HIT, VariableContainer.HIT},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Assert.assertEquals(3, logic.FindLengthShip(startArray, 1, 3));
    }

    @Test
    public void test2FindLengthShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.HIT, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Assert.assertEquals(2, logic.FindLengthShip(startArray, 2, 0));
    }

    @Test
    public void test3FindLengthShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Assert.assertEquals(3, logic.FindLengthShip(startArray, 0, 4));
    }

    @Test
    public void test4FindLengthShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Assert.assertEquals(3, logic.FindLengthShip(startArray, 2, 1));
    }

    @Test
    public void test5FindLengthShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT}};

        Assert.assertEquals(4, logic.FindLengthShip(startArray, 2, 4));
    }

    @Test
    public void test6FindLengthShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Assert.assertEquals(3, logic.FindLengthShip(startArray, 3, 2));
    }

    @Test
    public void test7FindLengthShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.HIT, VariableContainer.HIT, VariableContainer.HIT},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Assert.assertEquals(4, logic.FindLengthShip(startArray, 2, 2));
    }

    @Test
    public void test8FindLengthShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Assert.assertEquals(4, logic.FindLengthShip(startArray, 2, 2));
    }

    @Test
    public void test1AllBoxesHitInShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Assert.assertEquals(true, logic.AllBoxesHitInShip(startArray, 2, 1));
    }

    @Test
    public void test2AllBoxesHitInShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Assert.assertEquals(false, logic.AllBoxesHitInShip(startArray, 2, 1));
    }

    @Test
    public void test3AllBoxesHitInShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.HIT, VariableContainer.HIT, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Assert.assertEquals(true, logic.AllBoxesHitInShip(startArray, 0, 1));
    }

    @Test
    public void test4AllBoxesHitInShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.HIT, VariableContainer.HIT, VariableContainer.PLACE, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Assert.assertEquals(false, logic.AllBoxesHitInShip(startArray, 0, 1));
    }

    @Test
    public void test5AllBoxesHitInShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Assert.assertEquals(true, logic.AllBoxesHitInShip(startArray, 1, 2));
    }

    @Test
    public void test6AllBoxesHitInShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Assert.assertEquals(true, logic.AllBoxesHitInShip(startArray, 2, 2));
    }

    @Test
    public void test7AllBoxesHitInShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.HIT, VariableContainer.HIT},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Assert.assertEquals(true, logic.AllBoxesHitInShip(startArray, 1, 2));
    }

    @Test
    public void test8AllBoxesHitInShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Assert.assertEquals(true, logic.AllBoxesHitInShip(startArray, 1, 1));
    }

    @Test
    public void test9AllBoxesHitInShip()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.PLACE, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        Assert.assertEquals(false, logic.AllBoxesHitInShip(startArray, 1, 1));
    }

    @Test
    public void test1HitSink()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        String[][] exceptedArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HITSINK, VariableContainer.HITSINK, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        logic.HitSink(startArray);

        for(int i = 0; i < startArray.length; i++)
        {
            for(int j = 0; j < startArray.length; j++)
            {
                System.out.print(startArray[i][j] + "    ");
            }
            System.out.println();
        }

        Assert.assertEquals(exceptedArray, startArray);

    }

    @Test
    public void test2HitSink()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.PLACE, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        String[][] exceptedArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.PLACE, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        logic.HitSink(startArray);

        for(int i = 0; i < startArray.length; i++)
        {
            for(int j = 0; j < startArray.length; j++)
            {
                System.out.print(startArray[i][j] + "    ");
            }
            System.out.println();
        }

        Assert.assertEquals(exceptedArray, startArray);

    }


    @Test
    public void test3HitSink()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.HIT, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        String[][] exceptedArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                    {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                    {VariableContainer.EMPTY, VariableContainer.HITSINK, VariableContainer.HITSINK, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                    {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                                    {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        logic.HitSink(startArray);

        for(int i = 0; i < startArray.length; i++)
        {
            for(int j = 0; j < startArray.length; j++)
            {
                System.out.print(startArray[i][j] + "    ");
            }
            System.out.println();
        }

        Assert.assertEquals(exceptedArray, startArray);

    }

    @Test
    public void test4HitSink()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.HIT, VariableContainer.HIT, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        String[][] exceptedArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HITSINK, VariableContainer.HITSINK, VariableContainer.HITSINK, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        logic.HitSink(startArray);

        for(int i = 0; i < startArray.length; i++)
        {
            for(int j = 0; j < startArray.length; j++)
            {
                System.out.print(startArray[i][j] + "    ");
            }
            System.out.println();
        }

        Assert.assertEquals(exceptedArray, startArray);

    }

    @Test
    public void test5HitSink()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.HIT, VariableContainer.HIT, VariableContainer.HIT, VariableContainer.HIT, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        String[][] exceptedArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.HITSINK, VariableContainer.HITSINK, VariableContainer.HITSINK, VariableContainer.HITSINK, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        logic.HitSink(startArray);

        for(int i = 0; i < startArray.length; i++)
        {
            for(int j = 0; j < startArray.length; j++)
            {
                System.out.print(startArray[i][j] + "    ");
            }
            System.out.println();
        }

        Assert.assertEquals(exceptedArray, startArray);

    }

    @Test
    public void test6HitSink()
    {
        Logic logic = new Logic();

        String[][] startArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HIT, VariableContainer.HIT, VariableContainer.HIT, VariableContainer.HIT},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        String[][] exceptedArray = {{VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.HITSINK, VariableContainer.HITSINK, VariableContainer.HITSINK, VariableContainer.HITSINK},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY},
                {VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY, VariableContainer.EMPTY}};

        logic.HitSink(startArray);

        for(int i = 0; i < startArray.length; i++)
        {
            for(int j = 0; j < startArray.length; j++)
            {
                System.out.print(startArray[i][j] + "    ");
            }
            System.out.println();
        }

        Assert.assertEquals(exceptedArray, startArray);

    }

}
