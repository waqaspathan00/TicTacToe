package com.company;

import java.util.ArrayList;

public class Board {

// the tictactoe board
//       |   |
//    -----------
//       |   |
//    -----------
//       |   |

    /**
     * each sec variable is a unique section in the tictactoe board
     * going from left to right, top to bottom
     *
     * temporarily made these variables public for testing purposes
     */
    public String  sec1, sec2, sec3,
            sec4, sec5, sec6,
            sec7, sec8, sec9;

    /**
     * the rows of the board
     * rows 1, 3, and 5 are 'variable' rows and will change throughout the game
     * rows 2 and 4 are just horizontal lines
     *
     * temporarily made these variables public for testing purposes
     */
    public String row1, row2, row3, row4, row5;

    /**
     * Holds the positions that have already been taken and chosen by players during previous moves
     */
    ArrayList<Integer> takenPositions = new ArrayList<>();

    /**
     * Board constructor that creates an empty board using the sections
     * it does this by first initializing all the sections to 3 empty spaces.
     * then calls setRows() and concatenates the respective sec variables together
     */
    public Board (){
        sec1 = sec2 = sec3 = sec4 = sec5 = sec6 = sec7 = sec8 = sec9
                = "   ";

        setRows();
    }

    /**
     * tests for the 8 different ways to win the game, if one of them is met it will return true
     * and the loop in main() will terminate
     * the 8 ways to win are:
     * 3 ways horizontally
     * 3 ways vertically
     * 2 ways diagonally
     * @return true if 3 given positions match
     *         false if none of the tests resolve
     */
    public boolean gameWon(){
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

    /**
     * assignPosition assigns the player character to a given position
     * the value of position is calculated in determinePosition()
     */
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

    /**
     * checks to see if the position being entered has already been taken or not
     * if it has been taken return true so that a letter will not be assigned in that position again
     * it does this by cycling through every value in the takenPositions arrayList
     * if one of those values is equal to the position the player chose then they will have to try again
     */
    public boolean validatePosition(int position){
        if (takenPositions.contains(position)){
            return true;
        }

        return false;
    }

    /**
     * determines the final position that a player will place in based on the row and column
     * it does this by using a nested switch case
     * the outer switch represents the row, the inner switch represents the column
     */
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

    /**
     * set the rows of the board according
     * to the values of the individual sections
     */
    public void setRows(){
        row1 = sec1 + "|" + sec2 + "|" + sec3;
        row2 = "-----------";
        row3 = sec4 + "|" + sec5 + "|" + sec6;
        row4 = "-----------";
        row5 = sec7 + "|" + sec8 + "|" + sec9;
    }

    /** Prints out the tictactoe board
     *
     * @return is temporarily null as a testing measure
     */
    public String printBoard(){
        return (row1 + "\n" + row2 + "\n" + row3 + "\n" + row4 + "\n" + row5 + "\n");

//        System.out.println(row1);
//        System.out.println(row2);
//        System.out.println(row3);
//        System.out.println(row4);
//        System.out.println(row5);
//        System.out.println();
    }

    /**
     * If a player move choice is invalid then print an error message
     *
     * @param row the row choice of the board
     * @param column the column choice of the board
     * @return is temporarily null as a testing measure
     */
    public String printError(int row, int column){
        return ("This move at (" + row + "," + column + ") is not valid. Try again...");
    }
}