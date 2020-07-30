package com.company.tests;

import com.company.Board;
import com.company.Main;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board board = new Board();
    Main m = new Main();

    @org.junit.jupiter.api.Test
    void determinePosition() {
        assertEquals(1, board.determinePosition(1, 1));
        assertFalse(board.determinePosition(1, 1) == 9);
        assertEquals(2, board.determinePosition(1, 2));
        assertFalse(board.determinePosition(1, 2) == 8);
        assertEquals(3, board.determinePosition(1, 3));
        assertFalse(board.determinePosition(1, 3) == 7);
        assertEquals(4, board.determinePosition(2, 1));
        assertFalse(board.determinePosition(2, 1) == 5);
        assertEquals(5, board.determinePosition(2, 2));
        assertFalse(board.determinePosition(2, 2) == 6);
        assertEquals(6, board.determinePosition(2, 3));
        assertFalse(board.determinePosition(2, 3) == 4);
        assertEquals(7, board.determinePosition(3, 1));
        assertFalse(board.determinePosition(2, 3) == 5);
        assertEquals(8, board.determinePosition(3, 2));
        assertFalse(board.determinePosition(3, 2) == 6);
        assertEquals(9, board.determinePosition(3, 3));
        assertFalse(board.determinePosition(3, 3) == 4);


        if (m.playerTurn(true) == 'X' && board.determinePosition(1, 1) == 1) {
            assertEquals(' ', board.row1.charAt(1));
        }

        if (m.playerTurn(true) == 'X' && board.determinePosition(1, 2) == 2) {
            assertEquals(' ', board.row1.charAt(5));
        }

        if (m.playerTurn(true) == 'X' && board.determinePosition(1, 3) == 3) {
            assertEquals(' ', board.row1.charAt(9));
        }

        if (m.playerTurn(false) == 'O' && board.determinePosition(2, 1) == 4) {
            assertEquals(' ', board.row1.charAt(1));
        }

        if (m.playerTurn(false) == 'O' && board.determinePosition(2, 2) == 5) {
            assertEquals(' ', board.row1.charAt(5));
        }

    }

    @org.junit.jupiter.api.Test
    void printBoard() {

        assertEquals(board.row1 + "\n" + board.row2 + "\n" + board.row3 + "\n" +
                board.row4 + "\n" + board.row5 + "\n", board.printBoard());

        board.row1 = " X | O | X ";
        board.row2 = "-----------";
        board.row3 = " O | X | O ";
        board.row4 = "-----------";
        board.row5 = " X | O | X ";
        assertEquals(" X | O | X " + "\n" + "-----------" + "\n" + " O | X | O " + "\n" +
                "-----------" + "\n" + " X | O | X " + "\n", board.printBoard());
        assertFalse(" X | X | X " + "\n" + "-----------" + "\n" + " O | O | O " + "\n" +
                "-----------" + "\n" + " X | X | X " + "\n" == board.printBoard());
    }

    @org.junit.jupiter.api.Test
    void printError() {
        assertFalse(board.printError(1, 1) == "This move at (" + 1 + "," + 2 + ") is not valid. Try again...");
        assertFalse(board.printError(1, 2) == "This move at (" + 1 + "," + 3 + ") is not valid. Try again...");
        assertFalse(board.printError(1, 3) == "This move at (" + 1 + "," + 1 + ") is not valid. Try again...");

        assertFalse(board.printError(7, 4) == "This move at (" + 2 + "," + 3 + ") is not valid. Try again...");
        assertFalse(board.printError(1, 5) == "This move at (" + 1 + "," + 1 + ") is not valid. Try again...");
        assertFalse(board.printError(2, 9) == "This move at (" + 2 + "," + 1 + ") is not valid. Try again...");
    }
}
