package com.battleship;

import com.sun.javafx.geom.Vec2d;

public class Ship {

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

    /*public Vec2d FindLastPutPlace(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j].equals(VariableContainer.PLACE)) {
                    if (i > 0 && array[i - 1][j].equals(VariableContainer.UNLOCK)) {

                    } else if (i + 1 < array.length && array[i + 1][j].equals(VariableContainer.UNLOCK)) {

                    } else if (j > 0 && array[i][j - 1].equals(VariableContainer.UNLOCK)) {

                    } else if (j + 1 < array.length && array[i][j + 1].equals(VariableContainer.UNLOCK)) {

                    } else {
                        return new Vec2d(i, j);
                    }
                }
            }
        }
        return new Vec2d(0, 0);
    }*/


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
        /*if (lastPut.y - 1 >= 0 && lastPut.y + 1 <= VariableContainer.array.length) {
            if (array[(int) lastPut.x][(int) lastPut.y - 1].equals(VariableContainer.PLACE) || array[(int) lastPut.x][(int) lastPut.y + 1].equals(VariableContainer.PLACE)) {
                return true;
            }
        }
        return false;*/

        if (lastPut.y - 1 >= 0 && array[(int) lastPut.x][(int) lastPut.y - 1].equals(VariableContainer.PLACE)) {
            return true;
        } else if (lastPut.y + 1 <= VariableContainer.array.length - 1 && array[(int) lastPut.x][(int) lastPut.y + 1].equals(VariableContainer.PLACE)) {
            return true;
        }

        return false;
    }

    public void SetUnlockPlace(String[][] array) {
        Vec2d lastPut = VariableContainer.LASTPLACE;//FindLastPutPlace(array);
        int x = (int) lastPut.x;
        System.out.println("FindLastPutPlace x = " + x);
        int y = (int) lastPut.y;
        System.out.println("FindLastPutPlace y = " + y);
        System.out.println("Horizontally = " + Horizontally(array));
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

}
