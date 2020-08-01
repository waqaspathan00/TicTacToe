package com.company.tests;

import com.company.Board;
import com.company.Main;
import org.junit.jupiter.api.Test;

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

    /*
        1 | 2 | 3
        -----------
        4 | 5 | 6
        -----------
        7 | 8 | 9
        */

    char x = 'X';
    char o = 'O';

    @Test
    void testGameWon() {

        Board board = new Board();
        assertFalse(board.gameWon());

        //////////////////////////
        ////////// Rows //////////
        //////////////////////////

        // First row

        board.assignPosition(x, 1);
        assertFalse(board.gameWon());
        board.assignPosition(x, 2);
        assertFalse(board.gameWon());
        board.assignPosition(x, 3);
        assertTrue(board.gameWon());

        board = new Board();

        // Second row

        board.assignPosition(x, 4);
        assertFalse(board.gameWon());
        board.assignPosition(x, 5);
        assertFalse(board.gameWon());
        board.assignPosition(x, 6);
        assertTrue(board.gameWon());

        board = new Board();

        // Third row

        board.assignPosition(x, 7);
        assertFalse(board.gameWon());
        board.assignPosition(x, 8);
        assertFalse(board.gameWon());
        board.assignPosition(x, 9);
        assertTrue(board.gameWon());

        board = new Board();

        // First row

        board.assignPosition(o, 1);
        assertFalse(board.gameWon());
        board.assignPosition(o, 2);
        assertFalse(board.gameWon());
        board.assignPosition(o, 3);
        assertTrue(board.gameWon());

        board = new Board();

        // Second row

        board.assignPosition(o, 4);
        assertFalse(board.gameWon());
        board.assignPosition(o, 5);
        assertFalse(board.gameWon());
        board.assignPosition(o, 6);
        assertTrue(board.gameWon());

        board = new Board();

        // Third row

        board.assignPosition(o, 7);
        assertFalse(board.gameWon());
        board.assignPosition(o, 8);
        assertFalse(board.gameWon());
        board.assignPosition(o, 9);
        assertTrue(board.gameWon());

        board = new Board();


        //////////////////////////
        ////////// Cols //////////
        //////////////////////////

        // First column

        board.assignPosition(x, 1);
        assertFalse(board.gameWon());
        board.assignPosition(x, 4);
        assertFalse(board.gameWon());
        board.assignPosition(x, 7);
        assertTrue(board.gameWon());

        board = new Board();

        // Second column

        board.assignPosition(x, 2);
        assertFalse(board.gameWon());
        board.assignPosition(x, 5);
        assertFalse(board.gameWon());
        board.assignPosition(x, 8);
        assertTrue(board.gameWon());

        board = new Board();

        // Third column

        board.assignPosition(x, 3);
        assertFalse(board.gameWon());
        board.assignPosition(x, 6);
        assertFalse(board.gameWon());
        board.assignPosition(x, 9);
        assertTrue(board.gameWon());

        board = new Board();

        // First column

        board.assignPosition(o, 1);
        assertFalse(board.gameWon());
        board.assignPosition(o, 4);
        assertFalse(board.gameWon());
        board.assignPosition(o, 7);
        assertTrue(board.gameWon());

        board = new Board();

        // Second column

        board.assignPosition(o, 2);
        assertFalse(board.gameWon());
        board.assignPosition(o, 5);
        assertFalse(board.gameWon());
        board.assignPosition(o, 8);
        assertTrue(board.gameWon());

        board = new Board();

        // Third column

        board.assignPosition(o, 3);
        assertFalse(board.gameWon());
        board.assignPosition(o, 6);
        assertFalse(board.gameWon());
        board.assignPosition(o, 9);
        assertTrue(board.gameWon());

        board = new Board();


        //////////////////////////
        ////////// Diag //////////
        //////////////////////////

        // Top left to bottom right

        board.assignPosition(x, 1);
        assertFalse(board.gameWon());
        board.assignPosition(x, 5);
        assertFalse(board.gameWon());
        board.assignPosition(x, 9);
        assertTrue(board.gameWon());

        board = new Board();

        // Top right to bottom left

        board.assignPosition(x, 3);
        assertFalse(board.gameWon());
        board.assignPosition(x, 5);
        assertFalse(board.gameWon());
        board.assignPosition(x, 7);
        assertTrue(board.gameWon());

        board = new Board();

        // Top left to bottom right

        board.assignPosition(o, 1);
        assertFalse(board.gameWon());
        board.assignPosition(o, 5);
        assertFalse(board.gameWon());
        board.assignPosition(o, 9);
        assertTrue(board.gameWon());

        board = new Board();

        // Top right to bottom left

        board.assignPosition(o, 3);
        assertFalse(board.gameWon());
        board.assignPosition(o, 5);
        assertFalse(board.gameWon());
        board.assignPosition(o, 7);
        assertTrue(board.gameWon());

        board = new Board();


        //////////////////////////
        ////////// Full //////////
        //////////////////////////

        board.assignPosition(x, 1);
        board.assignPosition(o, 2);
        board.assignPosition(x, 3);
        assertFalse(board.gameWon());
        board.assignPosition(x, 4);
        board.assignPosition(o, 5);
        board.assignPosition(o, 6);
        assertFalse(board.gameWon());
        board.assignPosition(o, 7);
        board.assignPosition(x, 8);
        board.assignPosition(x, 9);
        assertFalse(board.gameWon());

        board = new Board();

    }

    @Test
    void testValidatePosition() {

        Board board = new Board();

        board.assignPosition(x, 1);
        assertTrue(board.validatePosition(1));
        board.assignPosition(x, 2);
        assertTrue(board.validatePosition(2));
        board.assignPosition(x, 3);
        assertTrue(board.validatePosition(3));
        board.assignPosition(x, 4);
        assertTrue(board.validatePosition(4));
        board.assignPosition(x, 5);
        assertTrue(board.validatePosition(5));
        board.assignPosition(x, 6);
        assertTrue(board.validatePosition(6));
        board.assignPosition(x, 7);
        assertTrue(board.validatePosition(7));
        board.assignPosition(x, 8);
        assertTrue(board.validatePosition(8));
        board.assignPosition(x, 9);
        assertTrue(board.validatePosition(9));

        board = new Board();

        board.assignPosition(o, 1);
        assertTrue(board.validatePosition(1));
        board.assignPosition(o, 2);
        assertTrue(board.validatePosition(2));
        board.assignPosition(o, 3);
        assertTrue(board.validatePosition(3));
        board.assignPosition(o, 4);
        assertTrue(board.validatePosition(4));
        board.assignPosition(o, 5);
        assertTrue(board.validatePosition(5));
        board.assignPosition(o, 6);
        assertTrue(board.validatePosition(6));
        board.assignPosition(o, 7);
        assertTrue(board.validatePosition(7));
        board.assignPosition(o, 8);
        assertTrue(board.validatePosition(8));
        board.assignPosition(o, 9);
        assertTrue(board.validatePosition(9));

        board = new Board();

    }
}