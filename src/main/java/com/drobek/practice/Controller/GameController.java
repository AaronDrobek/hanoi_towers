package com.drobek.practice.Controller;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameController {

    int diskToMove;
    int diskToMoveIndex;
    String towerOfDiscOrigin;
    int discToValidate;
    int discToValidateIndex;


    public void buildTowers(int[] tower) {
        for (int index = tower.length; index > 0; index--) {
            tower[tower.length - index] = index;
        }
    }


    public void printTower(int[] a, char x) {
        System.out.print(x + "-");
        for (int item : a) {
            System.out.print(item);
        }
        System.out.print("-");
        System.out.println();
    }

    private void checkIfCanMoveFromTower(int[] tower, String towerName) {
        for (int i = tower.length - 1; i >= 0; i--) {
            if (tower[i] > 0) {
                diskToMoveIndex = i;
                diskToMove = tower[i];
                towerOfDiscOrigin = towerName;
                break;
            }
        }
    }

    public void towerOfHanoi(int numberOfDisks, char from, char to, int[] towerA, int[] towerB, int[] towerC) {
        if (from == 'A') {
            checkIfCanMoveFromTower(towerA, "towerA");
        }
        if (from == 'B') {
            checkIfCanMoveFromTower(towerB, "towerB");
        }
        if (from == 'C') {
            checkIfCanMoveFromTower(towerC, "towerC");
        }
        if (to == 'A') {
            int emptyTower = 0;
            for (int i = towerA.length - 1; i >= 0; i--) {
                if (towerA[i] > 0) {
                    discToValidate = towerA[i];
                    discToValidateIndex = i;
                    emptyTower++;
                    if (validate()) {
                        towerA[discToValidateIndex + 1] = diskToMove;
                        if (from == 'B') {
                            towerB[diskToMoveIndex] = 0;
                            break;
                        }
                        if (from == 'C') {
                            towerC[diskToMoveIndex] = 0;
                            break;
                        }
                    }
                }
            }
            if (emptyTower == 0) {

                if (from == 'B') {
                    moveMethod(towerA, towerB, diskToMove, diskToMoveIndex);
                }
                if (from == 'C') {
                    moveMethod(towerA, towerC, diskToMove, diskToMoveIndex);
                }
            }
        }
        if (to == 'B') {
            int emptyTower = 0;
            for (int i = towerB.length - 1; i >= 0; i--) {
                if (towerB[i] > 0) {
                    discToValidate = towerB[i];
                    discToValidateIndex = i;
                    emptyTower++;
                    if (validate()) {
                        towerB[discToValidateIndex + 1] = diskToMove;
                        if (from == 'A') {
                            towerA[diskToMoveIndex] = 0;
                            break;
                        }

                        if (from == 'C') {
                            towerC[diskToMoveIndex] = 0;
                            break;
                        }
                    }
                }
            }
            if (emptyTower == 0) {

                if (from == 'A') {
                    moveMethod(towerB, towerA, diskToMove, diskToMoveIndex);
                }
                if (from == 'C') {
                    moveMethod(towerB, towerC, diskToMove, diskToMoveIndex);
                }
            }
        }
        if (to == 'C') {
            int emptyTower = 0;
            for (int i = towerC.length - 1; i >= 0; i--) {
                if (towerC[i] > 0) {
                    discToValidate = towerC[i];
                    discToValidateIndex = i;
                    emptyTower++;
                    if (validate()) {
                        towerC[discToValidateIndex + 1] = diskToMove;
                        if (from == 'B') {
                            towerB[diskToMoveIndex] = 0;
                            break;
                        }

                        if (from == 'A') {
                            towerA[diskToMoveIndex] = 0;
                            break;
                        }
                    }
                }
            }
            if (emptyTower == 0) {
                if (from == 'A') {
                    moveMethod(towerC, towerA, diskToMove, diskToMoveIndex);
                }

                if (from == 'B') {
                    moveMethod(towerC, towerB, diskToMove, diskToMoveIndex);
                }
            }
        }

    }

    public void moveMethod(int[] xtower, int[] ytower, int diskToMove, int diskToMoveIndex) {
        xtower[0] = diskToMove;
        ytower[diskToMoveIndex] = 0;
    }

    public boolean validate() {
        if (diskToMove < discToValidate) {
            //can move
            return true;
        } else {
            System.out.println("not valid move! you cannot place a larger number on top of a smaller number");
            return false;
        }

    }

    public boolean checkWin(int[] towerB, int[] towerC, int userInput) {
        if (towerB[userInput - 1] > 0 || towerC[userInput - 1] > 0) {
            System.out.println("********* YOU WON !*********");
            return true;
        }
        return false;
    }


}


