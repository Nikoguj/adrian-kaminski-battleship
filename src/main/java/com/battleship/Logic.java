package com.battleship;

import com.sun.javafx.geom.Vec2d;

public class Logic {

    public void SetStatus(String[][] array, String status, int column, int row) {
        try {
            array[row][column] = status;
        } catch (Exception e) {
            System.out.println("Outside the border");
        }
    }

    public void SetLockAroundPlace(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j].equals(VariableContainer.PLACE)) {
                    SetLockIfAroundIsPlace(array, i - 1, j);
                    SetLockIfAroundIsPlace(array, i + 1, j);
                    SetLockIfAroundIsPlace(array, i, j - 1);
                    SetLockIfAroundIsPlace(array, i, j + 1);
                    SetLockIfAroundIsPlace(array, i - 1, j - 1);
                    SetLockIfAroundIsPlace(array, i + 1, j + 1);
                    SetLockIfAroundIsPlace(array, i - 1, j + 1);
                    SetLockIfAroundIsPlace(array, i + 1, j - 1);
                }
            }
        }
    }

    public void SetLockIfAroundIsPlace(String[][] array, int i, int j) {
        try {
            if (!array[i][j].equals(VariableContainer.PLACE)) {
                SetStatus(array, VariableContainer.LOCK, j, i);
            }
        } catch (Exception e) {
        }
    }

    public void SetUnlockAroundFirstPlace(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j].equals(VariableContainer.PLACE)) {
                    SetUnlockIfEmpty(array, i - 1, j);
                    SetUnlockIfEmpty(array, i + 1, j);
                    SetUnlockIfEmpty(array, i, j - 1);
                    SetUnlockIfEmpty(array, i, j + 1);
                }
            }
        }
    }

    public void SetUnlockIfEmpty(String[][] array, int i, int j) {
        try {
            if (array[i][j].equals(VariableContainer.EMPTY)) {
                SetStatus(array, VariableContainer.UNLOCK, j, i);
            }
        } catch (Exception e) {
            System.out.println("Outside the border");
        }
    }

    public void SetAllUnlockToEmpty(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j].equals(VariableContainer.UNLOCK)) {
                    SetStatus(array, VariableContainer.EMPTY, j, i);
                }
            }
        }
    }

    public boolean Horizontally(String[][] array) {
        Vec2d lastPut = VariableContainer.LASTPLACE;

        if (lastPut.y - 1 >= 0 && array[(int) lastPut.x][(int) lastPut.y - 1].equals(VariableContainer.PLACE)) {
            return true;
        } else if (lastPut.y + 1 <= VariableContainer.array.length - 1 && array[(int) lastPut.x][(int) lastPut.y + 1].equals(VariableContainer.PLACE)) {
            return true;
        }

        return false;
    }

    public void SetUnlockPlace(String[][] array) {
        Vec2d lastPut = VariableContainer.LASTPLACE;
        int x = (int) lastPut.x;
        int y = (int) lastPut.y;
        if (Horizontally(array)) {
            SetAllUnlockToEmpty(array);
            for (int i = y; i < array.length; i++) {
                if (!array[x][i].equals(VariableContainer.LOCK)) {
                    if (array[x][i].equals(VariableContainer.EMPTY)) {
                        SetStatus(array, VariableContainer.UNLOCK, i, x);
                        break;
                    }
                } else {
                    break;
                }
            }

            for (int i = y; i >= 0; i--) {
                if (!array[x][i].equals(VariableContainer.LOCK)) {
                    if (array[x][i].equals(VariableContainer.EMPTY)) {
                        SetStatus(array, VariableContainer.UNLOCK, i, x);
                        break;
                    }
                } else {
                    break;
                }
            }

        } else {
            SetAllUnlockToEmpty(array);
            for (int i = x; i < array.length; i++) {
                if (!array[i][y].equals(VariableContainer.LOCK)) {
                    if (array[i][y].equals(VariableContainer.EMPTY)) {
                        SetStatus(array, VariableContainer.UNLOCK, y, i);
                        break;
                    }
                } else {
                    break;
                }

            }
            for (int i = x; i >= 0; i--) {
                if (!array[i][y].equals(VariableContainer.LOCK)) {
                    if (array[i][y].equals(VariableContainer.EMPTY)) {
                        SetStatus(array, VariableContainer.UNLOCK, y, i);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    public void HitSink(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j].equals(VariableContainer.HIT)) {
                    if (CheckIfItIsOneMastedShip(array, i, j)) {
                        array[i][j] = VariableContainer.HITSINK;
                    } else {
                        Vec2d vector = FindFirstBoxOfShip(array, i, j);
                        int length = FindLengthShip(array, i, j);
                        boolean allBoxHitInShip = AllBoxesHitInShip(array, i, j);
                        if(allBoxHitInShip)
                        {
                            if(CheckPosition(array, i, j) == "horizontal")
                            {
                                System.out.println("horizontal");
                                for(int k = (int) vector.y; k < vector.y + length; k++)
                                {
                                    array[i][k] = VariableContainer.HITSINK;
                                }
                            }else
                            {
                                System.out.println("vertical");
                                for(int k = (int) vector.x; k < vector.x + length; k++)
                                {
                                    array[k][j] = VariableContainer.HITSINK;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean CheckIfItIsOneMastedShip(String[][] array, int i, int j) {
        try {
            if (array[i + 1][j].equals(VariableContainer.HIT) || array[i + 1][j].equals(VariableContainer.PLACE)) {
                return false;
            }
        } catch (Exception e) {

        }
        try {
            if (array[i - 1][j].equals(VariableContainer.HIT) || array[i - 1][j].equals(VariableContainer.PLACE)) {
                return false;
            }
        } catch (Exception e) {

        }
        try {
            if (array[i][j + 1].equals(VariableContainer.HIT) || array[i][j + 1].equals(VariableContainer.PLACE)) {
                return false;
            }
        } catch (Exception e) {

        }
        try {
            if (array[i][j - 1].equals(VariableContainer.HIT) || array[i][j - 1].equals(VariableContainer.PLACE)) {
                return false;
            }
        } catch (Exception e) {

        }
        return true;
    }

    private String CheckPosition(String[][] array, int i, int j) {
        try {
            if (array[i + 1][j].equals(VariableContainer.HIT) || array[i + 1][j].equals(VariableContainer.PLACE)) {
                return "vertical";
            }
        } catch (Exception e) {

        }
        try {
            if (array[i - 1][j].equals(VariableContainer.HIT) || array[i - 1][j].equals(VariableContainer.PLACE)) {
                return "vertical";
            }
        } catch (Exception e) {

        }
        try {
            if (array[i][j + 1].equals(VariableContainer.HIT) || array[i][j + 1].equals(VariableContainer.PLACE)) {
                return "horizontal";
            }
        } catch (Exception e) {

        }
        try {
            if (array[i][j - 1].equals(VariableContainer.HIT) || array[i][j - 1].equals(VariableContainer.PLACE)) {
                return "horizontal";
            }
        } catch (Exception e) {

        }
        return "";
    }

    public Vec2d FindFirstBoxOfShip(String[][] array, int i, int j) {
        if (CheckPosition(array, i, j) == "horizontal") {
            while (j - 1 >= 0 && (array[i][j - 1].equals(VariableContainer.PLACE) || array[i][j - 1].equals(VariableContainer.HIT))) {
                j = j - 1;
            }
            Vec2d vec2d = new Vec2d(i, j);
            return vec2d;
        } else {
            while (i - 1 >= 0 && (array[i - 1][j].equals(VariableContainer.PLACE) || array[i - 1][j].equals(VariableContainer.HIT))) {
                i = i - 1;
            }
            Vec2d vec2d = new Vec2d(i, j);
            return vec2d;
        }
    }

    public int FindLengthShip(String[][] array, int i, int j) {
        int length = 0;
        Vec2d vector = FindFirstBoxOfShip(array, i, j);
        System.out.println(vector);
        if (CheckPosition(array, i, j) == "horizontal") {
            while (vector.y + 1 < array.length && (array[i][(int) (vector.y + 1)].equals(VariableContainer.PLACE) || array[i][(int) (vector.y + 1)].equals(VariableContainer.HIT))) {
                length++;
                vector.y = vector.y + 1;
            }
            System.out.println("Length = " + (length + 1));
            return length + 1;
        } else {
            while (vector.x + 1 < array.length && (array[(int) (vector.x + 1)][j].equals(VariableContainer.PLACE) || array[(int) (vector.x + 1)][j].equals(VariableContainer.HIT))) {
                length++;
                vector.x++;
            }
            System.out.println("Length = " + (length + 1));
            return length + 1;
        }
    }

    public boolean AllBoxesHitInShip(String[][] array, int i, int j) {
        int counter = 0;
        Vec2d vector = FindFirstBoxOfShip(array, i, j);
        int length = FindLengthShip(array, i, j);
        if (CheckPosition(array, i, j) == "horizontal") {
            while (vector.y + 1 <= array.length && array[i][(int) vector.y].equals(VariableContainer.HIT)) {
                counter++;
                vector.y++;
            }
        } else {
            while (vector.x + 1 <= array.length && array[(int) vector.x][j].equals(VariableContainer.HIT)) {
                counter++;
                vector.x++;
            }
        }

        if (counter == length) {
            return true;
        } else {
            return false;
        }
    }

}