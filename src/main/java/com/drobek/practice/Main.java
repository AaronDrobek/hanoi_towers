package com.drobek.practice;

import com.drobek.practice.Controller.GameController;

import java.util.Scanner;

public class Main {
public static Scanner scanner = new Scanner(System.in);
    public static void main(String... arg){
        GameController gameController = new GameController();
        System.out.println("How many discs would you like to play with?");
        int userInput = scanner.nextInt();
        int[] towerA = new int[userInput];
        int[] towerB = new int[userInput];
        int[] towerC = new int[userInput];

        gameController.buildGameBoard(userInput, towerA);
        gameController.printGameBoard(towerA, 'A');
        gameController.printGameBoard(towerB, 'B');
        gameController.printGameBoard(towerC, 'C');


//        System.out.println("How many discs would you like? 1-5 ");
//        int userInput = scanner.nextInt();
//        gameController.validateUserEntry(userInput);
////        gameController.buildGameBoard(userInput);
//        gameController.printGameBoard();




    }
}
