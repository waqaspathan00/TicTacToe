package com.company;

import java.util.ArrayList;

public class Board {

//    the tictactoe board
//       |   |
//    -----------
//       |   |
//    -----------
//       |   |

    // each sec variable is a unique section in the tictactoe board
    // going from left to right, top to bottom
    String  sec1, sec2, sec3,
            sec4, sec5, sec6,
            sec7, sec8, sec9;

    // the rows of the board
    // Rows 1, 3, and 5 are 'variable' rows and will change throughout the game
    // Rows 2 and 4 are just horizontal lines
    String row1, row2, row3, row4, row5;

    // Holds the positions that have already been taken and chosen by players during previous moves
    ArrayList<Integer> takenPositions = new ArrayList<>();

    // Board constructor that creates an empty board using the sections
    // it does this by first initializing all the sections to 3 empty spaces.
    // then calls setRows() and concatenates the respective sec variables together
    public Board (){
        sec1 = sec2 = sec3 = sec4 = sec5 = sec6 = sec7 = sec8 = sec9
                = "   ";

        setRows();
    }

    // tests for the 8 different ways to win the game, if one of them is met it will return true
    // and the loop in main() will terminate
    // the 8 ways to win are:
    // 3 ways horizontally
    // 3 ways vertically
    // 2 ways diagonally
    // if any one of these ways proves valid then check to see if one of those positions is empty
    // if it is empty then that means the entire test is empty and equal, so in turn it is invalid
    // Note: the position that is checked to be empty is predetermined as one of the 3 spots being chosen
    public boolean gameWon(Board board){
        // First Row
        if (((row1.charAt(1)) == (row1.charAt(5)))
                && ((row1.charAt(5)) == (row1.charAt(9)))){
            if (row1.charAt(1) != ' '){
                return true;
            }
        }

        // Second Row
        if (((row3.charAt(1)) == (row3.charAt(5)))
                && ((row3.charAt(5)) == (row3.charAt(9)))){
            if (row3.charAt(1) != ' '){
                return true;
            }
        }

        // Third Row
        if (((row5.charAt(1)) == (row5.charAt(5)))
                && ((row5.charAt(5)) == (row5.charAt(9)))){
            if (row5.charAt(1) != ' '){
                return true;
            }
        }

        // First Column
        if (((row1.charAt(1)) == (row3.charAt(1)))
                && ((row3.charAt(1)) == (row5.charAt(1)))){
            if (row1.charAt(1) != ' '){
                return true;
            }
        }

        // Second Column
        if (((row1.charAt(5)) == (row3.charAt(5)))
                && ((row3.charAt(5)) == (row5.charAt(5)))){
            if (row1.charAt(5) != ' '){
                return true;
            }
        }

        // Third Column
        if (((row1.charAt(9)) == (row3.charAt(9)))
                && ((row3.charAt(9)) == (row5.charAt(9)))){
            if (row1.charAt(9) != ' '){
                return true;
            }
        }

        // Diagonal from Top Left - Bottom Right
        if (((row1.charAt(1)) == (row3.charAt(5)))
                && ((row3.charAt(5)) == (row5.charAt(9)))){
            if (row1.charAt(1) != ' '){
                return true;
            }
        }

        // Diagonal from Top Right - Bottom Left
        if (((row1.charAt(9)) == (row3.charAt(5)))
                && ((row3.charAt(5)) == (row5.charAt(1)))){
            if (row1.charAt(9) != ' '){
                return true;
            }
        }

        return false;
    }

    // QUESTION
    // IntelliJea was suggesting that i change the above third Column to the following
//    return ((row1.charAt(9)) == (row3.charAt(9)))
//            && ((row3.charAt(9)) == (row5.charAt(9)));
    // would this work properly and or more efficiently if EVERY if statement in the method was built like this
    // Also, why did it only suggest it for the third column, why not the other rows or columns? Did I miss something
    // and accidentally build this one slightly differently?


    // assignPosition assigns the player character to a given position
    // the value of position is calculated in determinePosition()
    public void assignPosition(char player, int position){
        switch (position){
            case 1:
                sec1 = " " + player + " ";
                takenPositions.add(1);
                break;
            case 2:
                sec2 = " " + player + " ";
                takenPositions.add(2);
                break;
            case 3:
                sec3 = " " + player + " ";
                takenPositions.add(3);
                break;
            case 4:
                sec4 = " " + player + " ";
                takenPositions.add(4);
                break;
            case 5:
                sec5 = " " + player + " ";
                takenPositions.add(5);
                break;
            case 6:
                sec6 = " " + player + " ";
                takenPositions.add(6);
                break;
            case 7:
                sec7 = " " + player + " ";
                takenPositions.add(7);
                break;
            case 8:
                sec8 = " " + player + " ";
                takenPositions.add(8);
                break;
            case 9:
                sec9 = " " + player + " ";
                takenPositions.add(9);
                break;
        }

        setRows();
    }

    // checks to see if the position being entered has already been taken or not
    // if it has been taken return true so that a letter will not be assigned in that position again
    // it does this by cycling through every value in the takenPositions arrayList
    // if one of those values is equal to the position the player chose then they will have to try again
    public boolean validatePosition(int position){
        for (int i = 0; i < takenPositions.size(); i++){
            if (position == takenPositions.get(i)){
                return true;
            }
        }

        return false;
    }

    // determines the final position that a player will place in based on the row and column
    // it does this by using a nested switch case
    // the outer switch represents the row, the inner switch represents the column
    public int determinePosition(int row, int column){
        switch (row){
            case 1:
                switch (column){
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 3;
                }
            case 2:
                switch (column){
                    case 1:
                        return 4;
                    case 2:
                        return 5;
                    case 3:
                        return 6;
                }
            case 3:
                switch (column){
                    case 1:
                        return 7;
                    case 2:
                        return 8;
                    case 3:
                        return 9;
                }
        }

        printError(row, column);
        return -1;
    }

    public void setRows(){
        row1 = sec1 + "|" + sec2 + "|" + sec3;
        row2 = "-----------";
        row3 = sec4 + "|" + sec5 + "|" + sec6;
        row4 = "-----------";
        row5 = sec7 + "|" + sec8 + "|" + sec9;
    }

    /** Prints out the tictactoe board
     *
     * @return null;
     */
    public String printBoard(){
        System.out.println(row1);
        System.out.println(row2);
        System.out.println(row3);
        System.out.println(row4);
        System.out.println(row5);
        System.out.println();

        return null;
    }

    public String printError(int row, int column){
        System.out.println("This move at (" + row + "," + column + ") is not valid. Try again...");

        return null;
    }
}