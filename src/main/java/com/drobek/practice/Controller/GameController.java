package com.drobek.practice.Controller;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameController {


    public void buildGameBoard(int input, int[] towerA) {
        for (int index = towerA.length; index > 0; index--) {
            towerA[towerA.length - index] = index;
        }
    }

    public void printGameBoard(int[] a,char x ) {
        System.out.print(x + "-");
        for(int item: a){
            System.out.print(item);
        }
        System.out.print("-");
        System.out.println();
    }

}


