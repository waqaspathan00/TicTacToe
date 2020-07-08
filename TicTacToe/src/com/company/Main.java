package com.company;
import java.util.*;

public class Main {

    // NOTES:
    // create validation methods for the row and column choice that should:
        // make sure they are values from 1-3
        // make sure that the combined input is not an already used slot on the board

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Board board = new Board();
        boolean alternatePlayer = true; // variable that allows alteration between players
        boolean gameWon = false;        // variable that will change to true once the game is won
        char player = playerTurn(alternatePlayer); // character name that is assigned from the value of alternatePlayer
        int rowChoice;      // the players choice of which row they want to place in
        int columnChoice;   // the players choice of which column they want to place in
        int position;       // final position calculated off the rowChoice and columnChoice
        int turnCount = 1;  // incrementing turn variable which will terminate the game once it becomes greater than 9


        // the test cases for this while loop:
        // 1) if the 3 in a row requirement is met
        // 2) if a draw is met OR if 9 turns have passed, the latter seems like a better option
        while((!gameWon) && (turnCount <= 9)){

            // taking in the users choice for their row and column
            System.out.print("Player '" + player + "', enter your move (row[1-3] and column[1-3]): ");
            rowChoice = scanner.nextInt();
            columnChoice = scanner.nextInt();

            // calculating their position on the board
            position = board.determinePosition(rowChoice, columnChoice);

            // if they entered an invalid position, restart the loop
            if (board.validatePosition(position)){
                board.printError(rowChoice, columnChoice);
                continue;
            }
            if (position == -1){
                continue;
            }

            // if everything is valid assign their letter to their position of choosing
            board.assignPosition(player, position);
            board.printBoard();

            // will test to see if the game has been won yet
            gameWon = board.gameWon(board);
            if (gameWon){
                System.out.println("Player '" + player + "' won!");
            }

            // the alternatingPlayer boolean will become the opposite value
            alternatePlayer = !alternatePlayer;

            // the players turn will change
            player = playerTurn(alternatePlayer);

            // increments the turn count
            turnCount++;
        }

        // this will only be reached if and when 9 turns have passed
        if (turnCount > 9){
            System.out.println("It is a tie!");
        }
    }

    // playerTurn alternates between player X and player O
    // if the incoming boolean value is true then it is player X's turn and vice versa
    // the value of the boolean value gets changed in the while loop
    public static char playerTurn (boolean alternatePlayer){
        if (alternatePlayer){
            return 'X';
        } else {
            return 'O';
        }
    }
}
