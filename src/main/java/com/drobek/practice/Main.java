package com.drobek.practice;

import com.drobek.practice.Controller.GameController;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String... arg) {

        int userInput;
        do {
            System.out.println("How many discs would you like to play with?");
            while (!scanner.hasNextInt()) {
                System.out.println("Number is required !");
                scanner.next();
            }
            userInput = scanner.nextInt();
        }
        while (userInput <= 0);

        int[] towerA = new int[userInput];
        int[] towerB = new int[userInput];
        int[] towerC = new int[userInput];
        int moveCounter = 0;

        GameController gameController = new GameController();
        gameController.buildTowers(towerA);

        while (gameController.checkWin(towerB, towerC, userInput) == false) {

            gameController.printTower(towerA, 'A');
            gameController.printTower(towerB, 'B');
            gameController.printTower(towerC, 'C');
            System.out.println();

            System.out.println("Move--FROM");
            char from = scanner.next().toUpperCase().charAt(0);
            if (from == 'A' || from == 'B' || from == 'C') {
                System.out.println("Move--TO");
                char to = scanner.next().toUpperCase().charAt(0);
                if (to != from) {
                    if (to == 'A' || to == 'B' || to == 'C') {
                        System.out.println();

                        gameController.towerOfHanoi(userInput, from, to, towerA, towerB, towerC);
                        moveCounter++;
                    } else {
                        System.out.println("please enter A B or C");
                    }
                } else {
                    System.out.println("please enter A B or C");
                }
            }
        }
        System.out.println("Took you " + moveCounter + " moves to move the tower");
    }

}

