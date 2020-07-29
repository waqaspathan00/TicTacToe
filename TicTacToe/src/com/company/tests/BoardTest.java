package com.company.tests;

import com.company.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

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
        assertFalse(board.gameWon(board));

        //////////////////////////
        ////////// Rows //////////
        //////////////////////////

        // First row

        board.assignPosition(x, 1);
        assertFalse(board.gameWon(board));
        board.assignPosition(x, 2);
        assertFalse(board.gameWon(board));
        board.assignPosition(x, 3);
        assertTrue(board.gameWon(board));

        board = new Board();

        // Second row

        board.assignPosition(x, 4);
        assertFalse(board.gameWon(board));
        board.assignPosition(x, 5);
        assertFalse(board.gameWon(board));
        board.assignPosition(x, 6);
        assertTrue(board.gameWon(board));

        board = new Board();

        // Third row

        board.assignPosition(x, 7);
        assertFalse(board.gameWon(board));
        board.assignPosition(x, 8);
        assertFalse(board.gameWon(board));
        board.assignPosition(x, 9);
        assertTrue(board.gameWon(board));

        board = new Board();

        // First row

        board.assignPosition(o, 1);
        assertFalse(board.gameWon(board));
        board.assignPosition(o, 2);
        assertFalse(board.gameWon(board));
        board.assignPosition(o, 3);
        assertTrue(board.gameWon(board));

        board = new Board();

        // Second row

        board.assignPosition(o, 4);
        assertFalse(board.gameWon(board));
        board.assignPosition(o, 5);
        assertFalse(board.gameWon(board));
        board.assignPosition(o, 6);
        assertTrue(board.gameWon(board));

        board = new Board();

        // Third row

        board.assignPosition(o, 7);
        assertFalse(board.gameWon(board));
        board.assignPosition(o, 8);
        assertFalse(board.gameWon(board));
        board.assignPosition(o, 9);
        assertTrue(board.gameWon(board));

        board = new Board();


        //////////////////////////
        ////////// Cols //////////
        //////////////////////////

        // First column

        board.assignPosition(x, 1);
        assertFalse(board.gameWon(board));
        board.assignPosition(x, 4);
        assertFalse(board.gameWon(board));
        board.assignPosition(x, 7);
        assertTrue(board.gameWon(board));

        board = new Board();

        // Second column

        board.assignPosition(x, 2);
        assertFalse(board.gameWon(board));
        board.assignPosition(x, 5);
        assertFalse(board.gameWon(board));
        board.assignPosition(x, 8);
        assertTrue(board.gameWon(board));

        board = new Board();

        // Third column

        board.assignPosition(x, 3);
        assertFalse(board.gameWon(board));
        board.assignPosition(x, 6);
        assertFalse(board.gameWon(board));
        board.assignPosition(x, 9);
        assertTrue(board.gameWon(board));

        board = new Board();

        // First column

        board.assignPosition(o, 1);
        assertFalse(board.gameWon(board));
        board.assignPosition(o, 4);
        assertFalse(board.gameWon(board));
        board.assignPosition(o, 7);
        assertTrue(board.gameWon(board));

        board = new Board();

        // Second column

        board.assignPosition(o, 2);
        assertFalse(board.gameWon(board));
        board.assignPosition(o, 5);
        assertFalse(board.gameWon(board));
        board.assignPosition(o, 8);
        assertTrue(board.gameWon(board));

        board = new Board();

        // Third column

        board.assignPosition(o, 3);
        assertFalse(board.gameWon(board));
        board.assignPosition(o, 6);
        assertFalse(board.gameWon(board));
        board.assignPosition(o, 9);
        assertTrue(board.gameWon(board));

        board = new Board();


        //////////////////////////
        ////////// Diag //////////
        //////////////////////////

        // Top left to bottom right

        board.assignPosition(x, 1);
        assertFalse(board.gameWon(board));
        board.assignPosition(x, 5);
        assertFalse(board.gameWon(board));
        board.assignPosition(x, 9);
        assertTrue(board.gameWon(board));

        board = new Board();

        // Top right to bottom left

        board.assignPosition(x, 3);
        assertFalse(board.gameWon(board));
        board.assignPosition(x, 5);
        assertFalse(board.gameWon(board));
        board.assignPosition(x, 7);
        assertTrue(board.gameWon(board));

        board = new Board();

        // Top left to bottom right

        board.assignPosition(o, 1);
        assertFalse(board.gameWon(board));
        board.assignPosition(o, 5);
        assertFalse(board.gameWon(board));
        board.assignPosition(o, 9);
        assertTrue(board.gameWon(board));

        board = new Board();

        // Top right to bottom left

        board.assignPosition(o, 3);
        assertFalse(board.gameWon(board));
        board.assignPosition(o, 5);
        assertFalse(board.gameWon(board));
        board.assignPosition(o, 7);
        assertTrue(board.gameWon(board));

        board = new Board();


        //////////////////////////
        ////////// Full //////////
        //////////////////////////

        board.assignPosition(x, 1);
        board.assignPosition(o, 2);
        board.assignPosition(x, 3);
        assertFalse(board.gameWon(board));
        board.assignPosition(x, 4);
        board.assignPosition(o, 5);
        board.assignPosition(o, 6);
        assertFalse(board.gameWon(board));
        board.assignPosition(o, 7);
        board.assignPosition(x, 8);
        board.assignPosition(x, 9);
        assertFalse(board.gameWon(board));

    }

    @Test
    void testValidatePosition() {

        Board board = new Board();

        assertFalse(board.validatePosition(1));
        board.assignPosition(x, 1);
        assertTrue(board.validatePosition(1));

        assertFalse(board.validatePosition(2));
        board.assignPosition(x, 2);
        assertTrue(board.validatePosition(2));

        assertFalse(board.validatePosition(3));
        board.assignPosition(x, 3);
        assertTrue(board.validatePosition(3));

        assertFalse(board.validatePosition(4));
        board.assignPosition(x, 4);
        assertTrue(board.validatePosition(4));

        assertFalse(board.validatePosition(5));
        board.assignPosition(x, 5);
        assertTrue(board.validatePosition(5));

        assertFalse(board.validatePosition(6));
        board.assignPosition(x, 6);
        assertTrue(board.validatePosition(6));

        assertFalse(board.validatePosition(7));
        board.assignPosition(x, 7);
        assertTrue(board.validatePosition(7));

        assertFalse(board.validatePosition(8));
        board.assignPosition(x, 8);
        assertTrue(board.validatePosition(8));

        assertFalse(board.validatePosition(9));
        board.assignPosition(x, 9);
        assertTrue(board.validatePosition(9));

        board = new Board();

        assertFalse(board.validatePosition(1));
        board.assignPosition(o, 1);
        assertTrue(board.validatePosition(1));

        assertFalse(board.validatePosition(2));
        board.assignPosition(o, 2);
        assertTrue(board.validatePosition(2));

        assertFalse(board.validatePosition(3));
        board.assignPosition(o, 3);
        assertTrue(board.validatePosition(3));

        assertFalse(board.validatePosition(4));
        board.assignPosition(o, 4);
        assertTrue(board.validatePosition(4));

        assertFalse(board.validatePosition(5));
        board.assignPosition(o, 5);
        assertTrue(board.validatePosition(5));

        assertFalse(board.validatePosition(6));
        board.assignPosition(o, 6);
        assertTrue(board.validatePosition(6));

        assertFalse(board.validatePosition(7));
        board.assignPosition(o, 7);
        assertTrue(board.validatePosition(7));

        assertFalse(board.validatePosition(8));
        board.assignPosition(o, 8);
        assertTrue(board.validatePosition(8));

        assertFalse(board.validatePosition(9));
        board.assignPosition(o, 9);
        assertTrue(board.validatePosition(9));

    }
}